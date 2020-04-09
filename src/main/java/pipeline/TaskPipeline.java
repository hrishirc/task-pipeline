package pipeline;

import job.exception.ExpectedException;

public class TaskPipeline<I, O1> extends AbstractPipeline<I, O1> {

  public TaskPipeline(AbstractPipeline<I, ?> pipeline) {
    super(pipeline);
  }

  public O1 work(Object input) {

    log.info("Starting Execution for Pipeline " + getName() + " for input " + input);

    I transformedInput = null;

    if (input != null) {
      final Task<Object, I> reducer = getReducer((Class<Object>) input.getClass());
      if (reducer != null) {
        try {
          transformedInput = reducer.work(input);
        } catch (Exception ex) {
          getExceptionHandler().execute(reducer, ex);
        }
      } else if (!(getInputClass().isAssignableFrom(input.getClass()))) {
        throw new ExpectedException(
            "Input cannot be accepted as it cannot be converted into " + getInputClass());
      } else transformedInput = (I) input;
    }

    Task currTask = getStartTask();
    Object output = transformedInput;

    while (currTask != null) {
      output = work(output, currTask);
      currTask = currTask.getNextTask();
    }

    log.info("Ending Execution for Pipeline " + getName() + " for input " + input);

    return (O1) output;
  }

  private <IX, OX> OX work(IX input, Task<IX, OX> currTask) {

    log.info("Starting Task " + currTask.getName());

    OX output;
    try {
      output = currTask.work(input);
    } catch (Exception ex) {
      output = getExceptionHandler().execute(currTask, ex);
    }

    log.info("Ending Task " + currTask.getName());

    return output;
  }
} /*end of Pipeline.java*/
