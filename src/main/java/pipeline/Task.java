package pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import job.exception.ErrorSignature;

public abstract class Task<I, O> {
  protected Logger log = LoggerFactory.getLogger(getClass());

  private Task<O, ?> nextTask;

  public Task<O, ?> getNextTask() {
    return nextTask;
  }

  public void setNextTask(Task<O, ?> nextTask) {
    if (this.nextTask == null) {
      this.nextTask = nextTask;
    } else {
      throw new RuntimeException("Pipeline cannot be modified once created");
    }
  }

  public abstract String getName();

  public abstract O work(I input);

  public O doOnException() {
    return null;
  }

  public abstract ErrorSignature getErrorSignature();

  public String toString() {
    return "Task : " + getName();
  }
} /*end of PipelineStep.java*/
