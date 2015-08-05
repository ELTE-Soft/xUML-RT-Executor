package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.StateMachineQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.stateMachine pattern,
 * to be used in conjunction with {@link StateMachineMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StateMachineMatcher
 * @see StateMachineProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StateMachineMatch extends BasePatternMatch {
  private BehavioredClassifier fBehavioredClassifier;
  
  private StateMachine fStateMachine;
  
  private static List<String> parameterNames = makeImmutableList("behavioredClassifier", "stateMachine");
  
  private StateMachineMatch(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine) {
    this.fBehavioredClassifier = pBehavioredClassifier;
    this.fStateMachine = pStateMachine;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("behavioredClassifier".equals(parameterName)) return this.fBehavioredClassifier;
    if ("stateMachine".equals(parameterName)) return this.fStateMachine;
    return null;
  }
  
  public BehavioredClassifier getBehavioredClassifier() {
    return this.fBehavioredClassifier;
  }
  
  public StateMachine getStateMachine() {
    return this.fStateMachine;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("behavioredClassifier".equals(parameterName) ) {
    	this.fBehavioredClassifier = (org.eclipse.uml2.uml.BehavioredClassifier) newValue;
    	return true;
    }
    if ("stateMachine".equals(parameterName) ) {
    	this.fStateMachine = (org.eclipse.uml2.uml.StateMachine) newValue;
    	return true;
    }
    return false;
  }
  
  public void setBehavioredClassifier(final BehavioredClassifier pBehavioredClassifier) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBehavioredClassifier = pBehavioredClassifier;
  }
  
  public void setStateMachine(final StateMachine pStateMachine) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fStateMachine = pStateMachine;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.stateMachine";
  }
  
  @Override
  public List<String> parameterNames() {
    return StateMachineMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBehavioredClassifier, fStateMachine};
  }
  
  @Override
  public StateMachineMatch toImmutable() {
    return isMutable() ? newMatch(fBehavioredClassifier, fStateMachine) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"behavioredClassifier\"=" + prettyPrintValue(fBehavioredClassifier) + ", ");
    
    result.append("\"stateMachine\"=" + prettyPrintValue(fStateMachine)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBehavioredClassifier == null) ? 0 : fBehavioredClassifier.hashCode());
    result = prime * result + ((fStateMachine == null) ? 0 : fStateMachine.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StateMachineMatch)) { // this should be infrequent
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
    StateMachineMatch other = (StateMachineMatch) obj;
    if (fBehavioredClassifier == null) {if (other.fBehavioredClassifier != null) return false;}
    else if (!fBehavioredClassifier.equals(other.fBehavioredClassifier)) return false;
    if (fStateMachine == null) {if (other.fStateMachine != null) return false;}
    else if (!fStateMachine.equals(other.fStateMachine)) return false;
    return true;
  }
  
  @Override
  public StateMachineQuerySpecification specification() {
    try {
    	return StateMachineQuerySpecification.instance();
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
  public static StateMachineMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBehavioredClassifier the fixed value of pattern parameter behavioredClassifier, or null if not bound.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StateMachineMatch newMutableMatch(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine) {
    return new Mutable(pBehavioredClassifier, pStateMachine);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBehavioredClassifier the fixed value of pattern parameter behavioredClassifier, or null if not bound.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static StateMachineMatch newMatch(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine) {
    return new Immutable(pBehavioredClassifier, pStateMachine);
  }
  
  private static final class Mutable extends StateMachineMatch {
    Mutable(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine) {
      super(pBehavioredClassifier, pStateMachine);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StateMachineMatch {
    Immutable(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine) {
      super(pBehavioredClassifier, pStateMachine);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
