package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.MethodNotPublicMatch;
import hu.eltesoft.modelexecution.validation.util.MethodNotPublicQuerySpecification;
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
import org.eclipse.uml2.uml.OpaqueBehavior;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.MethodNotPublic pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MethodNotPublicMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Methods must be public", mark = { "me" })
 * pattern MethodNotPublic(me : OpaqueBehavior) {
 * 	OpaqueBehavior.visibility(me, visibility);
 * 	visibility != VisibilityKind::public;
 * }
 * </pre></code>
 * 
 * @see MethodNotPublicMatch
 * @see MethodNotPublicProcessor
 * @see MethodNotPublicQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MethodNotPublicMatcher extends BaseMatcher<MethodNotPublicMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MethodNotPublicMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    MethodNotPublicMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new MethodNotPublicMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ME = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(MethodNotPublicMatcher.class);
  
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
  public MethodNotPublicMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public MethodNotPublicMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @return matches represented as a MethodNotPublicMatch object.
   * 
   */
  public Collection<MethodNotPublicMatch> getAllMatches(final OpaqueBehavior pMe) {
    return rawGetAllMatches(new Object[]{pMe});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @return a match represented as a MethodNotPublicMatch object, or null if no match is found.
   * 
   */
  public MethodNotPublicMatch getOneArbitraryMatch(final OpaqueBehavior pMe) {
    return rawGetOneArbitraryMatch(new Object[]{pMe});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final OpaqueBehavior pMe) {
    return rawHasMatch(new Object[]{pMe});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final OpaqueBehavior pMe) {
    return rawCountMatches(new Object[]{pMe});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final OpaqueBehavior pMe, final IMatchProcessor<? super MethodNotPublicMatch> processor) {
    rawForEachMatch(new Object[]{pMe}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final OpaqueBehavior pMe, final IMatchProcessor<? super MethodNotPublicMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pMe}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MethodNotPublicMatch newMatch(final OpaqueBehavior pMe) {
    return MethodNotPublicMatch.newMatch(pMe);
  }
  
  /**
   * Retrieve the set of values that occur in matches for me.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<OpaqueBehavior> rawAccumulateAllValuesOfme(final Object[] parameters) {
    Set<OpaqueBehavior> results = new HashSet<OpaqueBehavior>();
    rawAccumulateAllValues(POSITION_ME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for me.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OpaqueBehavior> getAllValuesOfme() {
    return rawAccumulateAllValuesOfme(emptyArray());
  }
  
  @Override
  protected MethodNotPublicMatch tupleToMatch(final Tuple t) {
    try {
    	return MethodNotPublicMatch.newMatch((org.eclipse.uml2.uml.OpaqueBehavior) t.get(POSITION_ME));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MethodNotPublicMatch arrayToMatch(final Object[] match) {
    try {
    	return MethodNotPublicMatch.newMatch((org.eclipse.uml2.uml.OpaqueBehavior) match[POSITION_ME]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MethodNotPublicMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MethodNotPublicMatch.newMutableMatch((org.eclipse.uml2.uml.OpaqueBehavior) match[POSITION_ME]);
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
  public static IQuerySpecification<MethodNotPublicMatcher> querySpecification() throws IncQueryException {
    return MethodNotPublicQuerySpecification.instance();
  }
}
