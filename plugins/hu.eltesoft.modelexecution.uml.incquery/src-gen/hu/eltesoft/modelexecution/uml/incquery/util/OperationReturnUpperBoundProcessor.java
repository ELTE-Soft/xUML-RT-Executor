package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBoundMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBound pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class OperationReturnUpperBoundProcessor implements IMatchProcessor<OperationReturnUpperBoundMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pOperation the value of pattern parameter operation in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * @param pUpperBound the value of pattern parameter upperBound in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final ValueSpecification pUpperBound);
  
  @Override
  public void process(final OperationReturnUpperBoundMatch match) {
    process(match.getCls(), match.getOperation(), match.getType(), match.getUpperBound());
    
  }
}