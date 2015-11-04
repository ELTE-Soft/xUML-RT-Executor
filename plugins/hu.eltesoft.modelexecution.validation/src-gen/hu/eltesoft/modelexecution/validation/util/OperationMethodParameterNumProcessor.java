package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.OperationMethodParameterNumMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.OperationMethodParameterNum pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class OperationMethodParameterNumProcessor implements IMatchProcessor<OperationMethodParameterNumMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOp the value of pattern parameter op in the currently processed match
   * @param pMethod the value of pattern parameter method in the currently processed match
   * @param pOpParams the value of pattern parameter opParams in the currently processed match
   * @param pMethodParams the value of pattern parameter methodParams in the currently processed match
   * 
   */
  public abstract void process(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams);
  
  @Override
  public void process(final OperationMethodParameterNumMatch match) {
    process(match.getOp(), match.getMethod(), match.getOpParams(), match.getMethodParams());
  }
}
