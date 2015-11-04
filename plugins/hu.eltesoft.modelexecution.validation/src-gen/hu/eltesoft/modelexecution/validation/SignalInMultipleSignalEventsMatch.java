package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.SignalInMultipleSignalEventsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.SignalInMultipleSignalEvents pattern,
 * to be used in conjunction with {@link SignalInMultipleSignalEventsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SignalInMultipleSignalEventsMatcher
 * @see SignalInMultipleSignalEventsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SignalInMultipleSignalEventsMatch extends BasePatternMatch {
  private Signal fSg;
  
  private SignalEvent fEv1;
  
  private SignalEvent fEv2;
  
  private static List<String> parameterNames = makeImmutableList("sg", "ev1", "ev2");
  
  private SignalInMultipleSignalEventsMatch(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2) {
    this.fSg = pSg;
    this.fEv1 = pEv1;
    this.fEv2 = pEv2;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("sg".equals(parameterName)) return this.fSg;
    if ("ev1".equals(parameterName)) return this.fEv1;
    if ("ev2".equals(parameterName)) return this.fEv2;
    return null;
  }
  
  public Signal getSg() {
    return this.fSg;
  }
  
  public SignalEvent getEv1() {
    return this.fEv1;
  }
  
  public SignalEvent getEv2() {
    return this.fEv2;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sg".equals(parameterName) ) {
    	this.fSg = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    if ("ev1".equals(parameterName) ) {
    	this.fEv1 = (org.eclipse.uml2.uml.SignalEvent) newValue;
    	return true;
    }
    if ("ev2".equals(parameterName) ) {
    	this.fEv2 = (org.eclipse.uml2.uml.SignalEvent) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSg(final Signal pSg) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSg = pSg;
  }
  
  public void setEv1(final SignalEvent pEv1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEv1 = pEv1;
  }
  
  public void setEv2(final SignalEvent pEv2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEv2 = pEv2;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.SignalInMultipleSignalEvents";
  }
  
  @Override
  public List<String> parameterNames() {
    return SignalInMultipleSignalEventsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSg, fEv1, fEv2};
  }
  
  @Override
  public SignalInMultipleSignalEventsMatch toImmutable() {
    return isMutable() ? newMatch(fSg, fEv1, fEv2) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sg\"=" + prettyPrintValue(fSg) + ", ");
    
    result.append("\"ev1\"=" + prettyPrintValue(fEv1) + ", ");
    
    result.append("\"ev2\"=" + prettyPrintValue(fEv2)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSg == null) ? 0 : fSg.hashCode());
    result = prime * result + ((fEv1 == null) ? 0 : fEv1.hashCode());
    result = prime * result + ((fEv2 == null) ? 0 : fEv2.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SignalInMultipleSignalEventsMatch)) { // this should be infrequent
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
    SignalInMultipleSignalEventsMatch other = (SignalInMultipleSignalEventsMatch) obj;
    if (fSg == null) {if (other.fSg != null) return false;}
    else if (!fSg.equals(other.fSg)) return false;
    if (fEv1 == null) {if (other.fEv1 != null) return false;}
    else if (!fEv1.equals(other.fEv1)) return false;
    if (fEv2 == null) {if (other.fEv2 != null) return false;}
    else if (!fEv2.equals(other.fEv2)) return false;
    return true;
  }
  
  @Override
  public SignalInMultipleSignalEventsQuerySpecification specification() {
    try {
    	return SignalInMultipleSignalEventsQuerySpecification.instance();
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
  public static SignalInMultipleSignalEventsMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pEv1 the fixed value of pattern parameter ev1, or null if not bound.
   * @param pEv2 the fixed value of pattern parameter ev2, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SignalInMultipleSignalEventsMatch newMutableMatch(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2) {
    return new Mutable(pSg, pEv1, pEv2);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pEv1 the fixed value of pattern parameter ev1, or null if not bound.
   * @param pEv2 the fixed value of pattern parameter ev2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SignalInMultipleSignalEventsMatch newMatch(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2) {
    return new Immutable(pSg, pEv1, pEv2);
  }
  
  private static final class Mutable extends SignalInMultipleSignalEventsMatch {
    Mutable(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2) {
      super(pSg, pEv1, pEv2);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SignalInMultipleSignalEventsMatch {
    Immutable(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2) {
      super(pSg, pEv1, pEv2);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
