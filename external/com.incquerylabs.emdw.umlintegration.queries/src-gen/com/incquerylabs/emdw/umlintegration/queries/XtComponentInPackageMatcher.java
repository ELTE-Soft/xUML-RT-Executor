package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.XtComponentInPackageMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.XtComponentInPackageQuerySpecification;
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

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.xtComponentInPackage pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link XtComponentInPackageMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern xtComponentInPackage(umlPackage: Package, component: Component) {
 * 	Package.packagedElement(umlPackage, component);
 * 	find xtComponent(component);
 * 	find xtPackage(umlPackage);
 * }
 * </pre></code>
 * 
 * @see XtComponentInPackageMatch
 * @see XtComponentInPackageProcessor
 * @see XtComponentInPackageQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class XtComponentInPackageMatcher extends BaseMatcher<XtComponentInPackageMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static XtComponentInPackageMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    XtComponentInPackageMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new XtComponentInPackageMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_UMLPACKAGE = 0;
  
  private final static int POSITION_COMPONENT = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(XtComponentInPackageMatcher.class);
  
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
  public XtComponentInPackageMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public XtComponentInPackageMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return matches represented as a XtComponentInPackageMatch object.
   * 
   */
  public Collection<XtComponentInPackageMatch> getAllMatches(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent) {
    return rawGetAllMatches(new Object[]{pUmlPackage, pComponent});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return a match represented as a XtComponentInPackageMatch object, or null if no match is found.
   * 
   */
  public XtComponentInPackageMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent) {
    return rawGetOneArbitraryMatch(new Object[]{pUmlPackage, pComponent});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent) {
    return rawHasMatch(new Object[]{pUmlPackage, pComponent});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent) {
    return rawCountMatches(new Object[]{pUmlPackage, pComponent});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent, final IMatchProcessor<? super XtComponentInPackageMatch> processor) {
    rawForEachMatch(new Object[]{pUmlPackage, pComponent}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent, final IMatchProcessor<? super XtComponentInPackageMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pUmlPackage, pComponent}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param pComponent the fixed value of pattern parameter component, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public XtComponentInPackageMatch newMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent) {
    return XtComponentInPackageMatch.newMatch(pUmlPackage, pComponent);
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
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfumlPackage(final XtComponentInPackageMatch partialMatch) {
    return rawAccumulateAllValuesOfumlPackage(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlPackage.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfumlPackage(final Component pComponent) {
    return rawAccumulateAllValuesOfumlPackage(new Object[]{
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
  public Set<Component> getAllValuesOfcomponent(final XtComponentInPackageMatch partialMatch) {
    return rawAccumulateAllValuesOfcomponent(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for component.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfcomponent(final org.eclipse.uml2.uml.Package pUmlPackage) {
    return rawAccumulateAllValuesOfcomponent(new Object[]{
    pUmlPackage, 
    null
    });
  }
  
  @Override
  protected XtComponentInPackageMatch tupleToMatch(final Tuple t) {
    try {
    	return XtComponentInPackageMatch.newMatch((org.eclipse.uml2.uml.Package) t.get(POSITION_UMLPACKAGE), (org.eclipse.uml2.uml.Component) t.get(POSITION_COMPONENT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtComponentInPackageMatch arrayToMatch(final Object[] match) {
    try {
    	return XtComponentInPackageMatch.newMatch((org.eclipse.uml2.uml.Package) match[POSITION_UMLPACKAGE], (org.eclipse.uml2.uml.Component) match[POSITION_COMPONENT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtComponentInPackageMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return XtComponentInPackageMatch.newMutableMatch((org.eclipse.uml2.uml.Package) match[POSITION_UMLPACKAGE], (org.eclipse.uml2.uml.Component) match[POSITION_COMPONENT]);
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
  public static IQuerySpecification<XtComponentInPackageMatcher> querySpecification() throws IncQueryException {
    return XtComponentInPackageQuerySpecification.instance();
  }
}
