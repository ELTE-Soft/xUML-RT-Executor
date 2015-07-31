package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

import java.util.Arrays;
import java.util.function.Function;

import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.uml2.uml.NamedElement;

/**
 * The root element of the translation tree.
 */
public class RootNode<UML extends NamedElement, Trans extends Named, Match extends IPatternMatch>
		extends AbstractNode<Trans, Match> {

	protected RootElementTranslator<UML, Trans, Match> translator;

	public RootNode(RootElementTranslator<UML, Trans, Match> translator,
			BaseMatcher<Match> matcher, Function<Match, Trans> transform) {
		super(Arrays.asList(matcher.getSpecification().getParameters().get(0)
				.getTypeName()), matcher, transform);
		this.translator = translator;
	}
}
