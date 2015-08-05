package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.StateExitBehaviorQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.State;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.stateExitBehavior pattern,
 * to be used in conjunction with {@link StateExitBehaviorMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StateExitBehaviorMatcher
 * @see StateExitBehaviorProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StateExitBehaviorMatch extends BasePatternMatch {
  private State fState;
  
  private Behavior fExit;
  
  private static List<String> parameterNames = makeImmutableList("state", "exit");
  
  private StateExitBehaviorMatch(final State pState, final Behavior pExit) {
    this.fState = pState;
    this.fExit = pExit;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("state".equals(parameterName)) return this.fState;
    if ("exit".equals(parameterName)) return this.fExit;
    return null;
  }
  
  public State getState() {
    return this.fState;
  }
  
  public Behavior getExit() {
    return this.fExit;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("state".equals(parameterName) ) {
    	this.fState = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    if ("exit".equals(parameterName) ) {
    	this.fExit = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    return false;
  }
  
  public void setState(final State pState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fState = pState;
  }
  
  public void setExit(final Behavior pExit) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fExit = pExit;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.stateExitBehavior";
  }
  
  @Override
  public List<String> parameterNames() {
    return StateExitBehaviorMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fState, fExit};
  }
  
  @Override
  public StateExitBehaviorMatch toImmutable() {
    return isMutable() ? newMatch(fState, fExit) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"state\"=" + prettyPrintValue(fState) + ", ");
    
    result.append("\"exit\"=" + prettyPrintValue(fExit)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fState == null) ? 0 : fState.hashCode());
    result = prime * result + ((fExit == null) ? 0 : fExit.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StateExitBehaviorMatch)) { // this should be infrequent
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
    StateExitBehaviorMatch other = (StateExitBehaviorMatch) obj;
    if (fState == null) {if (other.fState != null) return false;}
    else if (!fState.equals(other.fState)) return false;
    if (fExit == null) {if (other.fExit != null) return false;}
    else if (!fExit.equals(other.fExit)) return false;
    return true;
  }
  
  @Override
  public StateExitBehaviorQuerySpecification specification() {
    try {
    	return StateExitBehaviorQuerySpecification.instance();
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
  public static StateExitBehaviorMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pExit the fixed value of pattern parameter exit, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StateExitBehaviorMatch newMutableMatch(final State pState, final Behavior pExit) {
    return new Mutable(pState, pExit);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pExit the fixed value of pattern parameter exit, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static StateExitBehaviorMatch newMatch(final State pState, final Behavior pExit) {
    return new Immutable(pState, pExit);
  }
  
  private static final class Mutable extends StateExitBehaviorMatch {
    Mutable(final State pState, final Behavior pExit) {
      super(pState, pExit);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StateExitBehaviorMatch {
    Immutable(final State pState, final Behavior pExit) {
      super(pState, pExit);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
