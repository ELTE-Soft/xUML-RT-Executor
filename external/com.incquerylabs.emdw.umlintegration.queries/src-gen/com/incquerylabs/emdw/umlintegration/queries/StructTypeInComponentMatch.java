package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.StructTypeInComponentQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.structTypeInComponent pattern,
 * to be used in conjunction with {@link StructTypeInComponentMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StructTypeInComponentMatcher
 * @see StructTypeInComponentProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StructTypeInComponentMatch extends BasePatternMatch {
  private DataType fStructType;
  
  private Component fUmlComponent;
  
  private static List<String> parameterNames = makeImmutableList("structType", "umlComponent");
  
  private StructTypeInComponentMatch(final DataType pStructType, final Component pUmlComponent) {
    this.fStructType = pStructType;
    this.fUmlComponent = pUmlComponent;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("structType".equals(parameterName)) return this.fStructType;
    if ("umlComponent".equals(parameterName)) return this.fUmlComponent;
    return null;
  }
  
  public DataType getStructType() {
    return this.fStructType;
  }
  
  public Component getUmlComponent() {
    return this.fUmlComponent;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("structType".equals(parameterName) ) {
    	this.fStructType = (org.eclipse.uml2.uml.DataType) newValue;
    	return true;
    }
    if ("umlComponent".equals(parameterName) ) {
    	this.fUmlComponent = (org.eclipse.uml2.uml.Component) newValue;
    	return true;
    }
    return false;
  }
  
  public void setStructType(final DataType pStructType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fStructType = pStructType;
  }
  
  public void setUmlComponent(final Component pUmlComponent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlComponent = pUmlComponent;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.structTypeInComponent";
  }
  
  @Override
  public List<String> parameterNames() {
    return StructTypeInComponentMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fStructType, fUmlComponent};
  }
  
  @Override
  public StructTypeInComponentMatch toImmutable() {
    return isMutable() ? newMatch(fStructType, fUmlComponent) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"structType\"=" + prettyPrintValue(fStructType) + ", ");
    
    result.append("\"umlComponent\"=" + prettyPrintValue(fUmlComponent)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fStructType == null) ? 0 : fStructType.hashCode());
    result = prime * result + ((fUmlComponent == null) ? 0 : fUmlComponent.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StructTypeInComponentMatch)) { // this should be infrequent
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
    StructTypeInComponentMatch other = (StructTypeInComponentMatch) obj;
    if (fStructType == null) {if (other.fStructType != null) return false;}
    else if (!fStructType.equals(other.fStructType)) return false;
    if (fUmlComponent == null) {if (other.fUmlComponent != null) return false;}
    else if (!fUmlComponent.equals(other.fUmlComponent)) return false;
    return true;
  }
  
  @Override
  public StructTypeInComponentQuerySpecification specification() {
    try {
    	return StructTypeInComponentQuerySpecification.instance();
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
  public static StructTypeInComponentMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StructTypeInComponentMatch newMutableMatch(final DataType pStructType, final Component pUmlComponent) {
    return new Mutable(pStructType, pUmlComponent);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static StructTypeInComponentMatch newMatch(final DataType pStructType, final Component pUmlComponent) {
    return new Immutable(pStructType, pUmlComponent);
  }
  
  private static final class Mutable extends StructTypeInComponentMatch {
    Mutable(final DataType pStructType, final Component pUmlComponent) {
      super(pStructType, pUmlComponent);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StructTypeInComponentMatch {
    Immutable(final DataType pStructType, final Component pUmlComponent) {
      super(pStructType, pUmlComponent);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
