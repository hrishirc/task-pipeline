package job.impl.sample;

import job.task.Worker;

class SamplePayloadWorker extends Worker<SamplePayload> {
  @Override
  public SamplePayload work(SamplePayload input) {
    return null;
  }
}
