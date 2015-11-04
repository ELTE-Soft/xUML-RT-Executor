package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.InitialPseudostateNotPublicMatch;
import hu.eltesoft.modelexecution.validation.util.InitialPseudostateNotPublicQuerySpecification;
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
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.InitialPseudostateNotPublic pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link InitialPseudostateNotPublicMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * ///////////////////
 * // initial state
 * ///////////////////
 * {@literal @}Violation(message = "Initial pseudostate must be public", mark = { "ps" })
 * pattern InitialPseudostateNotPublic(ps : Pseudostate) {
 * 	Pseudostate.visibility(ps, visibility);
 * 	visibility != VisibilityKind::public;
 * }
 * </pre></code>
 * 
 * @see InitialPseudostateNotPublicMatch
 * @see InitialPseudostateNotPublicProcessor
 * @see InitialPseudostateNotPublicQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class InitialPseudostateNotPublicMatcher extends BaseMatcher<InitialPseudostateNotPublicMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static InitialPseudostateNotPublicMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    InitialPseudostateNotPublicMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new InitialPseudostateNotPublicMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_PS = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(InitialPseudostateNotPublicMatcher.class);
  
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
  public InitialPseudostateNotPublicMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public InitialPseudostateNotPublicMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPs the fixed value of pattern parameter ps, or null if not bound.
   * @return matches represented as a InitialPseudostateNotPublicMatch object.
   * 
   */
  public Collection<InitialPseudostateNotPublicMatch> getAllMatches(final Pseudostate pPs) {
    return rawGetAllMatches(new Object[]{pPs});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPs the fixed value of pattern parameter ps, or null if not bound.
   * @return a match represented as a InitialPseudostateNotPublicMatch object, or null if no match is found.
   * 
   */
  public InitialPseudostateNotPublicMatch getOneArbitraryMatch(final Pseudostate pPs) {
    return rawGetOneArbitraryMatch(new Object[]{pPs});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pPs the fixed value of pattern parameter ps, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Pseudostate pPs) {
    return rawHasMatch(new Object[]{pPs});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPs the fixed value of pattern parameter ps, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Pseudostate pPs) {
    return rawCountMatches(new Object[]{pPs});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pPs the fixed value of pattern parameter ps, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Pseudostate pPs, final IMatchProcessor<? super InitialPseudostateNotPublicMatch> processor) {
    rawForEachMatch(new Object[]{pPs}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPs the fixed value of pattern parameter ps, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Pseudostate pPs, final IMatchProcessor<? super InitialPseudostateNotPublicMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pPs}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPs the fixed value of pattern parameter ps, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public InitialPseudostateNotPublicMatch newMatch(final Pseudostate pPs) {
    return InitialPseudostateNotPublicMatch.newMatch(pPs);
  }
  
  /**
   * Retrieve the set of values that occur in matches for ps.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Pseudostate> rawAccumulateAllValuesOfps(final Object[] parameters) {
    Set<Pseudostate> results = new HashSet<Pseudostate>();
    rawAccumulateAllValues(POSITION_PS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ps.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfps() {
    return rawAccumulateAllValuesOfps(emptyArray());
  }
  
  @Override
  protected InitialPseudostateNotPublicMatch tupleToMatch(final Tuple t) {
    try {
    	return InitialPseudostateNotPublicMatch.newMatch((org.eclipse.uml2.uml.Pseudostate) t.get(POSITION_PS));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected InitialPseudostateNotPublicMatch arrayToMatch(final Object[] match) {
    try {
    	return InitialPseudostateNotPublicMatch.newMatch((org.eclipse.uml2.uml.Pseudostate) match[POSITION_PS]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected InitialPseudostateNotPublicMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return InitialPseudostateNotPublicMatch.newMutableMatch((org.eclipse.uml2.uml.Pseudostate) match[POSITION_PS]);
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
  public static IQuerySpecification<InitialPseudostateNotPublicMatcher> querySpecification() throws IncQueryException {
    return InitialPseudostateNotPublicQuerySpecification.instance();
  }
}
