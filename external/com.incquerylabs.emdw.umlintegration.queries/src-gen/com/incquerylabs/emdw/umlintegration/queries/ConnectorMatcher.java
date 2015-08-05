package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.ConnectorMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.ConnectorQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.connector pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ConnectorMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern connector(component: Component, connector: Connector) {
 * 	Component.ownedConnector(component, connector);
 * }
 * </pre></code>
 * 
 * @see ConnectorMatch
 * @see ConnectorProcessor
 * @see ConnectorQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ConnectorMatcher extends BaseMatcher<ConnectorMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ConnectorMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ConnectorMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ConnectorMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_COMPONENT = 0;
  
  private final static int POSITION_CONNECTOR = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ConnectorMatcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public ConnectorMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public ConnectorMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @return matches represented as a ConnectorMatch object.
   * 
   */
  public Collection<ConnectorMatch> getAllMatches(final Component pComponent, final Connector pConnector) {
    return rawGetAllMatches(new Object[]{pComponent, pConnector});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @return a match represented as a ConnectorMatch object, or null if no match is found.
   * 
   */
  public ConnectorMatch getOneArbitraryMatch(final Component pComponent, final Connector pConnector) {
    return rawGetOneArbitraryMatch(new Object[]{pComponent, pConnector});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Component pComponent, final Connector pConnector) {
    return rawHasMatch(new Object[]{pComponent, pConnector});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Component pComponent, final Connector pConnector) {
    return rawCountMatches(new Object[]{pComponent, pConnector});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Component pComponent, final Connector pConnector, final IMatchProcessor<? super ConnectorMatch> processor) {
    rawForEachMatch(new Object[]{pComponent, pConnector}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Component pComponent, final Connector pConnector, final IMatchProcessor<? super ConnectorMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pComponent, pConnector}, processor);
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
  public ConnectorMatch newMatch(final Component pComponent, final Connector pConnector) {
    return ConnectorMatch.newMatch(pComponent, pConnector);
  }
  
  /**
   * Retrieve the set of values that occur in matches for component.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Component> rawAccumulateAllValuesOfcomponent(final Object[] parameters) {
    Set<Component> results = new HashSet<Component>();
    rawAccumulateAllValues(POSITION_COMPONENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for component.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfcomponent() {
    return rawAccumulateAllValuesOfcomponent(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for component.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfcomponent(final ConnectorMatch partialMatch) {
    return rawAccumulateAllValuesOfcomponent(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for component.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfcomponent(final Connector pConnector) {
    return rawAccumulateAllValuesOfcomponent(new Object[]{
    null, 
    pConnector
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for connector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Connector> rawAccumulateAllValuesOfconnector(final Object[] parameters) {
    Set<Connector> results = new HashSet<Connector>();
    rawAccumulateAllValues(POSITION_CONNECTOR, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for connector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Connector> getAllValuesOfconnector() {
    return rawAccumulateAllValuesOfconnector(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for connector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Connector> getAllValuesOfconnector(final ConnectorMatch partialMatch) {
    return rawAccumulateAllValuesOfconnector(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for connector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Connector> getAllValuesOfconnector(final Component pComponent) {
    return rawAccumulateAllValuesOfconnector(new Object[]{
    pComponent, 
    null
    });
  }
  
  @Override
  protected ConnectorMatch tupleToMatch(final Tuple t) {
    try {
    	return ConnectorMatch.newMatch((org.eclipse.uml2.uml.Component) t.get(POSITION_COMPONENT), (org.eclipse.uml2.uml.Connector) t.get(POSITION_CONNECTOR));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ConnectorMatch arrayToMatch(final Object[] match) {
    try {
    	return ConnectorMatch.newMatch((org.eclipse.uml2.uml.Component) match[POSITION_COMPONENT], (org.eclipse.uml2.uml.Connector) match[POSITION_CONNECTOR]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ConnectorMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ConnectorMatch.newMutableMatch((org.eclipse.uml2.uml.Component) match[POSITION_COMPONENT], (org.eclipse.uml2.uml.Connector) match[POSITION_CONNECTOR]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<ConnectorMatcher> querySpecification() throws IncQueryException {
    return ConnectorQuerySpecification.instance();
  }
}
