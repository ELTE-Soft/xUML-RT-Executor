package hu.eltesoft.modelexecution.m2m.logic.listeners;

import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.uml2.uml.NamedElement;

import hu.eltesoft.modelexecution.m2m.logic.registry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;

/**
 * Update listener applied by generators to keep the change registry in sync
 * using query notification listeners. As it indicates a modification even in
 * case of object removals, this class is intended to use with non-m2m-root
 * model elements.
 */
public class MatchUpdateListener<UML extends NamedElement, Match extends IPatternMatch>
		implements IMatchUpdateListener<Match> {

	protected final RootElementTranslator<UML, ?, ?> translator;
	protected final ChangeRegistry changes;

	public MatchUpdateListener(RootElementTranslator<UML, ?, ?> translator, ChangeRegistry changes) {
		this.translator = translator;
		this.changes = changes;
	}

	@Override
	public void notifyAppearance(Match match) {
		registerChangeIfAppliable(match);
	}

	@Override
	public void notifyDisappearance(Match match) {
		registerChangeIfAppliable(match);
	}

	private void registerChangeIfAppliable(Match match) {
		UML root = extractRoot(match);
		// To generalize patterns, we allow subpattern updates to appear for
		// multiple translators. For example when an attribute is created for an
		// AssociationClass, both the Class and AssociationClass translators
		// register it, but only the later can handle the change.
		if (translator.canHandle(root)) {
			changes.registerUpdate(extractRoot(match), translator);
		}
	}

	@SuppressWarnings("unchecked")
	protected UML extractRoot(Match match) {
		return (UML) match.get(0);
	}
}
