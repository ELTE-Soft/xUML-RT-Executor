package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ExternalEntityMustBeAbstractMatch;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityMustBeAbstractQuerySpecification;
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

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.ExternalEntityMustBeAbstract pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ExternalEntityMustBeAbstractMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "External entity must be an abstract class", mark = { "cl" })
 * pattern ExternalEntityMustBeAbstract(cl : Class) {
 * 	find ExternalEntity(cl, _);
 * 	Class.isAbstract(cl, false);
 * }
 * </pre></code>
 * 
 * @see ExternalEntityMustBeAbstractMatch
 * @see ExternalEntityMustBeAbstractProcessor
 * @see ExternalEntityMustBeAbstractQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ExternalEntityMustBeAbstractMatcher extends BaseMatcher<ExternalEntityMustBeAbstractMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ExternalEntityMustBeAbstractMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ExternalEntityMustBeAbstractMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ExternalEntityMustBeAbstractMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CL = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ExternalEntityMustBeAbstractMatcher.class);
  
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
  public ExternalEntityMustBeAbstractMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ExternalEntityMustBeAbstractMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @return matches represented as a ExternalEntityMustBeAbstractMatch object.
   * 
   */
  public Collection<ExternalEntityMustBeAbstractMatch> getAllMatches(final org.eclipse.uml2.uml.Class pCl) {
    return rawGetAllMatches(new Object[]{pCl});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @return a match represented as a ExternalEntityMustBeAbstractMatch object, or null if no match is found.
   * 
   */
  public ExternalEntityMustBeAbstractMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCl) {
    return rawGetOneArbitraryMatch(new Object[]{pCl});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pCl) {
    return rawHasMatch(new Object[]{pCl});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pCl) {
    return rawCountMatches(new Object[]{pCl});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pCl, final IMatchProcessor<? super ExternalEntityMustBeAbstractMatch> processor) {
    rawForEachMatch(new Object[]{pCl}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCl, final IMatchProcessor<? super ExternalEntityMustBeAbstractMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCl}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ExternalEntityMustBeAbstractMatch newMatch(final org.eclipse.uml2.uml.Class pCl) {
    return ExternalEntityMustBeAbstractMatch.newMatch(pCl);
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfcl(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_CL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcl() {
    return rawAccumulateAllValuesOfcl(emptyArray());
  }
  
  @Override
  protected ExternalEntityMustBeAbstractMatch tupleToMatch(final Tuple t) {
    try {
    	return ExternalEntityMustBeAbstractMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_CL));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ExternalEntityMustBeAbstractMatch arrayToMatch(final Object[] match) {
    try {
    	return ExternalEntityMustBeAbstractMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_CL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ExternalEntityMustBeAbstractMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ExternalEntityMustBeAbstractMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_CL]);
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
  public static IQuerySpecification<ExternalEntityMustBeAbstractMatcher> querySpecification() throws IncQueryException {
    return ExternalEntityMustBeAbstractQuerySpecification.instance();
  }
}
