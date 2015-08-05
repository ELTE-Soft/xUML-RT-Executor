package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtPackageInPackageQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtPackageInPackage pattern,
 * to be used in conjunction with {@link XtPackageInPackageMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtPackageInPackageMatcher
 * @see XtPackageInPackageProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtPackageInPackageMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Package fParent;
  
  private org.eclipse.uml2.uml.Package fChild;
  
  private static List<String> parameterNames = makeImmutableList("parent", "child");
  
  private XtPackageInPackageMatch(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild) {
    this.fParent = pParent;
    this.fChild = pChild;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("parent".equals(parameterName)) return this.fParent;
    if ("child".equals(parameterName)) return this.fChild;
    return null;
  }
  
  public org.eclipse.uml2.uml.Package getParent() {
    return this.fParent;
  }
  
  public org.eclipse.uml2.uml.Package getChild() {
    return this.fChild;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("parent".equals(parameterName) ) {
    	this.fParent = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    if ("child".equals(parameterName) ) {
    	this.fChild = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    return false;
  }
  
  public void setParent(final org.eclipse.uml2.uml.Package pParent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParent = pParent;
  }
  
  public void setChild(final org.eclipse.uml2.uml.Package pChild) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fChild = pChild;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtPackageInPackage";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtPackageInPackageMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fParent, fChild};
  }
  
  @Override
  public XtPackageInPackageMatch toImmutable() {
    return isMutable() ? newMatch(fParent, fChild) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"parent\"=" + prettyPrintValue(fParent) + ", ");
    
    result.append("\"child\"=" + prettyPrintValue(fChild)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fParent == null) ? 0 : fParent.hashCode());
    result = prime * result + ((fChild == null) ? 0 : fChild.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtPackageInPackageMatch)) { // this should be infrequent
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
    XtPackageInPackageMatch other = (XtPackageInPackageMatch) obj;
    if (fParent == null) {if (other.fParent != null) return false;}
    else if (!fParent.equals(other.fParent)) return false;
    if (fChild == null) {if (other.fChild != null) return false;}
    else if (!fChild.equals(other.fChild)) return false;
    return true;
  }
  
  @Override
  public XtPackageInPackageQuerySpecification specification() {
    try {
    	return XtPackageInPackageQuerySpecification.instance();
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
  public static XtPackageInPackageMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtPackageInPackageMatch newMutableMatch(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild) {
    return new Mutable(pParent, pChild);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtPackageInPackageMatch newMatch(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild) {
    return new Immutable(pParent, pChild);
  }
  
  private static final class Mutable extends XtPackageInPackageMatch {
    Mutable(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild) {
      super(pParent, pChild);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtPackageInPackageMatch {
    Immutable(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild) {
      super(pParent, pChild);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
