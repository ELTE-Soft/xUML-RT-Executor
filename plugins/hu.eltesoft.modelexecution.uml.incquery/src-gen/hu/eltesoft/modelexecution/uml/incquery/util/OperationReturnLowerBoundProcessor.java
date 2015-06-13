package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.OperationReturnLowerBoundMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.OperationReturnLowerBound pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class OperationReturnLowerBoundProcessor implements IMatchProcessor<OperationReturnLowerBoundMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pOperation the value of pattern parameter operation in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * @param pLowerBound the value of pattern parameter lowerBound in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final ValueSpecification pLowerBound);
  
  @Override
  public void process(final OperationReturnLowerBoundMatch match) {
    process(match.getCls(), match.getOperation(), match.getType(), match.getLowerBound());
    
  }
}
