package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationReturnTypeQuerySpecification;
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
import org.eclipse.uml2.uml.Type;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.OperationReturnType pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link OperationReturnTypeMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern OperationReturnType(cls : Class, operation : Operation, type, ordered, unique) {
 * 	find OperationReturn(cls, operation, parameter);
 * 	Parameter.type(parameter, type);
 * 	Parameter.isOrdered(parameter, ordered);
 * 	Parameter.isUnique(parameter, unique);
 * }
 * </pre></code>
 * 
 * @see OperationReturnTypeMatch
 * @see OperationReturnTypeProcessor
 * @see OperationReturnTypeQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class OperationReturnTypeMatcher extends BaseMatcher<OperationReturnTypeMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<OperationReturnTypeMatcher> querySpecification() throws IncQueryException {
    return OperationReturnTypeQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static OperationReturnTypeMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    OperationReturnTypeMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new OperationReturnTypeMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CLS = 0;
  
  private final static int POSITION_OPERATION = 1;
  
  private final static int POSITION_TYPE = 2;
  
  private final static int POSITION_ORDERED = 3;
  
  private final static int POSITION_UNIQUE = 4;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(OperationReturnTypeMatcher.class);
  
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
  public OperationReturnTypeMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public OperationReturnTypeMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return matches represented as a OperationReturnTypeMatch object.
   * 
   */
  public Collection<OperationReturnTypeMatch> getAllMatches(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawGetAllMatches(new Object[]{pCls, pOperation, pType, pOrdered, pUnique});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return a match represented as a OperationReturnTypeMatch object, or null if no match is found.
   * 
   */
  public OperationReturnTypeMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawGetOneArbitraryMatch(new Object[]{pCls, pOperation, pType, pOrdered, pUnique});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawHasMatch(new Object[]{pCls, pOperation, pType, pOrdered, pUnique});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawCountMatches(new Object[]{pCls, pOperation, pType, pOrdered, pUnique});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final Boolean pOrdered, final Boolean pUnique, final IMatchProcessor<? super OperationReturnTypeMatch> processor) {
    rawForEachMatch(new Object[]{pCls, pOperation, pType, pOrdered, pUnique}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final Boolean pOrdered, final Boolean pUnique, final IMatchProcessor<? super OperationReturnTypeMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCls, pOperation, pType, pOrdered, pUnique}, processor);
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
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<OperationReturnTypeMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pCls, pOperation, pType, pOrdered, pUnique});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public OperationReturnTypeMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return OperationReturnTypeMatch.newMatch(pCls, pOperation, pType, pOrdered, pUnique);
    
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
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final OperationReturnTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfcls(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final Operation pOperation, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawAccumulateAllValuesOfcls(new Object[]{null, pOperation, pType, pOrdered, pUnique});
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
  public Set<Operation> getAllValuesOfoperation(final OperationReturnTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfoperation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation(final org.eclipse.uml2.uml.Class pCls, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawAccumulateAllValuesOfoperation(new Object[]{pCls, null, pType, pOrdered, pUnique});
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
  public Set<Type> getAllValuesOftype(final OperationReturnTypeMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Boolean pOrdered, final Boolean pUnique) {
    return rawAccumulateAllValuesOftype(new Object[]{pCls, pOperation, null, pOrdered, pUnique});
  }
  
  /**
   * Retrieve the set of values that occur in matches for ordered.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Boolean> rawAccumulateAllValuesOfordered(final Object[] parameters) {
    Set<Boolean> results = new HashSet<Boolean>();
    rawAccumulateAllValues(POSITION_ORDERED, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ordered.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfordered() {
    return rawAccumulateAllValuesOfordered(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ordered.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfordered(final OperationReturnTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfordered(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ordered.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfordered(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final Boolean pUnique) {
    return rawAccumulateAllValuesOfordered(new Object[]{pCls, pOperation, pType, null, pUnique});
  }
  
  /**
   * Retrieve the set of values that occur in matches for unique.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Boolean> rawAccumulateAllValuesOfunique(final Object[] parameters) {
    Set<Boolean> results = new HashSet<Boolean>();
    rawAccumulateAllValues(POSITION_UNIQUE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for unique.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfunique() {
    return rawAccumulateAllValuesOfunique(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for unique.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfunique(final OperationReturnTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfunique(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for unique.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfunique(final org.eclipse.uml2.uml.Class pCls, final Operation pOperation, final Type pType, final Boolean pOrdered) {
    return rawAccumulateAllValuesOfunique(new Object[]{pCls, pOperation, pType, pOrdered, null});
  }
  
  @Override
  protected OperationReturnTypeMatch tupleToMatch(final Tuple t) {
    try {
      return OperationReturnTypeMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_CLS), (org.eclipse.uml2.uml.Operation) t.get(POSITION_OPERATION), (org.eclipse.uml2.uml.Type) t.get(POSITION_TYPE), (java.lang.Boolean) t.get(POSITION_ORDERED), (java.lang.Boolean) t.get(POSITION_UNIQUE));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected OperationReturnTypeMatch arrayToMatch(final Object[] match) {
    try {
      return OperationReturnTypeMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLS], (org.eclipse.uml2.uml.Operation) match[POSITION_OPERATION], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (java.lang.Boolean) match[POSITION_ORDERED], (java.lang.Boolean) match[POSITION_UNIQUE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected OperationReturnTypeMatch arrayToMatchMutable(final Object[] match) {
    try {
      return OperationReturnTypeMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLS], (org.eclipse.uml2.uml.Operation) match[POSITION_OPERATION], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (java.lang.Boolean) match[POSITION_ORDERED], (java.lang.Boolean) match[POSITION_UNIQUE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
