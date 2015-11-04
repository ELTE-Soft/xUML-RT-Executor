package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.MultipleInitialStateQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.MultipleInitialState pattern,
 * to be used in conjunction with {@link MultipleInitialStateMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MultipleInitialStateMatcher
 * @see MultipleInitialStateProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MultipleInitialStateMatch extends BasePatternMatch {
  private Region fRg;
  
  private Pseudostate fInit1;
  
  private Pseudostate fInit2;
  
  private static List<String> parameterNames = makeImmutableList("rg", "init1", "init2");
  
  private MultipleInitialStateMatch(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2) {
    this.fRg = pRg;
    this.fInit1 = pInit1;
    this.fInit2 = pInit2;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("rg".equals(parameterName)) return this.fRg;
    if ("init1".equals(parameterName)) return this.fInit1;
    if ("init2".equals(parameterName)) return this.fInit2;
    return null;
  }
  
  public Region getRg() {
    return this.fRg;
  }
  
  public Pseudostate getInit1() {
    return this.fInit1;
  }
  
  public Pseudostate getInit2() {
    return this.fInit2;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("rg".equals(parameterName) ) {
    	this.fRg = (org.eclipse.uml2.uml.Region) newValue;
    	return true;
    }
    if ("init1".equals(parameterName) ) {
    	this.fInit1 = (org.eclipse.uml2.uml.Pseudostate) newValue;
    	return true;
    }
    if ("init2".equals(parameterName) ) {
    	this.fInit2 = (org.eclipse.uml2.uml.Pseudostate) newValue;
    	return true;
    }
    return false;
  }
  
  public void setRg(final Region pRg) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRg = pRg;
  }
  
  public void setInit1(final Pseudostate pInit1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInit1 = pInit1;
  }
  
  public void setInit2(final Pseudostate pInit2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInit2 = pInit2;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.MultipleInitialState";
  }
  
  @Override
  public List<String> parameterNames() {
    return MultipleInitialStateMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRg, fInit1, fInit2};
  }
  
  @Override
  public MultipleInitialStateMatch toImmutable() {
    return isMutable() ? newMatch(fRg, fInit1, fInit2) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"rg\"=" + prettyPrintValue(fRg) + ", ");
    
    result.append("\"init1\"=" + prettyPrintValue(fInit1) + ", ");
    
    result.append("\"init2\"=" + prettyPrintValue(fInit2)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRg == null) ? 0 : fRg.hashCode());
    result = prime * result + ((fInit1 == null) ? 0 : fInit1.hashCode());
    result = prime * result + ((fInit2 == null) ? 0 : fInit2.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MultipleInitialStateMatch)) { // this should be infrequent
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
    MultipleInitialStateMatch other = (MultipleInitialStateMatch) obj;
    if (fRg == null) {if (other.fRg != null) return false;}
    else if (!fRg.equals(other.fRg)) return false;
    if (fInit1 == null) {if (other.fInit1 != null) return false;}
    else if (!fInit1.equals(other.fInit1)) return false;
    if (fInit2 == null) {if (other.fInit2 != null) return false;}
    else if (!fInit2.equals(other.fInit2)) return false;
    return true;
  }
  
  @Override
  public MultipleInitialStateQuerySpecification specification() {
    try {
    	return MultipleInitialStateQuerySpecification.instance();
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
  public static MultipleInitialStateMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pInit1 the fixed value of pattern parameter init1, or null if not bound.
   * @param pInit2 the fixed value of pattern parameter init2, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MultipleInitialStateMatch newMutableMatch(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2) {
    return new Mutable(pRg, pInit1, pInit2);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pInit1 the fixed value of pattern parameter init1, or null if not bound.
   * @param pInit2 the fixed value of pattern parameter init2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static MultipleInitialStateMatch newMatch(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2) {
    return new Immutable(pRg, pInit1, pInit2);
  }
  
  private static final class Mutable extends MultipleInitialStateMatch {
    Mutable(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2) {
      super(pRg, pInit1, pInit2);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MultipleInitialStateMatch {
    Immutable(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2) {
      super(pRg, pInit1, pInit2);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
