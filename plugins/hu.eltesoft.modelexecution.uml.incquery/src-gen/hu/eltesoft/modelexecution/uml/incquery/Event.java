package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.EventMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.EventQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalEventQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in event.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file event.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.uml.incquery, the group contains the definition of the following patterns: <ul>
 * <li>Event</li>
 * <li>SignalEvent</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Event extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Event instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Event();
    }
    return INSTANCE;
    
  }
  
  private static Event INSTANCE;
  
  private Event() throws IncQueryException {
    querySpecifications.add(EventQuerySpecification.instance());
    querySpecifications.add(SignalEventQuerySpecification.instance());
    
  }
  
  public EventQuerySpecification getEvent() throws IncQueryException {
    return EventQuerySpecification.instance();
  }
  
  public EventMatcher getEvent(final IncQueryEngine engine) throws IncQueryException {
    return EventMatcher.on(engine);
  }
  
  public SignalEventQuerySpecification getSignalEvent() throws IncQueryException {
    return SignalEventQuerySpecification.instance();
  }
  
  public SignalEventMatcher getSignalEvent(final IncQueryEngine engine) throws IncQueryException {
    return SignalEventMatcher.on(engine);
  }
}
