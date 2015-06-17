package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionParameterUpperBoundQuerySpecification;
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
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterUpperBound pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ReceptionParameterUpperBoundMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern ReceptionParameterUpperBound(cls: Class, reception : Reception, parameter : Parameter, type, upperBound: ValueSpecification) {
 * 	find ReceptionParameterType(cls, reception, parameter, type, _, _);
 * 	Parameter.upperValue(parameter, upperBound);
 * }
 * </pre></code>
 * 
 * @see ReceptionParameterUpperBoundMatch
 * @see ReceptionParameterUpperBoundProcessor
 * @see ReceptionParameterUpperBoundQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ReceptionParameterUpperBoundMatcher extends BaseMatcher<ReceptionParameterUpperBoundMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<ReceptionParameterUpperBoundMatcher> querySpecification() throws IncQueryException {
    return ReceptionParameterUpperBoundQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ReceptionParameterUpperBoundMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ReceptionParameterUpperBoundMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ReceptionParameterUpperBoundMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CLS = 0;
  
  private final static int POSITION_RECEPTION = 1;
  
  private final static int POSITION_PARAMETER = 2;
  
  private final static int POSITION_TYPE = 3;
  
  private final static int POSITION_UPPERBOUND = 4;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ReceptionParameterUpperBoundMatcher.class);
  
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
  public ReceptionParameterUpperBoundMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ReceptionParameterUpperBoundMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @return matches represented as a ReceptionParameterUpperBoundMatch object.
   * 
   */
  public Collection<ReceptionParameterUpperBoundMatch> getAllMatches(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final ValueSpecification pUpperBound) {
    return rawGetAllMatches(new Object[]{pCls, pReception, pParameter, pType, pUpperBound});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @return a match represented as a ReceptionParameterUpperBoundMatch object, or null if no match is found.
   * 
   */
  public ReceptionParameterUpperBoundMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final ValueSpecification pUpperBound) {
    return rawGetOneArbitraryMatch(new Object[]{pCls, pReception, pParameter, pType, pUpperBound});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final ValueSpecification pUpperBound) {
    return rawHasMatch(new Object[]{pCls, pReception, pParameter, pType, pUpperBound});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final ValueSpecification pUpperBound) {
    return rawCountMatches(new Object[]{pCls, pReception, pParameter, pType, pUpperBound});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final ValueSpecification pUpperBound, final IMatchProcessor<? super ReceptionParameterUpperBoundMatch> processor) {
    rawForEachMatch(new Object[]{pCls, pReception, pParameter, pType, pUpperBound}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final ValueSpecification pUpperBound, final IMatchProcessor<? super ReceptionParameterUpperBoundMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCls, pReception, pParameter, pType, pUpperBound}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<ReceptionParameterUpperBoundMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final ValueSpecification pUpperBound) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pCls, pReception, pParameter, pType, pUpperBound});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ReceptionParameterUpperBoundMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final ValueSpecification pUpperBound) {
    return ReceptionParameterUpperBoundMatch.newMatch(pCls, pReception, pParameter, pType, pUpperBound);
    
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
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final ReceptionParameterUpperBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfcls(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final Reception pReception, final Parameter pParameter, final Type pType, final ValueSpecification pUpperBound) {
    return rawAccumulateAllValuesOfcls(new Object[]{null, pReception, pParameter, pType, pUpperBound});
  }
  
  /**
   * Retrieve the set of values that occur in matches for reception.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Reception> rawAccumulateAllValuesOfreception(final Object[] parameters) {
    Set<Reception> results = new HashSet<Reception>();
    rawAccumulateAllValues(POSITION_RECEPTION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for reception.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reception> getAllValuesOfreception() {
    return rawAccumulateAllValuesOfreception(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for reception.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reception> getAllValuesOfreception(final ReceptionParameterUpperBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfreception(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for reception.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reception> getAllValuesOfreception(final org.eclipse.uml2.uml.Class pCls, final Parameter pParameter, final Type pType, final ValueSpecification pUpperBound) {
    return rawAccumulateAllValuesOfreception(new Object[]{pCls, null, pParameter, pType, pUpperBound});
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
  public Set<Parameter> getAllValuesOfparameter(final ReceptionParameterUpperBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfparameter(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Type pType, final ValueSpecification pUpperBound) {
    return rawAccumulateAllValuesOfparameter(new Object[]{pCls, pReception, null, pType, pUpperBound});
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
  public Set<Type> getAllValuesOftype(final ReceptionParameterUpperBoundMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final ValueSpecification pUpperBound) {
    return rawAccumulateAllValuesOftype(new Object[]{pCls, pReception, pParameter, null, pUpperBound});
  }
  
  /**
   * Retrieve the set of values that occur in matches for upperBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ValueSpecification> rawAccumulateAllValuesOfupperBound(final Object[] parameters) {
    Set<ValueSpecification> results = new HashSet<ValueSpecification>();
    rawAccumulateAllValues(POSITION_UPPERBOUND, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for upperBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfupperBound() {
    return rawAccumulateAllValuesOfupperBound(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for upperBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfupperBound(final ReceptionParameterUpperBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfupperBound(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for upperBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfupperBound(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType) {
    return rawAccumulateAllValuesOfupperBound(new Object[]{pCls, pReception, pParameter, pType, null});
  }
  
  @Override
  protected ReceptionParameterUpperBoundMatch tupleToMatch(final Tuple t) {
    try {
      return ReceptionParameterUpperBoundMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_CLS), (org.eclipse.uml2.uml.Reception) t.get(POSITION_RECEPTION), (org.eclipse.uml2.uml.Parameter) t.get(POSITION_PARAMETER), (org.eclipse.uml2.uml.Type) t.get(POSITION_TYPE), (org.eclipse.uml2.uml.ValueSpecification) t.get(POSITION_UPPERBOUND));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected ReceptionParameterUpperBoundMatch arrayToMatch(final Object[] match) {
    try {
      return ReceptionParameterUpperBoundMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLS], (org.eclipse.uml2.uml.Reception) match[POSITION_RECEPTION], (org.eclipse.uml2.uml.Parameter) match[POSITION_PARAMETER], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_UPPERBOUND]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected ReceptionParameterUpperBoundMatch arrayToMatchMutable(final Object[] match) {
    try {
      return ReceptionParameterUpperBoundMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLS], (org.eclipse.uml2.uml.Reception) match[POSITION_RECEPTION], (org.eclipse.uml2.uml.Parameter) match[POSITION_PARAMETER], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_UPPERBOUND]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
