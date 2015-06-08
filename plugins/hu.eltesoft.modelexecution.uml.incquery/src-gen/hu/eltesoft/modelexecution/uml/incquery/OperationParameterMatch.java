package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.OperationParameter pattern,
 * to be used in conjunction with {@link OperationParameterMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see OperationParameterMatcher
 * @see OperationParameterProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class OperationParameterMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCls;
  
  private Operation fOperation;
  
  private Parameter fParameter;
  
  private ParameterDirectionKind fDirection;
  
  private static List<String> parameterNames = makeImmutableList("cls", "operation", "parameter", "direction");
  
  private OperationParameterMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final ParameterDirectionKind pDirection) {
    this.fCls = pCls;
    this.fOperation = pOperation;
    this.fParameter = pParameter;
    this.fDirection = pDirection;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cls".equals(parameterName)) return this.fCls;
    if ("operation".equals(parameterName)) return this.fOperation;
    if ("parameter".equals(parameterName)) return this.fParameter;
    if ("direction".equals(parameterName)) return this.fDirection;
    return null;
    
  }
  
  public org.eclipse.uml2.uml.Class getCls() {
    return this.fCls;
    
  }
  
  public Operation getOperation() {
    return this.fOperation;
    
  }
  
  public Parameter getParameter() {
    return this.fParameter;
    
  }
  
  public ParameterDirectionKind getDirection() {
    return this.fDirection;
    
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
    if ("parameter".equals(parameterName) ) {
    	this.fParameter = (org.eclipse.uml2.uml.Parameter) newValue;
    	return true;
    }
    if ("direction".equals(parameterName) ) {
    	this.fDirection = (org.eclipse.uml2.uml.ParameterDirectionKind) newValue;
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
  
  public void setParameter(final Parameter pParameter) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParameter = pParameter;
    
  }
  
  public void setDirection(final ParameterDirectionKind pDirection) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fDirection = pDirection;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.OperationParameter";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return OperationParameterMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCls, fOperation, fParameter, fDirection};
    
  }
  
  @Override
  public OperationParameterMatch toImmutable() {
    return isMutable() ? newMatch(fCls, fOperation, fParameter, fDirection) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cls\"=" + prettyPrintValue(fCls) + ", ");
    result.append("\"operation\"=" + prettyPrintValue(fOperation) + ", ");
    result.append("\"parameter\"=" + prettyPrintValue(fParameter) + ", ");
    result.append("\"direction\"=" + prettyPrintValue(fDirection));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    result = prime * result + ((fOperation == null) ? 0 : fOperation.hashCode());
    result = prime * result + ((fParameter == null) ? 0 : fParameter.hashCode());
    result = prime * result + ((fDirection == null) ? 0 : fDirection.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof OperationParameterMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    OperationParameterMatch other = (OperationParameterMatch) obj;
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    if (fOperation == null) {if (other.fOperation != null) return false;}
    else if (!fOperation.equals(other.fOperation)) return false;
    if (fParameter == null) {if (other.fParameter != null) return false;}
    else if (!fParameter.equals(other.fParameter)) return false;
    if (fDirection == null) {if (other.fDirection != null) return false;}
    else if (!fDirection.equals(other.fDirection)) return false;
    return true;
  }
  
  @Override
  public OperationParameterQuerySpecification specification() {
    try {
    	return OperationParameterQuerySpecification.instance();
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
  public static OperationParameterMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pDirection the fixed value of pattern parameter direction, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static OperationParameterMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final ParameterDirectionKind pDirection) {
    return new Mutable(pCls, pOperation, pParameter, pDirection);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pDirection the fixed value of pattern parameter direction, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static OperationParameterMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final ParameterDirectionKind pDirection) {
    return new Immutable(pCls, pOperation, pParameter, pDirection);
    
  }
  
  private static final class Mutable extends OperationParameterMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final ParameterDirectionKind pDirection) {
      super(pCls, pOperation, pParameter, pDirection);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends OperationParameterMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final ParameterDirectionKind pDirection) {
      super(pCls, pOperation, pParameter, pDirection);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
