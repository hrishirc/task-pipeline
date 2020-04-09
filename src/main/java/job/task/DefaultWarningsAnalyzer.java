package job.task;

import java.util.ArrayList;
import java.util.List;

import job.contract.Input;
import job.contract.Payload;
import job.exception.ExpectedException;

public class DefaultWarningsAnalyzer<I extends Input, P extends Payload<I>>
    extends WarningsAnalyzer<P> {

  @Override
  public final P work(P payload) {

    if (payload.getInput().isCheckWarnings()) {
      handleWarnings(payload);
    }

    return payload;
  }

  protected void handleWarnings(P payload) {
    List<String> inputWarnings = payload.getInput().getWarnings();
    List<String> payloadWarnings = payload.getWarnings();

    ArrayList<String> allWarnings = new ArrayList<>();
    allWarnings.addAll(inputWarnings);
    allWarnings.addAll(payloadWarnings);

    if (!allWarnings.isEmpty()) {
      final ExpectedException expectedException =
          new ExpectedException(
              "Warnings were observed in this operation. Check 'details' field for more information");
      expectedException.setDetails(allWarnings);
      throw expectedException;
    }
  }
} /*end of WarningsAnalyzer.java*/
