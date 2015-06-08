package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.OperationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.Operation pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class OperationProcessor implements IMatchProcessor<OperationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pOperation the value of pattern parameter operation in the currently processed match
   * @param pIsStatic the value of pattern parameter isStatic in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Boolean pIsStatic);
  
  @Override
  public void process(final OperationMatch match) {
    process(match.getCls(), match.getOperation(), match.getIsStatic());
    
  }
}
