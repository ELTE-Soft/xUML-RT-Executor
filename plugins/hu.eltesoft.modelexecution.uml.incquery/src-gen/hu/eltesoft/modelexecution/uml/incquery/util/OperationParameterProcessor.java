package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.OperationParameter pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class OperationParameterProcessor implements IMatchProcessor<OperationParameterMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pOperation the value of pattern parameter operation in the currently processed match
   * @param pParameter the value of pattern parameter parameter in the currently processed match
   * @param pDirection the value of pattern parameter direction in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final ParameterDirectionKind pDirection);
  
  @Override
  public void process(final OperationParameterMatch match) {
    process(match.getCls(), match.getOperation(), match.getParameter(), match.getDirection());
    
  }
}
