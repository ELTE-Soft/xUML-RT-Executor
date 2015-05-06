package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.TransitionMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.TransitionQuerySpecification;
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
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.Transition pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TransitionMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern
 * Transition(region : Region, source : State, transition : Transition, eventName, target : State) {
 * 	Transition.container(transition, region);
 * 
 * 	Transition.source(transition, source);
 * 	Transition.target(transition, target);
 * 
 * 	Transition.trigger(transition, trigger);
 * 	Trigger.event(trigger, event);
 * 	Event.name(event, eventName);
 * }
 * </pre></code>
 * 
 * @see TransitionMatch
 * @see TransitionProcessor
 * @see TransitionQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TransitionMatcher extends BaseMatcher<TransitionMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<TransitionMatcher> querySpecification() throws IncQueryException {
    return TransitionQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TransitionMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    TransitionMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new TransitionMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_REGION = 0;
  
  private final static int POSITION_SOURCE = 1;
  
  private final static int POSITION_TRANSITION = 2;
  
  private final static int POSITION_EVENTNAME = 3;
  
  private final static int POSITION_TARGET = 4;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(TransitionMatcher.class);
  
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
  public TransitionMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public TransitionMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEventName the fixed value of pattern parameter eventName, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return matches represented as a TransitionMatch object.
   * 
   */
  public Collection<TransitionMatch> getAllMatches(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget) {
    return rawGetAllMatches(new Object[]{pRegion, pSource, pTransition, pEventName, pTarget});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEventName the fixed value of pattern parameter eventName, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return a match represented as a TransitionMatch object, or null if no match is found.
   * 
   */
  public TransitionMatch getOneArbitraryMatch(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget) {
    return rawGetOneArbitraryMatch(new Object[]{pRegion, pSource, pTransition, pEventName, pTarget});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEventName the fixed value of pattern parameter eventName, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget) {
    return rawHasMatch(new Object[]{pRegion, pSource, pTransition, pEventName, pTarget});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEventName the fixed value of pattern parameter eventName, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget) {
    return rawCountMatches(new Object[]{pRegion, pSource, pTransition, pEventName, pTarget});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEventName the fixed value of pattern parameter eventName, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget, final IMatchProcessor<? super TransitionMatch> processor) {
    rawForEachMatch(new Object[]{pRegion, pSource, pTransition, pEventName, pTarget}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEventName the fixed value of pattern parameter eventName, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget, final IMatchProcessor<? super TransitionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRegion, pSource, pTransition, pEventName, pTarget}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEventName the fixed value of pattern parameter eventName, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<TransitionMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pRegion, pSource, pTransition, pEventName, pTarget});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEventName the fixed value of pattern parameter eventName, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TransitionMatch newMatch(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final State pTarget) {
    return TransitionMatch.newMatch(pRegion, pSource, pTransition, pEventName, pTarget);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for region.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Region> rawAccumulateAllValuesOfregion(final Object[] parameters) {
    Set<Region> results = new HashSet<Region>();
    rawAccumulateAllValues(POSITION_REGION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for region.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfregion() {
    return rawAccumulateAllValuesOfregion(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for region.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfregion(final TransitionMatch partialMatch) {
    return rawAccumulateAllValuesOfregion(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for region.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfregion(final State pSource, final Transition pTransition, final String pEventName, final State pTarget) {
    return rawAccumulateAllValuesOfregion(new Object[]{null, pSource, pTransition, pEventName, pTarget});
  }
  
  /**
   * Retrieve the set of values that occur in matches for source.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<State> rawAccumulateAllValuesOfsource(final Object[] parameters) {
    Set<State> results = new HashSet<State>();
    rawAccumulateAllValues(POSITION_SOURCE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for source.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfsource() {
    return rawAccumulateAllValuesOfsource(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for source.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfsource(final TransitionMatch partialMatch) {
    return rawAccumulateAllValuesOfsource(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for source.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfsource(final Region pRegion, final Transition pTransition, final String pEventName, final State pTarget) {
    return rawAccumulateAllValuesOfsource(new Object[]{pRegion, null, pTransition, pEventName, pTarget});
  }
  
  /**
   * Retrieve the set of values that occur in matches for transition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Transition> rawAccumulateAllValuesOftransition(final Object[] parameters) {
    Set<Transition> results = new HashSet<Transition>();
    rawAccumulateAllValues(POSITION_TRANSITION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for transition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftransition() {
    return rawAccumulateAllValuesOftransition(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for transition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftransition(final TransitionMatch partialMatch) {
    return rawAccumulateAllValuesOftransition(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for transition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftransition(final Region pRegion, final State pSource, final String pEventName, final State pTarget) {
    return rawAccumulateAllValuesOftransition(new Object[]{pRegion, pSource, null, pEventName, pTarget});
  }
  
  /**
   * Retrieve the set of values that occur in matches for eventName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfeventName(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_EVENTNAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for eventName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfeventName() {
    return rawAccumulateAllValuesOfeventName(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for eventName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfeventName(final TransitionMatch partialMatch) {
    return rawAccumulateAllValuesOfeventName(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for eventName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfeventName(final Region pRegion, final State pSource, final Transition pTransition, final State pTarget) {
    return rawAccumulateAllValuesOfeventName(new Object[]{pRegion, pSource, pTransition, null, pTarget});
  }
  
  /**
   * Retrieve the set of values that occur in matches for target.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<State> rawAccumulateAllValuesOftarget(final Object[] parameters) {
    Set<State> results = new HashSet<State>();
    rawAccumulateAllValues(POSITION_TARGET, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for target.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOftarget() {
    return rawAccumulateAllValuesOftarget(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for target.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOftarget(final TransitionMatch partialMatch) {
    return rawAccumulateAllValuesOftarget(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for target.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOftarget(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName) {
    return rawAccumulateAllValuesOftarget(new Object[]{pRegion, pSource, pTransition, pEventName, null});
  }
  
  @Override
  protected TransitionMatch tupleToMatch(final Tuple t) {
    try {
      return TransitionMatch.newMatch((org.eclipse.uml2.uml.Region) t.get(POSITION_REGION), (org.eclipse.uml2.uml.State) t.get(POSITION_SOURCE), (org.eclipse.uml2.uml.Transition) t.get(POSITION_TRANSITION), (java.lang.String) t.get(POSITION_EVENTNAME), (org.eclipse.uml2.uml.State) t.get(POSITION_TARGET));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected TransitionMatch arrayToMatch(final Object[] match) {
    try {
      return TransitionMatch.newMatch((org.eclipse.uml2.uml.Region) match[POSITION_REGION], (org.eclipse.uml2.uml.State) match[POSITION_SOURCE], (org.eclipse.uml2.uml.Transition) match[POSITION_TRANSITION], (java.lang.String) match[POSITION_EVENTNAME], (org.eclipse.uml2.uml.State) match[POSITION_TARGET]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected TransitionMatch arrayToMatchMutable(final Object[] match) {
    try {
      return TransitionMatch.newMutableMatch((org.eclipse.uml2.uml.Region) match[POSITION_REGION], (org.eclipse.uml2.uml.State) match[POSITION_SOURCE], (org.eclipse.uml2.uml.Transition) match[POSITION_TRANSITION], (java.lang.String) match[POSITION_EVENTNAME], (org.eclipse.uml2.uml.State) match[POSITION_TARGET]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
