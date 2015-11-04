package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.RedefinedOperationParameterNumQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Operation;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.RedefinedOperationParameterNum pattern,
 * to be used in conjunction with {@link RedefinedOperationParameterNumMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see RedefinedOperationParameterNumMatcher
 * @see RedefinedOperationParameterNumProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class RedefinedOperationParameterNumMatch extends BasePatternMatch {
  private Operation fRedefined;
  
  private Operation fRedefiner;
  
  private Integer fRedefinerParams;
  
  private Integer fRedefinedParams;
  
  private static List<String> parameterNames = makeImmutableList("redefined", "redefiner", "redefinerParams", "redefinedParams");
  
  private RedefinedOperationParameterNumMatch(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams) {
    this.fRedefined = pRedefined;
    this.fRedefiner = pRedefiner;
    this.fRedefinerParams = pRedefinerParams;
    this.fRedefinedParams = pRedefinedParams;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("redefined".equals(parameterName)) return this.fRedefined;
    if ("redefiner".equals(parameterName)) return this.fRedefiner;
    if ("redefinerParams".equals(parameterName)) return this.fRedefinerParams;
    if ("redefinedParams".equals(parameterName)) return this.fRedefinedParams;
    return null;
  }
  
  public Operation getRedefined() {
    return this.fRedefined;
  }
  
  public Operation getRedefiner() {
    return this.fRedefiner;
  }
  
  public Integer getRedefinerParams() {
    return this.fRedefinerParams;
  }
  
  public Integer getRedefinedParams() {
    return this.fRedefinedParams;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("redefined".equals(parameterName) ) {
    	this.fRedefined = (org.eclipse.uml2.uml.Operation) newValue;
    	return true;
    }
    if ("redefiner".equals(parameterName) ) {
    	this.fRedefiner = (org.eclipse.uml2.uml.Operation) newValue;
    	return true;
    }
    if ("redefinerParams".equals(parameterName) ) {
    	this.fRedefinerParams = (java.lang.Integer) newValue;
    	return true;
    }
    if ("redefinedParams".equals(parameterName) ) {
    	this.fRedefinedParams = (java.lang.Integer) newValue;
    	return true;
    }
    return false;
  }
  
  public void setRedefined(final Operation pRedefined) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRedefined = pRedefined;
  }
  
  public void setRedefiner(final Operation pRedefiner) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRedefiner = pRedefiner;
  }
  
  public void setRedefinerParams(final Integer pRedefinerParams) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRedefinerParams = pRedefinerParams;
  }
  
  public void setRedefinedParams(final Integer pRedefinedParams) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRedefinedParams = pRedefinedParams;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.RedefinedOperationParameterNum";
  }
  
  @Override
  public List<String> parameterNames() {
    return RedefinedOperationParameterNumMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRedefined, fRedefiner, fRedefinerParams, fRedefinedParams};
  }
  
  @Override
  public RedefinedOperationParameterNumMatch toImmutable() {
    return isMutable() ? newMatch(fRedefined, fRedefiner, fRedefinerParams, fRedefinedParams) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"redefined\"=" + prettyPrintValue(fRedefined) + ", ");
    
    result.append("\"redefiner\"=" + prettyPrintValue(fRedefiner) + ", ");
    
    result.append("\"redefinerParams\"=" + prettyPrintValue(fRedefinerParams) + ", ");
    
    result.append("\"redefinedParams\"=" + prettyPrintValue(fRedefinedParams)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRedefined == null) ? 0 : fRedefined.hashCode());
    result = prime * result + ((fRedefiner == null) ? 0 : fRedefiner.hashCode());
    result = prime * result + ((fRedefinerParams == null) ? 0 : fRedefinerParams.hashCode());
    result = prime * result + ((fRedefinedParams == null) ? 0 : fRedefinedParams.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof RedefinedOperationParameterNumMatch)) { // this should be infrequent
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
    RedefinedOperationParameterNumMatch other = (RedefinedOperationParameterNumMatch) obj;
    if (fRedefined == null) {if (other.fRedefined != null) return false;}
    else if (!fRedefined.equals(other.fRedefined)) return false;
    if (fRedefiner == null) {if (other.fRedefiner != null) return false;}
    else if (!fRedefiner.equals(other.fRedefiner)) return false;
    if (fRedefinerParams == null) {if (other.fRedefinerParams != null) return false;}
    else if (!fRedefinerParams.equals(other.fRedefinerParams)) return false;
    if (fRedefinedParams == null) {if (other.fRedefinedParams != null) return false;}
    else if (!fRedefinedParams.equals(other.fRedefinedParams)) return false;
    return true;
  }
  
  @Override
  public RedefinedOperationParameterNumQuerySpecification specification() {
    try {
    	return RedefinedOperationParameterNumQuerySpecification.instance();
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
  public static RedefinedOperationParameterNumMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @param pRedefinerParams the fixed value of pattern parameter redefinerParams, or null if not bound.
   * @param pRedefinedParams the fixed value of pattern parameter redefinedParams, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static RedefinedOperationParameterNumMatch newMutableMatch(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams) {
    return new Mutable(pRedefined, pRedefiner, pRedefinerParams, pRedefinedParams);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @param pRedefinerParams the fixed value of pattern parameter redefinerParams, or null if not bound.
   * @param pRedefinedParams the fixed value of pattern parameter redefinedParams, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static RedefinedOperationParameterNumMatch newMatch(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams) {
    return new Immutable(pRedefined, pRedefiner, pRedefinerParams, pRedefinedParams);
  }
  
  private static final class Mutable extends RedefinedOperationParameterNumMatch {
    Mutable(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams) {
      super(pRedefined, pRedefiner, pRedefinerParams, pRedefinedParams);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends RedefinedOperationParameterNumMatch {
    Immutable(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams) {
      super(pRedefined, pRedefiner, pRedefinerParams, pRedefinedParams);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
