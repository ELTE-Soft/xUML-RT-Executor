package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior;
import hu.eltesoft.modelexecution.m2t.java.templates.BehaviorTemplate;
import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzer;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatcher;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;

public class BehaviorGenerator extends
		AbstractGenerator<Behavior, BhBehavior, BehaviorTemplate> {

	private static final BehaviorFactory FACTORY = BehaviorFactory.eINSTANCE;

	private final BehaviorMatcher behaviorMatcher;
	private final AlfCodeMatcher alfCodeMatcher;
	private final ContainerClassOfBehaviorMatcher containerMatcher;

	public BehaviorGenerator(IncQueryEngine engine, TextChangesListener listener)
			throws IncQueryException {
		super(listener);
		behaviorMatcher = BehaviorMatcher.on(engine);
		alfCodeMatcher = AlfCodeMatcher.on(engine);
		containerMatcher = ContainerClassOfBehaviorMatcher.on(engine);
	}

	@Override
	public BhBehavior generateTranslationModel(Behavior source)
			throws GenerationException {
		BhBehavior root = FACTORY.createBhBehavior();

		check(behaviorMatcher.forOneArbitraryMatch(source, match -> {
			Behavior pBehavior = match.getBehavior();
			root.setReference(new NamedReference(pBehavior));
		}));

		check(containerMatcher.forOneArbitraryMatch(source, null, match -> {
			Class pContainerClass = match.getContainerClass();
			root.setContainerClass(new NamedReference(pContainerClass));
		}));

		if (!alfCodeMatcher.forOneArbitraryMatch(source, null, null, match -> {
			String pAlfCode = match.getAlfCode();
			Class pContainerClass = match.getContainerClass();
			root.setAlfResult(new AlfAnalyzer().analyze(pAlfCode,
					pContainerClass));
		})) {
			root.setAlfResult(new AlfAnalyzer().analyze("{}"));
		}

		return root;
	}

	@Override
	protected BehaviorTemplate createTemplate(BhBehavior root) {
		return new BehaviorTemplate(root);
	};

	@Override
	public ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry) {

		return new ReversionTask() {

			private final IMatchUpdateListener<BehaviorMatch> behaviorListener;
			private final IMatchUpdateListener<ContainerClassOfBehaviorMatch> containerClassOfBehaviorListener;
			private final IMatchUpdateListener<AlfCodeMatch> alfCodeListener;

			{
				behaviorListener = new IMatchUpdateListener<BehaviorMatch>() {

					@Override
					public void notifyAppearance(BehaviorMatch match) {
						changeRegistry.newModification(match.getBehavior(),
								BehaviorGenerator.this);
					}

					@Override
					public void notifyDisappearance(BehaviorMatch match) {
						// disappearance of root: delete file
						Behavior b = match.getBehavior();
						String fileName = NamedReference.getIdentifier(b);
						changeRegistry.newDeletion(fileName);
					}
				};

				advancedEngine.addMatchUpdateListener(behaviorMatcher,
						behaviorListener, false);
			}

			{
				containerClassOfBehaviorListener = new IMatchUpdateListener<ContainerClassOfBehaviorMatch>() {

					@Override
					public void notifyAppearance(
							ContainerClassOfBehaviorMatch match) {
						changeRegistry.newModification(match.getBehavior(),
								BehaviorGenerator.this);
					}

					@Override
					public void notifyDisappearance(
							ContainerClassOfBehaviorMatch match) {
						changeRegistry.newModification(match.getBehavior(),
								BehaviorGenerator.this);
					}
				};

				advancedEngine.addMatchUpdateListener(containerMatcher,
						containerClassOfBehaviorListener, false);
			}

			{
				alfCodeListener = new IMatchUpdateListener<AlfCodeMatch>() {

					@Override
					public void notifyAppearance(AlfCodeMatch match) {
						changeRegistry.newModification(match.getBehavior(),
								BehaviorGenerator.this);
					}

					@Override
					public void notifyDisappearance(AlfCodeMatch match) {
						changeRegistry.newModification(match.getBehavior(),
								BehaviorGenerator.this);
					}
				};

				advancedEngine.addMatchUpdateListener(alfCodeMatcher,
						alfCodeListener, false);
			}

			@Override
			public boolean revert() {
				advancedEngine.removeMatchUpdateListener(behaviorMatcher,
						behaviorListener);
				advancedEngine.removeMatchUpdateListener(containerMatcher,
						containerClassOfBehaviorListener);
				advancedEngine.removeMatchUpdateListener(alfCodeMatcher,
						alfCodeListener);
				return true;
			}
		};
	}
}
