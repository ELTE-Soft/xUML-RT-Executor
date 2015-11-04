package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.RedefinedLeafQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Operation;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.RedefinedLeaf pattern,
 * to be used in conjunction with {@link RedefinedLeafMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see RedefinedLeafMatcher
 * @see RedefinedLeafProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class RedefinedLeafMatch extends BasePatternMatch {
  private Operation fOp;
  
  private Operation fRedefined;
  
  private static List<String> parameterNames = makeImmutableList("op", "redefined");
  
  private RedefinedLeafMatch(final Operation pOp, final Operation pRedefined) {
    this.fOp = pOp;
    this.fRedefined = pRedefined;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("op".equals(parameterName)) return this.fOp;
    if ("redefined".equals(parameterName)) return this.fRedefined;
    return null;
  }
  
  public Operation getOp() {
    return this.fOp;
  }
  
  public Operation getRedefined() {
    return this.fRedefined;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("op".equals(parameterName) ) {
    	this.fOp = (org.eclipse.uml2.uml.Operation) newValue;
    	return true;
    }
    if ("redefined".equals(parameterName) ) {
    	this.fRedefined = (org.eclipse.uml2.uml.Operation) newValue;
    	return true;
    }
    return false;
  }
  
  public void setOp(final Operation pOp) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOp = pOp;
  }
  
  public void setRedefined(final Operation pRedefined) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRedefined = pRedefined;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.RedefinedLeaf";
  }
  
  @Override
  public List<String> parameterNames() {
    return RedefinedLeafMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOp, fRedefined};
  }
  
  @Override
  public RedefinedLeafMatch toImmutable() {
    return isMutable() ? newMatch(fOp, fRedefined) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"op\"=" + prettyPrintValue(fOp) + ", ");
    
    result.append("\"redefined\"=" + prettyPrintValue(fRedefined)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fOp == null) ? 0 : fOp.hashCode());
    result = prime * result + ((fRedefined == null) ? 0 : fRedefined.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof RedefinedLeafMatch)) { // this should be infrequent
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
    RedefinedLeafMatch other = (RedefinedLeafMatch) obj;
    if (fOp == null) {if (other.fOp != null) return false;}
    else if (!fOp.equals(other.fOp)) return false;
    if (fRedefined == null) {if (other.fRedefined != null) return false;}
    else if (!fRedefined.equals(other.fRedefined)) return false;
    return true;
  }
  
  @Override
  public RedefinedLeafQuerySpecification specification() {
    try {
    	return RedefinedLeafQuerySpecification.instance();
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
  public static RedefinedLeafMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static RedefinedLeafMatch newMutableMatch(final Operation pOp, final Operation pRedefined) {
    return new Mutable(pOp, pRedefined);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static RedefinedLeafMatch newMatch(final Operation pOp, final Operation pRedefined) {
    return new Immutable(pOp, pRedefined);
  }
  
  private static final class Mutable extends RedefinedLeafMatch {
    Mutable(final Operation pOp, final Operation pRedefined) {
      super(pOp, pRedefined);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends RedefinedLeafMatch {
    Immutable(final Operation pOp, final Operation pRedefined) {
      super(pOp, pRedefined);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
