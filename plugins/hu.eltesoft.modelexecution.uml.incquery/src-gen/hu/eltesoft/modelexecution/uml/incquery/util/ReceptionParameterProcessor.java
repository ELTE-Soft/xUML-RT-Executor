package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Reception;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.ReceptionParameter pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionParameterProcessor implements IMatchProcessor<ReceptionParameterMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pReception the value of pattern parameter reception in the currently processed match
   * @param pParameter the value of pattern parameter parameter in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter);
  
  @Override
  public void process(final ReceptionParameterMatch match) {
    process(match.getCls(), match.getReception(), match.getParameter());
    
  }
}
