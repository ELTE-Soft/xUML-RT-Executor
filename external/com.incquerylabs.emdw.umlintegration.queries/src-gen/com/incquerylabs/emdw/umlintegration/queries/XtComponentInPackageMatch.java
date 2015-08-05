package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtComponentInPackageQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Component;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtComponentInPackage pattern,
 * to be used in conjunction with {@link XtComponentInPackageMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtComponentInPackageMatcher
 * @see XtComponentInPackageProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtComponentInPackageMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Package fUmlPackage;
  
  private Component fComponent;
  
  private static List<String> parameterNames = makeImmutableList("umlPackage", "component");
  
  private XtComponentInPackageMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent) {
    this.fUmlPackage = pUmlPackage;
    this.fComponent = pComponent;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("umlPackage".equals(parameterName)) return this.fUmlPackage;
    if ("component".equals(parameterName)) return this.fComponent;
    return null;
  }
  
  public org.eclipse.uml2.uml.Package getUmlPackage() {
    return this.fUmlPackage;
  }
  
  public Component getComponent() {
    return this.fComponent;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("umlPackage".equals(parameterName) ) {
    	this.fUmlPackage = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    if ("component".equals(parameterName) ) {
    	this.fComponent = (org.eclipse.uml2.uml.Component) newValue;
    	return true;
    }
    return false;
  }
  
  public void setUmlPackage(final org.eclipse.uml2.uml.Package pUmlPackage) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlPackage = pUmlPackage;
  }
  
  public void setComponent(final Component pComponent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fComponent = pComponent;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtComponentInPackage";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtComponentInPackageMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fUmlPackage, fComponent};
  }
  
  @Override
  public XtComponentInPackageMatch toImmutable() {
    return isMutable() ? newMatch(fUmlPackage, fComponent) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"umlPackage\"=" + prettyPrintValue(fUmlPackage) + ", ");
    
    result.append("\"component\"=" + prettyPrintValue(fComponent)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fUmlPackage == null) ? 0 : fUmlPackage.hashCode());
    result = prime * result + ((fComponent == null) ? 0 : fComponent.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtComponentInPackageMatch)) { // this should be infrequent
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
    XtComponentInPackageMatch other = (XtComponentInPackageMatch) obj;
    if (fUmlPackage == null) {if (other.fUmlPackage != null) return false;}
    else if (!fUmlPackage.equals(other.fUmlPackage)) return false;
    if (fComponent == null) {if (other.fComponent != null) return false;}
    else if (!fComponent.equals(other.fComponent)) return false;
    return true;
  }
  
  @Override
  public XtComponentInPackageQuerySpecification specification() {
    try {
    	return XtComponentInPackageQuerySpecification.instance();
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
  public static XtComponentInPackageMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtComponentInPackageMatch newMutableMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent) {
    return new Mutable(pUmlPackage, pComponent);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtComponentInPackageMatch newMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent) {
    return new Immutable(pUmlPackage, pComponent);
  }
  
  private static final class Mutable extends XtComponentInPackageMatch {
    Mutable(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent) {
      super(pUmlPackage, pComponent);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtComponentInPackageMatch {
    Immutable(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent) {
      super(pUmlPackage, pComponent);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
