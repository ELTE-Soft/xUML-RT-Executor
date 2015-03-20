package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClRegion;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.templates.ClassTemplate;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.ClsProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.MethodProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.RegionOfClassProcessor;

import org.eclipse.emf.common.util.EList;
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

	public ClassGenerator(IncQueryEngine engine, TextChangesListener listener) throws IncQueryException {
		super(listener);
		clsMatcher = ClsMatcher.on(engine);
		regionOfClassMatcher = RegionOfClassMatcher.on(engine);
		operationMatcher = OperationMatcher.on(engine);
		methodMatcher = MethodMatcher.on(engine);
		receptionMatcher = ReceptionMatcher.on(engine);
	}

	@Override
	public ClClass generateTranslationModel(Class source) {
		// new ClClass
		ClClass root = FACTORY.createClClass();

		// name
		clsMatcher.forOneArbitraryMatch(source, null, getProcessorToSetNameOfRoot(root));

		// region
		regionOfClassMatcher.forOneArbitraryMatch(source, null, getProcessorToSetRegionOfRoot(root));

		// operations
		operationMatcher.forEachMatch(source, null, null, getProcessorToSetOperationsOfRoot(root.getOperations()));

		// receptions
		receptionMatcher.forEachMatch(source, null, null, getProcessorToSetReceptionsOfRoot(root.getReceptions()));

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

	private OperationProcessor getProcessorToSetOperationsOfRoot(EList<ClOperation> operationsOfRoot) {
		return new OperationProcessor() {

			@Override
			public void process(Class pCls, Operation pOperation, String pOperationName) {
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

			private MethodProcessor getProcessorToSetMethodOfOperation(ClOperation clOperation) {
				return new MethodProcessor() {
					@Override
					public void process(Class pCls, Operation pOperation, String pMethodName) {
						clOperation.setName(pMethodName);
					}
				};
			}

		};
	}

	private ReceptionProcessor getProcessorToSetReceptionsOfRoot(EList<ClReception> receptionsOfRoot) {
		return new ReceptionProcessor() {

			@Override
			public void process(Class pCls, String pReceptionName, String pSignalName) {
				// new ClReception
				ClReception clReception = FACTORY.createClReception();

				// name
				clReception.setName(pReceptionName);

				// signal
				clReception.setSignal(createClSignal(pSignalName));

				receptionsOfRoot.add(clReception);
			}

			private ClSignal createClSignal(String name) {
				// new ClSignal
				ClSignal clSignal = FACTORY.createClSignal();

				// name
				clSignal.setName(name);

				return clSignal;
			}

		};
	}

	@Override
	public void generateText(ClClass root) {
		ClassTemplate template = new ClassTemplate(root);

		SourceMappedText output = (SourceMappedText) template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		listener.contentChanged(root.getName(), output, symbols);
	}

	@Override
	public ClClass generateModelRoot(Class source) {
		// TODO Auto-generated method stub
		return null;
	}

}
