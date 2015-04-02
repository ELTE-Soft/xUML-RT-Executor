package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.InitialsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Initials pattern,
 * to be used in conjunction with {@link InitialsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InitialsMatcher
 * @see InitialsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class InitialsMatch extends BasePatternMatch {
  private Region fRegion;
  
  private Pseudostate fInitPseudostate;
  
  private String fInitPseudostateName;
  
  private Transition fInitTransition;
  
  private State fFirstState;
  
  private static List<String> parameterNames = makeImmutableList("region", "initPseudostate", "initPseudostateName", "initTransition", "firstState");
  
  private InitialsMatch(final Region pRegion, final Pseudostate pInitPseudostate, final String pInitPseudostateName, final Transition pInitTransition, final State pFirstState) {
    this.fRegion = pRegion;
    this.fInitPseudostate = pInitPseudostate;
    this.fInitPseudostateName = pInitPseudostateName;
    this.fInitTransition = pInitTransition;
    this.fFirstState = pFirstState;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("region".equals(parameterName)) return this.fRegion;
    if ("initPseudostate".equals(parameterName)) return this.fInitPseudostate;
    if ("initPseudostateName".equals(parameterName)) return this.fInitPseudostateName;
    if ("initTransition".equals(parameterName)) return this.fInitTransition;
    if ("firstState".equals(parameterName)) return this.fFirstState;
    return null;
    
  }
  
  public Region getRegion() {
    return this.fRegion;
    
  }
  
  public Pseudostate getInitPseudostate() {
    return this.fInitPseudostate;
    
  }
  
  public String getInitPseudostateName() {
    return this.fInitPseudostateName;
    
  }
  
  public Transition getInitTransition() {
    return this.fInitTransition;
    
  }
  
  public State getFirstState() {
    return this.fFirstState;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("region".equals(parameterName) ) {
    	this.fRegion = (org.eclipse.uml2.uml.Region) newValue;
    	return true;
    }
    if ("initPseudostate".equals(parameterName) ) {
    	this.fInitPseudostate = (org.eclipse.uml2.uml.Pseudostate) newValue;
    	return true;
    }
    if ("initPseudostateName".equals(parameterName) ) {
    	this.fInitPseudostateName = (java.lang.String) newValue;
    	return true;
    }
    if ("initTransition".equals(parameterName) ) {
    	this.fInitTransition = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    if ("firstState".equals(parameterName) ) {
    	this.fFirstState = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setRegion(final Region pRegion) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRegion = pRegion;
    
  }
  
  public void setInitPseudostate(final Pseudostate pInitPseudostate) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInitPseudostate = pInitPseudostate;
    
  }
  
  public void setInitPseudostateName(final String pInitPseudostateName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInitPseudostateName = pInitPseudostateName;
    
  }
  
  public void setInitTransition(final Transition pInitTransition) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInitTransition = pInitTransition;
    
  }
  
  public void setFirstState(final State pFirstState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fFirstState = pFirstState;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Initials";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return InitialsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRegion, fInitPseudostate, fInitPseudostateName, fInitTransition, fFirstState};
    
  }
  
  @Override
  public InitialsMatch toImmutable() {
    return isMutable() ? newMatch(fRegion, fInitPseudostate, fInitPseudostateName, fInitTransition, fFirstState) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"region\"=" + prettyPrintValue(fRegion) + ", ");
    result.append("\"initPseudostate\"=" + prettyPrintValue(fInitPseudostate) + ", ");
    result.append("\"initPseudostateName\"=" + prettyPrintValue(fInitPseudostateName) + ", ");
    result.append("\"initTransition\"=" + prettyPrintValue(fInitTransition) + ", ");
    result.append("\"firstState\"=" + prettyPrintValue(fFirstState));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRegion == null) ? 0 : fRegion.hashCode());
    result = prime * result + ((fInitPseudostate == null) ? 0 : fInitPseudostate.hashCode());
    result = prime * result + ((fInitPseudostateName == null) ? 0 : fInitPseudostateName.hashCode());
    result = prime * result + ((fInitTransition == null) ? 0 : fInitTransition.hashCode());
    result = prime * result + ((fFirstState == null) ? 0 : fFirstState.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InitialsMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    InitialsMatch other = (InitialsMatch) obj;
    if (fRegion == null) {if (other.fRegion != null) return false;}
    else if (!fRegion.equals(other.fRegion)) return false;
    if (fInitPseudostate == null) {if (other.fInitPseudostate != null) return false;}
    else if (!fInitPseudostate.equals(other.fInitPseudostate)) return false;
    if (fInitPseudostateName == null) {if (other.fInitPseudostateName != null) return false;}
    else if (!fInitPseudostateName.equals(other.fInitPseudostateName)) return false;
    if (fInitTransition == null) {if (other.fInitTransition != null) return false;}
    else if (!fInitTransition.equals(other.fInitTransition)) return false;
    if (fFirstState == null) {if (other.fFirstState != null) return false;}
    else if (!fFirstState.equals(other.fFirstState)) return false;
    return true;
  }
  
  @Override
  public InitialsQuerySpecification specification() {
    try {
    	return InitialsQuerySpecification.instance();
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
  public static InitialsMatch newEmptyMatch() {
    return new Mutable(null, null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pInitPseudostate the fixed value of pattern parameter initPseudostate, or null if not bound.
   * @param pInitPseudostateName the fixed value of pattern parameter initPseudostateName, or null if not bound.
   * @param pInitTransition the fixed value of pattern parameter initTransition, or null if not bound.
   * @param pFirstState the fixed value of pattern parameter firstState, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static InitialsMatch newMutableMatch(final Region pRegion, final Pseudostate pInitPseudostate, final String pInitPseudostateName, final Transition pInitTransition, final State pFirstState) {
    return new Mutable(pRegion, pInitPseudostate, pInitPseudostateName, pInitTransition, pFirstState);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pInitPseudostate the fixed value of pattern parameter initPseudostate, or null if not bound.
   * @param pInitPseudostateName the fixed value of pattern parameter initPseudostateName, or null if not bound.
   * @param pInitTransition the fixed value of pattern parameter initTransition, or null if not bound.
   * @param pFirstState the fixed value of pattern parameter firstState, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static InitialsMatch newMatch(final Region pRegion, final Pseudostate pInitPseudostate, final String pInitPseudostateName, final Transition pInitTransition, final State pFirstState) {
    return new Immutable(pRegion, pInitPseudostate, pInitPseudostateName, pInitTransition, pFirstState);
    
  }
  
  private static final class Mutable extends InitialsMatch {
    Mutable(final Region pRegion, final Pseudostate pInitPseudostate, final String pInitPseudostateName, final Transition pInitTransition, final State pFirstState) {
      super(pRegion, pInitPseudostate, pInitPseudostateName, pInitTransition, pFirstState);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends InitialsMatch {
    Immutable(final Region pRegion, final Pseudostate pInitPseudostate, final String pInitPseudostateName, final Transition pInitTransition, final State pFirstState) {
      super(pRegion, pInitPseudostate, pInitPseudostateName, pInitTransition, pFirstState);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
