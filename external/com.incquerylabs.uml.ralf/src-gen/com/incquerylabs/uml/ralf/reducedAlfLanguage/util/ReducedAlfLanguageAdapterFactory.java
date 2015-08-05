/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.util;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage
 * @generated
 */
public class ReducedAlfLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ReducedAlfLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReducedAlfLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ReducedAlfLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReducedAlfLanguageSwitch<Adapter> modelSwitch =
    new ReducedAlfLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseStatements(Statements object)
      {
        return createStatementsAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseLiteralExpression(LiteralExpression object)
      {
        return createLiteralExpressionAdapter();
      }
      @Override
      public Adapter caseBooleanLiteralExpression(BooleanLiteralExpression object)
      {
        return createBooleanLiteralExpressionAdapter();
      }
      @Override
      public Adapter caseNaturalLiteralExpression(NaturalLiteralExpression object)
      {
        return createNaturalLiteralExpressionAdapter();
      }
      @Override
      public Adapter caseRealLiteralExpression(RealLiteralExpression object)
      {
        return createRealLiteralExpressionAdapter();
      }
      @Override
      public Adapter caseUnboundedLiteralExpression(UnboundedLiteralExpression object)
      {
        return createUnboundedLiteralExpressionAdapter();
      }
      @Override
      public Adapter caseStringLiteralExpression(StringLiteralExpression object)
      {
        return createStringLiteralExpressionAdapter();
      }
      @Override
      public Adapter caseNameExpression(NameExpression object)
      {
        return createNameExpressionAdapter();
      }
      @Override
      public Adapter casePropertyAccessExpression(PropertyAccessExpression object)
      {
        return createPropertyAccessExpressionAdapter();
      }
      @Override
      public Adapter caseTuple(Tuple object)
      {
        return createTupleAdapter();
      }
      @Override
      public Adapter caseExpressionList(ExpressionList object)
      {
        return createExpressionListAdapter();
      }
      @Override
      public Adapter caseNamedTuple(NamedTuple object)
      {
        return createNamedTupleAdapter();
      }
      @Override
      public Adapter caseNamedExpression(NamedExpression object)
      {
        return createNamedExpressionAdapter();
      }
      @Override
      public Adapter caseSuperInvocationExpression(SuperInvocationExpression object)
      {
        return createSuperInvocationExpressionAdapter();
      }
      @Override
      public Adapter caseLinkOperationExpression(LinkOperationExpression object)
      {
        return createLinkOperationExpressionAdapter();
      }
      @Override
      public Adapter caseClassExtentExpression(ClassExtentExpression object)
      {
        return createClassExtentExpressionAdapter();
      }
      @Override
      public Adapter caseNullExpression(NullExpression object)
      {
        return createNullExpressionAdapter();
      }
      @Override
      public Adapter caseCollectionLiteralExpression(CollectionLiteralExpression object)
      {
        return createCollectionLiteralExpressionAdapter();
      }
      @Override
      public Adapter caseTypeDeclaration(TypeDeclaration object)
      {
        return createTypeDeclarationAdapter();
      }
      @Override
      public Adapter caseBooleanUnaryExpression(BooleanUnaryExpression object)
      {
        return createBooleanUnaryExpressionAdapter();
      }
      @Override
      public Adapter caseBitStringUnaryExpression(BitStringUnaryExpression object)
      {
        return createBitStringUnaryExpressionAdapter();
      }
      @Override
      public Adapter caseNumericUnaryExpression(NumericUnaryExpression object)
      {
        return createNumericUnaryExpressionAdapter();
      }
      @Override
      public Adapter caseIsolationExpression(IsolationExpression object)
      {
        return createIsolationExpressionAdapter();
      }
      @Override
      public Adapter caseCastExpression(CastExpression object)
      {
        return createCastExpressionAdapter();
      }
      @Override
      public Adapter caseAssignmentExpression(AssignmentExpression object)
      {
        return createAssignmentExpressionAdapter();
      }
      @Override
      public Adapter caseLeftHandSide(LeftHandSide object)
      {
        return createLeftHandSideAdapter();
      }
      @Override
      public Adapter caseNameLeftHandSide(NameLeftHandSide object)
      {
        return createNameLeftHandSideAdapter();
      }
      @Override
      public Adapter caseFeatureLeftHandSide(FeatureLeftHandSide object)
      {
        return createFeatureLeftHandSideAdapter();
      }
      @Override
      public Adapter caseStatement(Statement object)
      {
        return createStatementAdapter();
      }
      @Override
      public Adapter caseSimpleStatement(SimpleStatement object)
      {
        return createSimpleStatementAdapter();
      }
      @Override
      public Adapter caseBlock(Block object)
      {
        return createBlockAdapter();
      }
      @Override
      public Adapter caseBlockStatement(BlockStatement object)
      {
        return createBlockStatementAdapter();
      }
      @Override
      public Adapter caseEmptyStatement(EmptyStatement object)
      {
        return createEmptyStatementAdapter();
      }
      @Override
      public Adapter caseLocalNameDeclarationStatement(LocalNameDeclarationStatement object)
      {
        return createLocalNameDeclarationStatementAdapter();
      }
      @Override
      public Adapter caseInstanceCreationExpression(InstanceCreationExpression object)
      {
        return createInstanceCreationExpressionAdapter();
      }
      @Override
      public Adapter caseExpressionStatement(ExpressionStatement object)
      {
        return createExpressionStatementAdapter();
      }
      @Override
      public Adapter caseIfStatement(IfStatement object)
      {
        return createIfStatementAdapter();
      }
      @Override
      public Adapter caseConcurrentClauses(ConcurrentClauses object)
      {
        return createConcurrentClausesAdapter();
      }
      @Override
      public Adapter caseNonFinalClause(NonFinalClause object)
      {
        return createNonFinalClauseAdapter();
      }
      @Override
      public Adapter caseSwitchStatement(SwitchStatement object)
      {
        return createSwitchStatementAdapter();
      }
      @Override
      public Adapter caseSwitchClause(SwitchClause object)
      {
        return createSwitchClauseAdapter();
      }
      @Override
      public Adapter caseWhileStatement(WhileStatement object)
      {
        return createWhileStatementAdapter();
      }
      @Override
      public Adapter caseDoStatement(DoStatement object)
      {
        return createDoStatementAdapter();
      }
      @Override
      public Adapter caseForStatement(ForStatement object)
      {
        return createForStatementAdapter();
      }
      @Override
      public Adapter caseForEachStatement(ForEachStatement object)
      {
        return createForEachStatementAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseBreakStatement(BreakStatement object)
      {
        return createBreakStatementAdapter();
      }
      @Override
      public Adapter caseReturnStatement(ReturnStatement object)
      {
        return createReturnStatementAdapter();
      }
      @Override
      public Adapter caseClassifyStatement(ClassifyStatement object)
      {
        return createClassifyStatementAdapter();
      }
      @Override
      public Adapter caseQualifiedNameList(QualifiedNameList object)
      {
        return createQualifiedNameListAdapter();
      }
      @Override
      public Adapter caseSendSignalStatement(SendSignalStatement object)
      {
        return createSendSignalStatementAdapter();
      }
      @Override
      public Adapter caseFeatureInvocationExpression(FeatureInvocationExpression object)
      {
        return createFeatureInvocationExpressionAdapter();
      }
      @Override
      public Adapter caseAssociationAccessExpression(AssociationAccessExpression object)
      {
        return createAssociationAccessExpressionAdapter();
      }
      @Override
      public Adapter caseSequenceAccessExpression(SequenceAccessExpression object)
      {
        return createSequenceAccessExpressionAdapter();
      }
      @Override
      public Adapter caseThisExpression(ThisExpression object)
      {
        return createThisExpressionAdapter();
      }
      @Override
      public Adapter caseElementCollectionExpression(ElementCollectionExpression object)
      {
        return createElementCollectionExpressionAdapter();
      }
      @Override
      public Adapter casePrefixExpression(PrefixExpression object)
      {
        return createPrefixExpressionAdapter();
      }
      @Override
      public Adapter casePostfixExpression(PostfixExpression object)
      {
        return createPostfixExpressionAdapter();
      }
      @Override
      public Adapter caseArithmeticExpression(ArithmeticExpression object)
      {
        return createArithmeticExpressionAdapter();
      }
      @Override
      public Adapter caseShiftExpression(ShiftExpression object)
      {
        return createShiftExpressionAdapter();
      }
      @Override
      public Adapter caseRelationalExpression(RelationalExpression object)
      {
        return createRelationalExpressionAdapter();
      }
      @Override
      public Adapter caseClassificationExpression(ClassificationExpression object)
      {
        return createClassificationExpressionAdapter();
      }
      @Override
      public Adapter caseEqualityExpression(EqualityExpression object)
      {
        return createEqualityExpressionAdapter();
      }
      @Override
      public Adapter caseLogicalExpression(LogicalExpression object)
      {
        return createLogicalExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalLogicalExpression(ConditionalLogicalExpression object)
      {
        return createConditionalLogicalExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalTestExpression(ConditionalTestExpression object)
      {
        return createConditionalTestExpressionAdapter();
      }
      @Override
      public Adapter caseLoopVariable(LoopVariable object)
      {
        return createLoopVariableAdapter();
      }
      @Override
      public Adapter caseEModelElement(EModelElement object)
      {
        return createEModelElementAdapter();
      }
      @Override
      public Adapter caseElement(Element object)
      {
        return createElementAdapter();
      }
      @Override
      public Adapter caseNamedElement(NamedElement object)
      {
        return createNamedElementAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements
   * @generated
   */
  public Adapter createStatementsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression <em>Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression
   * @generated
   */
  public Adapter createLiteralExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanLiteralExpression <em>Boolean Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanLiteralExpression
   * @generated
   */
  public Adapter createBooleanLiteralExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NaturalLiteralExpression <em>Natural Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NaturalLiteralExpression
   * @generated
   */
  public Adapter createNaturalLiteralExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.RealLiteralExpression <em>Real Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.RealLiteralExpression
   * @generated
   */
  public Adapter createRealLiteralExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.UnboundedLiteralExpression <em>Unbounded Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.UnboundedLiteralExpression
   * @generated
   */
  public Adapter createUnboundedLiteralExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.StringLiteralExpression <em>String Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.StringLiteralExpression
   * @generated
   */
  public Adapter createStringLiteralExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NameExpression <em>Name Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NameExpression
   * @generated
   */
  public Adapter createNameExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PropertyAccessExpression <em>Property Access Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.PropertyAccessExpression
   * @generated
   */
  public Adapter createPropertyAccessExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Tuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Tuple
   * @generated
   */
  public Adapter createTupleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList <em>Expression List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList
   * @generated
   */
  public Adapter createExpressionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedTuple <em>Named Tuple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedTuple
   * @generated
   */
  public Adapter createNamedTupleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedExpression <em>Named Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedExpression
   * @generated
   */
  public Adapter createNamedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SuperInvocationExpression <em>Super Invocation Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SuperInvocationExpression
   * @generated
   */
  public Adapter createSuperInvocationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression <em>Link Operation Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression
   * @generated
   */
  public Adapter createLinkOperationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassExtentExpression <em>Class Extent Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassExtentExpression
   * @generated
   */
  public Adapter createClassExtentExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NullExpression <em>Null Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NullExpression
   * @generated
   */
  public Adapter createNullExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionLiteralExpression <em>Collection Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionLiteralExpression
   * @generated
   */
  public Adapter createCollectionLiteralExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.TypeDeclaration <em>Type Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.TypeDeclaration
   * @generated
   */
  public Adapter createTypeDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression <em>Boolean Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression
   * @generated
   */
  public Adapter createBooleanUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BitStringUnaryExpression <em>Bit String Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BitStringUnaryExpression
   * @generated
   */
  public Adapter createBitStringUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression <em>Numeric Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression
   * @generated
   */
  public Adapter createNumericUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.IsolationExpression <em>Isolation Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.IsolationExpression
   * @generated
   */
  public Adapter createIsolationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.CastExpression <em>Cast Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.CastExpression
   * @generated
   */
  public Adapter createCastExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression <em>Assignment Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression
   * @generated
   */
  public Adapter createAssignmentExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LeftHandSide <em>Left Hand Side</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LeftHandSide
   * @generated
   */
  public Adapter createLeftHandSideAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NameLeftHandSide <em>Name Left Hand Side</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NameLeftHandSide
   * @generated
   */
  public Adapter createNameLeftHandSideAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureLeftHandSide <em>Feature Left Hand Side</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureLeftHandSide
   * @generated
   */
  public Adapter createFeatureLeftHandSideAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Statement
   * @generated
   */
  public Adapter createStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SimpleStatement <em>Simple Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SimpleStatement
   * @generated
   */
  public Adapter createSimpleStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Block
   * @generated
   */
  public Adapter createBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BlockStatement <em>Block Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BlockStatement
   * @generated
   */
  public Adapter createBlockStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.EmptyStatement <em>Empty Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.EmptyStatement
   * @generated
   */
  public Adapter createEmptyStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement <em>Local Name Declaration Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement
   * @generated
   */
  public Adapter createLocalNameDeclarationStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression <em>Instance Creation Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression
   * @generated
   */
  public Adapter createInstanceCreationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionStatement <em>Expression Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionStatement
   * @generated
   */
  public Adapter createExpressionStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement
   * @generated
   */
  public Adapter createIfStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConcurrentClauses <em>Concurrent Clauses</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConcurrentClauses
   * @generated
   */
  public Adapter createConcurrentClausesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NonFinalClause <em>Non Final Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NonFinalClause
   * @generated
   */
  public Adapter createNonFinalClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement <em>Switch Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement
   * @generated
   */
  public Adapter createSwitchStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchClause <em>Switch Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchClause
   * @generated
   */
  public Adapter createSwitchClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement
   * @generated
   */
  public Adapter createWhileStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement <em>Do Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement
   * @generated
   */
  public Adapter createDoStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement <em>For Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement
   * @generated
   */
  public Adapter createForStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ForEachStatement <em>For Each Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ForEachStatement
   * @generated
   */
  public Adapter createForEachStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BreakStatement <em>Break Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BreakStatement
   * @generated
   */
  public Adapter createBreakStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ReturnStatement <em>Return Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReturnStatement
   * @generated
   */
  public Adapter createReturnStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement <em>Classify Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement
   * @generated
   */
  public Adapter createClassifyStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.QualifiedNameList <em>Qualified Name List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.QualifiedNameList
   * @generated
   */
  public Adapter createQualifiedNameListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement <em>Send Signal Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement
   * @generated
   */
  public Adapter createSendSignalStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression <em>Feature Invocation Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression
   * @generated
   */
  public Adapter createFeatureInvocationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AssociationAccessExpression <em>Association Access Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AssociationAccessExpression
   * @generated
   */
  public Adapter createAssociationAccessExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SequenceAccessExpression <em>Sequence Access Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SequenceAccessExpression
   * @generated
   */
  public Adapter createSequenceAccessExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ThisExpression <em>This Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ThisExpression
   * @generated
   */
  public Adapter createThisExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression <em>Element Collection Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression
   * @generated
   */
  public Adapter createElementCollectionExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PrefixExpression <em>Prefix Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.PrefixExpression
   * @generated
   */
  public Adapter createPrefixExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression <em>Postfix Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression
   * @generated
   */
  public Adapter createPostfixExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression <em>Arithmetic Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression
   * @generated
   */
  public Adapter createArithmeticExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression <em>Shift Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression
   * @generated
   */
  public Adapter createShiftExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalExpression
   * @generated
   */
  public Adapter createRelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationExpression <em>Classification Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationExpression
   * @generated
   */
  public Adapter createClassificationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityExpression
   * @generated
   */
  public Adapter createEqualityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression <em>Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression
   * @generated
   */
  public Adapter createLogicalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression <em>Conditional Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression
   * @generated
   */
  public Adapter createConditionalLogicalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalTestExpression <em>Conditional Test Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalTestExpression
   * @generated
   */
  public Adapter createConditionalTestExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LoopVariable <em>Loop Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LoopVariable
   * @generated
   */
  public Adapter createLoopVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EModelElement <em>EModel Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.ecore.EModelElement
   * @generated
   */
  public Adapter createEModelElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.uml2.uml.Element
   * @generated
   */
  public Adapter createElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.uml2.uml.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //ReducedAlfLanguageAdapterFactory
