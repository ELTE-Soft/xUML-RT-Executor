package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.ClsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Cls pattern,
 * to be used in conjunction with {@link ClsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ClsMatcher
 * @see ClsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ClsMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCls;
  
  private String fClassName;
  
  private static List<String> parameterNames = makeImmutableList("cls", "className");
  
  private ClsMatch(final org.eclipse.uml2.uml.Class pCls, final String pClassName) {
    this.fCls = pCls;
    this.fClassName = pClassName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cls".equals(parameterName)) return this.fCls;
    if ("className".equals(parameterName)) return this.fClassName;
    return null;
    
  }
  
  public org.eclipse.uml2.uml.Class getCls() {
    return this.fCls;
    
  }
  
  public String getClassName() {
    return this.fClassName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cls".equals(parameterName) ) {
    	this.fCls = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("className".equals(parameterName) ) {
    	this.fClassName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setCls(final org.eclipse.uml2.uml.Class pCls) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCls = pCls;
    
  }
  
  public void setClassName(final String pClassName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fClassName = pClassName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Cls";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ClsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCls, fClassName};
    
  }
  
  @Override
  public ClsMatch toImmutable() {
    return isMutable() ? newMatch(fCls, fClassName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cls\"=" + prettyPrintValue(fCls) + ", ");
    result.append("\"className\"=" + prettyPrintValue(fClassName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    result = prime * result + ((fClassName == null) ? 0 : fClassName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ClsMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ClsMatch other = (ClsMatch) obj;
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    if (fClassName == null) {if (other.fClassName != null) return false;}
    else if (!fClassName.equals(other.fClassName)) return false;
    return true;
  }
  
  @Override
  public ClsQuerySpecification specification() {
    try {
    	return ClsQuerySpecification.instance();
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
  public static ClsMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pClassName the fixed value of pattern parameter className, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ClsMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCls, final String pClassName) {
    return new Mutable(pCls, pClassName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pClassName the fixed value of pattern parameter className, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ClsMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final String pClassName) {
    return new Immutable(pCls, pClassName);
    
  }
  
  private static final class Mutable extends ClsMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCls, final String pClassName) {
      super(pCls, pClassName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ClsMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCls, final String pClassName) {
      super(pCls, pClassName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
