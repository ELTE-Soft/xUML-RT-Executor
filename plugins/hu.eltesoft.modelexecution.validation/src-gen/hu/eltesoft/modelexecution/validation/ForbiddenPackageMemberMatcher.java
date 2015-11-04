package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ForbiddenPackageMemberMatch;
import hu.eltesoft.modelexecution.validation.util.ForbiddenPackageMemberQuerySpecification;
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
import org.eclipse.uml2.uml.Element;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.ForbiddenPackageMember pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ForbiddenPackageMemberMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Packages can only contain components, packages, events, signals, associations and classes", mark = { "elem" })
 * pattern ForbiddenPackageMember(pk : Package, elem : Element) {
 * 	find Package(pk);
 * 	Package.ownedElement(pk, elem);
 * 	neg find GeneralPackagedElement(elem);
 * }
 * </pre></code>
 * 
 * @see ForbiddenPackageMemberMatch
 * @see ForbiddenPackageMemberProcessor
 * @see ForbiddenPackageMemberQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ForbiddenPackageMemberMatcher extends BaseMatcher<ForbiddenPackageMemberMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ForbiddenPackageMemberMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ForbiddenPackageMemberMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ForbiddenPackageMemberMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_PK = 0;
  
  private final static int POSITION_ELEM = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ForbiddenPackageMemberMatcher.class);
  
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
  public ForbiddenPackageMemberMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ForbiddenPackageMemberMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPk the fixed value of pattern parameter pk, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return matches represented as a ForbiddenPackageMemberMatch object.
   * 
   */
  public Collection<ForbiddenPackageMemberMatch> getAllMatches(final org.eclipse.uml2.uml.Package pPk, final Element pElem) {
    return rawGetAllMatches(new Object[]{pPk, pElem});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPk the fixed value of pattern parameter pk, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return a match represented as a ForbiddenPackageMemberMatch object, or null if no match is found.
   * 
   */
  public ForbiddenPackageMemberMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Package pPk, final Element pElem) {
    return rawGetOneArbitraryMatch(new Object[]{pPk, pElem});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pPk the fixed value of pattern parameter pk, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Package pPk, final Element pElem) {
    return rawHasMatch(new Object[]{pPk, pElem});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pPk the fixed value of pattern parameter pk, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Package pPk, final Element pElem) {
    return rawCountMatches(new Object[]{pPk, pElem});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pPk the fixed value of pattern parameter pk, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Package pPk, final Element pElem, final IMatchProcessor<? super ForbiddenPackageMemberMatch> processor) {
    rawForEachMatch(new Object[]{pPk, pElem}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pPk the fixed value of pattern parameter pk, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Package pPk, final Element pElem, final IMatchProcessor<? super ForbiddenPackageMemberMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pPk, pElem}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPk the fixed value of pattern parameter pk, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ForbiddenPackageMemberMatch newMatch(final org.eclipse.uml2.uml.Package pPk, final Element pElem) {
    return ForbiddenPackageMemberMatch.newMatch(pPk, pElem);
  }
  
  /**
   * Retrieve the set of values that occur in matches for pk.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Package> rawAccumulateAllValuesOfpk(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Package> results = new HashSet<org.eclipse.uml2.uml.Package>();
    rawAccumulateAllValues(POSITION_PK, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for pk.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfpk() {
    return rawAccumulateAllValuesOfpk(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for pk.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfpk(final ForbiddenPackageMemberMatch partialMatch) {
    return rawAccumulateAllValuesOfpk(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for pk.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Package> getAllValuesOfpk(final Element pElem) {
    return rawAccumulateAllValuesOfpk(new Object[]{
    null, 
    pElem
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Element> rawAccumulateAllValuesOfelem(final Object[] parameters) {
    Set<Element> results = new HashSet<Element>();
    rawAccumulateAllValues(POSITION_ELEM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfelem() {
    return rawAccumulateAllValuesOfelem(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfelem(final ForbiddenPackageMemberMatch partialMatch) {
    return rawAccumulateAllValuesOfelem(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfelem(final org.eclipse.uml2.uml.Package pPk) {
    return rawAccumulateAllValuesOfelem(new Object[]{
    pPk, 
    null
    });
  }
  
  @Override
  protected ForbiddenPackageMemberMatch tupleToMatch(final Tuple t) {
    try {
    	return ForbiddenPackageMemberMatch.newMatch((org.eclipse.uml2.uml.Package) t.get(POSITION_PK), (org.eclipse.uml2.uml.Element) t.get(POSITION_ELEM));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ForbiddenPackageMemberMatch arrayToMatch(final Object[] match) {
    try {
    	return ForbiddenPackageMemberMatch.newMatch((org.eclipse.uml2.uml.Package) match[POSITION_PK], (org.eclipse.uml2.uml.Element) match[POSITION_ELEM]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ForbiddenPackageMemberMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ForbiddenPackageMemberMatch.newMutableMatch((org.eclipse.uml2.uml.Package) match[POSITION_PK], (org.eclipse.uml2.uml.Element) match[POSITION_ELEM]);
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
  public static IQuerySpecification<ForbiddenPackageMemberMatcher> querySpecification() throws IncQueryException {
    return ForbiddenPackageMemberQuerySpecification.instance();
  }
}
