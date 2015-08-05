package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.EnumerationLiteralQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.enumerationLiteral pattern,
 * to be used in conjunction with {@link EnumerationLiteralMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EnumerationLiteralMatcher
 * @see EnumerationLiteralProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EnumerationLiteralMatch extends BasePatternMatch {
  private Enumeration fEnumeration;
  
  private EnumerationLiteral fEnumerationLiteral;
  
  private static List<String> parameterNames = makeImmutableList("enumeration", "enumerationLiteral");
  
  private EnumerationLiteralMatch(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral) {
    this.fEnumeration = pEnumeration;
    this.fEnumerationLiteral = pEnumerationLiteral;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("enumeration".equals(parameterName)) return this.fEnumeration;
    if ("enumerationLiteral".equals(parameterName)) return this.fEnumerationLiteral;
    return null;
  }
  
  public Enumeration getEnumeration() {
    return this.fEnumeration;
  }
  
  public EnumerationLiteral getEnumerationLiteral() {
    return this.fEnumerationLiteral;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("enumeration".equals(parameterName) ) {
    	this.fEnumeration = (org.eclipse.uml2.uml.Enumeration) newValue;
    	return true;
    }
    if ("enumerationLiteral".equals(parameterName) ) {
    	this.fEnumerationLiteral = (org.eclipse.uml2.uml.EnumerationLiteral) newValue;
    	return true;
    }
    return false;
  }
  
  public void setEnumeration(final Enumeration pEnumeration) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEnumeration = pEnumeration;
  }
  
  public void setEnumerationLiteral(final EnumerationLiteral pEnumerationLiteral) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEnumerationLiteral = pEnumerationLiteral;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.enumerationLiteral";
  }
  
  @Override
  public List<String> parameterNames() {
    return EnumerationLiteralMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fEnumeration, fEnumerationLiteral};
  }
  
  @Override
  public EnumerationLiteralMatch toImmutable() {
    return isMutable() ? newMatch(fEnumeration, fEnumerationLiteral) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"enumeration\"=" + prettyPrintValue(fEnumeration) + ", ");
    
    result.append("\"enumerationLiteral\"=" + prettyPrintValue(fEnumerationLiteral)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fEnumeration == null) ? 0 : fEnumeration.hashCode());
    result = prime * result + ((fEnumerationLiteral == null) ? 0 : fEnumerationLiteral.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EnumerationLiteralMatch)) { // this should be infrequent
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
    EnumerationLiteralMatch other = (EnumerationLiteralMatch) obj;
    if (fEnumeration == null) {if (other.fEnumeration != null) return false;}
    else if (!fEnumeration.equals(other.fEnumeration)) return false;
    if (fEnumerationLiteral == null) {if (other.fEnumerationLiteral != null) return false;}
    else if (!fEnumerationLiteral.equals(other.fEnumerationLiteral)) return false;
    return true;
  }
  
  @Override
  public EnumerationLiteralQuerySpecification specification() {
    try {
    	return EnumerationLiteralQuerySpecification.instance();
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
  public static EnumerationLiteralMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pEnumeration the fixed value of pattern parameter enumeration, or null if not bound.
   * @param pEnumerationLiteral the fixed value of pattern parameter enumerationLiteral, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static EnumerationLiteralMatch newMutableMatch(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral) {
    return new Mutable(pEnumeration, pEnumerationLiteral);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEnumeration the fixed value of pattern parameter enumeration, or null if not bound.
   * @param pEnumerationLiteral the fixed value of pattern parameter enumerationLiteral, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static EnumerationLiteralMatch newMatch(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral) {
    return new Immutable(pEnumeration, pEnumerationLiteral);
  }
  
  private static final class Mutable extends EnumerationLiteralMatch {
    Mutable(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral) {
      super(pEnumeration, pEnumerationLiteral);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends EnumerationLiteralMatch {
    Immutable(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral) {
      super(pEnumeration, pEnumerationLiteral);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
