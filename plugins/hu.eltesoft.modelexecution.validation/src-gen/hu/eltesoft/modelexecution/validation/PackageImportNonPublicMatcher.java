package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.PackageImportNonPublicMatch;
import hu.eltesoft.modelexecution.validation.util.PackageImportNonPublicQuerySpecification;
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
import org.eclipse.uml2.uml.PackageImport;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.PackageImportNonPublic pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link PackageImportNonPublicMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Package imports must be public", mark = { "pi" })
 * pattern PackageImportNonPublic(pi : PackageImport) {
 * 	PackageImport.visibility(pi, visibility);
 * 	visibility != VisibilityKind::public;
 * }
 * </pre></code>
 * 
 * @see PackageImportNonPublicMatch
 * @see PackageImportNonPublicProcessor
 * @see PackageImportNonPublicQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class PackageImportNonPublicMatcher extends BaseMatcher<PackageImportNonPublicMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static PackageImportNonPublicMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    PackageImportNonPublicMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new PackageImportNonPublicMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_PI = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(PackageImportNonPublicMatcher.class);
  
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
  public PackageImportNonPublicMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public PackageImportNonPublicMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPi the fixed value of pattern parameter pi, or null if not bound.
   * @return matches represented as a PackageImportNonPublicMatch object.
   * 
   */
  public Collection<PackageImportNonPublicMatch> getAllMatches(final PackageImport pPi) {
    return rawGetAllMatches(new Object[]{pPi});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPi the fixed value of pattern parameter pi, or null if not bound.
   * @return a match represented as a PackageImportNonPublicMatch object, or null if no match is found.
   * 
   */
  public PackageImportNonPublicMatch getOneArbitraryMatch(final PackageImport pPi) {
    return rawGetOneArbitraryMatch(new Object[]{pPi});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pPi the fixed value of pattern parameter pi, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final PackageImport pPi) {
    return rawHasMatch(new Object[]{pPi});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPi the fixed value of pattern parameter pi, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final PackageImport pPi) {
    return rawCountMatches(new Object[]{pPi});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pPi the fixed value of pattern parameter pi, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final PackageImport pPi, final IMatchProcessor<? super PackageImportNonPublicMatch> processor) {
    rawForEachMatch(new Object[]{pPi}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPi the fixed value of pattern parameter pi, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final PackageImport pPi, final IMatchProcessor<? super PackageImportNonPublicMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pPi}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPi the fixed value of pattern parameter pi, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public PackageImportNonPublicMatch newMatch(final PackageImport pPi) {
    return PackageImportNonPublicMatch.newMatch(pPi);
  }
  
  /**
   * Retrieve the set of values that occur in matches for pi.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<PackageImport> rawAccumulateAllValuesOfpi(final Object[] parameters) {
    Set<PackageImport> results = new HashSet<PackageImport>();
    rawAccumulateAllValues(POSITION_PI, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for pi.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<PackageImport> getAllValuesOfpi() {
    return rawAccumulateAllValuesOfpi(emptyArray());
  }
  
  @Override
  protected PackageImportNonPublicMatch tupleToMatch(final Tuple t) {
    try {
    	return PackageImportNonPublicMatch.newMatch((org.eclipse.uml2.uml.PackageImport) t.get(POSITION_PI));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected PackageImportNonPublicMatch arrayToMatch(final Object[] match) {
    try {
    	return PackageImportNonPublicMatch.newMatch((org.eclipse.uml2.uml.PackageImport) match[POSITION_PI]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected PackageImportNonPublicMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return PackageImportNonPublicMatch.newMutableMatch((org.eclipse.uml2.uml.PackageImport) match[POSITION_PI]);
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
  public static IQuerySpecification<PackageImportNonPublicMatcher> querySpecification() throws IncQueryException {
    return PackageImportNonPublicQuerySpecification.instance();
  }
}
