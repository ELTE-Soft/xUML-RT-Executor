package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.TwoElementWithSameNameMatch;
import hu.eltesoft.modelexecution.validation.util.TwoElementWithSameNameQuerySpecification;
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
import org.eclipse.uml2.uml.NamedElement;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.TwoElementWithSameName pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TwoElementWithSameNameMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * // FIXME: reenable when qualified name is correct
 * //{@literal @}Violation(message = "Two elements with the same qualified name: {qname}", mark = { "elem1", "elem2" })
 * pattern TwoElementWithSameName(qname, elem1 : NamedElement, elem2 : NamedElement) {
 * 	NamedElement.qualifiedName(elem1, qname);
 * 	NamedElement.qualifiedName(elem2, qname);
 * 	elem1 != elem2;
 * }
 * </pre></code>
 * 
 * @see TwoElementWithSameNameMatch
 * @see TwoElementWithSameNameProcessor
 * @see TwoElementWithSameNameQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TwoElementWithSameNameMatcher extends BaseMatcher<TwoElementWithSameNameMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TwoElementWithSameNameMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    TwoElementWithSameNameMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new TwoElementWithSameNameMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_QNAME = 0;
  
  private final static int POSITION_ELEM1 = 1;
  
  private final static int POSITION_ELEM2 = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(TwoElementWithSameNameMatcher.class);
  
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
  public TwoElementWithSameNameMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public TwoElementWithSameNameMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pQname the fixed value of pattern parameter qname, or null if not bound.
   * @param pElem1 the fixed value of pattern parameter elem1, or null if not bound.
   * @param pElem2 the fixed value of pattern parameter elem2, or null if not bound.
   * @return matches represented as a TwoElementWithSameNameMatch object.
   * 
   */
  public Collection<TwoElementWithSameNameMatch> getAllMatches(final String pQname, final NamedElement pElem1, final NamedElement pElem2) {
    return rawGetAllMatches(new Object[]{pQname, pElem1, pElem2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pQname the fixed value of pattern parameter qname, or null if not bound.
   * @param pElem1 the fixed value of pattern parameter elem1, or null if not bound.
   * @param pElem2 the fixed value of pattern parameter elem2, or null if not bound.
   * @return a match represented as a TwoElementWithSameNameMatch object, or null if no match is found.
   * 
   */
  public TwoElementWithSameNameMatch getOneArbitraryMatch(final String pQname, final NamedElement pElem1, final NamedElement pElem2) {
    return rawGetOneArbitraryMatch(new Object[]{pQname, pElem1, pElem2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pQname the fixed value of pattern parameter qname, or null if not bound.
   * @param pElem1 the fixed value of pattern parameter elem1, or null if not bound.
   * @param pElem2 the fixed value of pattern parameter elem2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final String pQname, final NamedElement pElem1, final NamedElement pElem2) {
    return rawHasMatch(new Object[]{pQname, pElem1, pElem2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pQname the fixed value of pattern parameter qname, or null if not bound.
   * @param pElem1 the fixed value of pattern parameter elem1, or null if not bound.
   * @param pElem2 the fixed value of pattern parameter elem2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final String pQname, final NamedElement pElem1, final NamedElement pElem2) {
    return rawCountMatches(new Object[]{pQname, pElem1, pElem2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pQname the fixed value of pattern parameter qname, or null if not bound.
   * @param pElem1 the fixed value of pattern parameter elem1, or null if not bound.
   * @param pElem2 the fixed value of pattern parameter elem2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final String pQname, final NamedElement pElem1, final NamedElement pElem2, final IMatchProcessor<? super TwoElementWithSameNameMatch> processor) {
    rawForEachMatch(new Object[]{pQname, pElem1, pElem2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pQname the fixed value of pattern parameter qname, or null if not bound.
   * @param pElem1 the fixed value of pattern parameter elem1, or null if not bound.
   * @param pElem2 the fixed value of pattern parameter elem2, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final String pQname, final NamedElement pElem1, final NamedElement pElem2, final IMatchProcessor<? super TwoElementWithSameNameMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pQname, pElem1, pElem2}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pQname the fixed value of pattern parameter qname, or null if not bound.
   * @param pElem1 the fixed value of pattern parameter elem1, or null if not bound.
   * @param pElem2 the fixed value of pattern parameter elem2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TwoElementWithSameNameMatch newMatch(final String pQname, final NamedElement pElem1, final NamedElement pElem2) {
    return TwoElementWithSameNameMatch.newMatch(pQname, pElem1, pElem2);
  }
  
  /**
   * Retrieve the set of values that occur in matches for qname.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfqname(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_QNAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for qname.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfqname() {
    return rawAccumulateAllValuesOfqname(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for qname.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfqname(final TwoElementWithSameNameMatch partialMatch) {
    return rawAccumulateAllValuesOfqname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for qname.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfqname(final NamedElement pElem1, final NamedElement pElem2) {
    return rawAccumulateAllValuesOfqname(new Object[]{
    null, 
    pElem1, 
    pElem2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<NamedElement> rawAccumulateAllValuesOfelem1(final Object[] parameters) {
    Set<NamedElement> results = new HashSet<NamedElement>();
    rawAccumulateAllValues(POSITION_ELEM1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfelem1() {
    return rawAccumulateAllValuesOfelem1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfelem1(final TwoElementWithSameNameMatch partialMatch) {
    return rawAccumulateAllValuesOfelem1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfelem1(final String pQname, final NamedElement pElem2) {
    return rawAccumulateAllValuesOfelem1(new Object[]{
    pQname, 
    null, 
    pElem2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<NamedElement> rawAccumulateAllValuesOfelem2(final Object[] parameters) {
    Set<NamedElement> results = new HashSet<NamedElement>();
    rawAccumulateAllValues(POSITION_ELEM2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfelem2() {
    return rawAccumulateAllValuesOfelem2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfelem2(final TwoElementWithSameNameMatch partialMatch) {
    return rawAccumulateAllValuesOfelem2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for elem2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<NamedElement> getAllValuesOfelem2(final String pQname, final NamedElement pElem1) {
    return rawAccumulateAllValuesOfelem2(new Object[]{
    pQname, 
    pElem1, 
    null
    });
  }
  
  @Override
  protected TwoElementWithSameNameMatch tupleToMatch(final Tuple t) {
    try {
    	return TwoElementWithSameNameMatch.newMatch((java.lang.String) t.get(POSITION_QNAME), (org.eclipse.uml2.uml.NamedElement) t.get(POSITION_ELEM1), (org.eclipse.uml2.uml.NamedElement) t.get(POSITION_ELEM2));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TwoElementWithSameNameMatch arrayToMatch(final Object[] match) {
    try {
    	return TwoElementWithSameNameMatch.newMatch((java.lang.String) match[POSITION_QNAME], (org.eclipse.uml2.uml.NamedElement) match[POSITION_ELEM1], (org.eclipse.uml2.uml.NamedElement) match[POSITION_ELEM2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TwoElementWithSameNameMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return TwoElementWithSameNameMatch.newMutableMatch((java.lang.String) match[POSITION_QNAME], (org.eclipse.uml2.uml.NamedElement) match[POSITION_ELEM1], (org.eclipse.uml2.uml.NamedElement) match[POSITION_ELEM2]);
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
  public static IQuerySpecification<TwoElementWithSameNameMatcher> querySpecification() throws IncQueryException {
    return TwoElementWithSameNameQuerySpecification.instance();
  }
}
