package hu.eltesoft.modelexecution.m2m.logic.listeners;

import hu.eltesoft.modelexecution.m2m.logic.registry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.registry.RootNameStorage;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;

import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.uml2.uml.NamedElement;

/**
 * A match update listener which is intended to be used with root m2m model
 * elements. Every object disappearance will indicate a delete operation in the
 * change registry.
 */
public class RootMatchUpdateListener<UML extends NamedElement, Match extends IPatternMatch>
		extends MatchUpdateListener<UML, Match> {

	private final RootNameStorage rootNames;

	public RootMatchUpdateListener(
			RootElementTranslator<UML, ?, Match> translator,
			ChangeRegistry changes, RootNameStorage rootNames) {
		super(translator, changes);
		this.rootNames = rootNames;
	}

	@Override
	public void notifyAppearance(Match match) {
		UML root = extractRoot(match);
		String rootName = translator.getRootName(root);
		rootNames.saveRootName(root, rootName);
		changes.registerUpdate(root, translator);
	}

	@Override
	public void notifyDisappearance(Match match) {
		UML root = extractRoot(match);
		rootNames.consumeRootName(root, changes::registerDelete);
	}
}
