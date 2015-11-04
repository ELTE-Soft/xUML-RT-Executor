package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.PropertyUnrecognizedElementQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.PropertyUnrecognizedElement pattern,
 * to be used in conjunction with {@link PropertyUnrecognizedElementMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PropertyUnrecognizedElementMatcher
 * @see PropertyUnrecognizedElementProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PropertyUnrecognizedElementMatch extends BasePatternMatch {
  private Property fPr;
  
  private Element fElem;
  
  private static List<String> parameterNames = makeImmutableList("pr", "elem");
  
  private PropertyUnrecognizedElementMatch(final Property pPr, final Element pElem) {
    this.fPr = pPr;
    this.fElem = pElem;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("pr".equals(parameterName)) return this.fPr;
    if ("elem".equals(parameterName)) return this.fElem;
    return null;
  }
  
  public Property getPr() {
    return this.fPr;
  }
  
  public Element getElem() {
    return this.fElem;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("pr".equals(parameterName) ) {
    	this.fPr = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    if ("elem".equals(parameterName) ) {
    	this.fElem = (org.eclipse.uml2.uml.Element) newValue;
    	return true;
    }
    return false;
  }
  
  public void setPr(final Property pPr) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPr = pPr;
  }
  
  public void setElem(final Element pElem) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElem = pElem;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.PropertyUnrecognizedElement";
  }
  
  @Override
  public List<String> parameterNames() {
    return PropertyUnrecognizedElementMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPr, fElem};
  }
  
  @Override
  public PropertyUnrecognizedElementMatch toImmutable() {
    return isMutable() ? newMatch(fPr, fElem) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"pr\"=" + prettyPrintValue(fPr) + ", ");
    
    result.append("\"elem\"=" + prettyPrintValue(fElem)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPr == null) ? 0 : fPr.hashCode());
    result = prime * result + ((fElem == null) ? 0 : fElem.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PropertyUnrecognizedElementMatch)) { // this should be infrequent
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
    PropertyUnrecognizedElementMatch other = (PropertyUnrecognizedElementMatch) obj;
    if (fPr == null) {if (other.fPr != null) return false;}
    else if (!fPr.equals(other.fPr)) return false;
    if (fElem == null) {if (other.fElem != null) return false;}
    else if (!fElem.equals(other.fElem)) return false;
    return true;
  }
  
  @Override
  public PropertyUnrecognizedElementQuerySpecification specification() {
    try {
    	return PropertyUnrecognizedElementQuerySpecification.instance();
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
  public static PropertyUnrecognizedElementMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pPr the fixed value of pattern parameter pr, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PropertyUnrecognizedElementMatch newMutableMatch(final Property pPr, final Element pElem) {
    return new Mutable(pPr, pElem);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPr the fixed value of pattern parameter pr, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PropertyUnrecognizedElementMatch newMatch(final Property pPr, final Element pElem) {
    return new Immutable(pPr, pElem);
  }
  
  private static final class Mutable extends PropertyUnrecognizedElementMatch {
    Mutable(final Property pPr, final Element pElem) {
      super(pPr, pElem);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PropertyUnrecognizedElementMatch {
    Immutable(final Property pPr, final Element pElem) {
      super(pPr, pElem);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
