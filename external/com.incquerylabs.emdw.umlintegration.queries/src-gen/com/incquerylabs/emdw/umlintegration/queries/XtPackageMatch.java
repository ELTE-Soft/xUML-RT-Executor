package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtPackageQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtPackage pattern,
 * to be used in conjunction with {@link XtPackageMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtPackageMatcher
 * @see XtPackageProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtPackageMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Package fUmlPackage;
  
  private static List<String> parameterNames = makeImmutableList("umlPackage");
  
  private XtPackageMatch(final org.eclipse.uml2.uml.Package pUmlPackage) {
    this.fUmlPackage = pUmlPackage;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("umlPackage".equals(parameterName)) return this.fUmlPackage;
    return null;
  }
  
  public org.eclipse.uml2.uml.Package getUmlPackage() {
    return this.fUmlPackage;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("umlPackage".equals(parameterName) ) {
    	this.fUmlPackage = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    return false;
  }
  
  public void setUmlPackage(final org.eclipse.uml2.uml.Package pUmlPackage) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlPackage = pUmlPackage;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtPackage";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtPackageMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fUmlPackage};
  }
  
  @Override
  public XtPackageMatch toImmutable() {
    return isMutable() ? newMatch(fUmlPackage) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"umlPackage\"=" + prettyPrintValue(fUmlPackage)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fUmlPackage == null) ? 0 : fUmlPackage.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtPackageMatch)) { // this should be infrequent
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
    XtPackageMatch other = (XtPackageMatch) obj;
    if (fUmlPackage == null) {if (other.fUmlPackage != null) return false;}
    else if (!fUmlPackage.equals(other.fUmlPackage)) return false;
    return true;
  }
  
  @Override
  public XtPackageQuerySpecification specification() {
    try {
    	return XtPackageQuerySpecification.instance();
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
  public static XtPackageMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtPackageMatch newMutableMatch(final org.eclipse.uml2.uml.Package pUmlPackage) {
    return new Mutable(pUmlPackage);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtPackageMatch newMatch(final org.eclipse.uml2.uml.Package pUmlPackage) {
    return new Immutable(pUmlPackage);
  }
  
  private static final class Mutable extends XtPackageMatch {
    Mutable(final org.eclipse.uml2.uml.Package pUmlPackage) {
      super(pUmlPackage);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtPackageMatch {
    Immutable(final org.eclipse.uml2.uml.Package pUmlPackage) {
      super(pUmlPackage);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
