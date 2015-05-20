package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.ExitQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Exit pattern,
 * to be used in conjunction with {@link ExitMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ExitMatcher
 * @see ExitProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ExitMatch extends BasePatternMatch {
  private Region fRegion;
  
  private State fState;
  
  private Behavior fExit;
  
  private String fExitName;
  
  private static List<String> parameterNames = makeImmutableList("region", "state", "exit", "exitName");
  
  private ExitMatch(final Region pRegion, final State pState, final Behavior pExit, final String pExitName) {
    this.fRegion = pRegion;
    this.fState = pState;
    this.fExit = pExit;
    this.fExitName = pExitName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("region".equals(parameterName)) return this.fRegion;
    if ("state".equals(parameterName)) return this.fState;
    if ("exit".equals(parameterName)) return this.fExit;
    if ("exitName".equals(parameterName)) return this.fExitName;
    return null;
    
  }
  
  public Region getRegion() {
    return this.fRegion;
    
  }
  
  public State getState() {
    return this.fState;
    
  }
  
  public Behavior getExit() {
    return this.fExit;
    
  }
  
  public String getExitName() {
    return this.fExitName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("region".equals(parameterName) ) {
    	this.fRegion = (org.eclipse.uml2.uml.Region) newValue;
    	return true;
    }
    if ("state".equals(parameterName) ) {
    	this.fState = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    if ("exit".equals(parameterName) ) {
    	this.fExit = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    if ("exitName".equals(parameterName) ) {
    	this.fExitName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setRegion(final Region pRegion) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRegion = pRegion;
    
  }
  
  public void setState(final State pState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fState = pState;
    
  }
  
  public void setExit(final Behavior pExit) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fExit = pExit;
    
  }
  
  public void setExitName(final String pExitName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fExitName = pExitName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Exit";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ExitMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRegion, fState, fExit, fExitName};
    
  }
  
  @Override
  public ExitMatch toImmutable() {
    return isMutable() ? newMatch(fRegion, fState, fExit, fExitName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"region\"=" + prettyPrintValue(fRegion) + ", ");
    result.append("\"state\"=" + prettyPrintValue(fState) + ", ");
    result.append("\"exit\"=" + prettyPrintValue(fExit) + ", ");
    result.append("\"exitName\"=" + prettyPrintValue(fExitName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRegion == null) ? 0 : fRegion.hashCode());
    result = prime * result + ((fState == null) ? 0 : fState.hashCode());
    result = prime * result + ((fExit == null) ? 0 : fExit.hashCode());
    result = prime * result + ((fExitName == null) ? 0 : fExitName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ExitMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ExitMatch other = (ExitMatch) obj;
    if (fRegion == null) {if (other.fRegion != null) return false;}
    else if (!fRegion.equals(other.fRegion)) return false;
    if (fState == null) {if (other.fState != null) return false;}
    else if (!fState.equals(other.fState)) return false;
    if (fExit == null) {if (other.fExit != null) return false;}
    else if (!fExit.equals(other.fExit)) return false;
    if (fExitName == null) {if (other.fExitName != null) return false;}
    else if (!fExitName.equals(other.fExitName)) return false;
    return true;
  }
  
  @Override
  public ExitQuerySpecification specification() {
    try {
    	return ExitQuerySpecification.instance();
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
  public static ExitMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pExit the fixed value of pattern parameter exit, or null if not bound.
   * @param pExitName the fixed value of pattern parameter exitName, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ExitMatch newMutableMatch(final Region pRegion, final State pState, final Behavior pExit, final String pExitName) {
    return new Mutable(pRegion, pState, pExit, pExitName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pExit the fixed value of pattern parameter exit, or null if not bound.
   * @param pExitName the fixed value of pattern parameter exitName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ExitMatch newMatch(final Region pRegion, final State pState, final Behavior pExit, final String pExitName) {
    return new Immutable(pRegion, pState, pExit, pExitName);
    
  }
  
  private static final class Mutable extends ExitMatch {
    Mutable(final Region pRegion, final State pState, final Behavior pExit, final String pExitName) {
      super(pRegion, pState, pExit, pExitName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ExitMatch {
    Immutable(final Region pRegion, final State pState, final Behavior pExit, final String pExitName) {
      super(pRegion, pState, pExit, pExitName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
