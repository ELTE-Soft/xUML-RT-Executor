package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ExternalEntitiesWithTheSameNameMatch;
import hu.eltesoft.modelexecution.validation.util.ExternalEntitiesWithTheSameNameQuerySpecification;
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
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.ExternalEntitiesWithTheSameName pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ExternalEntitiesWithTheSameNameMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Two external entities cannot have the same name", mark = { "cl1", "cl2" })
 * pattern ExternalEntitiesWithTheSameName(cl1 : Class, cl2 : Class) {
 * 	find ExternalEntity(cl1, _);
 * 	find ExternalEntity(cl2, _);
 * 	Class.name(cl1, name);
 * 	Class.name(cl2, name);
 * 	cl1 != cl2;
 * }
 * </pre></code>
 * 
 * @see ExternalEntitiesWithTheSameNameMatch
 * @see ExternalEntitiesWithTheSameNameProcessor
 * @see ExternalEntitiesWithTheSameNameQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ExternalEntitiesWithTheSameNameMatcher extends BaseMatcher<ExternalEntitiesWithTheSameNameMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ExternalEntitiesWithTheSameNameMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ExternalEntitiesWithTheSameNameMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ExternalEntitiesWithTheSameNameMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CL1 = 0;
  
  private final static int POSITION_CL2 = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ExternalEntitiesWithTheSameNameMatcher.class);
  
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
  public ExternalEntitiesWithTheSameNameMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ExternalEntitiesWithTheSameNameMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCl1 the fixed value of pattern parameter cl1, or null if not bound.
   * @param pCl2 the fixed value of pattern parameter cl2, or null if not bound.
   * @return matches represented as a ExternalEntitiesWithTheSameNameMatch object.
   * 
   */
  public Collection<ExternalEntitiesWithTheSameNameMatch> getAllMatches(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2) {
    return rawGetAllMatches(new Object[]{pCl1, pCl2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCl1 the fixed value of pattern parameter cl1, or null if not bound.
   * @param pCl2 the fixed value of pattern parameter cl2, or null if not bound.
   * @return a match represented as a ExternalEntitiesWithTheSameNameMatch object, or null if no match is found.
   * 
   */
  public ExternalEntitiesWithTheSameNameMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2) {
    return rawGetOneArbitraryMatch(new Object[]{pCl1, pCl2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCl1 the fixed value of pattern parameter cl1, or null if not bound.
   * @param pCl2 the fixed value of pattern parameter cl2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2) {
    return rawHasMatch(new Object[]{pCl1, pCl2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCl1 the fixed value of pattern parameter cl1, or null if not bound.
   * @param pCl2 the fixed value of pattern parameter cl2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2) {
    return rawCountMatches(new Object[]{pCl1, pCl2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCl1 the fixed value of pattern parameter cl1, or null if not bound.
   * @param pCl2 the fixed value of pattern parameter cl2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2, final IMatchProcessor<? super ExternalEntitiesWithTheSameNameMatch> processor) {
    rawForEachMatch(new Object[]{pCl1, pCl2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCl1 the fixed value of pattern parameter cl1, or null if not bound.
   * @param pCl2 the fixed value of pattern parameter cl2, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2, final IMatchProcessor<? super ExternalEntitiesWithTheSameNameMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCl1, pCl2}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCl1 the fixed value of pattern parameter cl1, or null if not bound.
   * @param pCl2 the fixed value of pattern parameter cl2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ExternalEntitiesWithTheSameNameMatch newMatch(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2) {
    return ExternalEntitiesWithTheSameNameMatch.newMatch(pCl1, pCl2);
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfcl1(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_CL1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcl1() {
    return rawAccumulateAllValuesOfcl1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcl1(final ExternalEntitiesWithTheSameNameMatch partialMatch) {
    return rawAccumulateAllValuesOfcl1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcl1(final org.eclipse.uml2.uml.Class pCl2) {
    return rawAccumulateAllValuesOfcl1(new Object[]{
    null, 
    pCl2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfcl2(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_CL2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcl2() {
    return rawAccumulateAllValuesOfcl2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcl2(final ExternalEntitiesWithTheSameNameMatch partialMatch) {
    return rawAccumulateAllValuesOfcl2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcl2(final org.eclipse.uml2.uml.Class pCl1) {
    return rawAccumulateAllValuesOfcl2(new Object[]{
    pCl1, 
    null
    });
  }
  
  @Override
  protected ExternalEntitiesWithTheSameNameMatch tupleToMatch(final Tuple t) {
    try {
    	return ExternalEntitiesWithTheSameNameMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_CL1), (org.eclipse.uml2.uml.Class) t.get(POSITION_CL2));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ExternalEntitiesWithTheSameNameMatch arrayToMatch(final Object[] match) {
    try {
    	return ExternalEntitiesWithTheSameNameMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_CL1], (org.eclipse.uml2.uml.Class) match[POSITION_CL2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ExternalEntitiesWithTheSameNameMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ExternalEntitiesWithTheSameNameMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_CL1], (org.eclipse.uml2.uml.Class) match[POSITION_CL2]);
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
  public static IQuerySpecification<ExternalEntitiesWithTheSameNameMatcher> querySpecification() throws IncQueryException {
    return ExternalEntitiesWithTheSameNameQuerySpecification.instance();
  }
}
