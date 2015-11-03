package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.RegionNotPublicQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Region;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.RegionNotPublic pattern,
 * to be used in conjunction with {@link RegionNotPublicMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see RegionNotPublicMatcher
 * @see RegionNotPublicProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class RegionNotPublicMatch extends BasePatternMatch {
  private Region fRg;
  
  private static List<String> parameterNames = makeImmutableList("rg");
  
  private RegionNotPublicMatch(final Region pRg) {
    this.fRg = pRg;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("rg".equals(parameterName)) return this.fRg;
    return null;
  }
  
  public Region getRg() {
    return this.fRg;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("rg".equals(parameterName) ) {
    	this.fRg = (org.eclipse.uml2.uml.Region) newValue;
    	return true;
    }
    return false;
  }
  
  public void setRg(final Region pRg) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRg = pRg;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.RegionNotPublic";
  }
  
  @Override
  public List<String> parameterNames() {
    return RegionNotPublicMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRg};
  }
  
  @Override
  public RegionNotPublicMatch toImmutable() {
    return isMutable() ? newMatch(fRg) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"rg\"=" + prettyPrintValue(fRg)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRg == null) ? 0 : fRg.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof RegionNotPublicMatch)) { // this should be infrequent
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
    RegionNotPublicMatch other = (RegionNotPublicMatch) obj;
    if (fRg == null) {if (other.fRg != null) return false;}
    else if (!fRg.equals(other.fRg)) return false;
    return true;
  }
  
  @Override
  public RegionNotPublicQuerySpecification specification() {
    try {
    	return RegionNotPublicQuerySpecification.instance();
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
  public static RegionNotPublicMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static RegionNotPublicMatch newMutableMatch(final Region pRg) {
    return new Mutable(pRg);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static RegionNotPublicMatch newMatch(final Region pRg) {
    return new Immutable(pRg);
  }
  
  private static final class Mutable extends RegionNotPublicMatch {
    Mutable(final Region pRg) {
      super(pRg);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends RegionNotPublicMatch {
    Immutable(final Region pRg) {
      super(pRg);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
