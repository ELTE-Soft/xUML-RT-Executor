package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.AttributeLowerBoundQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.AttributeLowerBound pattern,
 * to be used in conjunction with {@link AttributeLowerBoundMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AttributeLowerBoundMatcher
 * @see AttributeLowerBoundProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AttributeLowerBoundMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCls;
  
  private Property fAttribute;
  
  private Type fType;
  
  private ValueSpecification fLowerBound;
  
  private static List<String> parameterNames = makeImmutableList("cls", "attribute", "type", "lowerBound");
  
  private AttributeLowerBoundMatch(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Type pType, final ValueSpecification pLowerBound) {
    this.fCls = pCls;
    this.fAttribute = pAttribute;
    this.fType = pType;
    this.fLowerBound = pLowerBound;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cls".equals(parameterName)) return this.fCls;
    if ("attribute".equals(parameterName)) return this.fAttribute;
    if ("type".equals(parameterName)) return this.fType;
    if ("lowerBound".equals(parameterName)) return this.fLowerBound;
    return null;
    
  }
  
  public org.eclipse.uml2.uml.Class getCls() {
    return this.fCls;
    
  }
  
  public Property getAttribute() {
    return this.fAttribute;
    
  }
  
  public Type getType() {
    return this.fType;
    
  }
  
  public ValueSpecification getLowerBound() {
    return this.fLowerBound;
    
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
    if ("type".equals(parameterName) ) {
    	this.fType = (org.eclipse.uml2.uml.Type) newValue;
    	return true;
    }
    if ("lowerBound".equals(parameterName) ) {
    	this.fLowerBound = (org.eclipse.uml2.uml.ValueSpecification) newValue;
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
  
  public void setType(final Type pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
    
  }
  
  public void setLowerBound(final ValueSpecification pLowerBound) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLowerBound = pLowerBound;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.AttributeLowerBound";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return AttributeLowerBoundMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCls, fAttribute, fType, fLowerBound};
    
  }
  
  @Override
  public AttributeLowerBoundMatch toImmutable() {
    return isMutable() ? newMatch(fCls, fAttribute, fType, fLowerBound) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cls\"=" + prettyPrintValue(fCls) + ", ");
    result.append("\"attribute\"=" + prettyPrintValue(fAttribute) + ", ");
    result.append("\"type\"=" + prettyPrintValue(fType) + ", ");
    result.append("\"lowerBound\"=" + prettyPrintValue(fLowerBound));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    result = prime * result + ((fAttribute == null) ? 0 : fAttribute.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    result = prime * result + ((fLowerBound == null) ? 0 : fLowerBound.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AttributeLowerBoundMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    AttributeLowerBoundMatch other = (AttributeLowerBoundMatch) obj;
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    if (fAttribute == null) {if (other.fAttribute != null) return false;}
    else if (!fAttribute.equals(other.fAttribute)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    if (fLowerBound == null) {if (other.fLowerBound != null) return false;}
    else if (!fLowerBound.equals(other.fLowerBound)) return false;
    return true;
  }
  
  @Override
  public AttributeLowerBoundQuerySpecification specification() {
    try {
    	return AttributeLowerBoundQuerySpecification.instance();
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
  public static AttributeLowerBoundMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AttributeLowerBoundMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Type pType, final ValueSpecification pLowerBound) {
    return new Mutable(pCls, pAttribute, pType, pLowerBound);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AttributeLowerBoundMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Type pType, final ValueSpecification pLowerBound) {
    return new Immutable(pCls, pAttribute, pType, pLowerBound);
    
  }
  
  private static final class Mutable extends AttributeLowerBoundMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Type pType, final ValueSpecification pLowerBound) {
      super(pCls, pAttribute, pType, pLowerBound);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AttributeLowerBoundMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Type pType, final ValueSpecification pLowerBound) {
      super(pCls, pAttribute, pType, pLowerBound);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
