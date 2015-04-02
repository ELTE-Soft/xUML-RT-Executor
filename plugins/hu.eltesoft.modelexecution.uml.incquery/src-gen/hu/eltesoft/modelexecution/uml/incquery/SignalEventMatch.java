package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.SignalEventQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.SignalEvent pattern,
 * to be used in conjunction with {@link SignalEventMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SignalEventMatcher
 * @see SignalEventProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SignalEventMatch extends BasePatternMatch {
  private SignalEvent fEvent;
  
  private String fSignalName;
  
  private static List<String> parameterNames = makeImmutableList("event", "signalName");
  
  private SignalEventMatch(final SignalEvent pEvent, final String pSignalName) {
    this.fEvent = pEvent;
    this.fSignalName = pSignalName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("event".equals(parameterName)) return this.fEvent;
    if ("signalName".equals(parameterName)) return this.fSignalName;
    return null;
    
  }
  
  public SignalEvent getEvent() {
    return this.fEvent;
    
  }
  
  public String getSignalName() {
    return this.fSignalName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("event".equals(parameterName) ) {
    	this.fEvent = (org.eclipse.uml2.uml.SignalEvent) newValue;
    	return true;
    }
    if ("signalName".equals(parameterName) ) {
    	this.fSignalName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setEvent(final SignalEvent pEvent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEvent = pEvent;
    
  }
  
  public void setSignalName(final String pSignalName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignalName = pSignalName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.SignalEvent";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return SignalEventMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fEvent, fSignalName};
    
  }
  
  @Override
  public SignalEventMatch toImmutable() {
    return isMutable() ? newMatch(fEvent, fSignalName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"event\"=" + prettyPrintValue(fEvent) + ", ");
    result.append("\"signalName\"=" + prettyPrintValue(fSignalName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fEvent == null) ? 0 : fEvent.hashCode());
    result = prime * result + ((fSignalName == null) ? 0 : fSignalName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SignalEventMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SignalEventMatch other = (SignalEventMatch) obj;
    if (fEvent == null) {if (other.fEvent != null) return false;}
    else if (!fEvent.equals(other.fEvent)) return false;
    if (fSignalName == null) {if (other.fSignalName != null) return false;}
    else if (!fSignalName.equals(other.fSignalName)) return false;
    return true;
  }
  
  @Override
  public SignalEventQuerySpecification specification() {
    try {
    	return SignalEventQuerySpecification.instance();
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
  public static SignalEventMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pSignalName the fixed value of pattern parameter signalName, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SignalEventMatch newMutableMatch(final SignalEvent pEvent, final String pSignalName) {
    return new Mutable(pEvent, pSignalName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pSignalName the fixed value of pattern parameter signalName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SignalEventMatch newMatch(final SignalEvent pEvent, final String pSignalName) {
    return new Immutable(pEvent, pSignalName);
    
  }
  
  private static final class Mutable extends SignalEventMatch {
    Mutable(final SignalEvent pEvent, final String pSignalName) {
      super(pEvent, pSignalName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SignalEventMatch {
    Immutable(final SignalEvent pEvent, final String pSignalName) {
      super(pEvent, pSignalName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
