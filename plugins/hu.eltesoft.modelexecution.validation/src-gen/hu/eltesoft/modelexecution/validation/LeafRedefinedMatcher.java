package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.LeafRedefinedMatch;
import hu.eltesoft.modelexecution.validation.util.LeafRedefinedQuerySpecification;
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
import org.eclipse.uml2.uml.RedefinableElement;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.LeafRedefined pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link LeafRedefinedMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Redefinition of leaf element is not allowed", mark = { "redefining" })
 * pattern LeafRedefined(elem : RedefinableElement, redefining : RedefinableElement) {
 * 	RedefinableElement.redefinedElement(redefining, elem);
 * 	RedefinableElement.isLeaf(elem, true);
 * }
 * </pre></code>
 * 
 * @see LeafRedefinedMatch
 * @see LeafRedefinedProcessor
 * @see LeafRedefinedQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class LeafRedefinedMatcher extends BaseMatcher<LeafRedefinedMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static LeafRedefinedMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    LeafRedefinedMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new LeafRedefinedMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ELEM = 0;
  
  private final static int POSITION_REDEFINING = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(LeafRedefinedMatcher.class);
  
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
  public LeafRedefinedMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public LeafRedefinedMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pRedefining the fixed value of pattern parameter redefining, or null if not bound.
   * @return matches represented as a LeafRedefinedMatch object.
   * 
   */
  public Collection<LeafRedefinedMatch> getAllMatches(final RedefinableElement pElem, final RedefinableElement pRedefining) {
    return rawGetAllMatches(new Object[]{pElem, pRedefining});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pRedefining the fixed value of pattern parameter redefining, or null if not bound.
   * @return a match represented as a LeafRedefinedMatch object, or null if no match is found.
   * 
   */
  public LeafRedefinedMatch getOneArbitraryMatch(final RedefinableElement pElem, final RedefinableElement pRedefining) {
    return rawGetOneArbitraryMatch(new Object[]{pElem, pRedefining});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pRedefining the fixed value of pattern parameter redefining, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final RedefinableElement pElem, final RedefinableElement pRedefining) {
    return rawHasMatch(new Object[]{pElem, pRedefining});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pRedefining the fixed value of pattern parameter redefining, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final RedefinableElement pElem, final RedefinableElement pRedefining) {
    return rawCountMatches(new Object[]{pElem, pRedefining});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pRedefining the fixed value of pattern parameter redefining, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final RedefinableElement pElem, final RedefinableElement pRedefining, final IMatchProcessor<? super LeafRedefinedMatch> processor) {
    rawForEachMatch(new Object[]{pElem, pRedefining}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pRedefining the fixed value of pattern parameter redefining, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final RedefinableElement pElem, final RedefinableElement pRedefining, final IMatchProcessor<? super LeafRedefinedMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pElem, pRedefining}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pRedefining the fixed value of pattern parameter redefining, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public LeafRedefinedMatch newMatch(final RedefinableElement pElem, final RedefinableElement pRedefining) {
    return LeafRedefinedMatch.newMatch(pElem, pRedefining);
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RedefinableElement> rawAccumulateAllValuesOfelem(final Object[] parameters) {
    Set<RedefinableElement> results = new HashSet<RedefinableElement>();
    rawAccumulateAllValues(POSITION_ELEM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RedefinableElement> getAllValuesOfelem() {
    return rawAccumulateAllValuesOfelem(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RedefinableElement> getAllValuesOfelem(final LeafRedefinedMatch partialMatch) {
    return rawAccumulateAllValuesOfelem(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RedefinableElement> getAllValuesOfelem(final RedefinableElement pRedefining) {
    return rawAccumulateAllValuesOfelem(new Object[]{
    null, 
    pRedefining
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefining.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RedefinableElement> rawAccumulateAllValuesOfredefining(final Object[] parameters) {
    Set<RedefinableElement> results = new HashSet<RedefinableElement>();
    rawAccumulateAllValues(POSITION_REDEFINING, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefining.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RedefinableElement> getAllValuesOfredefining() {
    return rawAccumulateAllValuesOfredefining(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefining.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RedefinableElement> getAllValuesOfredefining(final LeafRedefinedMatch partialMatch) {
    return rawAccumulateAllValuesOfredefining(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefining.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RedefinableElement> getAllValuesOfredefining(final RedefinableElement pElem) {
    return rawAccumulateAllValuesOfredefining(new Object[]{
    pElem, 
    null
    });
  }
  
  @Override
  protected LeafRedefinedMatch tupleToMatch(final Tuple t) {
    try {
    	return LeafRedefinedMatch.newMatch((org.eclipse.uml2.uml.RedefinableElement) t.get(POSITION_ELEM), (org.eclipse.uml2.uml.RedefinableElement) t.get(POSITION_REDEFINING));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LeafRedefinedMatch arrayToMatch(final Object[] match) {
    try {
    	return LeafRedefinedMatch.newMatch((org.eclipse.uml2.uml.RedefinableElement) match[POSITION_ELEM], (org.eclipse.uml2.uml.RedefinableElement) match[POSITION_REDEFINING]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LeafRedefinedMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return LeafRedefinedMatch.newMutableMatch((org.eclipse.uml2.uml.RedefinableElement) match[POSITION_ELEM], (org.eclipse.uml2.uml.RedefinableElement) match[POSITION_REDEFINING]);
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
  public static IQuerySpecification<LeafRedefinedMatcher> querySpecification() throws IncQueryException {
    return LeafRedefinedQuerySpecification.instance();
  }
}
