package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.ChildDeepHistoryQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.State;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.childDeepHistory pattern,
 * to be used in conjunction with {@link ChildDeepHistoryMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ChildDeepHistoryMatcher
 * @see ChildDeepHistoryProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ChildDeepHistoryMatch extends BasePatternMatch {
  private State fState;
  
  private Pseudostate fPseudostate;
  
  private static List<String> parameterNames = makeImmutableList("state", "pseudostate");
  
  private ChildDeepHistoryMatch(final State pState, final Pseudostate pPseudostate) {
    this.fState = pState;
    this.fPseudostate = pPseudostate;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("state".equals(parameterName)) return this.fState;
    if ("pseudostate".equals(parameterName)) return this.fPseudostate;
    return null;
  }
  
  public State getState() {
    return this.fState;
  }
  
  public Pseudostate getPseudostate() {
    return this.fPseudostate;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("state".equals(parameterName) ) {
    	this.fState = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    if ("pseudostate".equals(parameterName) ) {
    	this.fPseudostate = (org.eclipse.uml2.uml.Pseudostate) newValue;
    	return true;
    }
    return false;
  }
  
  public void setState(final State pState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fState = pState;
  }
  
  public void setPseudostate(final Pseudostate pPseudostate) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPseudostate = pPseudostate;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.childDeepHistory";
  }
  
  @Override
  public List<String> parameterNames() {
    return ChildDeepHistoryMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fState, fPseudostate};
  }
  
  @Override
  public ChildDeepHistoryMatch toImmutable() {
    return isMutable() ? newMatch(fState, fPseudostate) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"state\"=" + prettyPrintValue(fState) + ", ");
    
    result.append("\"pseudostate\"=" + prettyPrintValue(fPseudostate)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fState == null) ? 0 : fState.hashCode());
    result = prime * result + ((fPseudostate == null) ? 0 : fPseudostate.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ChildDeepHistoryMatch)) { // this should be infrequent
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
    ChildDeepHistoryMatch other = (ChildDeepHistoryMatch) obj;
    if (fState == null) {if (other.fState != null) return false;}
    else if (!fState.equals(other.fState)) return false;
    if (fPseudostate == null) {if (other.fPseudostate != null) return false;}
    else if (!fPseudostate.equals(other.fPseudostate)) return false;
    return true;
  }
  
  @Override
  public ChildDeepHistoryQuerySpecification specification() {
    try {
    	return ChildDeepHistoryQuerySpecification.instance();
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
  public static ChildDeepHistoryMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ChildDeepHistoryMatch newMutableMatch(final State pState, final Pseudostate pPseudostate) {
    return new Mutable(pState, pPseudostate);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ChildDeepHistoryMatch newMatch(final State pState, final Pseudostate pPseudostate) {
    return new Immutable(pState, pPseudostate);
  }
  
  private static final class Mutable extends ChildDeepHistoryMatch {
    Mutable(final State pState, final Pseudostate pPseudostate) {
      super(pState, pPseudostate);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ChildDeepHistoryMatch {
    Immutable(final State pState, final Pseudostate pPseudostate) {
      super(pState, pPseudostate);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
