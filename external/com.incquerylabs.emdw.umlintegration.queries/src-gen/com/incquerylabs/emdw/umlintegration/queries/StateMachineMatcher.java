package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.StateMachineMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.StateMachineQuerySpecification;
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
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.stateMachine pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link StateMachineMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern stateMachine(behavioredClassifier: BehavioredClassifier, stateMachine: StateMachine) {
 * 	BehavioredClassifier.classifierBehavior(behavioredClassifier, stateMachine);
 * }
 * </pre></code>
 * 
 * @see StateMachineMatch
 * @see StateMachineProcessor
 * @see StateMachineQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class StateMachineMatcher extends BaseMatcher<StateMachineMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static StateMachineMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    StateMachineMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new StateMachineMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_BEHAVIOREDCLASSIFIER = 0;
  
  private final static int POSITION_STATEMACHINE = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(StateMachineMatcher.class);
  
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
  public StateMachineMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public StateMachineMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBehavioredClassifier the fixed value of pattern parameter behavioredClassifier, or null if not bound.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @return matches represented as a StateMachineMatch object.
   * 
   */
  public Collection<StateMachineMatch> getAllMatches(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine) {
    return rawGetAllMatches(new Object[]{pBehavioredClassifier, pStateMachine});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBehavioredClassifier the fixed value of pattern parameter behavioredClassifier, or null if not bound.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @return a match represented as a StateMachineMatch object, or null if no match is found.
   * 
   */
  public StateMachineMatch getOneArbitraryMatch(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine) {
    return rawGetOneArbitraryMatch(new Object[]{pBehavioredClassifier, pStateMachine});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBehavioredClassifier the fixed value of pattern parameter behavioredClassifier, or null if not bound.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine) {
    return rawHasMatch(new Object[]{pBehavioredClassifier, pStateMachine});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBehavioredClassifier the fixed value of pattern parameter behavioredClassifier, or null if not bound.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine) {
    return rawCountMatches(new Object[]{pBehavioredClassifier, pStateMachine});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBehavioredClassifier the fixed value of pattern parameter behavioredClassifier, or null if not bound.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine, final IMatchProcessor<? super StateMachineMatch> processor) {
    rawForEachMatch(new Object[]{pBehavioredClassifier, pStateMachine}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBehavioredClassifier the fixed value of pattern parameter behavioredClassifier, or null if not bound.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine, final IMatchProcessor<? super StateMachineMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBehavioredClassifier, pStateMachine}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBehavioredClassifier the fixed value of pattern parameter behavioredClassifier, or null if not bound.
   * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public StateMachineMatch newMatch(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine) {
    return StateMachineMatch.newMatch(pBehavioredClassifier, pStateMachine);
  }
  
  /**
   * Retrieve the set of values that occur in matches for behavioredClassifier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<BehavioredClassifier> rawAccumulateAllValuesOfbehavioredClassifier(final Object[] parameters) {
    Set<BehavioredClassifier> results = new HashSet<BehavioredClassifier>();
    rawAccumulateAllValues(POSITION_BEHAVIOREDCLASSIFIER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for behavioredClassifier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BehavioredClassifier> getAllValuesOfbehavioredClassifier() {
    return rawAccumulateAllValuesOfbehavioredClassifier(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for behavioredClassifier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BehavioredClassifier> getAllValuesOfbehavioredClassifier(final StateMachineMatch partialMatch) {
    return rawAccumulateAllValuesOfbehavioredClassifier(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for behavioredClassifier.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BehavioredClassifier> getAllValuesOfbehavioredClassifier(final StateMachine pStateMachine) {
    return rawAccumulateAllValuesOfbehavioredClassifier(new Object[]{
    null, 
    pStateMachine
    });
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
  public Set<StateMachine> getAllValuesOfstateMachine(final StateMachineMatch partialMatch) {
    return rawAccumulateAllValuesOfstateMachine(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for stateMachine.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfstateMachine(final BehavioredClassifier pBehavioredClassifier) {
    return rawAccumulateAllValuesOfstateMachine(new Object[]{
    pBehavioredClassifier, 
    null
    });
  }
  
  @Override
  protected StateMachineMatch tupleToMatch(final Tuple t) {
    try {
    	return StateMachineMatch.newMatch((org.eclipse.uml2.uml.BehavioredClassifier) t.get(POSITION_BEHAVIOREDCLASSIFIER), (org.eclipse.uml2.uml.StateMachine) t.get(POSITION_STATEMACHINE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected StateMachineMatch arrayToMatch(final Object[] match) {
    try {
    	return StateMachineMatch.newMatch((org.eclipse.uml2.uml.BehavioredClassifier) match[POSITION_BEHAVIOREDCLASSIFIER], (org.eclipse.uml2.uml.StateMachine) match[POSITION_STATEMACHINE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected StateMachineMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return StateMachineMatch.newMutableMatch((org.eclipse.uml2.uml.BehavioredClassifier) match[POSITION_BEHAVIOREDCLASSIFIER], (org.eclipse.uml2.uml.StateMachine) match[POSITION_STATEMACHINE]);
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
  public static IQuerySpecification<StateMachineMatcher> querySpecification() throws IncQueryException {
    return StateMachineQuerySpecification.instance();
  }
}
