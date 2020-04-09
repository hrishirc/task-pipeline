package job.task;

import job.exception.ErrorSignature;
import pipeline.Task;
import util.constants.PipelineConstants;

public abstract class PayloadValidator<P> extends Task<P, P> {
  @Override
  public String getName() {
    return PipelineConstants.PAYLOAD_VALIDATOR;
  }

  @Override
  public ErrorSignature getErrorSignature() {
    return ErrorSignature.BUSINESS_LOGIC;
  }
}
/*end of InputValidator.java*/
