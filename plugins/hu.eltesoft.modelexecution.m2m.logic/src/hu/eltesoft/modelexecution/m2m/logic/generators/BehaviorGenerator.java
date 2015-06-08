package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.listeners.MatchUpdateListener;
import hu.eltesoft.modelexecution.m2m.logic.listeners.RootMatchUpdateListener;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhParameter;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.BehaviorTemplate;
import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzer;
import hu.eltesoft.modelexecution.uml.alf.UnsupportedAlfFeatureException;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatcher;


import hu.eltesoft.modelexecution.uml.incquery.StaticBehaviorMatcher;

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
	private final StaticBehaviorMatcher staticMatcher;
	private final AlfCodeMatcher alfCodeMatcher;
	private final ContainerClassOfBehaviorMatcher containerMatcher;
	private final BehaviorParameterMatcher parameterMatcher;
	private final BehaviorReturnTypeMatcher returnMatcher;

	public BehaviorGenerator(IncQueryEngine engine) throws IncQueryException {
		behaviorMatcher = BehaviorMatcher.on(engine);
		staticMatcher = StaticBehaviorMatcher.on(engine);
		alfCodeMatcher = AlfCodeMatcher.on(engine);
		containerMatcher = ContainerClassOfBehaviorMatcher.on(engine);
		parameterMatcher = BehaviorParameterMatcher.on(engine);
		returnMatcher = BehaviorReturnTypeMatcher.on(engine);
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
		
		root.setIsStatic(staticMatcher.hasMatch(source));
		
		returnMatcher.forOneArbitraryMatch(source, null, match -> {
			root.setReturnType(convertType(match.getType()));
		});
		
		collectParameters(source, root);

		String rootName = NamedReference.getIdentifier(source);
		return new Pair<>(rootName, new BehaviorTemplate(root));
	}

	protected void collectParameters(Behavior source, BhBehavior root) {
		parameterMatcher.forEachMatch(source, null, null, null, paramMatch -> {
			BhParameter parameter = FACTORY.createBhParameter();
			parameter.setReference(new NamedReference(paramMatch.getParameter()));
			parameter.setType(convertType(paramMatch.getType()));
			parameter.setDirection(convertDirection(paramMatch.getDirection()));
			root.getParameters().add(parameter);
		});
	}

	@Override
	public void runOn(Consumer<Behavior> task) {
		behaviorMatcher.forEachMatch((Behavior) null,
				match -> task.accept(match.getBehavior()));
	}

	@Override
	public ReversibleTask addListeners(AdvancedIncQueryEngine engine,
			ChangeRegistry changeRegistry) {

		return new ReversibleTask() {

			private final IMatchUpdateListener<BehaviorMatch> behaviorListener;
			private final IMatchUpdateListener<ContainerClassOfBehaviorMatch> containerClassOfBehaviorListener;
			private final IMatchUpdateListener<AlfCodeMatch> alfCodeListener;

			{
				behaviorMatcher.forEachMatch((Behavior) null,
						match -> saveRootName(match.getBehavior()));

				behaviorListener = new RootMatchUpdateListener<>(
						BehaviorGenerator.this, changeRegistry,
						match -> match.getBehavior());

				engine.addMatchUpdateListener(behaviorMatcher,
						behaviorListener, false);
			}

			{
				containerClassOfBehaviorListener = new MatchUpdateListener<>(
						BehaviorGenerator.this, changeRegistry,
						match -> match.getBehavior());

				engine.addMatchUpdateListener(containerMatcher,
						containerClassOfBehaviorListener, false);
			}

			{
				alfCodeListener = new MatchUpdateListener<>(
						BehaviorGenerator.this, changeRegistry,
						match -> match.getBehavior());

				engine.addMatchUpdateListener(alfCodeMatcher, alfCodeListener,
						false);
			}

			@Override
			public boolean revert() {
				engine.removeMatchUpdateListener(behaviorMatcher,
						behaviorListener);
				engine.removeMatchUpdateListener(containerMatcher,
						containerClassOfBehaviorListener);
				engine.removeMatchUpdateListener(alfCodeMatcher,
						alfCodeListener);
				return true;
			}
		};
	}
}
