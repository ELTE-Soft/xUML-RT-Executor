package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Behavior pattern,
 * to be used in conjunction with {@link BehaviorMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BehaviorMatcher
 * @see BehaviorProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BehaviorMatch extends BasePatternMatch {
  private Behavior fBehavior;
  
  private String fBehaviorName;
  
  private static List<String> parameterNames = makeImmutableList("behavior", "behaviorName");
  
  private BehaviorMatch(final Behavior pBehavior, final String pBehaviorName) {
    this.fBehavior = pBehavior;
    this.fBehaviorName = pBehaviorName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("behavior".equals(parameterName)) return this.fBehavior;
    if ("behaviorName".equals(parameterName)) return this.fBehaviorName;
    return null;
    
  }
  
  public Behavior getBehavior() {
    return this.fBehavior;
    
  }
  
  public String getBehaviorName() {
    return this.fBehaviorName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("behavior".equals(parameterName) ) {
    	this.fBehavior = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    if ("behaviorName".equals(parameterName) ) {
    	this.fBehaviorName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBehavior(final Behavior pBehavior) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBehavior = pBehavior;
    
  }
  
  public void setBehaviorName(final String pBehaviorName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBehaviorName = pBehaviorName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Behavior";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return BehaviorMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBehavior, fBehaviorName};
    
  }
  
  @Override
  public BehaviorMatch toImmutable() {
    return isMutable() ? newMatch(fBehavior, fBehaviorName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"behavior\"=" + prettyPrintValue(fBehavior) + ", ");
    result.append("\"behaviorName\"=" + prettyPrintValue(fBehaviorName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBehavior == null) ? 0 : fBehavior.hashCode());
    result = prime * result + ((fBehaviorName == null) ? 0 : fBehaviorName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof BehaviorMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    BehaviorMatch other = (BehaviorMatch) obj;
    if (fBehavior == null) {if (other.fBehavior != null) return false;}
    else if (!fBehavior.equals(other.fBehavior)) return false;
    if (fBehaviorName == null) {if (other.fBehaviorName != null) return false;}
    else if (!fBehaviorName.equals(other.fBehaviorName)) return false;
    return true;
  }
  
  @Override
  public BehaviorQuerySpecification specification() {
    try {
    	return BehaviorQuerySpecification.instance();
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
  public static BehaviorMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pBehaviorName the fixed value of pattern parameter behaviorName, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BehaviorMatch newMutableMatch(final Behavior pBehavior, final String pBehaviorName) {
    return new Mutable(pBehavior, pBehaviorName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pBehaviorName the fixed value of pattern parameter behaviorName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static BehaviorMatch newMatch(final Behavior pBehavior, final String pBehaviorName) {
    return new Immutable(pBehavior, pBehaviorName);
    
  }
  
  private static final class Mutable extends BehaviorMatch {
    Mutable(final Behavior pBehavior, final String pBehaviorName) {
      super(pBehavior, pBehaviorName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BehaviorMatch {
    Immutable(final Behavior pBehavior, final String pBehaviorName) {
      super(pBehavior, pBehaviorName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
