/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.impl;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReducedAlfLanguageFactoryImpl extends EFactoryImpl implements ReducedAlfLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ReducedAlfLanguageFactory init()
  {
    try
    {
      ReducedAlfLanguageFactory theReducedAlfLanguageFactory = (ReducedAlfLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(ReducedAlfLanguagePackage.eNS_URI);
      if (theReducedAlfLanguageFactory != null)
      {
        return theReducedAlfLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ReducedAlfLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReducedAlfLanguageFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ReducedAlfLanguagePackage.STATEMENTS: return createStatements();
      case ReducedAlfLanguagePackage.EXPRESSION: return createExpression();
      case ReducedAlfLanguagePackage.LITERAL_EXPRESSION: return createLiteralExpression();
      case ReducedAlfLanguagePackage.BOOLEAN_LITERAL_EXPRESSION: return createBooleanLiteralExpression();
      case ReducedAlfLanguagePackage.NATURAL_LITERAL_EXPRESSION: return createNaturalLiteralExpression();
      case ReducedAlfLanguagePackage.REAL_LITERAL_EXPRESSION: return createRealLiteralExpression();
      case ReducedAlfLanguagePackage.UNBOUNDED_LITERAL_EXPRESSION: return createUnboundedLiteralExpression();
      case ReducedAlfLanguagePackage.STRING_LITERAL_EXPRESSION: return createStringLiteralExpression();
      case ReducedAlfLanguagePackage.NAME_EXPRESSION: return createNameExpression();
      case ReducedAlfLanguagePackage.PROPERTY_ACCESS_EXPRESSION: return createPropertyAccessExpression();
      case ReducedAlfLanguagePackage.TUPLE: return createTuple();
      case ReducedAlfLanguagePackage.EXPRESSION_LIST: return createExpressionList();
      case ReducedAlfLanguagePackage.NAMED_TUPLE: return createNamedTuple();
      case ReducedAlfLanguagePackage.NAMED_EXPRESSION: return createNamedExpression();
      case ReducedAlfLanguagePackage.SUPER_INVOCATION_EXPRESSION: return createSuperInvocationExpression();
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION: return createLinkOperationExpression();
      case ReducedAlfLanguagePackage.CLASS_EXTENT_EXPRESSION: return createClassExtentExpression();
      case ReducedAlfLanguagePackage.NULL_EXPRESSION: return createNullExpression();
      case ReducedAlfLanguagePackage.COLLECTION_LITERAL_EXPRESSION: return createCollectionLiteralExpression();
      case ReducedAlfLanguagePackage.TYPE_DECLARATION: return createTypeDeclaration();
      case ReducedAlfLanguagePackage.BOOLEAN_UNARY_EXPRESSION: return createBooleanUnaryExpression();
      case ReducedAlfLanguagePackage.BIT_STRING_UNARY_EXPRESSION: return createBitStringUnaryExpression();
      case ReducedAlfLanguagePackage.NUMERIC_UNARY_EXPRESSION: return createNumericUnaryExpression();
      case ReducedAlfLanguagePackage.ISOLATION_EXPRESSION: return createIsolationExpression();
      case ReducedAlfLanguagePackage.CAST_EXPRESSION: return createCastExpression();
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION: return createAssignmentExpression();
      case ReducedAlfLanguagePackage.LEFT_HAND_SIDE: return createLeftHandSide();
      case ReducedAlfLanguagePackage.NAME_LEFT_HAND_SIDE: return createNameLeftHandSide();
      case ReducedAlfLanguagePackage.FEATURE_LEFT_HAND_SIDE: return createFeatureLeftHandSide();
      case ReducedAlfLanguagePackage.STATEMENT: return createStatement();
      case ReducedAlfLanguagePackage.SIMPLE_STATEMENT: return createSimpleStatement();
      case ReducedAlfLanguagePackage.BLOCK: return createBlock();
      case ReducedAlfLanguagePackage.BLOCK_STATEMENT: return createBlockStatement();
      case ReducedAlfLanguagePackage.EMPTY_STATEMENT: return createEmptyStatement();
      case ReducedAlfLanguagePackage.LOCAL_NAME_DECLARATION_STATEMENT: return createLocalNameDeclarationStatement();
      case ReducedAlfLanguagePackage.INSTANCE_CREATION_EXPRESSION: return createInstanceCreationExpression();
      case ReducedAlfLanguagePackage.EXPRESSION_STATEMENT: return createExpressionStatement();
      case ReducedAlfLanguagePackage.IF_STATEMENT: return createIfStatement();
      case ReducedAlfLanguagePackage.CONCURRENT_CLAUSES: return createConcurrentClauses();
      case ReducedAlfLanguagePackage.NON_FINAL_CLAUSE: return createNonFinalClause();
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT: return createSwitchStatement();
      case ReducedAlfLanguagePackage.SWITCH_CLAUSE: return createSwitchClause();
      case ReducedAlfLanguagePackage.WHILE_STATEMENT: return createWhileStatement();
      case ReducedAlfLanguagePackage.DO_STATEMENT: return createDoStatement();
      case ReducedAlfLanguagePackage.FOR_STATEMENT: return createForStatement();
      case ReducedAlfLanguagePackage.FOR_EACH_STATEMENT: return createForEachStatement();
      case ReducedAlfLanguagePackage.VARIABLE: return createVariable();
      case ReducedAlfLanguagePackage.BREAK_STATEMENT: return createBreakStatement();
      case ReducedAlfLanguagePackage.RETURN_STATEMENT: return createReturnStatement();
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT: return createClassifyStatement();
      case ReducedAlfLanguagePackage.QUALIFIED_NAME_LIST: return createQualifiedNameList();
      case ReducedAlfLanguagePackage.SEND_SIGNAL_STATEMENT: return createSendSignalStatement();
      case ReducedAlfLanguagePackage.FEATURE_INVOCATION_EXPRESSION: return createFeatureInvocationExpression();
      case ReducedAlfLanguagePackage.ASSOCIATION_ACCESS_EXPRESSION: return createAssociationAccessExpression();
      case ReducedAlfLanguagePackage.SEQUENCE_ACCESS_EXPRESSION: return createSequenceAccessExpression();
      case ReducedAlfLanguagePackage.THIS_EXPRESSION: return createThisExpression();
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION: return createElementCollectionExpression();
      case ReducedAlfLanguagePackage.PREFIX_EXPRESSION: return createPrefixExpression();
      case ReducedAlfLanguagePackage.POSTFIX_EXPRESSION: return createPostfixExpression();
      case ReducedAlfLanguagePackage.ARITHMETIC_EXPRESSION: return createArithmeticExpression();
      case ReducedAlfLanguagePackage.SHIFT_EXPRESSION: return createShiftExpression();
      case ReducedAlfLanguagePackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION: return createClassificationExpression();
      case ReducedAlfLanguagePackage.EQUALITY_EXPRESSION: return createEqualityExpression();
      case ReducedAlfLanguagePackage.LOGICAL_EXPRESSION: return createLogicalExpression();
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION: return createConditionalLogicalExpression();
      case ReducedAlfLanguagePackage.CONDITIONAL_TEST_EXPRESSION: return createConditionalTestExpression();
      case ReducedAlfLanguagePackage.LOOP_VARIABLE: return createLoopVariable();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ReducedAlfLanguagePackage.LINK_OPERATION:
        return createLinkOperationFromString(eDataType, initialValue);
      case ReducedAlfLanguagePackage.COLLECTION_TYPE:
        return createCollectionTypeFromString(eDataType, initialValue);
      case ReducedAlfLanguagePackage.AFFIX_OPERATOR:
        return createAffixOperatorFromString(eDataType, initialValue);
      case ReducedAlfLanguagePackage.NUMERIC_UNARY_OPERATOR:
        return createNumericUnaryOperatorFromString(eDataType, initialValue);
      case ReducedAlfLanguagePackage.SHIFT_OPERATOR:
        return createShiftOperatorFromString(eDataType, initialValue);
      case ReducedAlfLanguagePackage.RELATIONAL_OPERATOR:
        return createRelationalOperatorFromString(eDataType, initialValue);
      case ReducedAlfLanguagePackage.CLASSIFICATION_OPERATOR:
        return createClassificationOperatorFromString(eDataType, initialValue);
      case ReducedAlfLanguagePackage.EQUALITY_OPERATOR:
        return createEqualityOperatorFromString(eDataType, initialValue);
      case ReducedAlfLanguagePackage.ASSIGNMENT_OPERATOR:
        return createAssignmentOperatorFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ReducedAlfLanguagePackage.LINK_OPERATION:
        return convertLinkOperationToString(eDataType, instanceValue);
      case ReducedAlfLanguagePackage.COLLECTION_TYPE:
        return convertCollectionTypeToString(eDataType, instanceValue);
      case ReducedAlfLanguagePackage.AFFIX_OPERATOR:
        return convertAffixOperatorToString(eDataType, instanceValue);
      case ReducedAlfLanguagePackage.NUMERIC_UNARY_OPERATOR:
        return convertNumericUnaryOperatorToString(eDataType, instanceValue);
      case ReducedAlfLanguagePackage.SHIFT_OPERATOR:
        return convertShiftOperatorToString(eDataType, instanceValue);
      case ReducedAlfLanguagePackage.RELATIONAL_OPERATOR:
        return convertRelationalOperatorToString(eDataType, instanceValue);
      case ReducedAlfLanguagePackage.CLASSIFICATION_OPERATOR:
        return convertClassificationOperatorToString(eDataType, instanceValue);
      case ReducedAlfLanguagePackage.EQUALITY_OPERATOR:
        return convertEqualityOperatorToString(eDataType, instanceValue);
      case ReducedAlfLanguagePackage.ASSIGNMENT_OPERATOR:
        return convertAssignmentOperatorToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statements createStatements()
  {
    StatementsImpl statements = new StatementsImpl();
    return statements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteralExpression createLiteralExpression()
  {
    LiteralExpressionImpl literalExpression = new LiteralExpressionImpl();
    return literalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteralExpression createBooleanLiteralExpression()
  {
    BooleanLiteralExpressionImpl booleanLiteralExpression = new BooleanLiteralExpressionImpl();
    return booleanLiteralExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NaturalLiteralExpression createNaturalLiteralExpression()
  {
    NaturalLiteralExpressionImpl naturalLiteralExpression = new NaturalLiteralExpressionImpl();
    return naturalLiteralExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RealLiteralExpression createRealLiteralExpression()
  {
    RealLiteralExpressionImpl realLiteralExpression = new RealLiteralExpressionImpl();
    return realLiteralExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnboundedLiteralExpression createUnboundedLiteralExpression()
  {
    UnboundedLiteralExpressionImpl unboundedLiteralExpression = new UnboundedLiteralExpressionImpl();
    return unboundedLiteralExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteralExpression createStringLiteralExpression()
  {
    StringLiteralExpressionImpl stringLiteralExpression = new StringLiteralExpressionImpl();
    return stringLiteralExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameExpression createNameExpression()
  {
    NameExpressionImpl nameExpression = new NameExpressionImpl();
    return nameExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyAccessExpression createPropertyAccessExpression()
  {
    PropertyAccessExpressionImpl propertyAccessExpression = new PropertyAccessExpressionImpl();
    return propertyAccessExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tuple createTuple()
  {
    TupleImpl tuple = new TupleImpl();
    return tuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionList createExpressionList()
  {
    ExpressionListImpl expressionList = new ExpressionListImpl();
    return expressionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedTuple createNamedTuple()
  {
    NamedTupleImpl namedTuple = new NamedTupleImpl();
    return namedTuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedExpression createNamedExpression()
  {
    NamedExpressionImpl namedExpression = new NamedExpressionImpl();
    return namedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuperInvocationExpression createSuperInvocationExpression()
  {
    SuperInvocationExpressionImpl superInvocationExpression = new SuperInvocationExpressionImpl();
    return superInvocationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperationExpression createLinkOperationExpression()
  {
    LinkOperationExpressionImpl linkOperationExpression = new LinkOperationExpressionImpl();
    return linkOperationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassExtentExpression createClassExtentExpression()
  {
    ClassExtentExpressionImpl classExtentExpression = new ClassExtentExpressionImpl();
    return classExtentExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullExpression createNullExpression()
  {
    NullExpressionImpl nullExpression = new NullExpressionImpl();
    return nullExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionLiteralExpression createCollectionLiteralExpression()
  {
    CollectionLiteralExpressionImpl collectionLiteralExpression = new CollectionLiteralExpressionImpl();
    return collectionLiteralExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDeclaration createTypeDeclaration()
  {
    TypeDeclarationImpl typeDeclaration = new TypeDeclarationImpl();
    return typeDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanUnaryExpression createBooleanUnaryExpression()
  {
    BooleanUnaryExpressionImpl booleanUnaryExpression = new BooleanUnaryExpressionImpl();
    return booleanUnaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitStringUnaryExpression createBitStringUnaryExpression()
  {
    BitStringUnaryExpressionImpl bitStringUnaryExpression = new BitStringUnaryExpressionImpl();
    return bitStringUnaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericUnaryExpression createNumericUnaryExpression()
  {
    NumericUnaryExpressionImpl numericUnaryExpression = new NumericUnaryExpressionImpl();
    return numericUnaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IsolationExpression createIsolationExpression()
  {
    IsolationExpressionImpl isolationExpression = new IsolationExpressionImpl();
    return isolationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CastExpression createCastExpression()
  {
    CastExpressionImpl castExpression = new CastExpressionImpl();
    return castExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentExpression createAssignmentExpression()
  {
    AssignmentExpressionImpl assignmentExpression = new AssignmentExpressionImpl();
    return assignmentExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LeftHandSide createLeftHandSide()
  {
    LeftHandSideImpl leftHandSide = new LeftHandSideImpl();
    return leftHandSide;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameLeftHandSide createNameLeftHandSide()
  {
    NameLeftHandSideImpl nameLeftHandSide = new NameLeftHandSideImpl();
    return nameLeftHandSide;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureLeftHandSide createFeatureLeftHandSide()
  {
    FeatureLeftHandSideImpl featureLeftHandSide = new FeatureLeftHandSideImpl();
    return featureLeftHandSide;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleStatement createSimpleStatement()
  {
    SimpleStatementImpl simpleStatement = new SimpleStatementImpl();
    return simpleStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block createBlock()
  {
    BlockImpl block = new BlockImpl();
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockStatement createBlockStatement()
  {
    BlockStatementImpl blockStatement = new BlockStatementImpl();
    return blockStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmptyStatement createEmptyStatement()
  {
    EmptyStatementImpl emptyStatement = new EmptyStatementImpl();
    return emptyStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalNameDeclarationStatement createLocalNameDeclarationStatement()
  {
    LocalNameDeclarationStatementImpl localNameDeclarationStatement = new LocalNameDeclarationStatementImpl();
    return localNameDeclarationStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceCreationExpression createInstanceCreationExpression()
  {
    InstanceCreationExpressionImpl instanceCreationExpression = new InstanceCreationExpressionImpl();
    return instanceCreationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionStatement createExpressionStatement()
  {
    ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
    return expressionStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfStatement createIfStatement()
  {
    IfStatementImpl ifStatement = new IfStatementImpl();
    return ifStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConcurrentClauses createConcurrentClauses()
  {
    ConcurrentClausesImpl concurrentClauses = new ConcurrentClausesImpl();
    return concurrentClauses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonFinalClause createNonFinalClause()
  {
    NonFinalClauseImpl nonFinalClause = new NonFinalClauseImpl();
    return nonFinalClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchStatement createSwitchStatement()
  {
    SwitchStatementImpl switchStatement = new SwitchStatementImpl();
    return switchStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchClause createSwitchClause()
  {
    SwitchClauseImpl switchClause = new SwitchClauseImpl();
    return switchClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhileStatement createWhileStatement()
  {
    WhileStatementImpl whileStatement = new WhileStatementImpl();
    return whileStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoStatement createDoStatement()
  {
    DoStatementImpl doStatement = new DoStatementImpl();
    return doStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForStatement createForStatement()
  {
    ForStatementImpl forStatement = new ForStatementImpl();
    return forStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForEachStatement createForEachStatement()
  {
    ForEachStatementImpl forEachStatement = new ForEachStatementImpl();
    return forEachStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BreakStatement createBreakStatement()
  {
    BreakStatementImpl breakStatement = new BreakStatementImpl();
    return breakStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReturnStatement createReturnStatement()
  {
    ReturnStatementImpl returnStatement = new ReturnStatementImpl();
    return returnStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifyStatement createClassifyStatement()
  {
    ClassifyStatementImpl classifyStatement = new ClassifyStatementImpl();
    return classifyStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameList createQualifiedNameList()
  {
    QualifiedNameListImpl qualifiedNameList = new QualifiedNameListImpl();
    return qualifiedNameList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SendSignalStatement createSendSignalStatement()
  {
    SendSignalStatementImpl sendSignalStatement = new SendSignalStatementImpl();
    return sendSignalStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureInvocationExpression createFeatureInvocationExpression()
  {
    FeatureInvocationExpressionImpl featureInvocationExpression = new FeatureInvocationExpressionImpl();
    return featureInvocationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationAccessExpression createAssociationAccessExpression()
  {
    AssociationAccessExpressionImpl associationAccessExpression = new AssociationAccessExpressionImpl();
    return associationAccessExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceAccessExpression createSequenceAccessExpression()
  {
    SequenceAccessExpressionImpl sequenceAccessExpression = new SequenceAccessExpressionImpl();
    return sequenceAccessExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThisExpression createThisExpression()
  {
    ThisExpressionImpl thisExpression = new ThisExpressionImpl();
    return thisExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementCollectionExpression createElementCollectionExpression()
  {
    ElementCollectionExpressionImpl elementCollectionExpression = new ElementCollectionExpressionImpl();
    return elementCollectionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrefixExpression createPrefixExpression()
  {
    PrefixExpressionImpl prefixExpression = new PrefixExpressionImpl();
    return prefixExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixExpression createPostfixExpression()
  {
    PostfixExpressionImpl postfixExpression = new PostfixExpressionImpl();
    return postfixExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArithmeticExpression createArithmeticExpression()
  {
    ArithmeticExpressionImpl arithmeticExpression = new ArithmeticExpressionImpl();
    return arithmeticExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpression createShiftExpression()
  {
    ShiftExpressionImpl shiftExpression = new ShiftExpressionImpl();
    return shiftExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpression createRelationalExpression()
  {
    RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
    return relationalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationExpression createClassificationExpression()
  {
    ClassificationExpressionImpl classificationExpression = new ClassificationExpressionImpl();
    return classificationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpression createEqualityExpression()
  {
    EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
    return equalityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalExpression createLogicalExpression()
  {
    LogicalExpressionImpl logicalExpression = new LogicalExpressionImpl();
    return logicalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalLogicalExpression createConditionalLogicalExpression()
  {
    ConditionalLogicalExpressionImpl conditionalLogicalExpression = new ConditionalLogicalExpressionImpl();
    return conditionalLogicalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalTestExpression createConditionalTestExpression()
  {
    ConditionalTestExpressionImpl conditionalTestExpression = new ConditionalTestExpressionImpl();
    return conditionalTestExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopVariable createLoopVariable()
  {
    LoopVariableImpl loopVariable = new LoopVariableImpl();
    return loopVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperation createLinkOperationFromString(EDataType eDataType, String initialValue)
  {
    LinkOperation result = LinkOperation.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLinkOperationToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionType createCollectionTypeFromString(EDataType eDataType, String initialValue)
  {
    CollectionType result = CollectionType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCollectionTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AffixOperator createAffixOperatorFromString(EDataType eDataType, String initialValue)
  {
    AffixOperator result = AffixOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAffixOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericUnaryOperator createNumericUnaryOperatorFromString(EDataType eDataType, String initialValue)
  {
    NumericUnaryOperator result = NumericUnaryOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertNumericUnaryOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftOperator createShiftOperatorFromString(EDataType eDataType, String initialValue)
  {
    ShiftOperator result = ShiftOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertShiftOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue)
  {
    RelationalOperator result = RelationalOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationOperator createClassificationOperatorFromString(EDataType eDataType, String initialValue)
  {
    ClassificationOperator result = ClassificationOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertClassificationOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityOperator createEqualityOperatorFromString(EDataType eDataType, String initialValue)
  {
    EqualityOperator result = EqualityOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEqualityOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentOperator createAssignmentOperatorFromString(EDataType eDataType, String initialValue)
  {
    AssignmentOperator result = AssignmentOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAssignmentOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReducedAlfLanguagePackage getReducedAlfLanguagePackage()
  {
    return (ReducedAlfLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ReducedAlfLanguagePackage getPackage()
  {
    return ReducedAlfLanguagePackage.eINSTANCE;
  }

} //ReducedAlfLanguageFactoryImpl
