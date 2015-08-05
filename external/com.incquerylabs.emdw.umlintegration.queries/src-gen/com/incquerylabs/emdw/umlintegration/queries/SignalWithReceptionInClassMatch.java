package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.SignalWithReceptionInClassQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.signalWithReceptionInClass pattern,
 * to be used in conjunction with {@link SignalWithReceptionInClassMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SignalWithReceptionInClassMatcher
 * @see SignalWithReceptionInClassProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SignalWithReceptionInClassMatch extends BasePatternMatch {
  private Signal fSignal;
  
  private Reception fReception;
  
  private org.eclipse.uml2.uml.Class fUmlClass;
  
  private static List<String> parameterNames = makeImmutableList("signal", "reception", "umlClass");
  
  private SignalWithReceptionInClassMatch(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass) {
    this.fSignal = pSignal;
    this.fReception = pReception;
    this.fUmlClass = pUmlClass;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("signal".equals(parameterName)) return this.fSignal;
    if ("reception".equals(parameterName)) return this.fReception;
    if ("umlClass".equals(parameterName)) return this.fUmlClass;
    return null;
  }
  
  public Signal getSignal() {
    return this.fSignal;
  }
  
  public Reception getReception() {
    return this.fReception;
  }
  
  public org.eclipse.uml2.uml.Class getUmlClass() {
    return this.fUmlClass;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("signal".equals(parameterName) ) {
    	this.fSignal = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    if ("reception".equals(parameterName) ) {
    	this.fReception = (org.eclipse.uml2.uml.Reception) newValue;
    	return true;
    }
    if ("umlClass".equals(parameterName) ) {
    	this.fUmlClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSignal(final Signal pSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignal = pSignal;
  }
  
  public void setReception(final Reception pReception) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fReception = pReception;
  }
  
  public void setUmlClass(final org.eclipse.uml2.uml.Class pUmlClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlClass = pUmlClass;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.signalWithReceptionInClass";
  }
  
  @Override
  public List<String> parameterNames() {
    return SignalWithReceptionInClassMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSignal, fReception, fUmlClass};
  }
  
  @Override
  public SignalWithReceptionInClassMatch toImmutable() {
    return isMutable() ? newMatch(fSignal, fReception, fUmlClass) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"signal\"=" + prettyPrintValue(fSignal) + ", ");
    
    result.append("\"reception\"=" + prettyPrintValue(fReception) + ", ");
    
    result.append("\"umlClass\"=" + prettyPrintValue(fUmlClass)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    result = prime * result + ((fReception == null) ? 0 : fReception.hashCode());
    result = prime * result + ((fUmlClass == null) ? 0 : fUmlClass.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SignalWithReceptionInClassMatch)) { // this should be infrequent
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
    SignalWithReceptionInClassMatch other = (SignalWithReceptionInClassMatch) obj;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    if (fReception == null) {if (other.fReception != null) return false;}
    else if (!fReception.equals(other.fReception)) return false;
    if (fUmlClass == null) {if (other.fUmlClass != null) return false;}
    else if (!fUmlClass.equals(other.fUmlClass)) return false;
    return true;
  }
  
  @Override
  public SignalWithReceptionInClassQuerySpecification specification() {
    try {
    	return SignalWithReceptionInClassQuerySpecification.instance();
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
  public static SignalWithReceptionInClassMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SignalWithReceptionInClassMatch newMutableMatch(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass) {
    return new Mutable(pSignal, pReception, pUmlClass);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SignalWithReceptionInClassMatch newMatch(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass) {
    return new Immutable(pSignal, pReception, pUmlClass);
  }
  
  private static final class Mutable extends SignalWithReceptionInClassMatch {
    Mutable(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass) {
      super(pSignal, pReception, pUmlClass);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SignalWithReceptionInClassMatch {
    Immutable(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass) {
      super(pSignal, pReception, pUmlClass);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
