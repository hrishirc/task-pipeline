package job.task;

import job.contract.Input;
import job.contract.Payload;
import job.exception.ErrorSignature;
import pipeline.Task;
import util.constants.PipelineConstants;

public abstract class PayloadMaker<I extends Input, O extends Payload<I>> extends Task<I, O> {

  @Override
  public String getName() {
    return PipelineConstants.PAYLOAD_MAKER;
  }

  @Override
  public O work(I input) {
    final O payload = getPayload(input);
    payload.setInput(input);
    return payload;
  }

  protected abstract O getPayload(I input);

  @Override
  public ErrorSignature getErrorSignature() {
    return ErrorSignature.UNEXPECTED;
  }
}
/*end of InputValidator.java*/
