package job.task;

import job.exception.ErrorSignature;
import pipeline.Task;
import util.constants.PipelineConstants;

public abstract class Worker<P> extends Task<P, P> {
  @Override
  public String getName() {
    return PipelineConstants.WORKER;
  }

  @Override
  public ErrorSignature getErrorSignature() {
    return ErrorSignature.UNEXPECTED;
  }
}
/*end of InputValidator.java*/
