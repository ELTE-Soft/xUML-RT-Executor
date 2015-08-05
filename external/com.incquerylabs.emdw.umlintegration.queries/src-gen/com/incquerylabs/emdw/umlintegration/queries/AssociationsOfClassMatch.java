package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.AssociationsOfClassQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.associationsOfClass pattern,
 * to be used in conjunction with {@link AssociationsOfClassMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AssociationsOfClassMatcher
 * @see AssociationsOfClassProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationsOfClassMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCl;
  
  private Property fAssociation;
  
  private static List<String> parameterNames = makeImmutableList("cl", "association");
  
  private AssociationsOfClassMatch(final org.eclipse.uml2.uml.Class pCl, final Property pAssociation) {
    this.fCl = pCl;
    this.fAssociation = pAssociation;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cl".equals(parameterName)) return this.fCl;
    if ("association".equals(parameterName)) return this.fAssociation;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getCl() {
    return this.fCl;
  }
  
  public Property getAssociation() {
    return this.fAssociation;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cl".equals(parameterName) ) {
    	this.fCl = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("association".equals(parameterName) ) {
    	this.fAssociation = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCl(final org.eclipse.uml2.uml.Class pCl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCl = pCl;
  }
  
  public void setAssociation(final Property pAssociation) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAssociation = pAssociation;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.associationsOfClass";
  }
  
  @Override
  public List<String> parameterNames() {
    return AssociationsOfClassMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCl, fAssociation};
  }
  
  @Override
  public AssociationsOfClassMatch toImmutable() {
    return isMutable() ? newMatch(fCl, fAssociation) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cl\"=" + prettyPrintValue(fCl) + ", ");
    
    result.append("\"association\"=" + prettyPrintValue(fAssociation)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCl == null) ? 0 : fCl.hashCode());
    result = prime * result + ((fAssociation == null) ? 0 : fAssociation.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AssociationsOfClassMatch)) { // this should be infrequent
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
    AssociationsOfClassMatch other = (AssociationsOfClassMatch) obj;
    if (fCl == null) {if (other.fCl != null) return false;}
    else if (!fCl.equals(other.fCl)) return false;
    if (fAssociation == null) {if (other.fAssociation != null) return false;}
    else if (!fAssociation.equals(other.fAssociation)) return false;
    return true;
  }
  
  @Override
  public AssociationsOfClassQuerySpecification specification() {
    try {
    	return AssociationsOfClassQuerySpecification.instance();
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
  public static AssociationsOfClassMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AssociationsOfClassMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCl, final Property pAssociation) {
    return new Mutable(pCl, pAssociation);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AssociationsOfClassMatch newMatch(final org.eclipse.uml2.uml.Class pCl, final Property pAssociation) {
    return new Immutable(pCl, pAssociation);
  }
  
  private static final class Mutable extends AssociationsOfClassMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCl, final Property pAssociation) {
      super(pCl, pAssociation);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AssociationsOfClassMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCl, final Property pAssociation) {
      super(pCl, pAssociation);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
