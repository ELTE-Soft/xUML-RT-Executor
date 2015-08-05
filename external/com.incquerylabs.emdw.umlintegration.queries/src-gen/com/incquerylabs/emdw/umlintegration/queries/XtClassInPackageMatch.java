package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtClassInPackageQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtClassInPackage pattern,
 * to be used in conjunction with {@link XtClassInPackageMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtClassInPackageMatcher
 * @see XtClassInPackageProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtClassInPackageMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Package fUmlPackage;
  
  private org.eclipse.uml2.uml.Class fUmlClass;
  
  private static List<String> parameterNames = makeImmutableList("umlPackage", "umlClass");
  
  private XtClassInPackageMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final org.eclipse.uml2.uml.Class pUmlClass) {
    this.fUmlPackage = pUmlPackage;
    this.fUmlClass = pUmlClass;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("umlPackage".equals(parameterName)) return this.fUmlPackage;
    if ("umlClass".equals(parameterName)) return this.fUmlClass;
    return null;
  }
  
  public org.eclipse.uml2.uml.Package getUmlPackage() {
    return this.fUmlPackage;
  }
  
  public org.eclipse.uml2.uml.Class getUmlClass() {
    return this.fUmlClass;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("umlPackage".equals(parameterName) ) {
    	this.fUmlPackage = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    if ("umlClass".equals(parameterName) ) {
    	this.fUmlClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setUmlPackage(final org.eclipse.uml2.uml.Package pUmlPackage) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlPackage = pUmlPackage;
  }
  
  public void setUmlClass(final org.eclipse.uml2.uml.Class pUmlClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlClass = pUmlClass;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtClassInPackage";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtClassInPackageMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fUmlPackage, fUmlClass};
  }
  
  @Override
  public XtClassInPackageMatch toImmutable() {
    return isMutable() ? newMatch(fUmlPackage, fUmlClass) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"umlPackage\"=" + prettyPrintValue(fUmlPackage) + ", ");
    
    result.append("\"umlClass\"=" + prettyPrintValue(fUmlClass)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fUmlPackage == null) ? 0 : fUmlPackage.hashCode());
    result = prime * result + ((fUmlClass == null) ? 0 : fUmlClass.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtClassInPackageMatch)) { // this should be infrequent
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
    XtClassInPackageMatch other = (XtClassInPackageMatch) obj;
    if (fUmlPackage == null) {if (other.fUmlPackage != null) return false;}
    else if (!fUmlPackage.equals(other.fUmlPackage)) return false;
    if (fUmlClass == null) {if (other.fUmlClass != null) return false;}
    else if (!fUmlClass.equals(other.fUmlClass)) return false;
    return true;
  }
  
  @Override
  public XtClassInPackageQuerySpecification specification() {
    try {
    	return XtClassInPackageQuerySpecification.instance();
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
  public static XtClassInPackageMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtClassInPackageMatch newMutableMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final org.eclipse.uml2.uml.Class pUmlClass) {
    return new Mutable(pUmlPackage, pUmlClass);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtClassInPackageMatch newMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final org.eclipse.uml2.uml.Class pUmlClass) {
    return new Immutable(pUmlPackage, pUmlClass);
  }
  
  private static final class Mutable extends XtClassInPackageMatch {
    Mutable(final org.eclipse.uml2.uml.Package pUmlPackage, final org.eclipse.uml2.uml.Class pUmlClass) {
      super(pUmlPackage, pUmlClass);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtClassInPackageMatch {
    Immutable(final org.eclipse.uml2.uml.Package pUmlPackage, final org.eclipse.uml2.uml.Class pUmlClass) {
      super(pUmlPackage, pUmlClass);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
