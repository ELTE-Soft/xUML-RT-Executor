/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage
 * @generated
 */
public interface ReducedAlfLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ReducedAlfLanguageFactory eINSTANCE = com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Statements</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statements</em>'.
   * @generated
   */
  Statements createStatements();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal Expression</em>'.
   * @generated
   */
  LiteralExpression createLiteralExpression();

  /**
   * Returns a new object of class '<em>Boolean Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Literal Expression</em>'.
   * @generated
   */
  BooleanLiteralExpression createBooleanLiteralExpression();

  /**
   * Returns a new object of class '<em>Natural Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Natural Literal Expression</em>'.
   * @generated
   */
  NaturalLiteralExpression createNaturalLiteralExpression();

  /**
   * Returns a new object of class '<em>Real Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Real Literal Expression</em>'.
   * @generated
   */
  RealLiteralExpression createRealLiteralExpression();

  /**
   * Returns a new object of class '<em>Unbounded Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unbounded Literal Expression</em>'.
   * @generated
   */
  UnboundedLiteralExpression createUnboundedLiteralExpression();

  /**
   * Returns a new object of class '<em>String Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Literal Expression</em>'.
   * @generated
   */
  StringLiteralExpression createStringLiteralExpression();

  /**
   * Returns a new object of class '<em>Name Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name Expression</em>'.
   * @generated
   */
  NameExpression createNameExpression();

  /**
   * Returns a new object of class '<em>Property Access Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Access Expression</em>'.
   * @generated
   */
  PropertyAccessExpression createPropertyAccessExpression();

  /**
   * Returns a new object of class '<em>Tuple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple</em>'.
   * @generated
   */
  Tuple createTuple();

  /**
   * Returns a new object of class '<em>Expression List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression List</em>'.
   * @generated
   */
  ExpressionList createExpressionList();

  /**
   * Returns a new object of class '<em>Named Tuple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Tuple</em>'.
   * @generated
   */
  NamedTuple createNamedTuple();

  /**
   * Returns a new object of class '<em>Named Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Expression</em>'.
   * @generated
   */
  NamedExpression createNamedExpression();

  /**
   * Returns a new object of class '<em>Super Invocation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Super Invocation Expression</em>'.
   * @generated
   */
  SuperInvocationExpression createSuperInvocationExpression();

  /**
   * Returns a new object of class '<em>Link Operation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Link Operation Expression</em>'.
   * @generated
   */
  LinkOperationExpression createLinkOperationExpression();

  /**
   * Returns a new object of class '<em>Class Extent Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Extent Expression</em>'.
   * @generated
   */
  ClassExtentExpression createClassExtentExpression();

  /**
   * Returns a new object of class '<em>Null Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Null Expression</em>'.
   * @generated
   */
  NullExpression createNullExpression();

  /**
   * Returns a new object of class '<em>Collection Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Collection Literal Expression</em>'.
   * @generated
   */
  CollectionLiteralExpression createCollectionLiteralExpression();

  /**
   * Returns a new object of class '<em>Type Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Declaration</em>'.
   * @generated
   */
  TypeDeclaration createTypeDeclaration();

  /**
   * Returns a new object of class '<em>Boolean Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Unary Expression</em>'.
   * @generated
   */
  BooleanUnaryExpression createBooleanUnaryExpression();

  /**
   * Returns a new object of class '<em>Bit String Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bit String Unary Expression</em>'.
   * @generated
   */
  BitStringUnaryExpression createBitStringUnaryExpression();

  /**
   * Returns a new object of class '<em>Numeric Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numeric Unary Expression</em>'.
   * @generated
   */
  NumericUnaryExpression createNumericUnaryExpression();

  /**
   * Returns a new object of class '<em>Isolation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Isolation Expression</em>'.
   * @generated
   */
  IsolationExpression createIsolationExpression();

  /**
   * Returns a new object of class '<em>Cast Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cast Expression</em>'.
   * @generated
   */
  CastExpression createCastExpression();

  /**
   * Returns a new object of class '<em>Assignment Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Expression</em>'.
   * @generated
   */
  AssignmentExpression createAssignmentExpression();

  /**
   * Returns a new object of class '<em>Left Hand Side</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Left Hand Side</em>'.
   * @generated
   */
  LeftHandSide createLeftHandSide();

  /**
   * Returns a new object of class '<em>Name Left Hand Side</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name Left Hand Side</em>'.
   * @generated
   */
  NameLeftHandSide createNameLeftHandSide();

  /**
   * Returns a new object of class '<em>Feature Left Hand Side</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature Left Hand Side</em>'.
   * @generated
   */
  FeatureLeftHandSide createFeatureLeftHandSide();

  /**
   * Returns a new object of class '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement</em>'.
   * @generated
   */
  Statement createStatement();

  /**
   * Returns a new object of class '<em>Simple Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Statement</em>'.
   * @generated
   */
  SimpleStatement createSimpleStatement();

  /**
   * Returns a new object of class '<em>Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Block</em>'.
   * @generated
   */
  Block createBlock();

  /**
   * Returns a new object of class '<em>Block Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Block Statement</em>'.
   * @generated
   */
  BlockStatement createBlockStatement();

  /**
   * Returns a new object of class '<em>Empty Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Empty Statement</em>'.
   * @generated
   */
  EmptyStatement createEmptyStatement();

  /**
   * Returns a new object of class '<em>Local Name Declaration Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Local Name Declaration Statement</em>'.
   * @generated
   */
  LocalNameDeclarationStatement createLocalNameDeclarationStatement();

  /**
   * Returns a new object of class '<em>Instance Creation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Creation Expression</em>'.
   * @generated
   */
  InstanceCreationExpression createInstanceCreationExpression();

  /**
   * Returns a new object of class '<em>Expression Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Statement</em>'.
   * @generated
   */
  ExpressionStatement createExpressionStatement();

  /**
   * Returns a new object of class '<em>If Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Statement</em>'.
   * @generated
   */
  IfStatement createIfStatement();

  /**
   * Returns a new object of class '<em>Concurrent Clauses</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Concurrent Clauses</em>'.
   * @generated
   */
  ConcurrentClauses createConcurrentClauses();

  /**
   * Returns a new object of class '<em>Non Final Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Final Clause</em>'.
   * @generated
   */
  NonFinalClause createNonFinalClause();

  /**
   * Returns a new object of class '<em>Switch Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch Statement</em>'.
   * @generated
   */
  SwitchStatement createSwitchStatement();

  /**
   * Returns a new object of class '<em>Switch Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch Clause</em>'.
   * @generated
   */
  SwitchClause createSwitchClause();

  /**
   * Returns a new object of class '<em>While Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>While Statement</em>'.
   * @generated
   */
  WhileStatement createWhileStatement();

  /**
   * Returns a new object of class '<em>Do Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Do Statement</em>'.
   * @generated
   */
  DoStatement createDoStatement();

  /**
   * Returns a new object of class '<em>For Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For Statement</em>'.
   * @generated
   */
  ForStatement createForStatement();

  /**
   * Returns a new object of class '<em>For Each Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For Each Statement</em>'.
   * @generated
   */
  ForEachStatement createForEachStatement();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns a new object of class '<em>Break Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Break Statement</em>'.
   * @generated
   */
  BreakStatement createBreakStatement();

  /**
   * Returns a new object of class '<em>Return Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Return Statement</em>'.
   * @generated
   */
  ReturnStatement createReturnStatement();

  /**
   * Returns a new object of class '<em>Classify Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classify Statement</em>'.
   * @generated
   */
  ClassifyStatement createClassifyStatement();

  /**
   * Returns a new object of class '<em>Qualified Name List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Name List</em>'.
   * @generated
   */
  QualifiedNameList createQualifiedNameList();

  /**
   * Returns a new object of class '<em>Send Signal Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Send Signal Statement</em>'.
   * @generated
   */
  SendSignalStatement createSendSignalStatement();

  /**
   * Returns a new object of class '<em>Feature Invocation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature Invocation Expression</em>'.
   * @generated
   */
  FeatureInvocationExpression createFeatureInvocationExpression();

  /**
   * Returns a new object of class '<em>Association Access Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Access Expression</em>'.
   * @generated
   */
  AssociationAccessExpression createAssociationAccessExpression();

  /**
   * Returns a new object of class '<em>Sequence Access Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Access Expression</em>'.
   * @generated
   */
  SequenceAccessExpression createSequenceAccessExpression();

  /**
   * Returns a new object of class '<em>This Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>This Expression</em>'.
   * @generated
   */
  ThisExpression createThisExpression();

  /**
   * Returns a new object of class '<em>Element Collection Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element Collection Expression</em>'.
   * @generated
   */
  ElementCollectionExpression createElementCollectionExpression();

  /**
   * Returns a new object of class '<em>Prefix Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Prefix Expression</em>'.
   * @generated
   */
  PrefixExpression createPrefixExpression();

  /**
   * Returns a new object of class '<em>Postfix Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Expression</em>'.
   * @generated
   */
  PostfixExpression createPostfixExpression();

  /**
   * Returns a new object of class '<em>Arithmetic Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Arithmetic Expression</em>'.
   * @generated
   */
  ArithmeticExpression createArithmeticExpression();

  /**
   * Returns a new object of class '<em>Shift Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Shift Expression</em>'.
   * @generated
   */
  ShiftExpression createShiftExpression();

  /**
   * Returns a new object of class '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relational Expression</em>'.
   * @generated
   */
  RelationalExpression createRelationalExpression();

  /**
   * Returns a new object of class '<em>Classification Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classification Expression</em>'.
   * @generated
   */
  ClassificationExpression createClassificationExpression();

  /**
   * Returns a new object of class '<em>Equality Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Expression</em>'.
   * @generated
   */
  EqualityExpression createEqualityExpression();

  /**
   * Returns a new object of class '<em>Logical Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Expression</em>'.
   * @generated
   */
  LogicalExpression createLogicalExpression();

  /**
   * Returns a new object of class '<em>Conditional Logical Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Logical Expression</em>'.
   * @generated
   */
  ConditionalLogicalExpression createConditionalLogicalExpression();

  /**
   * Returns a new object of class '<em>Conditional Test Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Test Expression</em>'.
   * @generated
   */
  ConditionalTestExpression createConditionalTestExpression();

  /**
   * Returns a new object of class '<em>Loop Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Loop Variable</em>'.
   * @generated
   */
  LoopVariable createLoopVariable();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ReducedAlfLanguagePackage getReducedAlfLanguagePackage();

} //ReducedAlfLanguageFactory
