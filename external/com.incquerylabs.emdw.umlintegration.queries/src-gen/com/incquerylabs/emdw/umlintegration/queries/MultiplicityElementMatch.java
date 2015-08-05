package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.MultiplicityElementQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.multiplicityElement pattern,
 * to be used in conjunction with {@link MultiplicityElementMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MultiplicityElementMatcher
 * @see MultiplicityElementProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MultiplicityElementMatch extends BasePatternMatch {
  private MultiplicityElement fMultiplicityElement;
  
  private ValueSpecification fLowerValue;
  
  private ValueSpecification fUpperValue;
  
  private static List<String> parameterNames = makeImmutableList("multiplicityElement", "lowerValue", "upperValue");
  
  private MultiplicityElementMatch(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue) {
    this.fMultiplicityElement = pMultiplicityElement;
    this.fLowerValue = pLowerValue;
    this.fUpperValue = pUpperValue;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("multiplicityElement".equals(parameterName)) return this.fMultiplicityElement;
    if ("lowerValue".equals(parameterName)) return this.fLowerValue;
    if ("upperValue".equals(parameterName)) return this.fUpperValue;
    return null;
  }
  
  public MultiplicityElement getMultiplicityElement() {
    return this.fMultiplicityElement;
  }
  
  public ValueSpecification getLowerValue() {
    return this.fLowerValue;
  }
  
  public ValueSpecification getUpperValue() {
    return this.fUpperValue;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("multiplicityElement".equals(parameterName) ) {
    	this.fMultiplicityElement = (org.eclipse.uml2.uml.MultiplicityElement) newValue;
    	return true;
    }
    if ("lowerValue".equals(parameterName) ) {
    	this.fLowerValue = (org.eclipse.uml2.uml.ValueSpecification) newValue;
    	return true;
    }
    if ("upperValue".equals(parameterName) ) {
    	this.fUpperValue = (org.eclipse.uml2.uml.ValueSpecification) newValue;
    	return true;
    }
    return false;
  }
  
  public void setMultiplicityElement(final MultiplicityElement pMultiplicityElement) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMultiplicityElement = pMultiplicityElement;
  }
  
  public void setLowerValue(final ValueSpecification pLowerValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLowerValue = pLowerValue;
  }
  
  public void setUpperValue(final ValueSpecification pUpperValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUpperValue = pUpperValue;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.multiplicityElement";
  }
  
  @Override
  public List<String> parameterNames() {
    return MultiplicityElementMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fMultiplicityElement, fLowerValue, fUpperValue};
  }
  
  @Override
  public MultiplicityElementMatch toImmutable() {
    return isMutable() ? newMatch(fMultiplicityElement, fLowerValue, fUpperValue) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"multiplicityElement\"=" + prettyPrintValue(fMultiplicityElement) + ", ");
    
    result.append("\"lowerValue\"=" + prettyPrintValue(fLowerValue) + ", ");
    
    result.append("\"upperValue\"=" + prettyPrintValue(fUpperValue)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fMultiplicityElement == null) ? 0 : fMultiplicityElement.hashCode());
    result = prime * result + ((fLowerValue == null) ? 0 : fLowerValue.hashCode());
    result = prime * result + ((fUpperValue == null) ? 0 : fUpperValue.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MultiplicityElementMatch)) { // this should be infrequent
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
    MultiplicityElementMatch other = (MultiplicityElementMatch) obj;
    if (fMultiplicityElement == null) {if (other.fMultiplicityElement != null) return false;}
    else if (!fMultiplicityElement.equals(other.fMultiplicityElement)) return false;
    if (fLowerValue == null) {if (other.fLowerValue != null) return false;}
    else if (!fLowerValue.equals(other.fLowerValue)) return false;
    if (fUpperValue == null) {if (other.fUpperValue != null) return false;}
    else if (!fUpperValue.equals(other.fUpperValue)) return false;
    return true;
  }
  
  @Override
  public MultiplicityElementQuerySpecification specification() {
    try {
    	return MultiplicityElementQuerySpecification.instance();
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
  public static MultiplicityElementMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pMultiplicityElement the fixed value of pattern parameter multiplicityElement, or null if not bound.
   * @param pLowerValue the fixed value of pattern parameter lowerValue, or null if not bound.
   * @param pUpperValue the fixed value of pattern parameter upperValue, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MultiplicityElementMatch newMutableMatch(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue) {
    return new Mutable(pMultiplicityElement, pLowerValue, pUpperValue);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pMultiplicityElement the fixed value of pattern parameter multiplicityElement, or null if not bound.
   * @param pLowerValue the fixed value of pattern parameter lowerValue, or null if not bound.
   * @param pUpperValue the fixed value of pattern parameter upperValue, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static MultiplicityElementMatch newMatch(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue) {
    return new Immutable(pMultiplicityElement, pLowerValue, pUpperValue);
  }
  
  private static final class Mutable extends MultiplicityElementMatch {
    Mutable(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue) {
      super(pMultiplicityElement, pLowerValue, pUpperValue);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MultiplicityElementMatch {
    Immutable(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue) {
      super(pMultiplicityElement, pLowerValue, pUpperValue);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
