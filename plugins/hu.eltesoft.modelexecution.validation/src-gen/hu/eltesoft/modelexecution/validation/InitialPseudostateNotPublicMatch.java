package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.InitialPseudostateNotPublicQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Pseudostate;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.InitialPseudostateNotPublic pattern,
 * to be used in conjunction with {@link InitialPseudostateNotPublicMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InitialPseudostateNotPublicMatcher
 * @see InitialPseudostateNotPublicProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class InitialPseudostateNotPublicMatch extends BasePatternMatch {
  private Pseudostate fPs;
  
  private static List<String> parameterNames = makeImmutableList("ps");
  
  private InitialPseudostateNotPublicMatch(final Pseudostate pPs) {
    this.fPs = pPs;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("ps".equals(parameterName)) return this.fPs;
    return null;
  }
  
  public Pseudostate getPs() {
    return this.fPs;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("ps".equals(parameterName) ) {
    	this.fPs = (org.eclipse.uml2.uml.Pseudostate) newValue;
    	return true;
    }
    return false;
  }
  
  public void setPs(final Pseudostate pPs) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPs = pPs;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.InitialPseudostateNotPublic";
  }
  
  @Override
  public List<String> parameterNames() {
    return InitialPseudostateNotPublicMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPs};
  }
  
  @Override
  public InitialPseudostateNotPublicMatch toImmutable() {
    return isMutable() ? newMatch(fPs) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"ps\"=" + prettyPrintValue(fPs)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPs == null) ? 0 : fPs.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InitialPseudostateNotPublicMatch)) { // this should be infrequent
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
    InitialPseudostateNotPublicMatch other = (InitialPseudostateNotPublicMatch) obj;
    if (fPs == null) {if (other.fPs != null) return false;}
    else if (!fPs.equals(other.fPs)) return false;
    return true;
  }
  
  @Override
  public InitialPseudostateNotPublicQuerySpecification specification() {
    try {
    	return InitialPseudostateNotPublicQuerySpecification.instance();
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
  public static InitialPseudostateNotPublicMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pPs the fixed value of pattern parameter ps, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static InitialPseudostateNotPublicMatch newMutableMatch(final Pseudostate pPs) {
    return new Mutable(pPs);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPs the fixed value of pattern parameter ps, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static InitialPseudostateNotPublicMatch newMatch(final Pseudostate pPs) {
    return new Immutable(pPs);
  }
  
  private static final class Mutable extends InitialPseudostateNotPublicMatch {
    Mutable(final Pseudostate pPs) {
      super(pPs);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends InitialPseudostateNotPublicMatch {
    Immutable(final Pseudostate pPs) {
      super(pPs);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
