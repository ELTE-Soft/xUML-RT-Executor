package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.StructTypeInPackageQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.DataType;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.structTypeInPackage pattern,
 * to be used in conjunction with {@link StructTypeInPackageMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StructTypeInPackageMatcher
 * @see StructTypeInPackageProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StructTypeInPackageMatch extends BasePatternMatch {
  private DataType fStructType;
  
  private org.eclipse.uml2.uml.Package fUmlPackage;
  
  private static List<String> parameterNames = makeImmutableList("structType", "umlPackage");
  
  private StructTypeInPackageMatch(final DataType pStructType, final org.eclipse.uml2.uml.Package pUmlPackage) {
    this.fStructType = pStructType;
    this.fUmlPackage = pUmlPackage;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("structType".equals(parameterName)) return this.fStructType;
    if ("umlPackage".equals(parameterName)) return this.fUmlPackage;
    return null;
  }
  
  public DataType getStructType() {
    return this.fStructType;
  }
  
  public org.eclipse.uml2.uml.Package getUmlPackage() {
    return this.fUmlPackage;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("structType".equals(parameterName) ) {
    	this.fStructType = (org.eclipse.uml2.uml.DataType) newValue;
    	return true;
    }
    if ("umlPackage".equals(parameterName) ) {
    	this.fUmlPackage = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    return false;
  }
  
  public void setStructType(final DataType pStructType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fStructType = pStructType;
  }
  
  public void setUmlPackage(final org.eclipse.uml2.uml.Package pUmlPackage) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlPackage = pUmlPackage;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.structTypeInPackage";
  }
  
  @Override
  public List<String> parameterNames() {
    return StructTypeInPackageMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fStructType, fUmlPackage};
  }
  
  @Override
  public StructTypeInPackageMatch toImmutable() {
    return isMutable() ? newMatch(fStructType, fUmlPackage) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"structType\"=" + prettyPrintValue(fStructType) + ", ");
    
    result.append("\"umlPackage\"=" + prettyPrintValue(fUmlPackage)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fStructType == null) ? 0 : fStructType.hashCode());
    result = prime * result + ((fUmlPackage == null) ? 0 : fUmlPackage.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StructTypeInPackageMatch)) { // this should be infrequent
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
    StructTypeInPackageMatch other = (StructTypeInPackageMatch) obj;
    if (fStructType == null) {if (other.fStructType != null) return false;}
    else if (!fStructType.equals(other.fStructType)) return false;
    if (fUmlPackage == null) {if (other.fUmlPackage != null) return false;}
    else if (!fUmlPackage.equals(other.fUmlPackage)) return false;
    return true;
  }
  
  @Override
  public StructTypeInPackageQuerySpecification specification() {
    try {
    	return StructTypeInPackageQuerySpecification.instance();
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
  public static StructTypeInPackageMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StructTypeInPackageMatch newMutableMatch(final DataType pStructType, final org.eclipse.uml2.uml.Package pUmlPackage) {
    return new Mutable(pStructType, pUmlPackage);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static StructTypeInPackageMatch newMatch(final DataType pStructType, final org.eclipse.uml2.uml.Package pUmlPackage) {
    return new Immutable(pStructType, pUmlPackage);
  }
  
  private static final class Mutable extends StructTypeInPackageMatch {
    Mutable(final DataType pStructType, final org.eclipse.uml2.uml.Package pUmlPackage) {
      super(pStructType, pUmlPackage);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StructTypeInPackageMatch {
    Immutable(final DataType pStructType, final org.eclipse.uml2.uml.Package pUmlPackage) {
      super(pStructType, pUmlPackage);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
