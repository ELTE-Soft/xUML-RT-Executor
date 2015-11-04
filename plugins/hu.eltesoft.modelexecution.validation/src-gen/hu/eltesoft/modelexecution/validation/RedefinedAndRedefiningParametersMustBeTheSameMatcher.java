package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.RedefinedAndRedefiningParametersMustBeTheSameMatch;
import hu.eltesoft.modelexecution.validation.util.RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification;
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
import org.eclipse.uml2.uml.Operation;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.RedefinedAndRedefiningParametersMustBeTheSame pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link RedefinedAndRedefiningParametersMustBeTheSameMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Parameters of the operation must be the same as the redefined operation {redefined}", 
 * 	mark = { "redefiner" }, post = "hu.eltesoft.modelexecution.validation.utils.IndexChecked"
 * )
 * pattern RedefinedAndRedefiningParametersMustBeTheSame(redefined : Operation, redefiner : Operation) {
 * 	Operation.redefinedOperation(redefiner, redefined);
 * 	Operation.ownedParameter(redefined, redefinedParam);
 * 	Operation.ownedParameter(redefiner, redefinerParam);
 * 	neg find ParamsCheck(redefinedParam, redefinerParam);
 * }
 * </pre></code>
 * 
 * @see RedefinedAndRedefiningParametersMustBeTheSameMatch
 * @see RedefinedAndRedefiningParametersMustBeTheSameProcessor
 * @see RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class RedefinedAndRedefiningParametersMustBeTheSameMatcher extends BaseMatcher<RedefinedAndRedefiningParametersMustBeTheSameMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static RedefinedAndRedefiningParametersMustBeTheSameMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    RedefinedAndRedefiningParametersMustBeTheSameMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new RedefinedAndRedefiningParametersMustBeTheSameMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_REDEFINED = 0;
  
  private final static int POSITION_REDEFINER = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(RedefinedAndRedefiningParametersMustBeTheSameMatcher.class);
  
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
  public RedefinedAndRedefiningParametersMustBeTheSameMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public RedefinedAndRedefiningParametersMustBeTheSameMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @return matches represented as a RedefinedAndRedefiningParametersMustBeTheSameMatch object.
   * 
   */
  public Collection<RedefinedAndRedefiningParametersMustBeTheSameMatch> getAllMatches(final Operation pRedefined, final Operation pRedefiner) {
    return rawGetAllMatches(new Object[]{pRedefined, pRedefiner});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @return a match represented as a RedefinedAndRedefiningParametersMustBeTheSameMatch object, or null if no match is found.
   * 
   */
  public RedefinedAndRedefiningParametersMustBeTheSameMatch getOneArbitraryMatch(final Operation pRedefined, final Operation pRedefiner) {
    return rawGetOneArbitraryMatch(new Object[]{pRedefined, pRedefiner});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Operation pRedefined, final Operation pRedefiner) {
    return rawHasMatch(new Object[]{pRedefined, pRedefiner});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Operation pRedefined, final Operation pRedefiner) {
    return rawCountMatches(new Object[]{pRedefined, pRedefiner});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Operation pRedefined, final Operation pRedefiner, final IMatchProcessor<? super RedefinedAndRedefiningParametersMustBeTheSameMatch> processor) {
    rawForEachMatch(new Object[]{pRedefined, pRedefiner}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Operation pRedefined, final Operation pRedefiner, final IMatchProcessor<? super RedefinedAndRedefiningParametersMustBeTheSameMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRedefined, pRedefiner}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public RedefinedAndRedefiningParametersMustBeTheSameMatch newMatch(final Operation pRedefined, final Operation pRedefiner) {
    return RedefinedAndRedefiningParametersMustBeTheSameMatch.newMatch(pRedefined, pRedefiner);
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefined.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Operation> rawAccumulateAllValuesOfredefined(final Object[] parameters) {
    Set<Operation> results = new HashSet<Operation>();
    rawAccumulateAllValues(POSITION_REDEFINED, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefined.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfredefined() {
    return rawAccumulateAllValuesOfredefined(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefined.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfredefined(final RedefinedAndRedefiningParametersMustBeTheSameMatch partialMatch) {
    return rawAccumulateAllValuesOfredefined(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefined.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfredefined(final Operation pRedefiner) {
    return rawAccumulateAllValuesOfredefined(new Object[]{
    null, 
    pRedefiner
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefiner.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Operation> rawAccumulateAllValuesOfredefiner(final Object[] parameters) {
    Set<Operation> results = new HashSet<Operation>();
    rawAccumulateAllValues(POSITION_REDEFINER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefiner.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfredefiner() {
    return rawAccumulateAllValuesOfredefiner(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefiner.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfredefiner(final RedefinedAndRedefiningParametersMustBeTheSameMatch partialMatch) {
    return rawAccumulateAllValuesOfredefiner(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefiner.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfredefiner(final Operation pRedefined) {
    return rawAccumulateAllValuesOfredefiner(new Object[]{
    pRedefined, 
    null
    });
  }
  
  @Override
  protected RedefinedAndRedefiningParametersMustBeTheSameMatch tupleToMatch(final Tuple t) {
    try {
    	return RedefinedAndRedefiningParametersMustBeTheSameMatch.newMatch((org.eclipse.uml2.uml.Operation) t.get(POSITION_REDEFINED), (org.eclipse.uml2.uml.Operation) t.get(POSITION_REDEFINER));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected RedefinedAndRedefiningParametersMustBeTheSameMatch arrayToMatch(final Object[] match) {
    try {
    	return RedefinedAndRedefiningParametersMustBeTheSameMatch.newMatch((org.eclipse.uml2.uml.Operation) match[POSITION_REDEFINED], (org.eclipse.uml2.uml.Operation) match[POSITION_REDEFINER]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected RedefinedAndRedefiningParametersMustBeTheSameMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return RedefinedAndRedefiningParametersMustBeTheSameMatch.newMutableMatch((org.eclipse.uml2.uml.Operation) match[POSITION_REDEFINED], (org.eclipse.uml2.uml.Operation) match[POSITION_REDEFINER]);
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
  public static IQuerySpecification<RedefinedAndRedefiningParametersMustBeTheSameMatcher> querySpecification() throws IncQueryException {
    return RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification.instance();
  }
}
