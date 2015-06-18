package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.ClassAssociationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.ClassAssociation pattern,
 * to be used in conjunction with {@link ClassAssociationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ClassAssociationMatcher
 * @see ClassAssociationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ClassAssociationMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCls;
  
  private Property fEnd;
  
  private static List<String> parameterNames = makeImmutableList("cls", "end");
  
  private ClassAssociationMatch(final org.eclipse.uml2.uml.Class pCls, final Property pEnd) {
    this.fCls = pCls;
    this.fEnd = pEnd;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cls".equals(parameterName)) return this.fCls;
    if ("end".equals(parameterName)) return this.fEnd;
    return null;
    
  }
  
  public org.eclipse.uml2.uml.Class getCls() {
    return this.fCls;
    
  }
  
  public Property getEnd() {
    return this.fEnd;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cls".equals(parameterName) ) {
    	this.fCls = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("end".equals(parameterName) ) {
    	this.fEnd = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setCls(final org.eclipse.uml2.uml.Class pCls) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCls = pCls;
    
  }
  
  public void setEnd(final Property pEnd) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEnd = pEnd;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ClassAssociation";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ClassAssociationMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCls, fEnd};
    
  }
  
  @Override
  public ClassAssociationMatch toImmutable() {
    return isMutable() ? newMatch(fCls, fEnd) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cls\"=" + prettyPrintValue(fCls) + ", ");
    result.append("\"end\"=" + prettyPrintValue(fEnd));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    result = prime * result + ((fEnd == null) ? 0 : fEnd.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ClassAssociationMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ClassAssociationMatch other = (ClassAssociationMatch) obj;
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    if (fEnd == null) {if (other.fEnd != null) return false;}
    else if (!fEnd.equals(other.fEnd)) return false;
    return true;
  }
  
  @Override
  public ClassAssociationQuerySpecification specification() {
    try {
    	return ClassAssociationQuerySpecification.instance();
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
  public static ClassAssociationMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ClassAssociationMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCls, final Property pEnd) {
    return new Mutable(pCls, pEnd);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ClassAssociationMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Property pEnd) {
    return new Immutable(pCls, pEnd);
    
  }
  
  private static final class Mutable extends ClassAssociationMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCls, final Property pEnd) {
      super(pCls, pEnd);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ClassAssociationMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCls, final Property pEnd) {
      super(pCls, pEnd);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
