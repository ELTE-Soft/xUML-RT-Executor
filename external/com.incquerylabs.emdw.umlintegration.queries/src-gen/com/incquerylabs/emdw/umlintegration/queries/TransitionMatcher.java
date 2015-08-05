package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.TransitionMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.TransitionQuerySpecification;
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
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.transition pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TransitionMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * // Transition
 * 
 * pattern transition(transition: Transition, sourceState: Vertex, targetState: Vertex) {
 * 	find toplevelTransition(_, transition, sourceState, targetState);
 * } or {
 * 	find childTransition(_, transition, sourceState, targetState);
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
  
  private final static int POSITION_TRANSITION = 0;
  
  private final static int POSITION_SOURCESTATE = 1;
  
  private final static int POSITION_TARGETSTATE = 2;
  
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
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return matches represented as a TransitionMatch object.
   * 
   */
  public Collection<TransitionMatch> getAllMatches(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return rawGetAllMatches(new Object[]{pTransition, pSourceState, pTargetState});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return a match represented as a TransitionMatch object, or null if no match is found.
   * 
   */
  public TransitionMatch getOneArbitraryMatch(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return rawGetOneArbitraryMatch(new Object[]{pTransition, pSourceState, pTargetState});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return rawHasMatch(new Object[]{pTransition, pSourceState, pTargetState});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return rawCountMatches(new Object[]{pTransition, pSourceState, pTargetState});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState, final IMatchProcessor<? super TransitionMatch> processor) {
    rawForEachMatch(new Object[]{pTransition, pSourceState, pTargetState}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState, final IMatchProcessor<? super TransitionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pTransition, pSourceState, pTargetState}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
   * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TransitionMatch newMatch(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState) {
    return TransitionMatch.newMatch(pTransition, pSourceState, pTargetState);
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
  public Set<Transition> getAllValuesOftransition(final Vertex pSourceState, final Vertex pTargetState) {
    return rawAccumulateAllValuesOftransition(new Object[]{
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
  public Set<Vertex> getAllValuesOfsourceState(final TransitionMatch partialMatch) {
    return rawAccumulateAllValuesOfsourceState(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Vertex> getAllValuesOfsourceState(final Transition pTransition, final Vertex pTargetState) {
    return rawAccumulateAllValuesOfsourceState(new Object[]{
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
  public Set<Vertex> getAllValuesOftargetState(final TransitionMatch partialMatch) {
    return rawAccumulateAllValuesOftargetState(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Vertex> getAllValuesOftargetState(final Transition pTransition, final Vertex pSourceState) {
    return rawAccumulateAllValuesOftargetState(new Object[]{
    pTransition, 
    pSourceState, 
    null
    });
  }
  
  @Override
  protected TransitionMatch tupleToMatch(final Tuple t) {
    try {
    	return TransitionMatch.newMatch((org.eclipse.uml2.uml.Transition) t.get(POSITION_TRANSITION), (org.eclipse.uml2.uml.Vertex) t.get(POSITION_SOURCESTATE), (org.eclipse.uml2.uml.Vertex) t.get(POSITION_TARGETSTATE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TransitionMatch arrayToMatch(final Object[] match) {
    try {
    	return TransitionMatch.newMatch((org.eclipse.uml2.uml.Transition) match[POSITION_TRANSITION], (org.eclipse.uml2.uml.Vertex) match[POSITION_SOURCESTATE], (org.eclipse.uml2.uml.Vertex) match[POSITION_TARGETSTATE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TransitionMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return TransitionMatch.newMutableMatch((org.eclipse.uml2.uml.Transition) match[POSITION_TRANSITION], (org.eclipse.uml2.uml.Vertex) match[POSITION_SOURCESTATE], (org.eclipse.uml2.uml.Vertex) match[POSITION_TARGETSTATE]);
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
  public static IQuerySpecification<TransitionMatcher> querySpecification() throws IncQueryException {
    return TransitionQuerySpecification.instance();
  }
}
