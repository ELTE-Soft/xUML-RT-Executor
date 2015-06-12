package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.StaticBehaviorQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.StaticBehavior pattern,
 * to be used in conjunction with {@link StaticBehaviorMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StaticBehaviorMatcher
 * @see StaticBehaviorProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StaticBehaviorMatch extends BasePatternMatch {
  private Behavior fBehavior;
  
  private Boolean fIsStatic;
  
  private static List<String> parameterNames = makeImmutableList("behavior", "isStatic");
  
  private StaticBehaviorMatch(final Behavior pBehavior, final Boolean pIsStatic) {
    this.fBehavior = pBehavior;
    this.fIsStatic = pIsStatic;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("behavior".equals(parameterName)) return this.fBehavior;
    if ("isStatic".equals(parameterName)) return this.fIsStatic;
    return null;
    
  }
  
  public Behavior getBehavior() {
    return this.fBehavior;
    
  }
  
  public Boolean getIsStatic() {
    return this.fIsStatic;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("behavior".equals(parameterName) ) {
    	this.fBehavior = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    if ("isStatic".equals(parameterName) ) {
    	this.fIsStatic = (java.lang.Boolean) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBehavior(final Behavior pBehavior) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBehavior = pBehavior;
    
  }
  
  public void setIsStatic(final Boolean pIsStatic) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fIsStatic = pIsStatic;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.StaticBehavior";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return StaticBehaviorMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBehavior, fIsStatic};
    
  }
  
  @Override
  public StaticBehaviorMatch toImmutable() {
    return isMutable() ? newMatch(fBehavior, fIsStatic) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"behavior\"=" + prettyPrintValue(fBehavior) + ", ");
    result.append("\"isStatic\"=" + prettyPrintValue(fIsStatic));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBehavior == null) ? 0 : fBehavior.hashCode());
    result = prime * result + ((fIsStatic == null) ? 0 : fIsStatic.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StaticBehaviorMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    StaticBehaviorMatch other = (StaticBehaviorMatch) obj;
    if (fBehavior == null) {if (other.fBehavior != null) return false;}
    else if (!fBehavior.equals(other.fBehavior)) return false;
    if (fIsStatic == null) {if (other.fIsStatic != null) return false;}
    else if (!fIsStatic.equals(other.fIsStatic)) return false;
    return true;
  }
  
  @Override
  public StaticBehaviorQuerySpecification specification() {
    try {
    	return StaticBehaviorQuerySpecification.instance();
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
  public static StaticBehaviorMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pIsStatic the fixed value of pattern parameter isStatic, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StaticBehaviorMatch newMutableMatch(final Behavior pBehavior, final Boolean pIsStatic) {
    return new Mutable(pBehavior, pIsStatic);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pIsStatic the fixed value of pattern parameter isStatic, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static StaticBehaviorMatch newMatch(final Behavior pBehavior, final Boolean pIsStatic) {
    return new Immutable(pBehavior, pIsStatic);
    
  }
  
  private static final class Mutable extends StaticBehaviorMatch {
    Mutable(final Behavior pBehavior, final Boolean pIsStatic) {
      super(pBehavior, pIsStatic);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StaticBehaviorMatch {
    Immutable(final Behavior pBehavior, final Boolean pIsStatic) {
      super(pBehavior, pIsStatic);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
