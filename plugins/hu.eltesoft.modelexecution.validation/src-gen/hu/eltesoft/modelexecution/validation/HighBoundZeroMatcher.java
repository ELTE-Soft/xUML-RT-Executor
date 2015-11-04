package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.HighBoundZeroMatch;
import hu.eltesoft.modelexecution.validation.util.HighBoundZeroQuerySpecification;
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
import org.eclipse.uml2.uml.MultiplicityElement;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.HighBoundZero pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link HighBoundZeroMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * // multiplicity violations
 * 
 * {@literal @}Violation(message = "High bound cannot be lower than one", mark = { "me" })
 * pattern HighBoundZero(me : MultiplicityElement) {
 * 	MultiplicityElement.upperValue(me, high);
 * 	find NumericValue(high, hv);
 * 	check (1 {@literal >} hv as Integer && hv != (-1));
 * }
 * </pre></code>
 * 
 * @see HighBoundZeroMatch
 * @see HighBoundZeroProcessor
 * @see HighBoundZeroQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class HighBoundZeroMatcher extends BaseMatcher<HighBoundZeroMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static HighBoundZeroMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    HighBoundZeroMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new HighBoundZeroMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ME = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(HighBoundZeroMatcher.class);
  
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
  public HighBoundZeroMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public HighBoundZeroMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @return matches represented as a HighBoundZeroMatch object.
   * 
   */
  public Collection<HighBoundZeroMatch> getAllMatches(final MultiplicityElement pMe) {
    return rawGetAllMatches(new Object[]{pMe});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @return a match represented as a HighBoundZeroMatch object, or null if no match is found.
   * 
   */
  public HighBoundZeroMatch getOneArbitraryMatch(final MultiplicityElement pMe) {
    return rawGetOneArbitraryMatch(new Object[]{pMe});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final MultiplicityElement pMe) {
    return rawHasMatch(new Object[]{pMe});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final MultiplicityElement pMe) {
    return rawCountMatches(new Object[]{pMe});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final MultiplicityElement pMe, final IMatchProcessor<? super HighBoundZeroMatch> processor) {
    rawForEachMatch(new Object[]{pMe}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final MultiplicityElement pMe, final IMatchProcessor<? super HighBoundZeroMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pMe}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public HighBoundZeroMatch newMatch(final MultiplicityElement pMe) {
    return HighBoundZeroMatch.newMatch(pMe);
  }
  
  /**
   * Retrieve the set of values that occur in matches for me.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<MultiplicityElement> rawAccumulateAllValuesOfme(final Object[] parameters) {
    Set<MultiplicityElement> results = new HashSet<MultiplicityElement>();
    rawAccumulateAllValues(POSITION_ME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for me.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<MultiplicityElement> getAllValuesOfme() {
    return rawAccumulateAllValuesOfme(emptyArray());
  }
  
  @Override
  protected HighBoundZeroMatch tupleToMatch(final Tuple t) {
    try {
    	return HighBoundZeroMatch.newMatch((org.eclipse.uml2.uml.MultiplicityElement) t.get(POSITION_ME));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected HighBoundZeroMatch arrayToMatch(final Object[] match) {
    try {
    	return HighBoundZeroMatch.newMatch((org.eclipse.uml2.uml.MultiplicityElement) match[POSITION_ME]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected HighBoundZeroMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return HighBoundZeroMatch.newMutableMatch((org.eclipse.uml2.uml.MultiplicityElement) match[POSITION_ME]);
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
  public static IQuerySpecification<HighBoundZeroMatcher> querySpecification() throws IncQueryException {
    return HighBoundZeroQuerySpecification.instance();
  }
}
