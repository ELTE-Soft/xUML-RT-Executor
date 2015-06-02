package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfRegionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Region;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegion pattern,
 * to be used in conjunction with {@link ContainerClassOfRegionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ContainerClassOfRegionMatcher
 * @see ContainerClassOfRegionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ContainerClassOfRegionMatch extends BasePatternMatch {
  private Region fRegion;
  
  private org.eclipse.uml2.uml.Class fContainerClass;
  
  private static List<String> parameterNames = makeImmutableList("region", "containerClass");
  
  private ContainerClassOfRegionMatch(final Region pRegion, final org.eclipse.uml2.uml.Class pContainerClass) {
    this.fRegion = pRegion;
    this.fContainerClass = pContainerClass;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("region".equals(parameterName)) return this.fRegion;
    if ("containerClass".equals(parameterName)) return this.fContainerClass;
    return null;
    
  }
  
  public Region getRegion() {
    return this.fRegion;
    
  }
  
  public org.eclipse.uml2.uml.Class getContainerClass() {
    return this.fContainerClass;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("region".equals(parameterName) ) {
    	this.fRegion = (org.eclipse.uml2.uml.Region) newValue;
    	return true;
    }
    if ("containerClass".equals(parameterName) ) {
    	this.fContainerClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setRegion(final Region pRegion) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRegion = pRegion;
    
  }
  
  public void setContainerClass(final org.eclipse.uml2.uml.Class pContainerClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fContainerClass = pContainerClass;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegion";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ContainerClassOfRegionMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRegion, fContainerClass};
    
  }
  
  @Override
  public ContainerClassOfRegionMatch toImmutable() {
    return isMutable() ? newMatch(fRegion, fContainerClass) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"region\"=" + prettyPrintValue(fRegion) + ", ");
    result.append("\"containerClass\"=" + prettyPrintValue(fContainerClass));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRegion == null) ? 0 : fRegion.hashCode());
    result = prime * result + ((fContainerClass == null) ? 0 : fContainerClass.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ContainerClassOfRegionMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ContainerClassOfRegionMatch other = (ContainerClassOfRegionMatch) obj;
    if (fRegion == null) {if (other.fRegion != null) return false;}
    else if (!fRegion.equals(other.fRegion)) return false;
    if (fContainerClass == null) {if (other.fContainerClass != null) return false;}
    else if (!fContainerClass.equals(other.fContainerClass)) return false;
    return true;
  }
  
  @Override
  public ContainerClassOfRegionQuerySpecification specification() {
    try {
    	return ContainerClassOfRegionQuerySpecification.instance();
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
  public static ContainerClassOfRegionMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pContainerClass the fixed value of pattern parameter containerClass, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ContainerClassOfRegionMatch newMutableMatch(final Region pRegion, final org.eclipse.uml2.uml.Class pContainerClass) {
    return new Mutable(pRegion, pContainerClass);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pContainerClass the fixed value of pattern parameter containerClass, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ContainerClassOfRegionMatch newMatch(final Region pRegion, final org.eclipse.uml2.uml.Class pContainerClass) {
    return new Immutable(pRegion, pContainerClass);
    
  }
  
  private static final class Mutable extends ContainerClassOfRegionMatch {
    Mutable(final Region pRegion, final org.eclipse.uml2.uml.Class pContainerClass) {
      super(pRegion, pContainerClass);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ContainerClassOfRegionMatch {
    Immutable(final Region pRegion, final org.eclipse.uml2.uml.Class pContainerClass) {
      super(pRegion, pContainerClass);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
