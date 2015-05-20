package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.RegionOfClassQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Region;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.RegionOfClass pattern,
 * to be used in conjunction with {@link RegionOfClassMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see RegionOfClassMatcher
 * @see RegionOfClassProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class RegionOfClassMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCls;
  
  private Region fRegion;
  
  private String fRegionName;
  
  private static List<String> parameterNames = makeImmutableList("cls", "region", "regionName");
  
  private RegionOfClassMatch(final org.eclipse.uml2.uml.Class pCls, final Region pRegion, final String pRegionName) {
    this.fCls = pCls;
    this.fRegion = pRegion;
    this.fRegionName = pRegionName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cls".equals(parameterName)) return this.fCls;
    if ("region".equals(parameterName)) return this.fRegion;
    if ("regionName".equals(parameterName)) return this.fRegionName;
    return null;
    
  }
  
  public org.eclipse.uml2.uml.Class getCls() {
    return this.fCls;
    
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
    if ("cls".equals(parameterName) ) {
    	this.fCls = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
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
  
  public void setCls(final org.eclipse.uml2.uml.Class pCls) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCls = pCls;
    
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
    return "hu.eltesoft.modelexecution.uml.incquery.RegionOfClass";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return RegionOfClassMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCls, fRegion, fRegionName};
    
  }
  
  @Override
  public RegionOfClassMatch toImmutable() {
    return isMutable() ? newMatch(fCls, fRegion, fRegionName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cls\"=" + prettyPrintValue(fCls) + ", ");
    result.append("\"region\"=" + prettyPrintValue(fRegion) + ", ");
    result.append("\"regionName\"=" + prettyPrintValue(fRegionName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    result = prime * result + ((fRegion == null) ? 0 : fRegion.hashCode());
    result = prime * result + ((fRegionName == null) ? 0 : fRegionName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof RegionOfClassMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    RegionOfClassMatch other = (RegionOfClassMatch) obj;
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    if (fRegion == null) {if (other.fRegion != null) return false;}
    else if (!fRegion.equals(other.fRegion)) return false;
    if (fRegionName == null) {if (other.fRegionName != null) return false;}
    else if (!fRegionName.equals(other.fRegionName)) return false;
    return true;
  }
  
  @Override
  public RegionOfClassQuerySpecification specification() {
    try {
    	return RegionOfClassQuerySpecification.instance();
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
  public static RegionOfClassMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pRegionName the fixed value of pattern parameter regionName, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static RegionOfClassMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCls, final Region pRegion, final String pRegionName) {
    return new Mutable(pCls, pRegion, pRegionName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pRegionName the fixed value of pattern parameter regionName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static RegionOfClassMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Region pRegion, final String pRegionName) {
    return new Immutable(pCls, pRegion, pRegionName);
    
  }
  
  private static final class Mutable extends RegionOfClassMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCls, final Region pRegion, final String pRegionName) {
      super(pCls, pRegion, pRegionName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends RegionOfClassMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCls, final Region pRegion, final String pRegionName) {
      super(pCls, pRegion, pRegionName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
