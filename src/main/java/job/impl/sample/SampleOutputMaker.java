package job.impl.sample;

import job.task.OutputMaker;

class SampleOutputMaker extends OutputMaker<SamplePayload, SampleOutput> {
  @Override
  public SampleOutput work(SamplePayload input) {
    return null;
  }
}
