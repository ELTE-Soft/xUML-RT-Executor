package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.RegionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Region;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Region pattern,
 * to be used in conjunction with {@link RegionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see RegionMatcher
 * @see RegionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class RegionMatch extends BasePatternMatch {
  private Region fRegion;
  
  private String fRegionName;
  
  private static List<String> parameterNames = makeImmutableList("region", "regionName");
  
  private RegionMatch(final Region pRegion, final String pRegionName) {
    this.fRegion = pRegion;
    this.fRegionName = pRegionName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("region".equals(parameterName)) return this.fRegion;
    if ("regionName".equals(parameterName)) return this.fRegionName;
    return null;
    
  }
  
  public Region getRegion() {
    return this.fRegion;
    
  }
  
  public String getRegionName() {
    return this.fRegionName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("region".equals(parameterName) ) {
    	this.fRegion = (org.eclipse.uml2.uml.Region) newValue;
    	return true;
    }
    if ("regionName".equals(parameterName) ) {
    	this.fRegionName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setRegion(final Region pRegion) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRegion = pRegion;
    
  }
  
  public void setRegionName(final String pRegionName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRegionName = pRegionName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Region";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return RegionMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRegion, fRegionName};
    
  }
  
  @Override
  public RegionMatch toImmutable() {
    return isMutable() ? newMatch(fRegion, fRegionName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"region\"=" + prettyPrintValue(fRegion) + ", ");
    result.append("\"regionName\"=" + prettyPrintValue(fRegionName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRegion == null) ? 0 : fRegion.hashCode());
    result = prime * result + ((fRegionName == null) ? 0 : fRegionName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof RegionMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    RegionMatch other = (RegionMatch) obj;
    if (fRegion == null) {if (other.fRegion != null) return false;}
    else if (!fRegion.equals(other.fRegion)) return false;
    if (fRegionName == null) {if (other.fRegionName != null) return false;}
    else if (!fRegionName.equals(other.fRegionName)) return false;
    return true;
  }
  
  @Override
  public RegionQuerySpecification specification() {
    try {
    	return RegionQuerySpecification.instance();
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
  public static RegionMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pRegionName the fixed value of pattern parameter regionName, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static RegionMatch newMutableMatch(final Region pRegion, final String pRegionName) {
    return new Mutable(pRegion, pRegionName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pRegionName the fixed value of pattern parameter regionName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static RegionMatch newMatch(final Region pRegion, final String pRegionName) {
    return new Immutable(pRegion, pRegionName);
    
  }
  
  private static final class Mutable extends RegionMatch {
    Mutable(final Region pRegion, final String pRegionName) {
      super(pRegion, pRegionName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends RegionMatch {
    Immutable(final Region pRegion, final String pRegionName) {
      super(pRegion, pRegionName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
