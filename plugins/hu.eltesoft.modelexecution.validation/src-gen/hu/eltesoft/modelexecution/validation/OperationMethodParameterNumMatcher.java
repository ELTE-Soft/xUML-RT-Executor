package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.OperationMethodParameterNumMatch;
import hu.eltesoft.modelexecution.validation.util.OperationMethodParameterNumQuerySpecification;
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
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.OperationMethodParameterNum pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link OperationMethodParameterNumMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Number of parameters ({methodParams}) does not the same as specification {op} ({opParams})", mark = { "method" })
 * pattern OperationMethodParameterNum(op : Operation, method : Behavior, opParams, methodParams) {
 * 	find Method(_, op, method);
 * 	opParams == count find ParameterOfOperation(op, _);
 * 	methodParams == count find ParameterOfBehavior(method, _);
 * 	opParams != methodParams;
 * }
 * </pre></code>
 * 
 * @see OperationMethodParameterNumMatch
 * @see OperationMethodParameterNumProcessor
 * @see OperationMethodParameterNumQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class OperationMethodParameterNumMatcher extends BaseMatcher<OperationMethodParameterNumMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static OperationMethodParameterNumMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    OperationMethodParameterNumMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new OperationMethodParameterNumMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_OP = 0;
  
  private final static int POSITION_METHOD = 1;
  
  private final static int POSITION_OPPARAMS = 2;
  
  private final static int POSITION_METHODPARAMS = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(OperationMethodParameterNumMatcher.class);
  
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
  public OperationMethodParameterNumMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public OperationMethodParameterNumMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @param pOpParams the fixed value of pattern parameter opParams, or null if not bound.
   * @param pMethodParams the fixed value of pattern parameter methodParams, or null if not bound.
   * @return matches represented as a OperationMethodParameterNumMatch object.
   * 
   */
  public Collection<OperationMethodParameterNumMatch> getAllMatches(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams) {
    return rawGetAllMatches(new Object[]{pOp, pMethod, pOpParams, pMethodParams});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @param pOpParams the fixed value of pattern parameter opParams, or null if not bound.
   * @param pMethodParams the fixed value of pattern parameter methodParams, or null if not bound.
   * @return a match represented as a OperationMethodParameterNumMatch object, or null if no match is found.
   * 
   */
  public OperationMethodParameterNumMatch getOneArbitraryMatch(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams) {
    return rawGetOneArbitraryMatch(new Object[]{pOp, pMethod, pOpParams, pMethodParams});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @param pOpParams the fixed value of pattern parameter opParams, or null if not bound.
   * @param pMethodParams the fixed value of pattern parameter methodParams, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams) {
    return rawHasMatch(new Object[]{pOp, pMethod, pOpParams, pMethodParams});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @param pOpParams the fixed value of pattern parameter opParams, or null if not bound.
   * @param pMethodParams the fixed value of pattern parameter methodParams, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams) {
    return rawCountMatches(new Object[]{pOp, pMethod, pOpParams, pMethodParams});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @param pOpParams the fixed value of pattern parameter opParams, or null if not bound.
   * @param pMethodParams the fixed value of pattern parameter methodParams, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams, final IMatchProcessor<? super OperationMethodParameterNumMatch> processor) {
    rawForEachMatch(new Object[]{pOp, pMethod, pOpParams, pMethodParams}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @param pOpParams the fixed value of pattern parameter opParams, or null if not bound.
   * @param pMethodParams the fixed value of pattern parameter methodParams, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams, final IMatchProcessor<? super OperationMethodParameterNumMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pOp, pMethod, pOpParams, pMethodParams}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @param pOpParams the fixed value of pattern parameter opParams, or null if not bound.
   * @param pMethodParams the fixed value of pattern parameter methodParams, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public OperationMethodParameterNumMatch newMatch(final Operation pOp, final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams) {
    return OperationMethodParameterNumMatch.newMatch(pOp, pMethod, pOpParams, pMethodParams);
  }
  
  /**
   * Retrieve the set of values that occur in matches for op.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Operation> rawAccumulateAllValuesOfop(final Object[] parameters) {
    Set<Operation> results = new HashSet<Operation>();
    rawAccumulateAllValues(POSITION_OP, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for op.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfop() {
    return rawAccumulateAllValuesOfop(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for op.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfop(final OperationMethodParameterNumMatch partialMatch) {
    return rawAccumulateAllValuesOfop(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for op.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfop(final Behavior pMethod, final Integer pOpParams, final Integer pMethodParams) {
    return rawAccumulateAllValuesOfop(new Object[]{
    null, 
    pMethod, 
    pOpParams, 
    pMethodParams
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for method.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Behavior> rawAccumulateAllValuesOfmethod(final Object[] parameters) {
    Set<Behavior> results = new HashSet<Behavior>();
    rawAccumulateAllValues(POSITION_METHOD, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for method.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfmethod() {
    return rawAccumulateAllValuesOfmethod(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for method.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfmethod(final OperationMethodParameterNumMatch partialMatch) {
    return rawAccumulateAllValuesOfmethod(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for method.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfmethod(final Operation pOp, final Integer pOpParams, final Integer pMethodParams) {
    return rawAccumulateAllValuesOfmethod(new Object[]{
    pOp, 
    null, 
    pOpParams, 
    pMethodParams
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for opParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Integer> rawAccumulateAllValuesOfopParams(final Object[] parameters) {
    Set<Integer> results = new HashSet<Integer>();
    rawAccumulateAllValues(POSITION_OPPARAMS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for opParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfopParams() {
    return rawAccumulateAllValuesOfopParams(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for opParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfopParams(final OperationMethodParameterNumMatch partialMatch) {
    return rawAccumulateAllValuesOfopParams(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for opParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfopParams(final Operation pOp, final Behavior pMethod, final Integer pMethodParams) {
    return rawAccumulateAllValuesOfopParams(new Object[]{
    pOp, 
    pMethod, 
    null, 
    pMethodParams
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for methodParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Integer> rawAccumulateAllValuesOfmethodParams(final Object[] parameters) {
    Set<Integer> results = new HashSet<Integer>();
    rawAccumulateAllValues(POSITION_METHODPARAMS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for methodParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfmethodParams() {
    return rawAccumulateAllValuesOfmethodParams(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for methodParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfmethodParams(final OperationMethodParameterNumMatch partialMatch) {
    return rawAccumulateAllValuesOfmethodParams(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for methodParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfmethodParams(final Operation pOp, final Behavior pMethod, final Integer pOpParams) {
    return rawAccumulateAllValuesOfmethodParams(new Object[]{
    pOp, 
    pMethod, 
    pOpParams, 
    null
    });
  }
  
  @Override
  protected OperationMethodParameterNumMatch tupleToMatch(final Tuple t) {
    try {
    	return OperationMethodParameterNumMatch.newMatch((org.eclipse.uml2.uml.Operation) t.get(POSITION_OP), (org.eclipse.uml2.uml.Behavior) t.get(POSITION_METHOD), (java.lang.Integer) t.get(POSITION_OPPARAMS), (java.lang.Integer) t.get(POSITION_METHODPARAMS));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected OperationMethodParameterNumMatch arrayToMatch(final Object[] match) {
    try {
    	return OperationMethodParameterNumMatch.newMatch((org.eclipse.uml2.uml.Operation) match[POSITION_OP], (org.eclipse.uml2.uml.Behavior) match[POSITION_METHOD], (java.lang.Integer) match[POSITION_OPPARAMS], (java.lang.Integer) match[POSITION_METHODPARAMS]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected OperationMethodParameterNumMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return OperationMethodParameterNumMatch.newMutableMatch((org.eclipse.uml2.uml.Operation) match[POSITION_OP], (org.eclipse.uml2.uml.Behavior) match[POSITION_METHOD], (java.lang.Integer) match[POSITION_OPPARAMS], (java.lang.Integer) match[POSITION_METHODPARAMS]);
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
  public static IQuerySpecification<OperationMethodParameterNumMatcher> querySpecification() throws IncQueryException {
    return OperationMethodParameterNumQuerySpecification.instance();
  }
}
