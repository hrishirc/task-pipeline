package job.impl.sample;

import job.Job;
import job.task.Emitter;
import job.task.InputValidator;
import job.task.OutputMaker;
import job.task.PayloadMaker;
import job.task.PayloadValidator;
import job.task.Worker;

public class SampleJobImpl extends Job<SampleInput, SamplePayload, SampleOutput> {

  @Override
  protected InputValidator<SampleInput> getInputValidator() {
    return new InputValidator<SampleInput>() {
      @Override
      public SampleInput work(SampleInput input) {
        return input;
      }
    };
  }

  @Override
  protected PayloadMaker<SampleInput, SamplePayload> getPayloadMaker() {
    return new SamplePayloadMaker();
  }

  @Override
  protected PayloadValidator<SamplePayload> getPayloadValidator() {
    return new PayloadValidator<SamplePayload>() {
      @Override
      public SamplePayload work(SamplePayload input) {
        return input;
      }
    };
  }

  @Override
  protected Worker<SamplePayload> getWorker() {
    return new SamplePayloadWorker();
  }

  @Override
  protected Emitter<SamplePayload> getEmitter() {
    return new Emitter<SamplePayload>() {
      @Override
      public SamplePayload work(SamplePayload input) {
        return input;
      }
    };
  }

  @Override
  protected OutputMaker<SamplePayload, SampleOutput> getOutputMaker() {
    return new SampleOutputMaker();
  }
} /*end of SampleJobImpl.java*/
