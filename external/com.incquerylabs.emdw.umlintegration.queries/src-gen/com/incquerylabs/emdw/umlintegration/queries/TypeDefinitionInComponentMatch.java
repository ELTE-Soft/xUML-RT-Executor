package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.TypeDefinitionInComponentQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Type;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.typeDefinitionInComponent pattern,
 * to be used in conjunction with {@link TypeDefinitionInComponentMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TypeDefinitionInComponentMatcher
 * @see TypeDefinitionInComponentProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TypeDefinitionInComponentMatch extends BasePatternMatch {
  private Component fUmlComponent;
  
  private Type fType;
  
  private static List<String> parameterNames = makeImmutableList("umlComponent", "type");
  
  private TypeDefinitionInComponentMatch(final Component pUmlComponent, final Type pType) {
    this.fUmlComponent = pUmlComponent;
    this.fType = pType;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("umlComponent".equals(parameterName)) return this.fUmlComponent;
    if ("type".equals(parameterName)) return this.fType;
    return null;
  }
  
  public Component getUmlComponent() {
    return this.fUmlComponent;
  }
  
  public Type getType() {
    return this.fType;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("umlComponent".equals(parameterName) ) {
    	this.fUmlComponent = (org.eclipse.uml2.uml.Component) newValue;
    	return true;
    }
    if ("type".equals(parameterName) ) {
    	this.fType = (org.eclipse.uml2.uml.Type) newValue;
    	return true;
    }
    return false;
  }
  
  public void setUmlComponent(final Component pUmlComponent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlComponent = pUmlComponent;
  }
  
  public void setType(final Type pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.typeDefinitionInComponent";
  }
  
  @Override
  public List<String> parameterNames() {
    return TypeDefinitionInComponentMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fUmlComponent, fType};
  }
  
  @Override
  public TypeDefinitionInComponentMatch toImmutable() {
    return isMutable() ? newMatch(fUmlComponent, fType) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"umlComponent\"=" + prettyPrintValue(fUmlComponent) + ", ");
    
    result.append("\"type\"=" + prettyPrintValue(fType)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fUmlComponent == null) ? 0 : fUmlComponent.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TypeDefinitionInComponentMatch)) { // this should be infrequent
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
    TypeDefinitionInComponentMatch other = (TypeDefinitionInComponentMatch) obj;
    if (fUmlComponent == null) {if (other.fUmlComponent != null) return false;}
    else if (!fUmlComponent.equals(other.fUmlComponent)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    return true;
  }
  
  @Override
  public TypeDefinitionInComponentQuerySpecification specification() {
    try {
    	return TypeDefinitionInComponentQuerySpecification.instance();
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
  public static TypeDefinitionInComponentMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TypeDefinitionInComponentMatch newMutableMatch(final Component pUmlComponent, final Type pType) {
    return new Mutable(pUmlComponent, pType);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TypeDefinitionInComponentMatch newMatch(final Component pUmlComponent, final Type pType) {
    return new Immutable(pUmlComponent, pType);
  }
  
  private static final class Mutable extends TypeDefinitionInComponentMatch {
    Mutable(final Component pUmlComponent, final Type pType) {
      super(pUmlComponent, pType);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TypeDefinitionInComponentMatch {
    Immutable(final Component pUmlComponent, final Type pType) {
      super(pUmlComponent, pType);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
