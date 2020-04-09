package pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import job.exception.ErrorSignature;
import job.exception.ExpectedException;
import job.exception.UnexpectedException;

@FunctionalInterface
public interface ExceptionHandler {

  Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

  static ExceptionHandler getDefault() {
    return new ExceptionHandler() {
      @Override
      public <I, O> O execute(Task<I, O> task, Exception ex) {
        log.error(ex.getMessage(), ex);
        if (ex instanceof ExpectedException) {
          ExpectedException ee = (ExpectedException) ex;
          final ErrorSignature errorSignature = task.getErrorSignature();
          if (ee.getErrorSignature() == null) {
            ee.setErrorSignature(errorSignature);
          }
          throw ee;
        } else {
          throw new UnexpectedException(ex, ErrorSignature.UNEXPECTED);
        }
      }
    };
  }

  <I, O> O execute(Task<I, O> task, Exception ex);
} /*end of ExceptionHandler.java*/
