package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.MultipleInitialTransitionsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Transition;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.MultipleInitialTransitions pattern,
 * to be used in conjunction with {@link MultipleInitialTransitionsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MultipleInitialTransitionsMatcher
 * @see MultipleInitialTransitionsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MultipleInitialTransitionsMatch extends BasePatternMatch {
  private Pseudostate fSrc;
  
  private Transition fTr1;
  
  private Transition fTr2;
  
  private static List<String> parameterNames = makeImmutableList("src", "tr1", "tr2");
  
  private MultipleInitialTransitionsMatch(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2) {
    this.fSrc = pSrc;
    this.fTr1 = pTr1;
    this.fTr2 = pTr2;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("src".equals(parameterName)) return this.fSrc;
    if ("tr1".equals(parameterName)) return this.fTr1;
    if ("tr2".equals(parameterName)) return this.fTr2;
    return null;
  }
  
  public Pseudostate getSrc() {
    return this.fSrc;
  }
  
  public Transition getTr1() {
    return this.fTr1;
  }
  
  public Transition getTr2() {
    return this.fTr2;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("src".equals(parameterName) ) {
    	this.fSrc = (org.eclipse.uml2.uml.Pseudostate) newValue;
    	return true;
    }
    if ("tr1".equals(parameterName) ) {
    	this.fTr1 = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    if ("tr2".equals(parameterName) ) {
    	this.fTr2 = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSrc(final Pseudostate pSrc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSrc = pSrc;
  }
  
  public void setTr1(final Transition pTr1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTr1 = pTr1;
  }
  
  public void setTr2(final Transition pTr2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTr2 = pTr2;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.MultipleInitialTransitions";
  }
  
  @Override
  public List<String> parameterNames() {
    return MultipleInitialTransitionsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSrc, fTr1, fTr2};
  }
  
  @Override
  public MultipleInitialTransitionsMatch toImmutable() {
    return isMutable() ? newMatch(fSrc, fTr1, fTr2) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"src\"=" + prettyPrintValue(fSrc) + ", ");
    
    result.append("\"tr1\"=" + prettyPrintValue(fTr1) + ", ");
    
    result.append("\"tr2\"=" + prettyPrintValue(fTr2)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSrc == null) ? 0 : fSrc.hashCode());
    result = prime * result + ((fTr1 == null) ? 0 : fTr1.hashCode());
    result = prime * result + ((fTr2 == null) ? 0 : fTr2.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MultipleInitialTransitionsMatch)) { // this should be infrequent
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
    MultipleInitialTransitionsMatch other = (MultipleInitialTransitionsMatch) obj;
    if (fSrc == null) {if (other.fSrc != null) return false;}
    else if (!fSrc.equals(other.fSrc)) return false;
    if (fTr1 == null) {if (other.fTr1 != null) return false;}
    else if (!fTr1.equals(other.fTr1)) return false;
    if (fTr2 == null) {if (other.fTr2 != null) return false;}
    else if (!fTr2.equals(other.fTr2)) return false;
    return true;
  }
  
  @Override
  public MultipleInitialTransitionsQuerySpecification specification() {
    try {
    	return MultipleInitialTransitionsQuerySpecification.instance();
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
  public static MultipleInitialTransitionsMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MultipleInitialTransitionsMatch newMutableMatch(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2) {
    return new Mutable(pSrc, pTr1, pTr2);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static MultipleInitialTransitionsMatch newMatch(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2) {
    return new Immutable(pSrc, pTr1, pTr2);
  }
  
  private static final class Mutable extends MultipleInitialTransitionsMatch {
    Mutable(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2) {
      super(pSrc, pTr1, pTr2);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MultipleInitialTransitionsMatch {
    Immutable(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2) {
      super(pSrc, pTr1, pTr2);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
