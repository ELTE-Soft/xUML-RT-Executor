package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.EventMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.Event pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EventProcessor implements IMatchProcessor<EventMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEvent the value of pattern parameter event in the currently processed match
   * @param pEventName the value of pattern parameter eventName in the currently processed match
   * 
   */
  public abstract void process(final SignalEvent pEvent, final String pEventName);
  
  @Override
  public void process(final EventMatch match) {
    process(match.getEvent(), match.getEventName());
    
  }
}
