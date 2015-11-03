package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Operation;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.RedefinedAndRedefiningParametersMustBeTheSame pattern,
 * to be used in conjunction with {@link RedefinedAndRedefiningParametersMustBeTheSameMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see RedefinedAndRedefiningParametersMustBeTheSameMatcher
 * @see RedefinedAndRedefiningParametersMustBeTheSameProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class RedefinedAndRedefiningParametersMustBeTheSameMatch extends BasePatternMatch {
  private Operation fRedefined;
  
  private Operation fRedefiner;
  
  private static List<String> parameterNames = makeImmutableList("redefined", "redefiner");
  
  private RedefinedAndRedefiningParametersMustBeTheSameMatch(final Operation pRedefined, final Operation pRedefiner) {
    this.fRedefined = pRedefined;
    this.fRedefiner = pRedefiner;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("redefined".equals(parameterName)) return this.fRedefined;
    if ("redefiner".equals(parameterName)) return this.fRedefiner;
    return null;
  }
  
  public Operation getRedefined() {
    return this.fRedefined;
  }
  
  public Operation getRedefiner() {
    return this.fRedefiner;
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
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.RedefinedAndRedefiningParametersMustBeTheSame";
  }
  
  @Override
  public List<String> parameterNames() {
    return RedefinedAndRedefiningParametersMustBeTheSameMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRedefined, fRedefiner};
  }
  
  @Override
  public RedefinedAndRedefiningParametersMustBeTheSameMatch toImmutable() {
    return isMutable() ? newMatch(fRedefined, fRedefiner) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"redefined\"=" + prettyPrintValue(fRedefined) + ", ");
    
    result.append("\"redefiner\"=" + prettyPrintValue(fRedefiner)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRedefined == null) ? 0 : fRedefined.hashCode());
    result = prime * result + ((fRedefiner == null) ? 0 : fRedefiner.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof RedefinedAndRedefiningParametersMustBeTheSameMatch)) { // this should be infrequent
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
    RedefinedAndRedefiningParametersMustBeTheSameMatch other = (RedefinedAndRedefiningParametersMustBeTheSameMatch) obj;
    if (fRedefined == null) {if (other.fRedefined != null) return false;}
    else if (!fRedefined.equals(other.fRedefined)) return false;
    if (fRedefiner == null) {if (other.fRedefiner != null) return false;}
    else if (!fRedefiner.equals(other.fRedefiner)) return false;
    return true;
  }
  
  @Override
  public RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification specification() {
    try {
    	return RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification.instance();
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
  public static RedefinedAndRedefiningParametersMustBeTheSameMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static RedefinedAndRedefiningParametersMustBeTheSameMatch newMutableMatch(final Operation pRedefined, final Operation pRedefiner) {
    return new Mutable(pRedefined, pRedefiner);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static RedefinedAndRedefiningParametersMustBeTheSameMatch newMatch(final Operation pRedefined, final Operation pRedefiner) {
    return new Immutable(pRedefined, pRedefiner);
  }
  
  private static final class Mutable extends RedefinedAndRedefiningParametersMustBeTheSameMatch {
    Mutable(final Operation pRedefined, final Operation pRedefiner) {
      super(pRedefined, pRedefiner);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends RedefinedAndRedefiningParametersMustBeTheSameMatch {
    Immutable(final Operation pRedefined, final Operation pRedefiner) {
      super(pRedefined, pRedefiner);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
