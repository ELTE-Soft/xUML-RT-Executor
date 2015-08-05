package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.XtPackageMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.XtPackageQuerySpecification;
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

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.xtPackage pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link XtPackageMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * //import "http://Papyrus/xtUMLProfile"
 * //import "http://Papyrus/ExecutableModelingProfile"
 * 
 * // disabled since there are issues with Maven compilation
 * //import "http://www.eclipse.org/uml2/5.0.0/UML/Profile/Standard" as standard
 * 
 * // Package
 * 
 * pattern xtPackage(umlPackage) {
 * 	Package(umlPackage);
 * 	neg find model(umlPackage);
 * 	neg find profile(umlPackage);
 * }
 * </pre></code>
 * 
 * @see XtPackageMatch
 * @see XtPackageProcessor
 * @see XtPackageQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class XtPackageMatcher extends BaseMatcher<XtPackageMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static XtPackageMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    XtPackageMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new XtPackageMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_UMLPACKAGE = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(XtPackageMatcher.class);
  
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
  public XtPackageMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public XtPackageMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return matches represented as a XtPackageMatch object.
   * 
   */
  public Collection<XtPackageMatch> getAllMatches(final org.eclipse.uml2.uml.Package pUmlPackage) {
    return rawGetAllMatches(new Object[]{pUmlPackage});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return a match represented as a XtPackageMatch object, or null if no match is found.
   * 
   */
  public XtPackageMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Package pUmlPackage) {
    return rawGetOneArbitraryMatch(new Object[]{pUmlPackage});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Package pUmlPackage) {
    return rawHasMatch(new Object[]{pUmlPackage});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Package pUmlPackage) {
    return rawCountMatches(new Object[]{pUmlPackage});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final IMatchProcessor<? super XtPackageMatch> processor) {
    rawForEachMatch(new Object[]{pUmlPackage}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Package pUmlPackage, final IMatchProcessor<? super XtPackageMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pUmlPackage}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public XtPackageMatch newMatch(final org.eclipse.uml2.uml.Package pUmlPackage) {
    return XtPackageMatch.newMatch(pUmlPackage);
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
  
  @Override
  protected XtPackageMatch tupleToMatch(final Tuple t) {
    try {
    	return XtPackageMatch.newMatch((org.eclipse.uml2.uml.Package) t.get(POSITION_UMLPACKAGE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtPackageMatch arrayToMatch(final Object[] match) {
    try {
    	return XtPackageMatch.newMatch((org.eclipse.uml2.uml.Package) match[POSITION_UMLPACKAGE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtPackageMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return XtPackageMatch.newMutableMatch((org.eclipse.uml2.uml.Package) match[POSITION_UMLPACKAGE]);
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
  public static IQuerySpecification<XtPackageMatcher> querySpecification() throws IncQueryException {
    return XtPackageQuerySpecification.instance();
  }
}
