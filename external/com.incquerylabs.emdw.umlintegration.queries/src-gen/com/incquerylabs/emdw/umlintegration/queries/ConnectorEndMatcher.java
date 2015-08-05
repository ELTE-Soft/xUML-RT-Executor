package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.ConnectorEndMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.ConnectorEndQuerySpecification;
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
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.connectorEnd pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ConnectorEndMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern connectorEnd(connector: Connector, connectorEnd: ConnectorEnd) {
 * 	Connector.end(connector, connectorEnd);
 * }
 * </pre></code>
 * 
 * @see ConnectorEndMatch
 * @see ConnectorEndProcessor
 * @see ConnectorEndQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ConnectorEndMatcher extends BaseMatcher<ConnectorEndMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ConnectorEndMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ConnectorEndMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ConnectorEndMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CONNECTOR = 0;
  
  private final static int POSITION_CONNECTOREND = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ConnectorEndMatcher.class);
  
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
  public ConnectorEndMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ConnectorEndMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @param pConnectorEnd the fixed value of pattern parameter connectorEnd, or null if not bound.
   * @return matches represented as a ConnectorEndMatch object.
   * 
   */
  public Collection<ConnectorEndMatch> getAllMatches(final Connector pConnector, final ConnectorEnd pConnectorEnd) {
    return rawGetAllMatches(new Object[]{pConnector, pConnectorEnd});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @param pConnectorEnd the fixed value of pattern parameter connectorEnd, or null if not bound.
   * @return a match represented as a ConnectorEndMatch object, or null if no match is found.
   * 
   */
  public ConnectorEndMatch getOneArbitraryMatch(final Connector pConnector, final ConnectorEnd pConnectorEnd) {
    return rawGetOneArbitraryMatch(new Object[]{pConnector, pConnectorEnd});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @param pConnectorEnd the fixed value of pattern parameter connectorEnd, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Connector pConnector, final ConnectorEnd pConnectorEnd) {
    return rawHasMatch(new Object[]{pConnector, pConnectorEnd});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @param pConnectorEnd the fixed value of pattern parameter connectorEnd, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Connector pConnector, final ConnectorEnd pConnectorEnd) {
    return rawCountMatches(new Object[]{pConnector, pConnectorEnd});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @param pConnectorEnd the fixed value of pattern parameter connectorEnd, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Connector pConnector, final ConnectorEnd pConnectorEnd, final IMatchProcessor<? super ConnectorEndMatch> processor) {
    rawForEachMatch(new Object[]{pConnector, pConnectorEnd}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
   * @param pConnectorEnd the fixed value of pattern parameter connectorEnd, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Connector pConnector, final ConnectorEnd pConnectorEnd, final IMatchProcessor<? super ConnectorEndMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pConnector, pConnectorEnd}, processor);
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
  public ConnectorEndMatch newMatch(final Connector pConnector, final ConnectorEnd pConnectorEnd) {
    return ConnectorEndMatch.newMatch(pConnector, pConnectorEnd);
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
  public Set<Connector> getAllValuesOfconnector(final ConnectorEndMatch partialMatch) {
    return rawAccumulateAllValuesOfconnector(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for connector.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Connector> getAllValuesOfconnector(final ConnectorEnd pConnectorEnd) {
    return rawAccumulateAllValuesOfconnector(new Object[]{
    null, 
    pConnectorEnd
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for connectorEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ConnectorEnd> rawAccumulateAllValuesOfconnectorEnd(final Object[] parameters) {
    Set<ConnectorEnd> results = new HashSet<ConnectorEnd>();
    rawAccumulateAllValues(POSITION_CONNECTOREND, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for connectorEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ConnectorEnd> getAllValuesOfconnectorEnd() {
    return rawAccumulateAllValuesOfconnectorEnd(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for connectorEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ConnectorEnd> getAllValuesOfconnectorEnd(final ConnectorEndMatch partialMatch) {
    return rawAccumulateAllValuesOfconnectorEnd(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for connectorEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ConnectorEnd> getAllValuesOfconnectorEnd(final Connector pConnector) {
    return rawAccumulateAllValuesOfconnectorEnd(new Object[]{
    pConnector, 
    null
    });
  }
  
  @Override
  protected ConnectorEndMatch tupleToMatch(final Tuple t) {
    try {
    	return ConnectorEndMatch.newMatch((org.eclipse.uml2.uml.Connector) t.get(POSITION_CONNECTOR), (org.eclipse.uml2.uml.ConnectorEnd) t.get(POSITION_CONNECTOREND));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ConnectorEndMatch arrayToMatch(final Object[] match) {
    try {
    	return ConnectorEndMatch.newMatch((org.eclipse.uml2.uml.Connector) match[POSITION_CONNECTOR], (org.eclipse.uml2.uml.ConnectorEnd) match[POSITION_CONNECTOREND]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ConnectorEndMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ConnectorEndMatch.newMutableMatch((org.eclipse.uml2.uml.Connector) match[POSITION_CONNECTOR], (org.eclipse.uml2.uml.ConnectorEnd) match[POSITION_CONNECTOREND]);
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
  public static IQuerySpecification<ConnectorEndMatcher> querySpecification() throws IncQueryException {
    return ConnectorEndQuerySpecification.instance();
  }
}
