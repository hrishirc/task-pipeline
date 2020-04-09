import job.impl.sample.SampleInput;
import job.impl.sample.SampleJobImpl;

public class Main {
  public static void main(String[] args) {

    System.setProperty("org.slf4j.simpleLogger.logFile", "System.out");
    final SampleJobImpl sampleJob = new SampleJobImpl();
    sampleJob.work(new SampleInput());
    //
  }
} /*end of Main.java*/
