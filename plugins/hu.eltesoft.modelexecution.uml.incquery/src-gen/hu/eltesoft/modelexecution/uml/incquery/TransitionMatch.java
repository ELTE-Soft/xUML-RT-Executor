package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.TransitionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Transition pattern,
 * to be used in conjunction with {@link TransitionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TransitionMatcher
 * @see TransitionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TransitionMatch extends BasePatternMatch {
  private Region fRegion;
  
  private State fSource;
  
  private Transition fTransition;
  
  private Event fEvent;
  
  private Signal fSignal;
  
  private State fTarget;
  
  private static List<String> parameterNames = makeImmutableList("region", "source", "transition", "event", "signal", "target");
  
  private TransitionMatch(final Region pRegion, final State pSource, final Transition pTransition, final Event pEvent, final Signal pSignal, final State pTarget) {
    this.fRegion = pRegion;
    this.fSource = pSource;
    this.fTransition = pTransition;
    this.fEvent = pEvent;
    this.fSignal = pSignal;
    this.fTarget = pTarget;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("region".equals(parameterName)) return this.fRegion;
    if ("source".equals(parameterName)) return this.fSource;
    if ("transition".equals(parameterName)) return this.fTransition;
    if ("event".equals(parameterName)) return this.fEvent;
    if ("signal".equals(parameterName)) return this.fSignal;
    if ("target".equals(parameterName)) return this.fTarget;
    return null;
    
  }
  
  public Region getRegion() {
    return this.fRegion;
    
  }
  
  public State getSource() {
    return this.fSource;
    
  }
  
  public Transition getTransition() {
    return this.fTransition;
    
  }
  
  public Event getEvent() {
    return this.fEvent;
    
  }
  
  public Signal getSignal() {
    return this.fSignal;
    
  }
  
  public State getTarget() {
    return this.fTarget;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("region".equals(parameterName) ) {
    	this.fRegion = (org.eclipse.uml2.uml.Region) newValue;
    	return true;
    }
    if ("source".equals(parameterName) ) {
    	this.fSource = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    if ("transition".equals(parameterName) ) {
    	this.fTransition = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    if ("event".equals(parameterName) ) {
    	this.fEvent = (org.eclipse.uml2.uml.Event) newValue;
    	return true;
    }
    if ("signal".equals(parameterName) ) {
    	this.fSignal = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    if ("target".equals(parameterName) ) {
    	this.fTarget = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setRegion(final Region pRegion) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRegion = pRegion;
    
  }
  
  public void setSource(final State pSource) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSource = pSource;
    
  }
  
  public void setTransition(final Transition pTransition) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTransition = pTransition;
    
  }
  
  public void setEvent(final Event pEvent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEvent = pEvent;
    
  }
  
  public void setSignal(final Signal pSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignal = pSignal;
    
  }
  
  public void setTarget(final State pTarget) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTarget = pTarget;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Transition";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return TransitionMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRegion, fSource, fTransition, fEvent, fSignal, fTarget};
    
  }
  
  @Override
  public TransitionMatch toImmutable() {
    return isMutable() ? newMatch(fRegion, fSource, fTransition, fEvent, fSignal, fTarget) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"region\"=" + prettyPrintValue(fRegion) + ", ");
    result.append("\"source\"=" + prettyPrintValue(fSource) + ", ");
    result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
    result.append("\"event\"=" + prettyPrintValue(fEvent) + ", ");
    result.append("\"signal\"=" + prettyPrintValue(fSignal) + ", ");
    result.append("\"target\"=" + prettyPrintValue(fTarget));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRegion == null) ? 0 : fRegion.hashCode());
    result = prime * result + ((fSource == null) ? 0 : fSource.hashCode());
    result = prime * result + ((fTransition == null) ? 0 : fTransition.hashCode());
    result = prime * result + ((fEvent == null) ? 0 : fEvent.hashCode());
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    result = prime * result + ((fTarget == null) ? 0 : fTarget.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TransitionMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TransitionMatch other = (TransitionMatch) obj;
    if (fRegion == null) {if (other.fRegion != null) return false;}
    else if (!fRegion.equals(other.fRegion)) return false;
    if (fSource == null) {if (other.fSource != null) return false;}
    else if (!fSource.equals(other.fSource)) return false;
    if (fTransition == null) {if (other.fTransition != null) return false;}
    else if (!fTransition.equals(other.fTransition)) return false;
    if (fEvent == null) {if (other.fEvent != null) return false;}
    else if (!fEvent.equals(other.fEvent)) return false;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    if (fTarget == null) {if (other.fTarget != null) return false;}
    else if (!fTarget.equals(other.fTarget)) return false;
    return true;
  }
  
  @Override
  public TransitionQuerySpecification specification() {
    try {
    	return TransitionQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static TransitionMatch newEmptyMatch() {
    return new Mutable(null, null, null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TransitionMatch newMutableMatch(final Region pRegion, final State pSource, final Transition pTransition, final Event pEvent, final Signal pSignal, final State pTarget) {
    return new Mutable(pRegion, pSource, pTransition, pEvent, pSignal, pTarget);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TransitionMatch newMatch(final Region pRegion, final State pSource, final Transition pTransition, final Event pEvent, final Signal pSignal, final State pTarget) {
    return new Immutable(pRegion, pSource, pTransition, pEvent, pSignal, pTarget);
    
  }
  
  private static final class Mutable extends TransitionMatch {
    Mutable(final Region pRegion, final State pSource, final Transition pTransition, final Event pEvent, final Signal pSignal, final State pTarget) {
      super(pRegion, pSource, pTransition, pEvent, pSignal, pTarget);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TransitionMatch {
    Immutable(final Region pRegion, final State pSource, final Transition pTransition, final Event pEvent, final Signal pSignal, final State pTarget) {
      super(pRegion, pSource, pTransition, pEvent, pSignal, pTarget);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
