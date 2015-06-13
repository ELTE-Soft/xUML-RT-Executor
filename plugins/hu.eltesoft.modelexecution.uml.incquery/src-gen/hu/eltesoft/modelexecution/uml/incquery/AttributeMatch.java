package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.AttributeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Attribute pattern,
 * to be used in conjunction with {@link AttributeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AttributeMatcher
 * @see AttributeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AttributeMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCls;
  
  private Property fAttribute;
  
  private Boolean fIsStatic;
  
  private static List<String> parameterNames = makeImmutableList("cls", "attribute", "isStatic");
  
  private AttributeMatch(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic) {
    this.fCls = pCls;
    this.fAttribute = pAttribute;
    this.fIsStatic = pIsStatic;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cls".equals(parameterName)) return this.fCls;
    if ("attribute".equals(parameterName)) return this.fAttribute;
    if ("isStatic".equals(parameterName)) return this.fIsStatic;
    return null;
    
  }
  
  public org.eclipse.uml2.uml.Class getCls() {
    return this.fCls;
    
  }
  
  public Property getAttribute() {
    return this.fAttribute;
    
  }
  
  public Boolean getIsStatic() {
    return this.fIsStatic;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cls".equals(parameterName) ) {
    	this.fCls = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("attribute".equals(parameterName) ) {
    	this.fAttribute = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    if ("isStatic".equals(parameterName) ) {
    	this.fIsStatic = (java.lang.Boolean) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setCls(final org.eclipse.uml2.uml.Class pCls) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCls = pCls;
    
  }
  
  public void setAttribute(final Property pAttribute) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAttribute = pAttribute;
    
  }
  
  public void setIsStatic(final Boolean pIsStatic) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fIsStatic = pIsStatic;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Attribute";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return AttributeMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCls, fAttribute, fIsStatic};
    
  }
  
  @Override
  public AttributeMatch toImmutable() {
    return isMutable() ? newMatch(fCls, fAttribute, fIsStatic) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cls\"=" + prettyPrintValue(fCls) + ", ");
    result.append("\"attribute\"=" + prettyPrintValue(fAttribute) + ", ");
    result.append("\"isStatic\"=" + prettyPrintValue(fIsStatic));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    result = prime * result + ((fAttribute == null) ? 0 : fAttribute.hashCode());
    result = prime * result + ((fIsStatic == null) ? 0 : fIsStatic.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AttributeMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    AttributeMatch other = (AttributeMatch) obj;
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    if (fAttribute == null) {if (other.fAttribute != null) return false;}
    else if (!fAttribute.equals(other.fAttribute)) return false;
    if (fIsStatic == null) {if (other.fIsStatic != null) return false;}
    else if (!fIsStatic.equals(other.fIsStatic)) return false;
    return true;
  }
  
  @Override
  public AttributeQuerySpecification specification() {
    try {
    	return AttributeQuerySpecification.instance();
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
  public static AttributeMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pIsStatic the fixed value of pattern parameter isStatic, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AttributeMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic) {
    return new Mutable(pCls, pAttribute, pIsStatic);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pIsStatic the fixed value of pattern parameter isStatic, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AttributeMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic) {
    return new Immutable(pCls, pAttribute, pIsStatic);
    
  }
  
  private static final class Mutable extends AttributeMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic) {
      super(pCls, pAttribute, pIsStatic);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AttributeMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic) {
      super(pCls, pAttribute, pIsStatic);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
