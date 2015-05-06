package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
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
		check(regionOfClassMatcher.forOneArbitraryMatch(source, null,
				getProcessorToSetRegionOfRoot(root)));

		// operations
		operationMatcher.forEachMatch(source, null, null,
				getProcessorToSetOperationsOfRoot(root.getOperations()));

		// receptions
		receptionMatcher.forEachMatch(source, null, null,
				getProcessorToSetReceptionsOfRoot(root.getReceptions()));

		return root;
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

	// generate text

	@Override
	public void generateText(ClClass root) {
		ClassTemplate template = new ClassTemplate(root);

		SourceMappedText output = template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		listener.contentChanged(root.getName(), output, symbols);
	}

	// add match update listener

	@Override
	public void addMatchUpdateListeners(AdvancedIncQueryEngine advancedEngine,
			ChangeRegistry changeRegistry) {

		advancedEngine.addMatchUpdateListener(clsMatcher,
				new IMatchUpdateListener<ClsMatch>() {

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

				}, false);

		advancedEngine.addMatchUpdateListener(regionOfClassMatcher,
				new IMatchUpdateListener<RegionOfClassMatch>() {

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

				}, false);

		advancedEngine.addMatchUpdateListener(operationMatcher,
				new IMatchUpdateListener<OperationMatch>() {

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

				}, false);

		advancedEngine.addMatchUpdateListener(methodMatcher,
				new IMatchUpdateListener<MethodMatch>() {

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

				}, false);

		advancedEngine.addMatchUpdateListener(receptionMatcher,
				new IMatchUpdateListener<ReceptionMatch>() {

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

				}, false);

	}

}
