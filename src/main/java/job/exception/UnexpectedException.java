package job.exception;

import java.util.ArrayList;
import java.util.List;

public class UnexpectedException extends RuntimeException {

  private ErrorSignature errorSignature;
  private List<String> details = new ArrayList<>();

  public UnexpectedException(Throwable cause, ErrorSignature errorSignature) {
    super(cause);
    this.errorSignature = errorSignature;
  }
} /*end of WrapperException.java*/
