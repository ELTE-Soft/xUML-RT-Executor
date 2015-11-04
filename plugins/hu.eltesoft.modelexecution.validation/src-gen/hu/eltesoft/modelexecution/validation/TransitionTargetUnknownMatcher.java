package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.TransitionTargetUnknownMatch;
import hu.eltesoft.modelexecution.validation.util.TransitionTargetUnknownQuerySpecification;
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

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.TransitionTargetUnknown pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TransitionTargetUnknownMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "The target of the transition is an initial pseudostate or a state", mark = { "tr" })
 * pattern TransitionTargetUnknown(tr : Transition) {
 * 	neg find TransitionTarget(tr, _);
 * }
 * </pre></code>
 * 
 * @see TransitionTargetUnknownMatch
 * @see TransitionTargetUnknownProcessor
 * @see TransitionTargetUnknownQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TransitionTargetUnknownMatcher extends BaseMatcher<TransitionTargetUnknownMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TransitionTargetUnknownMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    TransitionTargetUnknownMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new TransitionTargetUnknownMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_TR = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(TransitionTargetUnknownMatcher.class);
  
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
  public TransitionTargetUnknownMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public TransitionTargetUnknownMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTr the fixed value of pattern parameter tr, or null if not bound.
   * @return matches represented as a TransitionTargetUnknownMatch object.
   * 
   */
  public Collection<TransitionTargetUnknownMatch> getAllMatches(final Transition pTr) {
    return rawGetAllMatches(new Object[]{pTr});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTr the fixed value of pattern parameter tr, or null if not bound.
   * @return a match represented as a TransitionTargetUnknownMatch object, or null if no match is found.
   * 
   */
  public TransitionTargetUnknownMatch getOneArbitraryMatch(final Transition pTr) {
    return rawGetOneArbitraryMatch(new Object[]{pTr});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pTr the fixed value of pattern parameter tr, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Transition pTr) {
    return rawHasMatch(new Object[]{pTr});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTr the fixed value of pattern parameter tr, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Transition pTr) {
    return rawCountMatches(new Object[]{pTr});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pTr the fixed value of pattern parameter tr, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Transition pTr, final IMatchProcessor<? super TransitionTargetUnknownMatch> processor) {
    rawForEachMatch(new Object[]{pTr}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTr the fixed value of pattern parameter tr, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Transition pTr, final IMatchProcessor<? super TransitionTargetUnknownMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pTr}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTr the fixed value of pattern parameter tr, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TransitionTargetUnknownMatch newMatch(final Transition pTr) {
    return TransitionTargetUnknownMatch.newMatch(pTr);
  }
  
  /**
   * Retrieve the set of values that occur in matches for tr.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Transition> rawAccumulateAllValuesOftr(final Object[] parameters) {
    Set<Transition> results = new HashSet<Transition>();
    rawAccumulateAllValues(POSITION_TR, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for tr.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftr() {
    return rawAccumulateAllValuesOftr(emptyArray());
  }
  
  @Override
  protected TransitionTargetUnknownMatch tupleToMatch(final Tuple t) {
    try {
    	return TransitionTargetUnknownMatch.newMatch((org.eclipse.uml2.uml.Transition) t.get(POSITION_TR));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TransitionTargetUnknownMatch arrayToMatch(final Object[] match) {
    try {
    	return TransitionTargetUnknownMatch.newMatch((org.eclipse.uml2.uml.Transition) match[POSITION_TR]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TransitionTargetUnknownMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return TransitionTargetUnknownMatch.newMutableMatch((org.eclipse.uml2.uml.Transition) match[POSITION_TR]);
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
  public static IQuerySpecification<TransitionTargetUnknownMatcher> querySpecification() throws IncQueryException {
    return TransitionTargetUnknownQuerySpecification.instance();
  }
}
