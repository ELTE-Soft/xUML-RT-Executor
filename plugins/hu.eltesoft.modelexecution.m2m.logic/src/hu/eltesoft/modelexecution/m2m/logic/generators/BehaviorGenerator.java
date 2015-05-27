package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhClass;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.BehaviorTemplate;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AlfCodeProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfBehaviorProcessor;

import java.util.function.Consumer;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.xtext.xbase.lib.Pair;

public class BehaviorGenerator extends AbstractGenerator<Behavior> {

	private static final BehaviorFactory FACTORY = BehaviorFactory.eINSTANCE;

	private final BehaviorMatcher behaviorMatcher;
	private final AlfCodeMatcher alfCodeMatcher;
	private final ContainerClassOfBehaviorMatcher containerClassOfBehaviorMatcher;

	public BehaviorGenerator(IncQueryEngine engine) throws IncQueryException {
		behaviorMatcher = BehaviorMatcher.on(engine);
		alfCodeMatcher = AlfCodeMatcher.on(engine);
		containerClassOfBehaviorMatcher = ContainerClassOfBehaviorMatcher
				.on(engine);
	}

	// generate translation model

	@Override
	public Pair<String, Template> getTemplate(Behavior source)
			throws GenerationException {
		// new BhBehavior
		BhBehavior root = FACTORY.createBhBehavior();

		// name
		check(behaviorMatcher.forOneArbitraryMatch(source, null,
				getProcessorToSetNameOfRoot(root)));

		// containerClass
		check(containerClassOfBehaviorMatcher.forOneArbitraryMatch(source,
				null, getProcessorToSetContainerClassOfRoot(root)));

		// alfCode
		if (!alfCodeMatcher.forOneArbitraryMatch(source, null,
				getProcessorToSetAlfCodeOfRoot(root))) {

			root.setAlfCode("{}");
		}

		return new Pair<>(root.getName(), new BehaviorTemplate(root));
	}

	private BehaviorProcessor getProcessorToSetNameOfRoot(BhBehavior root) {
		return new BehaviorProcessor() {

			@Override
			public void process(Behavior pBehavior, String pBehaviorName) {
				root.setName(pBehaviorName);
			}

		};
	}

	private ContainerClassOfBehaviorProcessor getProcessorToSetContainerClassOfRoot(
			BhBehavior root) {
		return new ContainerClassOfBehaviorProcessor() {

			@Override
			public void process(Behavior pBehavior, String pContainerClassName) {
				root.setContainerClass(createContainerClass(pContainerClassName));
			}

			private BhClass createContainerClass(String name) {
				// new BhClass
				BhClass bhClass = FACTORY.createBhClass();

				// name
				bhClass.setName(name);

				return bhClass;
			}

		};
	}

	private AlfCodeProcessor getProcessorToSetAlfCodeOfRoot(BhBehavior root) {
		return new AlfCodeProcessor() {

			@Override
			public void process(Behavior pBehavior, String pAlfCode) {
				root.setAlfCode(pAlfCode);
			}

		};
	}

	// run query directly

	public void runOn(Consumer<Behavior> task) {
		behaviorMatcher.forEachMatch(null, null,
				match -> task.accept(match.getBehavior()));
	}

	// add match update listeners

	@Override
	public ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry) {

		return new ReversionTask() {

			private final IMatchUpdateListener<BehaviorMatch> behaviorListener;
			private final IMatchUpdateListener<ContainerClassOfBehaviorMatch> containerClassOfBehaviorListener;
			private final IMatchUpdateListener<AlfCodeMatch> alfCodeListener;

			{ // set behaviorListener
				behaviorListener = new IMatchUpdateListener<BehaviorMatch>() {

					@Override
					public void notifyAppearance(BehaviorMatch match) {
						changeRegistry.newModification(match.getBehavior(),
								BehaviorGenerator.this);
					}

					@Override
					public void notifyDisappearance(BehaviorMatch match) {
						// disappearance of root: delete file
						changeRegistry.newDeletion(match.getBehaviorName());
					}

				};

				advancedEngine.addMatchUpdateListener(behaviorMatcher,
						behaviorListener, false);
			}

			{ // set containerClassOfBehaviorListener
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

				advancedEngine.addMatchUpdateListener(
						containerClassOfBehaviorMatcher,
						containerClassOfBehaviorListener, false);

			}

			{ // setAlfCodeListener
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
				advancedEngine.removeMatchUpdateListener(
						containerClassOfBehaviorMatcher,
						containerClassOfBehaviorListener);
				advancedEngine.removeMatchUpdateListener(alfCodeMatcher,
						alfCodeListener);

				return true;
			}

		};

	}
}
