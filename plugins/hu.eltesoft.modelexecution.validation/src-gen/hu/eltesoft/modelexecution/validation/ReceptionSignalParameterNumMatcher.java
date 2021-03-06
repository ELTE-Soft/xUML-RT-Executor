package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ReceptionSignalParameterNumMatch;
import hu.eltesoft.modelexecution.validation.util.ReceptionSignalParameterNumQuerySpecification;
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
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.ReceptionSignalParameterNum pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ReceptionSignalParameterNumMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Number of parameters ({params}) does not the same as number of properties in signal {sg} ({properties})", mark = { "rc" })
 * pattern ReceptionSignalParameterNum(rc : Reception, sg : Signal, params, properties) {
 * 	Reception.signal(rc, sg);
 * 	params == count find ParameterOfReception(rc, _);
 * 	properties == count find PropertiesOfSignal(sg, _);
 * 	params != properties;
 * }
 * </pre></code>
 * 
 * @see ReceptionSignalParameterNumMatch
 * @see ReceptionSignalParameterNumProcessor
 * @see ReceptionSignalParameterNumQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ReceptionSignalParameterNumMatcher extends BaseMatcher<ReceptionSignalParameterNumMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ReceptionSignalParameterNumMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ReceptionSignalParameterNumMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ReceptionSignalParameterNumMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_RC = 0;
  
  private final static int POSITION_SG = 1;
  
  private final static int POSITION_PARAMS = 2;
  
  private final static int POSITION_PROPERTIES = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ReceptionSignalParameterNumMatcher.class);
  
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
  public ReceptionSignalParameterNumMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ReceptionSignalParameterNumMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pParams the fixed value of pattern parameter params, or null if not bound.
   * @param pProperties the fixed value of pattern parameter properties, or null if not bound.
   * @return matches represented as a ReceptionSignalParameterNumMatch object.
   * 
   */
  public Collection<ReceptionSignalParameterNumMatch> getAllMatches(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties) {
    return rawGetAllMatches(new Object[]{pRc, pSg, pParams, pProperties});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pParams the fixed value of pattern parameter params, or null if not bound.
   * @param pProperties the fixed value of pattern parameter properties, or null if not bound.
   * @return a match represented as a ReceptionSignalParameterNumMatch object, or null if no match is found.
   * 
   */
  public ReceptionSignalParameterNumMatch getOneArbitraryMatch(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties) {
    return rawGetOneArbitraryMatch(new Object[]{pRc, pSg, pParams, pProperties});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pParams the fixed value of pattern parameter params, or null if not bound.
   * @param pProperties the fixed value of pattern parameter properties, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties) {
    return rawHasMatch(new Object[]{pRc, pSg, pParams, pProperties});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pParams the fixed value of pattern parameter params, or null if not bound.
   * @param pProperties the fixed value of pattern parameter properties, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties) {
    return rawCountMatches(new Object[]{pRc, pSg, pParams, pProperties});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pParams the fixed value of pattern parameter params, or null if not bound.
   * @param pProperties the fixed value of pattern parameter properties, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties, final IMatchProcessor<? super ReceptionSignalParameterNumMatch> processor) {
    rawForEachMatch(new Object[]{pRc, pSg, pParams, pProperties}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pParams the fixed value of pattern parameter params, or null if not bound.
   * @param pProperties the fixed value of pattern parameter properties, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties, final IMatchProcessor<? super ReceptionSignalParameterNumMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRc, pSg, pParams, pProperties}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pParams the fixed value of pattern parameter params, or null if not bound.
   * @param pProperties the fixed value of pattern parameter properties, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ReceptionSignalParameterNumMatch newMatch(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties) {
    return ReceptionSignalParameterNumMatch.newMatch(pRc, pSg, pParams, pProperties);
  }
  
  /**
   * Retrieve the set of values that occur in matches for rc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Reception> rawAccumulateAllValuesOfrc(final Object[] parameters) {
    Set<Reception> results = new HashSet<Reception>();
    rawAccumulateAllValues(POSITION_RC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for rc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reception> getAllValuesOfrc() {
    return rawAccumulateAllValuesOfrc(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for rc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reception> getAllValuesOfrc(final ReceptionSignalParameterNumMatch partialMatch) {
    return rawAccumulateAllValuesOfrc(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for rc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reception> getAllValuesOfrc(final Signal pSg, final Integer pParams, final Integer pProperties) {
    return rawAccumulateAllValuesOfrc(new Object[]{
    null, 
    pSg, 
    pParams, 
    pProperties
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for sg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Signal> rawAccumulateAllValuesOfsg(final Object[] parameters) {
    Set<Signal> results = new HashSet<Signal>();
    rawAccumulateAllValues(POSITION_SG, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsg() {
    return rawAccumulateAllValuesOfsg(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsg(final ReceptionSignalParameterNumMatch partialMatch) {
    return rawAccumulateAllValuesOfsg(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsg(final Reception pRc, final Integer pParams, final Integer pProperties) {
    return rawAccumulateAllValuesOfsg(new Object[]{
    pRc, 
    null, 
    pParams, 
    pProperties
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for params.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Integer> rawAccumulateAllValuesOfparams(final Object[] parameters) {
    Set<Integer> results = new HashSet<Integer>();
    rawAccumulateAllValues(POSITION_PARAMS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for params.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfparams() {
    return rawAccumulateAllValuesOfparams(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for params.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfparams(final ReceptionSignalParameterNumMatch partialMatch) {
    return rawAccumulateAllValuesOfparams(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for params.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfparams(final Reception pRc, final Signal pSg, final Integer pProperties) {
    return rawAccumulateAllValuesOfparams(new Object[]{
    pRc, 
    pSg, 
    null, 
    pProperties
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for properties.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Integer> rawAccumulateAllValuesOfproperties(final Object[] parameters) {
    Set<Integer> results = new HashSet<Integer>();
    rawAccumulateAllValues(POSITION_PROPERTIES, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for properties.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfproperties() {
    return rawAccumulateAllValuesOfproperties(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for properties.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfproperties(final ReceptionSignalParameterNumMatch partialMatch) {
    return rawAccumulateAllValuesOfproperties(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for properties.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfproperties(final Reception pRc, final Signal pSg, final Integer pParams) {
    return rawAccumulateAllValuesOfproperties(new Object[]{
    pRc, 
    pSg, 
    pParams, 
    null
    });
  }
  
  @Override
  protected ReceptionSignalParameterNumMatch tupleToMatch(final Tuple t) {
    try {
    	return ReceptionSignalParameterNumMatch.newMatch((org.eclipse.uml2.uml.Reception) t.get(POSITION_RC), (org.eclipse.uml2.uml.Signal) t.get(POSITION_SG), (java.lang.Integer) t.get(POSITION_PARAMS), (java.lang.Integer) t.get(POSITION_PROPERTIES));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ReceptionSignalParameterNumMatch arrayToMatch(final Object[] match) {
    try {
    	return ReceptionSignalParameterNumMatch.newMatch((org.eclipse.uml2.uml.Reception) match[POSITION_RC], (org.eclipse.uml2.uml.Signal) match[POSITION_SG], (java.lang.Integer) match[POSITION_PARAMS], (java.lang.Integer) match[POSITION_PROPERTIES]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ReceptionSignalParameterNumMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ReceptionSignalParameterNumMatch.newMutableMatch((org.eclipse.uml2.uml.Reception) match[POSITION_RC], (org.eclipse.uml2.uml.Signal) match[POSITION_SG], (java.lang.Integer) match[POSITION_PARAMS], (java.lang.Integer) match[POSITION_PROPERTIES]);
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
  public static IQuerySpecification<ReceptionSignalParameterNumMatcher> querySpecification() throws IncQueryException {
    return ReceptionSignalParameterNumQuerySpecification.instance();
  }
}
