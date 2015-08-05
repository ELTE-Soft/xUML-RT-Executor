package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.StructTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.DataType;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.structType pattern,
 * to be used in conjunction with {@link StructTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StructTypeMatcher
 * @see StructTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StructTypeMatch extends BasePatternMatch {
  private DataType fStructType;
  
  private static List<String> parameterNames = makeImmutableList("structType");
  
  private StructTypeMatch(final DataType pStructType) {
    this.fStructType = pStructType;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("structType".equals(parameterName)) return this.fStructType;
    return null;
  }
  
  public DataType getStructType() {
    return this.fStructType;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("structType".equals(parameterName) ) {
    	this.fStructType = (org.eclipse.uml2.uml.DataType) newValue;
    	return true;
    }
    return false;
  }
  
  public void setStructType(final DataType pStructType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fStructType = pStructType;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.structType";
  }
  
  @Override
  public List<String> parameterNames() {
    return StructTypeMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fStructType};
  }
  
  @Override
  public StructTypeMatch toImmutable() {
    return isMutable() ? newMatch(fStructType) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"structType\"=" + prettyPrintValue(fStructType)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fStructType == null) ? 0 : fStructType.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StructTypeMatch)) { // this should be infrequent
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
    StructTypeMatch other = (StructTypeMatch) obj;
    if (fStructType == null) {if (other.fStructType != null) return false;}
    else if (!fStructType.equals(other.fStructType)) return false;
    return true;
  }
  
  @Override
  public StructTypeQuerySpecification specification() {
    try {
    	return StructTypeQuerySpecification.instance();
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
  public static StructTypeMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StructTypeMatch newMutableMatch(final DataType pStructType) {
    return new Mutable(pStructType);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static StructTypeMatch newMatch(final DataType pStructType) {
    return new Immutable(pStructType);
  }
  
  private static final class Mutable extends StructTypeMatch {
    Mutable(final DataType pStructType) {
      super(pStructType);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StructTypeMatch {
    Immutable(final DataType pStructType) {
      super(pStructType);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
