package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.NoInitialTransitionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Pseudostate;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.NoInitialTransition pattern,
 * to be used in conjunction with {@link NoInitialTransitionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see NoInitialTransitionMatcher
 * @see NoInitialTransitionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class NoInitialTransitionMatch extends BasePatternMatch {
  private Pseudostate fSrc;
  
  private static List<String> parameterNames = makeImmutableList("src");
  
  private NoInitialTransitionMatch(final Pseudostate pSrc) {
    this.fSrc = pSrc;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("src".equals(parameterName)) return this.fSrc;
    return null;
  }
  
  public Pseudostate getSrc() {
    return this.fSrc;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("src".equals(parameterName) ) {
    	this.fSrc = (org.eclipse.uml2.uml.Pseudostate) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSrc(final Pseudostate pSrc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSrc = pSrc;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.NoInitialTransition";
  }
  
  @Override
  public List<String> parameterNames() {
    return NoInitialTransitionMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSrc};
  }
  
  @Override
  public NoInitialTransitionMatch toImmutable() {
    return isMutable() ? newMatch(fSrc) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"src\"=" + prettyPrintValue(fSrc)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSrc == null) ? 0 : fSrc.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof NoInitialTransitionMatch)) { // this should be infrequent
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
    NoInitialTransitionMatch other = (NoInitialTransitionMatch) obj;
    if (fSrc == null) {if (other.fSrc != null) return false;}
    else if (!fSrc.equals(other.fSrc)) return false;
    return true;
  }
  
  @Override
  public NoInitialTransitionQuerySpecification specification() {
    try {
    	return NoInitialTransitionQuerySpecification.instance();
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
  public static NoInitialTransitionMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static NoInitialTransitionMatch newMutableMatch(final Pseudostate pSrc) {
    return new Mutable(pSrc);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static NoInitialTransitionMatch newMatch(final Pseudostate pSrc) {
    return new Immutable(pSrc);
  }
  
  private static final class Mutable extends NoInitialTransitionMatch {
    Mutable(final Pseudostate pSrc) {
      super(pSrc);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends NoInitialTransitionMatch {
    Immutable(final Pseudostate pSrc) {
      super(pSrc);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
