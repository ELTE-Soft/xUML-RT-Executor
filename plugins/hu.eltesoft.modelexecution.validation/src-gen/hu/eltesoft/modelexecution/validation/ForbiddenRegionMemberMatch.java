package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ForbiddenRegionMemberQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Region;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ForbiddenRegionMember pattern,
 * to be used in conjunction with {@link ForbiddenRegionMemberMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ForbiddenRegionMemberMatcher
 * @see ForbiddenRegionMemberProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ForbiddenRegionMemberMatch extends BasePatternMatch {
  private Region fRg;
  
  private Element fElem;
  
  private static List<String> parameterNames = makeImmutableList("rg", "elem");
  
  private ForbiddenRegionMemberMatch(final Region pRg, final Element pElem) {
    this.fRg = pRg;
    this.fElem = pElem;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("rg".equals(parameterName)) return this.fRg;
    if ("elem".equals(parameterName)) return this.fElem;
    return null;
  }
  
  public Region getRg() {
    return this.fRg;
  }
  
  public Element getElem() {
    return this.fElem;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("rg".equals(parameterName) ) {
    	this.fRg = (org.eclipse.uml2.uml.Region) newValue;
    	return true;
    }
    if ("elem".equals(parameterName) ) {
    	this.fElem = (org.eclipse.uml2.uml.Element) newValue;
    	return true;
    }
    return false;
  }
  
  public void setRg(final Region pRg) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRg = pRg;
  }
  
  public void setElem(final Element pElem) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElem = pElem;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ForbiddenRegionMember";
  }
  
  @Override
  public List<String> parameterNames() {
    return ForbiddenRegionMemberMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRg, fElem};
  }
  
  @Override
  public ForbiddenRegionMemberMatch toImmutable() {
    return isMutable() ? newMatch(fRg, fElem) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"rg\"=" + prettyPrintValue(fRg) + ", ");
    
    result.append("\"elem\"=" + prettyPrintValue(fElem)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRg == null) ? 0 : fRg.hashCode());
    result = prime * result + ((fElem == null) ? 0 : fElem.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ForbiddenRegionMemberMatch)) { // this should be infrequent
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
    ForbiddenRegionMemberMatch other = (ForbiddenRegionMemberMatch) obj;
    if (fRg == null) {if (other.fRg != null) return false;}
    else if (!fRg.equals(other.fRg)) return false;
    if (fElem == null) {if (other.fElem != null) return false;}
    else if (!fElem.equals(other.fElem)) return false;
    return true;
  }
  
  @Override
  public ForbiddenRegionMemberQuerySpecification specification() {
    try {
    	return ForbiddenRegionMemberQuerySpecification.instance();
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
  public static ForbiddenRegionMemberMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ForbiddenRegionMemberMatch newMutableMatch(final Region pRg, final Element pElem) {
    return new Mutable(pRg, pElem);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ForbiddenRegionMemberMatch newMatch(final Region pRg, final Element pElem) {
    return new Immutable(pRg, pElem);
  }
  
  private static final class Mutable extends ForbiddenRegionMemberMatch {
    Mutable(final Region pRg, final Element pElem) {
      super(pRg, pElem);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ForbiddenRegionMemberMatch {
    Immutable(final Region pRg, final Element pElem) {
      super(pRg, pElem);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
