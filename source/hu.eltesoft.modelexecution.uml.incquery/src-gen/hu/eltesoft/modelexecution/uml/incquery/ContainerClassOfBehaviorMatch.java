package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfBehaviorQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehavior pattern,
 * to be used in conjunction with {@link ContainerClassOfBehaviorMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ContainerClassOfBehaviorMatcher
 * @see ContainerClassOfBehaviorProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ContainerClassOfBehaviorMatch extends BasePatternMatch {
  private Behavior fBehavior;
  
  private String fContainerClassName;
  
  private static List<String> parameterNames = makeImmutableList("behavior", "containerClassName");
  
  private ContainerClassOfBehaviorMatch(final Behavior pBehavior, final String pContainerClassName) {
    this.fBehavior = pBehavior;
    this.fContainerClassName = pContainerClassName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("behavior".equals(parameterName)) return this.fBehavior;
    if ("containerClassName".equals(parameterName)) return this.fContainerClassName;
    return null;
    
  }
  
  public Behavior getBehavior() {
    return this.fBehavior;
    
  }
  
  public String getContainerClassName() {
    return this.fContainerClassName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("behavior".equals(parameterName) ) {
    	this.fBehavior = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    if ("containerClassName".equals(parameterName) ) {
    	this.fContainerClassName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBehavior(final Behavior pBehavior) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBehavior = pBehavior;
    
  }
  
  public void setContainerClassName(final String pContainerClassName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fContainerClassName = pContainerClassName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehavior";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ContainerClassOfBehaviorMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBehavior, fContainerClassName};
    
  }
  
  @Override
  public ContainerClassOfBehaviorMatch toImmutable() {
    return isMutable() ? newMatch(fBehavior, fContainerClassName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"behavior\"=" + prettyPrintValue(fBehavior) + ", ");
    result.append("\"containerClassName\"=" + prettyPrintValue(fContainerClassName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBehavior == null) ? 0 : fBehavior.hashCode());
    result = prime * result + ((fContainerClassName == null) ? 0 : fContainerClassName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ContainerClassOfBehaviorMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ContainerClassOfBehaviorMatch other = (ContainerClassOfBehaviorMatch) obj;
    if (fBehavior == null) {if (other.fBehavior != null) return false;}
    else if (!fBehavior.equals(other.fBehavior)) return false;
    if (fContainerClassName == null) {if (other.fContainerClassName != null) return false;}
    else if (!fContainerClassName.equals(other.fContainerClassName)) return false;
    return true;
  }
  
  @Override
  public ContainerClassOfBehaviorQuerySpecification specification() {
    try {
    	return ContainerClassOfBehaviorQuerySpecification.instance();
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
  public static ContainerClassOfBehaviorMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ContainerClassOfBehaviorMatch newMutableMatch(final Behavior pBehavior, final String pContainerClassName) {
    return new Mutable(pBehavior, pContainerClassName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ContainerClassOfBehaviorMatch newMatch(final Behavior pBehavior, final String pContainerClassName) {
    return new Immutable(pBehavior, pContainerClassName);
    
  }
  
  private static final class Mutable extends ContainerClassOfBehaviorMatch {
    Mutable(final Behavior pBehavior, final String pContainerClassName) {
      super(pBehavior, pContainerClassName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ContainerClassOfBehaviorMatch {
    Immutable(final Behavior pBehavior, final String pContainerClassName) {
      super(pBehavior, pContainerClassName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
