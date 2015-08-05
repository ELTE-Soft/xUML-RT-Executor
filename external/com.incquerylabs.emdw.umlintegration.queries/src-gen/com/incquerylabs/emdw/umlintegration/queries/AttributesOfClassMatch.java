package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.AttributesOfClassQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.attributesOfClass pattern,
 * to be used in conjunction with {@link AttributesOfClassMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AttributesOfClassMatcher
 * @see AttributesOfClassProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AttributesOfClassMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCl;
  
  private Property fAttribute;
  
  private static List<String> parameterNames = makeImmutableList("cl", "attribute");
  
  private AttributesOfClassMatch(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute) {
    this.fCl = pCl;
    this.fAttribute = pAttribute;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cl".equals(parameterName)) return this.fCl;
    if ("attribute".equals(parameterName)) return this.fAttribute;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getCl() {
    return this.fCl;
  }
  
  public Property getAttribute() {
    return this.fAttribute;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cl".equals(parameterName) ) {
    	this.fCl = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("attribute".equals(parameterName) ) {
    	this.fAttribute = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCl(final org.eclipse.uml2.uml.Class pCl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCl = pCl;
  }
  
  public void setAttribute(final Property pAttribute) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAttribute = pAttribute;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.attributesOfClass";
  }
  
  @Override
  public List<String> parameterNames() {
    return AttributesOfClassMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCl, fAttribute};
  }
  
  @Override
  public AttributesOfClassMatch toImmutable() {
    return isMutable() ? newMatch(fCl, fAttribute) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cl\"=" + prettyPrintValue(fCl) + ", ");
    
    result.append("\"attribute\"=" + prettyPrintValue(fAttribute)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCl == null) ? 0 : fCl.hashCode());
    result = prime * result + ((fAttribute == null) ? 0 : fAttribute.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AttributesOfClassMatch)) { // this should be infrequent
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
    AttributesOfClassMatch other = (AttributesOfClassMatch) obj;
    if (fCl == null) {if (other.fCl != null) return false;}
    else if (!fCl.equals(other.fCl)) return false;
    if (fAttribute == null) {if (other.fAttribute != null) return false;}
    else if (!fAttribute.equals(other.fAttribute)) return false;
    return true;
  }
  
  @Override
  public AttributesOfClassQuerySpecification specification() {
    try {
    	return AttributesOfClassQuerySpecification.instance();
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
  public static AttributesOfClassMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AttributesOfClassMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute) {
    return new Mutable(pCl, pAttribute);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AttributesOfClassMatch newMatch(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute) {
    return new Immutable(pCl, pAttribute);
  }
  
  private static final class Mutable extends AttributesOfClassMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute) {
      super(pCl, pAttribute);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AttributesOfClassMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute) {
      super(pCl, pAttribute);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
