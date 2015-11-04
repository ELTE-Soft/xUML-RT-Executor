package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.TransitionTargetUnknownQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Transition;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.TransitionTargetUnknown pattern,
 * to be used in conjunction with {@link TransitionTargetUnknownMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TransitionTargetUnknownMatcher
 * @see TransitionTargetUnknownProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TransitionTargetUnknownMatch extends BasePatternMatch {
  private Transition fTr;
  
  private static List<String> parameterNames = makeImmutableList("tr");
  
  private TransitionTargetUnknownMatch(final Transition pTr) {
    this.fTr = pTr;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("tr".equals(parameterName)) return this.fTr;
    return null;
  }
  
  public Transition getTr() {
    return this.fTr;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("tr".equals(parameterName) ) {
    	this.fTr = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    return false;
  }
  
  public void setTr(final Transition pTr) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTr = pTr;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.TransitionTargetUnknown";
  }
  
  @Override
  public List<String> parameterNames() {
    return TransitionTargetUnknownMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTr};
  }
  
  @Override
  public TransitionTargetUnknownMatch toImmutable() {
    return isMutable() ? newMatch(fTr) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"tr\"=" + prettyPrintValue(fTr)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTr == null) ? 0 : fTr.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TransitionTargetUnknownMatch)) { // this should be infrequent
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
    TransitionTargetUnknownMatch other = (TransitionTargetUnknownMatch) obj;
    if (fTr == null) {if (other.fTr != null) return false;}
    else if (!fTr.equals(other.fTr)) return false;
    return true;
  }
  
  @Override
  public TransitionTargetUnknownQuerySpecification specification() {
    try {
    	return TransitionTargetUnknownQuerySpecification.instance();
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
  public static TransitionTargetUnknownMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pTr the fixed value of pattern parameter tr, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TransitionTargetUnknownMatch newMutableMatch(final Transition pTr) {
    return new Mutable(pTr);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTr the fixed value of pattern parameter tr, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TransitionTargetUnknownMatch newMatch(final Transition pTr) {
    return new Immutable(pTr);
  }
  
  private static final class Mutable extends TransitionTargetUnknownMatch {
    Mutable(final Transition pTr) {
      super(pTr);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TransitionTargetUnknownMatch {
    Immutable(final Transition pTr) {
      super(pTr);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
