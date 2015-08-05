package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.NamedDataTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.DataType;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.namedDataType pattern,
 * to be used in conjunction with {@link NamedDataTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see NamedDataTypeMatcher
 * @see NamedDataTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class NamedDataTypeMatch extends BasePatternMatch {
  private DataType fDataType;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("dataType", "name");
  
  private NamedDataTypeMatch(final DataType pDataType, final String pName) {
    this.fDataType = pDataType;
    this.fName = pName;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("dataType".equals(parameterName)) return this.fDataType;
    if ("name".equals(parameterName)) return this.fName;
    return null;
  }
  
  public DataType getDataType() {
    return this.fDataType;
  }
  
  public String getName() {
    return this.fName;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("dataType".equals(parameterName) ) {
    	this.fDataType = (org.eclipse.uml2.uml.DataType) newValue;
    	return true;
    }
    if ("name".equals(parameterName) ) {
    	this.fName = (java.lang.String) newValue;
    	return true;
    }
    return false;
  }
  
  public void setDataType(final DataType pDataType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fDataType = pDataType;
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.namedDataType";
  }
  
  @Override
  public List<String> parameterNames() {
    return NamedDataTypeMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fDataType, fName};
  }
  
  @Override
  public NamedDataTypeMatch toImmutable() {
    return isMutable() ? newMatch(fDataType, fName) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"dataType\"=" + prettyPrintValue(fDataType) + ", ");
    
    result.append("\"name\"=" + prettyPrintValue(fName)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fDataType == null) ? 0 : fDataType.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof NamedDataTypeMatch)) { // this should be infrequent
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
    NamedDataTypeMatch other = (NamedDataTypeMatch) obj;
    if (fDataType == null) {if (other.fDataType != null) return false;}
    else if (!fDataType.equals(other.fDataType)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  @Override
  public NamedDataTypeQuerySpecification specification() {
    try {
    	return NamedDataTypeQuerySpecification.instance();
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
  public static NamedDataTypeMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pDataType the fixed value of pattern parameter dataType, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static NamedDataTypeMatch newMutableMatch(final DataType pDataType, final String pName) {
    return new Mutable(pDataType, pName);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pDataType the fixed value of pattern parameter dataType, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static NamedDataTypeMatch newMatch(final DataType pDataType, final String pName) {
    return new Immutable(pDataType, pName);
  }
  
  private static final class Mutable extends NamedDataTypeMatch {
    Mutable(final DataType pDataType, final String pName) {
      super(pDataType, pName);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends NamedDataTypeMatch {
    Immutable(final DataType pDataType, final String pName) {
      super(pDataType, pName);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
