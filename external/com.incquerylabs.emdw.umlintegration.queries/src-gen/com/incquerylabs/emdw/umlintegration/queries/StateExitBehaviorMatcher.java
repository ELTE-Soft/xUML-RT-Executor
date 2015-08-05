package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.StateExitBehaviorMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.StateExitBehaviorQuerySpecification;
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
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.State;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.stateExitBehavior pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link StateExitBehaviorMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern stateExitBehavior(state: State, exit: Behavior) {
 * 	find umlState(state);
 * 	State.exit(state, exit);
 * }
 * </pre></code>
 * 
 * @see StateExitBehaviorMatch
 * @see StateExitBehaviorProcessor
 * @see StateExitBehaviorQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class StateExitBehaviorMatcher extends BaseMatcher<StateExitBehaviorMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static StateExitBehaviorMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    StateExitBehaviorMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new StateExitBehaviorMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_STATE = 0;
  
  private final static int POSITION_EXIT = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(StateExitBehaviorMatcher.class);
  
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
  public StateExitBehaviorMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public StateExitBehaviorMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pExit the fixed value of pattern parameter exit, or null if not bound.
   * @return matches represented as a StateExitBehaviorMatch object.
   * 
   */
  public Collection<StateExitBehaviorMatch> getAllMatches(final State pState, final Behavior pExit) {
    return rawGetAllMatches(new Object[]{pState, pExit});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pExit the fixed value of pattern parameter exit, or null if not bound.
   * @return a match represented as a StateExitBehaviorMatch object, or null if no match is found.
   * 
   */
  public StateExitBehaviorMatch getOneArbitraryMatch(final State pState, final Behavior pExit) {
    return rawGetOneArbitraryMatch(new Object[]{pState, pExit});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pExit the fixed value of pattern parameter exit, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final State pState, final Behavior pExit) {
    return rawHasMatch(new Object[]{pState, pExit});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pExit the fixed value of pattern parameter exit, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final State pState, final Behavior pExit) {
    return rawCountMatches(new Object[]{pState, pExit});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pExit the fixed value of pattern parameter exit, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final State pState, final Behavior pExit, final IMatchProcessor<? super StateExitBehaviorMatch> processor) {
    rawForEachMatch(new Object[]{pState, pExit}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pExit the fixed value of pattern parameter exit, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final State pState, final Behavior pExit, final IMatchProcessor<? super StateExitBehaviorMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pState, pExit}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pExit the fixed value of pattern parameter exit, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public StateExitBehaviorMatch newMatch(final State pState, final Behavior pExit) {
    return StateExitBehaviorMatch.newMatch(pState, pExit);
  }
  
  /**
   * Retrieve the set of values that occur in matches for state.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<State> rawAccumulateAllValuesOfstate(final Object[] parameters) {
    Set<State> results = new HashSet<State>();
    rawAccumulateAllValues(POSITION_STATE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for state.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfstate() {
    return rawAccumulateAllValuesOfstate(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for state.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfstate(final StateExitBehaviorMatch partialMatch) {
    return rawAccumulateAllValuesOfstate(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for state.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfstate(final Behavior pExit) {
    return rawAccumulateAllValuesOfstate(new Object[]{
    null, 
    pExit
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for exit.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Behavior> rawAccumulateAllValuesOfexit(final Object[] parameters) {
    Set<Behavior> results = new HashSet<Behavior>();
    rawAccumulateAllValues(POSITION_EXIT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for exit.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfexit() {
    return rawAccumulateAllValuesOfexit(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for exit.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfexit(final StateExitBehaviorMatch partialMatch) {
    return rawAccumulateAllValuesOfexit(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for exit.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfexit(final State pState) {
    return rawAccumulateAllValuesOfexit(new Object[]{
    pState, 
    null
    });
  }
  
  @Override
  protected StateExitBehaviorMatch tupleToMatch(final Tuple t) {
    try {
    	return StateExitBehaviorMatch.newMatch((org.eclipse.uml2.uml.State) t.get(POSITION_STATE), (org.eclipse.uml2.uml.Behavior) t.get(POSITION_EXIT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected StateExitBehaviorMatch arrayToMatch(final Object[] match) {
    try {
    	return StateExitBehaviorMatch.newMatch((org.eclipse.uml2.uml.State) match[POSITION_STATE], (org.eclipse.uml2.uml.Behavior) match[POSITION_EXIT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected StateExitBehaviorMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return StateExitBehaviorMatch.newMutableMatch((org.eclipse.uml2.uml.State) match[POSITION_STATE], (org.eclipse.uml2.uml.Behavior) match[POSITION_EXIT]);
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
  public static IQuerySpecification<StateExitBehaviorMatcher> querySpecification() throws IncQueryException {
    return StateExitBehaviorQuerySpecification.instance();
  }
}
