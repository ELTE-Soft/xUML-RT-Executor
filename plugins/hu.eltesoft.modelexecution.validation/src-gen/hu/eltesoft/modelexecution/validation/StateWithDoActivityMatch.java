package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.StateWithDoActivityQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.State;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.StateWithDoActivity pattern,
 * to be used in conjunction with {@link StateWithDoActivityMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StateWithDoActivityMatcher
 * @see StateWithDoActivityProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StateWithDoActivityMatch extends BasePatternMatch {
  private State fSt;
  
  private static List<String> parameterNames = makeImmutableList("st");
  
  private StateWithDoActivityMatch(final State pSt) {
    this.fSt = pSt;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("st".equals(parameterName)) return this.fSt;
    return null;
  }
  
  public State getSt() {
    return this.fSt;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("st".equals(parameterName) ) {
    	this.fSt = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSt(final State pSt) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSt = pSt;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.StateWithDoActivity";
  }
  
  @Override
  public List<String> parameterNames() {
    return StateWithDoActivityMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSt};
  }
  
  @Override
  public StateWithDoActivityMatch toImmutable() {
    return isMutable() ? newMatch(fSt) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"st\"=" + prettyPrintValue(fSt)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSt == null) ? 0 : fSt.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StateWithDoActivityMatch)) { // this should be infrequent
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
    StateWithDoActivityMatch other = (StateWithDoActivityMatch) obj;
    if (fSt == null) {if (other.fSt != null) return false;}
    else if (!fSt.equals(other.fSt)) return false;
    return true;
  }
  
  @Override
  public StateWithDoActivityQuerySpecification specification() {
    try {
    	return StateWithDoActivityQuerySpecification.instance();
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
  public static StateWithDoActivityMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSt the fixed value of pattern parameter st, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StateWithDoActivityMatch newMutableMatch(final State pSt) {
    return new Mutable(pSt);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSt the fixed value of pattern parameter st, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static StateWithDoActivityMatch newMatch(final State pSt) {
    return new Immutable(pSt);
  }
  
  private static final class Mutable extends StateWithDoActivityMatch {
    Mutable(final State pSt) {
      super(pSt);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StateWithDoActivityMatch {
    Immutable(final State pSt) {
      super(pSt);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
