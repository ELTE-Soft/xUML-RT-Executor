package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * Any node of the translation tree.
 */
public abstract class AbstractNode<Trans, Match extends IPatternMatch> {

	protected final BaseMatcher<Match> matcher;
	protected final Function<Match, Trans> transform;
	protected final List<AbstractFeatureNode<?, ?>> childNodes = new ArrayList<>();
	private List<String> types;

	public AbstractNode(List<String> types, BaseMatcher<Match> matcher, Function<Match, Trans> transform) {
		this.matcher = matcher;
		this.transform = transform;
		this.types = types;
	}

	/**
	 * Creates a sub-node that can translate any model element.
	 * @see FeatureNode
	 */
	public <SubMeta, SubMatch extends IPatternMatch> AbstractFeatureNode<SubMeta, SubMatch> on(
			EStructuralFeature feature, BaseMatcher<SubMatch> matcher, Function<SubMatch, SubMeta> transform) {
		checkMatcherParams(matcher);
		LinkedList<String> extendedTypes = extendParamList(matcher);
		AbstractFeatureNode<SubMeta, SubMatch> newNode = new FeatureNode<SubMeta, SubMatch>(extendedTypes, feature,
				matcher, transform);
		childNodes.add(newNode);
		return newNode;
	}

	/**
	 * Creates a sub-node that can translate model elements that are {@link EObject EObjects}.
	 * Supports automatic sorting.
	 * @see EObjectFeatureNode
	 */
	public <SubMeta extends EObject, SubMatch extends IPatternMatch> AbstractFeatureNode<SubMeta, SubMatch> onEObject(
			EStructuralFeature feature, BaseMatcher<SubMatch> matcher, Function<SubMatch, SubMeta> transform) {
		checkMatcherParams(matcher);
		LinkedList<String> extendedTypes = extendParamList(matcher);
		AbstractFeatureNode<SubMeta, SubMatch> newNode = new EObjectFeatureNode<SubMeta, SubMatch>(extendedTypes,
				feature, matcher, transform);
		childNodes.add(newNode);
		return newNode;
	}

	/**
	 * Creates a sub-node that supports sorting by a {@linkplain Comparator}
	 * defined on the processed matches.
	 * @see CustomSortedFeatureNode
	 */
	public <SubMeta extends EObject, SubMatch extends IPatternMatch> AbstractFeatureNode<SubMeta, SubMatch> onSorted(
			EStructuralFeature feature, BaseMatcher<SubMatch> matcher, Comparator<SubMatch> comparator,
			Function<SubMatch, SubMeta> transform) {
		checkMatcherParams(matcher);
		LinkedList<String> extendedTypes = extendParamList(matcher);
		AbstractFeatureNode<SubMeta, SubMatch> newNode = new CustomSortedFeatureNode<SubMeta, SubMatch>(extendedTypes,
				feature, matcher, transform, comparator);
		childNodes.add(newNode);
		return newNode;
	}

	protected LinkedList<String> extendParamList(BaseMatcher<?> matcher) {
		List<PParameter> parameters = matcher.getSpecification().getParameters();
		LinkedList<String> extendedTypes = new LinkedList<>(types);
		// allow simple (marker) queries, that does not add a new type to the
		// stack
		if (parameters.size() > types.size()) {
			extendedTypes.add(parameters.get(types.size()).getTypeName());
		}
		return extendedTypes;
	}

	/**
	 * Checks that the structure of the query is in the required format.
	 */
	protected void checkMatcherParams(BaseMatcher<?> matcher) {
		List<PParameter> parameters = matcher.getSpecification().getParameters();
		if (parameters.size() < types.size()) {
			throw new RuntimeException(
					"The pattern " + matcher.getPatternName() + " must have at least " + types.size() + " parameters");
		}
		for (int i = 0; i < types.size(); i++) {
			ClassLoader classLoader = getClass().getClassLoader();
			try {
				Class<?> expectedRoot = classLoader.loadClass(types.get(i));
				Class<?> actualRoot = classLoader.loadClass(parameters.get(i).getTypeName());
				// if the actual is assignable from the expected, than all
				// feature assignments that the transformation may perform will
				// be defined on the ancestor.
				if (!actualRoot.isAssignableFrom(expectedRoot)) {
					throw new RuntimeException("The " + i + "th parameter of the pattern " + matcher.getPatternName()
							+ " must be an ancestor of " + expectedRoot.getCanonicalName() + " but it is "
							+ actualRoot.getCanonicalName());
				}
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("While checking pattern arguments", e);
			}
		}
	}
}
