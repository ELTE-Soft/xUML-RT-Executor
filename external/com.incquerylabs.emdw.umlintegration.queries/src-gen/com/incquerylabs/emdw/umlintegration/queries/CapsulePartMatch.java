package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.CapsulePartQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.capsulePart pattern,
 * to be used in conjunction with {@link CapsulePartMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see CapsulePartMatcher
 * @see CapsulePartProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class CapsulePartMatch extends BasePatternMatch {
  private Component fComponent;
  
  private Property fProperty;
  
  private static List<String> parameterNames = makeImmutableList("component", "property");
  
  private CapsulePartMatch(final Component pComponent, final Property pProperty) {
    this.fComponent = pComponent;
    this.fProperty = pProperty;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("component".equals(parameterName)) return this.fComponent;
    if ("property".equals(parameterName)) return this.fProperty;
    return null;
  }
  
  public Component getComponent() {
    return this.fComponent;
  }
  
  public Property getProperty() {
    return this.fProperty;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("component".equals(parameterName) ) {
    	this.fComponent = (org.eclipse.uml2.uml.Component) newValue;
    	return true;
    }
    if ("property".equals(parameterName) ) {
    	this.fProperty = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
  }
  
  public void setComponent(final Component pComponent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fComponent = pComponent;
  }
  
  public void setProperty(final Property pProperty) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fProperty = pProperty;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.capsulePart";
  }
  
  @Override
  public List<String> parameterNames() {
    return CapsulePartMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fComponent, fProperty};
  }
  
  @Override
  public CapsulePartMatch toImmutable() {
    return isMutable() ? newMatch(fComponent, fProperty) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"component\"=" + prettyPrintValue(fComponent) + ", ");
    
    result.append("\"property\"=" + prettyPrintValue(fProperty)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fComponent == null) ? 0 : fComponent.hashCode());
    result = prime * result + ((fProperty == null) ? 0 : fProperty.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof CapsulePartMatch)) { // this should be infrequent
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
    CapsulePartMatch other = (CapsulePartMatch) obj;
    if (fComponent == null) {if (other.fComponent != null) return false;}
    else if (!fComponent.equals(other.fComponent)) return false;
    if (fProperty == null) {if (other.fProperty != null) return false;}
    else if (!fProperty.equals(other.fProperty)) return false;
    return true;
  }
  
  @Override
  public CapsulePartQuerySpecification specification() {
    try {
    	return CapsulePartQuerySpecification.instance();
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
  public static CapsulePartMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static CapsulePartMatch newMutableMatch(final Component pComponent, final Property pProperty) {
    return new Mutable(pComponent, pProperty);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static CapsulePartMatch newMatch(final Component pComponent, final Property pProperty) {
    return new Immutable(pComponent, pProperty);
  }
  
  private static final class Mutable extends CapsulePartMatch {
    Mutable(final Component pComponent, final Property pProperty) {
      super(pComponent, pProperty);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends CapsulePartMatch {
    Immutable(final Component pComponent, final Property pProperty) {
      super(pComponent, pProperty);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
