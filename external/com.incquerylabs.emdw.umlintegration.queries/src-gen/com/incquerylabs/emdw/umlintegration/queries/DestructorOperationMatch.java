package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.DestructorOperationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Operation;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.destructorOperation pattern,
 * to be used in conjunction with {@link DestructorOperationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see DestructorOperationMatcher
 * @see DestructorOperationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class DestructorOperationMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fUmlClass;
  
  private Operation fOperation;
  
  private static List<String> parameterNames = makeImmutableList("umlClass", "operation");
  
  private DestructorOperationMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation) {
    this.fUmlClass = pUmlClass;
    this.fOperation = pOperation;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("umlClass".equals(parameterName)) return this.fUmlClass;
    if ("operation".equals(parameterName)) return this.fOperation;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getUmlClass() {
    return this.fUmlClass;
  }
  
  public Operation getOperation() {
    return this.fOperation;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("umlClass".equals(parameterName) ) {
    	this.fUmlClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("operation".equals(parameterName) ) {
    	this.fOperation = (org.eclipse.uml2.uml.Operation) newValue;
    	return true;
    }
    return false;
  }
  
  public void setUmlClass(final org.eclipse.uml2.uml.Class pUmlClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlClass = pUmlClass;
  }
  
  public void setOperation(final Operation pOperation) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOperation = pOperation;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.destructorOperation";
  }
  
  @Override
  public List<String> parameterNames() {
    return DestructorOperationMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fUmlClass, fOperation};
  }
  
  @Override
  public DestructorOperationMatch toImmutable() {
    return isMutable() ? newMatch(fUmlClass, fOperation) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"umlClass\"=" + prettyPrintValue(fUmlClass) + ", ");
    
    result.append("\"operation\"=" + prettyPrintValue(fOperation)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fUmlClass == null) ? 0 : fUmlClass.hashCode());
    result = prime * result + ((fOperation == null) ? 0 : fOperation.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof DestructorOperationMatch)) { // this should be infrequent
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
    DestructorOperationMatch other = (DestructorOperationMatch) obj;
    if (fUmlClass == null) {if (other.fUmlClass != null) return false;}
    else if (!fUmlClass.equals(other.fUmlClass)) return false;
    if (fOperation == null) {if (other.fOperation != null) return false;}
    else if (!fOperation.equals(other.fOperation)) return false;
    return true;
  }
  
  @Override
  public DestructorOperationQuerySpecification specification() {
    try {
    	return DestructorOperationQuerySpecification.instance();
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
  public static DestructorOperationMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static DestructorOperationMatch newMutableMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation) {
    return new Mutable(pUmlClass, pOperation);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static DestructorOperationMatch newMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation) {
    return new Immutable(pUmlClass, pOperation);
  }
  
  private static final class Mutable extends DestructorOperationMatch {
    Mutable(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation) {
      super(pUmlClass, pOperation);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends DestructorOperationMatch {
    Immutable(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation) {
      super(pUmlClass, pOperation);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
