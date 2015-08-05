package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtPortQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Port;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtPort pattern,
 * to be used in conjunction with {@link XtPortMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtPortMatcher
 * @see XtPortProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtPortMatch extends BasePatternMatch {
  private Component fComponent;
  
  private Port fPort;
  
  private static List<String> parameterNames = makeImmutableList("component", "port");
  
  private XtPortMatch(final Component pComponent, final Port pPort) {
    this.fComponent = pComponent;
    this.fPort = pPort;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("component".equals(parameterName)) return this.fComponent;
    if ("port".equals(parameterName)) return this.fPort;
    return null;
  }
  
  public Component getComponent() {
    return this.fComponent;
  }
  
  public Port getPort() {
    return this.fPort;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("component".equals(parameterName) ) {
    	this.fComponent = (org.eclipse.uml2.uml.Component) newValue;
    	return true;
    }
    if ("port".equals(parameterName) ) {
    	this.fPort = (org.eclipse.uml2.uml.Port) newValue;
    	return true;
    }
    return false;
  }
  
  public void setComponent(final Component pComponent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fComponent = pComponent;
  }
  
  public void setPort(final Port pPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPort = pPort;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtPort";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtPortMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fComponent, fPort};
  }
  
  @Override
  public XtPortMatch toImmutable() {
    return isMutable() ? newMatch(fComponent, fPort) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"component\"=" + prettyPrintValue(fComponent) + ", ");
    
    result.append("\"port\"=" + prettyPrintValue(fPort)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fComponent == null) ? 0 : fComponent.hashCode());
    result = prime * result + ((fPort == null) ? 0 : fPort.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtPortMatch)) { // this should be infrequent
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
    XtPortMatch other = (XtPortMatch) obj;
    if (fComponent == null) {if (other.fComponent != null) return false;}
    else if (!fComponent.equals(other.fComponent)) return false;
    if (fPort == null) {if (other.fPort != null) return false;}
    else if (!fPort.equals(other.fPort)) return false;
    return true;
  }
  
  @Override
  public XtPortQuerySpecification specification() {
    try {
    	return XtPortQuerySpecification.instance();
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
  public static XtPortMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtPortMatch newMutableMatch(final Component pComponent, final Port pPort) {
    return new Mutable(pComponent, pPort);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtPortMatch newMatch(final Component pComponent, final Port pPort) {
    return new Immutable(pComponent, pPort);
  }
  
  private static final class Mutable extends XtPortMatch {
    Mutable(final Component pComponent, final Port pPort) {
      super(pComponent, pPort);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtPortMatch {
    Immutable(final Component pComponent, final Port pPort) {
      super(pComponent, pPort);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
