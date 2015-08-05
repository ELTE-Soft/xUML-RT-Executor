package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtClassEventQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtClassEvent pattern,
 * to be used in conjunction with {@link XtClassEventMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtClassEventMatcher
 * @see XtClassEventProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtClassEventMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fUmlClass;
  
  private Signal fSignal;
  
  private static List<String> parameterNames = makeImmutableList("umlClass", "signal");
  
  private XtClassEventMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal) {
    this.fUmlClass = pUmlClass;
    this.fSignal = pSignal;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("umlClass".equals(parameterName)) return this.fUmlClass;
    if ("signal".equals(parameterName)) return this.fSignal;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getUmlClass() {
    return this.fUmlClass;
  }
  
  public Signal getSignal() {
    return this.fSignal;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("umlClass".equals(parameterName) ) {
    	this.fUmlClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("signal".equals(parameterName) ) {
    	this.fSignal = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    return false;
  }
  
  public void setUmlClass(final org.eclipse.uml2.uml.Class pUmlClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlClass = pUmlClass;
  }
  
  public void setSignal(final Signal pSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignal = pSignal;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtClassEvent";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtClassEventMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fUmlClass, fSignal};
  }
  
  @Override
  public XtClassEventMatch toImmutable() {
    return isMutable() ? newMatch(fUmlClass, fSignal) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"umlClass\"=" + prettyPrintValue(fUmlClass) + ", ");
    
    result.append("\"signal\"=" + prettyPrintValue(fSignal)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fUmlClass == null) ? 0 : fUmlClass.hashCode());
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtClassEventMatch)) { // this should be infrequent
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
    XtClassEventMatch other = (XtClassEventMatch) obj;
    if (fUmlClass == null) {if (other.fUmlClass != null) return false;}
    else if (!fUmlClass.equals(other.fUmlClass)) return false;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    return true;
  }
  
  @Override
  public XtClassEventQuerySpecification specification() {
    try {
    	return XtClassEventQuerySpecification.instance();
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
  public static XtClassEventMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtClassEventMatch newMutableMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal) {
    return new Mutable(pUmlClass, pSignal);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtClassEventMatch newMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal) {
    return new Immutable(pUmlClass, pSignal);
  }
  
  private static final class Mutable extends XtClassEventMatch {
    Mutable(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal) {
      super(pUmlClass, pSignal);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtClassEventMatch {
    Immutable(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal) {
      super(pUmlClass, pSignal);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
