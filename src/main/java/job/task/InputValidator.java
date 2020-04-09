package job.task;

import job.exception.ErrorSignature;
import pipeline.Task;
import util.constants.PipelineConstants;

public abstract class InputValidator<I> extends Task<I, I> {
  @Override
  public String getName() {
    return PipelineConstants.INPUT_VALIDATOR;
  }

  @Override
  public ErrorSignature getErrorSignature() {
    return ErrorSignature.BAD_INPUT;
  }
}
/*end of InputValidator.java*/
