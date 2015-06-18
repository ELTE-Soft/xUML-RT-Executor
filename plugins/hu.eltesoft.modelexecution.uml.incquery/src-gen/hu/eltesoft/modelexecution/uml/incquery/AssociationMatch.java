package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.AssociationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Association;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Association pattern,
 * to be used in conjunction with {@link AssociationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AssociationMatcher
 * @see AssociationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationMatch extends BasePatternMatch {
  private Association fAssociation;
  
  private static List<String> parameterNames = makeImmutableList("association");
  
  private AssociationMatch(final Association pAssociation) {
    this.fAssociation = pAssociation;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("association".equals(parameterName)) return this.fAssociation;
    return null;
    
  }
  
  public Association getAssociation() {
    return this.fAssociation;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("association".equals(parameterName) ) {
    	this.fAssociation = (org.eclipse.uml2.uml.Association) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setAssociation(final Association pAssociation) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAssociation = pAssociation;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Association";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return AssociationMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fAssociation};
    
  }
  
  @Override
  public AssociationMatch toImmutable() {
    return isMutable() ? newMatch(fAssociation) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"association\"=" + prettyPrintValue(fAssociation));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fAssociation == null) ? 0 : fAssociation.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AssociationMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    AssociationMatch other = (AssociationMatch) obj;
    if (fAssociation == null) {if (other.fAssociation != null) return false;}
    else if (!fAssociation.equals(other.fAssociation)) return false;
    return true;
  }
  
  @Override
  public AssociationQuerySpecification specification() {
    try {
    	return AssociationQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static AssociationMatch newEmptyMatch() {
    return new Mutable(null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AssociationMatch newMutableMatch(final Association pAssociation) {
    return new Mutable(pAssociation);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AssociationMatch newMatch(final Association pAssociation) {
    return new Immutable(pAssociation);
    
  }
  
  private static final class Mutable extends AssociationMatch {
    Mutable(final Association pAssociation) {
      super(pAssociation);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AssociationMatch {
    Immutable(final Association pAssociation) {
      super(pAssociation);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
