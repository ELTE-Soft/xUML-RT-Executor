package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.XtPackageInModelMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.XtPackageInModelQuerySpecification;
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
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.xtPackageInModel pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link XtPackageInModelMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern xtPackageInModel(model: Model, umlPackage: Package) {
 * 	Model.packagedElement(model, umlPackage);
 * 	find xtPackage(umlPackage);
 * }
 * </pre></code>
 * 
 * @see XtPackageInModelMatch
 * @see XtPackageInModelProcessor
 * @see XtPackageInModelQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class XtPackageInModelMatcher extends BaseMatcher<XtPackageInModelMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static XtPackageInModelMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    XtPackageInModelMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new XtPackageInModelMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_MODEL = 0;
  
  private final static int POSITION_UMLPACKAGE = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(XtPackageInModelMatcher.class);
  
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
  public XtPackageInModelMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public XtPackageInModelMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return matches represented as a XtPackageInModelMatch object.
   * 
   */
  public Collection<XtPackageInModelMatch> getAllMatches(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage) {
    return rawGetAllMatches(new Object[]{pModel, pUmlPackage});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return a match represented as a XtPackageInModelMatch object, or null if no match is found.
   * 
   */
  public XtPackageInModelMatch getOneArbitraryMatch(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage) {
    return rawGetOneArbitraryMatch(new Object[]{pModel, pUmlPackage});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage) {
    return rawHasMatch(new Object[]{pModel, pUmlPackage});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage) {
    return rawCountMatches(new Object[]{pModel, pUmlPackage});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage, final IMatchProcessor<? super XtPackageInModelMatch> processor) {
    rawForEachMatch(new Object[]{pModel, pUmlPackage}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage, final IMatchProcessor<? super XtPackageInModelMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pModel, pUmlPackage}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public XtPackageInModelMatch newMatch(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage) {
    return XtPackageInModelMatch.newMatch(pModel, pUmlPackage);
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
  public Set<Model> getAllValuesOfmodel(final XtPackageInModelMatch partialMatch) {
    return rawAccumulateAllValuesOfmodel(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for model.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Model> getAllValuesOfmodel(final org.eclipse.uml2.uml.Package pUmlPackage) {
    return rawAccumulateAllValuesOfmodel(new Object[]{
    null, 
    pUmlPackage
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlPackage.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Package> rawAccumulateAllValuesOfumlPackage(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Package> results = new HashSet<org.eclipse.uml2.uml.Package>();
    rawAccumulateAllValues(POSITION_UMLPACKAGE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlPackage.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfumlPackage() {
    return rawAccumulateAllValuesOfumlPackage(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlPackage.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfumlPackage(final XtPackageInModelMatch partialMatch) {
    return rawAccumulateAllValuesOfumlPackage(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlPackage.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfumlPackage(final Model pModel) {
    return rawAccumulateAllValuesOfumlPackage(new Object[]{
    pModel, 
    null
    });
  }
  
  @Override
  protected XtPackageInModelMatch tupleToMatch(final Tuple t) {
    try {
    	return XtPackageInModelMatch.newMatch((org.eclipse.uml2.uml.Model) t.get(POSITION_MODEL), (org.eclipse.uml2.uml.Package) t.get(POSITION_UMLPACKAGE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtPackageInModelMatch arrayToMatch(final Object[] match) {
    try {
    	return XtPackageInModelMatch.newMatch((org.eclipse.uml2.uml.Model) match[POSITION_MODEL], (org.eclipse.uml2.uml.Package) match[POSITION_UMLPACKAGE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtPackageInModelMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return XtPackageInModelMatch.newMutableMatch((org.eclipse.uml2.uml.Model) match[POSITION_MODEL], (org.eclipse.uml2.uml.Package) match[POSITION_UMLPACKAGE]);
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
  public static IQuerySpecification<XtPackageInModelMatcher> querySpecification() throws IncQueryException {
    return XtPackageInModelQuerySpecification.instance();
  }
}
