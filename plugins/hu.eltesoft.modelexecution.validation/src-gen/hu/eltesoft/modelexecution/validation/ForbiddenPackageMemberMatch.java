package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ForbiddenPackageMemberQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Element;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ForbiddenPackageMember pattern,
 * to be used in conjunction with {@link ForbiddenPackageMemberMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ForbiddenPackageMemberMatcher
 * @see ForbiddenPackageMemberProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ForbiddenPackageMemberMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Package fPk;
  
  private Element fElem;
  
  private static List<String> parameterNames = makeImmutableList("pk", "elem");
  
  private ForbiddenPackageMemberMatch(final org.eclipse.uml2.uml.Package pPk, final Element pElem) {
    this.fPk = pPk;
    this.fElem = pElem;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("pk".equals(parameterName)) return this.fPk;
    if ("elem".equals(parameterName)) return this.fElem;
    return null;
  }
  
  public org.eclipse.uml2.uml.Package getPk() {
    return this.fPk;
  }
  
  public Element getElem() {
    return this.fElem;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("pk".equals(parameterName) ) {
    	this.fPk = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    if ("elem".equals(parameterName) ) {
    	this.fElem = (org.eclipse.uml2.uml.Element) newValue;
    	return true;
    }
    return false;
  }
  
  public void setPk(final org.eclipse.uml2.uml.Package pPk) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPk = pPk;
  }
  
  public void setElem(final Element pElem) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElem = pElem;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ForbiddenPackageMember";
  }
  
  @Override
  public List<String> parameterNames() {
    return ForbiddenPackageMemberMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPk, fElem};
  }
  
  @Override
  public ForbiddenPackageMemberMatch toImmutable() {
    return isMutable() ? newMatch(fPk, fElem) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"pk\"=" + prettyPrintValue(fPk) + ", ");
    
    result.append("\"elem\"=" + prettyPrintValue(fElem)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPk == null) ? 0 : fPk.hashCode());
    result = prime * result + ((fElem == null) ? 0 : fElem.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ForbiddenPackageMemberMatch)) { // this should be infrequent
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
    ForbiddenPackageMemberMatch other = (ForbiddenPackageMemberMatch) obj;
    if (fPk == null) {if (other.fPk != null) return false;}
    else if (!fPk.equals(other.fPk)) return false;
    if (fElem == null) {if (other.fElem != null) return false;}
    else if (!fElem.equals(other.fElem)) return false;
    return true;
  }
  
  @Override
  public ForbiddenPackageMemberQuerySpecification specification() {
    try {
    	return ForbiddenPackageMemberQuerySpecification.instance();
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
  public static ForbiddenPackageMemberMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pPk the fixed value of pattern parameter pk, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ForbiddenPackageMemberMatch newMutableMatch(final org.eclipse.uml2.uml.Package pPk, final Element pElem) {
    return new Mutable(pPk, pElem);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPk the fixed value of pattern parameter pk, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ForbiddenPackageMemberMatch newMatch(final org.eclipse.uml2.uml.Package pPk, final Element pElem) {
    return new Immutable(pPk, pElem);
  }
  
  private static final class Mutable extends ForbiddenPackageMemberMatch {
    Mutable(final org.eclipse.uml2.uml.Package pPk, final Element pElem) {
      super(pPk, pElem);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ForbiddenPackageMemberMatch {
    Immutable(final org.eclipse.uml2.uml.Package pPk, final Element pElem) {
      super(pPk, pElem);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
