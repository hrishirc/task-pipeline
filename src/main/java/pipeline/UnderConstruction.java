package pipeline;

import java.text.MessageFormat;
import java.util.Map;

import job.task.EmptyTask;

public class UnderConstruction<I, O> extends AbstractPipeline<I, O> {
  private Task<?, O> latestTask;

  public UnderConstruction() {}

  private <OZ> UnderConstruction(UnderConstruction<I, OZ> prevProgress, Task<OZ, O> latestTask) {
    super(prevProgress);
    this.latestTask = latestTask;
  }

  public UnderConstruction<I, O> with(Map<Class, Task<Object, I>> reducers) {
    reducers.forEach(this::add);
    return this;
  }

  public <IZ> UnderConstruction<I, O> add(Class<IZ> rawInputClass, Task<IZ, I> reducer) {
    if (getReducer(rawInputClass) != null) {
      log.warn(
          MessageFormat.format(
              "Reducer already exists for conversion of input of type : {0} into {1}. This will be overriden",
              rawInputClass, getInputClass()));
    }

    addReducer(rawInputClass, reducer);
    return this;
  }

  public <O1> UnderConstruction<I, O1> attach(Task<O, O1> latestTask) {

    log.info("Started Attaching task " + latestTask.getName());

    if (latestTask == null) {

      log.warn(
          "No task has been passed. If input and output of task are of different signatures, pipeline execution will fail during execution!!!");

      latestTask = new EmptyTask<>();
    }

    if (getStartTask() == null) {
      setStartTask((Task<I, ?>) latestTask);
    }

    if (this.latestTask != null) {
      this.latestTask.setNextTask(latestTask);
    } else {
      this.latestTask = (Task<?, O>) latestTask;
    }

    log.info("Finished attaching task " + latestTask.getName());

    return new UnderConstruction<>(this, latestTask);
  }

  public void setExceptionHandler(ExceptionHandler exceptionHandler) {
    if (getExceptionHandler() != null) {
      log.warn(
          "Exception Handler already defined for pipeline. This message usually indicates an unintended duplicate call in code.");
    }

    super.setExceptionHandler(exceptionHandler);
  }

  public TaskPipeline<I, O> finish() {
    return new TaskPipeline<>(this);
  }
}
