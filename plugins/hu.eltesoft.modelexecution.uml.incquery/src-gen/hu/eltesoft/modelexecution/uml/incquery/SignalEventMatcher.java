package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalEventQuerySpecification;
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
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.SignalEvent pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SignalEventMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern SignalEvent(event : SignalEvent, signal : Signal) {
 * 	SignalEvent.signal(event, signal);
 * }
 * </pre></code>
 * 
 * @see SignalEventMatch
 * @see SignalEventProcessor
 * @see SignalEventQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SignalEventMatcher extends BaseMatcher<SignalEventMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<SignalEventMatcher> querySpecification() throws IncQueryException {
    return SignalEventQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SignalEventMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SignalEventMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SignalEventMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_EVENT = 0;
  
  private final static int POSITION_SIGNAL = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SignalEventMatcher.class);
  
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
  public SignalEventMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SignalEventMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return matches represented as a SignalEventMatch object.
   * 
   */
  public Collection<SignalEventMatch> getAllMatches(final SignalEvent pEvent, final Signal pSignal) {
    return rawGetAllMatches(new Object[]{pEvent, pSignal});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return a match represented as a SignalEventMatch object, or null if no match is found.
   * 
   */
  public SignalEventMatch getOneArbitraryMatch(final SignalEvent pEvent, final Signal pSignal) {
    return rawGetOneArbitraryMatch(new Object[]{pEvent, pSignal});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final SignalEvent pEvent, final Signal pSignal) {
    return rawHasMatch(new Object[]{pEvent, pSignal});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final SignalEvent pEvent, final Signal pSignal) {
    return rawCountMatches(new Object[]{pEvent, pSignal});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final SignalEvent pEvent, final Signal pSignal, final IMatchProcessor<? super SignalEventMatch> processor) {
    rawForEachMatch(new Object[]{pEvent, pSignal}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final SignalEvent pEvent, final Signal pSignal, final IMatchProcessor<? super SignalEventMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pEvent, pSignal}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<SignalEventMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final SignalEvent pEvent, final Signal pSignal) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pEvent, pSignal});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEvent the fixed value of pattern parameter event, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SignalEventMatch newMatch(final SignalEvent pEvent, final Signal pSignal) {
    return SignalEventMatch.newMatch(pEvent, pSignal);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for event.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SignalEvent> rawAccumulateAllValuesOfevent(final Object[] parameters) {
    Set<SignalEvent> results = new HashSet<SignalEvent>();
    rawAccumulateAllValues(POSITION_EVENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for event.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SignalEvent> getAllValuesOfevent() {
    return rawAccumulateAllValuesOfevent(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for event.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SignalEvent> getAllValuesOfevent(final SignalEventMatch partialMatch) {
    return rawAccumulateAllValuesOfevent(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for event.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SignalEvent> getAllValuesOfevent(final Signal pSignal) {
    return rawAccumulateAllValuesOfevent(new Object[]{null, pSignal});
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Signal> rawAccumulateAllValuesOfsignal(final Object[] parameters) {
    Set<Signal> results = new HashSet<Signal>();
    rawAccumulateAllValues(POSITION_SIGNAL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal() {
    return rawAccumulateAllValuesOfsignal(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final SignalEventMatch partialMatch) {
    return rawAccumulateAllValuesOfsignal(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final SignalEvent pEvent) {
    return rawAccumulateAllValuesOfsignal(new Object[]{pEvent, null});
  }
  
  @Override
  protected SignalEventMatch tupleToMatch(final Tuple t) {
    try {
      return SignalEventMatch.newMatch((org.eclipse.uml2.uml.SignalEvent) t.get(POSITION_EVENT), (org.eclipse.uml2.uml.Signal) t.get(POSITION_SIGNAL));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected SignalEventMatch arrayToMatch(final Object[] match) {
    try {
      return SignalEventMatch.newMatch((org.eclipse.uml2.uml.SignalEvent) match[POSITION_EVENT], (org.eclipse.uml2.uml.Signal) match[POSITION_SIGNAL]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected SignalEventMatch arrayToMatchMutable(final Object[] match) {
    try {
      return SignalEventMatch.newMutableMatch((org.eclipse.uml2.uml.SignalEvent) match[POSITION_EVENT], (org.eclipse.uml2.uml.Signal) match[POSITION_SIGNAL]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
