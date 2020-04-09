package job.task;

import job.exception.ErrorSignature;
import pipeline.Task;
import util.constants.PipelineConstants;

public abstract class OutputMaker<I, O> extends Task<I, O> {
  @Override
  public String getName() {
    return PipelineConstants.OUTPUT_MAKER;
  }

  @Override
  public ErrorSignature getErrorSignature() {
    return ErrorSignature.UNEXPECTED;
  }
}
/*end of InputValidator.java*/
