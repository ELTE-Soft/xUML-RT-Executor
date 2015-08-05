package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.GuardQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Transition;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.guard pattern,
 * to be used in conjunction with {@link GuardMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see GuardMatcher
 * @see GuardProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class GuardMatch extends BasePatternMatch {
  private Transition fTransition;
  
  private Constraint fGuard;
  
  private static List<String> parameterNames = makeImmutableList("transition", "guard");
  
  private GuardMatch(final Transition pTransition, final Constraint pGuard) {
    this.fTransition = pTransition;
    this.fGuard = pGuard;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("transition".equals(parameterName)) return this.fTransition;
    if ("guard".equals(parameterName)) return this.fGuard;
    return null;
  }
  
  public Transition getTransition() {
    return this.fTransition;
  }
  
  public Constraint getGuard() {
    return this.fGuard;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("transition".equals(parameterName) ) {
    	this.fTransition = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    if ("guard".equals(parameterName) ) {
    	this.fGuard = (org.eclipse.uml2.uml.Constraint) newValue;
    	return true;
    }
    return false;
  }
  
  public void setTransition(final Transition pTransition) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTransition = pTransition;
  }
  
  public void setGuard(final Constraint pGuard) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fGuard = pGuard;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.guard";
  }
  
  @Override
  public List<String> parameterNames() {
    return GuardMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTransition, fGuard};
  }
  
  @Override
  public GuardMatch toImmutable() {
    return isMutable() ? newMatch(fTransition, fGuard) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
    
    result.append("\"guard\"=" + prettyPrintValue(fGuard)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTransition == null) ? 0 : fTransition.hashCode());
    result = prime * result + ((fGuard == null) ? 0 : fGuard.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof GuardMatch)) { // this should be infrequent
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
    GuardMatch other = (GuardMatch) obj;
    if (fTransition == null) {if (other.fTransition != null) return false;}
    else if (!fTransition.equals(other.fTransition)) return false;
    if (fGuard == null) {if (other.fGuard != null) return false;}
    else if (!fGuard.equals(other.fGuard)) return false;
    return true;
  }
  
  @Override
  public GuardQuerySpecification specification() {
    try {
    	return GuardQuerySpecification.instance();
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
  public static GuardMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pGuard the fixed value of pattern parameter guard, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static GuardMatch newMutableMatch(final Transition pTransition, final Constraint pGuard) {
    return new Mutable(pTransition, pGuard);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pGuard the fixed value of pattern parameter guard, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static GuardMatch newMatch(final Transition pTransition, final Constraint pGuard) {
    return new Immutable(pTransition, pGuard);
  }
  
  private static final class Mutable extends GuardMatch {
    Mutable(final Transition pTransition, final Constraint pGuard) {
      super(pTransition, pGuard);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends GuardMatch {
    Immutable(final Transition pTransition, final Constraint pGuard) {
      super(pTransition, pGuard);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
