package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.OperationMethodParameterNumQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.OperationMethodParameterNum pattern,
 * to be used in conjunction with {@link OperationMethodParameterNumMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see OperationMethodParameterNumMatcher
 * @see OperationMethodParameterNumProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class OperationMethodParameterNumMatch extends BasePatternMatch {
  private Operation fOp;
  
  private Behavior fMethod;
  
  private Integer fOpParams;
  
  private Integer fMethodParams;
  
  private static List<String> parameterNames = makeImmutableList("op", "method", "opParams", "methodParams");
  
  private OperationMethodParameterNumMatch(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams) {
    this.fOp = pOp;
    this.fMethod = pMethod;
    this.fOpParams = pOpParams;
    this.fMethodParams = pMethodParams;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("op".equals(parameterName)) return this.fOp;
    if ("method".equals(parameterName)) return this.fMethod;
    if ("opParams".equals(parameterName)) return this.fOpParams;
    if ("methodParams".equals(parameterName)) return this.fMethodParams;
    return null;
  }
  
  public Operation getOp() {
    return this.fOp;
  }
  
  public Behavior getMethod() {
    return this.fMethod;
  }
  
  public Integer getOpParams() {
    return this.fOpParams;
  }
  
  public Integer getMethodParams() {
    return this.fMethodParams;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("op".equals(parameterName) ) {
    	this.fOp = (org.eclipse.uml2.uml.Operation) newValue;
    	return true;
    }
    if ("method".equals(parameterName) ) {
    	this.fMethod = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    if ("opParams".equals(parameterName) ) {
    	this.fOpParams = (java.lang.Integer) newValue;
    	return true;
    }
    if ("methodParams".equals(parameterName) ) {
    	this.fMethodParams = (java.lang.Integer) newValue;
    	return true;
    }
    return false;
  }
  
  public void setOp(final Operation pOp) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOp = pOp;
  }
  
  public void setMethod(final Behavior pMethod) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMethod = pMethod;
  }
  
  public void setOpParams(final Integer pOpParams) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOpParams = pOpParams;
  }
  
  public void setMethodParams(final Integer pMethodParams) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMethodParams = pMethodParams;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.OperationMethodParameterNum";
  }
  
  @Override
  public List<String> parameterNames() {
    return OperationMethodParameterNumMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOp, fMethod, fOpParams, fMethodParams};
  }
  
  @Override
  public OperationMethodParameterNumMatch toImmutable() {
    return isMutable() ? newMatch(fOp, fMethod, fOpParams, fMethodParams) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"op\"=" + prettyPrintValue(fOp) + ", ");
    
    result.append("\"method\"=" + prettyPrintValue(fMethod) + ", ");
    
    result.append("\"opParams\"=" + prettyPrintValue(fOpParams) + ", ");
    
    result.append("\"methodParams\"=" + prettyPrintValue(fMethodParams)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fOp == null) ? 0 : fOp.hashCode());
    result = prime * result + ((fMethod == null) ? 0 : fMethod.hashCode());
    result = prime * result + ((fOpParams == null) ? 0 : fOpParams.hashCode());
    result = prime * result + ((fMethodParams == null) ? 0 : fMethodParams.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof OperationMethodParameterNumMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    OperationMethodParameterNumMatch other = (OperationMethodParameterNumMatch) obj;
    if (fOp == null) {if (other.fOp != null) return false;}
    else if (!fOp.equals(other.fOp)) return false;
    if (fMethod == null) {if (other.fMethod != null) return false;}
    else if (!fMethod.equals(other.fMethod)) return false;
    if (fOpParams == null) {if (other.fOpParams != null) return false;}
    else if (!fOpParams.equals(other.fOpParams)) return false;
    if (fMethodParams == null) {if (other.fMethodParams != null) return false;}
    else if (!fMethodParams.equals(other.fMethodParams)) return false;
    return true;
  }
  
  @Override
  public OperationMethodParameterNumQuerySpecification specification() {
    try {
    	return OperationMethodParameterNumQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static OperationMethodParameterNumMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @param pOpParams the fixed value of pattern parameter opParams, or null if not bound.
   * @param pMethodParams the fixed value of pattern parameter methodParams, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static OperationMethodParameterNumMatch newMutableMatch(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams) {
    return new Mutable(pOp, pMethod, pOpParams, pMethodParams);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @param pOpParams the fixed value of pattern parameter opParams, or null if not bound.
   * @param pMethodParams the fixed value of pattern parameter methodParams, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static OperationMethodParameterNumMatch newMatch(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams) {
    return new Immutable(pOp, pMethod, pOpParams, pMethodParams);
  }
  
  private static final class Mutable extends OperationMethodParameterNumMatch {
    Mutable(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams) {
      super(pOp, pMethod, pOpParams, pMethodParams);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends OperationMethodParameterNumMatch {
    Immutable(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams) {
      super(pOp, pMethod, pOpParams, pMethodParams);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
