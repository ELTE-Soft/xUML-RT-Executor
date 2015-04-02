package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.EventQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Event pattern,
 * to be used in conjunction with {@link EventMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EventMatcher
 * @see EventProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EventMatch extends BasePatternMatch {
  private SignalEvent fEvent;
  
  private String fEventName;
  
  private static List<String> parameterNames = makeImmutableList("event", "eventName");
  
  private EventMatch(final SignalEvent pEvent, final String pEventName) {
    this.fEvent = pEvent;
    this.fEventName = pEventName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("event".equals(parameterName)) return this.fEvent;
    if ("eventName".equals(parameterName)) return this.fEventName;
    return null;
    
  }
  
  public SignalEvent getEvent() {
    return this.fEvent;
    
  }
  
  public String getEventName() {
    return this.fEventName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("event".equals(parameterName) ) {
    	this.fEvent = (org.eclipse.uml2.uml.SignalEvent) newValue;
    	return true;
    }
    if ("eventName".equals(parameterName) ) {
    	this.fEventName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setEvent(final SignalEvent pEvent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEvent = pEvent;
    
  }
  
  public void setEventName(final String pEventName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEventName = pEventName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Event";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return EventMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fEvent, fEventName};
    
  }
  
  @Override
  public EventMatch toImmutable() {
    return isMutable() ? newMatch(fEvent, fEventName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"event\"=" + prettyPrintValue(fEvent) + ", ");
    result.append("\"eventName\"=" + prettyPrintValue(fEventName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fEvent == null) ? 0 : fEvent.hashCode());
    result = prime * result + ((fEventName == null) ? 0 : fEventName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EventMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EventMatch other = (EventMatch) obj;
    if (fEvent == null) {if (other.fEvent != null) return false;}
    else if (!fEvent.equals(other.fEvent)) return false;
    if (fEventName == null) {if (other.fEventName != null) return false;}
    else if (!fEventName.equals(other.fEventName)) return false;
    return true;
  }
  
  @Override
  public EventQuerySpecification specification() {
    try {
    	return EventQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static EventMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pEventName the fixed value of pattern parameter eventName, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static EventMatch newMutableMatch(final SignalEvent pEvent, final String pEventName) {
    return new Mutable(pEvent, pEventName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pEventName the fixed value of pattern parameter eventName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static EventMatch newMatch(final SignalEvent pEvent, final String pEventName) {
    return new Immutable(pEvent, pEventName);
    
  }
  
  private static final class Mutable extends EventMatch {
    Mutable(final SignalEvent pEvent, final String pEventName) {
      super(pEvent, pEventName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends EventMatch {
    Immutable(final SignalEvent pEvent, final String pEventName) {
      super(pEvent, pEventName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
