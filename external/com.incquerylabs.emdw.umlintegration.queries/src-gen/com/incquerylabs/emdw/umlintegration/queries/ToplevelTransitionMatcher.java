package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.ToplevelTransitionMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelTransitionQuerySpecification;
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
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.toplevelTransition pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ToplevelTransitionMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern toplevelTransition(stateMachine: StateMachine, transition: Transition, sourceState: Vertex, targetState: Vertex) {
 * 	find stateMachine(_, stateMachine);
 * 	StateMachine.region(stateMachine, region);
 * 	find transitionOfRegion(region, transition, sourceState, targetState);
 * }
 * </pre></code>
 * 
 * @see ToplevelTransitionMatch
 * @see ToplevelTransitionProcessor
 * @see ToplevelTransitionQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ToplevelTransitionMatcher extends BaseMatcher<ToplevelTransitionMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ToplevelTransitionMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ToplevelTransitionMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ToplevelTransitionMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_STATEMACHINE = 0;
  
  private final static int POSITION_TRANSITION = 1;
  
  private final static int POSITION_SOURCESTATE = 2;
  
  private final static int POSITION_TARGETSTATE = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ToplevelTransitionMatcher.class);
  
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
  public ToplevelTransitionMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ToplevelTransitionMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return matches represented as a ToplevelTransitionMatch object.
   * 
   */
  public Collection<ToplevelTransitionMatch> getAllMatches(final StateMachine pStateMachine, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return rawGetAllMatches(new Object[]{pStateMachine, pTransition, pSourceState, pTargetState});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return a match represented as a ToplevelTransitionMatch object, or null if no match is found.
   * 
   */
  public ToplevelTransitionMatch getOneArbitraryMatch(final StateMachine pStateMachine, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return rawGetOneArbitraryMatch(new Object[]{pStateMachine, pTransition, pSourceState, pTargetState});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final StateMachine pStateMachine, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return rawHasMatch(new Object[]{pStateMachine, pTransition, pSourceState, pTargetState});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final StateMachine pStateMachine, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return rawCountMatches(new Object[]{pStateMachine, pTransition, pSourceState, pTargetState});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final StateMachine pStateMachine, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState, final IMatchProcessor<? super ToplevelTransitionMatch> processor) {
    rawForEachMatch(new Object[]{pStateMachine, pTransition, pSourceState, pTargetState}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final StateMachine pStateMachine, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState, final IMatchProcessor<? super ToplevelTransitionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pStateMachine, pTransition, pSourceState, pTargetState}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ToplevelTransitionMatch newMatch(final StateMachine pStateMachine, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return ToplevelTransitionMatch.newMatch(pStateMachine, pTransition, pSourceState, pTargetState);
  }
  
  /**
   * Retrieve the set of values that occur in matches for stateMachine.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<StateMachine> rawAccumulateAllValuesOfstateMachine(final Object[] parameters) {
    Set<StateMachine> results = new HashSet<StateMachine>();
    rawAccumulateAllValues(POSITION_STATEMACHINE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for stateMachine.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfstateMachine() {
    return rawAccumulateAllValuesOfstateMachine(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for stateMachine.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfstateMachine(final ToplevelTransitionMatch partialMatch) {
    return rawAccumulateAllValuesOfstateMachine(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for stateMachine.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfstateMachine(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return rawAccumulateAllValuesOfstateMachine(new Object[]{
    null, 
    pTransition, 
    pSourceState, 
    pTargetState
    });
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
  public Set<Transition> getAllValuesOftransition(final ToplevelTransitionMatch partialMatch) {
    return rawAccumulateAllValuesOftransition(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for transition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftransition(final StateMachine pStateMachine, final Vertex pSourceState, final Vertex pTargetState) {
    return rawAccumulateAllValuesOftransition(new Object[]{
    pStateMachine, 
    null, 
    pSourceState, 
    pTargetState
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Vertex> rawAccumulateAllValuesOfsourceState(final Object[] parameters) {
    Set<Vertex> results = new HashSet<Vertex>();
    rawAccumulateAllValues(POSITION_SOURCESTATE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Vertex> getAllValuesOfsourceState() {
    return rawAccumulateAllValuesOfsourceState(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Vertex> getAllValuesOfsourceState(final ToplevelTransitionMatch partialMatch) {
    return rawAccumulateAllValuesOfsourceState(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Vertex> getAllValuesOfsourceState(final StateMachine pStateMachine, final Transition pTransition, final Vertex pTargetState) {
    return rawAccumulateAllValuesOfsourceState(new Object[]{
    pStateMachine, 
    pTransition, 
    null, 
    pTargetState
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Vertex> rawAccumulateAllValuesOftargetState(final Object[] parameters) {
    Set<Vertex> results = new HashSet<Vertex>();
    rawAccumulateAllValues(POSITION_TARGETSTATE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Vertex> getAllValuesOftargetState() {
    return rawAccumulateAllValuesOftargetState(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Vertex> getAllValuesOftargetState(final ToplevelTransitionMatch partialMatch) {
    return rawAccumulateAllValuesOftargetState(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Vertex> getAllValuesOftargetState(final StateMachine pStateMachine, final Transition pTransition, final Vertex pSourceState) {
    return rawAccumulateAllValuesOftargetState(new Object[]{
    pStateMachine, 
    pTransition, 
    pSourceState, 
    null
    });
  }
  
  @Override
  protected ToplevelTransitionMatch tupleToMatch(final Tuple t) {
    try {
    	return ToplevelTransitionMatch.newMatch((org.eclipse.uml2.uml.StateMachine) t.get(POSITION_STATEMACHINE), (org.eclipse.uml2.uml.Transition) t.get(POSITION_TRANSITION), (org.eclipse.uml2.uml.Vertex) t.get(POSITION_SOURCESTATE), (org.eclipse.uml2.uml.Vertex) t.get(POSITION_TARGETSTATE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ToplevelTransitionMatch arrayToMatch(final Object[] match) {
    try {
    	return ToplevelTransitionMatch.newMatch((org.eclipse.uml2.uml.StateMachine) match[POSITION_STATEMACHINE], (org.eclipse.uml2.uml.Transition) match[POSITION_TRANSITION], (org.eclipse.uml2.uml.Vertex) match[POSITION_SOURCESTATE], (org.eclipse.uml2.uml.Vertex) match[POSITION_TARGETSTATE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ToplevelTransitionMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ToplevelTransitionMatch.newMutableMatch((org.eclipse.uml2.uml.StateMachine) match[POSITION_STATEMACHINE], (org.eclipse.uml2.uml.Transition) match[POSITION_TRANSITION], (org.eclipse.uml2.uml.Vertex) match[POSITION_SOURCESTATE], (org.eclipse.uml2.uml.Vertex) match[POSITION_TARGETSTATE]);
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
  public static IQuerySpecification<ToplevelTransitionMatcher> querySpecification() throws IncQueryException {
    return ToplevelTransitionQuerySpecification.instance();
  }
}
