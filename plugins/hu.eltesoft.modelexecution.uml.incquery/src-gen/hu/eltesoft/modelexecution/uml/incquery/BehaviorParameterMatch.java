package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.BehaviorParameter pattern,
 * to be used in conjunction with {@link BehaviorParameterMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BehaviorParameterMatcher
 * @see BehaviorParameterProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BehaviorParameterMatch extends BasePatternMatch {
  private Behavior fBehavior;
  
  private Parameter fParameter;
  
  private ParameterDirectionKind fDirection;
  
  private static List<String> parameterNames = makeImmutableList("behavior", "parameter", "direction");
  
  private BehaviorParameterMatch(final Behavior pBehavior, final Parameter pParameter, final ParameterDirectionKind pDirection) {
    this.fBehavior = pBehavior;
    this.fParameter = pParameter;
    this.fDirection = pDirection;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("behavior".equals(parameterName)) return this.fBehavior;
    if ("parameter".equals(parameterName)) return this.fParameter;
    if ("direction".equals(parameterName)) return this.fDirection;
    return null;
    
  }
  
  public Behavior getBehavior() {
    return this.fBehavior;
    
  }
  
  public Parameter getParameter() {
    return this.fParameter;
    
  }
  
  public ParameterDirectionKind getDirection() {
    return this.fDirection;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("behavior".equals(parameterName) ) {
    	this.fBehavior = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    if ("parameter".equals(parameterName) ) {
    	this.fParameter = (org.eclipse.uml2.uml.Parameter) newValue;
    	return true;
    }
    if ("direction".equals(parameterName) ) {
    	this.fDirection = (org.eclipse.uml2.uml.ParameterDirectionKind) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBehavior(final Behavior pBehavior) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBehavior = pBehavior;
    
  }
  
  public void setParameter(final Parameter pParameter) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParameter = pParameter;
    
  }
  
  public void setDirection(final ParameterDirectionKind pDirection) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fDirection = pDirection;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.BehaviorParameter";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return BehaviorParameterMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBehavior, fParameter, fDirection};
    
  }
  
  @Override
  public BehaviorParameterMatch toImmutable() {
    return isMutable() ? newMatch(fBehavior, fParameter, fDirection) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"behavior\"=" + prettyPrintValue(fBehavior) + ", ");
    result.append("\"parameter\"=" + prettyPrintValue(fParameter) + ", ");
    result.append("\"direction\"=" + prettyPrintValue(fDirection));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBehavior == null) ? 0 : fBehavior.hashCode());
    result = prime * result + ((fParameter == null) ? 0 : fParameter.hashCode());
    result = prime * result + ((fDirection == null) ? 0 : fDirection.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof BehaviorParameterMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    BehaviorParameterMatch other = (BehaviorParameterMatch) obj;
    if (fBehavior == null) {if (other.fBehavior != null) return false;}
    else if (!fBehavior.equals(other.fBehavior)) return false;
    if (fParameter == null) {if (other.fParameter != null) return false;}
    else if (!fParameter.equals(other.fParameter)) return false;
    if (fDirection == null) {if (other.fDirection != null) return false;}
    else if (!fDirection.equals(other.fDirection)) return false;
    return true;
  }
  
  @Override
  public BehaviorParameterQuerySpecification specification() {
    try {
    	return BehaviorParameterQuerySpecification.instance();
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
  public static BehaviorParameterMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pDirection the fixed value of pattern parameter direction, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BehaviorParameterMatch newMutableMatch(final Behavior pBehavior, final Parameter pParameter, final ParameterDirectionKind pDirection) {
    return new Mutable(pBehavior, pParameter, pDirection);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pDirection the fixed value of pattern parameter direction, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static BehaviorParameterMatch newMatch(final Behavior pBehavior, final Parameter pParameter, final ParameterDirectionKind pDirection) {
    return new Immutable(pBehavior, pParameter, pDirection);
    
  }
  
  private static final class Mutable extends BehaviorParameterMatch {
    Mutable(final Behavior pBehavior, final Parameter pParameter, final ParameterDirectionKind pDirection) {
      super(pBehavior, pParameter, pDirection);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BehaviorParameterMatch {
    Immutable(final Behavior pBehavior, final Parameter pParameter, final ParameterDirectionKind pDirection) {
      super(pBehavior, pParameter, pDirection);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
