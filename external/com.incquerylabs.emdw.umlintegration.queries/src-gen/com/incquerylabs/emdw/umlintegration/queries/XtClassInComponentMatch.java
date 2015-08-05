package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtClassInComponentQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Component;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtClassInComponent pattern,
 * to be used in conjunction with {@link XtClassInComponentMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtClassInComponentMatcher
 * @see XtClassInComponentProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtClassInComponentMatch extends BasePatternMatch {
  private Component fComponent;
  
  private org.eclipse.uml2.uml.Class fUmlClass;
  
  private static List<String> parameterNames = makeImmutableList("component", "umlClass");
  
  private XtClassInComponentMatch(final Component pComponent, final org.eclipse.uml2.uml.Class pUmlClass) {
    this.fComponent = pComponent;
    this.fUmlClass = pUmlClass;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("component".equals(parameterName)) return this.fComponent;
    if ("umlClass".equals(parameterName)) return this.fUmlClass;
    return null;
  }
  
  public Component getComponent() {
    return this.fComponent;
  }
  
  public org.eclipse.uml2.uml.Class getUmlClass() {
    return this.fUmlClass;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("component".equals(parameterName) ) {
    	this.fComponent = (org.eclipse.uml2.uml.Component) newValue;
    	return true;
    }
    if ("umlClass".equals(parameterName) ) {
    	this.fUmlClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setComponent(final Component pComponent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fComponent = pComponent;
  }
  
  public void setUmlClass(final org.eclipse.uml2.uml.Class pUmlClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlClass = pUmlClass;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtClassInComponent";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtClassInComponentMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fComponent, fUmlClass};
  }
  
  @Override
  public XtClassInComponentMatch toImmutable() {
    return isMutable() ? newMatch(fComponent, fUmlClass) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"component\"=" + prettyPrintValue(fComponent) + ", ");
    
    result.append("\"umlClass\"=" + prettyPrintValue(fUmlClass)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fComponent == null) ? 0 : fComponent.hashCode());
    result = prime * result + ((fUmlClass == null) ? 0 : fUmlClass.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtClassInComponentMatch)) { // this should be infrequent
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
    XtClassInComponentMatch other = (XtClassInComponentMatch) obj;
    if (fComponent == null) {if (other.fComponent != null) return false;}
    else if (!fComponent.equals(other.fComponent)) return false;
    if (fUmlClass == null) {if (other.fUmlClass != null) return false;}
    else if (!fUmlClass.equals(other.fUmlClass)) return false;
    return true;
  }
  
  @Override
  public XtClassInComponentQuerySpecification specification() {
    try {
    	return XtClassInComponentQuerySpecification.instance();
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
  public static XtClassInComponentMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtClassInComponentMatch newMutableMatch(final Component pComponent, final org.eclipse.uml2.uml.Class pUmlClass) {
    return new Mutable(pComponent, pUmlClass);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtClassInComponentMatch newMatch(final Component pComponent, final org.eclipse.uml2.uml.Class pUmlClass) {
    return new Immutable(pComponent, pUmlClass);
  }
  
  private static final class Mutable extends XtClassInComponentMatch {
    Mutable(final Component pComponent, final org.eclipse.uml2.uml.Class pUmlClass) {
      super(pComponent, pUmlClass);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtClassInComponentMatch {
    Immutable(final Component pComponent, final org.eclipse.uml2.uml.Class pUmlClass) {
      super(pComponent, pUmlClass);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
