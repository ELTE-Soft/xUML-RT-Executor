package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ClassStateMachineOwnedBehaviorQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ClassStateMachineOwnedBehavior pattern,
 * to be used in conjunction with {@link ClassStateMachineOwnedBehaviorMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ClassStateMachineOwnedBehaviorMatcher
 * @see ClassStateMachineOwnedBehaviorProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ClassStateMachineOwnedBehaviorMatch extends BasePatternMatch {
  private StateMachine fBeh;
  
  private static List<String> parameterNames = makeImmutableList("beh");
  
  private ClassStateMachineOwnedBehaviorMatch(final StateMachine pBeh) {
    this.fBeh = pBeh;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("beh".equals(parameterName)) return this.fBeh;
    return null;
  }
  
  public StateMachine getBeh() {
    return this.fBeh;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("beh".equals(parameterName) ) {
    	this.fBeh = (org.eclipse.uml2.uml.StateMachine) newValue;
    	return true;
    }
    return false;
  }
  
  public void setBeh(final StateMachine pBeh) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBeh = pBeh;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ClassStateMachineOwnedBehavior";
  }
  
  @Override
  public List<String> parameterNames() {
    return ClassStateMachineOwnedBehaviorMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBeh};
  }
  
  @Override
  public ClassStateMachineOwnedBehaviorMatch toImmutable() {
    return isMutable() ? newMatch(fBeh) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"beh\"=" + prettyPrintValue(fBeh)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBeh == null) ? 0 : fBeh.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ClassStateMachineOwnedBehaviorMatch)) { // this should be infrequent
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
    ClassStateMachineOwnedBehaviorMatch other = (ClassStateMachineOwnedBehaviorMatch) obj;
    if (fBeh == null) {if (other.fBeh != null) return false;}
    else if (!fBeh.equals(other.fBeh)) return false;
    return true;
  }
  
  @Override
  public ClassStateMachineOwnedBehaviorQuerySpecification specification() {
    try {
    	return ClassStateMachineOwnedBehaviorQuerySpecification.instance();
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
  public static ClassStateMachineOwnedBehaviorMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBeh the fixed value of pattern parameter beh, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ClassStateMachineOwnedBehaviorMatch newMutableMatch(final StateMachine pBeh) {
    return new Mutable(pBeh);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBeh the fixed value of pattern parameter beh, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ClassStateMachineOwnedBehaviorMatch newMatch(final StateMachine pBeh) {
    return new Immutable(pBeh);
  }
  
  private static final class Mutable extends ClassStateMachineOwnedBehaviorMatch {
    Mutable(final StateMachine pBeh) {
      super(pBeh);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ClassStateMachineOwnedBehaviorMatch {
    Immutable(final StateMachine pBeh) {
      super(pBeh);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
