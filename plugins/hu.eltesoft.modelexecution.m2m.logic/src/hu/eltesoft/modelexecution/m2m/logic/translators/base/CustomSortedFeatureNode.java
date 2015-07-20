package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;

public class CustomSortedFeatureNode<Trans, Match extends IPatternMatch> extends AbstractFeatureNode<Trans, Match> {

	private Comparator<Match> comparator;

	public CustomSortedFeatureNode(List<String> typeNames, EStructuralFeature feature, BaseMatcher<Match> matcher,
			Function<Match, Trans> transform, Comparator<Match> comparator) {
		super(typeNames, feature, matcher, transform);
		this.comparator = comparator;
	}

	@Override
	protected void processOrderedMultiFeature(Match filterMatch, List<EObject> stack, Collection<Trans> list) {
		List<Match> res = new ArrayList<>(matcher.getAllMatches(filterMatch));
		Collections.sort(res, comparator);
		res.forEach(m -> list.add(transform(m, stack)));
	}

}
