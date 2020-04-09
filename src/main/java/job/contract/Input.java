package job.contract;

import java.util.List;

public abstract class Input {
  private List<String> warnings;
  private boolean checkWarnings = false;

  public List<String> getWarnings() {
    return warnings;
  }

  public void setWarnings(List<String> warnings) {
    this.warnings = warnings;
  }

  public boolean isCheckWarnings() {
    return checkWarnings;
  }

  public void setCheckWarnings(boolean checkWarnings) {
    this.checkWarnings = checkWarnings;
  }
} /*end of Request.java*/
