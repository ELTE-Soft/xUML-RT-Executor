package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.AttributeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.attribute pattern,
 * to be used in conjunction with {@link AttributeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AttributeMatcher
 * @see AttributeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AttributeMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fUmlClass;
  
  private Property fProperty;
  
  private static List<String> parameterNames = makeImmutableList("umlClass", "property");
  
  private AttributeMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Property pProperty) {
    this.fUmlClass = pUmlClass;
    this.fProperty = pProperty;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("umlClass".equals(parameterName)) return this.fUmlClass;
    if ("property".equals(parameterName)) return this.fProperty;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getUmlClass() {
    return this.fUmlClass;
  }
  
  public Property getProperty() {
    return this.fProperty;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("umlClass".equals(parameterName) ) {
    	this.fUmlClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("property".equals(parameterName) ) {
    	this.fProperty = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
  }
  
  public void setUmlClass(final org.eclipse.uml2.uml.Class pUmlClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlClass = pUmlClass;
  }
  
  public void setProperty(final Property pProperty) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fProperty = pProperty;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.attribute";
  }
  
  @Override
  public List<String> parameterNames() {
    return AttributeMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fUmlClass, fProperty};
  }
  
  @Override
  public AttributeMatch toImmutable() {
    return isMutable() ? newMatch(fUmlClass, fProperty) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"umlClass\"=" + prettyPrintValue(fUmlClass) + ", ");
    
    result.append("\"property\"=" + prettyPrintValue(fProperty)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fUmlClass == null) ? 0 : fUmlClass.hashCode());
    result = prime * result + ((fProperty == null) ? 0 : fProperty.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AttributeMatch)) { // this should be infrequent
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
    AttributeMatch other = (AttributeMatch) obj;
    if (fUmlClass == null) {if (other.fUmlClass != null) return false;}
    else if (!fUmlClass.equals(other.fUmlClass)) return false;
    if (fProperty == null) {if (other.fProperty != null) return false;}
    else if (!fProperty.equals(other.fProperty)) return false;
    return true;
  }
  
  @Override
  public AttributeQuerySpecification specification() {
    try {
    	return AttributeQuerySpecification.instance();
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
  public static AttributeMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AttributeMatch newMutableMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Property pProperty) {
    return new Mutable(pUmlClass, pProperty);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AttributeMatch newMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Property pProperty) {
    return new Immutable(pUmlClass, pProperty);
  }
  
  private static final class Mutable extends AttributeMatch {
    Mutable(final org.eclipse.uml2.uml.Class pUmlClass, final Property pProperty) {
      super(pUmlClass, pProperty);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AttributeMatch {
    Immutable(final org.eclipse.uml2.uml.Class pUmlClass, final Property pProperty) {
      super(pUmlClass, pProperty);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
