package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.NonPublicStateMachineMatch;
import hu.eltesoft.modelexecution.validation.util.NonPublicStateMachineQuerySpecification;
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

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.NonPublicStateMachine pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link NonPublicStateMachineMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "State machines must be public", mark = { "sm" })
 * pattern NonPublicStateMachine(sm : StateMachine) {
 * 	StateMachine.visibility(sm, visibility);
 * 	visibility != VisibilityKind::public;
 * }
 * </pre></code>
 * 
 * @see NonPublicStateMachineMatch
 * @see NonPublicStateMachineProcessor
 * @see NonPublicStateMachineQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class NonPublicStateMachineMatcher extends BaseMatcher<NonPublicStateMachineMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NonPublicStateMachineMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    NonPublicStateMachineMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new NonPublicStateMachineMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SM = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(NonPublicStateMachineMatcher.class);
  
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
  public NonPublicStateMachineMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public NonPublicStateMachineMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @return matches represented as a NonPublicStateMachineMatch object.
   * 
   */
  public Collection<NonPublicStateMachineMatch> getAllMatches(final StateMachine pSm) {
    return rawGetAllMatches(new Object[]{pSm});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @return a match represented as a NonPublicStateMachineMatch object, or null if no match is found.
   * 
   */
  public NonPublicStateMachineMatch getOneArbitraryMatch(final StateMachine pSm) {
    return rawGetOneArbitraryMatch(new Object[]{pSm});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final StateMachine pSm) {
    return rawHasMatch(new Object[]{pSm});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final StateMachine pSm) {
    return rawCountMatches(new Object[]{pSm});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final StateMachine pSm, final IMatchProcessor<? super NonPublicStateMachineMatch> processor) {
    rawForEachMatch(new Object[]{pSm}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final StateMachine pSm, final IMatchProcessor<? super NonPublicStateMachineMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSm}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public NonPublicStateMachineMatch newMatch(final StateMachine pSm) {
    return NonPublicStateMachineMatch.newMatch(pSm);
  }
  
  /**
   * Retrieve the set of values that occur in matches for sm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<StateMachine> rawAccumulateAllValuesOfsm(final Object[] parameters) {
    Set<StateMachine> results = new HashSet<StateMachine>();
    rawAccumulateAllValues(POSITION_SM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfsm() {
    return rawAccumulateAllValuesOfsm(emptyArray());
  }
  
  @Override
  protected NonPublicStateMachineMatch tupleToMatch(final Tuple t) {
    try {
    	return NonPublicStateMachineMatch.newMatch((org.eclipse.uml2.uml.StateMachine) t.get(POSITION_SM));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NonPublicStateMachineMatch arrayToMatch(final Object[] match) {
    try {
    	return NonPublicStateMachineMatch.newMatch((org.eclipse.uml2.uml.StateMachine) match[POSITION_SM]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NonPublicStateMachineMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return NonPublicStateMachineMatch.newMutableMatch((org.eclipse.uml2.uml.StateMachine) match[POSITION_SM]);
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
  public static IQuerySpecification<NonPublicStateMachineMatcher> querySpecification() throws IncQueryException {
    return NonPublicStateMachineQuerySpecification.instance();
  }
}
