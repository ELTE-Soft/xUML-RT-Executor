package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhClass;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.templates.BehaviorTemplate;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AlfCodeProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfBehaviorProcessor;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;

/**
 * 
 * @author Gábor Ferenc Kovács
 *
 */
public class BehaviorGenerator extends AbstractGenerator<Behavior, BhBehavior> {

	private static final BehaviorFactory FACTORY = BehaviorFactory.eINSTANCE;

	private final BehaviorMatcher behaviorMatcher;
	private final AlfCodeMatcher alfCodeMatcher;
	private final ContainerClassOfBehaviorMatcher containerClassOfBehaviorMatcher;

	public BehaviorGenerator(IncQueryEngine engine, TextChangesListener listener)
			throws IncQueryException {
		super(listener);
		behaviorMatcher = BehaviorMatcher.on(engine);
		alfCodeMatcher = AlfCodeMatcher.on(engine);
		containerClassOfBehaviorMatcher = ContainerClassOfBehaviorMatcher
				.on(engine);
	}

	// generate translation model

	@Override
	public BhBehavior generateTranslationModel(Behavior source)
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

		return root;
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

	// generate text

	@Override
	public void generateText(BhBehavior root) {
		BehaviorTemplate template = new BehaviorTemplate(root);

		SourceMappedText output = template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		listener.contentChanged(root.getName(), output, symbols);
	}

	// add match update listeners

	@Override
	public void addMatchUpdateListeners(AdvancedIncQueryEngine advancedEngine,
			ChangeRegistry changeRegistry) {

		advancedEngine.addMatchUpdateListener(behaviorMatcher,
				new IMatchUpdateListener<BehaviorMatch>() {

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

				}, false);

		advancedEngine.addMatchUpdateListener(containerClassOfBehaviorMatcher,
				new IMatchUpdateListener<ContainerClassOfBehaviorMatch>() {

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

				}, false);

		advancedEngine.addMatchUpdateListener(alfCodeMatcher,
				new IMatchUpdateListener<AlfCodeMatch>() {

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

				}, false);

	}

}
