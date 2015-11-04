package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ForbiddenComponentMemberQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ForbiddenComponentMember pattern,
 * to be used in conjunction with {@link ForbiddenComponentMemberMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ForbiddenComponentMemberMatcher
 * @see ForbiddenComponentMemberProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ForbiddenComponentMemberMatch extends BasePatternMatch {
  private Component fCp;
  
  private Element fElem;
  
  private static List<String> parameterNames = makeImmutableList("cp", "elem");
  
  private ForbiddenComponentMemberMatch(final Component pCp, final Element pElem) {
    this.fCp = pCp;
    this.fElem = pElem;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cp".equals(parameterName)) return this.fCp;
    if ("elem".equals(parameterName)) return this.fElem;
    return null;
  }
  
  public Component getCp() {
    return this.fCp;
  }
  
  public Element getElem() {
    return this.fElem;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cp".equals(parameterName) ) {
    	this.fCp = (org.eclipse.uml2.uml.Component) newValue;
    	return true;
    }
    if ("elem".equals(parameterName) ) {
    	this.fElem = (org.eclipse.uml2.uml.Element) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCp(final Component pCp) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCp = pCp;
  }
  
  public void setElem(final Element pElem) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElem = pElem;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ForbiddenComponentMember";
  }
  
  @Override
  public List<String> parameterNames() {
    return ForbiddenComponentMemberMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCp, fElem};
  }
  
  @Override
  public ForbiddenComponentMemberMatch toImmutable() {
    return isMutable() ? newMatch(fCp, fElem) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cp\"=" + prettyPrintValue(fCp) + ", ");
    
    result.append("\"elem\"=" + prettyPrintValue(fElem)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCp == null) ? 0 : fCp.hashCode());
    result = prime * result + ((fElem == null) ? 0 : fElem.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ForbiddenComponentMemberMatch)) { // this should be infrequent
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
    ForbiddenComponentMemberMatch other = (ForbiddenComponentMemberMatch) obj;
    if (fCp == null) {if (other.fCp != null) return false;}
    else if (!fCp.equals(other.fCp)) return false;
    if (fElem == null) {if (other.fElem != null) return false;}
    else if (!fElem.equals(other.fElem)) return false;
    return true;
  }
  
  @Override
  public ForbiddenComponentMemberQuerySpecification specification() {
    try {
    	return ForbiddenComponentMemberQuerySpecification.instance();
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
  public static ForbiddenComponentMemberMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ForbiddenComponentMemberMatch newMutableMatch(final Component pCp, final Element pElem) {
    return new Mutable(pCp, pElem);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ForbiddenComponentMemberMatch newMatch(final Component pCp, final Element pElem) {
    return new Immutable(pCp, pElem);
  }
  
  private static final class Mutable extends ForbiddenComponentMemberMatch {
    Mutable(final Component pCp, final Element pElem) {
      super(pCp, pElem);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ForbiddenComponentMemberMatch {
    Immutable(final Component pCp, final Element pElem) {
      super(pCp, pElem);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
