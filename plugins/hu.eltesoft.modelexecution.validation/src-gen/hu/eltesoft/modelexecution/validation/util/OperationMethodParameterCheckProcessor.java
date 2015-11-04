package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.OperationMethodParameterCheckMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.OperationMethodParameterCheck pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class OperationMethodParameterCheckProcessor implements IMatchProcessor<OperationMethodParameterCheckMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOpParam the value of pattern parameter opParam in the currently processed match
   * @param pMethodParam the value of pattern parameter methodParam in the currently processed match
   * @param pOp the value of pattern parameter op in the currently processed match
   * @param pMethod the value of pattern parameter method in the currently processed match
   * 
   */
  public abstract void process(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod);
  
  @Override
  public void process(final OperationMethodParameterCheckMatch match) {
    process(match.getOpParam(), match.getMethodParam(), match.getOp(), match.getMethod());
  }
}
