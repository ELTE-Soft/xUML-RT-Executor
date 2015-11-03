package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.OperationMethodParameterCheckQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.OperationMethodParameterCheck pattern,
 * to be used in conjunction with {@link OperationMethodParameterCheckMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see OperationMethodParameterCheckMatcher
 * @see OperationMethodParameterCheckProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class OperationMethodParameterCheckMatch extends BasePatternMatch {
  private Parameter fOpParam;
  
  private Parameter fMethodParam;
  
  private Operation fOp;
  
  private Behavior fMethod;
  
  private static List<String> parameterNames = makeImmutableList("opParam", "methodParam", "op", "method");
  
  private OperationMethodParameterCheckMatch(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod) {
    this.fOpParam = pOpParam;
    this.fMethodParam = pMethodParam;
    this.fOp = pOp;
    this.fMethod = pMethod;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("opParam".equals(parameterName)) return this.fOpParam;
    if ("methodParam".equals(parameterName)) return this.fMethodParam;
    if ("op".equals(parameterName)) return this.fOp;
    if ("method".equals(parameterName)) return this.fMethod;
    return null;
  }
  
  public Parameter getOpParam() {
    return this.fOpParam;
  }
  
  public Parameter getMethodParam() {
    return this.fMethodParam;
  }
  
  public Operation getOp() {
    return this.fOp;
  }
  
  public Behavior getMethod() {
    return this.fMethod;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("opParam".equals(parameterName) ) {
    	this.fOpParam = (org.eclipse.uml2.uml.Parameter) newValue;
    	return true;
    }
    if ("methodParam".equals(parameterName) ) {
    	this.fMethodParam = (org.eclipse.uml2.uml.Parameter) newValue;
    	return true;
    }
    if ("op".equals(parameterName) ) {
    	this.fOp = (org.eclipse.uml2.uml.Operation) newValue;
    	return true;
    }
    if ("method".equals(parameterName) ) {
    	this.fMethod = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    return false;
  }
  
  public void setOpParam(final Parameter pOpParam) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOpParam = pOpParam;
  }
  
  public void setMethodParam(final Parameter pMethodParam) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMethodParam = pMethodParam;
  }
  
  public void setOp(final Operation pOp) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOp = pOp;
  }
  
  public void setMethod(final Behavior pMethod) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMethod = pMethod;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.OperationMethodParameterCheck";
  }
  
  @Override
  public List<String> parameterNames() {
    return OperationMethodParameterCheckMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOpParam, fMethodParam, fOp, fMethod};
  }
  
  @Override
  public OperationMethodParameterCheckMatch toImmutable() {
    return isMutable() ? newMatch(fOpParam, fMethodParam, fOp, fMethod) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"opParam\"=" + prettyPrintValue(fOpParam) + ", ");
    
    result.append("\"methodParam\"=" + prettyPrintValue(fMethodParam) + ", ");
    
    result.append("\"op\"=" + prettyPrintValue(fOp) + ", ");
    
    result.append("\"method\"=" + prettyPrintValue(fMethod)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fOpParam == null) ? 0 : fOpParam.hashCode());
    result = prime * result + ((fMethodParam == null) ? 0 : fMethodParam.hashCode());
    result = prime * result + ((fOp == null) ? 0 : fOp.hashCode());
    result = prime * result + ((fMethod == null) ? 0 : fMethod.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof OperationMethodParameterCheckMatch)) { // this should be infrequent
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
    OperationMethodParameterCheckMatch other = (OperationMethodParameterCheckMatch) obj;
    if (fOpParam == null) {if (other.fOpParam != null) return false;}
    else if (!fOpParam.equals(other.fOpParam)) return false;
    if (fMethodParam == null) {if (other.fMethodParam != null) return false;}
    else if (!fMethodParam.equals(other.fMethodParam)) return false;
    if (fOp == null) {if (other.fOp != null) return false;}
    else if (!fOp.equals(other.fOp)) return false;
    if (fMethod == null) {if (other.fMethod != null) return false;}
    else if (!fMethod.equals(other.fMethod)) return false;
    return true;
  }
  
  @Override
  public OperationMethodParameterCheckQuerySpecification specification() {
    try {
    	return OperationMethodParameterCheckQuerySpecification.instance();
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
  public static OperationMethodParameterCheckMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pOpParam the fixed value of pattern parameter opParam, or null if not bound.
   * @param pMethodParam the fixed value of pattern parameter methodParam, or null if not bound.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static OperationMethodParameterCheckMatch newMutableMatch(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod) {
    return new Mutable(pOpParam, pMethodParam, pOp, pMethod);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOpParam the fixed value of pattern parameter opParam, or null if not bound.
   * @param pMethodParam the fixed value of pattern parameter methodParam, or null if not bound.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static OperationMethodParameterCheckMatch newMatch(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod) {
    return new Immutable(pOpParam, pMethodParam, pOp, pMethod);
  }
  
  private static final class Mutable extends OperationMethodParameterCheckMatch {
    Mutable(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod) {
      super(pOpParam, pMethodParam, pOp, pMethod);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends OperationMethodParameterCheckMatch {
    Immutable(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod) {
      super(pOpParam, pMethodParam, pOp, pMethod);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
