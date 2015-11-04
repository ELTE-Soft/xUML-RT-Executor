package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.MultipleTransitionsWithAnEventQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.MultipleTransitionsWithAnEvent pattern,
 * to be used in conjunction with {@link MultipleTransitionsWithAnEventMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MultipleTransitionsWithAnEventMatcher
 * @see MultipleTransitionsWithAnEventProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MultipleTransitionsWithAnEventMatch extends BasePatternMatch {
  private Transition fTr1;
  
  private Transition fTr2;
  
  private State fSrc;
  
  private Event fEv;
  
  private static List<String> parameterNames = makeImmutableList("tr1", "tr2", "src", "ev");
  
  private MultipleTransitionsWithAnEventMatch(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv) {
    this.fTr1 = pTr1;
    this.fTr2 = pTr2;
    this.fSrc = pSrc;
    this.fEv = pEv;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("tr1".equals(parameterName)) return this.fTr1;
    if ("tr2".equals(parameterName)) return this.fTr2;
    if ("src".equals(parameterName)) return this.fSrc;
    if ("ev".equals(parameterName)) return this.fEv;
    return null;
  }
  
  public Transition getTr1() {
    return this.fTr1;
  }
  
  public Transition getTr2() {
    return this.fTr2;
  }
  
  public State getSrc() {
    return this.fSrc;
  }
  
  public Event getEv() {
    return this.fEv;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("tr1".equals(parameterName) ) {
    	this.fTr1 = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    if ("tr2".equals(parameterName) ) {
    	this.fTr2 = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    if ("src".equals(parameterName) ) {
    	this.fSrc = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    if ("ev".equals(parameterName) ) {
    	this.fEv = (org.eclipse.uml2.uml.Event) newValue;
    	return true;
    }
    return false;
  }
  
  public void setTr1(final Transition pTr1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTr1 = pTr1;
  }
  
  public void setTr2(final Transition pTr2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTr2 = pTr2;
  }
  
  public void setSrc(final State pSrc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSrc = pSrc;
  }
  
  public void setEv(final Event pEv) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEv = pEv;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.MultipleTransitionsWithAnEvent";
  }
  
  @Override
  public List<String> parameterNames() {
    return MultipleTransitionsWithAnEventMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTr1, fTr2, fSrc, fEv};
  }
  
  @Override
  public MultipleTransitionsWithAnEventMatch toImmutable() {
    return isMutable() ? newMatch(fTr1, fTr2, fSrc, fEv) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"tr1\"=" + prettyPrintValue(fTr1) + ", ");
    
    result.append("\"tr2\"=" + prettyPrintValue(fTr2) + ", ");
    
    result.append("\"src\"=" + prettyPrintValue(fSrc) + ", ");
    
    result.append("\"ev\"=" + prettyPrintValue(fEv)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTr1 == null) ? 0 : fTr1.hashCode());
    result = prime * result + ((fTr2 == null) ? 0 : fTr2.hashCode());
    result = prime * result + ((fSrc == null) ? 0 : fSrc.hashCode());
    result = prime * result + ((fEv == null) ? 0 : fEv.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MultipleTransitionsWithAnEventMatch)) { // this should be infrequent
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
    MultipleTransitionsWithAnEventMatch other = (MultipleTransitionsWithAnEventMatch) obj;
    if (fTr1 == null) {if (other.fTr1 != null) return false;}
    else if (!fTr1.equals(other.fTr1)) return false;
    if (fTr2 == null) {if (other.fTr2 != null) return false;}
    else if (!fTr2.equals(other.fTr2)) return false;
    if (fSrc == null) {if (other.fSrc != null) return false;}
    else if (!fSrc.equals(other.fSrc)) return false;
    if (fEv == null) {if (other.fEv != null) return false;}
    else if (!fEv.equals(other.fEv)) return false;
    return true;
  }
  
  @Override
  public MultipleTransitionsWithAnEventQuerySpecification specification() {
    try {
    	return MultipleTransitionsWithAnEventQuerySpecification.instance();
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
  public static MultipleTransitionsWithAnEventMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MultipleTransitionsWithAnEventMatch newMutableMatch(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv) {
    return new Mutable(pTr1, pTr2, pSrc, pEv);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static MultipleTransitionsWithAnEventMatch newMatch(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv) {
    return new Immutable(pTr1, pTr2, pSrc, pEv);
  }
  
  private static final class Mutable extends MultipleTransitionsWithAnEventMatch {
    Mutable(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv) {
      super(pTr1, pTr2, pSrc, pEv);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MultipleTransitionsWithAnEventMatch {
    Immutable(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv) {
      super(pTr1, pTr2, pSrc, pEv);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
