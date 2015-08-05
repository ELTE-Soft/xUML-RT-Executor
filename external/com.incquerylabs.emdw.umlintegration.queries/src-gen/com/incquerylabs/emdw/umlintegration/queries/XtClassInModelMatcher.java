package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.XtClassInModelMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.XtClassInModelQuerySpecification;
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
import org.eclipse.uml2.uml.Model;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.xtClassInModel pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link XtClassInModelMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern xtClassInModel(model: Model, umlClass: Class) {
 * 	Model.packagedElement(model, umlClass);
 * 	find xtClass(umlClass);
 * }
 * </pre></code>
 * 
 * @see XtClassInModelMatch
 * @see XtClassInModelProcessor
 * @see XtClassInModelQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class XtClassInModelMatcher extends BaseMatcher<XtClassInModelMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static XtClassInModelMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    XtClassInModelMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new XtClassInModelMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_MODEL = 0;
  
  private final static int POSITION_UMLCLASS = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(XtClassInModelMatcher.class);
  
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
  public XtClassInModelMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public XtClassInModelMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return matches represented as a XtClassInModelMatch object.
   * 
   */
  public Collection<XtClassInModelMatch> getAllMatches(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawGetAllMatches(new Object[]{pModel, pUmlClass});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return a match represented as a XtClassInModelMatch object, or null if no match is found.
   * 
   */
  public XtClassInModelMatch getOneArbitraryMatch(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawGetOneArbitraryMatch(new Object[]{pModel, pUmlClass});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawHasMatch(new Object[]{pModel, pUmlClass});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawCountMatches(new Object[]{pModel, pUmlClass});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass, final IMatchProcessor<? super XtClassInModelMatch> processor) {
    rawForEachMatch(new Object[]{pModel, pUmlClass}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass, final IMatchProcessor<? super XtClassInModelMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pModel, pUmlClass}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public XtClassInModelMatch newMatch(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass) {
    return XtClassInModelMatch.newMatch(pModel, pUmlClass);
  }
  
  /**
   * Retrieve the set of values that occur in matches for model.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Model> rawAccumulateAllValuesOfmodel(final Object[] parameters) {
    Set<Model> results = new HashSet<Model>();
    rawAccumulateAllValues(POSITION_MODEL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for model.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Model> getAllValuesOfmodel() {
    return rawAccumulateAllValuesOfmodel(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for model.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Model> getAllValuesOfmodel(final XtClassInModelMatch partialMatch) {
    return rawAccumulateAllValuesOfmodel(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for model.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Model> getAllValuesOfmodel(final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawAccumulateAllValuesOfmodel(new Object[]{
    null, 
    pUmlClass
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfumlClass(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_UMLCLASS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass() {
    return rawAccumulateAllValuesOfumlClass(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass(final XtClassInModelMatch partialMatch) {
    return rawAccumulateAllValuesOfumlClass(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass(final Model pModel) {
    return rawAccumulateAllValuesOfumlClass(new Object[]{
    pModel, 
    null
    });
  }
  
  @Override
  protected XtClassInModelMatch tupleToMatch(final Tuple t) {
    try {
    	return XtClassInModelMatch.newMatch((org.eclipse.uml2.uml.Model) t.get(POSITION_MODEL), (org.eclipse.uml2.uml.Class) t.get(POSITION_UMLCLASS));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtClassInModelMatch arrayToMatch(final Object[] match) {
    try {
    	return XtClassInModelMatch.newMatch((org.eclipse.uml2.uml.Model) match[POSITION_MODEL], (org.eclipse.uml2.uml.Class) match[POSITION_UMLCLASS]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtClassInModelMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return XtClassInModelMatch.newMutableMatch((org.eclipse.uml2.uml.Model) match[POSITION_MODEL], (org.eclipse.uml2.uml.Class) match[POSITION_UMLCLASS]);
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
  public static IQuerySpecification<XtClassInModelMatcher> querySpecification() throws IncQueryException {
    return XtClassInModelQuerySpecification.instance();
  }
}
