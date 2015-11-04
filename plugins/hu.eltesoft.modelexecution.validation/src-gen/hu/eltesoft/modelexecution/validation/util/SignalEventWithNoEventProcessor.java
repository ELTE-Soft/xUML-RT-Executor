package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.SignalEventWithNoEventMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.SignalEventWithNoEvent pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SignalEventWithNoEventProcessor implements IMatchProcessor<SignalEventWithNoEventMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEv the value of pattern parameter ev in the currently processed match
   * 
   */
  public abstract void process(final SignalEvent pEv);
  
  @Override
  public void process(final SignalEventWithNoEventMatch match) {
    process(match.getEv());
  }
}
