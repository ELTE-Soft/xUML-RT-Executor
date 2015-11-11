package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ReceptionSignalChecksMatch;
import hu.eltesoft.modelexecution.validation.util.ReceptionSignalChecksQuerySpecification;
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
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.ReceptionSignalChecks pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ReceptionSignalChecksMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Reception parameter must conform to the property {property} of signal {sg}",
 * 	mark = { "param" }, post = "hu.eltesoft.modelexecution.validation.utils.IndexChecked"
 * )
 * pattern ReceptionSignalChecks(param : Parameter, property : Property, rc : Reception, sg : Signal) {
 * 	Reception.signal(rc, sg);
 * 	Reception.ownedParameter(rc, param);
 * 	Signal.ownedAttribute(sg, property);
 * 	neg find ParamPropCheck(param, property);
 * }
 * </pre></code>
 * 
 * @see ReceptionSignalChecksMatch
 * @see ReceptionSignalChecksProcessor
 * @see ReceptionSignalChecksQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ReceptionSignalChecksMatcher extends BaseMatcher<ReceptionSignalChecksMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ReceptionSignalChecksMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ReceptionSignalChecksMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ReceptionSignalChecksMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_PARAM = 0;
  
  private final static int POSITION_PROPERTY = 1;
  
  private final static int POSITION_RC = 2;
  
  private final static int POSITION_SG = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ReceptionSignalChecksMatcher.class);
  
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
  public ReceptionSignalChecksMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ReceptionSignalChecksMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @return matches represented as a ReceptionSignalChecksMatch object.
   * 
   */
  public Collection<ReceptionSignalChecksMatch> getAllMatches(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg) {
    return rawGetAllMatches(new Object[]{pParam, pProperty, pRc, pSg});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @return a match represented as a ReceptionSignalChecksMatch object, or null if no match is found.
   * 
   */
  public ReceptionSignalChecksMatch getOneArbitraryMatch(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg) {
    return rawGetOneArbitraryMatch(new Object[]{pParam, pProperty, pRc, pSg});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg) {
    return rawHasMatch(new Object[]{pParam, pProperty, pRc, pSg});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg) {
    return rawCountMatches(new Object[]{pParam, pProperty, pRc, pSg});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg, final IMatchProcessor<? super ReceptionSignalChecksMatch> processor) {
    rawForEachMatch(new Object[]{pParam, pProperty, pRc, pSg}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg, final IMatchProcessor<? super ReceptionSignalChecksMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pParam, pProperty, pRc, pSg}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ReceptionSignalChecksMatch newMatch(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg) {
    return ReceptionSignalChecksMatch.newMatch(pParam, pProperty, pRc, pSg);
  }
  
  /**
   * Retrieve the set of values that occur in matches for param.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Parameter> rawAccumulateAllValuesOfparam(final Object[] parameters) {
    Set<Parameter> results = new HashSet<Parameter>();
    rawAccumulateAllValues(POSITION_PARAM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for param.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparam() {
    return rawAccumulateAllValuesOfparam(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for param.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparam(final ReceptionSignalChecksMatch partialMatch) {
    return rawAccumulateAllValuesOfparam(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for param.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparam(final Property pProperty, final Reception pRc, final Signal pSg) {
    return rawAccumulateAllValuesOfparam(new Object[]{
    null, 
    pProperty, 
    pRc, 
    pSg
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfproperty(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_PROPERTY, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfproperty() {
    return rawAccumulateAllValuesOfproperty(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfproperty(final ReceptionSignalChecksMatch partialMatch) {
    return rawAccumulateAllValuesOfproperty(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfproperty(final Parameter pParam, final Reception pRc, final Signal pSg) {
    return rawAccumulateAllValuesOfproperty(new Object[]{
    pParam, 
    null, 
    pRc, 
    pSg
    });
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
  public Set<Reception> getAllValuesOfrc(final ReceptionSignalChecksMatch partialMatch) {
    return rawAccumulateAllValuesOfrc(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for rc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reception> getAllValuesOfrc(final Parameter pParam, final Property pProperty, final Signal pSg) {
    return rawAccumulateAllValuesOfrc(new Object[]{
    pParam, 
    pProperty, 
    null, 
    pSg
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
  public Set<Signal> getAllValuesOfsg(final ReceptionSignalChecksMatch partialMatch) {
    return rawAccumulateAllValuesOfsg(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsg(final Parameter pParam, final Property pProperty, final Reception pRc) {
    return rawAccumulateAllValuesOfsg(new Object[]{
    pParam, 
    pProperty, 
    pRc, 
    null
    });
  }
  
  @Override
  protected ReceptionSignalChecksMatch tupleToMatch(final Tuple t) {
    try {
    	return ReceptionSignalChecksMatch.newMatch((org.eclipse.uml2.uml.Parameter) t.get(POSITION_PARAM), (org.eclipse.uml2.uml.Property) t.get(POSITION_PROPERTY), (org.eclipse.uml2.uml.Reception) t.get(POSITION_RC), (org.eclipse.uml2.uml.Signal) t.get(POSITION_SG));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ReceptionSignalChecksMatch arrayToMatch(final Object[] match) {
    try {
    	return ReceptionSignalChecksMatch.newMatch((org.eclipse.uml2.uml.Parameter) match[POSITION_PARAM], (org.eclipse.uml2.uml.Property) match[POSITION_PROPERTY], (org.eclipse.uml2.uml.Reception) match[POSITION_RC], (org.eclipse.uml2.uml.Signal) match[POSITION_SG]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ReceptionSignalChecksMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ReceptionSignalChecksMatch.newMutableMatch((org.eclipse.uml2.uml.Parameter) match[POSITION_PARAM], (org.eclipse.uml2.uml.Property) match[POSITION_PROPERTY], (org.eclipse.uml2.uml.Reception) match[POSITION_RC], (org.eclipse.uml2.uml.Signal) match[POSITION_SG]);
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
  public static IQuerySpecification<ReceptionSignalChecksMatcher> querySpecification() throws IncQueryException {
    return ReceptionSignalChecksQuerySpecification.instance();
  }
}
