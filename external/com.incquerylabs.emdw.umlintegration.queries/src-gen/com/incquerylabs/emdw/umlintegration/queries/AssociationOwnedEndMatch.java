package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.AssociationOwnedEndQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.associationOwnedEnd pattern,
 * to be used in conjunction with {@link AssociationOwnedEndMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AssociationOwnedEndMatcher
 * @see AssociationOwnedEndProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationOwnedEndMatch extends BasePatternMatch {
  private Association fAssociation;
  
  private Property fOwnedEnd;
  
  private static List<String> parameterNames = makeImmutableList("association", "ownedEnd");
  
  private AssociationOwnedEndMatch(final Association pAssociation, final Property pOwnedEnd) {
    this.fAssociation = pAssociation;
    this.fOwnedEnd = pOwnedEnd;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("association".equals(parameterName)) return this.fAssociation;
    if ("ownedEnd".equals(parameterName)) return this.fOwnedEnd;
    return null;
  }
  
  public Association getAssociation() {
    return this.fAssociation;
  }
  
  public Property getOwnedEnd() {
    return this.fOwnedEnd;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("association".equals(parameterName) ) {
    	this.fAssociation = (org.eclipse.uml2.uml.Association) newValue;
    	return true;
    }
    if ("ownedEnd".equals(parameterName) ) {
    	this.fOwnedEnd = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
  }
  
  public void setAssociation(final Association pAssociation) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAssociation = pAssociation;
  }
  
  public void setOwnedEnd(final Property pOwnedEnd) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOwnedEnd = pOwnedEnd;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.associationOwnedEnd";
  }
  
  @Override
  public List<String> parameterNames() {
    return AssociationOwnedEndMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fAssociation, fOwnedEnd};
  }
  
  @Override
  public AssociationOwnedEndMatch toImmutable() {
    return isMutable() ? newMatch(fAssociation, fOwnedEnd) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"association\"=" + prettyPrintValue(fAssociation) + ", ");
    
    result.append("\"ownedEnd\"=" + prettyPrintValue(fOwnedEnd)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fAssociation == null) ? 0 : fAssociation.hashCode());
    result = prime * result + ((fOwnedEnd == null) ? 0 : fOwnedEnd.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AssociationOwnedEndMatch)) { // this should be infrequent
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
    AssociationOwnedEndMatch other = (AssociationOwnedEndMatch) obj;
    if (fAssociation == null) {if (other.fAssociation != null) return false;}
    else if (!fAssociation.equals(other.fAssociation)) return false;
    if (fOwnedEnd == null) {if (other.fOwnedEnd != null) return false;}
    else if (!fOwnedEnd.equals(other.fOwnedEnd)) return false;
    return true;
  }
  
  @Override
  public AssociationOwnedEndQuerySpecification specification() {
    try {
    	return AssociationOwnedEndQuerySpecification.instance();
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
  public static AssociationOwnedEndMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pOwnedEnd the fixed value of pattern parameter ownedEnd, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AssociationOwnedEndMatch newMutableMatch(final Association pAssociation, final Property pOwnedEnd) {
    return new Mutable(pAssociation, pOwnedEnd);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pOwnedEnd the fixed value of pattern parameter ownedEnd, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AssociationOwnedEndMatch newMatch(final Association pAssociation, final Property pOwnedEnd) {
    return new Immutable(pAssociation, pOwnedEnd);
  }
  
  private static final class Mutable extends AssociationOwnedEndMatch {
    Mutable(final Association pAssociation, final Property pOwnedEnd) {
      super(pAssociation, pOwnedEnd);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AssociationOwnedEndMatch {
    Immutable(final Association pAssociation, final Property pOwnedEnd) {
      super(pAssociation, pOwnedEnd);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
