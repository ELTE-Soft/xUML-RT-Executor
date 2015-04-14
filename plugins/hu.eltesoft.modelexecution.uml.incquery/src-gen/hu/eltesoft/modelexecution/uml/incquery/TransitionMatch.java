package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.TransitionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Region;
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
  
  private String fEventName;
  
  private State fTarget;
  
  private static List<String> parameterNames = makeImmutableList("region", "source", "transition", "eventName", "target");
  
  private TransitionMatch(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget) {
    this.fRegion = pRegion;
    this.fSource = pSource;
    this.fTransition = pTransition;
    this.fEventName = pEventName;
    this.fTarget = pTarget;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("region".equals(parameterName)) return this.fRegion;
    if ("source".equals(parameterName)) return this.fSource;
    if ("transition".equals(parameterName)) return this.fTransition;
    if ("eventName".equals(parameterName)) return this.fEventName;
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
  
  public String getEventName() {
    return this.fEventName;
    
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
    if ("eventName".equals(parameterName) ) {
    	this.fEventName = (java.lang.String) newValue;
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
  
  public void setEventName(final String pEventName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEventName = pEventName;
    
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
    return new Object[]{fRegion, fSource, fTransition, fEventName, fTarget};
    
  }
  
  @Override
  public TransitionMatch toImmutable() {
    return isMutable() ? newMatch(fRegion, fSource, fTransition, fEventName, fTarget) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"region\"=" + prettyPrintValue(fRegion) + ", ");
    result.append("\"source\"=" + prettyPrintValue(fSource) + ", ");
    result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
    result.append("\"eventName\"=" + prettyPrintValue(fEventName) + ", ");
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
    result = prime * result + ((fEventName == null) ? 0 : fEventName.hashCode());
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
    if (fEventName == null) {if (other.fEventName != null) return false;}
    else if (!fEventName.equals(other.fEventName)) return false;
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
    return new Mutable(null, null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEventName the fixed value of pattern parameter eventName, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TransitionMatch newMutableMatch(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget) {
    return new Mutable(pRegion, pSource, pTransition, pEventName, pTarget);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEventName the fixed value of pattern parameter eventName, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TransitionMatch newMatch(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget) {
    return new Immutable(pRegion, pSource, pTransition, pEventName, pTarget);
    
  }
  
  private static final class Mutable extends TransitionMatch {
    Mutable(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget) {
      super(pRegion, pSource, pTransition, pEventName, pTarget);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TransitionMatch {
    Immutable(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget) {
      super(pRegion, pSource, pTransition, pEventName, pTarget);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
