package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.EventIsNotSignalEventMatch;
import hu.eltesoft.modelexecution.validation.util.EventIsNotSignalEventQuerySpecification;
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
import org.eclipse.uml2.uml.Event;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.EventIsNotSignalEvent pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link EventIsNotSignalEventMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Only signal events are supported", mark = { "ev" })
 * pattern EventIsNotSignalEvent(ev : Event) {
 * 	neg find IsSignalEvent(ev);
 * }
 * </pre></code>
 * 
 * @see EventIsNotSignalEventMatch
 * @see EventIsNotSignalEventProcessor
 * @see EventIsNotSignalEventQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class EventIsNotSignalEventMatcher extends BaseMatcher<EventIsNotSignalEventMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static EventIsNotSignalEventMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    EventIsNotSignalEventMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new EventIsNotSignalEventMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_EV = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(EventIsNotSignalEventMatcher.class);
  
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
  public EventIsNotSignalEventMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public EventIsNotSignalEventMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return matches represented as a EventIsNotSignalEventMatch object.
   * 
   */
  public Collection<EventIsNotSignalEventMatch> getAllMatches(final Event pEv) {
    return rawGetAllMatches(new Object[]{pEv});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return a match represented as a EventIsNotSignalEventMatch object, or null if no match is found.
   * 
   */
  public EventIsNotSignalEventMatch getOneArbitraryMatch(final Event pEv) {
    return rawGetOneArbitraryMatch(new Object[]{pEv});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Event pEv) {
    return rawHasMatch(new Object[]{pEv});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Event pEv) {
    return rawCountMatches(new Object[]{pEv});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Event pEv, final IMatchProcessor<? super EventIsNotSignalEventMatch> processor) {
    rawForEachMatch(new Object[]{pEv}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Event pEv, final IMatchProcessor<? super EventIsNotSignalEventMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pEv}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public EventIsNotSignalEventMatch newMatch(final Event pEv) {
    return EventIsNotSignalEventMatch.newMatch(pEv);
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Event> rawAccumulateAllValuesOfev(final Object[] parameters) {
    Set<Event> results = new HashSet<Event>();
    rawAccumulateAllValues(POSITION_EV, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Event> getAllValuesOfev() {
    return rawAccumulateAllValuesOfev(emptyArray());
  }
  
  @Override
  protected EventIsNotSignalEventMatch tupleToMatch(final Tuple t) {
    try {
    	return EventIsNotSignalEventMatch.newMatch((org.eclipse.uml2.uml.Event) t.get(POSITION_EV));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected EventIsNotSignalEventMatch arrayToMatch(final Object[] match) {
    try {
    	return EventIsNotSignalEventMatch.newMatch((org.eclipse.uml2.uml.Event) match[POSITION_EV]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected EventIsNotSignalEventMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return EventIsNotSignalEventMatch.newMutableMatch((org.eclipse.uml2.uml.Event) match[POSITION_EV]);
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
  public static IQuerySpecification<EventIsNotSignalEventMatcher> querySpecification() throws IncQueryException {
    return EventIsNotSignalEventQuerySpecification.instance();
  }
}
