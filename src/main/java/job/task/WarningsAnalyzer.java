package job.task;

import job.exception.ErrorSignature;
import pipeline.Task;
import util.constants.PipelineConstants;

public abstract class WarningsAnalyzer<P> extends Task<P, P> {

  @Override
  public String getName() {
    return PipelineConstants.WARNINGS_ANALYZER;
  }

  @Override
  public ErrorSignature getErrorSignature() {
    return ErrorSignature.BUSINESS_LOGIC;
  }
} /*end of WarningsAnalyzer.java*/
