package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.TransitionEffectQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.TransitionEffect pattern,
 * to be used in conjunction with {@link TransitionEffectMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TransitionEffectMatcher
 * @see TransitionEffectProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TransitionEffectMatch extends BasePatternMatch {
  private Region fRegion;
  
  private Transition fTransition;
  
  private String fEffectName;
  
  private static List<String> parameterNames = makeImmutableList("region", "transition", "effectName");
  
  private TransitionEffectMatch(final Region pRegion, final Transition pTransition, final String pEffectName) {
    this.fRegion = pRegion;
    this.fTransition = pTransition;
    this.fEffectName = pEffectName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("region".equals(parameterName)) return this.fRegion;
    if ("transition".equals(parameterName)) return this.fTransition;
    if ("effectName".equals(parameterName)) return this.fEffectName;
    return null;
    
  }
  
  public Region getRegion() {
    return this.fRegion;
    
  }
  
  public Transition getTransition() {
    return this.fTransition;
    
  }
  
  public String getEffectName() {
    return this.fEffectName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("region".equals(parameterName) ) {
    	this.fRegion = (org.eclipse.uml2.uml.Region) newValue;
    	return true;
    }
    if ("transition".equals(parameterName) ) {
    	this.fTransition = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    if ("effectName".equals(parameterName) ) {
    	this.fEffectName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setRegion(final Region pRegion) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRegion = pRegion;
    
  }
  
  public void setTransition(final Transition pTransition) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTransition = pTransition;
    
  }
  
  public void setEffectName(final String pEffectName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEffectName = pEffectName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.TransitionEffect";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return TransitionEffectMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRegion, fTransition, fEffectName};
    
  }
  
  @Override
  public TransitionEffectMatch toImmutable() {
    return isMutable() ? newMatch(fRegion, fTransition, fEffectName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"region\"=" + prettyPrintValue(fRegion) + ", ");
    result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
    result.append("\"effectName\"=" + prettyPrintValue(fEffectName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRegion == null) ? 0 : fRegion.hashCode());
    result = prime * result + ((fTransition == null) ? 0 : fTransition.hashCode());
    result = prime * result + ((fEffectName == null) ? 0 : fEffectName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TransitionEffectMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TransitionEffectMatch other = (TransitionEffectMatch) obj;
    if (fRegion == null) {if (other.fRegion != null) return false;}
    else if (!fRegion.equals(other.fRegion)) return false;
    if (fTransition == null) {if (other.fTransition != null) return false;}
    else if (!fTransition.equals(other.fTransition)) return false;
    if (fEffectName == null) {if (other.fEffectName != null) return false;}
    else if (!fEffectName.equals(other.fEffectName)) return false;
    return true;
  }
  
  @Override
  public TransitionEffectQuerySpecification specification() {
    try {
    	return TransitionEffectQuerySpecification.instance();
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
  public static TransitionEffectMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEffectName the fixed value of pattern parameter effectName, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TransitionEffectMatch newMutableMatch(final Region pRegion, final Transition pTransition, final String pEffectName) {
    return new Mutable(pRegion, pTransition, pEffectName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEffectName the fixed value of pattern parameter effectName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TransitionEffectMatch newMatch(final Region pRegion, final Transition pTransition, final String pEffectName) {
    return new Immutable(pRegion, pTransition, pEffectName);
    
  }
  
  private static final class Mutable extends TransitionEffectMatch {
    Mutable(final Region pRegion, final Transition pTransition, final String pEffectName) {
      super(pRegion, pTransition, pEffectName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TransitionEffectMatch {
    Immutable(final Region pRegion, final Transition pTransition, final String pEffectName) {
      super(pRegion, pTransition, pEffectName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
