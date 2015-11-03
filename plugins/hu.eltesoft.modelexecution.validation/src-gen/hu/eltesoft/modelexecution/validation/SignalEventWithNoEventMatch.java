package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.SignalEventWithNoEventQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.SignalEventWithNoEvent pattern,
 * to be used in conjunction with {@link SignalEventWithNoEventMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SignalEventWithNoEventMatcher
 * @see SignalEventWithNoEventProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SignalEventWithNoEventMatch extends BasePatternMatch {
  private SignalEvent fEv;
  
  private static List<String> parameterNames = makeImmutableList("ev");
  
  private SignalEventWithNoEventMatch(final SignalEvent pEv) {
    this.fEv = pEv;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("ev".equals(parameterName)) return this.fEv;
    return null;
  }
  
  public SignalEvent getEv() {
    return this.fEv;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("ev".equals(parameterName) ) {
    	this.fEv = (org.eclipse.uml2.uml.SignalEvent) newValue;
    	return true;
    }
    return false;
  }
  
  public void setEv(final SignalEvent pEv) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEv = pEv;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.SignalEventWithNoEvent";
  }
  
  @Override
  public List<String> parameterNames() {
    return SignalEventWithNoEventMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fEv};
  }
  
  @Override
  public SignalEventWithNoEventMatch toImmutable() {
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
    if (!(obj instanceof SignalEventWithNoEventMatch)) { // this should be infrequent
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
    SignalEventWithNoEventMatch other = (SignalEventWithNoEventMatch) obj;
    if (fEv == null) {if (other.fEv != null) return false;}
    else if (!fEv.equals(other.fEv)) return false;
    return true;
  }
  
  @Override
  public SignalEventWithNoEventQuerySpecification specification() {
    try {
    	return SignalEventWithNoEventQuerySpecification.instance();
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
  public static SignalEventWithNoEventMatch newEmptyMatch() {
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
  public static SignalEventWithNoEventMatch newMutableMatch(final SignalEvent pEv) {
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
  public static SignalEventWithNoEventMatch newMatch(final SignalEvent pEv) {
    return new Immutable(pEv);
  }
  
  private static final class Mutable extends SignalEventWithNoEventMatch {
    Mutable(final SignalEvent pEv) {
      super(pEv);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SignalEventWithNoEventMatch {
    Immutable(final SignalEvent pEv) {
      super(pEv);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
