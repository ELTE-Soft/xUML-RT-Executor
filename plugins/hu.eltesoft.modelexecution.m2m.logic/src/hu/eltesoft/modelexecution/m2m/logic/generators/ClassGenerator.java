package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.listeners.MatchUpdateListener;
import hu.eltesoft.modelexecution.m2m.logic.listeners.RootMatchUpdateListener;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClParameter;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.ClassTemplate;
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatch;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatch;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatcher;
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
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.xtext.xbase.lib.Pair;

public class ClassGenerator extends AbstractGenerator<Class> {

	private static final ClassdefFactory FACTORY = ClassdefFactory.eINSTANCE;
	private final ClsMatcher clsMatcher;
	private final RegionOfClassMatcher regionOfClassMatcher;
	private final AttributeMatcher attributeMatcher;
	private final OperationMatcher operationMatcher;
	private final OperationParameterMatcher parameterMatcher;
	private final OperationReturnTypeMatcher returnMatcher;
	private final MethodMatcher methodMatcher;
	private final ReceptionMatcher receptionMatcher;

	public ClassGenerator(IncQueryEngine engine) throws IncQueryException {
		clsMatcher = ClsMatcher.on(engine);
		regionOfClassMatcher = RegionOfClassMatcher.on(engine);
		attributeMatcher = AttributeMatcher.on(engine);
		operationMatcher = OperationMatcher.on(engine);
		parameterMatcher = OperationParameterMatcher.on(engine);
		returnMatcher = OperationReturnTypeMatcher.on(engine);
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

		collectAttributes(source, root);

		regionOfClassMatcher.forOneArbitraryMatch(source, null, match -> {
			Region pRegion = match.getRegion();
			root.setRegion(new NamedReference(pRegion));
		});

		collectOperations(source, root);

		collectReceptions(source, root);

		String rootName = NamedReference.getIdentifier(source);
		return new Pair<>(rootName, new ClassTemplate(root));
	}

	protected void collectAttributes(Class source, ClClass root) {
		AttributeMatch filterMatch = AttributeMatch.newMatch(source, null,
				null, null);
		attributeMatcher.forEachMatch(
				filterMatch,
				match -> {
					ClAttribute attribute = FACTORY.createClAttribute();
					Property matchedAttrib = match.getAttribute();
					attribute.setReference(new NamedReference(matchedAttrib));
					attribute.setIsStatic(match.getIsStatic());
					attribute.setType(convertType(match.getType()));
					attribute.setMultiplicity(convertMultiplicity(
							matchedAttrib.getLowerValue(),
							matchedAttrib.getUpperValue()));
					root.getAttributes().add(attribute);
				});
	}

	protected void collectOperations(Class source, ClClass root) {
		operationMatcher.forEachMatch(source, null, null, match -> {
			Operation pOperation = match.getOperation();

			ClOperation clOperation = FACTORY.createClOperation();
			clOperation.setReference(new NamedReference(pOperation));
			clOperation.setIsStatic(match.getIsStatic());

			// Method attribute is optional: if there is no
			// match, the
			// method was missing from the source model as well.
				methodMatcher.forOneArbitraryMatch(null, pOperation, null,
						match2 -> {
							Behavior pMethod = match2.getMethod();
							clOperation.setMethod(new NamedReference(pMethod));
						});

				returnMatcher.forOneArbitraryMatch(null, pOperation, null,
						match2 -> {
							clOperation.setReturnType(convertType(match2
									.getType()));
						});

				collectParameters(pOperation, clOperation);

				root.getOperations().add(clOperation);
			});
	}

	protected void collectParameters(Operation operation,
			ClOperation clOperation) {
		parameterMatcher.forEachMatch(null, operation, null, null, null,
				paramMatch -> {
					ClParameter parameter = FACTORY.createClParameter();
					parameter.setReference(new NamedReference(paramMatch
							.getParameter()));
					parameter.setType(convertType(paramMatch.getType()));
					parameter.setDirection(convertDirection(paramMatch
							.getDirection()));
					clOperation.getParameters().add(parameter);
				});
	}

	protected void collectReceptions(Class source, ClClass root) {
		receptionMatcher.forEachMatch(source, null, null, match -> {
			Reception pReception = match.getReception();
			Signal pSignal = match.getSignal();

			ClReception clReception = FACTORY.createClReception();
			clReception.setReference(new NamedReference(pReception));
			clReception.setSignal(new NamedReference(pSignal));

			root.getReceptions().add(clReception);
		});
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
