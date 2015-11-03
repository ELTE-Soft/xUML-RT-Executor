package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ForbiddenRegionMemberMatch;
import hu.eltesoft.modelexecution.validation.util.ForbiddenRegionMemberQuerySpecification;
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
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Region;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.ForbiddenRegionMember pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ForbiddenRegionMemberMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "State machines regions can only contain transitions and states", mark = { "elem" })
 * pattern ForbiddenRegionMember(rg : Region, elem) {
 * 	Region.ownedElement(rg, elem);
 * 	neg find State(_, elem);
 * 	neg find Transition(elem);
 * 	neg find InitialState(_, elem);
 * }
 * </pre></code>
 * 
 * @see ForbiddenRegionMemberMatch
 * @see ForbiddenRegionMemberProcessor
 * @see ForbiddenRegionMemberQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ForbiddenRegionMemberMatcher extends BaseMatcher<ForbiddenRegionMemberMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ForbiddenRegionMemberMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ForbiddenRegionMemberMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ForbiddenRegionMemberMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_RG = 0;
  
  private final static int POSITION_ELEM = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ForbiddenRegionMemberMatcher.class);
  
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
  public ForbiddenRegionMemberMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ForbiddenRegionMemberMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return matches represented as a ForbiddenRegionMemberMatch object.
   * 
   */
  public Collection<ForbiddenRegionMemberMatch> getAllMatches(final Region pRg, final Element pElem) {
    return rawGetAllMatches(new Object[]{pRg, pElem});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return a match represented as a ForbiddenRegionMemberMatch object, or null if no match is found.
   * 
   */
  public ForbiddenRegionMemberMatch getOneArbitraryMatch(final Region pRg, final Element pElem) {
    return rawGetOneArbitraryMatch(new Object[]{pRg, pElem});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Region pRg, final Element pElem) {
    return rawHasMatch(new Object[]{pRg, pElem});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Region pRg, final Element pElem) {
    return rawCountMatches(new Object[]{pRg, pElem});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Region pRg, final Element pElem, final IMatchProcessor<? super ForbiddenRegionMemberMatch> processor) {
    rawForEachMatch(new Object[]{pRg, pElem}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Region pRg, final Element pElem, final IMatchProcessor<? super ForbiddenRegionMemberMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRg, pElem}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ForbiddenRegionMemberMatch newMatch(final Region pRg, final Element pElem) {
    return ForbiddenRegionMemberMatch.newMatch(pRg, pElem);
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Region> rawAccumulateAllValuesOfrg(final Object[] parameters) {
    Set<Region> results = new HashSet<Region>();
    rawAccumulateAllValues(POSITION_RG, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfrg() {
    return rawAccumulateAllValuesOfrg(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfrg(final ForbiddenRegionMemberMatch partialMatch) {
    return rawAccumulateAllValuesOfrg(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfrg(final Element pElem) {
    return rawAccumulateAllValuesOfrg(new Object[]{
    null, 
    pElem
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Element> rawAccumulateAllValuesOfelem(final Object[] parameters) {
    Set<Element> results = new HashSet<Element>();
    rawAccumulateAllValues(POSITION_ELEM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfelem() {
    return rawAccumulateAllValuesOfelem(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfelem(final ForbiddenRegionMemberMatch partialMatch) {
    return rawAccumulateAllValuesOfelem(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfelem(final Region pRg) {
    return rawAccumulateAllValuesOfelem(new Object[]{
    pRg, 
    null
    });
  }
  
  @Override
  protected ForbiddenRegionMemberMatch tupleToMatch(final Tuple t) {
    try {
    	return ForbiddenRegionMemberMatch.newMatch((org.eclipse.uml2.uml.Region) t.get(POSITION_RG), (org.eclipse.uml2.uml.Element) t.get(POSITION_ELEM));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ForbiddenRegionMemberMatch arrayToMatch(final Object[] match) {
    try {
    	return ForbiddenRegionMemberMatch.newMatch((org.eclipse.uml2.uml.Region) match[POSITION_RG], (org.eclipse.uml2.uml.Element) match[POSITION_ELEM]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ForbiddenRegionMemberMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ForbiddenRegionMemberMatch.newMutableMatch((org.eclipse.uml2.uml.Region) match[POSITION_RG], (org.eclipse.uml2.uml.Element) match[POSITION_ELEM]);
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
  public static IQuerySpecification<ForbiddenRegionMemberMatcher> querySpecification() throws IncQueryException {
    return ForbiddenRegionMemberQuerySpecification.instance();
  }
}
