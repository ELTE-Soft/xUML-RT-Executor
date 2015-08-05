package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.ActionChainQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Transition;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.actionChain pattern,
 * to be used in conjunction with {@link ActionChainMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ActionChainMatcher
 * @see ActionChainProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ActionChainMatch extends BasePatternMatch {
  private Transition fTransition;
  
  private Behavior fEffect;
  
  private static List<String> parameterNames = makeImmutableList("transition", "effect");
  
  private ActionChainMatch(final Transition pTransition, final Behavior pEffect) {
    this.fTransition = pTransition;
    this.fEffect = pEffect;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("transition".equals(parameterName)) return this.fTransition;
    if ("effect".equals(parameterName)) return this.fEffect;
    return null;
  }
  
  public Transition getTransition() {
    return this.fTransition;
  }
  
  public Behavior getEffect() {
    return this.fEffect;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("transition".equals(parameterName) ) {
    	this.fTransition = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    if ("effect".equals(parameterName) ) {
    	this.fEffect = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    return false;
  }
  
  public void setTransition(final Transition pTransition) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTransition = pTransition;
  }
  
  public void setEffect(final Behavior pEffect) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEffect = pEffect;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.actionChain";
  }
  
  @Override
  public List<String> parameterNames() {
    return ActionChainMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTransition, fEffect};
  }
  
  @Override
  public ActionChainMatch toImmutable() {
    return isMutable() ? newMatch(fTransition, fEffect) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
    
    result.append("\"effect\"=" + prettyPrintValue(fEffect)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTransition == null) ? 0 : fTransition.hashCode());
    result = prime * result + ((fEffect == null) ? 0 : fEffect.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ActionChainMatch)) { // this should be infrequent
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
    ActionChainMatch other = (ActionChainMatch) obj;
    if (fTransition == null) {if (other.fTransition != null) return false;}
    else if (!fTransition.equals(other.fTransition)) return false;
    if (fEffect == null) {if (other.fEffect != null) return false;}
    else if (!fEffect.equals(other.fEffect)) return false;
    return true;
  }
  
  @Override
  public ActionChainQuerySpecification specification() {
    try {
    	return ActionChainQuerySpecification.instance();
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
  public static ActionChainMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ActionChainMatch newMutableMatch(final Transition pTransition, final Behavior pEffect) {
    return new Mutable(pTransition, pEffect);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ActionChainMatch newMatch(final Transition pTransition, final Behavior pEffect) {
    return new Immutable(pTransition, pEffect);
  }
  
  private static final class Mutable extends ActionChainMatch {
    Mutable(final Transition pTransition, final Behavior pEffect) {
      super(pTransition, pEffect);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ActionChainMatch {
    Immutable(final Transition pTransition, final Behavior pEffect) {
      super(pTransition, pEffect);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
