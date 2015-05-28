package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.MethodQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Method pattern,
 * to be used in conjunction with {@link MethodMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MethodMatcher
 * @see MethodProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MethodMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCls;
  
  private Operation fOperation;
  
  private Behavior fMethod;
  
  private static List<String> parameterNames = makeImmutableList("cls", "operation", "method");
  
  private MethodMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Behavior pMethod) {
    this.fCls = pCls;
    this.fOperation = pOperation;
    this.fMethod = pMethod;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cls".equals(parameterName)) return this.fCls;
    if ("operation".equals(parameterName)) return this.fOperation;
    if ("method".equals(parameterName)) return this.fMethod;
    return null;
    
  }
  
  public org.eclipse.uml2.uml.Class getCls() {
    return this.fCls;
    
  }
  
  public Operation getOperation() {
    return this.fOperation;
    
  }
  
  public Behavior getMethod() {
    return this.fMethod;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cls".equals(parameterName) ) {
    	this.fCls = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("operation".equals(parameterName) ) {
    	this.fOperation = (org.eclipse.uml2.uml.Operation) newValue;
    	return true;
    }
    if ("method".equals(parameterName) ) {
    	this.fMethod = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setCls(final org.eclipse.uml2.uml.Class pCls) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCls = pCls;
    
  }
  
  public void setOperation(final Operation pOperation) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOperation = pOperation;
    
  }
  
  public void setMethod(final Behavior pMethod) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMethod = pMethod;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Method";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return MethodMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCls, fOperation, fMethod};
    
  }
  
  @Override
  public MethodMatch toImmutable() {
    return isMutable() ? newMatch(fCls, fOperation, fMethod) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cls\"=" + prettyPrintValue(fCls) + ", ");
    result.append("\"operation\"=" + prettyPrintValue(fOperation) + ", ");
    result.append("\"method\"=" + prettyPrintValue(fMethod));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    result = prime * result + ((fOperation == null) ? 0 : fOperation.hashCode());
    result = prime * result + ((fMethod == null) ? 0 : fMethod.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MethodMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    MethodMatch other = (MethodMatch) obj;
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    if (fOperation == null) {if (other.fOperation != null) return false;}
    else if (!fOperation.equals(other.fOperation)) return false;
    if (fMethod == null) {if (other.fMethod != null) return false;}
    else if (!fMethod.equals(other.fMethod)) return false;
    return true;
  }
  
  @Override
  public MethodQuerySpecification specification() {
    try {
    	return MethodQuerySpecification.instance();
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
  public static MethodMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MethodMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Behavior pMethod) {
    return new Mutable(pCls, pOperation, pMethod);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static MethodMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Behavior pMethod) {
    return new Immutable(pCls, pOperation, pMethod);
    
  }
  
  private static final class Mutable extends MethodMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Behavior pMethod) {
      super(pCls, pOperation, pMethod);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MethodMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Behavior pMethod) {
      super(pCls, pOperation, pMethod);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
