package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ForbiddenStateMachineMemberQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ForbiddenStateMachineMember pattern,
 * to be used in conjunction with {@link ForbiddenStateMachineMemberMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ForbiddenStateMachineMemberMatcher
 * @see ForbiddenStateMachineMemberProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ForbiddenStateMachineMemberMatch extends BasePatternMatch {
  private StateMachine fSm;
  
  private Element fElem;
  
  private static List<String> parameterNames = makeImmutableList("sm", "elem");
  
  private ForbiddenStateMachineMemberMatch(final StateMachine pSm, final Element pElem) {
    this.fSm = pSm;
    this.fElem = pElem;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("sm".equals(parameterName)) return this.fSm;
    if ("elem".equals(parameterName)) return this.fElem;
    return null;
  }
  
  public StateMachine getSm() {
    return this.fSm;
  }
  
  public Element getElem() {
    return this.fElem;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sm".equals(parameterName) ) {
    	this.fSm = (org.eclipse.uml2.uml.StateMachine) newValue;
    	return true;
    }
    if ("elem".equals(parameterName) ) {
    	this.fElem = (org.eclipse.uml2.uml.Element) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSm(final StateMachine pSm) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSm = pSm;
  }
  
  public void setElem(final Element pElem) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElem = pElem;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ForbiddenStateMachineMember";
  }
  
  @Override
  public List<String> parameterNames() {
    return ForbiddenStateMachineMemberMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSm, fElem};
  }
  
  @Override
  public ForbiddenStateMachineMemberMatch toImmutable() {
    return isMutable() ? newMatch(fSm, fElem) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sm\"=" + prettyPrintValue(fSm) + ", ");
    
    result.append("\"elem\"=" + prettyPrintValue(fElem)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSm == null) ? 0 : fSm.hashCode());
    result = prime * result + ((fElem == null) ? 0 : fElem.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ForbiddenStateMachineMemberMatch)) { // this should be infrequent
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
    ForbiddenStateMachineMemberMatch other = (ForbiddenStateMachineMemberMatch) obj;
    if (fSm == null) {if (other.fSm != null) return false;}
    else if (!fSm.equals(other.fSm)) return false;
    if (fElem == null) {if (other.fElem != null) return false;}
    else if (!fElem.equals(other.fElem)) return false;
    return true;
  }
  
  @Override
  public ForbiddenStateMachineMemberQuerySpecification specification() {
    try {
    	return ForbiddenStateMachineMemberQuerySpecification.instance();
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
  public static ForbiddenStateMachineMemberMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ForbiddenStateMachineMemberMatch newMutableMatch(final StateMachine pSm, final Element pElem) {
    return new Mutable(pSm, pElem);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ForbiddenStateMachineMemberMatch newMatch(final StateMachine pSm, final Element pElem) {
    return new Immutable(pSm, pElem);
  }
  
  private static final class Mutable extends ForbiddenStateMachineMemberMatch {
    Mutable(final StateMachine pSm, final Element pElem) {
      super(pSm, pElem);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ForbiddenStateMachineMemberMatch {
    Immutable(final StateMachine pSm, final Element pElem) {
      super(pSm, pElem);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
