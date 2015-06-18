package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Type;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.OperationReturnType pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class OperationReturnTypeProcessor implements IMatchProcessor<OperationReturnTypeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pOperation the value of pattern parameter operation in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * @param pOrdered the value of pattern parameter ordered in the currently processed match
   * @param pUnique the value of pattern parameter unique in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final Boolean pOrdered, final Boolean pUnique);
  
  @Override
  public void process(final OperationReturnTypeMatch match) {
    process(match.getCls(), match.getOperation(), match.getType(), match.getOrdered(), match.getUnique());
    
  }
}
