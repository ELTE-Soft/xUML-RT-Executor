package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.SignalEvent pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SignalEventProcessor implements IMatchProcessor<SignalEventMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEvent the value of pattern parameter event in the currently processed match
   * @param pSignal the value of pattern parameter signal in the currently processed match
   * 
   */
  public abstract void process(final SignalEvent pEvent, final Signal pSignal);
  
  @Override
  public void process(final SignalEventMatch match) {
    process(match.getEvent(), match.getSignal());
    
  }
}
