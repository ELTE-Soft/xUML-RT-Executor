package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ModelViewpointQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Model;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ModelViewpoint pattern,
 * to be used in conjunction with {@link ModelViewpointMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ModelViewpointMatcher
 * @see ModelViewpointProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ModelViewpointMatch extends BasePatternMatch {
  private Model fMd;
  
  private static List<String> parameterNames = makeImmutableList("md");
  
  private ModelViewpointMatch(final Model pMd) {
    this.fMd = pMd;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("md".equals(parameterName)) return this.fMd;
    return null;
  }
  
  public Model getMd() {
    return this.fMd;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("md".equals(parameterName) ) {
    	this.fMd = (org.eclipse.uml2.uml.Model) newValue;
    	return true;
    }
    return false;
  }
  
  public void setMd(final Model pMd) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMd = pMd;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ModelViewpoint";
  }
  
  @Override
  public List<String> parameterNames() {
    return ModelViewpointMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fMd};
  }
  
  @Override
  public ModelViewpointMatch toImmutable() {
    return isMutable() ? newMatch(fMd) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"md\"=" + prettyPrintValue(fMd)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fMd == null) ? 0 : fMd.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ModelViewpointMatch)) { // this should be infrequent
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
    ModelViewpointMatch other = (ModelViewpointMatch) obj;
    if (fMd == null) {if (other.fMd != null) return false;}
    else if (!fMd.equals(other.fMd)) return false;
    return true;
  }
  
  @Override
  public ModelViewpointQuerySpecification specification() {
    try {
    	return ModelViewpointQuerySpecification.instance();
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
  public static ModelViewpointMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pMd the fixed value of pattern parameter md, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ModelViewpointMatch newMutableMatch(final Model pMd) {
    return new Mutable(pMd);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pMd the fixed value of pattern parameter md, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ModelViewpointMatch newMatch(final Model pMd) {
    return new Immutable(pMd);
  }
  
  private static final class Mutable extends ModelViewpointMatch {
    Mutable(final Model pMd) {
      super(pMd);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ModelViewpointMatch {
    Immutable(final Model pMd) {
      super(pMd);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
