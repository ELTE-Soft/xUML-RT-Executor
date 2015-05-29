package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.BehaviorTemplate;
import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzer;
import hu.eltesoft.modelexecution.uml.alf.UnsupportedAlfFeatureException;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatcher;

import java.util.function.Consumer;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.xtext.xbase.lib.Pair;

public class BehaviorGenerator extends AbstractGenerator<Behavior> {

	private static final BehaviorFactory FACTORY = BehaviorFactory.eINSTANCE;

	private final BehaviorMatcher behaviorMatcher;
	private final AlfCodeMatcher alfCodeMatcher;
	private final ContainerClassOfBehaviorMatcher containerMatcher;

	public BehaviorGenerator(IncQueryEngine engine) throws IncQueryException {
		behaviorMatcher = BehaviorMatcher.on(engine);
		alfCodeMatcher = AlfCodeMatcher.on(engine);
		containerMatcher = ContainerClassOfBehaviorMatcher.on(engine);
	}

	@Override
	public Pair<String, Template> getTemplate(Behavior source)
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
			try {
				String pAlfCode = match.getAlfCode();
				Class pContainerClass = match.getContainerClass();
				root.setAlfResult(new AlfAnalyzer().analyze(pAlfCode,
						pContainerClass));
			} catch (UnsupportedAlfFeatureException e) {
				throw new GenerationException(e);
			}
		})) {
			root.setAlfResult(new AlfAnalyzer().analyze("{}"));
		}

		String rootName = NamedReference.getIdentifier(source);
		return new Pair<>(rootName, new BehaviorTemplate(root));
	}

	@Override
	public void runOn(Consumer<Behavior> task) {
		behaviorMatcher.forEachMatch((Behavior) null,
				match -> task.accept(match.getBehavior()));
	}

	@Override
	public ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry) {

		return new ReversionTask() {

			private final IMatchUpdateListener<BehaviorMatch> behaviorListener;
			private final IMatchUpdateListener<ContainerClassOfBehaviorMatch> containerClassOfBehaviorListener;
			private final IMatchUpdateListener<AlfCodeMatch> alfCodeListener;

			{
				behaviorMatcher.forEachMatch((Behavior) null,
						match -> saveRootName(match.getBehavior()));

				behaviorListener = new IMatchUpdateListener<BehaviorMatch>() {

					@Override
					public void notifyAppearance(BehaviorMatch match) {
						Behavior behavior = match.getBehavior();
						saveRootName(behavior);
						changeRegistry.newModification(behavior,
								BehaviorGenerator.this);
					}

					@Override
					public void notifyDisappearance(BehaviorMatch match) {
						Behavior behavior = match.getBehavior();
						consumeRootName(behavior, changeRegistry::newDeletion);
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
