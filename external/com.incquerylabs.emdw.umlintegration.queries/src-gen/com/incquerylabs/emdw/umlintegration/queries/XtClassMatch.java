package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtClassQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtClass pattern,
 * to be used in conjunction with {@link XtClassMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtClassMatcher
 * @see XtClassProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtClassMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fUmlClass;
  
  private static List<String> parameterNames = makeImmutableList("umlClass");
  
  private XtClassMatch(final org.eclipse.uml2.uml.Class pUmlClass) {
    this.fUmlClass = pUmlClass;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("umlClass".equals(parameterName)) return this.fUmlClass;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getUmlClass() {
    return this.fUmlClass;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("umlClass".equals(parameterName) ) {
    	this.fUmlClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setUmlClass(final org.eclipse.uml2.uml.Class pUmlClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlClass = pUmlClass;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtClass";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtClassMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fUmlClass};
  }
  
  @Override
  public XtClassMatch toImmutable() {
    return isMutable() ? newMatch(fUmlClass) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"umlClass\"=" + prettyPrintValue(fUmlClass)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fUmlClass == null) ? 0 : fUmlClass.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtClassMatch)) { // this should be infrequent
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
    XtClassMatch other = (XtClassMatch) obj;
    if (fUmlClass == null) {if (other.fUmlClass != null) return false;}
    else if (!fUmlClass.equals(other.fUmlClass)) return false;
    return true;
  }
  
  @Override
  public XtClassQuerySpecification specification() {
    try {
    	return XtClassQuerySpecification.instance();
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
  public static XtClassMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtClassMatch newMutableMatch(final org.eclipse.uml2.uml.Class pUmlClass) {
    return new Mutable(pUmlClass);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtClassMatch newMatch(final org.eclipse.uml2.uml.Class pUmlClass) {
    return new Immutable(pUmlClass);
  }
  
  private static final class Mutable extends XtClassMatch {
    Mutable(final org.eclipse.uml2.uml.Class pUmlClass) {
      super(pUmlClass);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtClassMatch {
    Immutable(final org.eclipse.uml2.uml.Class pUmlClass) {
      super(pUmlClass);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
