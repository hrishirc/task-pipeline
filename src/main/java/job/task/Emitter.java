package job.task;

import job.exception.ErrorSignature;
import pipeline.Task;
import util.constants.PipelineConstants;

public abstract class Emitter<I> extends Task<I, I> {
  @Override
  public String getName() {
    return PipelineConstants.EMITTER;
  }

  @Override
  public ErrorSignature getErrorSignature() {
    return ErrorSignature.UNEXPECTED;
  }
}
/*end of InputValidator.java*/
