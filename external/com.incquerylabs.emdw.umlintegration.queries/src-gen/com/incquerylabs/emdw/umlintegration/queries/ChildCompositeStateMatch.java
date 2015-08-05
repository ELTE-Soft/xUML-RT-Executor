package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.ChildCompositeStateQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.State;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.childCompositeState pattern,
 * to be used in conjunction with {@link ChildCompositeStateMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ChildCompositeStateMatcher
 * @see ChildCompositeStateProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ChildCompositeStateMatch extends BasePatternMatch {
  private State fParentState;
  
  private State fState;
  
  private static List<String> parameterNames = makeImmutableList("parentState", "state");
  
  private ChildCompositeStateMatch(final State pParentState, final State pState) {
    this.fParentState = pParentState;
    this.fState = pState;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("parentState".equals(parameterName)) return this.fParentState;
    if ("state".equals(parameterName)) return this.fState;
    return null;
  }
  
  public State getParentState() {
    return this.fParentState;
  }
  
  public State getState() {
    return this.fState;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("parentState".equals(parameterName) ) {
    	this.fParentState = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    if ("state".equals(parameterName) ) {
    	this.fState = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    return false;
  }
  
  public void setParentState(final State pParentState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParentState = pParentState;
  }
  
  public void setState(final State pState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fState = pState;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.childCompositeState";
  }
  
  @Override
  public List<String> parameterNames() {
    return ChildCompositeStateMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fParentState, fState};
  }
  
  @Override
  public ChildCompositeStateMatch toImmutable() {
    return isMutable() ? newMatch(fParentState, fState) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"parentState\"=" + prettyPrintValue(fParentState) + ", ");
    
    result.append("\"state\"=" + prettyPrintValue(fState)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fParentState == null) ? 0 : fParentState.hashCode());
    result = prime * result + ((fState == null) ? 0 : fState.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ChildCompositeStateMatch)) { // this should be infrequent
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
    ChildCompositeStateMatch other = (ChildCompositeStateMatch) obj;
    if (fParentState == null) {if (other.fParentState != null) return false;}
    else if (!fParentState.equals(other.fParentState)) return false;
    if (fState == null) {if (other.fState != null) return false;}
    else if (!fState.equals(other.fState)) return false;
    return true;
  }
  
  @Override
  public ChildCompositeStateQuerySpecification specification() {
    try {
    	return ChildCompositeStateQuerySpecification.instance();
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
  public static ChildCompositeStateMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pParentState the fixed value of pattern parameter parentState, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ChildCompositeStateMatch newMutableMatch(final State pParentState, final State pState) {
    return new Mutable(pParentState, pState);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParentState the fixed value of pattern parameter parentState, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ChildCompositeStateMatch newMatch(final State pParentState, final State pState) {
    return new Immutable(pParentState, pState);
  }
  
  private static final class Mutable extends ChildCompositeStateMatch {
    Mutable(final State pParentState, final State pState) {
      super(pParentState, pState);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ChildCompositeStateMatch {
    Immutable(final State pParentState, final State pState) {
      super(pParentState, pState);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
