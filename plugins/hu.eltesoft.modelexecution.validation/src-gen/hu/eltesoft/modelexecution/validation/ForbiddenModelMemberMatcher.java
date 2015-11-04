package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ForbiddenModelMemberMatch;
import hu.eltesoft.modelexecution.validation.util.ForbiddenModelMemberQuerySpecification;
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
import org.eclipse.uml2.uml.Model;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.ForbiddenModelMember pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ForbiddenModelMemberMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Models can only contain components, packages, events, signals, classes, associations, package imports and profile application", mark = { "elem" })
 * pattern ForbiddenModelMember(md : Model, elem : Element) {
 * 	Package.ownedElement(md, elem);
 * 	neg find GeneralPackagedElement(elem);
 * 	neg find PackageImport(elem);
 * 	neg find ProfileApplication(elem);
 * }
 * </pre></code>
 * 
 * @see ForbiddenModelMemberMatch
 * @see ForbiddenModelMemberProcessor
 * @see ForbiddenModelMemberQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ForbiddenModelMemberMatcher extends BaseMatcher<ForbiddenModelMemberMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ForbiddenModelMemberMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ForbiddenModelMemberMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ForbiddenModelMemberMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_MD = 0;
  
  private final static int POSITION_ELEM = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ForbiddenModelMemberMatcher.class);
  
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
  public ForbiddenModelMemberMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ForbiddenModelMemberMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pMd the fixed value of pattern parameter md, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return matches represented as a ForbiddenModelMemberMatch object.
   * 
   */
  public Collection<ForbiddenModelMemberMatch> getAllMatches(final Model pMd, final Element pElem) {
    return rawGetAllMatches(new Object[]{pMd, pElem});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pMd the fixed value of pattern parameter md, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return a match represented as a ForbiddenModelMemberMatch object, or null if no match is found.
   * 
   */
  public ForbiddenModelMemberMatch getOneArbitraryMatch(final Model pMd, final Element pElem) {
    return rawGetOneArbitraryMatch(new Object[]{pMd, pElem});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pMd the fixed value of pattern parameter md, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Model pMd, final Element pElem) {
    return rawHasMatch(new Object[]{pMd, pElem});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pMd the fixed value of pattern parameter md, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Model pMd, final Element pElem) {
    return rawCountMatches(new Object[]{pMd, pElem});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pMd the fixed value of pattern parameter md, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Model pMd, final Element pElem, final IMatchProcessor<? super ForbiddenModelMemberMatch> processor) {
    rawForEachMatch(new Object[]{pMd, pElem}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pMd the fixed value of pattern parameter md, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Model pMd, final Element pElem, final IMatchProcessor<? super ForbiddenModelMemberMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pMd, pElem}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pMd the fixed value of pattern parameter md, or null if not bound.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ForbiddenModelMemberMatch newMatch(final Model pMd, final Element pElem) {
    return ForbiddenModelMemberMatch.newMatch(pMd, pElem);
  }
  
  /**
   * Retrieve the set of values that occur in matches for md.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Model> rawAccumulateAllValuesOfmd(final Object[] parameters) {
    Set<Model> results = new HashSet<Model>();
    rawAccumulateAllValues(POSITION_MD, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for md.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Model> getAllValuesOfmd() {
    return rawAccumulateAllValuesOfmd(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for md.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Model> getAllValuesOfmd(final ForbiddenModelMemberMatch partialMatch) {
    return rawAccumulateAllValuesOfmd(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for md.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Model> getAllValuesOfmd(final Element pElem) {
    return rawAccumulateAllValuesOfmd(new Object[]{
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
  public Set<Element> getAllValuesOfelem(final ForbiddenModelMemberMatch partialMatch) {
    return rawAccumulateAllValuesOfelem(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Element> getAllValuesOfelem(final Model pMd) {
    return rawAccumulateAllValuesOfelem(new Object[]{
    pMd, 
    null
    });
  }
  
  @Override
  protected ForbiddenModelMemberMatch tupleToMatch(final Tuple t) {
    try {
    	return ForbiddenModelMemberMatch.newMatch((org.eclipse.uml2.uml.Model) t.get(POSITION_MD), (org.eclipse.uml2.uml.Element) t.get(POSITION_ELEM));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ForbiddenModelMemberMatch arrayToMatch(final Object[] match) {
    try {
    	return ForbiddenModelMemberMatch.newMatch((org.eclipse.uml2.uml.Model) match[POSITION_MD], (org.eclipse.uml2.uml.Element) match[POSITION_ELEM]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ForbiddenModelMemberMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ForbiddenModelMemberMatch.newMutableMatch((org.eclipse.uml2.uml.Model) match[POSITION_MD], (org.eclipse.uml2.uml.Element) match[POSITION_ELEM]);
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
  public static IQuerySpecification<ForbiddenModelMemberMatcher> querySpecification() throws IncQueryException {
    return ForbiddenModelMemberQuerySpecification.instance();
  }
}
