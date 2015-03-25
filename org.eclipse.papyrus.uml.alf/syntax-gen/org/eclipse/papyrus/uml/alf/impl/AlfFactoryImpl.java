/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.uml.alf.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlfFactoryImpl extends EFactoryImpl implements AlfFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AlfFactory init() {
		try {
			AlfFactory theAlfFactory = (AlfFactory)EPackage.Registry.INSTANCE.getEFactory(AlfPackage.eNS_URI);
			if (theAlfFactory != null) {
				return theAlfFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AlfFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlfFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AlfPackage.ASSIGNED_SOURCE: return (EObject)createAssignedSource();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE: return (EObject)createInternalElementReference();
			case AlfPackage.EXTERNAL_ELEMENT_REFERENCE: return (EObject)createExternalElementReference();
			case AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE: return (EObject)createExternalEnumerationLiteralReference();
			case AlfPackage.BOUND_ELEMENT_REFERENCE: return (EObject)createBoundElementReference();
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION: return (EObject)createSequenceExpansionExpression();
			case AlfPackage.ASSIGNABLE_ELEMENT_REFERENCE: return (EObject)createAssignableElementReference();
			case AlfPackage.EXTENT_OR_EXPRESSION: return (EObject)createExtentOrExpression();
			case AlfPackage.QUALIFIED_NAME: return (EObject)createQualifiedName();
			case AlfPackage.FEATURE_REFERENCE: return (EObject)createFeatureReference();
			case AlfPackage.NAME_BINDING: return (EObject)createNameBinding();
			case AlfPackage.NAMED_TEMPLATE_BINDING: return (EObject)createNamedTemplateBinding();
			case AlfPackage.TEMPLATE_PARAMETER_SUBSTITUTION: return (EObject)createTemplateParameterSubstitution();
			case AlfPackage.NUMERIC_UNARY_EXPRESSION: return (EObject)createNumericUnaryExpression();
			case AlfPackage.FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION: return (EObject)createForAllOrExistsOrOneExpression();
			case AlfPackage.ISOLATION_EXPRESSION: return (EObject)createIsolationExpression();
			case AlfPackage.BOOLEAN_UNARY_EXPRESSION: return (EObject)createBooleanUnaryExpression();
			case AlfPackage.CAST_EXPRESSION: return (EObject)createCastExpression();
			case AlfPackage.POSITIONAL_TUPLE: return (EObject)createPositionalTuple();
			case AlfPackage.NAMED_EXPRESSION: return (EObject)createNamedExpression();
			case AlfPackage.INPUT_NAMED_EXPRESSION: return (EObject)createInputNamedExpression();
			case AlfPackage.OUTPUT_NAMED_EXPRESSION: return (EObject)createOutputNamedExpression();
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION: return (EObject)createSequenceAccessExpression();
			case AlfPackage.STRING_LITERAL_EXPRESSION: return (EObject)createStringLiteralExpression();
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION: return (EObject)createSequenceOperationExpression();
			case AlfPackage.SELECT_OR_REJECT_EXPRESSION: return (EObject)createSelectOrRejectExpression();
			case AlfPackage.CLASS_EXTENT_EXPRESSION: return (EObject)createClassExtentExpression();
			case AlfPackage.POSITIONAL_TEMPLATE_BINDING: return (EObject)createPositionalTemplateBinding();
			case AlfPackage.CONDITIONAL_LOGICAL_EXPRESSION: return (EObject)createConditionalLogicalExpression();
			case AlfPackage.LINK_OPERATION_EXPRESSION: return (EObject)createLinkOperationExpression();
			case AlfPackage.EQUALITY_EXPRESSION: return (EObject)createEqualityExpression();
			case AlfPackage.ASSIGNMENT_EXPRESSION: return (EObject)createAssignmentExpression();
			case AlfPackage.LOGICAL_EXPRESSION: return (EObject)createLogicalExpression();
			case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION: return (EObject)createSequenceConstructionExpression();
			case AlfPackage.COLLECT_OR_ITERATE_EXPRESSION: return (EObject)createCollectOrIterateExpression();
			case AlfPackage.IS_UNIQUE_EXPRESSION: return (EObject)createIsUniqueExpression();
			case AlfPackage.ARITHMETIC_EXPRESSION: return (EObject)createArithmeticExpression();
			case AlfPackage.FEATURE_LEFT_HAND_SIDE: return (EObject)createFeatureLeftHandSide();
			case AlfPackage.CONDITIONAL_TEST_EXPRESSION: return (EObject)createConditionalTestExpression();
			case AlfPackage.INSTANCE_CREATION_EXPRESSION: return (EObject)createInstanceCreationExpression();
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION: return (EObject)createPropertyAccessExpression();
			case AlfPackage.NAME_EXPRESSION: return (EObject)createNameExpression();
			case AlfPackage.BIT_STRING_UNARY_EXPRESSION: return (EObject)createBitStringUnaryExpression();
			case AlfPackage.FEATURE_INVOCATION_EXPRESSION: return (EObject)createFeatureInvocationExpression();
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION: return (EObject)createBehaviorInvocationExpression();
			case AlfPackage.SHIFT_EXPRESSION: return (EObject)createShiftExpression();
			case AlfPackage.UNBOUNDED_LITERAL_EXPRESSION: return (EObject)createUnboundedLiteralExpression();
			case AlfPackage.THIS_EXPRESSION: return (EObject)createThisExpression();
			case AlfPackage.CLASSIFICATION_EXPRESSION: return (EObject)createClassificationExpression();
			case AlfPackage.SUPER_INVOCATION_EXPRESSION: return (EObject)createSuperInvocationExpression();
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION: return (EObject)createIncrementOrDecrementExpression();
			case AlfPackage.BOOLEAN_LITERAL_EXPRESSION: return (EObject)createBooleanLiteralExpression();
			case AlfPackage.NAMED_TUPLE: return (EObject)createNamedTuple();
			case AlfPackage.NATURAL_LITERAL_EXPRESSION: return (EObject)createNaturalLiteralExpression();
			case AlfPackage.SEQUENCE_RANGE: return (EObject)createSequenceRange();
			case AlfPackage.NAME_LEFT_HAND_SIDE: return (EObject)createNameLeftHandSide();
			case AlfPackage.EFFECTIVE_LEFT_HAND_SIDE: return (EObject)createEffectiveLeftHandSide();
			case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION: return (EObject)createSequenceReductionExpression();
			case AlfPackage.SEQUENCE_EXPRESSION_LIST: return (EObject)createSequenceExpressionList();
			case AlfPackage.RELATIONAL_EXPRESSION: return (EObject)createRelationalExpression();
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT: return (EObject)createLocalNameDeclarationStatement();
			case AlfPackage.ASSIGNABLE_LOCAL_NAME_DECLARATION: return (EObject)createAssignableLocalNameDeclaration();
			case AlfPackage.ANNOTATION: return (EObject)createAnnotation();
			case AlfPackage.QUALIFIED_NAME_LIST: return (EObject)createQualifiedNameList();
			case AlfPackage.NON_FINAL_CLAUSE: return (EObject)createNonFinalClause();
			case AlfPackage.BLOCK: return (EObject)createBlock();
			case AlfPackage.BLOCK_STATEMENT: return (EObject)createBlockStatement();
			case AlfPackage.DO_STATEMENT: return (EObject)createDoStatement();
			case AlfPackage.CONCURRENT_CLAUSES: return (EObject)createConcurrentClauses();
			case AlfPackage.BREAK_STATEMENT: return (EObject)createBreakStatement();
			case AlfPackage.EXPRESSION_STATEMENT: return (EObject)createExpressionStatement();
			case AlfPackage.CLASSIFY_STATEMENT: return (EObject)createClassifyStatement();
			case AlfPackage.FOR_STATEMENT: return (EObject)createForStatement();
			case AlfPackage.LOOP_VARIABLE_DEFINITION: return (EObject)createLoopVariableDefinition();
			case AlfPackage.IF_STATEMENT: return (EObject)createIfStatement();
			case AlfPackage.SWITCH_STATEMENT: return (EObject)createSwitchStatement();
			case AlfPackage.SWITCH_CLAUSE: return (EObject)createSwitchClause();
			case AlfPackage.WHILE_STATEMENT: return (EObject)createWhileStatement();
			case AlfPackage.RETURN_STATEMENT: return (EObject)createReturnStatement();
			case AlfPackage.IN_LINE_STATEMENT: return (EObject)createInLineStatement();
			case AlfPackage.ACCEPT_STATEMENT: return (EObject)createAcceptStatement();
			case AlfPackage.ACCEPT_BLOCK: return (EObject)createAcceptBlock();
			case AlfPackage.EMPTY_STATEMENT: return (EObject)createEmptyStatement();
			case AlfPackage.MODEL_NAMESPACE: return (EObject)createModelNamespace();
			case AlfPackage.NAMESPACE_DEFINITION: return (EObject)createNamespaceDefinition();
			case AlfPackage.STEREOTYPE_ANNOTATION: return (EObject)createStereotypeAnnotation();
			case AlfPackage.TAGGED_VALUE_LIST: return (EObject)createTaggedValueList();
			case AlfPackage.TAGGED_VALUE: return (EObject)createTaggedValue();
			case AlfPackage.UNIT_DEFINITION: return (EObject)createUnitDefinition();
			case AlfPackage.IMPORTED_MEMBER: return (EObject)createImportedMember();
			case AlfPackage.ENUMERATION_LITERAL_NAME: return (EObject)createEnumerationLiteralName();
			case AlfPackage.OPERATION_DEFINITION: return (EObject)createOperationDefinition();
			case AlfPackage.ASSOCIATION_DEFINITION: return (EObject)createAssociationDefinition();
			case AlfPackage.CLASS_DEFINITION: return (EObject)createClassDefinition();
			case AlfPackage.TYPED_ELEMENT_DEFINITION: return (EObject)createTypedElementDefinition();
			case AlfPackage.DATA_TYPE_DEFINITION: return (EObject)createDataTypeDefinition();
			case AlfPackage.PACKAGE_DEFINITION: return (EObject)createPackageDefinition();
			case AlfPackage.PROPERTY_DEFINITION: return (EObject)createPropertyDefinition();
			case AlfPackage.SIGNAL_DEFINITION: return (EObject)createSignalDefinition();
			case AlfPackage.ACTIVE_CLASS_DEFINITION: return (EObject)createActiveClassDefinition();
			case AlfPackage.ACTIVITY_DEFINITION: return (EObject)createActivityDefinition();
			case AlfPackage.ELEMENT_IMPORT_REFERENCE: return (EObject)createElementImportReference();
			case AlfPackage.SIGNAL_RECEPTION_DEFINITION: return (EObject)createSignalReceptionDefinition();
			case AlfPackage.ENUMERATION_DEFINITION: return (EObject)createEnumerationDefinition();
			case AlfPackage.PACKAGE_IMPORT_REFERENCE: return (EObject)createPackageImportReference();
			case AlfPackage.CLASSIFIER_TEMPLATE_PARAMETER: return (EObject)createClassifierTemplateParameter();
			case AlfPackage.FORMAL_PARAMETER: return (EObject)createFormalParameter();
			case AlfPackage.RECEPTION_DEFINITION: return (EObject)createReceptionDefinition();
			case AlfPackage.MEMBER: return (EObject)createMember();
			case AlfPackage.ANNOTATED_STATEMENT: return (EObject)createAnnotatedStatement();
			case AlfPackage.BOUND_CLASSIFIER: return (EObject)createBoundClassifier();
			case AlfPackage.RETURN_PARAMETER: return (EObject)createReturnParameter();
			case AlfPackage.NON_RETURN_PARAMETER: return (EObject)createNonReturnParameter();
			case AlfPackage.ANY_TYPE: return (EObject)createAnyType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignedSource createAssignedSource() {
		AssignedSourceImpl assignedSource = new AssignedSourceImpl();
		return assignedSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalElementReference createInternalElementReference() {
		InternalElementReferenceImpl internalElementReference = new InternalElementReferenceImpl();
		return internalElementReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalElementReference createExternalElementReference() {
		ExternalElementReferenceImpl externalElementReference = new ExternalElementReferenceImpl();
		return externalElementReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalEnumerationLiteralReference createExternalEnumerationLiteralReference() {
		ExternalEnumerationLiteralReferenceImpl externalEnumerationLiteralReference = new ExternalEnumerationLiteralReferenceImpl();
		return externalEnumerationLiteralReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundElementReference createBoundElementReference() {
		BoundElementReferenceImpl boundElementReference = new BoundElementReferenceImpl();
		return boundElementReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceExpansionExpression createSequenceExpansionExpression() {
		SequenceExpansionExpressionImpl sequenceExpansionExpression = new SequenceExpansionExpressionImpl();
		return sequenceExpansionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignableElementReference createAssignableElementReference() {
		AssignableElementReferenceImpl assignableElementReference = new AssignableElementReferenceImpl();
		return assignableElementReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtentOrExpression createExtentOrExpression() {
		ExtentOrExpressionImpl extentOrExpression = new ExtentOrExpressionImpl();
		return extentOrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName createQualifiedName() {
		QualifiedNameImpl qualifiedName = new QualifiedNameImpl();
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureReference createFeatureReference() {
		FeatureReferenceImpl featureReference = new FeatureReferenceImpl();
		return featureReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameBinding createNameBinding() {
		NameBindingImpl nameBinding = new NameBindingImpl();
		return nameBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedTemplateBinding createNamedTemplateBinding() {
		NamedTemplateBindingImpl namedTemplateBinding = new NamedTemplateBindingImpl();
		return namedTemplateBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameterSubstitution createTemplateParameterSubstitution() {
		TemplateParameterSubstitutionImpl templateParameterSubstitution = new TemplateParameterSubstitutionImpl();
		return templateParameterSubstitution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericUnaryExpression createNumericUnaryExpression() {
		NumericUnaryExpressionImpl numericUnaryExpression = new NumericUnaryExpressionImpl();
		return numericUnaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForAllOrExistsOrOneExpression createForAllOrExistsOrOneExpression() {
		ForAllOrExistsOrOneExpressionImpl forAllOrExistsOrOneExpression = new ForAllOrExistsOrOneExpressionImpl();
		return forAllOrExistsOrOneExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsolationExpression createIsolationExpression() {
		IsolationExpressionImpl isolationExpression = new IsolationExpressionImpl();
		return isolationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanUnaryExpression createBooleanUnaryExpression() {
		BooleanUnaryExpressionImpl booleanUnaryExpression = new BooleanUnaryExpressionImpl();
		return booleanUnaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CastExpression createCastExpression() {
		CastExpressionImpl castExpression = new CastExpressionImpl();
		return castExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositionalTuple createPositionalTuple() {
		PositionalTupleImpl positionalTuple = new PositionalTupleImpl();
		return positionalTuple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedExpression createNamedExpression() {
		NamedExpressionImpl namedExpression = new NamedExpressionImpl();
		return namedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputNamedExpression createInputNamedExpression() {
		InputNamedExpressionImpl inputNamedExpression = new InputNamedExpressionImpl();
		return inputNamedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputNamedExpression createOutputNamedExpression() {
		OutputNamedExpressionImpl outputNamedExpression = new OutputNamedExpressionImpl();
		return outputNamedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceAccessExpression createSequenceAccessExpression() {
		SequenceAccessExpressionImpl sequenceAccessExpression = new SequenceAccessExpressionImpl();
		return sequenceAccessExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExpression createStringLiteralExpression() {
		StringLiteralExpressionImpl stringLiteralExpression = new StringLiteralExpressionImpl();
		return stringLiteralExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceOperationExpression createSequenceOperationExpression() {
		SequenceOperationExpressionImpl sequenceOperationExpression = new SequenceOperationExpressionImpl();
		return sequenceOperationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectOrRejectExpression createSelectOrRejectExpression() {
		SelectOrRejectExpressionImpl selectOrRejectExpression = new SelectOrRejectExpressionImpl();
		return selectOrRejectExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassExtentExpression createClassExtentExpression() {
		ClassExtentExpressionImpl classExtentExpression = new ClassExtentExpressionImpl();
		return classExtentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositionalTemplateBinding createPositionalTemplateBinding() {
		PositionalTemplateBindingImpl positionalTemplateBinding = new PositionalTemplateBindingImpl();
		return positionalTemplateBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalLogicalExpression createConditionalLogicalExpression() {
		ConditionalLogicalExpressionImpl conditionalLogicalExpression = new ConditionalLogicalExpressionImpl();
		return conditionalLogicalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkOperationExpression createLinkOperationExpression() {
		LinkOperationExpressionImpl linkOperationExpression = new LinkOperationExpressionImpl();
		return linkOperationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityExpression createEqualityExpression() {
		EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
		return equalityExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentExpression createAssignmentExpression() {
		AssignmentExpressionImpl assignmentExpression = new AssignmentExpressionImpl();
		return assignmentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalExpression createLogicalExpression() {
		LogicalExpressionImpl logicalExpression = new LogicalExpressionImpl();
		return logicalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceConstructionExpression createSequenceConstructionExpression() {
		SequenceConstructionExpressionImpl sequenceConstructionExpression = new SequenceConstructionExpressionImpl();
		return sequenceConstructionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectOrIterateExpression createCollectOrIterateExpression() {
		CollectOrIterateExpressionImpl collectOrIterateExpression = new CollectOrIterateExpressionImpl();
		return collectOrIterateExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsUniqueExpression createIsUniqueExpression() {
		IsUniqueExpressionImpl isUniqueExpression = new IsUniqueExpressionImpl();
		return isUniqueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithmeticExpression createArithmeticExpression() {
		ArithmeticExpressionImpl arithmeticExpression = new ArithmeticExpressionImpl();
		return arithmeticExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureLeftHandSide createFeatureLeftHandSide() {
		FeatureLeftHandSideImpl featureLeftHandSide = new FeatureLeftHandSideImpl();
		return featureLeftHandSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalTestExpression createConditionalTestExpression() {
		ConditionalTestExpressionImpl conditionalTestExpression = new ConditionalTestExpressionImpl();
		return conditionalTestExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceCreationExpression createInstanceCreationExpression() {
		InstanceCreationExpressionImpl instanceCreationExpression = new InstanceCreationExpressionImpl();
		return instanceCreationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyAccessExpression createPropertyAccessExpression() {
		PropertyAccessExpressionImpl propertyAccessExpression = new PropertyAccessExpressionImpl();
		return propertyAccessExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpression createNameExpression() {
		NameExpressionImpl nameExpression = new NameExpressionImpl();
		return nameExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BitStringUnaryExpression createBitStringUnaryExpression() {
		BitStringUnaryExpressionImpl bitStringUnaryExpression = new BitStringUnaryExpressionImpl();
		return bitStringUnaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureInvocationExpression createFeatureInvocationExpression() {
		FeatureInvocationExpressionImpl featureInvocationExpression = new FeatureInvocationExpressionImpl();
		return featureInvocationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorInvocationExpression createBehaviorInvocationExpression() {
		BehaviorInvocationExpressionImpl behaviorInvocationExpression = new BehaviorInvocationExpressionImpl();
		return behaviorInvocationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShiftExpression createShiftExpression() {
		ShiftExpressionImpl shiftExpression = new ShiftExpressionImpl();
		return shiftExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnboundedLiteralExpression createUnboundedLiteralExpression() {
		UnboundedLiteralExpressionImpl unboundedLiteralExpression = new UnboundedLiteralExpressionImpl();
		return unboundedLiteralExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisExpression createThisExpression() {
		ThisExpressionImpl thisExpression = new ThisExpressionImpl();
		return thisExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassificationExpression createClassificationExpression() {
		ClassificationExpressionImpl classificationExpression = new ClassificationExpressionImpl();
		return classificationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperInvocationExpression createSuperInvocationExpression() {
		SuperInvocationExpressionImpl superInvocationExpression = new SuperInvocationExpressionImpl();
		return superInvocationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncrementOrDecrementExpression createIncrementOrDecrementExpression() {
		IncrementOrDecrementExpressionImpl incrementOrDecrementExpression = new IncrementOrDecrementExpressionImpl();
		return incrementOrDecrementExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteralExpression createBooleanLiteralExpression() {
		BooleanLiteralExpressionImpl booleanLiteralExpression = new BooleanLiteralExpressionImpl();
		return booleanLiteralExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedTuple createNamedTuple() {
		NamedTupleImpl namedTuple = new NamedTupleImpl();
		return namedTuple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NaturalLiteralExpression createNaturalLiteralExpression() {
		NaturalLiteralExpressionImpl naturalLiteralExpression = new NaturalLiteralExpressionImpl();
		return naturalLiteralExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceRange createSequenceRange() {
		SequenceRangeImpl sequenceRange = new SequenceRangeImpl();
		return sequenceRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameLeftHandSide createNameLeftHandSide() {
		NameLeftHandSideImpl nameLeftHandSide = new NameLeftHandSideImpl();
		return nameLeftHandSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EffectiveLeftHandSide createEffectiveLeftHandSide() {
		EffectiveLeftHandSideImpl effectiveLeftHandSide = new EffectiveLeftHandSideImpl();
		return effectiveLeftHandSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceReductionExpression createSequenceReductionExpression() {
		SequenceReductionExpressionImpl sequenceReductionExpression = new SequenceReductionExpressionImpl();
		return sequenceReductionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceExpressionList createSequenceExpressionList() {
		SequenceExpressionListImpl sequenceExpressionList = new SequenceExpressionListImpl();
		return sequenceExpressionList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalExpression createRelationalExpression() {
		RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
		return relationalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalNameDeclarationStatement createLocalNameDeclarationStatement() {
		LocalNameDeclarationStatementImpl localNameDeclarationStatement = new LocalNameDeclarationStatementImpl();
		return localNameDeclarationStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignableLocalNameDeclaration createAssignableLocalNameDeclaration() {
		AssignableLocalNameDeclarationImpl assignableLocalNameDeclaration = new AssignableLocalNameDeclarationImpl();
		return assignableLocalNameDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedNameList createQualifiedNameList() {
		QualifiedNameListImpl qualifiedNameList = new QualifiedNameListImpl();
		return qualifiedNameList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonFinalClause createNonFinalClause() {
		NonFinalClauseImpl nonFinalClause = new NonFinalClauseImpl();
		return nonFinalClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockStatement createBlockStatement() {
		BlockStatementImpl blockStatement = new BlockStatementImpl();
		return blockStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoStatement createDoStatement() {
		DoStatementImpl doStatement = new DoStatementImpl();
		return doStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcurrentClauses createConcurrentClauses() {
		ConcurrentClausesImpl concurrentClauses = new ConcurrentClausesImpl();
		return concurrentClauses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BreakStatement createBreakStatement() {
		BreakStatementImpl breakStatement = new BreakStatementImpl();
		return breakStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionStatement createExpressionStatement() {
		ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
		return expressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifyStatement createClassifyStatement() {
		ClassifyStatementImpl classifyStatement = new ClassifyStatementImpl();
		return classifyStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForStatement createForStatement() {
		ForStatementImpl forStatement = new ForStatementImpl();
		return forStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopVariableDefinition createLoopVariableDefinition() {
		LoopVariableDefinitionImpl loopVariableDefinition = new LoopVariableDefinitionImpl();
		return loopVariableDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfStatement createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchStatement createSwitchStatement() {
		SwitchStatementImpl switchStatement = new SwitchStatementImpl();
		return switchStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchClause createSwitchClause() {
		SwitchClauseImpl switchClause = new SwitchClauseImpl();
		return switchClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileStatement createWhileStatement() {
		WhileStatementImpl whileStatement = new WhileStatementImpl();
		return whileStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnStatement createReturnStatement() {
		ReturnStatementImpl returnStatement = new ReturnStatementImpl();
		return returnStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InLineStatement createInLineStatement() {
		InLineStatementImpl inLineStatement = new InLineStatementImpl();
		return inLineStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AcceptStatement createAcceptStatement() {
		AcceptStatementImpl acceptStatement = new AcceptStatementImpl();
		return acceptStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AcceptBlock createAcceptBlock() {
		AcceptBlockImpl acceptBlock = new AcceptBlockImpl();
		return acceptBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptyStatement createEmptyStatement() {
		EmptyStatementImpl emptyStatement = new EmptyStatementImpl();
		return emptyStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelNamespace createModelNamespace() {
		ModelNamespaceImpl modelNamespace = new ModelNamespaceImpl();
		return modelNamespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespaceDefinition createNamespaceDefinition() {
		NamespaceDefinitionImpl namespaceDefinition = new NamespaceDefinitionImpl();
		return namespaceDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypeAnnotation createStereotypeAnnotation() {
		StereotypeAnnotationImpl stereotypeAnnotation = new StereotypeAnnotationImpl();
		return stereotypeAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaggedValueList createTaggedValueList() {
		TaggedValueListImpl taggedValueList = new TaggedValueListImpl();
		return taggedValueList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaggedValue createTaggedValue() {
		TaggedValueImpl taggedValue = new TaggedValueImpl();
		return taggedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitDefinition createUnitDefinition() {
		UnitDefinitionImpl unitDefinition = new UnitDefinitionImpl();
		return unitDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportedMember createImportedMember() {
		ImportedMemberImpl importedMember = new ImportedMemberImpl();
		return importedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteralName createEnumerationLiteralName() {
		EnumerationLiteralNameImpl enumerationLiteralName = new EnumerationLiteralNameImpl();
		return enumerationLiteralName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationDefinition createOperationDefinition() {
		OperationDefinitionImpl operationDefinition = new OperationDefinitionImpl();
		return operationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationDefinition createAssociationDefinition() {
		AssociationDefinitionImpl associationDefinition = new AssociationDefinitionImpl();
		return associationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDefinition createClassDefinition() {
		ClassDefinitionImpl classDefinition = new ClassDefinitionImpl();
		return classDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElementDefinition createTypedElementDefinition() {
		TypedElementDefinitionImpl typedElementDefinition = new TypedElementDefinitionImpl();
		return typedElementDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeDefinition createDataTypeDefinition() {
		DataTypeDefinitionImpl dataTypeDefinition = new DataTypeDefinitionImpl();
		return dataTypeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageDefinition createPackageDefinition() {
		PackageDefinitionImpl packageDefinition = new PackageDefinitionImpl();
		return packageDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyDefinition createPropertyDefinition() {
		PropertyDefinitionImpl propertyDefinition = new PropertyDefinitionImpl();
		return propertyDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalDefinition createSignalDefinition() {
		SignalDefinitionImpl signalDefinition = new SignalDefinitionImpl();
		return signalDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActiveClassDefinition createActiveClassDefinition() {
		ActiveClassDefinitionImpl activeClassDefinition = new ActiveClassDefinitionImpl();
		return activeClassDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityDefinition createActivityDefinition() {
		ActivityDefinitionImpl activityDefinition = new ActivityDefinitionImpl();
		return activityDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementImportReference createElementImportReference() {
		ElementImportReferenceImpl elementImportReference = new ElementImportReferenceImpl();
		return elementImportReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalReceptionDefinition createSignalReceptionDefinition() {
		SignalReceptionDefinitionImpl signalReceptionDefinition = new SignalReceptionDefinitionImpl();
		return signalReceptionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationDefinition createEnumerationDefinition() {
		EnumerationDefinitionImpl enumerationDefinition = new EnumerationDefinitionImpl();
		return enumerationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageImportReference createPackageImportReference() {
		PackageImportReferenceImpl packageImportReference = new PackageImportReferenceImpl();
		return packageImportReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierTemplateParameter createClassifierTemplateParameter() {
		ClassifierTemplateParameterImpl classifierTemplateParameter = new ClassifierTemplateParameterImpl();
		return classifierTemplateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalParameter createFormalParameter() {
		FormalParameterImpl formalParameter = new FormalParameterImpl();
		return formalParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReceptionDefinition createReceptionDefinition() {
		ReceptionDefinitionImpl receptionDefinition = new ReceptionDefinitionImpl();
		return receptionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Member createMember() {
		MemberImpl member = new MemberImpl();
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotatedStatement createAnnotatedStatement() {
		AnnotatedStatementImpl annotatedStatement = new AnnotatedStatementImpl();
		return annotatedStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundClassifier createBoundClassifier() {
		BoundClassifierImpl boundClassifier = new BoundClassifierImpl();
		return boundClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnParameter createReturnParameter() {
		ReturnParameterImpl returnParameter = new ReturnParameterImpl();
		return returnParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonReturnParameter createNonReturnParameter() {
		NonReturnParameterImpl nonReturnParameter = new NonReturnParameterImpl();
		return nonReturnParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyType createAnyType() {
		AnyTypeImpl anyType = new AnyTypeImpl();
		return anyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlfPackage getAlfPackage() {
		return (AlfPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AlfPackage getPackage() {
		return AlfPackage.eINSTANCE;
	}

} // AlfFactoryImpl
