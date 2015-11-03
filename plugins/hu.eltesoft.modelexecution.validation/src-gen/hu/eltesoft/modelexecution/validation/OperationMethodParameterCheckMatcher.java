package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.OperationMethodParameterCheckMatch;
import hu.eltesoft.modelexecution.validation.util.OperationMethodParameterCheckQuerySpecification;
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
import org.eclipse.uml2.uml.Parameter;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.OperationMethodParameterCheck pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link OperationMethodParameterCheckMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Parameter of the method {method} does not conform to its specification in {op}", 
 *   mark = { "methodParam" }, post = "hu.eltesoft.modelexecution.validation.utils.IndexChecked"
 * )
 * pattern OperationMethodParameterCheck(opParam : Parameter, methodParam : Parameter, op : Operation, method : Behavior) {
 * 	find Method(_, op, method);
 * 	Operation.ownedParameter(op, opParam);
 * 	OpaqueBehavior.ownedParameter(method, methodParam);
 * 	neg find ParamsCheck(opParam, methodParam);
 * }
 * </pre></code>
 * 
 * @see OperationMethodParameterCheckMatch
 * @see OperationMethodParameterCheckProcessor
 * @see OperationMethodParameterCheckQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class OperationMethodParameterCheckMatcher extends BaseMatcher<OperationMethodParameterCheckMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static OperationMethodParameterCheckMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    OperationMethodParameterCheckMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new OperationMethodParameterCheckMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_OPPARAM = 0;
  
  private final static int POSITION_METHODPARAM = 1;
  
  private final static int POSITION_OP = 2;
  
  private final static int POSITION_METHOD = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(OperationMethodParameterCheckMatcher.class);
  
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
  public OperationMethodParameterCheckMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public OperationMethodParameterCheckMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOpParam the fixed value of pattern parameter opParam, or null if not bound.
   * @param pMethodParam the fixed value of pattern parameter methodParam, or null if not bound.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @return matches represented as a OperationMethodParameterCheckMatch object.
   * 
   */
  public Collection<OperationMethodParameterCheckMatch> getAllMatches(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod) {
    return rawGetAllMatches(new Object[]{pOpParam, pMethodParam, pOp, pMethod});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOpParam the fixed value of pattern parameter opParam, or null if not bound.
   * @param pMethodParam the fixed value of pattern parameter methodParam, or null if not bound.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @return a match represented as a OperationMethodParameterCheckMatch object, or null if no match is found.
   * 
   */
  public OperationMethodParameterCheckMatch getOneArbitraryMatch(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod) {
    return rawGetOneArbitraryMatch(new Object[]{pOpParam, pMethodParam, pOp, pMethod});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pOpParam the fixed value of pattern parameter opParam, or null if not bound.
   * @param pMethodParam the fixed value of pattern parameter methodParam, or null if not bound.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod) {
    return rawHasMatch(new Object[]{pOpParam, pMethodParam, pOp, pMethod});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOpParam the fixed value of pattern parameter opParam, or null if not bound.
   * @param pMethodParam the fixed value of pattern parameter methodParam, or null if not bound.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod) {
    return rawCountMatches(new Object[]{pOpParam, pMethodParam, pOp, pMethod});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pOpParam the fixed value of pattern parameter opParam, or null if not bound.
   * @param pMethodParam the fixed value of pattern parameter methodParam, or null if not bound.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod, final IMatchProcessor<? super OperationMethodParameterCheckMatch> processor) {
    rawForEachMatch(new Object[]{pOpParam, pMethodParam, pOp, pMethod}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOpParam the fixed value of pattern parameter opParam, or null if not bound.
   * @param pMethodParam the fixed value of pattern parameter methodParam, or null if not bound.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod, final IMatchProcessor<? super OperationMethodParameterCheckMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pOpParam, pMethodParam, pOp, pMethod}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOpParam the fixed value of pattern parameter opParam, or null if not bound.
   * @param pMethodParam the fixed value of pattern parameter methodParam, or null if not bound.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param pMethod the fixed value of pattern parameter method, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public OperationMethodParameterCheckMatch newMatch(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp, final Behavior pMethod) {
    return OperationMethodParameterCheckMatch.newMatch(pOpParam, pMethodParam, pOp, pMethod);
  }
  
  /**
   * Retrieve the set of values that occur in matches for opParam.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Parameter> rawAccumulateAllValuesOfopParam(final Object[] parameters) {
    Set<Parameter> results = new HashSet<Parameter>();
    rawAccumulateAllValues(POSITION_OPPARAM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for opParam.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfopParam() {
    return rawAccumulateAllValuesOfopParam(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for opParam.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfopParam(final OperationMethodParameterCheckMatch partialMatch) {
    return rawAccumulateAllValuesOfopParam(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for opParam.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfopParam(final Parameter pMethodParam, final Operation pOp, final Behavior pMethod) {
    return rawAccumulateAllValuesOfopParam(new Object[]{
    null, 
    pMethodParam, 
    pOp, 
    pMethod
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for methodParam.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Parameter> rawAccumulateAllValuesOfmethodParam(final Object[] parameters) {
    Set<Parameter> results = new HashSet<Parameter>();
    rawAccumulateAllValues(POSITION_METHODPARAM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for methodParam.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfmethodParam() {
    return rawAccumulateAllValuesOfmethodParam(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for methodParam.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfmethodParam(final OperationMethodParameterCheckMatch partialMatch) {
    return rawAccumulateAllValuesOfmethodParam(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for methodParam.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfmethodParam(final Parameter pOpParam, final Operation pOp, final Behavior pMethod) {
    return rawAccumulateAllValuesOfmethodParam(new Object[]{
    pOpParam, 
    null, 
    pOp, 
    pMethod
    });
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
  public Set<Operation> getAllValuesOfop(final OperationMethodParameterCheckMatch partialMatch) {
    return rawAccumulateAllValuesOfop(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for op.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfop(final Parameter pOpParam, final Parameter pMethodParam, final Behavior pMethod) {
    return rawAccumulateAllValuesOfop(new Object[]{
    pOpParam, 
    pMethodParam, 
    null, 
    pMethod
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
  public Set<Behavior> getAllValuesOfmethod(final OperationMethodParameterCheckMatch partialMatch) {
    return rawAccumulateAllValuesOfmethod(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for method.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfmethod(final Parameter pOpParam, final Parameter pMethodParam, final Operation pOp) {
    return rawAccumulateAllValuesOfmethod(new Object[]{
    pOpParam, 
    pMethodParam, 
    pOp, 
    null
    });
  }
  
  @Override
  protected OperationMethodParameterCheckMatch tupleToMatch(final Tuple t) {
    try {
    	return OperationMethodParameterCheckMatch.newMatch((org.eclipse.uml2.uml.Parameter) t.get(POSITION_OPPARAM), (org.eclipse.uml2.uml.Parameter) t.get(POSITION_METHODPARAM), (org.eclipse.uml2.uml.Operation) t.get(POSITION_OP), (org.eclipse.uml2.uml.Behavior) t.get(POSITION_METHOD));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected OperationMethodParameterCheckMatch arrayToMatch(final Object[] match) {
    try {
    	return OperationMethodParameterCheckMatch.newMatch((org.eclipse.uml2.uml.Parameter) match[POSITION_OPPARAM], (org.eclipse.uml2.uml.Parameter) match[POSITION_METHODPARAM], (org.eclipse.uml2.uml.Operation) match[POSITION_OP], (org.eclipse.uml2.uml.Behavior) match[POSITION_METHOD]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected OperationMethodParameterCheckMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return OperationMethodParameterCheckMatch.newMutableMatch((org.eclipse.uml2.uml.Parameter) match[POSITION_OPPARAM], (org.eclipse.uml2.uml.Parameter) match[POSITION_METHODPARAM], (org.eclipse.uml2.uml.Operation) match[POSITION_OP], (org.eclipse.uml2.uml.Behavior) match[POSITION_METHOD]);
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
  public static IQuerySpecification<OperationMethodParameterCheckMatcher> querySpecification() throws IncQueryException {
    return OperationMethodParameterCheckQuerySpecification.instance();
  }
}
