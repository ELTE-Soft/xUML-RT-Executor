package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterLowerBoundQuerySpecification;
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
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBound pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link OperationParameterLowerBoundMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern OperationParameterLowerBound(cls: Class, operation : Operation, parameter : Parameter, type, lowerBound: ValueSpecification) {
 * 	find OperationParameterType(cls, operation, parameter, type, _, _);
 * 	Parameter.lowerValue(parameter, lowerBound);
 * }
 * </pre></code>
 * 
 * @see OperationParameterLowerBoundMatch
 * @see OperationParameterLowerBoundProcessor
 * @see OperationParameterLowerBoundQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class OperationParameterLowerBoundMatcher extends BaseMatcher<OperationParameterLowerBoundMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<OperationParameterLowerBoundMatcher> querySpecification() throws IncQueryException {
    return OperationParameterLowerBoundQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static OperationParameterLowerBoundMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    OperationParameterLowerBoundMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new OperationParameterLowerBoundMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CLS = 0;
  
  private final static int POSITION_OPERATION = 1;
  
  private final static int POSITION_PARAMETER = 2;
  
  private final static int POSITION_TYPE = 3;
  
  private final static int POSITION_LOWERBOUND = 4;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(OperationParameterLowerBoundMatcher.class);
  
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
  public OperationParameterLowerBoundMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public OperationParameterLowerBoundMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return matches represented as a OperationParameterLowerBoundMatch object.
   * 
   */
  public Collection<OperationParameterLowerBoundMatch> getAllMatches(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType, final ValueSpecification pLowerBound) {
    return rawGetAllMatches(new Object[]{pCls, pOperation, pParameter, pType, pLowerBound});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return a match represented as a OperationParameterLowerBoundMatch object, or null if no match is found.
   * 
   */
  public OperationParameterLowerBoundMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType, final ValueSpecification pLowerBound) {
    return rawGetOneArbitraryMatch(new Object[]{pCls, pOperation, pParameter, pType, pLowerBound});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType, final ValueSpecification pLowerBound) {
    return rawHasMatch(new Object[]{pCls, pOperation, pParameter, pType, pLowerBound});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType, final ValueSpecification pLowerBound) {
    return rawCountMatches(new Object[]{pCls, pOperation, pParameter, pType, pLowerBound});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType, final ValueSpecification pLowerBound, final IMatchProcessor<? super OperationParameterLowerBoundMatch> processor) {
    rawForEachMatch(new Object[]{pCls, pOperation, pParameter, pType, pLowerBound}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType, final ValueSpecification pLowerBound, final IMatchProcessor<? super OperationParameterLowerBoundMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCls, pOperation, pParameter, pType, pLowerBound}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<OperationParameterLowerBoundMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType, final ValueSpecification pLowerBound) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pCls, pOperation, pParameter, pType, pLowerBound});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public OperationParameterLowerBoundMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType, final ValueSpecification pLowerBound) {
    return OperationParameterLowerBoundMatch.newMatch(pCls, pOperation, pParameter, pType, pLowerBound);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfcls(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_CLS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls() {
    return rawAccumulateAllValuesOfcls(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final OperationParameterLowerBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfcls(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final Operation pOperation, final Parameter pParameter, final Type pType, final ValueSpecification pLowerBound) {
    return rawAccumulateAllValuesOfcls(new Object[]{null, pOperation, pParameter, pType, pLowerBound});
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Operation> rawAccumulateAllValuesOfoperation(final Object[] parameters) {
    Set<Operation> results = new HashSet<Operation>();
    rawAccumulateAllValues(POSITION_OPERATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation() {
    return rawAccumulateAllValuesOfoperation(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation(final OperationParameterLowerBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfoperation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation(final org.eclipse.uml2.uml.Class pCls, final Parameter pParameter, final Type pType, final ValueSpecification pLowerBound) {
    return rawAccumulateAllValuesOfoperation(new Object[]{pCls, null, pParameter, pType, pLowerBound});
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Parameter> rawAccumulateAllValuesOfparameter(final Object[] parameters) {
    Set<Parameter> results = new HashSet<Parameter>();
    rawAccumulateAllValues(POSITION_PARAMETER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter() {
    return rawAccumulateAllValuesOfparameter(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter(final OperationParameterLowerBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfparameter(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final ValueSpecification pLowerBound) {
    return rawAccumulateAllValuesOfparameter(new Object[]{pCls, pOperation, null, pType, pLowerBound});
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Type> rawAccumulateAllValuesOftype(final Object[] parameters) {
    Set<Type> results = new HashSet<Type>();
    rawAccumulateAllValues(POSITION_TYPE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype() {
    return rawAccumulateAllValuesOftype(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final OperationParameterLowerBoundMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final ValueSpecification pLowerBound) {
    return rawAccumulateAllValuesOftype(new Object[]{pCls, pOperation, pParameter, null, pLowerBound});
  }
  
  /**
   * Retrieve the set of values that occur in matches for lowerBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ValueSpecification> rawAccumulateAllValuesOflowerBound(final Object[] parameters) {
    Set<ValueSpecification> results = new HashSet<ValueSpecification>();
    rawAccumulateAllValues(POSITION_LOWERBOUND, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for lowerBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOflowerBound() {
    return rawAccumulateAllValuesOflowerBound(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for lowerBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOflowerBound(final OperationParameterLowerBoundMatch partialMatch) {
    return rawAccumulateAllValuesOflowerBound(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for lowerBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOflowerBound(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Parameter pParameter, final Type pType) {
    return rawAccumulateAllValuesOflowerBound(new Object[]{pCls, pOperation, pParameter, pType, null});
  }
  
  @Override
  protected OperationParameterLowerBoundMatch tupleToMatch(final Tuple t) {
    try {
      return OperationParameterLowerBoundMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_CLS), (org.eclipse.uml2.uml.Operation) t.get(POSITION_OPERATION), (org.eclipse.uml2.uml.Parameter) t.get(POSITION_PARAMETER), (org.eclipse.uml2.uml.Type) t.get(POSITION_TYPE), (org.eclipse.uml2.uml.ValueSpecification) t.get(POSITION_LOWERBOUND));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected OperationParameterLowerBoundMatch arrayToMatch(final Object[] match) {
    try {
      return OperationParameterLowerBoundMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLS], (org.eclipse.uml2.uml.Operation) match[POSITION_OPERATION], (org.eclipse.uml2.uml.Parameter) match[POSITION_PARAMETER], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_LOWERBOUND]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected OperationParameterLowerBoundMatch arrayToMatchMutable(final Object[] match) {
    try {
      return OperationParameterLowerBoundMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLS], (org.eclipse.uml2.uml.Operation) match[POSITION_OPERATION], (org.eclipse.uml2.uml.Parameter) match[POSITION_PARAMETER], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_LOWERBOUND]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
