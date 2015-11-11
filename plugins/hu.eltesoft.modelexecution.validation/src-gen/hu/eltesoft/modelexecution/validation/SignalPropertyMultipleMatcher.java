package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.SignalPropertyMultipleMatch;
import hu.eltesoft.modelexecution.validation.util.SignalPropertyMultipleQuerySpecification;
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
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.SignalPropertyMultiple pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SignalPropertyMultipleMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Signals properties must be single", mark = { "prop" })
 * pattern SignalPropertyMultiple(sg : Signal, prop : Property) {
 * 	Signal.ownedAttribute(sg, prop);
 * 	Property.upperValue(prop, high);
 * 	find NumericValue(high, hv);
 * 	check (hv as Integer {@literal >} 1);
 * }
 * </pre></code>
 * 
 * @see SignalPropertyMultipleMatch
 * @see SignalPropertyMultipleProcessor
 * @see SignalPropertyMultipleQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SignalPropertyMultipleMatcher extends BaseMatcher<SignalPropertyMultipleMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SignalPropertyMultipleMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SignalPropertyMultipleMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SignalPropertyMultipleMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SG = 0;
  
  private final static int POSITION_PROP = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SignalPropertyMultipleMatcher.class);
  
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
  public SignalPropertyMultipleMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SignalPropertyMultipleMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pProp the fixed value of pattern parameter prop, or null if not bound.
   * @return matches represented as a SignalPropertyMultipleMatch object.
   * 
   */
  public Collection<SignalPropertyMultipleMatch> getAllMatches(final Signal pSg, final Property pProp) {
    return rawGetAllMatches(new Object[]{pSg, pProp});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pProp the fixed value of pattern parameter prop, or null if not bound.
   * @return a match represented as a SignalPropertyMultipleMatch object, or null if no match is found.
   * 
   */
  public SignalPropertyMultipleMatch getOneArbitraryMatch(final Signal pSg, final Property pProp) {
    return rawGetOneArbitraryMatch(new Object[]{pSg, pProp});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pProp the fixed value of pattern parameter prop, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Signal pSg, final Property pProp) {
    return rawHasMatch(new Object[]{pSg, pProp});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pProp the fixed value of pattern parameter prop, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Signal pSg, final Property pProp) {
    return rawCountMatches(new Object[]{pSg, pProp});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pProp the fixed value of pattern parameter prop, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Signal pSg, final Property pProp, final IMatchProcessor<? super SignalPropertyMultipleMatch> processor) {
    rawForEachMatch(new Object[]{pSg, pProp}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pProp the fixed value of pattern parameter prop, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Signal pSg, final Property pProp, final IMatchProcessor<? super SignalPropertyMultipleMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSg, pProp}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pProp the fixed value of pattern parameter prop, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SignalPropertyMultipleMatch newMatch(final Signal pSg, final Property pProp) {
    return SignalPropertyMultipleMatch.newMatch(pSg, pProp);
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
  public Set<Signal> getAllValuesOfsg(final SignalPropertyMultipleMatch partialMatch) {
    return rawAccumulateAllValuesOfsg(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsg(final Property pProp) {
    return rawAccumulateAllValuesOfsg(new Object[]{
    null, 
    pProp
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for prop.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfprop(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_PROP, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for prop.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfprop() {
    return rawAccumulateAllValuesOfprop(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for prop.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfprop(final SignalPropertyMultipleMatch partialMatch) {
    return rawAccumulateAllValuesOfprop(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for prop.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfprop(final Signal pSg) {
    return rawAccumulateAllValuesOfprop(new Object[]{
    pSg, 
    null
    });
  }
  
  @Override
  protected SignalPropertyMultipleMatch tupleToMatch(final Tuple t) {
    try {
    	return SignalPropertyMultipleMatch.newMatch((org.eclipse.uml2.uml.Signal) t.get(POSITION_SG), (org.eclipse.uml2.uml.Property) t.get(POSITION_PROP));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SignalPropertyMultipleMatch arrayToMatch(final Object[] match) {
    try {
    	return SignalPropertyMultipleMatch.newMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SG], (org.eclipse.uml2.uml.Property) match[POSITION_PROP]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SignalPropertyMultipleMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return SignalPropertyMultipleMatch.newMutableMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SG], (org.eclipse.uml2.uml.Property) match[POSITION_PROP]);
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
  public static IQuerySpecification<SignalPropertyMultipleMatcher> querySpecification() throws IncQueryException {
    return SignalPropertyMultipleQuerySpecification.instance();
  }
}
