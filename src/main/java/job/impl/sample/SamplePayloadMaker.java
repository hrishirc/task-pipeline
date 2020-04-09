package job.impl.sample;

import job.task.PayloadMaker;

class SamplePayloadMaker extends PayloadMaker<SampleInput, SamplePayload> {
  @Override
  protected SamplePayload getPayload(SampleInput input) {
    return new SamplePayload();
  }
}
