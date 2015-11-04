package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.EventNonPublicQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Event;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.EventNonPublic pattern,
 * to be used in conjunction with {@link EventNonPublicMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EventNonPublicMatcher
 * @see EventNonPublicProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EventNonPublicMatch extends BasePatternMatch {
  private Event fEv;
  
  private static List<String> parameterNames = makeImmutableList("ev");
  
  private EventNonPublicMatch(final Event pEv) {
    this.fEv = pEv;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("ev".equals(parameterName)) return this.fEv;
    return null;
  }
  
  public Event getEv() {
    return this.fEv;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("ev".equals(parameterName) ) {
    	this.fEv = (org.eclipse.uml2.uml.Event) newValue;
    	return true;
    }
    return false;
  }
  
  public void setEv(final Event pEv) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEv = pEv;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.EventNonPublic";
  }
  
  @Override
  public List<String> parameterNames() {
    return EventNonPublicMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fEv};
  }
  
  @Override
  public EventNonPublicMatch toImmutable() {
    return isMutable() ? newMatch(fEv) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"ev\"=" + prettyPrintValue(fEv)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fEv == null) ? 0 : fEv.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EventNonPublicMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EventNonPublicMatch other = (EventNonPublicMatch) obj;
    if (fEv == null) {if (other.fEv != null) return false;}
    else if (!fEv.equals(other.fEv)) return false;
    return true;
  }
  
  @Override
  public EventNonPublicQuerySpecification specification() {
    try {
    	return EventNonPublicQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static EventNonPublicMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static EventNonPublicMatch newMutableMatch(final Event pEv) {
    return new Mutable(pEv);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static EventNonPublicMatch newMatch(final Event pEv) {
    return new Immutable(pEv);
  }
  
  private static final class Mutable extends EventNonPublicMatch {
    Mutable(final Event pEv) {
      super(pEv);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends EventNonPublicMatch {
    Immutable(final Event pEv) {
      super(pEv);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
