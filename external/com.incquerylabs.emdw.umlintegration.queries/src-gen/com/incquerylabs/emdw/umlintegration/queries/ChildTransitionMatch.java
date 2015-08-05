package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.ChildTransitionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.childTransition pattern,
 * to be used in conjunction with {@link ChildTransitionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ChildTransitionMatcher
 * @see ChildTransitionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ChildTransitionMatch extends BasePatternMatch {
  private State fParentState;
  
  private Transition fTransition;
  
  private Vertex fSourceState;
  
  private Vertex fTargetState;
  
  private static List<String> parameterNames = makeImmutableList("parentState", "transition", "sourceState", "targetState");
  
  private ChildTransitionMatch(final State pParentState, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    this.fParentState = pParentState;
    this.fTransition = pTransition;
    this.fSourceState = pSourceState;
    this.fTargetState = pTargetState;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("parentState".equals(parameterName)) return this.fParentState;
    if ("transition".equals(parameterName)) return this.fTransition;
    if ("sourceState".equals(parameterName)) return this.fSourceState;
    if ("targetState".equals(parameterName)) return this.fTargetState;
    return null;
  }
  
  public State getParentState() {
    return this.fParentState;
  }
  
  public Transition getTransition() {
    return this.fTransition;
  }
  
  public Vertex getSourceState() {
    return this.fSourceState;
  }
  
  public Vertex getTargetState() {
    return this.fTargetState;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("parentState".equals(parameterName) ) {
    	this.fParentState = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    if ("transition".equals(parameterName) ) {
    	this.fTransition = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    if ("sourceState".equals(parameterName) ) {
    	this.fSourceState = (org.eclipse.uml2.uml.Vertex) newValue;
    	return true;
    }
    if ("targetState".equals(parameterName) ) {
    	this.fTargetState = (org.eclipse.uml2.uml.Vertex) newValue;
    	return true;
    }
    return false;
  }
  
  public void setParentState(final State pParentState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParentState = pParentState;
  }
  
  public void setTransition(final Transition pTransition) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTransition = pTransition;
  }
  
  public void setSourceState(final Vertex pSourceState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSourceState = pSourceState;
  }
  
  public void setTargetState(final Vertex pTargetState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTargetState = pTargetState;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.childTransition";
  }
  
  @Override
  public List<String> parameterNames() {
    return ChildTransitionMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fParentState, fTransition, fSourceState, fTargetState};
  }
  
  @Override
  public ChildTransitionMatch toImmutable() {
    return isMutable() ? newMatch(fParentState, fTransition, fSourceState, fTargetState) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"parentState\"=" + prettyPrintValue(fParentState) + ", ");
    
    result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
    
    result.append("\"sourceState\"=" + prettyPrintValue(fSourceState) + ", ");
    
    result.append("\"targetState\"=" + prettyPrintValue(fTargetState)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fParentState == null) ? 0 : fParentState.hashCode());
    result = prime * result + ((fTransition == null) ? 0 : fTransition.hashCode());
    result = prime * result + ((fSourceState == null) ? 0 : fSourceState.hashCode());
    result = prime * result + ((fTargetState == null) ? 0 : fTargetState.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ChildTransitionMatch)) { // this should be infrequent
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
    ChildTransitionMatch other = (ChildTransitionMatch) obj;
    if (fParentState == null) {if (other.fParentState != null) return false;}
    else if (!fParentState.equals(other.fParentState)) return false;
    if (fTransition == null) {if (other.fTransition != null) return false;}
    else if (!fTransition.equals(other.fTransition)) return false;
    if (fSourceState == null) {if (other.fSourceState != null) return false;}
    else if (!fSourceState.equals(other.fSourceState)) return false;
    if (fTargetState == null) {if (other.fTargetState != null) return false;}
    else if (!fTargetState.equals(other.fTargetState)) return false;
    return true;
  }
  
  @Override
  public ChildTransitionQuerySpecification specification() {
    try {
    	return ChildTransitionQuerySpecification.instance();
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
  public static ChildTransitionMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pParentState the fixed value of pattern parameter parentState, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ChildTransitionMatch newMutableMatch(final State pParentState, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return new Mutable(pParentState, pTransition, pSourceState, pTargetState);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParentState the fixed value of pattern parameter parentState, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ChildTransitionMatch newMatch(final State pParentState, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return new Immutable(pParentState, pTransition, pSourceState, pTargetState);
  }
  
  private static final class Mutable extends ChildTransitionMatch {
    Mutable(final State pParentState, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
      super(pParentState, pTransition, pSourceState, pTargetState);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ChildTransitionMatch {
    Immutable(final State pParentState, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
      super(pParentState, pTransition, pSourceState, pTargetState);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
