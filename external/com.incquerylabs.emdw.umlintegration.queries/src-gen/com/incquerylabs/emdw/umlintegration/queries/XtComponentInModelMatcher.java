package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.XtComponentInModelMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.XtComponentInModelQuerySpecification;
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
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.xtComponentInModel pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link XtComponentInModelMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern xtComponentInModel(model: Model, component: Component) {
 * 	Model.packagedElement(model, component);
 * 	find xtComponent(component);
 * }
 * </pre></code>
 * 
 * @see XtComponentInModelMatch
 * @see XtComponentInModelProcessor
 * @see XtComponentInModelQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class XtComponentInModelMatcher extends BaseMatcher<XtComponentInModelMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static XtComponentInModelMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    XtComponentInModelMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new XtComponentInModelMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_MODEL = 0;
  
  private final static int POSITION_COMPONENT = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(XtComponentInModelMatcher.class);
  
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
  public XtComponentInModelMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public XtComponentInModelMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return matches represented as a XtComponentInModelMatch object.
   * 
   */
  public Collection<XtComponentInModelMatch> getAllMatches(final Model pModel, final Component pComponent) {
    return rawGetAllMatches(new Object[]{pModel, pComponent});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return a match represented as a XtComponentInModelMatch object, or null if no match is found.
   * 
   */
  public XtComponentInModelMatch getOneArbitraryMatch(final Model pModel, final Component pComponent) {
    return rawGetOneArbitraryMatch(new Object[]{pModel, pComponent});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Model pModel, final Component pComponent) {
    return rawHasMatch(new Object[]{pModel, pComponent});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Model pModel, final Component pComponent) {
    return rawCountMatches(new Object[]{pModel, pComponent});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Model pModel, final Component pComponent, final IMatchProcessor<? super XtComponentInModelMatch> processor) {
    rawForEachMatch(new Object[]{pModel, pComponent}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Model pModel, final Component pComponent, final IMatchProcessor<? super XtComponentInModelMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pModel, pComponent}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public XtComponentInModelMatch newMatch(final Model pModel, final Component pComponent) {
    return XtComponentInModelMatch.newMatch(pModel, pComponent);
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
  public Set<Model> getAllValuesOfmodel(final XtComponentInModelMatch partialMatch) {
    return rawAccumulateAllValuesOfmodel(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for model.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Model> getAllValuesOfmodel(final Component pComponent) {
    return rawAccumulateAllValuesOfmodel(new Object[]{
    null, 
    pComponent
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for component.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Component> rawAccumulateAllValuesOfcomponent(final Object[] parameters) {
    Set<Component> results = new HashSet<Component>();
    rawAccumulateAllValues(POSITION_COMPONENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for component.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfcomponent() {
    return rawAccumulateAllValuesOfcomponent(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for component.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfcomponent(final XtComponentInModelMatch partialMatch) {
    return rawAccumulateAllValuesOfcomponent(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for component.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfcomponent(final Model pModel) {
    return rawAccumulateAllValuesOfcomponent(new Object[]{
    pModel, 
    null
    });
  }
  
  @Override
  protected XtComponentInModelMatch tupleToMatch(final Tuple t) {
    try {
    	return XtComponentInModelMatch.newMatch((org.eclipse.uml2.uml.Model) t.get(POSITION_MODEL), (org.eclipse.uml2.uml.Component) t.get(POSITION_COMPONENT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtComponentInModelMatch arrayToMatch(final Object[] match) {
    try {
    	return XtComponentInModelMatch.newMatch((org.eclipse.uml2.uml.Model) match[POSITION_MODEL], (org.eclipse.uml2.uml.Component) match[POSITION_COMPONENT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtComponentInModelMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return XtComponentInModelMatch.newMutableMatch((org.eclipse.uml2.uml.Model) match[POSITION_MODEL], (org.eclipse.uml2.uml.Component) match[POSITION_COMPONENT]);
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
  public static IQuerySpecification<XtComponentInModelMatcher> querySpecification() throws IncQueryException {
    return XtComponentInModelQuerySpecification.instance();
  }
}
