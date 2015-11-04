package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.StateMachineMustHaveOneRegionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.StateMachineMustHaveOneRegion pattern,
 * to be used in conjunction with {@link StateMachineMustHaveOneRegionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StateMachineMustHaveOneRegionMatcher
 * @see StateMachineMustHaveOneRegionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StateMachineMustHaveOneRegionMatch extends BasePatternMatch {
  private StateMachine fSm;
  
  private Region fRg1;
  
  private Region fRg2;
  
  private static List<String> parameterNames = makeImmutableList("sm", "rg1", "rg2");
  
  private StateMachineMustHaveOneRegionMatch(final StateMachine pSm, final Region pRg1, final Region pRg2) {
    this.fSm = pSm;
    this.fRg1 = pRg1;
    this.fRg2 = pRg2;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("sm".equals(parameterName)) return this.fSm;
    if ("rg1".equals(parameterName)) return this.fRg1;
    if ("rg2".equals(parameterName)) return this.fRg2;
    return null;
  }
  
  public StateMachine getSm() {
    return this.fSm;
  }
  
  public Region getRg1() {
    return this.fRg1;
  }
  
  public Region getRg2() {
    return this.fRg2;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sm".equals(parameterName) ) {
    	this.fSm = (org.eclipse.uml2.uml.StateMachine) newValue;
    	return true;
    }
    if ("rg1".equals(parameterName) ) {
    	this.fRg1 = (org.eclipse.uml2.uml.Region) newValue;
    	return true;
    }
    if ("rg2".equals(parameterName) ) {
    	this.fRg2 = (org.eclipse.uml2.uml.Region) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSm(final StateMachine pSm) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSm = pSm;
  }
  
  public void setRg1(final Region pRg1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRg1 = pRg1;
  }
  
  public void setRg2(final Region pRg2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRg2 = pRg2;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.StateMachineMustHaveOneRegion";
  }
  
  @Override
  public List<String> parameterNames() {
    return StateMachineMustHaveOneRegionMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSm, fRg1, fRg2};
  }
  
  @Override
  public StateMachineMustHaveOneRegionMatch toImmutable() {
    return isMutable() ? newMatch(fSm, fRg1, fRg2) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sm\"=" + prettyPrintValue(fSm) + ", ");
    
    result.append("\"rg1\"=" + prettyPrintValue(fRg1) + ", ");
    
    result.append("\"rg2\"=" + prettyPrintValue(fRg2)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSm == null) ? 0 : fSm.hashCode());
    result = prime * result + ((fRg1 == null) ? 0 : fRg1.hashCode());
    result = prime * result + ((fRg2 == null) ? 0 : fRg2.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StateMachineMustHaveOneRegionMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    StateMachineMustHaveOneRegionMatch other = (StateMachineMustHaveOneRegionMatch) obj;
    if (fSm == null) {if (other.fSm != null) return false;}
    else if (!fSm.equals(other.fSm)) return false;
    if (fRg1 == null) {if (other.fRg1 != null) return false;}
    else if (!fRg1.equals(other.fRg1)) return false;
    if (fRg2 == null) {if (other.fRg2 != null) return false;}
    else if (!fRg2.equals(other.fRg2)) return false;
    return true;
  }
  
  @Override
  public StateMachineMustHaveOneRegionQuerySpecification specification() {
    try {
    	return StateMachineMustHaveOneRegionQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static StateMachineMustHaveOneRegionMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pRg1 the fixed value of pattern parameter rg1, or null if not bound.
   * @param pRg2 the fixed value of pattern parameter rg2, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StateMachineMustHaveOneRegionMatch newMutableMatch(final StateMachine pSm, final Region pRg1, final Region pRg2) {
    return new Mutable(pSm, pRg1, pRg2);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pRg1 the fixed value of pattern parameter rg1, or null if not bound.
   * @param pRg2 the fixed value of pattern parameter rg2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static StateMachineMustHaveOneRegionMatch newMatch(final StateMachine pSm, final Region pRg1, final Region pRg2) {
    return new Immutable(pSm, pRg1, pRg2);
  }
  
  private static final class Mutable extends StateMachineMustHaveOneRegionMatch {
    Mutable(final StateMachine pSm, final Region pRg1, final Region pRg2) {
      super(pSm, pRg1, pRg2);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StateMachineMustHaveOneRegionMatch {
    Immutable(final StateMachine pSm, final Region pRg1, final Region pRg2) {
      super(pSm, pRg1, pRg2);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
