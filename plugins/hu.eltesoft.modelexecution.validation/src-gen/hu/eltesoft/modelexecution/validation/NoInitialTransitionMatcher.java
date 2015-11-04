package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.NoInitialTransitionMatch;
import hu.eltesoft.modelexecution.validation.util.NoInitialTransitionQuerySpecification;
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

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.NoInitialTransition pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link NoInitialTransitionMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "No transition from an initial pseudostate", mark = { "src" })
 * pattern NoInitialTransition(src : Pseudostate) {
 * 	find InitialState(_, src);
 * 	neg find InitialTransition(src, _);
 * }
 * </pre></code>
 * 
 * @see NoInitialTransitionMatch
 * @see NoInitialTransitionProcessor
 * @see NoInitialTransitionQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class NoInitialTransitionMatcher extends BaseMatcher<NoInitialTransitionMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NoInitialTransitionMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    NoInitialTransitionMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new NoInitialTransitionMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SRC = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(NoInitialTransitionMatcher.class);
  
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
  public NoInitialTransitionMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public NoInitialTransitionMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @return matches represented as a NoInitialTransitionMatch object.
   * 
   */
  public Collection<NoInitialTransitionMatch> getAllMatches(final Pseudostate pSrc) {
    return rawGetAllMatches(new Object[]{pSrc});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @return a match represented as a NoInitialTransitionMatch object, or null if no match is found.
   * 
   */
  public NoInitialTransitionMatch getOneArbitraryMatch(final Pseudostate pSrc) {
    return rawGetOneArbitraryMatch(new Object[]{pSrc});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Pseudostate pSrc) {
    return rawHasMatch(new Object[]{pSrc});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Pseudostate pSrc) {
    return rawCountMatches(new Object[]{pSrc});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Pseudostate pSrc, final IMatchProcessor<? super NoInitialTransitionMatch> processor) {
    rawForEachMatch(new Object[]{pSrc}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Pseudostate pSrc, final IMatchProcessor<? super NoInitialTransitionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSrc}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public NoInitialTransitionMatch newMatch(final Pseudostate pSrc) {
    return NoInitialTransitionMatch.newMatch(pSrc);
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Pseudostate> rawAccumulateAllValuesOfsrc(final Object[] parameters) {
    Set<Pseudostate> results = new HashSet<Pseudostate>();
    rawAccumulateAllValues(POSITION_SRC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfsrc() {
    return rawAccumulateAllValuesOfsrc(emptyArray());
  }
  
  @Override
  protected NoInitialTransitionMatch tupleToMatch(final Tuple t) {
    try {
    	return NoInitialTransitionMatch.newMatch((org.eclipse.uml2.uml.Pseudostate) t.get(POSITION_SRC));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NoInitialTransitionMatch arrayToMatch(final Object[] match) {
    try {
    	return NoInitialTransitionMatch.newMatch((org.eclipse.uml2.uml.Pseudostate) match[POSITION_SRC]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NoInitialTransitionMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return NoInitialTransitionMatch.newMutableMatch((org.eclipse.uml2.uml.Pseudostate) match[POSITION_SRC]);
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
  public static IQuerySpecification<NoInitialTransitionMatcher> querySpecification() throws IncQueryException {
    return NoInitialTransitionQuerySpecification.instance();
  }
}
