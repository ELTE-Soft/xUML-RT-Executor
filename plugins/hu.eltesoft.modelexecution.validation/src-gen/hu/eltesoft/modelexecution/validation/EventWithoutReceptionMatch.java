package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.EventWithoutReceptionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Transition;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.EventWithoutReception pattern,
 * to be used in conjunction with {@link EventWithoutReceptionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EventWithoutReceptionMatcher
 * @see EventWithoutReceptionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EventWithoutReceptionMatch extends BasePatternMatch {
  private Transition fTr;
  
  private org.eclipse.uml2.uml.Class fCl;
  
  private Signal fSg;
  
  private static List<String> parameterNames = makeImmutableList("tr", "cl", "sg");
  
  private EventWithoutReceptionMatch(final Transition pTr, final org.eclipse.uml2.uml.Class pCl, final Signal pSg) {
    this.fTr = pTr;
    this.fCl = pCl;
    this.fSg = pSg;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("tr".equals(parameterName)) return this.fTr;
    if ("cl".equals(parameterName)) return this.fCl;
    if ("sg".equals(parameterName)) return this.fSg;
    return null;
  }
  
  public Transition getTr() {
    return this.fTr;
  }
  
  public org.eclipse.uml2.uml.Class getCl() {
    return this.fCl;
  }
  
  public Signal getSg() {
    return this.fSg;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("tr".equals(parameterName) ) {
    	this.fTr = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    if ("cl".equals(parameterName) ) {
    	this.fCl = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("sg".equals(parameterName) ) {
    	this.fSg = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    return false;
  }
  
  public void setTr(final Transition pTr) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTr = pTr;
  }
  
  public void setCl(final org.eclipse.uml2.uml.Class pCl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCl = pCl;
  }
  
  public void setSg(final Signal pSg) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSg = pSg;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.EventWithoutReception";
  }
  
  @Override
  public List<String> parameterNames() {
    return EventWithoutReceptionMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTr, fCl, fSg};
  }
  
  @Override
  public EventWithoutReceptionMatch toImmutable() {
    return isMutable() ? newMatch(fTr, fCl, fSg) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"tr\"=" + prettyPrintValue(fTr) + ", ");
    
    result.append("\"cl\"=" + prettyPrintValue(fCl) + ", ");
    
    result.append("\"sg\"=" + prettyPrintValue(fSg)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTr == null) ? 0 : fTr.hashCode());
    result = prime * result + ((fCl == null) ? 0 : fCl.hashCode());
    result = prime * result + ((fSg == null) ? 0 : fSg.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EventWithoutReceptionMatch)) { // this should be infrequent
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
    EventWithoutReceptionMatch other = (EventWithoutReceptionMatch) obj;
    if (fTr == null) {if (other.fTr != null) return false;}
    else if (!fTr.equals(other.fTr)) return false;
    if (fCl == null) {if (other.fCl != null) return false;}
    else if (!fCl.equals(other.fCl)) return false;
    if (fSg == null) {if (other.fSg != null) return false;}
    else if (!fSg.equals(other.fSg)) return false;
    return true;
  }
  
  @Override
  public EventWithoutReceptionQuerySpecification specification() {
    try {
    	return EventWithoutReceptionQuerySpecification.instance();
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
  public static EventWithoutReceptionMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pTr the fixed value of pattern parameter tr, or null if not bound.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static EventWithoutReceptionMatch newMutableMatch(final Transition pTr, final org.eclipse.uml2.uml.Class pCl, final Signal pSg) {
    return new Mutable(pTr, pCl, pSg);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTr the fixed value of pattern parameter tr, or null if not bound.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static EventWithoutReceptionMatch newMatch(final Transition pTr, final org.eclipse.uml2.uml.Class pCl, final Signal pSg) {
    return new Immutable(pTr, pCl, pSg);
  }
  
  private static final class Mutable extends EventWithoutReceptionMatch {
    Mutable(final Transition pTr, final org.eclipse.uml2.uml.Class pCl, final Signal pSg) {
      super(pTr, pCl, pSg);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends EventWithoutReceptionMatch {
    Immutable(final Transition pTr, final org.eclipse.uml2.uml.Class pCl, final Signal pSg) {
      super(pTr, pCl, pSg);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
