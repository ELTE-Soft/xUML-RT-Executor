package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.ConnectorEndQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.connectorEnd pattern,
 * to be used in conjunction with {@link ConnectorEndMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ConnectorEndMatcher
 * @see ConnectorEndProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ConnectorEndMatch extends BasePatternMatch {
  private Connector fConnector;
  
  private ConnectorEnd fConnectorEnd;
  
  private static List<String> parameterNames = makeImmutableList("connector", "connectorEnd");
  
  private ConnectorEndMatch(final Connector pConnector, final ConnectorEnd pConnectorEnd) {
    this.fConnector = pConnector;
    this.fConnectorEnd = pConnectorEnd;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("connector".equals(parameterName)) return this.fConnector;
    if ("connectorEnd".equals(parameterName)) return this.fConnectorEnd;
    return null;
  }
  
  public Connector getConnector() {
    return this.fConnector;
  }
  
  public ConnectorEnd getConnectorEnd() {
    return this.fConnectorEnd;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("connector".equals(parameterName) ) {
    	this.fConnector = (org.eclipse.uml2.uml.Connector) newValue;
    	return true;
    }
    if ("connectorEnd".equals(parameterName) ) {
    	this.fConnectorEnd = (org.eclipse.uml2.uml.ConnectorEnd) newValue;
    	return true;
    }
    return false;
  }
  
  public void setConnector(final Connector pConnector) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fConnector = pConnector;
  }
  
  public void setConnectorEnd(final ConnectorEnd pConnectorEnd) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fConnectorEnd = pConnectorEnd;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.connectorEnd";
  }
  
  @Override
  public List<String> parameterNames() {
    return ConnectorEndMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fConnector, fConnectorEnd};
  }
  
  @Override
  public ConnectorEndMatch toImmutable() {
    return isMutable() ? newMatch(fConnector, fConnectorEnd) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"connector\"=" + prettyPrintValue(fConnector) + ", ");
    
    result.append("\"connectorEnd\"=" + prettyPrintValue(fConnectorEnd)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fConnector == null) ? 0 : fConnector.hashCode());
    result = prime * result + ((fConnectorEnd == null) ? 0 : fConnectorEnd.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ConnectorEndMatch)) { // this should be infrequent
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
    ConnectorEndMatch other = (ConnectorEndMatch) obj;
    if (fConnector == null) {if (other.fConnector != null) return false;}
    else if (!fConnector.equals(other.fConnector)) return false;
    if (fConnectorEnd == null) {if (other.fConnectorEnd != null) return false;}
    else if (!fConnectorEnd.equals(other.fConnectorEnd)) return false;
    return true;
  }
  
  @Override
  public ConnectorEndQuerySpecification specification() {
    try {
    	return ConnectorEndQuerySpecification.instance();
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
  public static ConnectorEndMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @param pConnectorEnd the fixed value of pattern parameter connectorEnd, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ConnectorEndMatch newMutableMatch(final Connector pConnector, final ConnectorEnd pConnectorEnd) {
    return new Mutable(pConnector, pConnectorEnd);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @param pConnectorEnd the fixed value of pattern parameter connectorEnd, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ConnectorEndMatch newMatch(final Connector pConnector, final ConnectorEnd pConnectorEnd) {
    return new Immutable(pConnector, pConnectorEnd);
  }
  
  private static final class Mutable extends ConnectorEndMatch {
    Mutable(final Connector pConnector, final ConnectorEnd pConnectorEnd) {
      super(pConnector, pConnectorEnd);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ConnectorEndMatch {
    Immutable(final Connector pConnector, final ConnectorEnd pConnectorEnd) {
      super(pConnector, pConnectorEnd);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
