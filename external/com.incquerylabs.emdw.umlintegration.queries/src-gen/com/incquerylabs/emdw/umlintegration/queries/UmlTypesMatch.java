package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.UmlTypesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Type;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.umlTypes pattern,
 * to be used in conjunction with {@link UmlTypesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see UmlTypesMatcher
 * @see UmlTypesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class UmlTypesMatch extends BasePatternMatch {
  private Type fType;
  
  private static List<String> parameterNames = makeImmutableList("type");
  
  private UmlTypesMatch(final Type pType) {
    this.fType = pType;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("type".equals(parameterName)) return this.fType;
    return null;
  }
  
  public Type getType() {
    return this.fType;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("type".equals(parameterName) ) {
    	this.fType = (org.eclipse.uml2.uml.Type) newValue;
    	return true;
    }
    return false;
  }
  
  public void setType(final Type pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.umlTypes";
  }
  
  @Override
  public List<String> parameterNames() {
    return UmlTypesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fType};
  }
  
  @Override
  public UmlTypesMatch toImmutable() {
    return isMutable() ? newMatch(fType) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"type\"=" + prettyPrintValue(fType)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof UmlTypesMatch)) { // this should be infrequent
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
    UmlTypesMatch other = (UmlTypesMatch) obj;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    return true;
  }
  
  @Override
  public UmlTypesQuerySpecification specification() {
    try {
    	return UmlTypesQuerySpecification.instance();
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
  public static UmlTypesMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static UmlTypesMatch newMutableMatch(final Type pType) {
    return new Mutable(pType);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static UmlTypesMatch newMatch(final Type pType) {
    return new Immutable(pType);
  }
  
  private static final class Mutable extends UmlTypesMatch {
    Mutable(final Type pType) {
      super(pType);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends UmlTypesMatch {
    Immutable(final Type pType) {
      super(pType);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
