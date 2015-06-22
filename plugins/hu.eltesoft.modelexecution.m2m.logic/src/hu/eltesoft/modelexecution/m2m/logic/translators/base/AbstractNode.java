package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**

 */
public abstract class AbstractNode<Trans, Match extends IPatternMatch> {

	protected final BaseMatcher<Match> matcher;
	protected final Function<Match, Trans> transform;
	protected final List<AbstractFeatureNode<?, ?>> childNodes = new ArrayList<>();
	private List<String> types;

	public AbstractNode(List<String> types, BaseMatcher<Match> matcher,
			Function<Match, Trans> transform) {
		this.matcher = matcher;
		this.transform = transform;
		this.types = types;
	}

	public <SubMeta extends EObject, SubMatch extends IPatternMatch> AbstractFeatureNode<SubMeta, SubMatch> onEObject(
			EStructuralFeature feature, BaseMatcher<SubMatch> matcher,
			Function<SubMatch, SubMeta> transform) {
		checkMatcherParams(matcher);
		LinkedList<String> extendedTypes = extendParamList(matcher);
		AbstractFeatureNode<SubMeta, SubMatch> newNode = new EObjectFeatureNode<SubMeta, SubMatch>(
				extendedTypes, feature, matcher, transform);
		childNodes.add(newNode);
		return newNode;
	}

	public <SubMeta, SubMatch extends IPatternMatch> AbstractFeatureNode<SubMeta, SubMatch> on(
			EStructuralFeature feature, BaseMatcher<SubMatch> matcher,
			Function<SubMatch, SubMeta> transform) {
		checkMatcherParams(matcher);
		LinkedList<String> extendedTypes = extendParamList(matcher);
		AbstractFeatureNode<SubMeta, SubMatch> newNode = new FeatureNode<SubMeta, SubMatch>(
				extendedTypes, feature, matcher, transform);
		childNodes.add(newNode);
		return newNode;
	}

	protected LinkedList<String> extendParamList(BaseMatcher<?> matcher) {
		List<PParameter> parameters = matcher.getSpecification()
				.getParameters();
		LinkedList<String> extendedTypes = new LinkedList<>(types);
		// allow simple (marker) queries, that does not add a new type to the stack
		if (parameters.size() > types.size()) {
			extendedTypes.add(parameters.get(types.size()).getTypeName());
		}
		return extendedTypes;
	}

	/**
	 * Checks that the structure of the query is in the required format.
	 */
	protected void checkMatcherParams(BaseMatcher<?> matcher) {
		List<PParameter> parameters = matcher.getSpecification()
				.getParameters();
		if (parameters.size() < types.size()) {
			throw new RuntimeException("The pattern "
					+ matcher.getPatternName() + " must have at least "
					+ types.size() + " parameters");
		}
		for (int i = 0; i < types.size(); i++) {
			if (!parameters.get(i).getTypeName().equals(types.get(i))) {
				throw new RuntimeException("The " + i
						+ "th parameter of the pattern "
						+ matcher.getPatternName() + " must be of type "
						+ types.get(i) + " but it is "
						+ parameters.get(i).getTypeName());
			}
		}
	}
}
