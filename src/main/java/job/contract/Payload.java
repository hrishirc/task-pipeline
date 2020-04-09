package job.contract;

import java.util.List;

public abstract class Payload<I> {
  private List<String> warnings;
  private I input;

  public List<String> getWarnings() {
    return warnings;
  }

  public void setWarnings(List<String> warnings) {
    this.warnings = warnings;
  }

  public I getInput() {
    return input;
  }

  public void setInput(I input) {
    this.input = input;
  }
} /*end of Data.java*/
