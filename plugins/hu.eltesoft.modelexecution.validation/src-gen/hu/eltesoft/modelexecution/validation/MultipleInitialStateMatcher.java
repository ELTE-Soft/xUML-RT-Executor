package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.MultipleInitialStateMatch;
import hu.eltesoft.modelexecution.validation.util.MultipleInitialStateQuerySpecification;
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
import org.eclipse.uml2.uml.Region;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.MultipleInitialState pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MultipleInitialStateMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "State machine regions cannot have multiple initial pseudostate", mark = { "init1", "init2" })
 * pattern MultipleInitialState(rg : Region, init1 : Pseudostate, init2 : Pseudostate) {
 * 	find InitialState(rg, init1);
 * 	find InitialState(rg, init2);
 * 	init1 != init2;
 * }
 * </pre></code>
 * 
 * @see MultipleInitialStateMatch
 * @see MultipleInitialStateProcessor
 * @see MultipleInitialStateQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MultipleInitialStateMatcher extends BaseMatcher<MultipleInitialStateMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MultipleInitialStateMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    MultipleInitialStateMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new MultipleInitialStateMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_RG = 0;
  
  private final static int POSITION_INIT1 = 1;
  
  private final static int POSITION_INIT2 = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(MultipleInitialStateMatcher.class);
  
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
  public MultipleInitialStateMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public MultipleInitialStateMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pInit1 the fixed value of pattern parameter init1, or null if not bound.
   * @param pInit2 the fixed value of pattern parameter init2, or null if not bound.
   * @return matches represented as a MultipleInitialStateMatch object.
   * 
   */
  public Collection<MultipleInitialStateMatch> getAllMatches(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2) {
    return rawGetAllMatches(new Object[]{pRg, pInit1, pInit2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pInit1 the fixed value of pattern parameter init1, or null if not bound.
   * @param pInit2 the fixed value of pattern parameter init2, or null if not bound.
   * @return a match represented as a MultipleInitialStateMatch object, or null if no match is found.
   * 
   */
  public MultipleInitialStateMatch getOneArbitraryMatch(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2) {
    return rawGetOneArbitraryMatch(new Object[]{pRg, pInit1, pInit2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pInit1 the fixed value of pattern parameter init1, or null if not bound.
   * @param pInit2 the fixed value of pattern parameter init2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2) {
    return rawHasMatch(new Object[]{pRg, pInit1, pInit2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pInit1 the fixed value of pattern parameter init1, or null if not bound.
   * @param pInit2 the fixed value of pattern parameter init2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2) {
    return rawCountMatches(new Object[]{pRg, pInit1, pInit2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pInit1 the fixed value of pattern parameter init1, or null if not bound.
   * @param pInit2 the fixed value of pattern parameter init2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2, final IMatchProcessor<? super MultipleInitialStateMatch> processor) {
    rawForEachMatch(new Object[]{pRg, pInit1, pInit2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pInit1 the fixed value of pattern parameter init1, or null if not bound.
   * @param pInit2 the fixed value of pattern parameter init2, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2, final IMatchProcessor<? super MultipleInitialStateMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRg, pInit1, pInit2}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRg the fixed value of pattern parameter rg, or null if not bound.
   * @param pInit1 the fixed value of pattern parameter init1, or null if not bound.
   * @param pInit2 the fixed value of pattern parameter init2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MultipleInitialStateMatch newMatch(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2) {
    return MultipleInitialStateMatch.newMatch(pRg, pInit1, pInit2);
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
  public Set<Region> getAllValuesOfrg(final MultipleInitialStateMatch partialMatch) {
    return rawAccumulateAllValuesOfrg(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfrg(final Pseudostate pInit1, final Pseudostate pInit2) {
    return rawAccumulateAllValuesOfrg(new Object[]{
    null, 
    pInit1, 
    pInit2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for init1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Pseudostate> rawAccumulateAllValuesOfinit1(final Object[] parameters) {
    Set<Pseudostate> results = new HashSet<Pseudostate>();
    rawAccumulateAllValues(POSITION_INIT1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for init1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfinit1() {
    return rawAccumulateAllValuesOfinit1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for init1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfinit1(final MultipleInitialStateMatch partialMatch) {
    return rawAccumulateAllValuesOfinit1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for init1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfinit1(final Region pRg, final Pseudostate pInit2) {
    return rawAccumulateAllValuesOfinit1(new Object[]{
    pRg, 
    null, 
    pInit2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for init2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Pseudostate> rawAccumulateAllValuesOfinit2(final Object[] parameters) {
    Set<Pseudostate> results = new HashSet<Pseudostate>();
    rawAccumulateAllValues(POSITION_INIT2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for init2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfinit2() {
    return rawAccumulateAllValuesOfinit2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for init2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfinit2(final MultipleInitialStateMatch partialMatch) {
    return rawAccumulateAllValuesOfinit2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for init2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfinit2(final Region pRg, final Pseudostate pInit1) {
    return rawAccumulateAllValuesOfinit2(new Object[]{
    pRg, 
    pInit1, 
    null
    });
  }
  
  @Override
  protected MultipleInitialStateMatch tupleToMatch(final Tuple t) {
    try {
    	return MultipleInitialStateMatch.newMatch((org.eclipse.uml2.uml.Region) t.get(POSITION_RG), (org.eclipse.uml2.uml.Pseudostate) t.get(POSITION_INIT1), (org.eclipse.uml2.uml.Pseudostate) t.get(POSITION_INIT2));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MultipleInitialStateMatch arrayToMatch(final Object[] match) {
    try {
    	return MultipleInitialStateMatch.newMatch((org.eclipse.uml2.uml.Region) match[POSITION_RG], (org.eclipse.uml2.uml.Pseudostate) match[POSITION_INIT1], (org.eclipse.uml2.uml.Pseudostate) match[POSITION_INIT2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MultipleInitialStateMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MultipleInitialStateMatch.newMutableMatch((org.eclipse.uml2.uml.Region) match[POSITION_RG], (org.eclipse.uml2.uml.Pseudostate) match[POSITION_INIT1], (org.eclipse.uml2.uml.Pseudostate) match[POSITION_INIT2]);
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
  public static IQuerySpecification<MultipleInitialStateMatcher> querySpecification() throws IncQueryException {
    return MultipleInitialStateQuerySpecification.instance();
  }
}
