package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.OperationParameterType pattern,
 * to be used in conjunction with {@link OperationParameterTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see OperationParameterTypeMatcher
 * @see OperationParameterTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class OperationParameterTypeMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCls;
  
  private Operation fOperation;
  
  private Parameter fParameter;
  
  private Type fType;
  
  private static List<String> parameterNames = makeImmutableList("cls", "operation", "parameter", "type");
  
  private OperationParameterTypeMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType) {
    this.fCls = pCls;
    this.fOperation = pOperation;
    this.fParameter = pParameter;
    this.fType = pType;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cls".equals(parameterName)) return this.fCls;
    if ("operation".equals(parameterName)) return this.fOperation;
    if ("parameter".equals(parameterName)) return this.fParameter;
    if ("type".equals(parameterName)) return this.fType;
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
  
  public Type getType() {
    return this.fType;
    
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
    if ("type".equals(parameterName) ) {
    	this.fType = (org.eclipse.uml2.uml.Type) newValue;
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
  
  public void setType(final Type pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.OperationParameterType";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return OperationParameterTypeMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCls, fOperation, fParameter, fType};
    
  }
  
  @Override
  public OperationParameterTypeMatch toImmutable() {
    return isMutable() ? newMatch(fCls, fOperation, fParameter, fType) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cls\"=" + prettyPrintValue(fCls) + ", ");
    result.append("\"operation\"=" + prettyPrintValue(fOperation) + ", ");
    result.append("\"parameter\"=" + prettyPrintValue(fParameter) + ", ");
    result.append("\"type\"=" + prettyPrintValue(fType));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    result = prime * result + ((fOperation == null) ? 0 : fOperation.hashCode());
    result = prime * result + ((fParameter == null) ? 0 : fParameter.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof OperationParameterTypeMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    OperationParameterTypeMatch other = (OperationParameterTypeMatch) obj;
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    if (fOperation == null) {if (other.fOperation != null) return false;}
    else if (!fOperation.equals(other.fOperation)) return false;
    if (fParameter == null) {if (other.fParameter != null) return false;}
    else if (!fParameter.equals(other.fParameter)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    return true;
  }
  
  @Override
  public OperationParameterTypeQuerySpecification specification() {
    try {
    	return OperationParameterTypeQuerySpecification.instance();
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
  public static OperationParameterTypeMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static OperationParameterTypeMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType) {
    return new Mutable(pCls, pOperation, pParameter, pType);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static OperationParameterTypeMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType) {
    return new Immutable(pCls, pOperation, pParameter, pType);
    
  }
  
  private static final class Mutable extends OperationParameterTypeMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType) {
      super(pCls, pOperation, pParameter, pType);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends OperationParameterTypeMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType) {
      super(pCls, pOperation, pParameter, pType);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
