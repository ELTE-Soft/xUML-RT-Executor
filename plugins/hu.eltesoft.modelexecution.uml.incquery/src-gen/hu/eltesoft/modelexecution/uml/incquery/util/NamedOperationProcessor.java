package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.NamedOperationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.NamedOperation pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NamedOperationProcessor implements IMatchProcessor<NamedOperationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pOperation the value of pattern parameter operation in the currently processed match
   * @param pName the value of pattern parameter name in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final String pName);
  
  @Override
  public void process(final NamedOperationMatch match) {
    process(match.getCls(), match.getOperation(), match.getName());
    
  }
}
