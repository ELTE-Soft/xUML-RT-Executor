package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClRegion;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClSignal;
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
import hu.eltesoft.modelexecution.uml.incquery.util.ClsProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.MethodProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.RegionOfClassProcessor;

import java.util.function.Consumer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
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

	// generate translation model

	@Override
	public Pair<String, Template> getTemplate(Class source)
			throws GenerationException {
		// new ClClass
		ClClass root = FACTORY.createClClass();

		// name
		check(clsMatcher.forOneArbitraryMatch(source, null,
				getProcessorToSetNameOfRoot(root)));

		// region
		regionOfClassMatcher.forOneArbitraryMatch(source, null,
				getProcessorToSetRegionOfRoot(root));

		// operations
		operationMatcher.forEachMatch(source, null, null,
				getProcessorToSetOperationsOfRoot(root.getOperations()));

		// receptions
		receptionMatcher.forEachMatch(source, null, null,
				getProcessorToSetReceptionsOfRoot(root.getReceptions()));

		return new Pair<>(root.getName(), new ClassTemplate(root));
	}

	private ClsProcessor getProcessorToSetNameOfRoot(ClClass root) {
		return new ClsProcessor() {

			@Override
			public void process(Class pCls, String pClassName) {
				root.setName(pClassName);
			}

		};
	}

	private RegionOfClassProcessor getProcessorToSetRegionOfRoot(ClClass root) {
		return new RegionOfClassProcessor() {

			@Override
			public void process(Class pCls, String pRegionName) {
				// new ClRegion
				ClRegion clRegion = FACTORY.createClRegion();

				// name
				clRegion.setName(pRegionName);

				root.setRegion(clRegion);
			}

		};
	}

	private OperationProcessor getProcessorToSetOperationsOfRoot(
			EList<ClOperation> operationsOfRoot) {
		return new OperationProcessor() {

			@Override
			public void process(Class pCls, Operation pOperation,
					String pOperationName) {
				// new ClOperation
				ClOperation clOperation = FACTORY.createClOperation();

				// name
				clOperation.setName(pOperationName);

				// method
				methodMatcher.forOneArbitraryMatch(null, pOperation, null,
						getProcessorToSetMethodOfOperation(clOperation));
				// Method attribute is optional: if there is no match, the
				// method was missing from the source model as well.

				operationsOfRoot.add(clOperation);
			}

			private MethodProcessor getProcessorToSetMethodOfOperation(
					ClOperation clOperation) {
				return new MethodProcessor() {
					@Override
					public void process(Class pCls, Operation pOperation,
							String pMethodName) {
						clOperation.setMethod(pMethodName);
					}
				};
			}

		};
	}

	private ReceptionProcessor getProcessorToSetReceptionsOfRoot(
			EList<ClReception> receptionsOfRoot) {
		return new ReceptionProcessor() {

			@Override
			public void process(Class pCls, String pReceptionName,
					String pSignalName) {
				// new ClReception
				ClReception clReception = FACTORY.createClReception();

				// name
				clReception.setName(pReceptionName);

				// signal
				clReception.setSignal(createSignal(pSignalName));

				receptionsOfRoot.add(clReception);
			}

			private ClSignal createSignal(String name) {
				// new ClSignal
				ClSignal clSignal = FACTORY.createClSignal();

				// name
				clSignal.setName(name);

				return clSignal;
			}

		};
	}

	// run query directly

	public void runOn(Consumer<Class> task) {
		clsMatcher.forEachMatch(null, null,
				match -> task.accept(match.getCls()));
	}

	// add match update listener

	@Override
	public ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry) {

		return new ReversionTask() {

			private final IMatchUpdateListener<ClsMatch> clsListener;
			private final IMatchUpdateListener<RegionOfClassMatch> regionOfClassListener;
			private final IMatchUpdateListener<OperationMatch> operationListener;
			private final IMatchUpdateListener<MethodMatch> methodListener;
			private final IMatchUpdateListener<ReceptionMatch> receptionListener;

			{ // set clsListener
				clsListener = new IMatchUpdateListener<ClsMatch>() {

					@Override
					public void notifyAppearance(ClsMatch match) {
						changeRegistry.newModification(match.getCls(),
								ClassGenerator.this);
					}

					@Override
					public void notifyDisappearance(ClsMatch match) {
						// disappearance of root: delete file
						changeRegistry.newDeletion(match.getClassName());
					}

				};

				advancedEngine.addMatchUpdateListener(clsMatcher, clsListener,
						false);
			}

			{ // set regionOfClassListener
				regionOfClassListener = new IMatchUpdateListener<RegionOfClassMatch>() {

					@Override
					public void notifyAppearance(RegionOfClassMatch match) {
						changeRegistry.newModification(match.getCls(),
								ClassGenerator.this);
					}

					@Override
					public void notifyDisappearance(RegionOfClassMatch match) {
						changeRegistry.newModification(match.getCls(),
								ClassGenerator.this);
					}

				};

				advancedEngine.addMatchUpdateListener(regionOfClassMatcher,
						regionOfClassListener, false);
			}

			{ // set operationListener
				operationListener = new IMatchUpdateListener<OperationMatch>() {

					@Override
					public void notifyAppearance(OperationMatch match) {
						changeRegistry.newModification(match.getCls(),
								ClassGenerator.this);
					}

					@Override
					public void notifyDisappearance(OperationMatch match) {
						changeRegistry.newModification(match.getCls(),
								ClassGenerator.this);
					}

				};

				advancedEngine.addMatchUpdateListener(operationMatcher,
						operationListener, false);

			}

			{ // set methodListener
				methodListener = new IMatchUpdateListener<MethodMatch>() {

					@Override
					public void notifyAppearance(MethodMatch match) {
						changeRegistry.newModification(match.getCls(),
								ClassGenerator.this);
					}

					@Override
					public void notifyDisappearance(MethodMatch match) {
						changeRegistry.newModification(match.getCls(),
								ClassGenerator.this);
					}

				};

				advancedEngine.addMatchUpdateListener(methodMatcher,
						methodListener, false);
			}

			{ // set receptionListener
				receptionListener = new IMatchUpdateListener<ReceptionMatch>() {

					@Override
					public void notifyAppearance(ReceptionMatch match) {
						changeRegistry.newModification(match.getCls(),
								ClassGenerator.this);
					}

					@Override
					public void notifyDisappearance(ReceptionMatch match) {
						changeRegistry.newModification(match.getCls(),
								ClassGenerator.this);
					}

				};

				advancedEngine.addMatchUpdateListener(receptionMatcher,
						receptionListener, false);
			}

			@Override
			public boolean revert() {

				advancedEngine.removeMatchUpdateListener(clsMatcher,
						clsListener);
				advancedEngine.removeMatchUpdateListener(regionOfClassMatcher,
						regionOfClassListener);
				advancedEngine.removeMatchUpdateListener(operationMatcher,
						operationListener);
				advancedEngine.removeMatchUpdateListener(methodMatcher,
						methodListener);
				advancedEngine.removeMatchUpdateListener(receptionMatcher,
						receptionListener);

				return true;
			}

		};

	}
}
