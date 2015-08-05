package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.EnumerationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Enumeration;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.enumeration pattern,
 * to be used in conjunction with {@link EnumerationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EnumerationMatcher
 * @see EnumerationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EnumerationMatch extends BasePatternMatch {
  private Enumeration fEnumeration;
  
  private static List<String> parameterNames = makeImmutableList("enumeration");
  
  private EnumerationMatch(final Enumeration pEnumeration) {
    this.fEnumeration = pEnumeration;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("enumeration".equals(parameterName)) return this.fEnumeration;
    return null;
  }
  
  public Enumeration getEnumeration() {
    return this.fEnumeration;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("enumeration".equals(parameterName) ) {
    	this.fEnumeration = (org.eclipse.uml2.uml.Enumeration) newValue;
    	return true;
    }
    return false;
  }
  
  public void setEnumeration(final Enumeration pEnumeration) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEnumeration = pEnumeration;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.enumeration";
  }
  
  @Override
  public List<String> parameterNames() {
    return EnumerationMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fEnumeration};
  }
  
  @Override
  public EnumerationMatch toImmutable() {
    return isMutable() ? newMatch(fEnumeration) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"enumeration\"=" + prettyPrintValue(fEnumeration)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fEnumeration == null) ? 0 : fEnumeration.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EnumerationMatch)) { // this should be infrequent
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
    EnumerationMatch other = (EnumerationMatch) obj;
    if (fEnumeration == null) {if (other.fEnumeration != null) return false;}
    else if (!fEnumeration.equals(other.fEnumeration)) return false;
    return true;
  }
  
  @Override
  public EnumerationQuerySpecification specification() {
    try {
    	return EnumerationQuerySpecification.instance();
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
  public static EnumerationMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pEnumeration the fixed value of pattern parameter enumeration, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static EnumerationMatch newMutableMatch(final Enumeration pEnumeration) {
    return new Mutable(pEnumeration);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEnumeration the fixed value of pattern parameter enumeration, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static EnumerationMatch newMatch(final Enumeration pEnumeration) {
    return new Immutable(pEnumeration);
  }
  
  private static final class Mutable extends EnumerationMatch {
    Mutable(final Enumeration pEnumeration) {
      super(pEnumeration);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends EnumerationMatch {
    Immutable(final Enumeration pEnumeration) {
      super(pEnumeration);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
