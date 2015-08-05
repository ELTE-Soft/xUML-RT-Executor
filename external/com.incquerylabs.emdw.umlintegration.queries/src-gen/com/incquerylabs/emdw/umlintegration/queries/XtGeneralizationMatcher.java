package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.XtGeneralizationMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.XtGeneralizationQuerySpecification;
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
import org.eclipse.uml2.uml.Generalization;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.xtGeneralization pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link XtGeneralizationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern xtGeneralization(subClass: Class, generalization: Generalization) {
 * 	find xtClass(subClass);
 * 	Class.generalization(subClass, generalization);
 * }
 * </pre></code>
 * 
 * @see XtGeneralizationMatch
 * @see XtGeneralizationProcessor
 * @see XtGeneralizationQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class XtGeneralizationMatcher extends BaseMatcher<XtGeneralizationMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static XtGeneralizationMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    XtGeneralizationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new XtGeneralizationMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SUBCLASS = 0;
  
  private final static int POSITION_GENERALIZATION = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(XtGeneralizationMatcher.class);
  
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
  public XtGeneralizationMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public XtGeneralizationMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSubClass the fixed value of pattern parameter subClass, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return matches represented as a XtGeneralizationMatch object.
   * 
   */
  public Collection<XtGeneralizationMatch> getAllMatches(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization) {
    return rawGetAllMatches(new Object[]{pSubClass, pGeneralization});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSubClass the fixed value of pattern parameter subClass, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return a match represented as a XtGeneralizationMatch object, or null if no match is found.
   * 
   */
  public XtGeneralizationMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization) {
    return rawGetOneArbitraryMatch(new Object[]{pSubClass, pGeneralization});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSubClass the fixed value of pattern parameter subClass, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization) {
    return rawHasMatch(new Object[]{pSubClass, pGeneralization});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSubClass the fixed value of pattern parameter subClass, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization) {
    return rawCountMatches(new Object[]{pSubClass, pGeneralization});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSubClass the fixed value of pattern parameter subClass, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization, final IMatchProcessor<? super XtGeneralizationMatch> processor) {
    rawForEachMatch(new Object[]{pSubClass, pGeneralization}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSubClass the fixed value of pattern parameter subClass, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization, final IMatchProcessor<? super XtGeneralizationMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSubClass, pGeneralization}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSubClass the fixed value of pattern parameter subClass, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public XtGeneralizationMatch newMatch(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization) {
    return XtGeneralizationMatch.newMatch(pSubClass, pGeneralization);
  }
  
  /**
   * Retrieve the set of values that occur in matches for subClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfsubClass(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_SUBCLASS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for subClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfsubClass() {
    return rawAccumulateAllValuesOfsubClass(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for subClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfsubClass(final XtGeneralizationMatch partialMatch) {
    return rawAccumulateAllValuesOfsubClass(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for subClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfsubClass(final Generalization pGeneralization) {
    return rawAccumulateAllValuesOfsubClass(new Object[]{
    null, 
    pGeneralization
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for generalization.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Generalization> rawAccumulateAllValuesOfgeneralization(final Object[] parameters) {
    Set<Generalization> results = new HashSet<Generalization>();
    rawAccumulateAllValues(POSITION_GENERALIZATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for generalization.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Generalization> getAllValuesOfgeneralization() {
    return rawAccumulateAllValuesOfgeneralization(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for generalization.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Generalization> getAllValuesOfgeneralization(final XtGeneralizationMatch partialMatch) {
    return rawAccumulateAllValuesOfgeneralization(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for generalization.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Generalization> getAllValuesOfgeneralization(final org.eclipse.uml2.uml.Class pSubClass) {
    return rawAccumulateAllValuesOfgeneralization(new Object[]{
    pSubClass, 
    null
    });
  }
  
  @Override
  protected XtGeneralizationMatch tupleToMatch(final Tuple t) {
    try {
    	return XtGeneralizationMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_SUBCLASS), (org.eclipse.uml2.uml.Generalization) t.get(POSITION_GENERALIZATION));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtGeneralizationMatch arrayToMatch(final Object[] match) {
    try {
    	return XtGeneralizationMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_SUBCLASS], (org.eclipse.uml2.uml.Generalization) match[POSITION_GENERALIZATION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtGeneralizationMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return XtGeneralizationMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_SUBCLASS], (org.eclipse.uml2.uml.Generalization) match[POSITION_GENERALIZATION]);
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
  public static IQuerySpecification<XtGeneralizationMatcher> querySpecification() throws IncQueryException {
    return XtGeneralizationQuerySpecification.instance();
  }
}
