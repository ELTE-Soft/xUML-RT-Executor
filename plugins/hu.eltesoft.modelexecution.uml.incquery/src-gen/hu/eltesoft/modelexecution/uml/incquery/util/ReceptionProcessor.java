package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.Reception pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionProcessor implements IMatchProcessor<ReceptionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pReceptionName the value of pattern parameter receptionName in the currently processed match
   * @param pSignalName the value of pattern parameter signalName in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final String pReceptionName, final String pSignalName);
  
  @Override
  public void process(final ReceptionMatch match) {
    process(match.getCls(), match.getReceptionName(), match.getSignalName());
    
  }
}
