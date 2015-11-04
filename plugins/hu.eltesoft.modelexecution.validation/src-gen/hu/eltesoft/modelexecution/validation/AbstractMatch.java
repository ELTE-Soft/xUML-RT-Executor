package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.AbstractQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Classifier;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.Abstract pattern,
 * to be used in conjunction with {@link AbstractMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AbstractMatcher
 * @see AbstractProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AbstractMatch extends BasePatternMatch {
  private Classifier fElem;
  
  private static List<String> parameterNames = makeImmutableList("elem");
  
  private AbstractMatch(final Classifier pElem) {
    this.fElem = pElem;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("elem".equals(parameterName)) return this.fElem;
    return null;
  }
  
  public Classifier getElem() {
    return this.fElem;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("elem".equals(parameterName) ) {
    	this.fElem = (org.eclipse.uml2.uml.Classifier) newValue;
    	return true;
    }
    return false;
  }
  
  public void setElem(final Classifier pElem) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElem = pElem;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.Abstract";
  }
  
  @Override
  public List<String> parameterNames() {
    return AbstractMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fElem};
  }
  
  @Override
  public AbstractMatch toImmutable() {
    return isMutable() ? newMatch(fElem) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"elem\"=" + prettyPrintValue(fElem)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fElem == null) ? 0 : fElem.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AbstractMatch)) { // this should be infrequent
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
    AbstractMatch other = (AbstractMatch) obj;
    if (fElem == null) {if (other.fElem != null) return false;}
    else if (!fElem.equals(other.fElem)) return false;
    return true;
  }
  
  @Override
  public AbstractQuerySpecification specification() {
    try {
    	return AbstractQuerySpecification.instance();
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
  public static AbstractMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AbstractMatch newMutableMatch(final Classifier pElem) {
    return new Mutable(pElem);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AbstractMatch newMatch(final Classifier pElem) {
    return new Immutable(pElem);
  }
  
  private static final class Mutable extends AbstractMatch {
    Mutable(final Classifier pElem) {
      super(pElem);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AbstractMatch {
    Immutable(final Classifier pElem) {
      super(pElem);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
