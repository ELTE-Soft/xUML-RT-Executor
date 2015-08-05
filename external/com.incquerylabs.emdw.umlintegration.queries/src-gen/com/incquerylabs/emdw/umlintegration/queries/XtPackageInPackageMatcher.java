package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.XtPackageInPackageMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.XtPackageInPackageQuerySpecification;
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
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.xtPackageInPackage pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link XtPackageInPackageMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern xtPackageInPackage(parent: Package, child: Package) {
 * 	Package.packagedElement(parent, child);
 * 	find xtPackage(parent);
 * 	find xtPackage(child);
 * }
 * </pre></code>
 * 
 * @see XtPackageInPackageMatch
 * @see XtPackageInPackageProcessor
 * @see XtPackageInPackageQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class XtPackageInPackageMatcher extends BaseMatcher<XtPackageInPackageMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static XtPackageInPackageMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    XtPackageInPackageMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new XtPackageInPackageMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_PARENT = 0;
  
  private final static int POSITION_CHILD = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(XtPackageInPackageMatcher.class);
  
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
  public XtPackageInPackageMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public XtPackageInPackageMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return matches represented as a XtPackageInPackageMatch object.
   * 
   */
  public Collection<XtPackageInPackageMatch> getAllMatches(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild) {
    return rawGetAllMatches(new Object[]{pParent, pChild});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return a match represented as a XtPackageInPackageMatch object, or null if no match is found.
   * 
   */
  public XtPackageInPackageMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild) {
    return rawGetOneArbitraryMatch(new Object[]{pParent, pChild});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild) {
    return rawHasMatch(new Object[]{pParent, pChild});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild) {
    return rawCountMatches(new Object[]{pParent, pChild});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild, final IMatchProcessor<? super XtPackageInPackageMatch> processor) {
    rawForEachMatch(new Object[]{pParent, pChild}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild, final IMatchProcessor<? super XtPackageInPackageMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pParent, pChild}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public XtPackageInPackageMatch newMatch(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild) {
    return XtPackageInPackageMatch.newMatch(pParent, pChild);
  }
  
  /**
   * Retrieve the set of values that occur in matches for parent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Package> rawAccumulateAllValuesOfparent(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Package> results = new HashSet<org.eclipse.uml2.uml.Package>();
    rawAccumulateAllValues(POSITION_PARENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for parent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfparent() {
    return rawAccumulateAllValuesOfparent(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfparent(final XtPackageInPackageMatch partialMatch) {
    return rawAccumulateAllValuesOfparent(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfparent(final org.eclipse.uml2.uml.Package pChild) {
    return rawAccumulateAllValuesOfparent(new Object[]{
    null, 
    pChild
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Package> rawAccumulateAllValuesOfchild(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Package> results = new HashSet<org.eclipse.uml2.uml.Package>();
    rawAccumulateAllValues(POSITION_CHILD, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfchild() {
    return rawAccumulateAllValuesOfchild(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfchild(final XtPackageInPackageMatch partialMatch) {
    return rawAccumulateAllValuesOfchild(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for child.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfchild(final org.eclipse.uml2.uml.Package pParent) {
    return rawAccumulateAllValuesOfchild(new Object[]{
    pParent, 
    null
    });
  }
  
  @Override
  protected XtPackageInPackageMatch tupleToMatch(final Tuple t) {
    try {
    	return XtPackageInPackageMatch.newMatch((org.eclipse.uml2.uml.Package) t.get(POSITION_PARENT), (org.eclipse.uml2.uml.Package) t.get(POSITION_CHILD));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtPackageInPackageMatch arrayToMatch(final Object[] match) {
    try {
    	return XtPackageInPackageMatch.newMatch((org.eclipse.uml2.uml.Package) match[POSITION_PARENT], (org.eclipse.uml2.uml.Package) match[POSITION_CHILD]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtPackageInPackageMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return XtPackageInPackageMatch.newMutableMatch((org.eclipse.uml2.uml.Package) match[POSITION_PARENT], (org.eclipse.uml2.uml.Package) match[POSITION_CHILD]);
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
  public static IQuerySpecification<XtPackageInPackageMatcher> querySpecification() throws IncQueryException {
    return XtPackageInPackageQuerySpecification.instance();
  }
}
