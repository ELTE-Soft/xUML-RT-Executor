/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.util;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.*;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage
 * @generated
 */
public class ReducedAlfLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ReducedAlfLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReducedAlfLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ReducedAlfLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ReducedAlfLanguagePackage.STATEMENTS:
      {
        Statements statements = (Statements)theEObject;
        T result = caseStatements(statements);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.LITERAL_EXPRESSION:
      {
        LiteralExpression literalExpression = (LiteralExpression)theEObject;
        T result = caseLiteralExpression(literalExpression);
        if (result == null) result = caseExpression(literalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.BOOLEAN_LITERAL_EXPRESSION:
      {
        BooleanLiteralExpression booleanLiteralExpression = (BooleanLiteralExpression)theEObject;
        T result = caseBooleanLiteralExpression(booleanLiteralExpression);
        if (result == null) result = caseLiteralExpression(booleanLiteralExpression);
        if (result == null) result = caseExpression(booleanLiteralExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.NATURAL_LITERAL_EXPRESSION:
      {
        NaturalLiteralExpression naturalLiteralExpression = (NaturalLiteralExpression)theEObject;
        T result = caseNaturalLiteralExpression(naturalLiteralExpression);
        if (result == null) result = caseLiteralExpression(naturalLiteralExpression);
        if (result == null) result = caseExpression(naturalLiteralExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.REAL_LITERAL_EXPRESSION:
      {
        RealLiteralExpression realLiteralExpression = (RealLiteralExpression)theEObject;
        T result = caseRealLiteralExpression(realLiteralExpression);
        if (result == null) result = caseLiteralExpression(realLiteralExpression);
        if (result == null) result = caseExpression(realLiteralExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.UNBOUNDED_LITERAL_EXPRESSION:
      {
        UnboundedLiteralExpression unboundedLiteralExpression = (UnboundedLiteralExpression)theEObject;
        T result = caseUnboundedLiteralExpression(unboundedLiteralExpression);
        if (result == null) result = caseLiteralExpression(unboundedLiteralExpression);
        if (result == null) result = caseExpression(unboundedLiteralExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.STRING_LITERAL_EXPRESSION:
      {
        StringLiteralExpression stringLiteralExpression = (StringLiteralExpression)theEObject;
        T result = caseStringLiteralExpression(stringLiteralExpression);
        if (result == null) result = caseLiteralExpression(stringLiteralExpression);
        if (result == null) result = caseExpression(stringLiteralExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.NAME_EXPRESSION:
      {
        NameExpression nameExpression = (NameExpression)theEObject;
        T result = caseNameExpression(nameExpression);
        if (result == null) result = caseExpression(nameExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.PROPERTY_ACCESS_EXPRESSION:
      {
        PropertyAccessExpression propertyAccessExpression = (PropertyAccessExpression)theEObject;
        T result = casePropertyAccessExpression(propertyAccessExpression);
        if (result == null) result = caseExpression(propertyAccessExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.TUPLE:
      {
        Tuple tuple = (Tuple)theEObject;
        T result = caseTuple(tuple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.EXPRESSION_LIST:
      {
        ExpressionList expressionList = (ExpressionList)theEObject;
        T result = caseExpressionList(expressionList);
        if (result == null) result = caseTuple(expressionList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.NAMED_TUPLE:
      {
        NamedTuple namedTuple = (NamedTuple)theEObject;
        T result = caseNamedTuple(namedTuple);
        if (result == null) result = caseTuple(namedTuple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.NAMED_EXPRESSION:
      {
        NamedExpression namedExpression = (NamedExpression)theEObject;
        T result = caseNamedExpression(namedExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.SUPER_INVOCATION_EXPRESSION:
      {
        SuperInvocationExpression superInvocationExpression = (SuperInvocationExpression)theEObject;
        T result = caseSuperInvocationExpression(superInvocationExpression);
        if (result == null) result = caseExpression(superInvocationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION:
      {
        LinkOperationExpression linkOperationExpression = (LinkOperationExpression)theEObject;
        T result = caseLinkOperationExpression(linkOperationExpression);
        if (result == null) result = caseExpression(linkOperationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.CLASS_EXTENT_EXPRESSION:
      {
        ClassExtentExpression classExtentExpression = (ClassExtentExpression)theEObject;
        T result = caseClassExtentExpression(classExtentExpression);
        if (result == null) result = caseExpression(classExtentExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.NULL_EXPRESSION:
      {
        NullExpression nullExpression = (NullExpression)theEObject;
        T result = caseNullExpression(nullExpression);
        if (result == null) result = caseExpression(nullExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.COLLECTION_LITERAL_EXPRESSION:
      {
        CollectionLiteralExpression collectionLiteralExpression = (CollectionLiteralExpression)theEObject;
        T result = caseCollectionLiteralExpression(collectionLiteralExpression);
        if (result == null) result = caseExpression(collectionLiteralExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.TYPE_DECLARATION:
      {
        TypeDeclaration typeDeclaration = (TypeDeclaration)theEObject;
        T result = caseTypeDeclaration(typeDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.BOOLEAN_UNARY_EXPRESSION:
      {
        BooleanUnaryExpression booleanUnaryExpression = (BooleanUnaryExpression)theEObject;
        T result = caseBooleanUnaryExpression(booleanUnaryExpression);
        if (result == null) result = caseExpression(booleanUnaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.BIT_STRING_UNARY_EXPRESSION:
      {
        BitStringUnaryExpression bitStringUnaryExpression = (BitStringUnaryExpression)theEObject;
        T result = caseBitStringUnaryExpression(bitStringUnaryExpression);
        if (result == null) result = caseExpression(bitStringUnaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.NUMERIC_UNARY_EXPRESSION:
      {
        NumericUnaryExpression numericUnaryExpression = (NumericUnaryExpression)theEObject;
        T result = caseNumericUnaryExpression(numericUnaryExpression);
        if (result == null) result = caseExpression(numericUnaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.ISOLATION_EXPRESSION:
      {
        IsolationExpression isolationExpression = (IsolationExpression)theEObject;
        T result = caseIsolationExpression(isolationExpression);
        if (result == null) result = caseExpression(isolationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.CAST_EXPRESSION:
      {
        CastExpression castExpression = (CastExpression)theEObject;
        T result = caseCastExpression(castExpression);
        if (result == null) result = caseExpression(castExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION:
      {
        AssignmentExpression assignmentExpression = (AssignmentExpression)theEObject;
        T result = caseAssignmentExpression(assignmentExpression);
        if (result == null) result = caseExpression(assignmentExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.LEFT_HAND_SIDE:
      {
        LeftHandSide leftHandSide = (LeftHandSide)theEObject;
        T result = caseLeftHandSide(leftHandSide);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.NAME_LEFT_HAND_SIDE:
      {
        NameLeftHandSide nameLeftHandSide = (NameLeftHandSide)theEObject;
        T result = caseNameLeftHandSide(nameLeftHandSide);
        if (result == null) result = caseLeftHandSide(nameLeftHandSide);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.FEATURE_LEFT_HAND_SIDE:
      {
        FeatureLeftHandSide featureLeftHandSide = (FeatureLeftHandSide)theEObject;
        T result = caseFeatureLeftHandSide(featureLeftHandSide);
        if (result == null) result = caseLeftHandSide(featureLeftHandSide);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.STATEMENT:
      {
        Statement statement = (Statement)theEObject;
        T result = caseStatement(statement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.SIMPLE_STATEMENT:
      {
        SimpleStatement simpleStatement = (SimpleStatement)theEObject;
        T result = caseSimpleStatement(simpleStatement);
        if (result == null) result = caseStatement(simpleStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.BLOCK:
      {
        Block block = (Block)theEObject;
        T result = caseBlock(block);
        if (result == null) result = caseBlockStatement(block);
        if (result == null) result = caseStatement(block);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.BLOCK_STATEMENT:
      {
        BlockStatement blockStatement = (BlockStatement)theEObject;
        T result = caseBlockStatement(blockStatement);
        if (result == null) result = caseStatement(blockStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.EMPTY_STATEMENT:
      {
        EmptyStatement emptyStatement = (EmptyStatement)theEObject;
        T result = caseEmptyStatement(emptyStatement);
        if (result == null) result = caseSimpleStatement(emptyStatement);
        if (result == null) result = caseStatement(emptyStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.LOCAL_NAME_DECLARATION_STATEMENT:
      {
        LocalNameDeclarationStatement localNameDeclarationStatement = (LocalNameDeclarationStatement)theEObject;
        T result = caseLocalNameDeclarationStatement(localNameDeclarationStatement);
        if (result == null) result = caseSimpleStatement(localNameDeclarationStatement);
        if (result == null) result = caseStatement(localNameDeclarationStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.INSTANCE_CREATION_EXPRESSION:
      {
        InstanceCreationExpression instanceCreationExpression = (InstanceCreationExpression)theEObject;
        T result = caseInstanceCreationExpression(instanceCreationExpression);
        if (result == null) result = caseExpression(instanceCreationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.EXPRESSION_STATEMENT:
      {
        ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
        T result = caseExpressionStatement(expressionStatement);
        if (result == null) result = caseSimpleStatement(expressionStatement);
        if (result == null) result = caseStatement(expressionStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.IF_STATEMENT:
      {
        IfStatement ifStatement = (IfStatement)theEObject;
        T result = caseIfStatement(ifStatement);
        if (result == null) result = caseStatement(ifStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.CONCURRENT_CLAUSES:
      {
        ConcurrentClauses concurrentClauses = (ConcurrentClauses)theEObject;
        T result = caseConcurrentClauses(concurrentClauses);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.NON_FINAL_CLAUSE:
      {
        NonFinalClause nonFinalClause = (NonFinalClause)theEObject;
        T result = caseNonFinalClause(nonFinalClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.SWITCH_STATEMENT:
      {
        SwitchStatement switchStatement = (SwitchStatement)theEObject;
        T result = caseSwitchStatement(switchStatement);
        if (result == null) result = caseStatement(switchStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.SWITCH_CLAUSE:
      {
        SwitchClause switchClause = (SwitchClause)theEObject;
        T result = caseSwitchClause(switchClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.WHILE_STATEMENT:
      {
        WhileStatement whileStatement = (WhileStatement)theEObject;
        T result = caseWhileStatement(whileStatement);
        if (result == null) result = caseStatement(whileStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.DO_STATEMENT:
      {
        DoStatement doStatement = (DoStatement)theEObject;
        T result = caseDoStatement(doStatement);
        if (result == null) result = caseStatement(doStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.FOR_STATEMENT:
      {
        ForStatement forStatement = (ForStatement)theEObject;
        T result = caseForStatement(forStatement);
        if (result == null) result = caseStatement(forStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.FOR_EACH_STATEMENT:
      {
        ForEachStatement forEachStatement = (ForEachStatement)theEObject;
        T result = caseForEachStatement(forEachStatement);
        if (result == null) result = caseStatement(forEachStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.VARIABLE:
      {
        Variable variable = (Variable)theEObject;
        T result = caseVariable(variable);
        if (result == null) result = caseNamedElement(variable);
        if (result == null) result = caseElement(variable);
        if (result == null) result = caseEModelElement(variable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.BREAK_STATEMENT:
      {
        BreakStatement breakStatement = (BreakStatement)theEObject;
        T result = caseBreakStatement(breakStatement);
        if (result == null) result = caseStatement(breakStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.RETURN_STATEMENT:
      {
        ReturnStatement returnStatement = (ReturnStatement)theEObject;
        T result = caseReturnStatement(returnStatement);
        if (result == null) result = caseStatement(returnStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT:
      {
        ClassifyStatement classifyStatement = (ClassifyStatement)theEObject;
        T result = caseClassifyStatement(classifyStatement);
        if (result == null) result = caseStatement(classifyStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.QUALIFIED_NAME_LIST:
      {
        QualifiedNameList qualifiedNameList = (QualifiedNameList)theEObject;
        T result = caseQualifiedNameList(qualifiedNameList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.SEND_SIGNAL_STATEMENT:
      {
        SendSignalStatement sendSignalStatement = (SendSignalStatement)theEObject;
        T result = caseSendSignalStatement(sendSignalStatement);
        if (result == null) result = caseStatement(sendSignalStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.FEATURE_INVOCATION_EXPRESSION:
      {
        FeatureInvocationExpression featureInvocationExpression = (FeatureInvocationExpression)theEObject;
        T result = caseFeatureInvocationExpression(featureInvocationExpression);
        if (result == null) result = caseExpression(featureInvocationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.ASSOCIATION_ACCESS_EXPRESSION:
      {
        AssociationAccessExpression associationAccessExpression = (AssociationAccessExpression)theEObject;
        T result = caseAssociationAccessExpression(associationAccessExpression);
        if (result == null) result = caseExpression(associationAccessExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.SEQUENCE_ACCESS_EXPRESSION:
      {
        SequenceAccessExpression sequenceAccessExpression = (SequenceAccessExpression)theEObject;
        T result = caseSequenceAccessExpression(sequenceAccessExpression);
        if (result == null) result = caseExpression(sequenceAccessExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.THIS_EXPRESSION:
      {
        ThisExpression thisExpression = (ThisExpression)theEObject;
        T result = caseThisExpression(thisExpression);
        if (result == null) result = caseExpression(thisExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION:
      {
        ElementCollectionExpression elementCollectionExpression = (ElementCollectionExpression)theEObject;
        T result = caseElementCollectionExpression(elementCollectionExpression);
        if (result == null) result = caseCollectionLiteralExpression(elementCollectionExpression);
        if (result == null) result = caseExpression(elementCollectionExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.PREFIX_EXPRESSION:
      {
        PrefixExpression prefixExpression = (PrefixExpression)theEObject;
        T result = casePrefixExpression(prefixExpression);
        if (result == null) result = caseExpression(prefixExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.POSTFIX_EXPRESSION:
      {
        PostfixExpression postfixExpression = (PostfixExpression)theEObject;
        T result = casePostfixExpression(postfixExpression);
        if (result == null) result = caseExpression(postfixExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.ARITHMETIC_EXPRESSION:
      {
        ArithmeticExpression arithmeticExpression = (ArithmeticExpression)theEObject;
        T result = caseArithmeticExpression(arithmeticExpression);
        if (result == null) result = caseExpression(arithmeticExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.SHIFT_EXPRESSION:
      {
        ShiftExpression shiftExpression = (ShiftExpression)theEObject;
        T result = caseShiftExpression(shiftExpression);
        if (result == null) result = caseExpression(shiftExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.RELATIONAL_EXPRESSION:
      {
        RelationalExpression relationalExpression = (RelationalExpression)theEObject;
        T result = caseRelationalExpression(relationalExpression);
        if (result == null) result = caseExpression(relationalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.CLASSIFICATION_EXPRESSION:
      {
        ClassificationExpression classificationExpression = (ClassificationExpression)theEObject;
        T result = caseClassificationExpression(classificationExpression);
        if (result == null) result = caseExpression(classificationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.EQUALITY_EXPRESSION:
      {
        EqualityExpression equalityExpression = (EqualityExpression)theEObject;
        T result = caseEqualityExpression(equalityExpression);
        if (result == null) result = caseExpression(equalityExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.LOGICAL_EXPRESSION:
      {
        LogicalExpression logicalExpression = (LogicalExpression)theEObject;
        T result = caseLogicalExpression(logicalExpression);
        if (result == null) result = caseExpression(logicalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.CONDITIONAL_LOGICAL_EXPRESSION:
      {
        ConditionalLogicalExpression conditionalLogicalExpression = (ConditionalLogicalExpression)theEObject;
        T result = caseConditionalLogicalExpression(conditionalLogicalExpression);
        if (result == null) result = caseExpression(conditionalLogicalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.CONDITIONAL_TEST_EXPRESSION:
      {
        ConditionalTestExpression conditionalTestExpression = (ConditionalTestExpression)theEObject;
        T result = caseConditionalTestExpression(conditionalTestExpression);
        if (result == null) result = caseExpression(conditionalTestExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReducedAlfLanguagePackage.LOOP_VARIABLE:
      {
        LoopVariable loopVariable = (LoopVariable)theEObject;
        T result = caseLoopVariable(loopVariable);
        if (result == null) result = caseVariable(loopVariable);
        if (result == null) result = caseNamedElement(loopVariable);
        if (result == null) result = caseElement(loopVariable);
        if (result == null) result = caseEModelElement(loopVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statements</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statements</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatements(Statements object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteralExpression(LiteralExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Literal Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanLiteralExpression(BooleanLiteralExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Natural Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Natural Literal Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNaturalLiteralExpression(NaturalLiteralExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Literal Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRealLiteralExpression(RealLiteralExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unbounded Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unbounded Literal Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnboundedLiteralExpression(UnboundedLiteralExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringLiteralExpression(StringLiteralExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameExpression(NameExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Access Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Access Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyAccessExpression(PropertyAccessExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTuple(Tuple object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionList(ExpressionList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Tuple</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Tuple</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedTuple(NamedTuple object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedExpression(NamedExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Super Invocation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Super Invocation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSuperInvocationExpression(SuperInvocationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Link Operation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Link Operation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLinkOperationExpression(LinkOperationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Extent Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Extent Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassExtentExpression(ClassExtentExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Null Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Null Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNullExpression(NullExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collection Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collection Literal Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectionLiteralExpression(CollectionLiteralExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeDeclaration(TypeDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanUnaryExpression(BooleanUnaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bit String Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bit String Unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBitStringUnaryExpression(BitStringUnaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numeric Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numeric Unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericUnaryExpression(NumericUnaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Isolation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Isolation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIsolationExpression(IsolationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cast Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cast Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCastExpression(CastExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignment Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignmentExpression(AssignmentExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Left Hand Side</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Left Hand Side</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLeftHandSide(LeftHandSide object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name Left Hand Side</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Left Hand Side</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameLeftHandSide(NameLeftHandSide object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Left Hand Side</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Left Hand Side</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureLeftHandSide(FeatureLeftHandSide object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatement(Statement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleStatement(SimpleStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlock(Block object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlockStatement(BlockStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Empty Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Empty Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEmptyStatement(EmptyStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Local Name Declaration Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Local Name Declaration Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLocalNameDeclarationStatement(LocalNameDeclarationStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Creation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Creation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstanceCreationExpression(InstanceCreationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionStatement(ExpressionStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfStatement(IfStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Concurrent Clauses</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Concurrent Clauses</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConcurrentClauses(ConcurrentClauses object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Final Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Final Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonFinalClause(NonFinalClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSwitchStatement(SwitchStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Switch Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Switch Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSwitchClause(SwitchClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhileStatement(WhileStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Do Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Do Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDoStatement(DoStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForStatement(ForStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>For Each Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>For Each Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForEachStatement(ForEachStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariable(Variable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Break Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Break Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBreakStatement(BreakStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Return Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Return Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReturnStatement(ReturnStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classify Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classify Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifyStatement(ClassifyStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Name List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Name List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedNameList(QualifiedNameList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Send Signal Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Send Signal Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSendSignalStatement(SendSignalStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Invocation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Invocation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureInvocationExpression(FeatureInvocationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association Access Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association Access Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociationAccessExpression(AssociationAccessExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Access Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Access Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSequenceAccessExpression(SequenceAccessExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>This Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>This Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThisExpression(ThisExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element Collection Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element Collection Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElementCollectionExpression(ElementCollectionExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Prefix Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Prefix Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrefixExpression(PrefixExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostfixExpression(PostfixExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arithmetic Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arithmetic Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArithmeticExpression(ArithmeticExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Shift Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Shift Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShiftExpression(ShiftExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationalExpression(RelationalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classification Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classification Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassificationExpression(ClassificationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualityExpression(EqualityExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalExpression(LogicalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Logical Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Logical Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalLogicalExpression(ConditionalLogicalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Test Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Test Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalTestExpression(ConditionalTestExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Loop Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Loop Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoopVariable(LoopVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEModelElement(EModelElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ReducedAlfLanguageSwitch
