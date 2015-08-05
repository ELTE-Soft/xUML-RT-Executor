package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.TypeDefinitionInPackageQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Type;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.typeDefinitionInPackage pattern,
 * to be used in conjunction with {@link TypeDefinitionInPackageMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TypeDefinitionInPackageMatcher
 * @see TypeDefinitionInPackageProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TypeDefinitionInPackageMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Package fUmlPackage;
  
  private Type fType;
  
  private static List<String> parameterNames = makeImmutableList("umlPackage", "type");
  
  private TypeDefinitionInPackageMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final Type pType) {
    this.fUmlPackage = pUmlPackage;
    this.fType = pType;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("umlPackage".equals(parameterName)) return this.fUmlPackage;
    if ("type".equals(parameterName)) return this.fType;
    return null;
  }
  
  public org.eclipse.uml2.uml.Package getUmlPackage() {
    return this.fUmlPackage;
  }
  
  public Type getType() {
    return this.fType;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("umlPackage".equals(parameterName) ) {
    	this.fUmlPackage = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    if ("type".equals(parameterName) ) {
    	this.fType = (org.eclipse.uml2.uml.Type) newValue;
    	return true;
    }
    return false;
  }
  
  public void setUmlPackage(final org.eclipse.uml2.uml.Package pUmlPackage) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlPackage = pUmlPackage;
  }
  
  public void setType(final Type pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.typeDefinitionInPackage";
  }
  
  @Override
  public List<String> parameterNames() {
    return TypeDefinitionInPackageMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fUmlPackage, fType};
  }
  
  @Override
  public TypeDefinitionInPackageMatch toImmutable() {
    return isMutable() ? newMatch(fUmlPackage, fType) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"umlPackage\"=" + prettyPrintValue(fUmlPackage) + ", ");
    
    result.append("\"type\"=" + prettyPrintValue(fType)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fUmlPackage == null) ? 0 : fUmlPackage.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TypeDefinitionInPackageMatch)) { // this should be infrequent
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
    TypeDefinitionInPackageMatch other = (TypeDefinitionInPackageMatch) obj;
    if (fUmlPackage == null) {if (other.fUmlPackage != null) return false;}
    else if (!fUmlPackage.equals(other.fUmlPackage)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    return true;
  }
  
  @Override
  public TypeDefinitionInPackageQuerySpecification specification() {
    try {
    	return TypeDefinitionInPackageQuerySpecification.instance();
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
  public static TypeDefinitionInPackageMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TypeDefinitionInPackageMatch newMutableMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final Type pType) {
    return new Mutable(pUmlPackage, pType);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TypeDefinitionInPackageMatch newMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final Type pType) {
    return new Immutable(pUmlPackage, pType);
  }
  
  private static final class Mutable extends TypeDefinitionInPackageMatch {
    Mutable(final org.eclipse.uml2.uml.Package pUmlPackage, final Type pType) {
      super(pUmlPackage, pType);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TypeDefinitionInPackageMatch {
    Immutable(final org.eclipse.uml2.uml.Package pUmlPackage, final Type pType) {
      super(pUmlPackage, pType);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
