package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.ModelQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Model;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.model pattern,
 * to be used in conjunction with {@link ModelMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ModelMatcher
 * @see ModelProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ModelMatch extends BasePatternMatch {
  private Model fModel;
  
  private static List<String> parameterNames = makeImmutableList("model");
  
  private ModelMatch(final Model pModel) {
    this.fModel = pModel;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("model".equals(parameterName)) return this.fModel;
    return null;
  }
  
  public Model getModel() {
    return this.fModel;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("model".equals(parameterName) ) {
    	this.fModel = (org.eclipse.uml2.uml.Model) newValue;
    	return true;
    }
    return false;
  }
  
  public void setModel(final Model pModel) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fModel = pModel;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.model";
  }
  
  @Override
  public List<String> parameterNames() {
    return ModelMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fModel};
  }
  
  @Override
  public ModelMatch toImmutable() {
    return isMutable() ? newMatch(fModel) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"model\"=" + prettyPrintValue(fModel)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fModel == null) ? 0 : fModel.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ModelMatch)) { // this should be infrequent
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
    ModelMatch other = (ModelMatch) obj;
    if (fModel == null) {if (other.fModel != null) return false;}
    else if (!fModel.equals(other.fModel)) return false;
    return true;
  }
  
  @Override
  public ModelQuerySpecification specification() {
    try {
    	return ModelQuerySpecification.instance();
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
  public static ModelMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ModelMatch newMutableMatch(final Model pModel) {
    return new Mutable(pModel);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ModelMatch newMatch(final Model pModel) {
    return new Immutable(pModel);
  }
  
  private static final class Mutable extends ModelMatch {
    Mutable(final Model pModel) {
      super(pModel);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ModelMatch {
    Immutable(final Model pModel) {
      super(pModel);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
