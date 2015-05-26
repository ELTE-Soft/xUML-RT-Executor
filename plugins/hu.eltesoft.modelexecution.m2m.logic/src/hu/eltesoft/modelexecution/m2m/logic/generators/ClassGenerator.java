package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory;
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

public class ClassGenerator extends
		AbstractGenerator<Class, ClClass, ClassTemplate> {

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

	@Override
	public ClClass generateTranslationModel(Class source)
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

		return root;
	}

	@Override
	protected ClassTemplate createTemplate(ClClass root) {
		return new ClassTemplate(root);
	};

	@Override
	public ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry) {

		return new ReversionTask() {

			private final IMatchUpdateListener<ClsMatch> clsListener;
			private final IMatchUpdateListener<RegionOfClassMatch> regionOfClassListener;
			private final IMatchUpdateListener<OperationMatch> operationListener;
			private final IMatchUpdateListener<MethodMatch> methodListener;
			private final IMatchUpdateListener<ReceptionMatch> receptionListener;

			{
				clsListener = new IMatchUpdateListener<ClsMatch>() {

					@Override
					public void notifyAppearance(ClsMatch match) {
						changeRegistry.newModification(match.getCls(),
								ClassGenerator.this);
					}

					@Override
					public void notifyDisappearance(ClsMatch match) {
						// disappearance of root: delete file
						Class c = match.getCls();
						String fileName = NamedReference.getIdentifier(c);
						changeRegistry.newDeletion(fileName);
					}
				};

				advancedEngine.addMatchUpdateListener(clsMatcher, clsListener,
						false);
			}

			{
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

			{
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

			{
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

			{
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
