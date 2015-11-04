package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.AbstractMatch;
import hu.eltesoft.modelexecution.validation.util.AbstractQuerySpecification;
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
import org.eclipse.uml2.uml.Classifier;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.Abstract pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AbstractMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Only classes and operations can be abstract", mark = { "elem" })
 * pattern Abstract(elem : Classifier) {
 * 	Classifier.isAbstract(elem, true);
 * 	neg find ClassOrAssocClass(elem);
 * 	neg find Operation(_, elem, _);
 * }
 * </pre></code>
 * 
 * @see AbstractMatch
 * @see AbstractProcessor
 * @see AbstractQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AbstractMatcher extends BaseMatcher<AbstractMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AbstractMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    AbstractMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new AbstractMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ELEM = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(AbstractMatcher.class);
  
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
  public AbstractMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public AbstractMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return matches represented as a AbstractMatch object.
   * 
   */
  public Collection<AbstractMatch> getAllMatches(final Classifier pElem) {
    return rawGetAllMatches(new Object[]{pElem});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return a match represented as a AbstractMatch object, or null if no match is found.
   * 
   */
  public AbstractMatch getOneArbitraryMatch(final Classifier pElem) {
    return rawGetOneArbitraryMatch(new Object[]{pElem});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Classifier pElem) {
    return rawHasMatch(new Object[]{pElem});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Classifier pElem) {
    return rawCountMatches(new Object[]{pElem});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Classifier pElem, final IMatchProcessor<? super AbstractMatch> processor) {
    rawForEachMatch(new Object[]{pElem}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Classifier pElem, final IMatchProcessor<? super AbstractMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pElem}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public AbstractMatch newMatch(final Classifier pElem) {
    return AbstractMatch.newMatch(pElem);
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Classifier> rawAccumulateAllValuesOfelem(final Object[] parameters) {
    Set<Classifier> results = new HashSet<Classifier>();
    rawAccumulateAllValues(POSITION_ELEM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Classifier> getAllValuesOfelem() {
    return rawAccumulateAllValuesOfelem(emptyArray());
  }
  
  @Override
  protected AbstractMatch tupleToMatch(final Tuple t) {
    try {
    	return AbstractMatch.newMatch((org.eclipse.uml2.uml.Classifier) t.get(POSITION_ELEM));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AbstractMatch arrayToMatch(final Object[] match) {
    try {
    	return AbstractMatch.newMatch((org.eclipse.uml2.uml.Classifier) match[POSITION_ELEM]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AbstractMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return AbstractMatch.newMutableMatch((org.eclipse.uml2.uml.Classifier) match[POSITION_ELEM]);
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
  public static IQuerySpecification<AbstractMatcher> querySpecification() throws IncQueryException {
    return AbstractQuerySpecification.instance();
  }
}
