package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClMethod;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClRegion;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.templates.ClassTemplate;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;
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

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;

public class ClassGenerator extends AbstractGenerator<Class, ClClass> {

	private static final ClassdefFactory FACTORY = ClassdefFactory.eINSTANCE;

	private final ClsMatcher clsMatcher;
	private final RegionOfClassMatcher regionOfClassMatcher;
	private final OperationMatcher operationMatcher;
	private final MethodMatcher methodMatcher;
	private final ReceptionMatcher receptionMatcher;

	public ClassGenerator(IncQueryEngine engine, TextChangesListener listener)
			throws IncQueryException {
		super(listener);
		clsMatcher = ClsMatcher.on(engine);
		regionOfClassMatcher = RegionOfClassMatcher.on(engine);
		operationMatcher = OperationMatcher.on(engine);
		methodMatcher = MethodMatcher.on(engine);
		receptionMatcher = ReceptionMatcher.on(engine);
	}

	// generate translation model

	@Override
	public ClClass generateTranslationModel(Class source)
			throws GenerationException {
		// new ClClass
		ClClass root = FACTORY.createClClass();

		// name
		check(clsMatcher.forOneArbitraryMatch(source, null,
				getProcessorToSetNameOfRoot(root)));

		// region
		regionOfClassMatcher.forOneArbitraryMatch(source, null, null,
				getProcessorToSetRegionOfRoot(root));

		// operations
		operationMatcher.forEachMatch(source, null, null,
				getProcessorToSetOperationsOfRoot(root.getOperations()));

		// receptions
		receptionMatcher.forEachMatch(source, null, null, null, null,
				getProcessorToSetReceptionsOfRoot(root.getReceptions()));

		return root;
	}

	private ClsProcessor getProcessorToSetNameOfRoot(ClClass root) {
		return new ClsProcessor() {

			@Override
			public void process(Class pCls, String pClassName) {
				root.setReference(new NamedReference(pCls, pClassName));
			}

		};
	}

	private RegionOfClassProcessor getProcessorToSetRegionOfRoot(ClClass root) {
		return new RegionOfClassProcessor() {

			@Override
			public void process(Class pCls, Region pRegion, String pRegionName) {
				// new ClRegion
				ClRegion clRegion = FACTORY.createClRegion();

				// name
				clRegion.setReference(new NamedReference(pRegion, pRegionName));

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
				clOperation.setReference(new NamedReference(pOperation,
						pOperationName));

				// method
				methodMatcher.forOneArbitraryMatch(null, pOperation, null,
						null, getProcessorToSetMethodOfOperation(clOperation));
				// Method attribute is optional: if there is no match, the
				// method was missing from the source model as well.

				operationsOfRoot.add(clOperation);
			}

			private MethodProcessor getProcessorToSetMethodOfOperation(
					ClOperation clOperation) {
				return new MethodProcessor() {
					@Override
					public void process(Class pCls, Operation pOperation,
							org.eclipse.uml2.uml.Behavior pMethod,
							String pMethodName) {
						clOperation
								.setMethod(createMethod(pMethod, pMethodName));
					}

					private ClMethod createMethod(
							org.eclipse.uml2.uml.Behavior method, String name) {
						// new ClMethod
						ClMethod clMethod = FACTORY.createClMethod();

						// name
						clMethod.setReference(new NamedReference(method, name));

						return clMethod;
					}
				};
			}

		};
	}

	private ReceptionProcessor getProcessorToSetReceptionsOfRoot(
			EList<ClReception> receptionsOfRoot) {
		return new ReceptionProcessor() {

			@Override
			public void process(Class pCls, Reception pReception,
					String pReceptionName, Signal pSignal, String pSignalName) {
				// new ClReception
				ClReception clReception = FACTORY.createClReception();

				// name
				clReception.setReference(new NamedReference(pReception,
						pReceptionName));

				// signal
				clReception.setSignal(createSignal(pSignal, pSignalName));

				receptionsOfRoot.add(clReception);
			}

			private ClSignal createSignal(Signal signal, String name) {
				// new ClSignal
				ClSignal clSignal = FACTORY.createClSignal();

				// name
				clSignal.setReference(new NamedReference(signal, name));

				return clSignal;
			}

		};
	}

	// generate text

	@Override
	public void generateText(ClClass root) {
		ClassTemplate template = new ClassTemplate(root);

		SourceMappedText output = template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		textChangesListener.contentChanged(root.getReference()
				.getNewIdentifier(), output, symbols);
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
