package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.FinalStateWithEntryActionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.FinalState;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.FinalStateWithEntryAction pattern,
 * to be used in conjunction with {@link FinalStateWithEntryActionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see FinalStateWithEntryActionMatcher
 * @see FinalStateWithEntryActionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class FinalStateWithEntryActionMatch extends BasePatternMatch {
  private FinalState fSt;
  
  private static List<String> parameterNames = makeImmutableList("st");
  
  private FinalStateWithEntryActionMatch(final FinalState pSt) {
    this.fSt = pSt;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("st".equals(parameterName)) return this.fSt;
    return null;
  }
  
  public FinalState getSt() {
    return this.fSt;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("st".equals(parameterName) ) {
    	this.fSt = (org.eclipse.uml2.uml.FinalState) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSt(final FinalState pSt) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSt = pSt;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.FinalStateWithEntryAction";
  }
  
  @Override
  public List<String> parameterNames() {
    return FinalStateWithEntryActionMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSt};
  }
  
  @Override
  public FinalStateWithEntryActionMatch toImmutable() {
    return isMutable() ? newMatch(fSt) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"st\"=" + prettyPrintValue(fSt)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSt == null) ? 0 : fSt.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof FinalStateWithEntryActionMatch)) { // this should be infrequent
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
    FinalStateWithEntryActionMatch other = (FinalStateWithEntryActionMatch) obj;
    if (fSt == null) {if (other.fSt != null) return false;}
    else if (!fSt.equals(other.fSt)) return false;
    return true;
  }
  
  @Override
  public FinalStateWithEntryActionQuerySpecification specification() {
    try {
    	return FinalStateWithEntryActionQuerySpecification.instance();
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
  public static FinalStateWithEntryActionMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSt the fixed value of pattern parameter st, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static FinalStateWithEntryActionMatch newMutableMatch(final FinalState pSt) {
    return new Mutable(pSt);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSt the fixed value of pattern parameter st, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static FinalStateWithEntryActionMatch newMatch(final FinalState pSt) {
    return new Immutable(pSt);
  }
  
  private static final class Mutable extends FinalStateWithEntryActionMatch {
    Mutable(final FinalState pSt) {
      super(pSt);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends FinalStateWithEntryActionMatch {
    Immutable(final FinalState pSt) {
      super(pSt);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
