package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.MultiReturnsMatch;
import hu.eltesoft.modelexecution.validation.util.MultiReturnsQuerySpecification;
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
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Parameter;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.MultiReturns pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MultiReturnsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "{bf} can have at most one return parameter", mark = { "pm1", "pm2" })
 * pattern MultiReturns(bf : BehavioralFeature, pm1 : Parameter, pm2 : Parameter) {
 * 	BehavioralFeature.ownedParameter(bf, pm1);
 * 	BehavioralFeature.ownedParameter(bf, pm2);
 * 	Parameter.direction(pm1, ::^return);
 * 	Parameter.direction(pm2, ::^return);
 * 	pm1 != pm2;
 * }
 * </pre></code>
 * 
 * @see MultiReturnsMatch
 * @see MultiReturnsProcessor
 * @see MultiReturnsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MultiReturnsMatcher extends BaseMatcher<MultiReturnsMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MultiReturnsMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    MultiReturnsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new MultiReturnsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_BF = 0;
  
  private final static int POSITION_PM1 = 1;
  
  private final static int POSITION_PM2 = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(MultiReturnsMatcher.class);
  
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
  public MultiReturnsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public MultiReturnsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBf the fixed value of pattern parameter bf, or null if not bound.
   * @param pPm1 the fixed value of pattern parameter pm1, or null if not bound.
   * @param pPm2 the fixed value of pattern parameter pm2, or null if not bound.
   * @return matches represented as a MultiReturnsMatch object.
   * 
   */
  public Collection<MultiReturnsMatch> getAllMatches(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2) {
    return rawGetAllMatches(new Object[]{pBf, pPm1, pPm2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBf the fixed value of pattern parameter bf, or null if not bound.
   * @param pPm1 the fixed value of pattern parameter pm1, or null if not bound.
   * @param pPm2 the fixed value of pattern parameter pm2, or null if not bound.
   * @return a match represented as a MultiReturnsMatch object, or null if no match is found.
   * 
   */
  public MultiReturnsMatch getOneArbitraryMatch(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2) {
    return rawGetOneArbitraryMatch(new Object[]{pBf, pPm1, pPm2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBf the fixed value of pattern parameter bf, or null if not bound.
   * @param pPm1 the fixed value of pattern parameter pm1, or null if not bound.
   * @param pPm2 the fixed value of pattern parameter pm2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2) {
    return rawHasMatch(new Object[]{pBf, pPm1, pPm2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBf the fixed value of pattern parameter bf, or null if not bound.
   * @param pPm1 the fixed value of pattern parameter pm1, or null if not bound.
   * @param pPm2 the fixed value of pattern parameter pm2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2) {
    return rawCountMatches(new Object[]{pBf, pPm1, pPm2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBf the fixed value of pattern parameter bf, or null if not bound.
   * @param pPm1 the fixed value of pattern parameter pm1, or null if not bound.
   * @param pPm2 the fixed value of pattern parameter pm2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2, final IMatchProcessor<? super MultiReturnsMatch> processor) {
    rawForEachMatch(new Object[]{pBf, pPm1, pPm2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBf the fixed value of pattern parameter bf, or null if not bound.
   * @param pPm1 the fixed value of pattern parameter pm1, or null if not bound.
   * @param pPm2 the fixed value of pattern parameter pm2, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2, final IMatchProcessor<? super MultiReturnsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBf, pPm1, pPm2}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBf the fixed value of pattern parameter bf, or null if not bound.
   * @param pPm1 the fixed value of pattern parameter pm1, or null if not bound.
   * @param pPm2 the fixed value of pattern parameter pm2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MultiReturnsMatch newMatch(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2) {
    return MultiReturnsMatch.newMatch(pBf, pPm1, pPm2);
  }
  
  /**
   * Retrieve the set of values that occur in matches for bf.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<BehavioralFeature> rawAccumulateAllValuesOfbf(final Object[] parameters) {
    Set<BehavioralFeature> results = new HashSet<BehavioralFeature>();
    rawAccumulateAllValues(POSITION_BF, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for bf.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BehavioralFeature> getAllValuesOfbf() {
    return rawAccumulateAllValuesOfbf(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for bf.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BehavioralFeature> getAllValuesOfbf(final MultiReturnsMatch partialMatch) {
    return rawAccumulateAllValuesOfbf(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for bf.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BehavioralFeature> getAllValuesOfbf(final Parameter pPm1, final Parameter pPm2) {
    return rawAccumulateAllValuesOfbf(new Object[]{
    null, 
    pPm1, 
    pPm2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for pm1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Parameter> rawAccumulateAllValuesOfpm1(final Object[] parameters) {
    Set<Parameter> results = new HashSet<Parameter>();
    rawAccumulateAllValues(POSITION_PM1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for pm1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfpm1() {
    return rawAccumulateAllValuesOfpm1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for pm1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfpm1(final MultiReturnsMatch partialMatch) {
    return rawAccumulateAllValuesOfpm1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for pm1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfpm1(final BehavioralFeature pBf, final Parameter pPm2) {
    return rawAccumulateAllValuesOfpm1(new Object[]{
    pBf, 
    null, 
    pPm2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for pm2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Parameter> rawAccumulateAllValuesOfpm2(final Object[] parameters) {
    Set<Parameter> results = new HashSet<Parameter>();
    rawAccumulateAllValues(POSITION_PM2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for pm2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfpm2() {
    return rawAccumulateAllValuesOfpm2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for pm2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfpm2(final MultiReturnsMatch partialMatch) {
    return rawAccumulateAllValuesOfpm2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for pm2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfpm2(final BehavioralFeature pBf, final Parameter pPm1) {
    return rawAccumulateAllValuesOfpm2(new Object[]{
    pBf, 
    pPm1, 
    null
    });
  }
  
  @Override
  protected MultiReturnsMatch tupleToMatch(final Tuple t) {
    try {
    	return MultiReturnsMatch.newMatch((org.eclipse.uml2.uml.BehavioralFeature) t.get(POSITION_BF), (org.eclipse.uml2.uml.Parameter) t.get(POSITION_PM1), (org.eclipse.uml2.uml.Parameter) t.get(POSITION_PM2));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MultiReturnsMatch arrayToMatch(final Object[] match) {
    try {
    	return MultiReturnsMatch.newMatch((org.eclipse.uml2.uml.BehavioralFeature) match[POSITION_BF], (org.eclipse.uml2.uml.Parameter) match[POSITION_PM1], (org.eclipse.uml2.uml.Parameter) match[POSITION_PM2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MultiReturnsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MultiReturnsMatch.newMutableMatch((org.eclipse.uml2.uml.BehavioralFeature) match[POSITION_BF], (org.eclipse.uml2.uml.Parameter) match[POSITION_PM1], (org.eclipse.uml2.uml.Parameter) match[POSITION_PM2]);
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
  public static IQuerySpecification<MultiReturnsMatcher> querySpecification() throws IncQueryException {
    return MultiReturnsQuerySpecification.instance();
  }
}
