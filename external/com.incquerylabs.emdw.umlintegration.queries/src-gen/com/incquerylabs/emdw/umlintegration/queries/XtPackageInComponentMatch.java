package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtPackageInComponentQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Component;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtPackageInComponent pattern,
 * to be used in conjunction with {@link XtPackageInComponentMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtPackageInComponentMatcher
 * @see XtPackageInComponentProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtPackageInComponentMatch extends BasePatternMatch {
  private Component fComponent;
  
  private org.eclipse.uml2.uml.Package fUmlPackage;
  
  private static List<String> parameterNames = makeImmutableList("component", "umlPackage");
  
  private XtPackageInComponentMatch(final Component pComponent, final org.eclipse.uml2.uml.Package pUmlPackage) {
    this.fComponent = pComponent;
    this.fUmlPackage = pUmlPackage;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("component".equals(parameterName)) return this.fComponent;
    if ("umlPackage".equals(parameterName)) return this.fUmlPackage;
    return null;
  }
  
  public Component getComponent() {
    return this.fComponent;
  }
  
  public org.eclipse.uml2.uml.Package getUmlPackage() {
    return this.fUmlPackage;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("component".equals(parameterName) ) {
    	this.fComponent = (org.eclipse.uml2.uml.Component) newValue;
    	return true;
    }
    if ("umlPackage".equals(parameterName) ) {
    	this.fUmlPackage = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    return false;
  }
  
  public void setComponent(final Component pComponent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fComponent = pComponent;
  }
  
  public void setUmlPackage(final org.eclipse.uml2.uml.Package pUmlPackage) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlPackage = pUmlPackage;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtPackageInComponent";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtPackageInComponentMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fComponent, fUmlPackage};
  }
  
  @Override
  public XtPackageInComponentMatch toImmutable() {
    return isMutable() ? newMatch(fComponent, fUmlPackage) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"component\"=" + prettyPrintValue(fComponent) + ", ");
    
    result.append("\"umlPackage\"=" + prettyPrintValue(fUmlPackage)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fComponent == null) ? 0 : fComponent.hashCode());
    result = prime * result + ((fUmlPackage == null) ? 0 : fUmlPackage.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtPackageInComponentMatch)) { // this should be infrequent
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
    XtPackageInComponentMatch other = (XtPackageInComponentMatch) obj;
    if (fComponent == null) {if (other.fComponent != null) return false;}
    else if (!fComponent.equals(other.fComponent)) return false;
    if (fUmlPackage == null) {if (other.fUmlPackage != null) return false;}
    else if (!fUmlPackage.equals(other.fUmlPackage)) return false;
    return true;
  }
  
  @Override
  public XtPackageInComponentQuerySpecification specification() {
    try {
    	return XtPackageInComponentQuerySpecification.instance();
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
  public static XtPackageInComponentMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtPackageInComponentMatch newMutableMatch(final Component pComponent, final org.eclipse.uml2.uml.Package pUmlPackage) {
    return new Mutable(pComponent, pUmlPackage);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtPackageInComponentMatch newMatch(final Component pComponent, final org.eclipse.uml2.uml.Package pUmlPackage) {
    return new Immutable(pComponent, pUmlPackage);
  }
  
  private static final class Mutable extends XtPackageInComponentMatch {
    Mutable(final Component pComponent, final org.eclipse.uml2.uml.Package pUmlPackage) {
      super(pComponent, pUmlPackage);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtPackageInComponentMatch {
    Immutable(final Component pComponent, final org.eclipse.uml2.uml.Package pUmlPackage) {
      super(pComponent, pUmlPackage);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
