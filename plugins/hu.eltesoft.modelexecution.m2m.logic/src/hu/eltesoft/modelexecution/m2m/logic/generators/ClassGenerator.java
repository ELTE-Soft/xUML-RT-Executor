package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.listeners.MatchUpdateListener;
import hu.eltesoft.modelexecution.m2m.logic.listeners.RootMatchUpdateListener;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.ClassTemplate;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatch;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatch;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatch;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatch;
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher;

import java.util.function.Consumer;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.xtext.xbase.lib.Pair;

public class ClassGenerator extends AbstractGenerator<Class> {

	private static final ClassdefFactory FACTORY = ClassdefFactory.eINSTANCE;

	private final ClsMatcher clsMatcher;
	private final RegionOfClassMatcher regionOfClassMatcher;
	private final OperationMatcher operationMatcher;
	private final MethodMatcher methodMatcher;
	private final ReceptionMatcher receptionMatcher;

	public ClassGenerator(IncQueryEngine engine) throws IncQueryException {
		clsMatcher = ClsMatcher.on(engine);
		regionOfClassMatcher = RegionOfClassMatcher.on(engine);
		operationMatcher = OperationMatcher.on(engine);
		methodMatcher = MethodMatcher.on(engine);
		receptionMatcher = ReceptionMatcher.on(engine);
	}

	@Override
	public Pair<String, Template> getTemplate(Class source)
			throws GenerationException {
		ClClass root = FACTORY.createClClass();

		check(clsMatcher.forOneArbitraryMatch(source, match -> {
			Class pCls = match.getCls();
			root.setReference(new NamedReference(pCls));
		}));

		regionOfClassMatcher.forOneArbitraryMatch(source, null, match -> {
			Region pRegion = match.getRegion();
			root.setRegion(new NamedReference(pRegion));
		});

		operationMatcher.forEachMatch(source, null, match -> {
			Operation pOperation = match.getOperation();

			ClOperation clOperation = FACTORY.createClOperation();
			clOperation.setReference(new NamedReference(pOperation));

			// Method attribute is optional: if there is no match, the
			// method was missing from the source model as well.
				methodMatcher.forOneArbitraryMatch(null, pOperation, null,
						match2 -> {
							Behavior pMethod = match2.getMethod();
							clOperation.setMethod(new NamedReference(pMethod));
						});

				root.getOperations().add(clOperation);
			});

		receptionMatcher.forEachMatch(source, null, null, match -> {
			Reception pReception = match.getReception();
			Signal pSignal = match.getSignal();

			ClReception clReception = FACTORY.createClReception();
			clReception.setReference(new NamedReference(pReception));
			clReception.setSignal(new NamedReference(pSignal));

			root.getReceptions().add(clReception);
		});

		String rootName = NamedReference.getIdentifier(source);
		return new Pair<>(rootName, new ClassTemplate(root));
	}

	@Override
	public void runOn(Consumer<Class> task) {
		clsMatcher.forEachMatch((Class) null,
				match -> task.accept(match.getCls()));
	}

	@Override
	public ReversibleTask addListeners(AdvancedIncQueryEngine engine,
			ChangeRegistry changeRegistry) {

		return new ReversibleTask() {

			private final IMatchUpdateListener<ClsMatch> clsListener;
			private final IMatchUpdateListener<RegionOfClassMatch> regionOfClassListener;
			private final IMatchUpdateListener<OperationMatch> operationListener;
			private final IMatchUpdateListener<MethodMatch> methodListener;
			private final IMatchUpdateListener<ReceptionMatch> receptionListener;

			{
				clsMatcher.forEachMatch((Class) null,
						match -> saveRootName(match.getCls()));

				clsListener = new RootMatchUpdateListener<>(
						ClassGenerator.this, changeRegistry,
						match -> match.getCls());

				engine.addMatchUpdateListener(clsMatcher, clsListener, false);
			}

			{
				regionOfClassListener = new MatchUpdateListener<>(
						ClassGenerator.this, changeRegistry,
						match -> match.getCls());

				engine.addMatchUpdateListener(regionOfClassMatcher,
						regionOfClassListener, false);
			}

			{
				operationListener = new MatchUpdateListener<>(
						ClassGenerator.this, changeRegistry,
						match -> match.getCls());

				engine.addMatchUpdateListener(operationMatcher,
						operationListener, false);
			}

			{
				methodListener = new MatchUpdateListener<>(ClassGenerator.this,
						changeRegistry, match -> match.getCls());

				engine.addMatchUpdateListener(methodMatcher, methodListener,
						false);
			}

			{
				receptionListener = new MatchUpdateListener<>(
						ClassGenerator.this, changeRegistry,
						match -> match.getCls());

				engine.addMatchUpdateListener(receptionMatcher,
						receptionListener, false);
			}

			@Override
			public boolean revert() {
				engine.removeMatchUpdateListener(clsMatcher, clsListener);
				engine.removeMatchUpdateListener(regionOfClassMatcher,
						regionOfClassListener);
				engine.removeMatchUpdateListener(operationMatcher,
						operationListener);
				engine.removeMatchUpdateListener(methodMatcher, methodListener);
				engine.removeMatchUpdateListener(receptionMatcher,
						receptionListener);
				return true;
			}
		};
	}
}
