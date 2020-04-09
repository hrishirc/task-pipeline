package job.task;

import job.exception.ErrorSignature;
import job.exception.ExpectedException;
import pipeline.Task;
import util.constants.PipelineConstants;

public class EmptyTask<I, O> extends Task<I, O> {

  @Override
  public String getName() {
    return PipelineConstants.EMPTY_TASK;
  }

  @Override
  public O work(I input) {
    O output;
    try {
      output = (O) input;
      log.info("Empty task executed successfully as part of pipeline");
    } catch (ClassCastException e) {
      throw new ExpectedException("");
    }

    return output;
  }

  @Override
  public ErrorSignature getErrorSignature() {
    return ErrorSignature.UNEXPECTED;
  }
}
