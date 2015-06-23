package hu.eltesoft.modelexecution.m2m.logic.listeners;

import hu.eltesoft.modelexecution.m2m.logic.registry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;

import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.uml2.uml.NamedElement;

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

	public MatchUpdateListener(RootElementTranslator<UML, ?, ?> translator,
			ChangeRegistry changes) {
		this.translator = translator;
		this.changes = changes;
	}

	@Override
	public void notifyAppearance(Match match) {
		changes.registerUpdate(extractRoot(match), translator);
	}

	@Override
	public void notifyDisappearance(Match match) {
		changes.registerUpdate(extractRoot(match), translator);
	}

	@SuppressWarnings("unchecked")
	protected UML extractRoot(Match match) {
		return (UML) match.get(0);
	}
}
