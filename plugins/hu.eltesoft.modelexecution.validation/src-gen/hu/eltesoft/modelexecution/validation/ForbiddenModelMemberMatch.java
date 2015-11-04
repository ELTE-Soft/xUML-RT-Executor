package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ForbiddenModelMemberQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ForbiddenModelMember pattern,
 * to be used in conjunction with {@link ForbiddenModelMemberMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ForbiddenModelMemberMatcher
 * @see ForbiddenModelMemberProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ForbiddenModelMemberMatch extends BasePatternMatch {
  private Model fMd;
  
  private Element fElem;
  
  private static List<String> parameterNames = makeImmutableList("md", "elem");
  
  private ForbiddenModelMemberMatch(final Model pMd, final Element pElem) {
    this.fMd = pMd;
    this.fElem = pElem;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("md".equals(parameterName)) return this.fMd;
    if ("elem".equals(parameterName)) return this.fElem;
    return null;
  }
  
  public Model getMd() {
    return this.fMd;
  }
  
  public Element getElem() {
    return this.fElem;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("md".equals(parameterName) ) {
    	this.fMd = (org.eclipse.uml2.uml.Model) newValue;
    	return true;
    }
    if ("elem".equals(parameterName) ) {
    	this.fElem = (org.eclipse.uml2.uml.Element) newValue;
    	return true;
    }
    return false;
  }
  
  public void setMd(final Model pMd) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMd = pMd;
  }
  
  public void setElem(final Element pElem) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElem = pElem;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ForbiddenModelMember";
  }
  
  @Override
  public List<String> parameterNames() {
    return ForbiddenModelMemberMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fMd, fElem};
  }
  
  @Override
  public ForbiddenModelMemberMatch toImmutable() {
    return isMutable() ? newMatch(fMd, fElem) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"md\"=" + prettyPrintValue(fMd) + ", ");
    
    result.append("\"elem\"=" + prettyPrintValue(fElem)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fMd == null) ? 0 : fMd.hashCode());
    result = prime * result + ((fElem == null) ? 0 : fElem.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ForbiddenModelMemberMatch)) { // this should be infrequent
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
    ForbiddenModelMemberMatch other = (ForbiddenModelMemberMatch) obj;
    if (fMd == null) {if (other.fMd != null) return false;}
    else if (!fMd.equals(other.fMd)) return false;
    if (fElem == null) {if (other.fElem != null) return false;}
    else if (!fElem.equals(other.fElem)) return false;
    return true;
  }
  
  @Override
  public ForbiddenModelMemberQuerySpecification specification() {
    try {
    	return ForbiddenModelMemberQuerySpecification.instance();
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
  public static ForbiddenModelMemberMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pMd the fixed value of pattern parameter md, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ForbiddenModelMemberMatch newMutableMatch(final Model pMd, final Element pElem) {
    return new Mutable(pMd, pElem);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pMd the fixed value of pattern parameter md, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ForbiddenModelMemberMatch newMatch(final Model pMd, final Element pElem) {
    return new Immutable(pMd, pElem);
  }
  
  private static final class Mutable extends ForbiddenModelMemberMatch {
    Mutable(final Model pMd, final Element pElem) {
      super(pMd, pElem);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ForbiddenModelMemberMatch {
    Immutable(final Model pMd, final Element pElem) {
      super(pMd, pElem);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
