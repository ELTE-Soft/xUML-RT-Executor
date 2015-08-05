package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.SignalAttributeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.signalAttribute pattern,
 * to be used in conjunction with {@link SignalAttributeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SignalAttributeMatcher
 * @see SignalAttributeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SignalAttributeMatch extends BasePatternMatch {
  private Signal fUmlSignal;
  
  private Property fProperty;
  
  private static List<String> parameterNames = makeImmutableList("umlSignal", "property");
  
  private SignalAttributeMatch(final Signal pUmlSignal, final Property pProperty) {
    this.fUmlSignal = pUmlSignal;
    this.fProperty = pProperty;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("umlSignal".equals(parameterName)) return this.fUmlSignal;
    if ("property".equals(parameterName)) return this.fProperty;
    return null;
  }
  
  public Signal getUmlSignal() {
    return this.fUmlSignal;
  }
  
  public Property getProperty() {
    return this.fProperty;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("umlSignal".equals(parameterName) ) {
    	this.fUmlSignal = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    if ("property".equals(parameterName) ) {
    	this.fProperty = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
  }
  
  public void setUmlSignal(final Signal pUmlSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlSignal = pUmlSignal;
  }
  
  public void setProperty(final Property pProperty) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fProperty = pProperty;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.signalAttribute";
  }
  
  @Override
  public List<String> parameterNames() {
    return SignalAttributeMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fUmlSignal, fProperty};
  }
  
  @Override
  public SignalAttributeMatch toImmutable() {
    return isMutable() ? newMatch(fUmlSignal, fProperty) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"umlSignal\"=" + prettyPrintValue(fUmlSignal) + ", ");
    
    result.append("\"property\"=" + prettyPrintValue(fProperty)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fUmlSignal == null) ? 0 : fUmlSignal.hashCode());
    result = prime * result + ((fProperty == null) ? 0 : fProperty.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SignalAttributeMatch)) { // this should be infrequent
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
    SignalAttributeMatch other = (SignalAttributeMatch) obj;
    if (fUmlSignal == null) {if (other.fUmlSignal != null) return false;}
    else if (!fUmlSignal.equals(other.fUmlSignal)) return false;
    if (fProperty == null) {if (other.fProperty != null) return false;}
    else if (!fProperty.equals(other.fProperty)) return false;
    return true;
  }
  
  @Override
  public SignalAttributeQuerySpecification specification() {
    try {
    	return SignalAttributeQuerySpecification.instance();
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
  public static SignalAttributeMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pUmlSignal the fixed value of pattern parameter umlSignal, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SignalAttributeMatch newMutableMatch(final Signal pUmlSignal, final Property pProperty) {
    return new Mutable(pUmlSignal, pProperty);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlSignal the fixed value of pattern parameter umlSignal, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SignalAttributeMatch newMatch(final Signal pUmlSignal, final Property pProperty) {
    return new Immutable(pUmlSignal, pProperty);
  }
  
  private static final class Mutable extends SignalAttributeMatch {
    Mutable(final Signal pUmlSignal, final Property pProperty) {
      super(pUmlSignal, pProperty);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SignalAttributeMatch {
    Immutable(final Signal pUmlSignal, final Property pProperty) {
      super(pUmlSignal, pProperty);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
