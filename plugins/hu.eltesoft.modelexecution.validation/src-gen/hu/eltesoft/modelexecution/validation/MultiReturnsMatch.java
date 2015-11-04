package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.MultiReturnsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Parameter;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.MultiReturns pattern,
 * to be used in conjunction with {@link MultiReturnsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MultiReturnsMatcher
 * @see MultiReturnsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MultiReturnsMatch extends BasePatternMatch {
  private BehavioralFeature fBf;
  
  private Parameter fPm1;
  
  private Parameter fPm2;
  
  private static List<String> parameterNames = makeImmutableList("bf", "pm1", "pm2");
  
  private MultiReturnsMatch(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2) {
    this.fBf = pBf;
    this.fPm1 = pPm1;
    this.fPm2 = pPm2;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("bf".equals(parameterName)) return this.fBf;
    if ("pm1".equals(parameterName)) return this.fPm1;
    if ("pm2".equals(parameterName)) return this.fPm2;
    return null;
  }
  
  public BehavioralFeature getBf() {
    return this.fBf;
  }
  
  public Parameter getPm1() {
    return this.fPm1;
  }
  
  public Parameter getPm2() {
    return this.fPm2;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("bf".equals(parameterName) ) {
    	this.fBf = (org.eclipse.uml2.uml.BehavioralFeature) newValue;
    	return true;
    }
    if ("pm1".equals(parameterName) ) {
    	this.fPm1 = (org.eclipse.uml2.uml.Parameter) newValue;
    	return true;
    }
    if ("pm2".equals(parameterName) ) {
    	this.fPm2 = (org.eclipse.uml2.uml.Parameter) newValue;
    	return true;
    }
    return false;
  }
  
  public void setBf(final BehavioralFeature pBf) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBf = pBf;
  }
  
  public void setPm1(final Parameter pPm1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPm1 = pPm1;
  }
  
  public void setPm2(final Parameter pPm2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPm2 = pPm2;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.MultiReturns";
  }
  
  @Override
  public List<String> parameterNames() {
    return MultiReturnsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBf, fPm1, fPm2};
  }
  
  @Override
  public MultiReturnsMatch toImmutable() {
    return isMutable() ? newMatch(fBf, fPm1, fPm2) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"bf\"=" + prettyPrintValue(fBf) + ", ");
    
    result.append("\"pm1\"=" + prettyPrintValue(fPm1) + ", ");
    
    result.append("\"pm2\"=" + prettyPrintValue(fPm2)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBf == null) ? 0 : fBf.hashCode());
    result = prime * result + ((fPm1 == null) ? 0 : fPm1.hashCode());
    result = prime * result + ((fPm2 == null) ? 0 : fPm2.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MultiReturnsMatch)) { // this should be infrequent
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
    MultiReturnsMatch other = (MultiReturnsMatch) obj;
    if (fBf == null) {if (other.fBf != null) return false;}
    else if (!fBf.equals(other.fBf)) return false;
    if (fPm1 == null) {if (other.fPm1 != null) return false;}
    else if (!fPm1.equals(other.fPm1)) return false;
    if (fPm2 == null) {if (other.fPm2 != null) return false;}
    else if (!fPm2.equals(other.fPm2)) return false;
    return true;
  }
  
  @Override
  public MultiReturnsQuerySpecification specification() {
    try {
    	return MultiReturnsQuerySpecification.instance();
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
  public static MultiReturnsMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBf the fixed value of pattern parameter bf, or null if not bound.
   * @param pPm1 the fixed value of pattern parameter pm1, or null if not bound.
   * @param pPm2 the fixed value of pattern parameter pm2, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MultiReturnsMatch newMutableMatch(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2) {
    return new Mutable(pBf, pPm1, pPm2);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBf the fixed value of pattern parameter bf, or null if not bound.
   * @param pPm1 the fixed value of pattern parameter pm1, or null if not bound.
   * @param pPm2 the fixed value of pattern parameter pm2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static MultiReturnsMatch newMatch(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2) {
    return new Immutable(pBf, pPm1, pPm2);
  }
  
  private static final class Mutable extends MultiReturnsMatch {
    Mutable(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2) {
      super(pBf, pPm1, pPm2);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MultiReturnsMatch {
    Immutable(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2) {
      super(pBf, pPm1, pPm2);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
