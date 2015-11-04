package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.TwoElementWithSameNameQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.TwoElementWithSameName pattern,
 * to be used in conjunction with {@link TwoElementWithSameNameMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TwoElementWithSameNameMatcher
 * @see TwoElementWithSameNameProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TwoElementWithSameNameMatch extends BasePatternMatch {
  private String fQname;
  
  private NamedElement fElem1;
  
  private NamedElement fElem2;
  
  private static List<String> parameterNames = makeImmutableList("qname", "elem1", "elem2");
  
  private TwoElementWithSameNameMatch(final String pQname, final NamedElement pElem1, final NamedElement pElem2) {
    this.fQname = pQname;
    this.fElem1 = pElem1;
    this.fElem2 = pElem2;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("qname".equals(parameterName)) return this.fQname;
    if ("elem1".equals(parameterName)) return this.fElem1;
    if ("elem2".equals(parameterName)) return this.fElem2;
    return null;
  }
  
  public String getQname() {
    return this.fQname;
  }
  
  public NamedElement getElem1() {
    return this.fElem1;
  }
  
  public NamedElement getElem2() {
    return this.fElem2;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("qname".equals(parameterName) ) {
    	this.fQname = (java.lang.String) newValue;
    	return true;
    }
    if ("elem1".equals(parameterName) ) {
    	this.fElem1 = (org.eclipse.uml2.uml.NamedElement) newValue;
    	return true;
    }
    if ("elem2".equals(parameterName) ) {
    	this.fElem2 = (org.eclipse.uml2.uml.NamedElement) newValue;
    	return true;
    }
    return false;
  }
  
  public void setQname(final String pQname) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fQname = pQname;
  }
  
  public void setElem1(final NamedElement pElem1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElem1 = pElem1;
  }
  
  public void setElem2(final NamedElement pElem2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElem2 = pElem2;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.TwoElementWithSameName";
  }
  
  @Override
  public List<String> parameterNames() {
    return TwoElementWithSameNameMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fQname, fElem1, fElem2};
  }
  
  @Override
  public TwoElementWithSameNameMatch toImmutable() {
    return isMutable() ? newMatch(fQname, fElem1, fElem2) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"qname\"=" + prettyPrintValue(fQname) + ", ");
    
    result.append("\"elem1\"=" + prettyPrintValue(fElem1) + ", ");
    
    result.append("\"elem2\"=" + prettyPrintValue(fElem2)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fQname == null) ? 0 : fQname.hashCode());
    result = prime * result + ((fElem1 == null) ? 0 : fElem1.hashCode());
    result = prime * result + ((fElem2 == null) ? 0 : fElem2.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TwoElementWithSameNameMatch)) { // this should be infrequent
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
    TwoElementWithSameNameMatch other = (TwoElementWithSameNameMatch) obj;
    if (fQname == null) {if (other.fQname != null) return false;}
    else if (!fQname.equals(other.fQname)) return false;
    if (fElem1 == null) {if (other.fElem1 != null) return false;}
    else if (!fElem1.equals(other.fElem1)) return false;
    if (fElem2 == null) {if (other.fElem2 != null) return false;}
    else if (!fElem2.equals(other.fElem2)) return false;
    return true;
  }
  
  @Override
  public TwoElementWithSameNameQuerySpecification specification() {
    try {
    	return TwoElementWithSameNameQuerySpecification.instance();
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
  public static TwoElementWithSameNameMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pQname the fixed value of pattern parameter qname, or null if not bound.
   * @param pElem1 the fixed value of pattern parameter elem1, or null if not bound.
   * @param pElem2 the fixed value of pattern parameter elem2, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TwoElementWithSameNameMatch newMutableMatch(final String pQname, final NamedElement pElem1, final NamedElement pElem2) {
    return new Mutable(pQname, pElem1, pElem2);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pQname the fixed value of pattern parameter qname, or null if not bound.
   * @param pElem1 the fixed value of pattern parameter elem1, or null if not bound.
   * @param pElem2 the fixed value of pattern parameter elem2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TwoElementWithSameNameMatch newMatch(final String pQname, final NamedElement pElem1, final NamedElement pElem2) {
    return new Immutable(pQname, pElem1, pElem2);
  }
  
  private static final class Mutable extends TwoElementWithSameNameMatch {
    Mutable(final String pQname, final NamedElement pElem1, final NamedElement pElem2) {
      super(pQname, pElem1, pElem2);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TwoElementWithSameNameMatch {
    Immutable(final String pQname, final NamedElement pElem1, final NamedElement pElem2) {
      super(pQname, pElem1, pElem2);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
