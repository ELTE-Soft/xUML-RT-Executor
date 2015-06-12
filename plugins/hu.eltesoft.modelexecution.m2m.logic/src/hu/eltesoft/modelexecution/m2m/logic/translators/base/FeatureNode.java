package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;

public class FeatureNode<Trans, Match extends IPatternMatch> extends
		AbstractFeatureNode<Trans, Match> {

	public FeatureNode(List<String> types, EStructuralFeature feature, BaseMatcher<Match> matcher,
			Function<Match, Trans> transform) {
		super(types, feature, matcher, transform);
	}

	@Override
	protected void processOrderedMultiFeature(Match filterMatch,
			List<EObject> stack, Collection<Trans> list) {
		throw new IllegalArgumentException(
				"Ordering supported only for EObject instances");
	}
}
