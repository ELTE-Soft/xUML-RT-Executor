package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.StateMachineWithSpecificationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.StateMachineWithSpecification pattern,
 * to be used in conjunction with {@link StateMachineWithSpecificationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StateMachineWithSpecificationMatcher
 * @see StateMachineWithSpecificationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StateMachineWithSpecificationMatch extends BasePatternMatch {
  private StateMachine fSm;
  
  private static List<String> parameterNames = makeImmutableList("sm");
  
  private StateMachineWithSpecificationMatch(final StateMachine pSm) {
    this.fSm = pSm;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("sm".equals(parameterName)) return this.fSm;
    return null;
  }
  
  public StateMachine getSm() {
    return this.fSm;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sm".equals(parameterName) ) {
    	this.fSm = (org.eclipse.uml2.uml.StateMachine) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSm(final StateMachine pSm) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSm = pSm;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.StateMachineWithSpecification";
  }
  
  @Override
  public List<String> parameterNames() {
    return StateMachineWithSpecificationMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSm};
  }
  
  @Override
  public StateMachineWithSpecificationMatch toImmutable() {
    return isMutable() ? newMatch(fSm) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sm\"=" + prettyPrintValue(fSm)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSm == null) ? 0 : fSm.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StateMachineWithSpecificationMatch)) { // this should be infrequent
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
    StateMachineWithSpecificationMatch other = (StateMachineWithSpecificationMatch) obj;
    if (fSm == null) {if (other.fSm != null) return false;}
    else if (!fSm.equals(other.fSm)) return false;
    return true;
  }
  
  @Override
  public StateMachineWithSpecificationQuerySpecification specification() {
    try {
    	return StateMachineWithSpecificationQuerySpecification.instance();
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
  public static StateMachineWithSpecificationMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StateMachineWithSpecificationMatch newMutableMatch(final StateMachine pSm) {
    return new Mutable(pSm);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static StateMachineWithSpecificationMatch newMatch(final StateMachine pSm) {
    return new Immutable(pSm);
  }
  
  private static final class Mutable extends StateMachineWithSpecificationMatch {
    Mutable(final StateMachine pSm) {
      super(pSm);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StateMachineWithSpecificationMatch {
    Immutable(final StateMachine pSm) {
      super(pSm);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
