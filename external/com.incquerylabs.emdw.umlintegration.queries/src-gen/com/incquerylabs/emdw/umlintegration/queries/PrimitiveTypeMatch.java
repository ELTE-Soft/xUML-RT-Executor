package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.PrimitiveTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.PrimitiveType;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.primitiveType pattern,
 * to be used in conjunction with {@link PrimitiveTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PrimitiveTypeMatcher
 * @see PrimitiveTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PrimitiveTypeMatch extends BasePatternMatch {
  private PrimitiveType fPrimitiveType;
  
  private static List<String> parameterNames = makeImmutableList("primitiveType");
  
  private PrimitiveTypeMatch(final PrimitiveType pPrimitiveType) {
    this.fPrimitiveType = pPrimitiveType;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("primitiveType".equals(parameterName)) return this.fPrimitiveType;
    return null;
  }
  
  public PrimitiveType getPrimitiveType() {
    return this.fPrimitiveType;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("primitiveType".equals(parameterName) ) {
    	this.fPrimitiveType = (org.eclipse.uml2.uml.PrimitiveType) newValue;
    	return true;
    }
    return false;
  }
  
  public void setPrimitiveType(final PrimitiveType pPrimitiveType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPrimitiveType = pPrimitiveType;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.primitiveType";
  }
  
  @Override
  public List<String> parameterNames() {
    return PrimitiveTypeMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPrimitiveType};
  }
  
  @Override
  public PrimitiveTypeMatch toImmutable() {
    return isMutable() ? newMatch(fPrimitiveType) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"primitiveType\"=" + prettyPrintValue(fPrimitiveType)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPrimitiveType == null) ? 0 : fPrimitiveType.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PrimitiveTypeMatch)) { // this should be infrequent
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
    PrimitiveTypeMatch other = (PrimitiveTypeMatch) obj;
    if (fPrimitiveType == null) {if (other.fPrimitiveType != null) return false;}
    else if (!fPrimitiveType.equals(other.fPrimitiveType)) return false;
    return true;
  }
  
  @Override
  public PrimitiveTypeQuerySpecification specification() {
    try {
    	return PrimitiveTypeQuerySpecification.instance();
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
  public static PrimitiveTypeMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pPrimitiveType the fixed value of pattern parameter primitiveType, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PrimitiveTypeMatch newMutableMatch(final PrimitiveType pPrimitiveType) {
    return new Mutable(pPrimitiveType);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPrimitiveType the fixed value of pattern parameter primitiveType, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PrimitiveTypeMatch newMatch(final PrimitiveType pPrimitiveType) {
    return new Immutable(pPrimitiveType);
  }
  
  private static final class Mutable extends PrimitiveTypeMatch {
    Mutable(final PrimitiveType pPrimitiveType) {
      super(pPrimitiveType);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PrimitiveTypeMatch {
    Immutable(final PrimitiveType pPrimitiveType) {
      super(pPrimitiveType);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
