package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorReturnTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Type;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnType pattern,
 * to be used in conjunction with {@link BehaviorReturnTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BehaviorReturnTypeMatcher
 * @see BehaviorReturnTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BehaviorReturnTypeMatch extends BasePatternMatch {
  private Behavior fBehavior;
  
  private Type fType;
  
  private static List<String> parameterNames = makeImmutableList("behavior", "type");
  
  private BehaviorReturnTypeMatch(final Behavior pBehavior, final Type pType) {
    this.fBehavior = pBehavior;
    this.fType = pType;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("behavior".equals(parameterName)) return this.fBehavior;
    if ("type".equals(parameterName)) return this.fType;
    return null;
    
  }
  
  public Behavior getBehavior() {
    return this.fBehavior;
    
  }
  
  public Type getType() {
    return this.fType;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("behavior".equals(parameterName) ) {
    	this.fBehavior = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    if ("type".equals(parameterName) ) {
    	this.fType = (org.eclipse.uml2.uml.Type) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBehavior(final Behavior pBehavior) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBehavior = pBehavior;
    
  }
  
  public void setType(final Type pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnType";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return BehaviorReturnTypeMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBehavior, fType};
    
  }
  
  @Override
  public BehaviorReturnTypeMatch toImmutable() {
    return isMutable() ? newMatch(fBehavior, fType) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"behavior\"=" + prettyPrintValue(fBehavior) + ", ");
    result.append("\"type\"=" + prettyPrintValue(fType));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBehavior == null) ? 0 : fBehavior.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof BehaviorReturnTypeMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    BehaviorReturnTypeMatch other = (BehaviorReturnTypeMatch) obj;
    if (fBehavior == null) {if (other.fBehavior != null) return false;}
    else if (!fBehavior.equals(other.fBehavior)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    return true;
  }
  
  @Override
  public BehaviorReturnTypeQuerySpecification specification() {
    try {
    	return BehaviorReturnTypeQuerySpecification.instance();
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
  public static BehaviorReturnTypeMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BehaviorReturnTypeMatch newMutableMatch(final Behavior pBehavior, final Type pType) {
    return new Mutable(pBehavior, pType);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static BehaviorReturnTypeMatch newMatch(final Behavior pBehavior, final Type pType) {
    return new Immutable(pBehavior, pType);
    
  }
  
  private static final class Mutable extends BehaviorReturnTypeMatch {
    Mutable(final Behavior pBehavior, final Type pType) {
      super(pBehavior, pType);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BehaviorReturnTypeMatch {
    Immutable(final Behavior pBehavior, final Type pType) {
      super(pBehavior, pType);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
