package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;

/**
 * A node that corresponds to a feature that's element is not a data type
 * defined by the translational metamodel. It can be a primitive type, or a
 * native java type that is wrapped by an {@linkplain EDataType}. <br/>
 * <b>Important: Ordering is not supported on these features.</b>
 */
public class FeatureNode<Trans, Match extends IPatternMatch> extends AbstractFeatureNode<Trans, Match> {

	public FeatureNode(List<String> types, EStructuralFeature feature, BaseMatcher<Match> matcher,
			Function<Match, Trans> transform) {
		super(types, feature, matcher, transform);
	}

	@Override
	protected void processOrderedMultiFeature(Match filterMatch, List<EObject> stack, Collection<Trans> list) {
		throw new IllegalArgumentException("Ordering supported only for EObject instances");
	}
}
