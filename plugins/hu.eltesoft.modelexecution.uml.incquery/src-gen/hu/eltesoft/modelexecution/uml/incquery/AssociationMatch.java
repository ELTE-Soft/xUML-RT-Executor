package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.AssociationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

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
  private org.eclipse.uml2.uml.Class fCls;
  
  private Association fAssociation;
  
  private Type fType;
  
  private ValueSpecification fLower;
  
  private ValueSpecification fUpper;
  
  private static List<String> parameterNames = makeImmutableList("cls", "association", "type", "lower", "upper");
  
  private AssociationMatch(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
    this.fCls = pCls;
    this.fAssociation = pAssociation;
    this.fType = pType;
    this.fLower = pLower;
    this.fUpper = pUpper;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cls".equals(parameterName)) return this.fCls;
    if ("association".equals(parameterName)) return this.fAssociation;
    if ("type".equals(parameterName)) return this.fType;
    if ("lower".equals(parameterName)) return this.fLower;
    if ("upper".equals(parameterName)) return this.fUpper;
    return null;
    
  }
  
  public org.eclipse.uml2.uml.Class getCls() {
    return this.fCls;
    
  }
  
  public Association getAssociation() {
    return this.fAssociation;
    
  }
  
  public Type getType() {
    return this.fType;
    
  }
  
  public ValueSpecification getLower() {
    return this.fLower;
    
  }
  
  public ValueSpecification getUpper() {
    return this.fUpper;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cls".equals(parameterName) ) {
    	this.fCls = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("association".equals(parameterName) ) {
    	this.fAssociation = (org.eclipse.uml2.uml.Association) newValue;
    	return true;
    }
    if ("type".equals(parameterName) ) {
    	this.fType = (org.eclipse.uml2.uml.Type) newValue;
    	return true;
    }
    if ("lower".equals(parameterName) ) {
    	this.fLower = (org.eclipse.uml2.uml.ValueSpecification) newValue;
    	return true;
    }
    if ("upper".equals(parameterName) ) {
    	this.fUpper = (org.eclipse.uml2.uml.ValueSpecification) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setCls(final org.eclipse.uml2.uml.Class pCls) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCls = pCls;
    
  }
  
  public void setAssociation(final Association pAssociation) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAssociation = pAssociation;
    
  }
  
  public void setType(final Type pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
    
  }
  
  public void setLower(final ValueSpecification pLower) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLower = pLower;
    
  }
  
  public void setUpper(final ValueSpecification pUpper) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUpper = pUpper;
    
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
    return new Object[]{fCls, fAssociation, fType, fLower, fUpper};
    
  }
  
  @Override
  public AssociationMatch toImmutable() {
    return isMutable() ? newMatch(fCls, fAssociation, fType, fLower, fUpper) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cls\"=" + prettyPrintValue(fCls) + ", ");
    result.append("\"association\"=" + prettyPrintValue(fAssociation) + ", ");
    result.append("\"type\"=" + prettyPrintValue(fType) + ", ");
    result.append("\"lower\"=" + prettyPrintValue(fLower) + ", ");
    result.append("\"upper\"=" + prettyPrintValue(fUpper));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    result = prime * result + ((fAssociation == null) ? 0 : fAssociation.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    result = prime * result + ((fLower == null) ? 0 : fLower.hashCode());
    result = prime * result + ((fUpper == null) ? 0 : fUpper.hashCode());
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
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    if (fAssociation == null) {if (other.fAssociation != null) return false;}
    else if (!fAssociation.equals(other.fAssociation)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    if (fLower == null) {if (other.fLower != null) return false;}
    else if (!fLower.equals(other.fLower)) return false;
    if (fUpper == null) {if (other.fUpper != null) return false;}
    else if (!fUpper.equals(other.fUpper)) return false;
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
    return new Mutable(null, null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pUpper the fixed value of pattern parameter upper, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AssociationMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
    return new Mutable(pCls, pAssociation, pType, pLower, pUpper);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pUpper the fixed value of pattern parameter upper, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AssociationMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
    return new Immutable(pCls, pAssociation, pType, pLower, pUpper);
    
  }
  
  private static final class Mutable extends AssociationMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
      super(pCls, pAssociation, pType, pLower, pUpper);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AssociationMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
      super(pCls, pAssociation, pType, pLower, pUpper);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
