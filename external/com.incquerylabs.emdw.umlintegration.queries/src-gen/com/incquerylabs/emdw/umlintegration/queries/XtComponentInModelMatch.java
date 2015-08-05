package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtComponentInModelQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtComponentInModel pattern,
 * to be used in conjunction with {@link XtComponentInModelMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtComponentInModelMatcher
 * @see XtComponentInModelProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtComponentInModelMatch extends BasePatternMatch {
  private Model fModel;
  
  private Component fComponent;
  
  private static List<String> parameterNames = makeImmutableList("model", "component");
  
  private XtComponentInModelMatch(final Model pModel, final Component pComponent) {
    this.fModel = pModel;
    this.fComponent = pComponent;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("model".equals(parameterName)) return this.fModel;
    if ("component".equals(parameterName)) return this.fComponent;
    return null;
  }
  
  public Model getModel() {
    return this.fModel;
  }
  
  public Component getComponent() {
    return this.fComponent;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("model".equals(parameterName) ) {
    	this.fModel = (org.eclipse.uml2.uml.Model) newValue;
    	return true;
    }
    if ("component".equals(parameterName) ) {
    	this.fComponent = (org.eclipse.uml2.uml.Component) newValue;
    	return true;
    }
    return false;
  }
  
  public void setModel(final Model pModel) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fModel = pModel;
  }
  
  public void setComponent(final Component pComponent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fComponent = pComponent;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtComponentInModel";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtComponentInModelMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fModel, fComponent};
  }
  
  @Override
  public XtComponentInModelMatch toImmutable() {
    return isMutable() ? newMatch(fModel, fComponent) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"model\"=" + prettyPrintValue(fModel) + ", ");
    
    result.append("\"component\"=" + prettyPrintValue(fComponent)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fModel == null) ? 0 : fModel.hashCode());
    result = prime * result + ((fComponent == null) ? 0 : fComponent.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtComponentInModelMatch)) { // this should be infrequent
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
    XtComponentInModelMatch other = (XtComponentInModelMatch) obj;
    if (fModel == null) {if (other.fModel != null) return false;}
    else if (!fModel.equals(other.fModel)) return false;
    if (fComponent == null) {if (other.fComponent != null) return false;}
    else if (!fComponent.equals(other.fComponent)) return false;
    return true;
  }
  
  @Override
  public XtComponentInModelQuerySpecification specification() {
    try {
    	return XtComponentInModelQuerySpecification.instance();
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
  public static XtComponentInModelMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtComponentInModelMatch newMutableMatch(final Model pModel, final Component pComponent) {
    return new Mutable(pModel, pComponent);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtComponentInModelMatch newMatch(final Model pModel, final Component pComponent) {
    return new Immutable(pModel, pComponent);
  }
  
  private static final class Mutable extends XtComponentInModelMatch {
    Mutable(final Model pModel, final Component pComponent) {
      super(pModel, pComponent);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtComponentInModelMatch {
    Immutable(final Model pModel, final Component pComponent) {
      super(pModel, pComponent);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
