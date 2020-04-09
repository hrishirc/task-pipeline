package job;

import job.contract.Input;
import job.contract.Output;
import job.contract.Payload;
import job.task.InputValidator;
import job.task.OutputMaker;

public abstract class SilentJob<P extends Payload<SilentJob.NullInput>>
    extends Job<SilentJob.NullInput, P, SilentJob.NullOutput> {

  @Override
  protected final InputValidator<NullInput> getInputValidator() {
    return null;
  }

  @Override
  protected final OutputMaker<P, NullOutput> getOutputMaker() {
    return null;
  }

  static class NullInput extends Input {}

  static class NullOutput extends Output {}
} /*end of TriggeredJOb.java*/
