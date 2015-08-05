package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelJunctionPointQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.toplevelJunctionPoint pattern,
 * to be used in conjunction with {@link ToplevelJunctionPointMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ToplevelJunctionPointMatcher
 * @see ToplevelJunctionPointProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ToplevelJunctionPointMatch extends BasePatternMatch {
  private StateMachine fStateMachine;
  
  private Pseudostate fPseudostate;
  
  private static List<String> parameterNames = makeImmutableList("stateMachine", "pseudostate");
  
  private ToplevelJunctionPointMatch(final StateMachine pStateMachine, final Pseudostate pPseudostate) {
    this.fStateMachine = pStateMachine;
    this.fPseudostate = pPseudostate;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("stateMachine".equals(parameterName)) return this.fStateMachine;
    if ("pseudostate".equals(parameterName)) return this.fPseudostate;
    return null;
  }
  
  public StateMachine getStateMachine() {
    return this.fStateMachine;
  }
  
  public Pseudostate getPseudostate() {
    return this.fPseudostate;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("stateMachine".equals(parameterName) ) {
    	this.fStateMachine = (org.eclipse.uml2.uml.StateMachine) newValue;
    	return true;
    }
    if ("pseudostate".equals(parameterName) ) {
    	this.fPseudostate = (org.eclipse.uml2.uml.Pseudostate) newValue;
    	return true;
    }
    return false;
  }
  
  public void setStateMachine(final StateMachine pStateMachine) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fStateMachine = pStateMachine;
  }
  
  public void setPseudostate(final Pseudostate pPseudostate) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPseudostate = pPseudostate;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.toplevelJunctionPoint";
  }
  
  @Override
  public List<String> parameterNames() {
    return ToplevelJunctionPointMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fStateMachine, fPseudostate};
  }
  
  @Override
  public ToplevelJunctionPointMatch toImmutable() {
    return isMutable() ? newMatch(fStateMachine, fPseudostate) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"stateMachine\"=" + prettyPrintValue(fStateMachine) + ", ");
    
    result.append("\"pseudostate\"=" + prettyPrintValue(fPseudostate)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fStateMachine == null) ? 0 : fStateMachine.hashCode());
    result = prime * result + ((fPseudostate == null) ? 0 : fPseudostate.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ToplevelJunctionPointMatch)) { // this should be infrequent
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
    ToplevelJunctionPointMatch other = (ToplevelJunctionPointMatch) obj;
    if (fStateMachine == null) {if (other.fStateMachine != null) return false;}
    else if (!fStateMachine.equals(other.fStateMachine)) return false;
    if (fPseudostate == null) {if (other.fPseudostate != null) return false;}
    else if (!fPseudostate.equals(other.fPseudostate)) return false;
    return true;
  }
  
  @Override
  public ToplevelJunctionPointQuerySpecification specification() {
    try {
    	return ToplevelJunctionPointQuerySpecification.instance();
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
  public static ToplevelJunctionPointMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ToplevelJunctionPointMatch newMutableMatch(final StateMachine pStateMachine, final Pseudostate pPseudostate) {
    return new Mutable(pStateMachine, pPseudostate);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ToplevelJunctionPointMatch newMatch(final StateMachine pStateMachine, final Pseudostate pPseudostate) {
    return new Immutable(pStateMachine, pPseudostate);
  }
  
  private static final class Mutable extends ToplevelJunctionPointMatch {
    Mutable(final StateMachine pStateMachine, final Pseudostate pPseudostate) {
      super(pStateMachine, pPseudostate);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ToplevelJunctionPointMatch {
    Immutable(final StateMachine pStateMachine, final Pseudostate pPseudostate) {
      super(pStateMachine, pPseudostate);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
