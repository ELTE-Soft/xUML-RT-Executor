package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.TransitionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.transition pattern,
 * to be used in conjunction with {@link TransitionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TransitionMatcher
 * @see TransitionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TransitionMatch extends BasePatternMatch {
  private Transition fTransition;
  
  private Vertex fSourceState;
  
  private Vertex fTargetState;
  
  private static List<String> parameterNames = makeImmutableList("transition", "sourceState", "targetState");
  
  private TransitionMatch(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    this.fTransition = pTransition;
    this.fSourceState = pSourceState;
    this.fTargetState = pTargetState;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("transition".equals(parameterName)) return this.fTransition;
    if ("sourceState".equals(parameterName)) return this.fSourceState;
    if ("targetState".equals(parameterName)) return this.fTargetState;
    return null;
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
    return "com.incquerylabs.emdw.umlintegration.queries.transition";
  }
  
  @Override
  public List<String> parameterNames() {
    return TransitionMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTransition, fSourceState, fTargetState};
  }
  
  @Override
  public TransitionMatch toImmutable() {
    return isMutable() ? newMatch(fTransition, fSourceState, fTargetState) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
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
    result = prime * result + ((fTransition == null) ? 0 : fTransition.hashCode());
    result = prime * result + ((fSourceState == null) ? 0 : fSourceState.hashCode());
    result = prime * result + ((fTargetState == null) ? 0 : fTargetState.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TransitionMatch)) { // this should be infrequent
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
    TransitionMatch other = (TransitionMatch) obj;
    if (fTransition == null) {if (other.fTransition != null) return false;}
    else if (!fTransition.equals(other.fTransition)) return false;
    if (fSourceState == null) {if (other.fSourceState != null) return false;}
    else if (!fSourceState.equals(other.fSourceState)) return false;
    if (fTargetState == null) {if (other.fTargetState != null) return false;}
    else if (!fTargetState.equals(other.fTargetState)) return false;
    return true;
  }
  
  @Override
  public TransitionQuerySpecification specification() {
    try {
    	return TransitionQuerySpecification.instance();
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
  public static TransitionMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TransitionMatch newMutableMatch(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return new Mutable(pTransition, pSourceState, pTargetState);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TransitionMatch newMatch(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return new Immutable(pTransition, pSourceState, pTargetState);
  }
  
  private static final class Mutable extends TransitionMatch {
    Mutable(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
      super(pTransition, pSourceState, pTargetState);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TransitionMatch {
    Immutable(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
      super(pTransition, pSourceState, pTargetState);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
