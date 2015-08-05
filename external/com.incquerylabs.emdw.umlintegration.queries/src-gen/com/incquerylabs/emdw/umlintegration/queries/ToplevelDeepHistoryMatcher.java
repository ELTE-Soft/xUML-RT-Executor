package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.ToplevelDeepHistoryMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelDeepHistoryQuerySpecification;
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
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.toplevelDeepHistory pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ToplevelDeepHistoryMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern toplevelDeepHistory(stateMachine: StateMachine, pseudostate: Pseudostate) {
 * 	find stateMachine(_, stateMachine);
 * 	StateMachine.region(stateMachine, region);
 * 	find pseudostateOfRegion(region, pseudostate, PseudostateKind::deepHistory);
 * }
 * </pre></code>
 * 
 * @see ToplevelDeepHistoryMatch
 * @see ToplevelDeepHistoryProcessor
 * @see ToplevelDeepHistoryQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ToplevelDeepHistoryMatcher extends BaseMatcher<ToplevelDeepHistoryMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ToplevelDeepHistoryMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ToplevelDeepHistoryMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ToplevelDeepHistoryMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_STATEMACHINE = 0;
  
  private final static int POSITION_PSEUDOSTATE = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ToplevelDeepHistoryMatcher.class);
  
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
  public ToplevelDeepHistoryMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ToplevelDeepHistoryMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @return matches represented as a ToplevelDeepHistoryMatch object.
   * 
   */
  public Collection<ToplevelDeepHistoryMatch> getAllMatches(final StateMachine pStateMachine, final Pseudostate pPseudostate) {
    return rawGetAllMatches(new Object[]{pStateMachine, pPseudostate});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @return a match represented as a ToplevelDeepHistoryMatch object, or null if no match is found.
   * 
   */
  public ToplevelDeepHistoryMatch getOneArbitraryMatch(final StateMachine pStateMachine, final Pseudostate pPseudostate) {
    return rawGetOneArbitraryMatch(new Object[]{pStateMachine, pPseudostate});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final StateMachine pStateMachine, final Pseudostate pPseudostate) {
    return rawHasMatch(new Object[]{pStateMachine, pPseudostate});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final StateMachine pStateMachine, final Pseudostate pPseudostate) {
    return rawCountMatches(new Object[]{pStateMachine, pPseudostate});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final StateMachine pStateMachine, final Pseudostate pPseudostate, final IMatchProcessor<? super ToplevelDeepHistoryMatch> processor) {
    rawForEachMatch(new Object[]{pStateMachine, pPseudostate}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final StateMachine pStateMachine, final Pseudostate pPseudostate, final IMatchProcessor<? super ToplevelDeepHistoryMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pStateMachine, pPseudostate}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param pPseudostate the fixed value of pattern parameter pseudostate, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ToplevelDeepHistoryMatch newMatch(final StateMachine pStateMachine, final Pseudostate pPseudostate) {
    return ToplevelDeepHistoryMatch.newMatch(pStateMachine, pPseudostate);
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
  public Set<StateMachine> getAllValuesOfstateMachine(final ToplevelDeepHistoryMatch partialMatch) {
    return rawAccumulateAllValuesOfstateMachine(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for stateMachine.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfstateMachine(final Pseudostate pPseudostate) {
    return rawAccumulateAllValuesOfstateMachine(new Object[]{
    null, 
    pPseudostate
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for pseudostate.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Pseudostate> rawAccumulateAllValuesOfpseudostate(final Object[] parameters) {
    Set<Pseudostate> results = new HashSet<Pseudostate>();
    rawAccumulateAllValues(POSITION_PSEUDOSTATE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for pseudostate.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfpseudostate() {
    return rawAccumulateAllValuesOfpseudostate(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for pseudostate.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfpseudostate(final ToplevelDeepHistoryMatch partialMatch) {
    return rawAccumulateAllValuesOfpseudostate(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for pseudostate.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfpseudostate(final StateMachine pStateMachine) {
    return rawAccumulateAllValuesOfpseudostate(new Object[]{
    pStateMachine, 
    null
    });
  }
  
  @Override
  protected ToplevelDeepHistoryMatch tupleToMatch(final Tuple t) {
    try {
    	return ToplevelDeepHistoryMatch.newMatch((org.eclipse.uml2.uml.StateMachine) t.get(POSITION_STATEMACHINE), (org.eclipse.uml2.uml.Pseudostate) t.get(POSITION_PSEUDOSTATE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ToplevelDeepHistoryMatch arrayToMatch(final Object[] match) {
    try {
    	return ToplevelDeepHistoryMatch.newMatch((org.eclipse.uml2.uml.StateMachine) match[POSITION_STATEMACHINE], (org.eclipse.uml2.uml.Pseudostate) match[POSITION_PSEUDOSTATE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ToplevelDeepHistoryMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ToplevelDeepHistoryMatch.newMutableMatch((org.eclipse.uml2.uml.StateMachine) match[POSITION_STATEMACHINE], (org.eclipse.uml2.uml.Pseudostate) match[POSITION_PSEUDOSTATE]);
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
  public static IQuerySpecification<ToplevelDeepHistoryMatcher> querySpecification() throws IncQueryException {
    return ToplevelDeepHistoryQuerySpecification.instance();
  }
}
