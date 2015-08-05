package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.ConnectorQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.connector pattern,
 * to be used in conjunction with {@link ConnectorMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ConnectorMatcher
 * @see ConnectorProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ConnectorMatch extends BasePatternMatch {
  private Component fComponent;
  
  private Connector fConnector;
  
  private static List<String> parameterNames = makeImmutableList("component", "connector");
  
  private ConnectorMatch(final Component pComponent, final Connector pConnector) {
    this.fComponent = pComponent;
    this.fConnector = pConnector;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("component".equals(parameterName)) return this.fComponent;
    if ("connector".equals(parameterName)) return this.fConnector;
    return null;
  }
  
  public Component getComponent() {
    return this.fComponent;
  }
  
  public Connector getConnector() {
    return this.fConnector;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("component".equals(parameterName) ) {
    	this.fComponent = (org.eclipse.uml2.uml.Component) newValue;
    	return true;
    }
    if ("connector".equals(parameterName) ) {
    	this.fConnector = (org.eclipse.uml2.uml.Connector) newValue;
    	return true;
    }
    return false;
  }
  
  public void setComponent(final Component pComponent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fComponent = pComponent;
  }
  
  public void setConnector(final Connector pConnector) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fConnector = pConnector;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.connector";
  }
  
  @Override
  public List<String> parameterNames() {
    return ConnectorMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fComponent, fConnector};
  }
  
  @Override
  public ConnectorMatch toImmutable() {
    return isMutable() ? newMatch(fComponent, fConnector) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"component\"=" + prettyPrintValue(fComponent) + ", ");
    
    result.append("\"connector\"=" + prettyPrintValue(fConnector)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fComponent == null) ? 0 : fComponent.hashCode());
    result = prime * result + ((fConnector == null) ? 0 : fConnector.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ConnectorMatch)) { // this should be infrequent
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
    ConnectorMatch other = (ConnectorMatch) obj;
    if (fComponent == null) {if (other.fComponent != null) return false;}
    else if (!fComponent.equals(other.fComponent)) return false;
    if (fConnector == null) {if (other.fConnector != null) return false;}
    else if (!fConnector.equals(other.fConnector)) return false;
    return true;
  }
  
  @Override
  public ConnectorQuerySpecification specification() {
    try {
    	return ConnectorQuerySpecification.instance();
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
  public static ConnectorMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ConnectorMatch newMutableMatch(final Component pComponent, final Connector pConnector) {
    return new Mutable(pComponent, pConnector);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ConnectorMatch newMatch(final Component pComponent, final Connector pConnector) {
    return new Immutable(pComponent, pConnector);
  }
  
  private static final class Mutable extends ConnectorMatch {
    Mutable(final Component pComponent, final Connector pConnector) {
      super(pComponent, pConnector);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ConnectorMatch {
    Immutable(final Component pComponent, final Connector pConnector) {
      super(pComponent, pConnector);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
