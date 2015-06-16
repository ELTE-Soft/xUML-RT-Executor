package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterUpperBoundMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterUpperBound pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionParameterUpperBoundProcessor implements IMatchProcessor<ReceptionParameterUpperBoundMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pReception the value of pattern parameter reception in the currently processed match
   * @param pParameter the value of pattern parameter parameter in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * @param pUpperBound the value of pattern parameter upperBound in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final ValueSpecification pUpperBound);
  
  @Override
  public void process(final ReceptionParameterUpperBoundMatch match) {
    process(match.getCls(), match.getReception(), match.getParameter(), match.getType(), match.getUpperBound());
    
  }
}
