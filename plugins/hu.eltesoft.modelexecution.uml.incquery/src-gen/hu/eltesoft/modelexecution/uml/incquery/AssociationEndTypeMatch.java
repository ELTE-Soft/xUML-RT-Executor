package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.AssociationEndTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.AssociationEndType pattern,
 * to be used in conjunction with {@link AssociationEndTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AssociationEndTypeMatcher
 * @see AssociationEndTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationEndTypeMatch extends BasePatternMatch {
  private Association fAssociation;
  
  private Property fEnd;
  
  private org.eclipse.uml2.uml.Class fCls;
  
  private static List<String> parameterNames = makeImmutableList("association", "end", "cls");
  
  private AssociationEndTypeMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
    this.fAssociation = pAssociation;
    this.fEnd = pEnd;
    this.fCls = pCls;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("association".equals(parameterName)) return this.fAssociation;
    if ("end".equals(parameterName)) return this.fEnd;
    if ("cls".equals(parameterName)) return this.fCls;
    return null;
    
  }
  
  public Association getAssociation() {
    return this.fAssociation;
    
  }
  
  public Property getEnd() {
    return this.fEnd;
    
  }
  
  public org.eclipse.uml2.uml.Class getCls() {
    return this.fCls;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("association".equals(parameterName) ) {
    	this.fAssociation = (org.eclipse.uml2.uml.Association) newValue;
    	return true;
    }
    if ("end".equals(parameterName) ) {
    	this.fEnd = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    if ("cls".equals(parameterName) ) {
    	this.fCls = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setAssociation(final Association pAssociation) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAssociation = pAssociation;
    
  }
  
  public void setEnd(final Property pEnd) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEnd = pEnd;
    
  }
  
  public void setCls(final org.eclipse.uml2.uml.Class pCls) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCls = pCls;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.AssociationEndType";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return AssociationEndTypeMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fAssociation, fEnd, fCls};
    
  }
  
  @Override
  public AssociationEndTypeMatch toImmutable() {
    return isMutable() ? newMatch(fAssociation, fEnd, fCls) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"association\"=" + prettyPrintValue(fAssociation) + ", ");
    result.append("\"end\"=" + prettyPrintValue(fEnd) + ", ");
    result.append("\"cls\"=" + prettyPrintValue(fCls));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fAssociation == null) ? 0 : fAssociation.hashCode());
    result = prime * result + ((fEnd == null) ? 0 : fEnd.hashCode());
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AssociationEndTypeMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    AssociationEndTypeMatch other = (AssociationEndTypeMatch) obj;
    if (fAssociation == null) {if (other.fAssociation != null) return false;}
    else if (!fAssociation.equals(other.fAssociation)) return false;
    if (fEnd == null) {if (other.fEnd != null) return false;}
    else if (!fEnd.equals(other.fEnd)) return false;
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    return true;
  }
  
  @Override
  public AssociationEndTypeQuerySpecification specification() {
    try {
    	return AssociationEndTypeQuerySpecification.instance();
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
  public static AssociationEndTypeMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AssociationEndTypeMatch newMutableMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
    return new Mutable(pAssociation, pEnd, pCls);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AssociationEndTypeMatch newMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
    return new Immutable(pAssociation, pEnd, pCls);
    
  }
  
  private static final class Mutable extends AssociationEndTypeMatch {
    Mutable(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
      super(pAssociation, pEnd, pCls);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AssociationEndTypeMatch {
    Immutable(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
      super(pAssociation, pEnd, pCls);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
