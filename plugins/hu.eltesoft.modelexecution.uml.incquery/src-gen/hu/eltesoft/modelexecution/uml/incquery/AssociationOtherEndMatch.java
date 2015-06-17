package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.AssociationOtherEndQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.AssociationOtherEnd pattern,
 * to be used in conjunction with {@link AssociationOtherEndMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AssociationOtherEndMatcher
 * @see AssociationOtherEndProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationOtherEndMatch extends BasePatternMatch {
  private Property fEnd;
  
  private Property fOtherEnd;
  
  private static List<String> parameterNames = makeImmutableList("end", "otherEnd");
  
  private AssociationOtherEndMatch(final Property pEnd, final Property pOtherEnd) {
    this.fEnd = pEnd;
    this.fOtherEnd = pOtherEnd;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("end".equals(parameterName)) return this.fEnd;
    if ("otherEnd".equals(parameterName)) return this.fOtherEnd;
    return null;
    
  }
  
  public Property getEnd() {
    return this.fEnd;
    
  }
  
  public Property getOtherEnd() {
    return this.fOtherEnd;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("end".equals(parameterName) ) {
    	this.fEnd = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    if ("otherEnd".equals(parameterName) ) {
    	this.fOtherEnd = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setEnd(final Property pEnd) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEnd = pEnd;
    
  }
  
  public void setOtherEnd(final Property pOtherEnd) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOtherEnd = pOtherEnd;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.AssociationOtherEnd";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return AssociationOtherEndMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fEnd, fOtherEnd};
    
  }
  
  @Override
  public AssociationOtherEndMatch toImmutable() {
    return isMutable() ? newMatch(fEnd, fOtherEnd) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"end\"=" + prettyPrintValue(fEnd) + ", ");
    result.append("\"otherEnd\"=" + prettyPrintValue(fOtherEnd));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fEnd == null) ? 0 : fEnd.hashCode());
    result = prime * result + ((fOtherEnd == null) ? 0 : fOtherEnd.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AssociationOtherEndMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    AssociationOtherEndMatch other = (AssociationOtherEndMatch) obj;
    if (fEnd == null) {if (other.fEnd != null) return false;}
    else if (!fEnd.equals(other.fEnd)) return false;
    if (fOtherEnd == null) {if (other.fOtherEnd != null) return false;}
    else if (!fOtherEnd.equals(other.fOtherEnd)) return false;
    return true;
  }
  
  @Override
  public AssociationOtherEndQuerySpecification specification() {
    try {
    	return AssociationOtherEndQuerySpecification.instance();
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
  public static AssociationOtherEndMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pOtherEnd the fixed value of pattern parameter otherEnd, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AssociationOtherEndMatch newMutableMatch(final Property pEnd, final Property pOtherEnd) {
    return new Mutable(pEnd, pOtherEnd);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pOtherEnd the fixed value of pattern parameter otherEnd, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AssociationOtherEndMatch newMatch(final Property pEnd, final Property pOtherEnd) {
    return new Immutable(pEnd, pOtherEnd);
    
  }
  
  private static final class Mutable extends AssociationOtherEndMatch {
    Mutable(final Property pEnd, final Property pOtherEnd) {
      super(pEnd, pOtherEnd);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AssociationOtherEndMatch {
    Immutable(final Property pEnd, final Property pOtherEnd) {
      super(pEnd, pOtherEnd);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
