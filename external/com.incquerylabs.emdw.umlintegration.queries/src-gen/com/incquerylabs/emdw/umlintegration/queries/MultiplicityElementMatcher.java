package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.MultiplicityElementMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.MultiplicityElementQuerySpecification;
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
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.multiplicityElement pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MultiplicityElementMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * // MultiplicityElement
 * 
 * pattern multiplicityElement(multiplicityElement: MultiplicityElement, lowerValue: ValueSpecification, upperValue: ValueSpecification) {
 * 	MultiplicityElement.lowerValue(multiplicityElement, lowerValue);
 * 	MultiplicityElement.upperValue(multiplicityElement, upperValue);
 * }
 * </pre></code>
 * 
 * @see MultiplicityElementMatch
 * @see MultiplicityElementProcessor
 * @see MultiplicityElementQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MultiplicityElementMatcher extends BaseMatcher<MultiplicityElementMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MultiplicityElementMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    MultiplicityElementMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new MultiplicityElementMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_MULTIPLICITYELEMENT = 0;
  
  private final static int POSITION_LOWERVALUE = 1;
  
  private final static int POSITION_UPPERVALUE = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(MultiplicityElementMatcher.class);
  
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
  public MultiplicityElementMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public MultiplicityElementMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pMultiplicityElement the fixed value of pattern parameter multiplicityElement, or null if not bound.
   * @param pLowerValue the fixed value of pattern parameter lowerValue, or null if not bound.
   * @param pUpperValue the fixed value of pattern parameter upperValue, or null if not bound.
   * @return matches represented as a MultiplicityElementMatch object.
   * 
   */
  public Collection<MultiplicityElementMatch> getAllMatches(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue) {
    return rawGetAllMatches(new Object[]{pMultiplicityElement, pLowerValue, pUpperValue});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pMultiplicityElement the fixed value of pattern parameter multiplicityElement, or null if not bound.
   * @param pLowerValue the fixed value of pattern parameter lowerValue, or null if not bound.
   * @param pUpperValue the fixed value of pattern parameter upperValue, or null if not bound.
   * @return a match represented as a MultiplicityElementMatch object, or null if no match is found.
   * 
   */
  public MultiplicityElementMatch getOneArbitraryMatch(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue) {
    return rawGetOneArbitraryMatch(new Object[]{pMultiplicityElement, pLowerValue, pUpperValue});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pMultiplicityElement the fixed value of pattern parameter multiplicityElement, or null if not bound.
   * @param pLowerValue the fixed value of pattern parameter lowerValue, or null if not bound.
   * @param pUpperValue the fixed value of pattern parameter upperValue, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue) {
    return rawHasMatch(new Object[]{pMultiplicityElement, pLowerValue, pUpperValue});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pMultiplicityElement the fixed value of pattern parameter multiplicityElement, or null if not bound.
   * @param pLowerValue the fixed value of pattern parameter lowerValue, or null if not bound.
   * @param pUpperValue the fixed value of pattern parameter upperValue, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue) {
    return rawCountMatches(new Object[]{pMultiplicityElement, pLowerValue, pUpperValue});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pMultiplicityElement the fixed value of pattern parameter multiplicityElement, or null if not bound.
   * @param pLowerValue the fixed value of pattern parameter lowerValue, or null if not bound.
   * @param pUpperValue the fixed value of pattern parameter upperValue, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue, final IMatchProcessor<? super MultiplicityElementMatch> processor) {
    rawForEachMatch(new Object[]{pMultiplicityElement, pLowerValue, pUpperValue}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pMultiplicityElement the fixed value of pattern parameter multiplicityElement, or null if not bound.
   * @param pLowerValue the fixed value of pattern parameter lowerValue, or null if not bound.
   * @param pUpperValue the fixed value of pattern parameter upperValue, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue, final IMatchProcessor<? super MultiplicityElementMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pMultiplicityElement, pLowerValue, pUpperValue}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pMultiplicityElement the fixed value of pattern parameter multiplicityElement, or null if not bound.
   * @param pLowerValue the fixed value of pattern parameter lowerValue, or null if not bound.
   * @param pUpperValue the fixed value of pattern parameter upperValue, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MultiplicityElementMatch newMatch(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue) {
    return MultiplicityElementMatch.newMatch(pMultiplicityElement, pLowerValue, pUpperValue);
  }
  
  /**
   * Retrieve the set of values that occur in matches for multiplicityElement.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<MultiplicityElement> rawAccumulateAllValuesOfmultiplicityElement(final Object[] parameters) {
    Set<MultiplicityElement> results = new HashSet<MultiplicityElement>();
    rawAccumulateAllValues(POSITION_MULTIPLICITYELEMENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for multiplicityElement.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<MultiplicityElement> getAllValuesOfmultiplicityElement() {
    return rawAccumulateAllValuesOfmultiplicityElement(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for multiplicityElement.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<MultiplicityElement> getAllValuesOfmultiplicityElement(final MultiplicityElementMatch partialMatch) {
    return rawAccumulateAllValuesOfmultiplicityElement(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for multiplicityElement.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<MultiplicityElement> getAllValuesOfmultiplicityElement(final ValueSpecification pLowerValue, final ValueSpecification pUpperValue) {
    return rawAccumulateAllValuesOfmultiplicityElement(new Object[]{
    null, 
    pLowerValue, 
    pUpperValue
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for lowerValue.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ValueSpecification> rawAccumulateAllValuesOflowerValue(final Object[] parameters) {
    Set<ValueSpecification> results = new HashSet<ValueSpecification>();
    rawAccumulateAllValues(POSITION_LOWERVALUE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for lowerValue.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOflowerValue() {
    return rawAccumulateAllValuesOflowerValue(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for lowerValue.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOflowerValue(final MultiplicityElementMatch partialMatch) {
    return rawAccumulateAllValuesOflowerValue(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for lowerValue.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOflowerValue(final MultiplicityElement pMultiplicityElement, final ValueSpecification pUpperValue) {
    return rawAccumulateAllValuesOflowerValue(new Object[]{
    pMultiplicityElement, 
    null, 
    pUpperValue
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for upperValue.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ValueSpecification> rawAccumulateAllValuesOfupperValue(final Object[] parameters) {
    Set<ValueSpecification> results = new HashSet<ValueSpecification>();
    rawAccumulateAllValues(POSITION_UPPERVALUE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for upperValue.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfupperValue() {
    return rawAccumulateAllValuesOfupperValue(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for upperValue.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfupperValue(final MultiplicityElementMatch partialMatch) {
    return rawAccumulateAllValuesOfupperValue(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for upperValue.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfupperValue(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue) {
    return rawAccumulateAllValuesOfupperValue(new Object[]{
    pMultiplicityElement, 
    pLowerValue, 
    null
    });
  }
  
  @Override
  protected MultiplicityElementMatch tupleToMatch(final Tuple t) {
    try {
    	return MultiplicityElementMatch.newMatch((org.eclipse.uml2.uml.MultiplicityElement) t.get(POSITION_MULTIPLICITYELEMENT), (org.eclipse.uml2.uml.ValueSpecification) t.get(POSITION_LOWERVALUE), (org.eclipse.uml2.uml.ValueSpecification) t.get(POSITION_UPPERVALUE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MultiplicityElementMatch arrayToMatch(final Object[] match) {
    try {
    	return MultiplicityElementMatch.newMatch((org.eclipse.uml2.uml.MultiplicityElement) match[POSITION_MULTIPLICITYELEMENT], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_LOWERVALUE], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_UPPERVALUE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MultiplicityElementMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MultiplicityElementMatch.newMutableMatch((org.eclipse.uml2.uml.MultiplicityElement) match[POSITION_MULTIPLICITYELEMENT], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_LOWERVALUE], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_UPPERVALUE]);
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
  public static IQuerySpecification<MultiplicityElementMatcher> querySpecification() throws IncQueryException {
    return MultiplicityElementQuerySpecification.instance();
  }
}
