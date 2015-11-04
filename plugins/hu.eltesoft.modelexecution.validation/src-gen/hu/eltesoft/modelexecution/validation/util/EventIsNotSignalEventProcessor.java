package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.EventIsNotSignalEventMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Event;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.EventIsNotSignalEvent pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EventIsNotSignalEventProcessor implements IMatchProcessor<EventIsNotSignalEventMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEv the value of pattern parameter ev in the currently processed match
   * 
   */
  public abstract void process(final Event pEv);
  
  @Override
  public void process(final EventIsNotSignalEventMatch match) {
    process(match.getEv());
  }
}
