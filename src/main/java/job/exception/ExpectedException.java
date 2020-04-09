package job.exception;

import java.util.ArrayList;
import java.util.List;

public class ExpectedException extends RuntimeException {

  private ErrorSignature errorSignature;
  private List<String> details = new ArrayList<>();

  public ExpectedException() {}

  public ExpectedException(String message) {
    super(message);
  }

  public ExpectedException(String message, Throwable cause) {
    super(message, cause);
  }

  public ExpectedException(Throwable cause) {
    super(cause);
  }

  public ExpectedException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ErrorSignature getErrorSignature() {
    return errorSignature;
  }

  public void setErrorSignature(ErrorSignature errorSignature) {
    this.errorSignature = errorSignature;
  }

  public List<String> getDetails() {
    return details;
  }

  public void setDetails(List<String> details) {
    this.details = details;
  }
} /*end of BusinessException.java*/
