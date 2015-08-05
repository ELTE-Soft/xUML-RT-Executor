package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelSimpleStateQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.toplevelSimpleState pattern,
 * to be used in conjunction with {@link ToplevelSimpleStateMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ToplevelSimpleStateMatcher
 * @see ToplevelSimpleStateProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ToplevelSimpleStateMatch extends BasePatternMatch {
  private StateMachine fStateMachine;
  
  private State fState;
  
  private static List<String> parameterNames = makeImmutableList("stateMachine", "state");
  
  private ToplevelSimpleStateMatch(final StateMachine pStateMachine, final State pState) {
    this.fStateMachine = pStateMachine;
    this.fState = pState;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("stateMachine".equals(parameterName)) return this.fStateMachine;
    if ("state".equals(parameterName)) return this.fState;
    return null;
  }
  
  public StateMachine getStateMachine() {
    return this.fStateMachine;
  }
  
  public State getState() {
    return this.fState;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("stateMachine".equals(parameterName) ) {
    	this.fStateMachine = (org.eclipse.uml2.uml.StateMachine) newValue;
    	return true;
    }
    if ("state".equals(parameterName) ) {
    	this.fState = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    return false;
  }
  
  public void setStateMachine(final StateMachine pStateMachine) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fStateMachine = pStateMachine;
  }
  
  public void setState(final State pState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fState = pState;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.toplevelSimpleState";
  }
  
  @Override
  public List<String> parameterNames() {
    return ToplevelSimpleStateMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fStateMachine, fState};
  }
  
  @Override
  public ToplevelSimpleStateMatch toImmutable() {
    return isMutable() ? newMatch(fStateMachine, fState) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"stateMachine\"=" + prettyPrintValue(fStateMachine) + ", ");
    
    result.append("\"state\"=" + prettyPrintValue(fState)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fStateMachine == null) ? 0 : fStateMachine.hashCode());
    result = prime * result + ((fState == null) ? 0 : fState.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ToplevelSimpleStateMatch)) { // this should be infrequent
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
    ToplevelSimpleStateMatch other = (ToplevelSimpleStateMatch) obj;
    if (fStateMachine == null) {if (other.fStateMachine != null) return false;}
    else if (!fStateMachine.equals(other.fStateMachine)) return false;
    if (fState == null) {if (other.fState != null) return false;}
    else if (!fState.equals(other.fState)) return false;
    return true;
  }
  
  @Override
  public ToplevelSimpleStateQuerySpecification specification() {
    try {
    	return ToplevelSimpleStateQuerySpecification.instance();
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
  public static ToplevelSimpleStateMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ToplevelSimpleStateMatch newMutableMatch(final StateMachine pStateMachine, final State pState) {
    return new Mutable(pStateMachine, pState);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ToplevelSimpleStateMatch newMatch(final StateMachine pStateMachine, final State pState) {
    return new Immutable(pStateMachine, pState);
  }
  
  private static final class Mutable extends ToplevelSimpleStateMatch {
    Mutable(final StateMachine pStateMachine, final State pState) {
      super(pStateMachine, pState);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ToplevelSimpleStateMatch {
    Immutable(final StateMachine pStateMachine, final State pState) {
      super(pStateMachine, pState);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
