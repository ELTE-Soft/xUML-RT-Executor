package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.ChoicePointQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Pseudostate;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.choicePoint pattern,
 * to be used in conjunction with {@link ChoicePointMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ChoicePointMatcher
 * @see ChoicePointProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ChoicePointMatch extends BasePatternMatch {
  private Pseudostate fPseudostate;
  
  private static List<String> parameterNames = makeImmutableList("pseudostate");
  
  private ChoicePointMatch(final Pseudostate pPseudostate) {
    this.fPseudostate = pPseudostate;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("pseudostate".equals(parameterName)) return this.fPseudostate;
    return null;
  }
  
  public Pseudostate getPseudostate() {
    return this.fPseudostate;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("pseudostate".equals(parameterName) ) {
    	this.fPseudostate = (org.eclipse.uml2.uml.Pseudostate) newValue;
    	return true;
    }
    return false;
  }
  
  public void setPseudostate(final Pseudostate pPseudostate) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPseudostate = pPseudostate;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.choicePoint";
  }
  
  @Override
  public List<String> parameterNames() {
    return ChoicePointMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPseudostate};
  }
  
  @Override
  public ChoicePointMatch toImmutable() {
    return isMutable() ? newMatch(fPseudostate) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"pseudostate\"=" + prettyPrintValue(fPseudostate)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPseudostate == null) ? 0 : fPseudostate.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ChoicePointMatch)) { // this should be infrequent
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
    ChoicePointMatch other = (ChoicePointMatch) obj;
    if (fPseudostate == null) {if (other.fPseudostate != null) return false;}
    else if (!fPseudostate.equals(other.fPseudostate)) return false;
    return true;
  }
  
  @Override
  public ChoicePointQuerySpecification specification() {
    try {
    	return ChoicePointQuerySpecification.instance();
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
  public static ChoicePointMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ChoicePointMatch newMutableMatch(final Pseudostate pPseudostate) {
    return new Mutable(pPseudostate);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ChoicePointMatch newMatch(final Pseudostate pPseudostate) {
    return new Immutable(pPseudostate);
  }
  
  private static final class Mutable extends ChoicePointMatch {
    Mutable(final Pseudostate pPseudostate) {
      super(pPseudostate);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ChoicePointMatch {
    Immutable(final Pseudostate pPseudostate) {
      super(pPseudostate);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
