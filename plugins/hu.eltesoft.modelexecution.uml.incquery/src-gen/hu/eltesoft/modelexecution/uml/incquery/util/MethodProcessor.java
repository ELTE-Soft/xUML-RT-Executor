package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.MethodMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.Method pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MethodProcessor implements IMatchProcessor<MethodMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pOperation the value of pattern parameter operation in the currently processed match
   * @param pMethod the value of pattern parameter method in the currently processed match
   * @param pMethodName the value of pattern parameter methodName in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Behavior pMethod, final String pMethodName);
  
  @Override
  public void process(final MethodMatch match) {
    process(match.getCls(), match.getOperation(), match.getMethod(), match.getMethodName());
    
  }
}
