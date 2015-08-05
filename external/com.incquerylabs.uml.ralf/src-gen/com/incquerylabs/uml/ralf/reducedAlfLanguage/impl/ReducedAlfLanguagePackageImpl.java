/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.impl;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentOperator;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.AssociationAccessExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BitStringUnaryExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Block;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BlockStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanLiteralExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BreakStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.CastExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassExtentExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationOperator;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionLiteralExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ConcurrentClauses;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalTestExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.EmptyStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityOperator;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureLeftHandSide;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ForEachStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.IsolationExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LeftHandSide;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperation;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LoopVariable;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NameExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NameLeftHandSide;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedTuple;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NaturalLiteralExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NonFinalClause;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NullExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.PrefixExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.PropertyAccessExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.QualifiedNameList;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.RealLiteralExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguageFactory;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalOperator;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReturnStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SequenceAccessExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftOperator;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SimpleStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Statement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.StringLiteralExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SuperInvocationExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchClause;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ThisExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Tuple;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.TypeDeclaration;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.UnboundedLiteralExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReducedAlfLanguagePackageImpl extends EPackageImpl implements ReducedAlfLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanLiteralExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass naturalLiteralExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass realLiteralExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unboundedLiteralExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringLiteralExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyAccessExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedTupleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass superInvocationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass linkOperationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classExtentExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nullExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectionLiteralExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanUnaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitStringUnaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericUnaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass isolationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass castExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass leftHandSideEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameLeftHandSideEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureLeftHandSideEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blockStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emptyStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass localNameDeclarationStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instanceCreationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass concurrentClausesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonFinalClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass switchStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass switchClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whileStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forEachStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass breakStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass returnStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifyStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedNameListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sendSignalStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureInvocationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationAccessExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceAccessExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thisExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elementCollectionExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass prefixExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postfixExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arithmeticExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shiftExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classificationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalityExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logicalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalLogicalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalTestExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loopVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum linkOperationEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum collectionTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum affixOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum numericUnaryOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum shiftOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum relationalOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum classificationOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum equalityOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum assignmentOperatorEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ReducedAlfLanguagePackageImpl()
  {
    super(eNS_URI, ReducedAlfLanguageFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ReducedAlfLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ReducedAlfLanguagePackage init()
  {
    if (isInited) return (ReducedAlfLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(ReducedAlfLanguagePackage.eNS_URI);

    // Obtain or create and register package
    ReducedAlfLanguagePackageImpl theReducedAlfLanguagePackage = (ReducedAlfLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ReducedAlfLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ReducedAlfLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    UMLPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theReducedAlfLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theReducedAlfLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theReducedAlfLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ReducedAlfLanguagePackage.eNS_URI, theReducedAlfLanguagePackage);
    return theReducedAlfLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatements()
  {
    return statementsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatements_Statement()
  {
    return (EReference)statementsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteralExpression()
  {
    return literalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteralExpression_Value()
  {
    return (EAttribute)literalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanLiteralExpression()
  {
    return booleanLiteralExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNaturalLiteralExpression()
  {
    return naturalLiteralExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRealLiteralExpression()
  {
    return realLiteralExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnboundedLiteralExpression()
  {
    return unboundedLiteralExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringLiteralExpression()
  {
    return stringLiteralExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameExpression()
  {
    return nameExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameExpression_Reference()
  {
    return (EReference)nameExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyAccessExpression()
  {
    return propertyAccessExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyAccessExpression_Context()
  {
    return (EReference)propertyAccessExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyAccessExpression_Property()
  {
    return (EReference)propertyAccessExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTuple()
  {
    return tupleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionList()
  {
    return expressionListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressionList_Expressions()
  {
    return (EReference)expressionListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedTuple()
  {
    return namedTupleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedTuple_Expressions()
  {
    return (EReference)namedTupleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedExpression()
  {
    return namedExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedExpression_Name()
  {
    return (EAttribute)namedExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedExpression_Expression()
  {
    return (EReference)namedExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuperInvocationExpression()
  {
    return superInvocationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuperInvocationExpression_Target()
  {
    return (EReference)superInvocationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuperInvocationExpression_Tuple()
  {
    return (EReference)superInvocationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLinkOperationExpression()
  {
    return linkOperationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationExpression_Association()
  {
    return (EReference)linkOperationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLinkOperationExpression_Operation()
  {
    return (EAttribute)linkOperationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkOperationExpression_Tuple()
  {
    return (EReference)linkOperationExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassExtentExpression()
  {
    return classExtentExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassExtentExpression_Class()
  {
    return (EReference)classExtentExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNullExpression()
  {
    return nullExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectionLiteralExpression()
  {
    return collectionLiteralExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeDeclaration()
  {
    return typeDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeDeclaration_Type()
  {
    return (EReference)typeDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanUnaryExpression()
  {
    return booleanUnaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanUnaryExpression_Operator()
  {
    return (EAttribute)booleanUnaryExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBooleanUnaryExpression_Operand()
  {
    return (EReference)booleanUnaryExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitStringUnaryExpression()
  {
    return bitStringUnaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBitStringUnaryExpression_Operator()
  {
    return (EAttribute)bitStringUnaryExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitStringUnaryExpression_Operand()
  {
    return (EReference)bitStringUnaryExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericUnaryExpression()
  {
    return numericUnaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumericUnaryExpression_Operator()
  {
    return (EAttribute)numericUnaryExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumericUnaryExpression_Operand()
  {
    return (EReference)numericUnaryExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIsolationExpression()
  {
    return isolationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIsolationExpression_Operator()
  {
    return (EAttribute)isolationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIsolationExpression_Operand()
  {
    return (EReference)isolationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCastExpression()
  {
    return castExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCastExpression_Type()
  {
    return (EReference)castExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCastExpression_Operand()
  {
    return (EReference)castExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignmentExpression()
  {
    return assignmentExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentExpression_LeftHandSide()
  {
    return (EReference)assignmentExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignmentExpression_Operator()
  {
    return (EAttribute)assignmentExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentExpression_RightHandSide()
  {
    return (EReference)assignmentExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLeftHandSide()
  {
    return leftHandSideEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameLeftHandSide()
  {
    return nameLeftHandSideEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameLeftHandSide_Expression()
  {
    return (EReference)nameLeftHandSideEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameLeftHandSide_Index()
  {
    return (EReference)nameLeftHandSideEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeatureLeftHandSide()
  {
    return featureLeftHandSideEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureLeftHandSide_Expression()
  {
    return (EReference)featureLeftHandSideEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatement()
  {
    return statementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleStatement()
  {
    return simpleStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlock()
  {
    return blockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlock_Statement()
  {
    return (EReference)blockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlockStatement()
  {
    return blockStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEmptyStatement()
  {
    return emptyStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLocalNameDeclarationStatement()
  {
    return localNameDeclarationStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationStatement_Variable()
  {
    return (EReference)localNameDeclarationStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalNameDeclarationStatement_Expression()
  {
    return (EReference)localNameDeclarationStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstanceCreationExpression()
  {
    return instanceCreationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceCreationExpression_Instance()
  {
    return (EReference)instanceCreationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceCreationExpression_Tuple()
  {
    return (EReference)instanceCreationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionStatement()
  {
    return expressionStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressionStatement_Expression()
  {
    return (EReference)expressionStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfStatement()
  {
    return ifStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfStatement_NonFinalClauses()
  {
    return (EReference)ifStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfStatement_FinalClause()
  {
    return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConcurrentClauses()
  {
    return concurrentClausesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConcurrentClauses_Clause()
  {
    return (EReference)concurrentClausesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonFinalClause()
  {
    return nonFinalClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonFinalClause_Condition()
  {
    return (EReference)nonFinalClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonFinalClause_Body()
  {
    return (EReference)nonFinalClauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSwitchStatement()
  {
    return switchStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchStatement_Expression()
  {
    return (EReference)switchStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchStatement_NonDefaultClause()
  {
    return (EReference)switchStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchStatement_DefaultClause()
  {
    return (EReference)switchStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSwitchClause()
  {
    return switchClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchClause_Case()
  {
    return (EReference)switchClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchClause_Block()
  {
    return (EReference)switchClauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWhileStatement()
  {
    return whileStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWhileStatement_Condition()
  {
    return (EReference)whileStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWhileStatement_Body()
  {
    return (EReference)whileStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDoStatement()
  {
    return doStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDoStatement_Body()
  {
    return (EReference)doStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDoStatement_Condition()
  {
    return (EReference)doStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForStatement()
  {
    return forStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStatement_Initialization()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStatement_Condition()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStatement_Update()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStatement_Body()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForEachStatement()
  {
    return forEachStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForEachStatement_VariableDefinition()
  {
    return (EReference)forEachStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForEachStatement_Body()
  {
    return (EReference)forEachStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariable()
  {
    return variableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariable_Type()
  {
    return (EReference)variableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariable_HasMultiplicity()
  {
    return (EAttribute)variableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBreakStatement()
  {
    return breakStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReturnStatement()
  {
    return returnStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReturnStatement_Expression()
  {
    return (EReference)returnStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassifyStatement()
  {
    return classifyStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifyStatement_Expression()
  {
    return (EReference)classifyStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifyStatement_FromList()
  {
    return (EReference)classifyStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifyStatement_ToList()
  {
    return (EReference)classifyStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassifyStatement_IsReclassifyAll()
  {
    return (EAttribute)classifyStatementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedNameList()
  {
    return qualifiedNameListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQualifiedNameList_Name()
  {
    return (EAttribute)qualifiedNameListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSendSignalStatement()
  {
    return sendSignalStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSendSignalStatement_Signal()
  {
    return (EReference)sendSignalStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSendSignalStatement_Target()
  {
    return (EReference)sendSignalStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeatureInvocationExpression()
  {
    return featureInvocationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureInvocationExpression_Context()
  {
    return (EReference)featureInvocationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeatureInvocationExpression_IsStatic()
  {
    return (EAttribute)featureInvocationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureInvocationExpression_Operation()
  {
    return (EReference)featureInvocationExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureInvocationExpression_Parameters()
  {
    return (EReference)featureInvocationExpressionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureInvocationExpression_Tuple()
  {
    return (EReference)featureInvocationExpressionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociationAccessExpression()
  {
    return associationAccessExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationAccessExpression_Context()
  {
    return (EReference)associationAccessExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationAccessExpression_Association()
  {
    return (EReference)associationAccessExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceAccessExpression()
  {
    return sequenceAccessExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceAccessExpression_Primary()
  {
    return (EReference)sequenceAccessExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceAccessExpression_Index()
  {
    return (EReference)sequenceAccessExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThisExpression()
  {
    return thisExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElementCollectionExpression()
  {
    return elementCollectionExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getElementCollectionExpression_CollectionType()
  {
    return (EAttribute)elementCollectionExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElementCollectionExpression_TypeDeclaration()
  {
    return (EReference)elementCollectionExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElementCollectionExpression_Elements()
  {
    return (EReference)elementCollectionExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrefixExpression()
  {
    return prefixExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrefixExpression_Operator()
  {
    return (EAttribute)prefixExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrefixExpression_Operand()
  {
    return (EReference)prefixExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostfixExpression()
  {
    return postfixExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostfixExpression_Operand()
  {
    return (EReference)postfixExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPostfixExpression_Operator()
  {
    return (EAttribute)postfixExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArithmeticExpression()
  {
    return arithmeticExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArithmeticExpression_Operand1()
  {
    return (EReference)arithmeticExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getArithmeticExpression_Operator()
  {
    return (EAttribute)arithmeticExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArithmeticExpression_Operand2()
  {
    return (EReference)arithmeticExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShiftExpression()
  {
    return shiftExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpression_Operand1()
  {
    return (EReference)shiftExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShiftExpression_Operator()
  {
    return (EAttribute)shiftExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpression_Operand2()
  {
    return (EReference)shiftExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelationalExpression()
  {
    return relationalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_Operand1()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelationalExpression_Operator()
  {
    return (EAttribute)relationalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_Operand2()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassificationExpression()
  {
    return classificationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationExpression_Operand()
  {
    return (EReference)classificationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassificationExpression_Operator()
  {
    return (EAttribute)classificationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassificationExpression_Type()
  {
    return (EReference)classificationExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEqualityExpression()
  {
    return equalityExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityExpression_Operand1()
  {
    return (EReference)equalityExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEqualityExpression_Operator()
  {
    return (EAttribute)equalityExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityExpression_Operand2()
  {
    return (EReference)equalityExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalExpression()
  {
    return logicalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalExpression_Operand1()
  {
    return (EReference)logicalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLogicalExpression_Operator()
  {
    return (EAttribute)logicalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalExpression_Operand2()
  {
    return (EReference)logicalExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalLogicalExpression()
  {
    return conditionalLogicalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalLogicalExpression_Operand1()
  {
    return (EReference)conditionalLogicalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConditionalLogicalExpression_Operator()
  {
    return (EAttribute)conditionalLogicalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalLogicalExpression_Operand2()
  {
    return (EReference)conditionalLogicalExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalTestExpression()
  {
    return conditionalTestExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalTestExpression_Operand1()
  {
    return (EReference)conditionalTestExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalTestExpression_Operand2()
  {
    return (EReference)conditionalTestExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalTestExpression_Operand3()
  {
    return (EReference)conditionalTestExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoopVariable()
  {
    return loopVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoopVariable_Expression()
  {
    return (EReference)loopVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getLinkOperation()
  {
    return linkOperationEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getCollectionType()
  {
    return collectionTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAffixOperator()
  {
    return affixOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getNumericUnaryOperator()
  {
    return numericUnaryOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getShiftOperator()
  {
    return shiftOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getRelationalOperator()
  {
    return relationalOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getClassificationOperator()
  {
    return classificationOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getEqualityOperator()
  {
    return equalityOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAssignmentOperator()
  {
    return assignmentOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReducedAlfLanguageFactory getReducedAlfLanguageFactory()
  {
    return (ReducedAlfLanguageFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    statementsEClass = createEClass(STATEMENTS);
    createEReference(statementsEClass, STATEMENTS__STATEMENT);

    expressionEClass = createEClass(EXPRESSION);

    literalExpressionEClass = createEClass(LITERAL_EXPRESSION);
    createEAttribute(literalExpressionEClass, LITERAL_EXPRESSION__VALUE);

    booleanLiteralExpressionEClass = createEClass(BOOLEAN_LITERAL_EXPRESSION);

    naturalLiteralExpressionEClass = createEClass(NATURAL_LITERAL_EXPRESSION);

    realLiteralExpressionEClass = createEClass(REAL_LITERAL_EXPRESSION);

    unboundedLiteralExpressionEClass = createEClass(UNBOUNDED_LITERAL_EXPRESSION);

    stringLiteralExpressionEClass = createEClass(STRING_LITERAL_EXPRESSION);

    nameExpressionEClass = createEClass(NAME_EXPRESSION);
    createEReference(nameExpressionEClass, NAME_EXPRESSION__REFERENCE);

    propertyAccessExpressionEClass = createEClass(PROPERTY_ACCESS_EXPRESSION);
    createEReference(propertyAccessExpressionEClass, PROPERTY_ACCESS_EXPRESSION__CONTEXT);
    createEReference(propertyAccessExpressionEClass, PROPERTY_ACCESS_EXPRESSION__PROPERTY);

    tupleEClass = createEClass(TUPLE);

    expressionListEClass = createEClass(EXPRESSION_LIST);
    createEReference(expressionListEClass, EXPRESSION_LIST__EXPRESSIONS);

    namedTupleEClass = createEClass(NAMED_TUPLE);
    createEReference(namedTupleEClass, NAMED_TUPLE__EXPRESSIONS);

    namedExpressionEClass = createEClass(NAMED_EXPRESSION);
    createEAttribute(namedExpressionEClass, NAMED_EXPRESSION__NAME);
    createEReference(namedExpressionEClass, NAMED_EXPRESSION__EXPRESSION);

    superInvocationExpressionEClass = createEClass(SUPER_INVOCATION_EXPRESSION);
    createEReference(superInvocationExpressionEClass, SUPER_INVOCATION_EXPRESSION__TARGET);
    createEReference(superInvocationExpressionEClass, SUPER_INVOCATION_EXPRESSION__TUPLE);

    linkOperationExpressionEClass = createEClass(LINK_OPERATION_EXPRESSION);
    createEReference(linkOperationExpressionEClass, LINK_OPERATION_EXPRESSION__ASSOCIATION);
    createEAttribute(linkOperationExpressionEClass, LINK_OPERATION_EXPRESSION__OPERATION);
    createEReference(linkOperationExpressionEClass, LINK_OPERATION_EXPRESSION__TUPLE);

    classExtentExpressionEClass = createEClass(CLASS_EXTENT_EXPRESSION);
    createEReference(classExtentExpressionEClass, CLASS_EXTENT_EXPRESSION__CLASS);

    nullExpressionEClass = createEClass(NULL_EXPRESSION);

    collectionLiteralExpressionEClass = createEClass(COLLECTION_LITERAL_EXPRESSION);

    typeDeclarationEClass = createEClass(TYPE_DECLARATION);
    createEReference(typeDeclarationEClass, TYPE_DECLARATION__TYPE);

    booleanUnaryExpressionEClass = createEClass(BOOLEAN_UNARY_EXPRESSION);
    createEAttribute(booleanUnaryExpressionEClass, BOOLEAN_UNARY_EXPRESSION__OPERATOR);
    createEReference(booleanUnaryExpressionEClass, BOOLEAN_UNARY_EXPRESSION__OPERAND);

    bitStringUnaryExpressionEClass = createEClass(BIT_STRING_UNARY_EXPRESSION);
    createEAttribute(bitStringUnaryExpressionEClass, BIT_STRING_UNARY_EXPRESSION__OPERATOR);
    createEReference(bitStringUnaryExpressionEClass, BIT_STRING_UNARY_EXPRESSION__OPERAND);

    numericUnaryExpressionEClass = createEClass(NUMERIC_UNARY_EXPRESSION);
    createEAttribute(numericUnaryExpressionEClass, NUMERIC_UNARY_EXPRESSION__OPERATOR);
    createEReference(numericUnaryExpressionEClass, NUMERIC_UNARY_EXPRESSION__OPERAND);

    isolationExpressionEClass = createEClass(ISOLATION_EXPRESSION);
    createEAttribute(isolationExpressionEClass, ISOLATION_EXPRESSION__OPERATOR);
    createEReference(isolationExpressionEClass, ISOLATION_EXPRESSION__OPERAND);

    castExpressionEClass = createEClass(CAST_EXPRESSION);
    createEReference(castExpressionEClass, CAST_EXPRESSION__TYPE);
    createEReference(castExpressionEClass, CAST_EXPRESSION__OPERAND);

    assignmentExpressionEClass = createEClass(ASSIGNMENT_EXPRESSION);
    createEReference(assignmentExpressionEClass, ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE);
    createEAttribute(assignmentExpressionEClass, ASSIGNMENT_EXPRESSION__OPERATOR);
    createEReference(assignmentExpressionEClass, ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE);

    leftHandSideEClass = createEClass(LEFT_HAND_SIDE);

    nameLeftHandSideEClass = createEClass(NAME_LEFT_HAND_SIDE);
    createEReference(nameLeftHandSideEClass, NAME_LEFT_HAND_SIDE__EXPRESSION);
    createEReference(nameLeftHandSideEClass, NAME_LEFT_HAND_SIDE__INDEX);

    featureLeftHandSideEClass = createEClass(FEATURE_LEFT_HAND_SIDE);
    createEReference(featureLeftHandSideEClass, FEATURE_LEFT_HAND_SIDE__EXPRESSION);

    statementEClass = createEClass(STATEMENT);

    simpleStatementEClass = createEClass(SIMPLE_STATEMENT);

    blockEClass = createEClass(BLOCK);
    createEReference(blockEClass, BLOCK__STATEMENT);

    blockStatementEClass = createEClass(BLOCK_STATEMENT);

    emptyStatementEClass = createEClass(EMPTY_STATEMENT);

    localNameDeclarationStatementEClass = createEClass(LOCAL_NAME_DECLARATION_STATEMENT);
    createEReference(localNameDeclarationStatementEClass, LOCAL_NAME_DECLARATION_STATEMENT__VARIABLE);
    createEReference(localNameDeclarationStatementEClass, LOCAL_NAME_DECLARATION_STATEMENT__EXPRESSION);

    instanceCreationExpressionEClass = createEClass(INSTANCE_CREATION_EXPRESSION);
    createEReference(instanceCreationExpressionEClass, INSTANCE_CREATION_EXPRESSION__INSTANCE);
    createEReference(instanceCreationExpressionEClass, INSTANCE_CREATION_EXPRESSION__TUPLE);

    expressionStatementEClass = createEClass(EXPRESSION_STATEMENT);
    createEReference(expressionStatementEClass, EXPRESSION_STATEMENT__EXPRESSION);

    ifStatementEClass = createEClass(IF_STATEMENT);
    createEReference(ifStatementEClass, IF_STATEMENT__NON_FINAL_CLAUSES);
    createEReference(ifStatementEClass, IF_STATEMENT__FINAL_CLAUSE);

    concurrentClausesEClass = createEClass(CONCURRENT_CLAUSES);
    createEReference(concurrentClausesEClass, CONCURRENT_CLAUSES__CLAUSE);

    nonFinalClauseEClass = createEClass(NON_FINAL_CLAUSE);
    createEReference(nonFinalClauseEClass, NON_FINAL_CLAUSE__CONDITION);
    createEReference(nonFinalClauseEClass, NON_FINAL_CLAUSE__BODY);

    switchStatementEClass = createEClass(SWITCH_STATEMENT);
    createEReference(switchStatementEClass, SWITCH_STATEMENT__EXPRESSION);
    createEReference(switchStatementEClass, SWITCH_STATEMENT__NON_DEFAULT_CLAUSE);
    createEReference(switchStatementEClass, SWITCH_STATEMENT__DEFAULT_CLAUSE);

    switchClauseEClass = createEClass(SWITCH_CLAUSE);
    createEReference(switchClauseEClass, SWITCH_CLAUSE__CASE);
    createEReference(switchClauseEClass, SWITCH_CLAUSE__BLOCK);

    whileStatementEClass = createEClass(WHILE_STATEMENT);
    createEReference(whileStatementEClass, WHILE_STATEMENT__CONDITION);
    createEReference(whileStatementEClass, WHILE_STATEMENT__BODY);

    doStatementEClass = createEClass(DO_STATEMENT);
    createEReference(doStatementEClass, DO_STATEMENT__BODY);
    createEReference(doStatementEClass, DO_STATEMENT__CONDITION);

    forStatementEClass = createEClass(FOR_STATEMENT);
    createEReference(forStatementEClass, FOR_STATEMENT__INITIALIZATION);
    createEReference(forStatementEClass, FOR_STATEMENT__CONDITION);
    createEReference(forStatementEClass, FOR_STATEMENT__UPDATE);
    createEReference(forStatementEClass, FOR_STATEMENT__BODY);

    forEachStatementEClass = createEClass(FOR_EACH_STATEMENT);
    createEReference(forEachStatementEClass, FOR_EACH_STATEMENT__VARIABLE_DEFINITION);
    createEReference(forEachStatementEClass, FOR_EACH_STATEMENT__BODY);

    variableEClass = createEClass(VARIABLE);
    createEReference(variableEClass, VARIABLE__TYPE);
    createEAttribute(variableEClass, VARIABLE__HAS_MULTIPLICITY);

    breakStatementEClass = createEClass(BREAK_STATEMENT);

    returnStatementEClass = createEClass(RETURN_STATEMENT);
    createEReference(returnStatementEClass, RETURN_STATEMENT__EXPRESSION);

    classifyStatementEClass = createEClass(CLASSIFY_STATEMENT);
    createEReference(classifyStatementEClass, CLASSIFY_STATEMENT__EXPRESSION);
    createEReference(classifyStatementEClass, CLASSIFY_STATEMENT__FROM_LIST);
    createEReference(classifyStatementEClass, CLASSIFY_STATEMENT__TO_LIST);
    createEAttribute(classifyStatementEClass, CLASSIFY_STATEMENT__IS_RECLASSIFY_ALL);

    qualifiedNameListEClass = createEClass(QUALIFIED_NAME_LIST);
    createEAttribute(qualifiedNameListEClass, QUALIFIED_NAME_LIST__NAME);

    sendSignalStatementEClass = createEClass(SEND_SIGNAL_STATEMENT);
    createEReference(sendSignalStatementEClass, SEND_SIGNAL_STATEMENT__SIGNAL);
    createEReference(sendSignalStatementEClass, SEND_SIGNAL_STATEMENT__TARGET);

    featureInvocationExpressionEClass = createEClass(FEATURE_INVOCATION_EXPRESSION);
    createEReference(featureInvocationExpressionEClass, FEATURE_INVOCATION_EXPRESSION__CONTEXT);
    createEAttribute(featureInvocationExpressionEClass, FEATURE_INVOCATION_EXPRESSION__IS_STATIC);
    createEReference(featureInvocationExpressionEClass, FEATURE_INVOCATION_EXPRESSION__OPERATION);
    createEReference(featureInvocationExpressionEClass, FEATURE_INVOCATION_EXPRESSION__PARAMETERS);
    createEReference(featureInvocationExpressionEClass, FEATURE_INVOCATION_EXPRESSION__TUPLE);

    associationAccessExpressionEClass = createEClass(ASSOCIATION_ACCESS_EXPRESSION);
    createEReference(associationAccessExpressionEClass, ASSOCIATION_ACCESS_EXPRESSION__CONTEXT);
    createEReference(associationAccessExpressionEClass, ASSOCIATION_ACCESS_EXPRESSION__ASSOCIATION);

    sequenceAccessExpressionEClass = createEClass(SEQUENCE_ACCESS_EXPRESSION);
    createEReference(sequenceAccessExpressionEClass, SEQUENCE_ACCESS_EXPRESSION__PRIMARY);
    createEReference(sequenceAccessExpressionEClass, SEQUENCE_ACCESS_EXPRESSION__INDEX);

    thisExpressionEClass = createEClass(THIS_EXPRESSION);

    elementCollectionExpressionEClass = createEClass(ELEMENT_COLLECTION_EXPRESSION);
    createEAttribute(elementCollectionExpressionEClass, ELEMENT_COLLECTION_EXPRESSION__COLLECTION_TYPE);
    createEReference(elementCollectionExpressionEClass, ELEMENT_COLLECTION_EXPRESSION__TYPE_DECLARATION);
    createEReference(elementCollectionExpressionEClass, ELEMENT_COLLECTION_EXPRESSION__ELEMENTS);

    prefixExpressionEClass = createEClass(PREFIX_EXPRESSION);
    createEAttribute(prefixExpressionEClass, PREFIX_EXPRESSION__OPERATOR);
    createEReference(prefixExpressionEClass, PREFIX_EXPRESSION__OPERAND);

    postfixExpressionEClass = createEClass(POSTFIX_EXPRESSION);
    createEReference(postfixExpressionEClass, POSTFIX_EXPRESSION__OPERAND);
    createEAttribute(postfixExpressionEClass, POSTFIX_EXPRESSION__OPERATOR);

    arithmeticExpressionEClass = createEClass(ARITHMETIC_EXPRESSION);
    createEReference(arithmeticExpressionEClass, ARITHMETIC_EXPRESSION__OPERAND1);
    createEAttribute(arithmeticExpressionEClass, ARITHMETIC_EXPRESSION__OPERATOR);
    createEReference(arithmeticExpressionEClass, ARITHMETIC_EXPRESSION__OPERAND2);

    shiftExpressionEClass = createEClass(SHIFT_EXPRESSION);
    createEReference(shiftExpressionEClass, SHIFT_EXPRESSION__OPERAND1);
    createEAttribute(shiftExpressionEClass, SHIFT_EXPRESSION__OPERATOR);
    createEReference(shiftExpressionEClass, SHIFT_EXPRESSION__OPERAND2);

    relationalExpressionEClass = createEClass(RELATIONAL_EXPRESSION);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__OPERAND1);
    createEAttribute(relationalExpressionEClass, RELATIONAL_EXPRESSION__OPERATOR);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__OPERAND2);

    classificationExpressionEClass = createEClass(CLASSIFICATION_EXPRESSION);
    createEReference(classificationExpressionEClass, CLASSIFICATION_EXPRESSION__OPERAND);
    createEAttribute(classificationExpressionEClass, CLASSIFICATION_EXPRESSION__OPERATOR);
    createEReference(classificationExpressionEClass, CLASSIFICATION_EXPRESSION__TYPE);

    equalityExpressionEClass = createEClass(EQUALITY_EXPRESSION);
    createEReference(equalityExpressionEClass, EQUALITY_EXPRESSION__OPERAND1);
    createEAttribute(equalityExpressionEClass, EQUALITY_EXPRESSION__OPERATOR);
    createEReference(equalityExpressionEClass, EQUALITY_EXPRESSION__OPERAND2);

    logicalExpressionEClass = createEClass(LOGICAL_EXPRESSION);
    createEReference(logicalExpressionEClass, LOGICAL_EXPRESSION__OPERAND1);
    createEAttribute(logicalExpressionEClass, LOGICAL_EXPRESSION__OPERATOR);
    createEReference(logicalExpressionEClass, LOGICAL_EXPRESSION__OPERAND2);

    conditionalLogicalExpressionEClass = createEClass(CONDITIONAL_LOGICAL_EXPRESSION);
    createEReference(conditionalLogicalExpressionEClass, CONDITIONAL_LOGICAL_EXPRESSION__OPERAND1);
    createEAttribute(conditionalLogicalExpressionEClass, CONDITIONAL_LOGICAL_EXPRESSION__OPERATOR);
    createEReference(conditionalLogicalExpressionEClass, CONDITIONAL_LOGICAL_EXPRESSION__OPERAND2);

    conditionalTestExpressionEClass = createEClass(CONDITIONAL_TEST_EXPRESSION);
    createEReference(conditionalTestExpressionEClass, CONDITIONAL_TEST_EXPRESSION__OPERAND1);
    createEReference(conditionalTestExpressionEClass, CONDITIONAL_TEST_EXPRESSION__OPERAND2);
    createEReference(conditionalTestExpressionEClass, CONDITIONAL_TEST_EXPRESSION__OPERAND3);

    loopVariableEClass = createEClass(LOOP_VARIABLE);
    createEReference(loopVariableEClass, LOOP_VARIABLE__EXPRESSION);

    // Create enums
    linkOperationEEnum = createEEnum(LINK_OPERATION);
    collectionTypeEEnum = createEEnum(COLLECTION_TYPE);
    affixOperatorEEnum = createEEnum(AFFIX_OPERATOR);
    numericUnaryOperatorEEnum = createEEnum(NUMERIC_UNARY_OPERATOR);
    shiftOperatorEEnum = createEEnum(SHIFT_OPERATOR);
    relationalOperatorEEnum = createEEnum(RELATIONAL_OPERATOR);
    classificationOperatorEEnum = createEEnum(CLASSIFICATION_OPERATOR);
    equalityOperatorEEnum = createEEnum(EQUALITY_OPERATOR);
    assignmentOperatorEEnum = createEEnum(ASSIGNMENT_OPERATOR);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    literalExpressionEClass.getESuperTypes().add(this.getExpression());
    booleanLiteralExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
    naturalLiteralExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
    realLiteralExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
    unboundedLiteralExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
    stringLiteralExpressionEClass.getESuperTypes().add(this.getLiteralExpression());
    nameExpressionEClass.getESuperTypes().add(this.getExpression());
    propertyAccessExpressionEClass.getESuperTypes().add(this.getExpression());
    expressionListEClass.getESuperTypes().add(this.getTuple());
    namedTupleEClass.getESuperTypes().add(this.getTuple());
    superInvocationExpressionEClass.getESuperTypes().add(this.getExpression());
    linkOperationExpressionEClass.getESuperTypes().add(this.getExpression());
    classExtentExpressionEClass.getESuperTypes().add(this.getExpression());
    nullExpressionEClass.getESuperTypes().add(this.getExpression());
    collectionLiteralExpressionEClass.getESuperTypes().add(this.getExpression());
    booleanUnaryExpressionEClass.getESuperTypes().add(this.getExpression());
    bitStringUnaryExpressionEClass.getESuperTypes().add(this.getExpression());
    numericUnaryExpressionEClass.getESuperTypes().add(this.getExpression());
    isolationExpressionEClass.getESuperTypes().add(this.getExpression());
    castExpressionEClass.getESuperTypes().add(this.getExpression());
    assignmentExpressionEClass.getESuperTypes().add(this.getExpression());
    nameLeftHandSideEClass.getESuperTypes().add(this.getLeftHandSide());
    featureLeftHandSideEClass.getESuperTypes().add(this.getLeftHandSide());
    simpleStatementEClass.getESuperTypes().add(this.getStatement());
    blockEClass.getESuperTypes().add(this.getBlockStatement());
    blockStatementEClass.getESuperTypes().add(this.getStatement());
    emptyStatementEClass.getESuperTypes().add(this.getSimpleStatement());
    localNameDeclarationStatementEClass.getESuperTypes().add(this.getSimpleStatement());
    instanceCreationExpressionEClass.getESuperTypes().add(this.getExpression());
    expressionStatementEClass.getESuperTypes().add(this.getSimpleStatement());
    ifStatementEClass.getESuperTypes().add(this.getStatement());
    switchStatementEClass.getESuperTypes().add(this.getStatement());
    whileStatementEClass.getESuperTypes().add(this.getStatement());
    doStatementEClass.getESuperTypes().add(this.getStatement());
    forStatementEClass.getESuperTypes().add(this.getStatement());
    forEachStatementEClass.getESuperTypes().add(this.getStatement());
    variableEClass.getESuperTypes().add(theUMLPackage.getNamedElement());
    breakStatementEClass.getESuperTypes().add(this.getStatement());
    returnStatementEClass.getESuperTypes().add(this.getStatement());
    classifyStatementEClass.getESuperTypes().add(this.getStatement());
    sendSignalStatementEClass.getESuperTypes().add(this.getStatement());
    featureInvocationExpressionEClass.getESuperTypes().add(this.getExpression());
    associationAccessExpressionEClass.getESuperTypes().add(this.getExpression());
    sequenceAccessExpressionEClass.getESuperTypes().add(this.getExpression());
    thisExpressionEClass.getESuperTypes().add(this.getExpression());
    elementCollectionExpressionEClass.getESuperTypes().add(this.getCollectionLiteralExpression());
    prefixExpressionEClass.getESuperTypes().add(this.getExpression());
    postfixExpressionEClass.getESuperTypes().add(this.getExpression());
    arithmeticExpressionEClass.getESuperTypes().add(this.getExpression());
    shiftExpressionEClass.getESuperTypes().add(this.getExpression());
    relationalExpressionEClass.getESuperTypes().add(this.getExpression());
    classificationExpressionEClass.getESuperTypes().add(this.getExpression());
    equalityExpressionEClass.getESuperTypes().add(this.getExpression());
    logicalExpressionEClass.getESuperTypes().add(this.getExpression());
    conditionalLogicalExpressionEClass.getESuperTypes().add(this.getExpression());
    conditionalTestExpressionEClass.getESuperTypes().add(this.getExpression());
    loopVariableEClass.getESuperTypes().add(this.getVariable());

    // Initialize classes and features; add operations and parameters
    initEClass(statementsEClass, Statements.class, "Statements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStatements_Statement(), this.getStatement(), null, "statement", null, 0, -1, Statements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(literalExpressionEClass, LiteralExpression.class, "LiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteralExpression_Value(), theEcorePackage.getEString(), "value", null, 0, 1, LiteralExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanLiteralExpressionEClass, BooleanLiteralExpression.class, "BooleanLiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(naturalLiteralExpressionEClass, NaturalLiteralExpression.class, "NaturalLiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(realLiteralExpressionEClass, RealLiteralExpression.class, "RealLiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unboundedLiteralExpressionEClass, UnboundedLiteralExpression.class, "UnboundedLiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stringLiteralExpressionEClass, StringLiteralExpression.class, "StringLiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nameExpressionEClass, NameExpression.class, "NameExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNameExpression_Reference(), theUMLPackage.getNamedElement(), null, "reference", null, 0, 1, NameExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyAccessExpressionEClass, PropertyAccessExpression.class, "PropertyAccessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertyAccessExpression_Context(), this.getExpression(), null, "context", null, 0, 1, PropertyAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropertyAccessExpression_Property(), theUMLPackage.getProperty(), null, "property", null, 0, 1, PropertyAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tupleEClass, Tuple.class, "Tuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(expressionListEClass, ExpressionList.class, "ExpressionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpressionList_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, ExpressionList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedTupleEClass, NamedTuple.class, "NamedTuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNamedTuple_Expressions(), this.getNamedExpression(), null, "expressions", null, 0, -1, NamedTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedExpressionEClass, NamedExpression.class, "NamedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedExpression_Name(), theEcorePackage.getEString(), "name", null, 0, 1, NamedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNamedExpression_Expression(), this.getExpression(), null, "expression", null, 0, 1, NamedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(superInvocationExpressionEClass, SuperInvocationExpression.class, "SuperInvocationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSuperInvocationExpression_Target(), theUMLPackage.getOperation(), null, "target", null, 0, 1, SuperInvocationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuperInvocationExpression_Tuple(), this.getTuple(), null, "tuple", null, 0, 1, SuperInvocationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(linkOperationExpressionEClass, LinkOperationExpression.class, "LinkOperationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLinkOperationExpression_Association(), theUMLPackage.getAssociation(), null, "association", null, 0, 1, LinkOperationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLinkOperationExpression_Operation(), this.getLinkOperation(), "operation", null, 0, 1, LinkOperationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLinkOperationExpression_Tuple(), this.getTuple(), null, "tuple", null, 0, 1, LinkOperationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classExtentExpressionEClass, ClassExtentExpression.class, "ClassExtentExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassExtentExpression_Class(), theUMLPackage.getClass_(), null, "class", null, 0, 1, ClassExtentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nullExpressionEClass, NullExpression.class, "NullExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(collectionLiteralExpressionEClass, CollectionLiteralExpression.class, "CollectionLiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeDeclarationEClass, TypeDeclaration.class, "TypeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeDeclaration_Type(), theUMLPackage.getType(), null, "type", null, 0, 1, TypeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanUnaryExpressionEClass, BooleanUnaryExpression.class, "BooleanUnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBooleanUnaryExpression_Operator(), theEcorePackage.getEString(), "operator", null, 0, 1, BooleanUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBooleanUnaryExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, BooleanUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bitStringUnaryExpressionEClass, BitStringUnaryExpression.class, "BitStringUnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBitStringUnaryExpression_Operator(), theEcorePackage.getEString(), "operator", null, 0, 1, BitStringUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBitStringUnaryExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, BitStringUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numericUnaryExpressionEClass, NumericUnaryExpression.class, "NumericUnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNumericUnaryExpression_Operator(), this.getNumericUnaryOperator(), "operator", null, 0, 1, NumericUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNumericUnaryExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, NumericUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(isolationExpressionEClass, IsolationExpression.class, "IsolationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIsolationExpression_Operator(), theEcorePackage.getEString(), "operator", null, 0, 1, IsolationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIsolationExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, IsolationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(castExpressionEClass, CastExpression.class, "CastExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCastExpression_Type(), this.getTypeDeclaration(), null, "type", null, 0, 1, CastExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCastExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, CastExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignmentExpressionEClass, AssignmentExpression.class, "AssignmentExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssignmentExpression_LeftHandSide(), this.getLeftHandSide(), null, "leftHandSide", null, 0, 1, AssignmentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssignmentExpression_Operator(), this.getAssignmentOperator(), "operator", null, 0, 1, AssignmentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignmentExpression_RightHandSide(), this.getExpression(), null, "rightHandSide", null, 0, 1, AssignmentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(leftHandSideEClass, LeftHandSide.class, "LeftHandSide", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nameLeftHandSideEClass, NameLeftHandSide.class, "NameLeftHandSide", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNameLeftHandSide_Expression(), this.getNameExpression(), null, "expression", null, 0, 1, NameLeftHandSide.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNameLeftHandSide_Index(), this.getExpression(), null, "index", null, 0, 1, NameLeftHandSide.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(featureLeftHandSideEClass, FeatureLeftHandSide.class, "FeatureLeftHandSide", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFeatureLeftHandSide_Expression(), this.getPropertyAccessExpression(), null, "expression", null, 0, 1, FeatureLeftHandSide.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statementEClass, Statement.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(simpleStatementEClass, SimpleStatement.class, "SimpleStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBlock_Statement(), this.getStatement(), null, "statement", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(blockStatementEClass, BlockStatement.class, "BlockStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(emptyStatementEClass, EmptyStatement.class, "EmptyStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(localNameDeclarationStatementEClass, LocalNameDeclarationStatement.class, "LocalNameDeclarationStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLocalNameDeclarationStatement_Variable(), this.getVariable(), null, "variable", null, 0, 1, LocalNameDeclarationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocalNameDeclarationStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, LocalNameDeclarationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instanceCreationExpressionEClass, InstanceCreationExpression.class, "InstanceCreationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInstanceCreationExpression_Instance(), theUMLPackage.getClassifier(), null, "instance", null, 0, 1, InstanceCreationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInstanceCreationExpression_Tuple(), this.getTuple(), null, "tuple", null, 0, 1, InstanceCreationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionStatementEClass, ExpressionStatement.class, "ExpressionStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpressionStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, ExpressionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfStatement_NonFinalClauses(), this.getConcurrentClauses(), null, "nonFinalClauses", null, 0, -1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfStatement_FinalClause(), this.getBlock(), null, "finalClause", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(concurrentClausesEClass, ConcurrentClauses.class, "ConcurrentClauses", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConcurrentClauses_Clause(), this.getNonFinalClause(), null, "clause", null, 0, -1, ConcurrentClauses.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nonFinalClauseEClass, NonFinalClause.class, "NonFinalClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNonFinalClause_Condition(), this.getExpression(), null, "condition", null, 0, 1, NonFinalClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNonFinalClause_Body(), this.getBlock(), null, "body", null, 0, 1, NonFinalClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(switchStatementEClass, SwitchStatement.class, "SwitchStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSwitchStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSwitchStatement_NonDefaultClause(), this.getSwitchClause(), null, "nonDefaultClause", null, 0, -1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSwitchStatement_DefaultClause(), this.getBlock(), null, "defaultClause", null, 0, 1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(switchClauseEClass, SwitchClause.class, "SwitchClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSwitchClause_Case(), this.getExpression(), null, "case", null, 0, -1, SwitchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSwitchClause_Block(), this.getBlock(), null, "block", null, 0, 1, SwitchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(whileStatementEClass, WhileStatement.class, "WhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWhileStatement_Condition(), this.getExpression(), null, "condition", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWhileStatement_Body(), this.getBlock(), null, "body", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(doStatementEClass, DoStatement.class, "DoStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDoStatement_Body(), this.getBlock(), null, "body", null, 0, 1, DoStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDoStatement_Condition(), this.getExpression(), null, "condition", null, 0, 1, DoStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(forStatementEClass, ForStatement.class, "ForStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getForStatement_Initialization(), this.getSimpleStatement(), null, "initialization", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStatement_Condition(), this.getExpression(), null, "condition", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStatement_Update(), this.getSimpleStatement(), null, "update", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStatement_Body(), this.getBlock(), null, "body", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(forEachStatementEClass, ForEachStatement.class, "ForEachStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getForEachStatement_VariableDefinition(), this.getVariable(), null, "variableDefinition", null, 0, 1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForEachStatement_Body(), this.getBlock(), null, "body", null, 0, 1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariable_Type(), this.getTypeDeclaration(), null, "type", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariable_HasMultiplicity(), theEcorePackage.getEBoolean(), "hasMultiplicity", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(breakStatementEClass, BreakStatement.class, "BreakStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(returnStatementEClass, ReturnStatement.class, "ReturnStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReturnStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, ReturnStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classifyStatementEClass, ClassifyStatement.class, "ClassifyStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassifyStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, ClassifyStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassifyStatement_FromList(), this.getQualifiedNameList(), null, "fromList", null, 0, 1, ClassifyStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassifyStatement_ToList(), this.getQualifiedNameList(), null, "toList", null, 0, 1, ClassifyStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClassifyStatement_IsReclassifyAll(), theEcorePackage.getEBoolean(), "isReclassifyAll", null, 0, 1, ClassifyStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(qualifiedNameListEClass, QualifiedNameList.class, "QualifiedNameList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQualifiedNameList_Name(), theEcorePackage.getEString(), "name", null, 0, -1, QualifiedNameList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sendSignalStatementEClass, SendSignalStatement.class, "SendSignalStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSendSignalStatement_Signal(), this.getExpression(), null, "signal", null, 0, 1, SendSignalStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSendSignalStatement_Target(), this.getExpression(), null, "target", null, 0, 1, SendSignalStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(featureInvocationExpressionEClass, FeatureInvocationExpression.class, "FeatureInvocationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFeatureInvocationExpression_Context(), this.getExpression(), null, "context", null, 0, 1, FeatureInvocationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeatureInvocationExpression_IsStatic(), theEcorePackage.getEBoolean(), "isStatic", null, 0, 1, FeatureInvocationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeatureInvocationExpression_Operation(), theUMLPackage.getOperation(), null, "operation", null, 0, 1, FeatureInvocationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeatureInvocationExpression_Parameters(), this.getTuple(), null, "parameters", null, 0, 1, FeatureInvocationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeatureInvocationExpression_Tuple(), this.getTuple(), null, "tuple", null, 0, 1, FeatureInvocationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(associationAccessExpressionEClass, AssociationAccessExpression.class, "AssociationAccessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssociationAccessExpression_Context(), this.getExpression(), null, "context", null, 0, 1, AssociationAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssociationAccessExpression_Association(), theUMLPackage.getProperty(), null, "association", null, 0, 1, AssociationAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequenceAccessExpressionEClass, SequenceAccessExpression.class, "SequenceAccessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSequenceAccessExpression_Primary(), this.getExpression(), null, "primary", null, 0, 1, SequenceAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSequenceAccessExpression_Index(), this.getExpression(), null, "index", null, 0, 1, SequenceAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thisExpressionEClass, ThisExpression.class, "ThisExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(elementCollectionExpressionEClass, ElementCollectionExpression.class, "ElementCollectionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getElementCollectionExpression_CollectionType(), this.getCollectionType(), "collectionType", null, 0, 1, ElementCollectionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getElementCollectionExpression_TypeDeclaration(), this.getTypeDeclaration(), null, "typeDeclaration", null, 0, 1, ElementCollectionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getElementCollectionExpression_Elements(), this.getExpressionList(), null, "elements", null, 0, 1, ElementCollectionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(prefixExpressionEClass, PrefixExpression.class, "PrefixExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPrefixExpression_Operator(), this.getAffixOperator(), "operator", null, 0, 1, PrefixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrefixExpression_Operand(), this.getLeftHandSide(), null, "operand", null, 0, 1, PrefixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(postfixExpressionEClass, PostfixExpression.class, "PostfixExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPostfixExpression_Operand(), this.getLeftHandSide(), null, "operand", null, 0, 1, PostfixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPostfixExpression_Operator(), this.getAffixOperator(), "operator", null, 0, 1, PostfixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arithmeticExpressionEClass, ArithmeticExpression.class, "ArithmeticExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArithmeticExpression_Operand1(), this.getExpression(), null, "operand1", null, 0, 1, ArithmeticExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getArithmeticExpression_Operator(), theEcorePackage.getEString(), "operator", null, 0, 1, ArithmeticExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArithmeticExpression_Operand2(), this.getExpression(), null, "operand2", null, 0, 1, ArithmeticExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(shiftExpressionEClass, ShiftExpression.class, "ShiftExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getShiftExpression_Operand1(), this.getExpression(), null, "operand1", null, 0, 1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getShiftExpression_Operator(), this.getShiftOperator(), "operator", null, 0, 1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getShiftExpression_Operand2(), this.getExpression(), null, "operand2", null, 0, 1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relationalExpressionEClass, RelationalExpression.class, "RelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelationalExpression_Operand1(), this.getExpression(), null, "operand1", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelationalExpression_Operator(), this.getRelationalOperator(), "operator", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRelationalExpression_Operand2(), this.getExpression(), null, "operand2", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classificationExpressionEClass, ClassificationExpression.class, "ClassificationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassificationExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, ClassificationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClassificationExpression_Operator(), this.getClassificationOperator(), "operator", null, 0, 1, ClassificationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassificationExpression_Type(), theUMLPackage.getClass_(), null, "type", null, 0, 1, ClassificationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(equalityExpressionEClass, EqualityExpression.class, "EqualityExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEqualityExpression_Operand1(), this.getExpression(), null, "operand1", null, 0, 1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEqualityExpression_Operator(), this.getEqualityOperator(), "operator", null, 0, 1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEqualityExpression_Operand2(), this.getExpression(), null, "operand2", null, 0, 1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalExpressionEClass, LogicalExpression.class, "LogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalExpression_Operand1(), this.getExpression(), null, "operand1", null, 0, 1, LogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLogicalExpression_Operator(), theEcorePackage.getEString(), "operator", null, 0, 1, LogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLogicalExpression_Operand2(), this.getExpression(), null, "operand2", null, 0, 1, LogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionalLogicalExpressionEClass, ConditionalLogicalExpression.class, "ConditionalLogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalLogicalExpression_Operand1(), this.getExpression(), null, "operand1", null, 0, 1, ConditionalLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConditionalLogicalExpression_Operator(), theEcorePackage.getEString(), "operator", null, 0, 1, ConditionalLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalLogicalExpression_Operand2(), this.getExpression(), null, "operand2", null, 0, 1, ConditionalLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionalTestExpressionEClass, ConditionalTestExpression.class, "ConditionalTestExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalTestExpression_Operand1(), this.getExpression(), null, "operand1", null, 0, 1, ConditionalTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalTestExpression_Operand2(), this.getExpression(), null, "operand2", null, 0, 1, ConditionalTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalTestExpression_Operand3(), this.getExpression(), null, "operand3", null, 0, 1, ConditionalTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loopVariableEClass, LoopVariable.class, "LoopVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLoopVariable_Expression(), this.getExpression(), null, "expression", null, 0, 1, LoopVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(linkOperationEEnum, LinkOperation.class, "LinkOperation");
    addEEnumLiteral(linkOperationEEnum, LinkOperation.LINK);
    addEEnumLiteral(linkOperationEEnum, LinkOperation.UNLINK);

    initEEnum(collectionTypeEEnum, CollectionType.class, "CollectionType");
    addEEnumLiteral(collectionTypeEEnum, CollectionType.SET);
    addEEnumLiteral(collectionTypeEEnum, CollectionType.BAG);
    addEEnumLiteral(collectionTypeEEnum, CollectionType.SEQUENCE);

    initEEnum(affixOperatorEEnum, AffixOperator.class, "AffixOperator");
    addEEnumLiteral(affixOperatorEEnum, AffixOperator.INCREMENT);
    addEEnumLiteral(affixOperatorEEnum, AffixOperator.DECREMENT);

    initEEnum(numericUnaryOperatorEEnum, NumericUnaryOperator.class, "NumericUnaryOperator");
    addEEnumLiteral(numericUnaryOperatorEEnum, NumericUnaryOperator.PLUS);
    addEEnumLiteral(numericUnaryOperatorEEnum, NumericUnaryOperator.MINUS);

    initEEnum(shiftOperatorEEnum, ShiftOperator.class, "ShiftOperator");
    addEEnumLiteral(shiftOperatorEEnum, ShiftOperator.RIGHT);
    addEEnumLiteral(shiftOperatorEEnum, ShiftOperator.LEFT);
    addEEnumLiteral(shiftOperatorEEnum, ShiftOperator.TRIPLE);

    initEEnum(relationalOperatorEEnum, RelationalOperator.class, "RelationalOperator");
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_THAN);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESSER_THAN);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_OR_EQUALS);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESSER_OR_EQUALS);

    initEEnum(classificationOperatorEEnum, ClassificationOperator.class, "ClassificationOperator");
    addEEnumLiteral(classificationOperatorEEnum, ClassificationOperator.INSTANCEOF);
    addEEnumLiteral(classificationOperatorEEnum, ClassificationOperator.HASTYPE);

    initEEnum(equalityOperatorEEnum, EqualityOperator.class, "EqualityOperator");
    addEEnumLiteral(equalityOperatorEEnum, EqualityOperator.EQUALS);
    addEEnumLiteral(equalityOperatorEEnum, EqualityOperator.NOT_EQUALS);

    initEEnum(assignmentOperatorEEnum, AssignmentOperator.class, "AssignmentOperator");
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.INCREMENT_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.DECREMENT_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.MULTIPLY_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.DIVISION_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.MODULO_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.AND_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.OR_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.XOR_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.LEFT_SHIFT_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.RIGHT_SHIFT_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.TRIPLE_SHIFT_ASSIGN);

    // Create resource
    createResource(eNS_URI);
  }

} //ReducedAlfLanguagePackageImpl
