/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface ReducedAlfLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "reducedAlfLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.incquerylabs.com/uml/ralf/ReducedAlfLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "reducedAlfLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ReducedAlfLanguagePackage eINSTANCE = com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.StatementsImpl <em>Statements</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.StatementsImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getStatements()
   * @generated
   */
  int STATEMENTS = 0;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENTS__STATEMENT = 0;

  /**
   * The number of structural features of the '<em>Statements</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENTS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LiteralExpressionImpl <em>Literal Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LiteralExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLiteralExpression()
   * @generated
   */
  int LITERAL_EXPRESSION = 2;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BooleanLiteralExpressionImpl <em>Boolean Literal Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BooleanLiteralExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getBooleanLiteralExpression()
   * @generated
   */
  int BOOLEAN_LITERAL_EXPRESSION = 3;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_EXPRESSION__VALUE = LITERAL_EXPRESSION__VALUE;

  /**
   * The number of structural features of the '<em>Boolean Literal Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NaturalLiteralExpressionImpl <em>Natural Literal Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NaturalLiteralExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNaturalLiteralExpression()
   * @generated
   */
  int NATURAL_LITERAL_EXPRESSION = 4;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATURAL_LITERAL_EXPRESSION__VALUE = LITERAL_EXPRESSION__VALUE;

  /**
   * The number of structural features of the '<em>Natural Literal Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATURAL_LITERAL_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.RealLiteralExpressionImpl <em>Real Literal Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.RealLiteralExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getRealLiteralExpression()
   * @generated
   */
  int REAL_LITERAL_EXPRESSION = 5;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_EXPRESSION__VALUE = LITERAL_EXPRESSION__VALUE;

  /**
   * The number of structural features of the '<em>Real Literal Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.UnboundedLiteralExpressionImpl <em>Unbounded Literal Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.UnboundedLiteralExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getUnboundedLiteralExpression()
   * @generated
   */
  int UNBOUNDED_LITERAL_EXPRESSION = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNBOUNDED_LITERAL_EXPRESSION__VALUE = LITERAL_EXPRESSION__VALUE;

  /**
   * The number of structural features of the '<em>Unbounded Literal Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNBOUNDED_LITERAL_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.StringLiteralExpressionImpl <em>String Literal Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.StringLiteralExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getStringLiteralExpression()
   * @generated
   */
  int STRING_LITERAL_EXPRESSION = 7;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_EXPRESSION__VALUE = LITERAL_EXPRESSION__VALUE;

  /**
   * The number of structural features of the '<em>String Literal Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NameExpressionImpl <em>Name Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NameExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNameExpression()
   * @generated
   */
  int NAME_EXPRESSION = 8;

  /**
   * The feature id for the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_EXPRESSION__REFERENCE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Name Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.PropertyAccessExpressionImpl <em>Property Access Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.PropertyAccessExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getPropertyAccessExpression()
   * @generated
   */
  int PROPERTY_ACCESS_EXPRESSION = 9;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ACCESS_EXPRESSION__CONTEXT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ACCESS_EXPRESSION__PROPERTY = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Property Access Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ACCESS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.TupleImpl <em>Tuple</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.TupleImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getTuple()
   * @generated
   */
  int TUPLE = 10;

  /**
   * The number of structural features of the '<em>Tuple</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ExpressionListImpl <em>Expression List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ExpressionListImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getExpressionList()
   * @generated
   */
  int EXPRESSION_LIST = 11;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST__EXPRESSIONS = TUPLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST_FEATURE_COUNT = TUPLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NamedTupleImpl <em>Named Tuple</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NamedTupleImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNamedTuple()
   * @generated
   */
  int NAMED_TUPLE = 12;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TUPLE__EXPRESSIONS = TUPLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Named Tuple</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TUPLE_FEATURE_COUNT = TUPLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NamedExpressionImpl <em>Named Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NamedExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNamedExpression()
   * @generated
   */
  int NAMED_EXPRESSION = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_EXPRESSION__NAME = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_EXPRESSION__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Named Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SuperInvocationExpressionImpl <em>Super Invocation Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SuperInvocationExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getSuperInvocationExpression()
   * @generated
   */
  int SUPER_INVOCATION_EXPRESSION = 14;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPER_INVOCATION_EXPRESSION__TARGET = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Tuple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPER_INVOCATION_EXPRESSION__TUPLE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Super Invocation Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPER_INVOCATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LinkOperationExpressionImpl <em>Link Operation Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LinkOperationExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLinkOperationExpression()
   * @generated
   */
  int LINK_OPERATION_EXPRESSION = 15;

  /**
   * The feature id for the '<em><b>Association</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_OPERATION_EXPRESSION__ASSOCIATION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_OPERATION_EXPRESSION__OPERATION = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Tuple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_OPERATION_EXPRESSION__TUPLE = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Link Operation Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_OPERATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassExtentExpressionImpl <em>Class Extent Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassExtentExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getClassExtentExpression()
   * @generated
   */
  int CLASS_EXTENT_EXPRESSION = 16;

  /**
   * The feature id for the '<em><b>Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_EXTENT_EXPRESSION__CLASS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Class Extent Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_EXTENT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NullExpressionImpl <em>Null Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NullExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNullExpression()
   * @generated
   */
  int NULL_EXPRESSION = 17;

  /**
   * The number of structural features of the '<em>Null Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.CollectionLiteralExpressionImpl <em>Collection Literal Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.CollectionLiteralExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getCollectionLiteralExpression()
   * @generated
   */
  int COLLECTION_LITERAL_EXPRESSION = 18;

  /**
   * The number of structural features of the '<em>Collection Literal Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.TypeDeclarationImpl <em>Type Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.TypeDeclarationImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getTypeDeclaration()
   * @generated
   */
  int TYPE_DECLARATION = 19;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECLARATION__TYPE = 0;

  /**
   * The number of structural features of the '<em>Type Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BooleanUnaryExpressionImpl <em>Boolean Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BooleanUnaryExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getBooleanUnaryExpression()
   * @generated
   */
  int BOOLEAN_UNARY_EXPRESSION = 20;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_UNARY_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_UNARY_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Boolean Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BitStringUnaryExpressionImpl <em>Bit String Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BitStringUnaryExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getBitStringUnaryExpression()
   * @generated
   */
  int BIT_STRING_UNARY_EXPRESSION = 21;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIT_STRING_UNARY_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIT_STRING_UNARY_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Bit String Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIT_STRING_UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NumericUnaryExpressionImpl <em>Numeric Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NumericUnaryExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNumericUnaryExpression()
   * @generated
   */
  int NUMERIC_UNARY_EXPRESSION = 22;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_UNARY_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_UNARY_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Numeric Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.IsolationExpressionImpl <em>Isolation Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.IsolationExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getIsolationExpression()
   * @generated
   */
  int ISOLATION_EXPRESSION = 23;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISOLATION_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISOLATION_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Isolation Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISOLATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.CastExpressionImpl <em>Cast Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.CastExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getCastExpression()
   * @generated
   */
  int CAST_EXPRESSION = 24;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION__TYPE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Cast Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.AssignmentExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getAssignmentExpression()
   * @generated
   */
  int ASSIGNMENT_EXPRESSION = 25;

  /**
   * The feature id for the '<em><b>Left Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Assignment Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LeftHandSideImpl <em>Left Hand Side</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LeftHandSideImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLeftHandSide()
   * @generated
   */
  int LEFT_HAND_SIDE = 26;

  /**
   * The number of structural features of the '<em>Left Hand Side</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEFT_HAND_SIDE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NameLeftHandSideImpl <em>Name Left Hand Side</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NameLeftHandSideImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNameLeftHandSide()
   * @generated
   */
  int NAME_LEFT_HAND_SIDE = 27;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_LEFT_HAND_SIDE__EXPRESSION = LEFT_HAND_SIDE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_LEFT_HAND_SIDE__INDEX = LEFT_HAND_SIDE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Name Left Hand Side</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_LEFT_HAND_SIDE_FEATURE_COUNT = LEFT_HAND_SIDE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.FeatureLeftHandSideImpl <em>Feature Left Hand Side</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.FeatureLeftHandSideImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getFeatureLeftHandSide()
   * @generated
   */
  int FEATURE_LEFT_HAND_SIDE = 28;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_LEFT_HAND_SIDE__EXPRESSION = LEFT_HAND_SIDE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Feature Left Hand Side</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_LEFT_HAND_SIDE_FEATURE_COUNT = LEFT_HAND_SIDE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.StatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 29;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SimpleStatementImpl <em>Simple Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SimpleStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getSimpleStatement()
   * @generated
   */
  int SIMPLE_STATEMENT = 30;

  /**
   * The number of structural features of the '<em>Simple Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BlockStatementImpl <em>Block Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BlockStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getBlockStatement()
   * @generated
   */
  int BLOCK_STATEMENT = 32;

  /**
   * The number of structural features of the '<em>Block Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BlockImpl <em>Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BlockImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getBlock()
   * @generated
   */
  int BLOCK = 31;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__STATEMENT = BLOCK_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_FEATURE_COUNT = BLOCK_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.EmptyStatementImpl <em>Empty Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.EmptyStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getEmptyStatement()
   * @generated
   */
  int EMPTY_STATEMENT = 33;

  /**
   * The number of structural features of the '<em>Empty Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPTY_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LocalNameDeclarationStatementImpl <em>Local Name Declaration Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LocalNameDeclarationStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLocalNameDeclarationStatement()
   * @generated
   */
  int LOCAL_NAME_DECLARATION_STATEMENT = 34;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_NAME_DECLARATION_STATEMENT__VARIABLE = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_NAME_DECLARATION_STATEMENT__EXPRESSION = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Local Name Declaration Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_NAME_DECLARATION_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.InstanceCreationExpressionImpl <em>Instance Creation Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.InstanceCreationExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getInstanceCreationExpression()
   * @generated
   */
  int INSTANCE_CREATION_EXPRESSION = 35;

  /**
   * The feature id for the '<em><b>Instance</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_CREATION_EXPRESSION__INSTANCE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Tuple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_CREATION_EXPRESSION__TUPLE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Instance Creation Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_CREATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ExpressionStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getExpressionStatement()
   * @generated
   */
  int EXPRESSION_STATEMENT = 36;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__EXPRESSION = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.IfStatementImpl <em>If Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.IfStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getIfStatement()
   * @generated
   */
  int IF_STATEMENT = 37;

  /**
   * The feature id for the '<em><b>Non Final Clauses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__NON_FINAL_CLAUSES = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Final Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__FINAL_CLAUSE = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>If Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConcurrentClausesImpl <em>Concurrent Clauses</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConcurrentClausesImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getConcurrentClauses()
   * @generated
   */
  int CONCURRENT_CLAUSES = 38;

  /**
   * The feature id for the '<em><b>Clause</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCURRENT_CLAUSES__CLAUSE = 0;

  /**
   * The number of structural features of the '<em>Concurrent Clauses</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCURRENT_CLAUSES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NonFinalClauseImpl <em>Non Final Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NonFinalClauseImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNonFinalClause()
   * @generated
   */
  int NON_FINAL_CLAUSE = 39;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_FINAL_CLAUSE__CONDITION = 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_FINAL_CLAUSE__BODY = 1;

  /**
   * The number of structural features of the '<em>Non Final Clause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_FINAL_CLAUSE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SwitchStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getSwitchStatement()
   * @generated
   */
  int SWITCH_STATEMENT = 40;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Non Default Clause</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_STATEMENT__NON_DEFAULT_CLAUSE = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Default Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_STATEMENT__DEFAULT_CLAUSE = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Switch Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SwitchClauseImpl <em>Switch Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SwitchClauseImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getSwitchClause()
   * @generated
   */
  int SWITCH_CLAUSE = 41;

  /**
   * The feature id for the '<em><b>Case</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_CLAUSE__CASE = 0;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_CLAUSE__BLOCK = 1;

  /**
   * The number of structural features of the '<em>Switch Clause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_CLAUSE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.WhileStatementImpl <em>While Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.WhileStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getWhileStatement()
   * @generated
   */
  int WHILE_STATEMENT = 42;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>While Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.DoStatementImpl <em>Do Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.DoStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getDoStatement()
   * @generated
   */
  int DO_STATEMENT = 43;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Do Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ForStatementImpl <em>For Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ForStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getForStatement()
   * @generated
   */
  int FOR_STATEMENT = 44;

  /**
   * The feature id for the '<em><b>Initialization</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__INITIALIZATION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Update</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__UPDATE = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>For Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ForEachStatementImpl <em>For Each Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ForEachStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getForEachStatement()
   * @generated
   */
  int FOR_EACH_STATEMENT = 45;

  /**
   * The feature id for the '<em><b>Variable Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_EACH_STATEMENT__VARIABLE_DEFINITION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_EACH_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>For Each Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_EACH_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.VariableImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 46;

  /**
   * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__EANNOTATIONS = UMLPackage.NAMED_ELEMENT__EANNOTATIONS;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__OWNED_COMMENT = UMLPackage.NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__OWNED_ELEMENT = UMLPackage.NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__OWNER = UMLPackage.NAMED_ELEMENT__OWNER;

  /**
   * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__CLIENT_DEPENDENCY = UMLPackage.NAMED_ELEMENT__CLIENT_DEPENDENCY;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = UMLPackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME_EXPRESSION = UMLPackage.NAMED_ELEMENT__NAME_EXPRESSION;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAMESPACE = UMLPackage.NAMED_ELEMENT__NAMESPACE;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__QUALIFIED_NAME = UMLPackage.NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__VISIBILITY = UMLPackage.NAMED_ELEMENT__VISIBILITY;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__TYPE = UMLPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Has Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__HAS_MULTIPLICITY = UMLPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = UMLPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BreakStatementImpl <em>Break Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BreakStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getBreakStatement()
   * @generated
   */
  int BREAK_STATEMENT = 47;

  /**
   * The number of structural features of the '<em>Break Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReturnStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getReturnStatement()
   * @generated
   */
  int RETURN_STATEMENT = 48;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Return Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassifyStatementImpl <em>Classify Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassifyStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getClassifyStatement()
   * @generated
   */
  int CLASSIFY_STATEMENT = 49;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFY_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>From List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFY_STATEMENT__FROM_LIST = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>To List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFY_STATEMENT__TO_LIST = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Is Reclassify All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFY_STATEMENT__IS_RECLASSIFY_ALL = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Classify Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFY_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.QualifiedNameListImpl <em>Qualified Name List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.QualifiedNameListImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getQualifiedNameList()
   * @generated
   */
  int QUALIFIED_NAME_LIST = 50;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME_LIST__NAME = 0;

  /**
   * The number of structural features of the '<em>Qualified Name List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SendSignalStatementImpl <em>Send Signal Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SendSignalStatementImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getSendSignalStatement()
   * @generated
   */
  int SEND_SIGNAL_STATEMENT = 51;

  /**
   * The feature id for the '<em><b>Signal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEND_SIGNAL_STATEMENT__SIGNAL = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEND_SIGNAL_STATEMENT__TARGET = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Send Signal Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEND_SIGNAL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.FeatureInvocationExpressionImpl <em>Feature Invocation Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.FeatureInvocationExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getFeatureInvocationExpression()
   * @generated
   */
  int FEATURE_INVOCATION_EXPRESSION = 52;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_INVOCATION_EXPRESSION__CONTEXT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Is Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_INVOCATION_EXPRESSION__IS_STATIC = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_INVOCATION_EXPRESSION__OPERATION = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_INVOCATION_EXPRESSION__PARAMETERS = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Tuple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_INVOCATION_EXPRESSION__TUPLE = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Feature Invocation Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_INVOCATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.AssociationAccessExpressionImpl <em>Association Access Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.AssociationAccessExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getAssociationAccessExpression()
   * @generated
   */
  int ASSOCIATION_ACCESS_EXPRESSION = 53;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_ACCESS_EXPRESSION__CONTEXT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Association</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_ACCESS_EXPRESSION__ASSOCIATION = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Association Access Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_ACCESS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SequenceAccessExpressionImpl <em>Sequence Access Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SequenceAccessExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getSequenceAccessExpression()
   * @generated
   */
  int SEQUENCE_ACCESS_EXPRESSION = 54;

  /**
   * The feature id for the '<em><b>Primary</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_ACCESS_EXPRESSION__PRIMARY = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_ACCESS_EXPRESSION__INDEX = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Sequence Access Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_ACCESS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ThisExpressionImpl <em>This Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ThisExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getThisExpression()
   * @generated
   */
  int THIS_EXPRESSION = 55;

  /**
   * The number of structural features of the '<em>This Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ElementCollectionExpressionImpl <em>Element Collection Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ElementCollectionExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getElementCollectionExpression()
   * @generated
   */
  int ELEMENT_COLLECTION_EXPRESSION = 56;

  /**
   * The feature id for the '<em><b>Collection Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_COLLECTION_EXPRESSION__COLLECTION_TYPE = COLLECTION_LITERAL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_COLLECTION_EXPRESSION__TYPE_DECLARATION = COLLECTION_LITERAL_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_COLLECTION_EXPRESSION__ELEMENTS = COLLECTION_LITERAL_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Element Collection Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_COLLECTION_EXPRESSION_FEATURE_COUNT = COLLECTION_LITERAL_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.PrefixExpressionImpl <em>Prefix Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.PrefixExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getPrefixExpression()
   * @generated
   */
  int PREFIX_EXPRESSION = 57;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Prefix Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.PostfixExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getPostfixExpression()
   * @generated
   */
  int POSTFIX_EXPRESSION = 58;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Postfix Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ArithmeticExpressionImpl <em>Arithmetic Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ArithmeticExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getArithmeticExpression()
   * @generated
   */
  int ARITHMETIC_EXPRESSION = 59;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARITHMETIC_EXPRESSION__OPERAND1 = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARITHMETIC_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARITHMETIC_EXPRESSION__OPERAND2 = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Arithmetic Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARITHMETIC_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ShiftExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getShiftExpression()
   * @generated
   */
  int SHIFT_EXPRESSION = 60;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__OPERAND1 = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__OPERAND2 = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Shift Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.RelationalExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 61;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OPERAND1 = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OPERAND2 = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassificationExpressionImpl <em>Classification Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassificationExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getClassificationExpression()
   * @generated
   */
  int CLASSIFICATION_EXPRESSION = 62;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION_EXPRESSION__TYPE = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Classification Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.EqualityExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getEqualityExpression()
   * @generated
   */
  int EQUALITY_EXPRESSION = 63;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__OPERAND1 = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__OPERAND2 = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Equality Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LogicalExpressionImpl <em>Logical Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LogicalExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLogicalExpression()
   * @generated
   */
  int LOGICAL_EXPRESSION = 64;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION__OPERAND1 = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION__OPERAND2 = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Logical Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConditionalLogicalExpressionImpl <em>Conditional Logical Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConditionalLogicalExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getConditionalLogicalExpression()
   * @generated
   */
  int CONDITIONAL_LOGICAL_EXPRESSION = 65;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_LOGICAL_EXPRESSION__OPERAND1 = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_LOGICAL_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_LOGICAL_EXPRESSION__OPERAND2 = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Conditional Logical Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_LOGICAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConditionalTestExpressionImpl <em>Conditional Test Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConditionalTestExpressionImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getConditionalTestExpression()
   * @generated
   */
  int CONDITIONAL_TEST_EXPRESSION = 66;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_TEST_EXPRESSION__OPERAND1 = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_TEST_EXPRESSION__OPERAND2 = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Operand3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_TEST_EXPRESSION__OPERAND3 = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Conditional Test Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_TEST_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LoopVariableImpl <em>Loop Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LoopVariableImpl
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLoopVariable()
   * @generated
   */
  int LOOP_VARIABLE = 67;

  /**
   * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__EANNOTATIONS = VARIABLE__EANNOTATIONS;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__OWNED_COMMENT = VARIABLE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__OWNED_ELEMENT = VARIABLE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__OWNER = VARIABLE__OWNER;

  /**
   * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__CLIENT_DEPENDENCY = VARIABLE__CLIENT_DEPENDENCY;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__NAME = VARIABLE__NAME;

  /**
   * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__NAME_EXPRESSION = VARIABLE__NAME_EXPRESSION;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__NAMESPACE = VARIABLE__NAMESPACE;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__QUALIFIED_NAME = VARIABLE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__VISIBILITY = VARIABLE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__TYPE = VARIABLE__TYPE;

  /**
   * The feature id for the '<em><b>Has Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__HAS_MULTIPLICITY = VARIABLE__HAS_MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__EXPRESSION = VARIABLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Loop Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperation <em>Link Operation</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperation
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLinkOperation()
   * @generated
   */
  int LINK_OPERATION = 68;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType <em>Collection Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getCollectionType()
   * @generated
   */
  int COLLECTION_TYPE = 69;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator <em>Affix Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getAffixOperator()
   * @generated
   */
  int AFFIX_OPERATOR = 70;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator <em>Numeric Unary Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNumericUnaryOperator()
   * @generated
   */
  int NUMERIC_UNARY_OPERATOR = 71;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftOperator <em>Shift Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftOperator
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getShiftOperator()
   * @generated
   */
  int SHIFT_OPERATOR = 72;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalOperator
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getRelationalOperator()
   * @generated
   */
  int RELATIONAL_OPERATOR = 73;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationOperator <em>Classification Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationOperator
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getClassificationOperator()
   * @generated
   */
  int CLASSIFICATION_OPERATOR = 74;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityOperator <em>Equality Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityOperator
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getEqualityOperator()
   * @generated
   */
  int EQUALITY_OPERATOR = 75;

  /**
   * The meta object id for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentOperator <em>Assignment Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentOperator
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getAssignmentOperator()
   * @generated
   */
  int ASSIGNMENT_OPERATOR = 76;


  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statements</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements
   * @generated
   */
  EClass getStatements();

  /**
   * Returns the meta object for the containment reference list '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements#getStatement()
   * @see #getStatements()
   * @generated
   */
  EReference getStatements_Statement();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression <em>Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression
   * @generated
   */
  EClass getLiteralExpression();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression#getValue()
   * @see #getLiteralExpression()
   * @generated
   */
  EAttribute getLiteralExpression_Value();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanLiteralExpression <em>Boolean Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanLiteralExpression
   * @generated
   */
  EClass getBooleanLiteralExpression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NaturalLiteralExpression <em>Natural Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Natural Literal Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NaturalLiteralExpression
   * @generated
   */
  EClass getNaturalLiteralExpression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.RealLiteralExpression <em>Real Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Literal Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.RealLiteralExpression
   * @generated
   */
  EClass getRealLiteralExpression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.UnboundedLiteralExpression <em>Unbounded Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unbounded Literal Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.UnboundedLiteralExpression
   * @generated
   */
  EClass getUnboundedLiteralExpression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.StringLiteralExpression <em>String Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.StringLiteralExpression
   * @generated
   */
  EClass getStringLiteralExpression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NameExpression <em>Name Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NameExpression
   * @generated
   */
  EClass getNameExpression();

  /**
   * Returns the meta object for the reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NameExpression#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Reference</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NameExpression#getReference()
   * @see #getNameExpression()
   * @generated
   */
  EReference getNameExpression_Reference();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PropertyAccessExpression <em>Property Access Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Access Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.PropertyAccessExpression
   * @generated
   */
  EClass getPropertyAccessExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PropertyAccessExpression#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Context</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.PropertyAccessExpression#getContext()
   * @see #getPropertyAccessExpression()
   * @generated
   */
  EReference getPropertyAccessExpression_Context();

  /**
   * Returns the meta object for the reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PropertyAccessExpression#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.PropertyAccessExpression#getProperty()
   * @see #getPropertyAccessExpression()
   * @generated
   */
  EReference getPropertyAccessExpression_Property();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Tuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Tuple
   * @generated
   */
  EClass getTuple();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList <em>Expression List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression List</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList
   * @generated
   */
  EClass getExpressionList();

  /**
   * Returns the meta object for the containment reference list '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList#getExpressions()
   * @see #getExpressionList()
   * @generated
   */
  EReference getExpressionList_Expressions();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedTuple <em>Named Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Tuple</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedTuple
   * @generated
   */
  EClass getNamedTuple();

  /**
   * Returns the meta object for the containment reference list '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedTuple#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedTuple#getExpressions()
   * @see #getNamedTuple()
   * @generated
   */
  EReference getNamedTuple_Expressions();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedExpression <em>Named Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedExpression
   * @generated
   */
  EClass getNamedExpression();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedExpression#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedExpression#getName()
   * @see #getNamedExpression()
   * @generated
   */
  EAttribute getNamedExpression_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedExpression#getExpression()
   * @see #getNamedExpression()
   * @generated
   */
  EReference getNamedExpression_Expression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SuperInvocationExpression <em>Super Invocation Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Super Invocation Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SuperInvocationExpression
   * @generated
   */
  EClass getSuperInvocationExpression();

  /**
   * Returns the meta object for the reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SuperInvocationExpression#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SuperInvocationExpression#getTarget()
   * @see #getSuperInvocationExpression()
   * @generated
   */
  EReference getSuperInvocationExpression_Target();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SuperInvocationExpression#getTuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tuple</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SuperInvocationExpression#getTuple()
   * @see #getSuperInvocationExpression()
   * @generated
   */
  EReference getSuperInvocationExpression_Tuple();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression <em>Link Operation Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Link Operation Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression
   * @generated
   */
  EClass getLinkOperationExpression();

  /**
   * Returns the meta object for the reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Association</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression#getAssociation()
   * @see #getLinkOperationExpression()
   * @generated
   */
  EReference getLinkOperationExpression_Association();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operation</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression#getOperation()
   * @see #getLinkOperationExpression()
   * @generated
   */
  EAttribute getLinkOperationExpression_Operation();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression#getTuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tuple</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression#getTuple()
   * @see #getLinkOperationExpression()
   * @generated
   */
  EReference getLinkOperationExpression_Tuple();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassExtentExpression <em>Class Extent Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Extent Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassExtentExpression
   * @generated
   */
  EClass getClassExtentExpression();

  /**
   * Returns the meta object for the reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassExtentExpression#getClass_ <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Class</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassExtentExpression#getClass_()
   * @see #getClassExtentExpression()
   * @generated
   */
  EReference getClassExtentExpression_Class();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NullExpression <em>Null Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NullExpression
   * @generated
   */
  EClass getNullExpression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionLiteralExpression <em>Collection Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Literal Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionLiteralExpression
   * @generated
   */
  EClass getCollectionLiteralExpression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.TypeDeclaration <em>Type Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Declaration</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.TypeDeclaration
   * @generated
   */
  EClass getTypeDeclaration();

  /**
   * Returns the meta object for the reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.TypeDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.TypeDeclaration#getType()
   * @see #getTypeDeclaration()
   * @generated
   */
  EReference getTypeDeclaration_Type();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression <em>Boolean Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Unary Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression
   * @generated
   */
  EClass getBooleanUnaryExpression();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression#getOperator()
   * @see #getBooleanUnaryExpression()
   * @generated
   */
  EAttribute getBooleanUnaryExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression#getOperand()
   * @see #getBooleanUnaryExpression()
   * @generated
   */
  EReference getBooleanUnaryExpression_Operand();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BitStringUnaryExpression <em>Bit String Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bit String Unary Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BitStringUnaryExpression
   * @generated
   */
  EClass getBitStringUnaryExpression();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BitStringUnaryExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BitStringUnaryExpression#getOperator()
   * @see #getBitStringUnaryExpression()
   * @generated
   */
  EAttribute getBitStringUnaryExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BitStringUnaryExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BitStringUnaryExpression#getOperand()
   * @see #getBitStringUnaryExpression()
   * @generated
   */
  EReference getBitStringUnaryExpression_Operand();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression <em>Numeric Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numeric Unary Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression
   * @generated
   */
  EClass getNumericUnaryExpression();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression#getOperator()
   * @see #getNumericUnaryExpression()
   * @generated
   */
  EAttribute getNumericUnaryExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression#getOperand()
   * @see #getNumericUnaryExpression()
   * @generated
   */
  EReference getNumericUnaryExpression_Operand();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.IsolationExpression <em>Isolation Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Isolation Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.IsolationExpression
   * @generated
   */
  EClass getIsolationExpression();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.IsolationExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.IsolationExpression#getOperator()
   * @see #getIsolationExpression()
   * @generated
   */
  EAttribute getIsolationExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.IsolationExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.IsolationExpression#getOperand()
   * @see #getIsolationExpression()
   * @generated
   */
  EReference getIsolationExpression_Operand();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.CastExpression <em>Cast Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cast Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.CastExpression
   * @generated
   */
  EClass getCastExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.CastExpression#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.CastExpression#getType()
   * @see #getCastExpression()
   * @generated
   */
  EReference getCastExpression_Type();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.CastExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.CastExpression#getOperand()
   * @see #getCastExpression()
   * @generated
   */
  EReference getCastExpression_Operand();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression <em>Assignment Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression
   * @generated
   */
  EClass getAssignmentExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression#getLeftHandSide <em>Left Hand Side</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Hand Side</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression#getLeftHandSide()
   * @see #getAssignmentExpression()
   * @generated
   */
  EReference getAssignmentExpression_LeftHandSide();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression#getOperator()
   * @see #getAssignmentExpression()
   * @generated
   */
  EAttribute getAssignmentExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression#getRightHandSide <em>Right Hand Side</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Hand Side</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression#getRightHandSide()
   * @see #getAssignmentExpression()
   * @generated
   */
  EReference getAssignmentExpression_RightHandSide();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LeftHandSide <em>Left Hand Side</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Left Hand Side</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LeftHandSide
   * @generated
   */
  EClass getLeftHandSide();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NameLeftHandSide <em>Name Left Hand Side</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name Left Hand Side</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NameLeftHandSide
   * @generated
   */
  EClass getNameLeftHandSide();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NameLeftHandSide#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NameLeftHandSide#getExpression()
   * @see #getNameLeftHandSide()
   * @generated
   */
  EReference getNameLeftHandSide_Expression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NameLeftHandSide#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Index</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NameLeftHandSide#getIndex()
   * @see #getNameLeftHandSide()
   * @generated
   */
  EReference getNameLeftHandSide_Index();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureLeftHandSide <em>Feature Left Hand Side</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Left Hand Side</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureLeftHandSide
   * @generated
   */
  EClass getFeatureLeftHandSide();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureLeftHandSide#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureLeftHandSide#getExpression()
   * @see #getFeatureLeftHandSide()
   * @generated
   */
  EReference getFeatureLeftHandSide_Expression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SimpleStatement <em>Simple Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SimpleStatement
   * @generated
   */
  EClass getSimpleStatement();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Block
   * @generated
   */
  EClass getBlock();

  /**
   * Returns the meta object for the containment reference list '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Block#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Block#getStatement()
   * @see #getBlock()
   * @generated
   */
  EReference getBlock_Statement();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BlockStatement <em>Block Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BlockStatement
   * @generated
   */
  EClass getBlockStatement();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.EmptyStatement <em>Empty Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Empty Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.EmptyStatement
   * @generated
   */
  EClass getEmptyStatement();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement <em>Local Name Declaration Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Local Name Declaration Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement
   * @generated
   */
  EClass getLocalNameDeclarationStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement#getVariable()
   * @see #getLocalNameDeclarationStatement()
   * @generated
   */
  EReference getLocalNameDeclarationStatement_Variable();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement#getExpression()
   * @see #getLocalNameDeclarationStatement()
   * @generated
   */
  EReference getLocalNameDeclarationStatement_Expression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression <em>Instance Creation Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance Creation Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression
   * @generated
   */
  EClass getInstanceCreationExpression();

  /**
   * Returns the meta object for the reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression#getInstance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Instance</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression#getInstance()
   * @see #getInstanceCreationExpression()
   * @generated
   */
  EReference getInstanceCreationExpression_Instance();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression#getTuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tuple</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression#getTuple()
   * @see #getInstanceCreationExpression()
   * @generated
   */
  EReference getInstanceCreationExpression_Tuple();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionStatement <em>Expression Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionStatement
   * @generated
   */
  EClass getExpressionStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionStatement#getExpression()
   * @see #getExpressionStatement()
   * @generated
   */
  EReference getExpressionStatement_Expression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement
   * @generated
   */
  EClass getIfStatement();

  /**
   * Returns the meta object for the containment reference list '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement#getNonFinalClauses <em>Non Final Clauses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Non Final Clauses</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement#getNonFinalClauses()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_NonFinalClauses();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement#getFinalClause <em>Final Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Final Clause</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement#getFinalClause()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_FinalClause();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConcurrentClauses <em>Concurrent Clauses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Concurrent Clauses</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConcurrentClauses
   * @generated
   */
  EClass getConcurrentClauses();

  /**
   * Returns the meta object for the containment reference list '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConcurrentClauses#getClause <em>Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Clause</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConcurrentClauses#getClause()
   * @see #getConcurrentClauses()
   * @generated
   */
  EReference getConcurrentClauses_Clause();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NonFinalClause <em>Non Final Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Non Final Clause</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NonFinalClause
   * @generated
   */
  EClass getNonFinalClause();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NonFinalClause#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NonFinalClause#getCondition()
   * @see #getNonFinalClause()
   * @generated
   */
  EReference getNonFinalClause_Condition();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NonFinalClause#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NonFinalClause#getBody()
   * @see #getNonFinalClause()
   * @generated
   */
  EReference getNonFinalClause_Body();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement <em>Switch Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Switch Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement
   * @generated
   */
  EClass getSwitchStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement#getExpression()
   * @see #getSwitchStatement()
   * @generated
   */
  EReference getSwitchStatement_Expression();

  /**
   * Returns the meta object for the containment reference list '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement#getNonDefaultClause <em>Non Default Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Non Default Clause</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement#getNonDefaultClause()
   * @see #getSwitchStatement()
   * @generated
   */
  EReference getSwitchStatement_NonDefaultClause();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement#getDefaultClause <em>Default Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default Clause</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement#getDefaultClause()
   * @see #getSwitchStatement()
   * @generated
   */
  EReference getSwitchStatement_DefaultClause();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchClause <em>Switch Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Switch Clause</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchClause
   * @generated
   */
  EClass getSwitchClause();

  /**
   * Returns the meta object for the containment reference list '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchClause#getCase <em>Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Case</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchClause#getCase()
   * @see #getSwitchClause()
   * @generated
   */
  EReference getSwitchClause_Case();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchClause#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchClause#getBlock()
   * @see #getSwitchClause()
   * @generated
   */
  EReference getSwitchClause_Block();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement
   * @generated
   */
  EClass getWhileStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement#getCondition()
   * @see #getWhileStatement()
   * @generated
   */
  EReference getWhileStatement_Condition();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement#getBody()
   * @see #getWhileStatement()
   * @generated
   */
  EReference getWhileStatement_Body();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement <em>Do Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Do Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement
   * @generated
   */
  EClass getDoStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement#getBody()
   * @see #getDoStatement()
   * @generated
   */
  EReference getDoStatement_Body();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement#getCondition()
   * @see #getDoStatement()
   * @generated
   */
  EReference getDoStatement_Condition();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement <em>For Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>For Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement
   * @generated
   */
  EClass getForStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement#getInitialization <em>Initialization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initialization</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement#getInitialization()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_Initialization();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement#getCondition()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_Condition();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement#getUpdate <em>Update</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Update</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement#getUpdate()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_Update();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement#getBody()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_Body();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ForEachStatement <em>For Each Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>For Each Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ForEachStatement
   * @generated
   */
  EClass getForEachStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ForEachStatement#getVariableDefinition <em>Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable Definition</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ForEachStatement#getVariableDefinition()
   * @see #getForEachStatement()
   * @generated
   */
  EReference getForEachStatement_VariableDefinition();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ForEachStatement#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ForEachStatement#getBody()
   * @see #getForEachStatement()
   * @generated
   */
  EReference getForEachStatement_Body();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable#getType()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Type();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable#isHasMultiplicity <em>Has Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Has Multiplicity</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable#isHasMultiplicity()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_HasMultiplicity();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.BreakStatement <em>Break Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Break Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.BreakStatement
   * @generated
   */
  EClass getBreakStatement();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ReturnStatement <em>Return Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Return Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReturnStatement
   * @generated
   */
  EClass getReturnStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ReturnStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReturnStatement#getExpression()
   * @see #getReturnStatement()
   * @generated
   */
  EReference getReturnStatement_Expression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement <em>Classify Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classify Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement
   * @generated
   */
  EClass getClassifyStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#getExpression()
   * @see #getClassifyStatement()
   * @generated
   */
  EReference getClassifyStatement_Expression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#getFromList <em>From List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>From List</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#getFromList()
   * @see #getClassifyStatement()
   * @generated
   */
  EReference getClassifyStatement_FromList();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#getToList <em>To List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>To List</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#getToList()
   * @see #getClassifyStatement()
   * @generated
   */
  EReference getClassifyStatement_ToList();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#isIsReclassifyAll <em>Is Reclassify All</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Reclassify All</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#isIsReclassifyAll()
   * @see #getClassifyStatement()
   * @generated
   */
  EAttribute getClassifyStatement_IsReclassifyAll();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.QualifiedNameList <em>Qualified Name List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Name List</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.QualifiedNameList
   * @generated
   */
  EClass getQualifiedNameList();

  /**
   * Returns the meta object for the attribute list '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.QualifiedNameList#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.QualifiedNameList#getName()
   * @see #getQualifiedNameList()
   * @generated
   */
  EAttribute getQualifiedNameList_Name();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement <em>Send Signal Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Send Signal Statement</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement
   * @generated
   */
  EClass getSendSignalStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement#getSignal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Signal</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement#getSignal()
   * @see #getSendSignalStatement()
   * @generated
   */
  EReference getSendSignalStatement_Signal();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement#getTarget()
   * @see #getSendSignalStatement()
   * @generated
   */
  EReference getSendSignalStatement_Target();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression <em>Feature Invocation Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Invocation Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression
   * @generated
   */
  EClass getFeatureInvocationExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Context</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression#getContext()
   * @see #getFeatureInvocationExpression()
   * @generated
   */
  EReference getFeatureInvocationExpression_Context();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression#isIsStatic <em>Is Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Static</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression#isIsStatic()
   * @see #getFeatureInvocationExpression()
   * @generated
   */
  EAttribute getFeatureInvocationExpression_IsStatic();

  /**
   * Returns the meta object for the reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Operation</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression#getOperation()
   * @see #getFeatureInvocationExpression()
   * @generated
   */
  EReference getFeatureInvocationExpression_Operation();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameters</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression#getParameters()
   * @see #getFeatureInvocationExpression()
   * @generated
   */
  EReference getFeatureInvocationExpression_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression#getTuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tuple</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression#getTuple()
   * @see #getFeatureInvocationExpression()
   * @generated
   */
  EReference getFeatureInvocationExpression_Tuple();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AssociationAccessExpression <em>Association Access Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association Access Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AssociationAccessExpression
   * @generated
   */
  EClass getAssociationAccessExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AssociationAccessExpression#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Context</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AssociationAccessExpression#getContext()
   * @see #getAssociationAccessExpression()
   * @generated
   */
  EReference getAssociationAccessExpression_Context();

  /**
   * Returns the meta object for the reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AssociationAccessExpression#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Association</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AssociationAccessExpression#getAssociation()
   * @see #getAssociationAccessExpression()
   * @generated
   */
  EReference getAssociationAccessExpression_Association();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SequenceAccessExpression <em>Sequence Access Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sequence Access Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SequenceAccessExpression
   * @generated
   */
  EClass getSequenceAccessExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SequenceAccessExpression#getPrimary <em>Primary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Primary</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SequenceAccessExpression#getPrimary()
   * @see #getSequenceAccessExpression()
   * @generated
   */
  EReference getSequenceAccessExpression_Primary();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.SequenceAccessExpression#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Index</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.SequenceAccessExpression#getIndex()
   * @see #getSequenceAccessExpression()
   * @generated
   */
  EReference getSequenceAccessExpression_Index();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ThisExpression <em>This Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>This Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ThisExpression
   * @generated
   */
  EClass getThisExpression();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression <em>Element Collection Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Collection Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression
   * @generated
   */
  EClass getElementCollectionExpression();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression#getCollectionType <em>Collection Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Collection Type</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression#getCollectionType()
   * @see #getElementCollectionExpression()
   * @generated
   */
  EAttribute getElementCollectionExpression_CollectionType();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression#getTypeDeclaration <em>Type Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type Declaration</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression#getTypeDeclaration()
   * @see #getElementCollectionExpression()
   * @generated
   */
  EReference getElementCollectionExpression_TypeDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Elements</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression#getElements()
   * @see #getElementCollectionExpression()
   * @generated
   */
  EReference getElementCollectionExpression_Elements();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PrefixExpression <em>Prefix Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prefix Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.PrefixExpression
   * @generated
   */
  EClass getPrefixExpression();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PrefixExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.PrefixExpression#getOperator()
   * @see #getPrefixExpression()
   * @generated
   */
  EAttribute getPrefixExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PrefixExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.PrefixExpression#getOperand()
   * @see #getPrefixExpression()
   * @generated
   */
  EReference getPrefixExpression_Operand();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression <em>Postfix Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression
   * @generated
   */
  EClass getPostfixExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression#getOperand()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_Operand();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression#getOperator()
   * @see #getPostfixExpression()
   * @generated
   */
  EAttribute getPostfixExpression_Operator();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression <em>Arithmetic Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Arithmetic Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression
   * @generated
   */
  EClass getArithmeticExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression#getOperand1()
   * @see #getArithmeticExpression()
   * @generated
   */
  EReference getArithmeticExpression_Operand1();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression#getOperator()
   * @see #getArithmeticExpression()
   * @generated
   */
  EAttribute getArithmeticExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression#getOperand2()
   * @see #getArithmeticExpression()
   * @generated
   */
  EReference getArithmeticExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression <em>Shift Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shift Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression
   * @generated
   */
  EClass getShiftExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression#getOperand1()
   * @see #getShiftExpression()
   * @generated
   */
  EReference getShiftExpression_Operand1();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression#getOperator()
   * @see #getShiftExpression()
   * @generated
   */
  EAttribute getShiftExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression#getOperand2()
   * @see #getShiftExpression()
   * @generated
   */
  EReference getShiftExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalExpression
   * @generated
   */
  EClass getRelationalExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalExpression#getOperand1()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Operand1();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalExpression#getOperator()
   * @see #getRelationalExpression()
   * @generated
   */
  EAttribute getRelationalExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalExpression#getOperand2()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationExpression <em>Classification Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classification Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationExpression
   * @generated
   */
  EClass getClassificationExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationExpression#getOperand()
   * @see #getClassificationExpression()
   * @generated
   */
  EReference getClassificationExpression_Operand();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationExpression#getOperator()
   * @see #getClassificationExpression()
   * @generated
   */
  EAttribute getClassificationExpression_Operator();

  /**
   * Returns the meta object for the reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationExpression#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationExpression#getType()
   * @see #getClassificationExpression()
   * @generated
   */
  EReference getClassificationExpression_Type();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityExpression
   * @generated
   */
  EClass getEqualityExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityExpression#getOperand1()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Operand1();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityExpression#getOperator()
   * @see #getEqualityExpression()
   * @generated
   */
  EAttribute getEqualityExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityExpression#getOperand2()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression <em>Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression
   * @generated
   */
  EClass getLogicalExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression#getOperand1()
   * @see #getLogicalExpression()
   * @generated
   */
  EReference getLogicalExpression_Operand1();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression#getOperator()
   * @see #getLogicalExpression()
   * @generated
   */
  EAttribute getLogicalExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression#getOperand2()
   * @see #getLogicalExpression()
   * @generated
   */
  EReference getLogicalExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression <em>Conditional Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Logical Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression
   * @generated
   */
  EClass getConditionalLogicalExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression#getOperand1()
   * @see #getConditionalLogicalExpression()
   * @generated
   */
  EReference getConditionalLogicalExpression_Operand1();

  /**
   * Returns the meta object for the attribute '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression#getOperator()
   * @see #getConditionalLogicalExpression()
   * @generated
   */
  EAttribute getConditionalLogicalExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression#getOperand2()
   * @see #getConditionalLogicalExpression()
   * @generated
   */
  EReference getConditionalLogicalExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalTestExpression <em>Conditional Test Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Test Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalTestExpression
   * @generated
   */
  EClass getConditionalTestExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalTestExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalTestExpression#getOperand1()
   * @see #getConditionalTestExpression()
   * @generated
   */
  EReference getConditionalTestExpression_Operand1();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalTestExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalTestExpression#getOperand2()
   * @see #getConditionalTestExpression()
   * @generated
   */
  EReference getConditionalTestExpression_Operand2();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalTestExpression#getOperand3 <em>Operand3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand3</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalTestExpression#getOperand3()
   * @see #getConditionalTestExpression()
   * @generated
   */
  EReference getConditionalTestExpression_Operand3();

  /**
   * Returns the meta object for class '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LoopVariable <em>Loop Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop Variable</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LoopVariable
   * @generated
   */
  EClass getLoopVariable();

  /**
   * Returns the meta object for the containment reference '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LoopVariable#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LoopVariable#getExpression()
   * @see #getLoopVariable()
   * @generated
   */
  EReference getLoopVariable_Expression();

  /**
   * Returns the meta object for enum '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperation <em>Link Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Link Operation</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperation
   * @generated
   */
  EEnum getLinkOperation();

  /**
   * Returns the meta object for enum '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType <em>Collection Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Collection Type</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType
   * @generated
   */
  EEnum getCollectionType();

  /**
   * Returns the meta object for enum '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator <em>Affix Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Affix Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator
   * @generated
   */
  EEnum getAffixOperator();

  /**
   * Returns the meta object for enum '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator <em>Numeric Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Numeric Unary Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator
   * @generated
   */
  EEnum getNumericUnaryOperator();

  /**
   * Returns the meta object for enum '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftOperator <em>Shift Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Shift Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftOperator
   * @generated
   */
  EEnum getShiftOperator();

  /**
   * Returns the meta object for enum '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalOperator <em>Relational Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Relational Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalOperator
   * @generated
   */
  EEnum getRelationalOperator();

  /**
   * Returns the meta object for enum '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationOperator <em>Classification Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Classification Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationOperator
   * @generated
   */
  EEnum getClassificationOperator();

  /**
   * Returns the meta object for enum '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityOperator <em>Equality Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Equality Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityOperator
   * @generated
   */
  EEnum getEqualityOperator();

  /**
   * Returns the meta object for enum '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentOperator <em>Assignment Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Assignment Operator</em>'.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentOperator
   * @generated
   */
  EEnum getAssignmentOperator();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ReducedAlfLanguageFactory getReducedAlfLanguageFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.StatementsImpl <em>Statements</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.StatementsImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getStatements()
     * @generated
     */
    EClass STATEMENTS = eINSTANCE.getStatements();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENTS__STATEMENT = eINSTANCE.getStatements_Statement();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LiteralExpressionImpl <em>Literal Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LiteralExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLiteralExpression()
     * @generated
     */
    EClass LITERAL_EXPRESSION = eINSTANCE.getLiteralExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL_EXPRESSION__VALUE = eINSTANCE.getLiteralExpression_Value();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BooleanLiteralExpressionImpl <em>Boolean Literal Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BooleanLiteralExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getBooleanLiteralExpression()
     * @generated
     */
    EClass BOOLEAN_LITERAL_EXPRESSION = eINSTANCE.getBooleanLiteralExpression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NaturalLiteralExpressionImpl <em>Natural Literal Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NaturalLiteralExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNaturalLiteralExpression()
     * @generated
     */
    EClass NATURAL_LITERAL_EXPRESSION = eINSTANCE.getNaturalLiteralExpression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.RealLiteralExpressionImpl <em>Real Literal Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.RealLiteralExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getRealLiteralExpression()
     * @generated
     */
    EClass REAL_LITERAL_EXPRESSION = eINSTANCE.getRealLiteralExpression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.UnboundedLiteralExpressionImpl <em>Unbounded Literal Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.UnboundedLiteralExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getUnboundedLiteralExpression()
     * @generated
     */
    EClass UNBOUNDED_LITERAL_EXPRESSION = eINSTANCE.getUnboundedLiteralExpression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.StringLiteralExpressionImpl <em>String Literal Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.StringLiteralExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getStringLiteralExpression()
     * @generated
     */
    EClass STRING_LITERAL_EXPRESSION = eINSTANCE.getStringLiteralExpression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NameExpressionImpl <em>Name Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NameExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNameExpression()
     * @generated
     */
    EClass NAME_EXPRESSION = eINSTANCE.getNameExpression();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAME_EXPRESSION__REFERENCE = eINSTANCE.getNameExpression_Reference();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.PropertyAccessExpressionImpl <em>Property Access Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.PropertyAccessExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getPropertyAccessExpression()
     * @generated
     */
    EClass PROPERTY_ACCESS_EXPRESSION = eINSTANCE.getPropertyAccessExpression();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_ACCESS_EXPRESSION__CONTEXT = eINSTANCE.getPropertyAccessExpression_Context();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_ACCESS_EXPRESSION__PROPERTY = eINSTANCE.getPropertyAccessExpression_Property();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.TupleImpl <em>Tuple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.TupleImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getTuple()
     * @generated
     */
    EClass TUPLE = eINSTANCE.getTuple();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ExpressionListImpl <em>Expression List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ExpressionListImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getExpressionList()
     * @generated
     */
    EClass EXPRESSION_LIST = eINSTANCE.getExpressionList();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_LIST__EXPRESSIONS = eINSTANCE.getExpressionList_Expressions();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NamedTupleImpl <em>Named Tuple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NamedTupleImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNamedTuple()
     * @generated
     */
    EClass NAMED_TUPLE = eINSTANCE.getNamedTuple();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_TUPLE__EXPRESSIONS = eINSTANCE.getNamedTuple_Expressions();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NamedExpressionImpl <em>Named Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NamedExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNamedExpression()
     * @generated
     */
    EClass NAMED_EXPRESSION = eINSTANCE.getNamedExpression();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_EXPRESSION__NAME = eINSTANCE.getNamedExpression_Name();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_EXPRESSION__EXPRESSION = eINSTANCE.getNamedExpression_Expression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SuperInvocationExpressionImpl <em>Super Invocation Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SuperInvocationExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getSuperInvocationExpression()
     * @generated
     */
    EClass SUPER_INVOCATION_EXPRESSION = eINSTANCE.getSuperInvocationExpression();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPER_INVOCATION_EXPRESSION__TARGET = eINSTANCE.getSuperInvocationExpression_Target();

    /**
     * The meta object literal for the '<em><b>Tuple</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPER_INVOCATION_EXPRESSION__TUPLE = eINSTANCE.getSuperInvocationExpression_Tuple();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LinkOperationExpressionImpl <em>Link Operation Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LinkOperationExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLinkOperationExpression()
     * @generated
     */
    EClass LINK_OPERATION_EXPRESSION = eINSTANCE.getLinkOperationExpression();

    /**
     * The meta object literal for the '<em><b>Association</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINK_OPERATION_EXPRESSION__ASSOCIATION = eINSTANCE.getLinkOperationExpression_Association();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LINK_OPERATION_EXPRESSION__OPERATION = eINSTANCE.getLinkOperationExpression_Operation();

    /**
     * The meta object literal for the '<em><b>Tuple</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINK_OPERATION_EXPRESSION__TUPLE = eINSTANCE.getLinkOperationExpression_Tuple();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassExtentExpressionImpl <em>Class Extent Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassExtentExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getClassExtentExpression()
     * @generated
     */
    EClass CLASS_EXTENT_EXPRESSION = eINSTANCE.getClassExtentExpression();

    /**
     * The meta object literal for the '<em><b>Class</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_EXTENT_EXPRESSION__CLASS = eINSTANCE.getClassExtentExpression_Class();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NullExpressionImpl <em>Null Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NullExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNullExpression()
     * @generated
     */
    EClass NULL_EXPRESSION = eINSTANCE.getNullExpression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.CollectionLiteralExpressionImpl <em>Collection Literal Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.CollectionLiteralExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getCollectionLiteralExpression()
     * @generated
     */
    EClass COLLECTION_LITERAL_EXPRESSION = eINSTANCE.getCollectionLiteralExpression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.TypeDeclarationImpl <em>Type Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.TypeDeclarationImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getTypeDeclaration()
     * @generated
     */
    EClass TYPE_DECLARATION = eINSTANCE.getTypeDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DECLARATION__TYPE = eINSTANCE.getTypeDeclaration_Type();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BooleanUnaryExpressionImpl <em>Boolean Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BooleanUnaryExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getBooleanUnaryExpression()
     * @generated
     */
    EClass BOOLEAN_UNARY_EXPRESSION = eINSTANCE.getBooleanUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_UNARY_EXPRESSION__OPERATOR = eINSTANCE.getBooleanUnaryExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOLEAN_UNARY_EXPRESSION__OPERAND = eINSTANCE.getBooleanUnaryExpression_Operand();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BitStringUnaryExpressionImpl <em>Bit String Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BitStringUnaryExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getBitStringUnaryExpression()
     * @generated
     */
    EClass BIT_STRING_UNARY_EXPRESSION = eINSTANCE.getBitStringUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIT_STRING_UNARY_EXPRESSION__OPERATOR = eINSTANCE.getBitStringUnaryExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BIT_STRING_UNARY_EXPRESSION__OPERAND = eINSTANCE.getBitStringUnaryExpression_Operand();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NumericUnaryExpressionImpl <em>Numeric Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NumericUnaryExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNumericUnaryExpression()
     * @generated
     */
    EClass NUMERIC_UNARY_EXPRESSION = eINSTANCE.getNumericUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERIC_UNARY_EXPRESSION__OPERATOR = eINSTANCE.getNumericUnaryExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERIC_UNARY_EXPRESSION__OPERAND = eINSTANCE.getNumericUnaryExpression_Operand();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.IsolationExpressionImpl <em>Isolation Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.IsolationExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getIsolationExpression()
     * @generated
     */
    EClass ISOLATION_EXPRESSION = eINSTANCE.getIsolationExpression();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ISOLATION_EXPRESSION__OPERATOR = eINSTANCE.getIsolationExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ISOLATION_EXPRESSION__OPERAND = eINSTANCE.getIsolationExpression_Operand();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.CastExpressionImpl <em>Cast Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.CastExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getCastExpression()
     * @generated
     */
    EClass CAST_EXPRESSION = eINSTANCE.getCastExpression();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAST_EXPRESSION__TYPE = eINSTANCE.getCastExpression_Type();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAST_EXPRESSION__OPERAND = eINSTANCE.getCastExpression_Operand();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.AssignmentExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getAssignmentExpression()
     * @generated
     */
    EClass ASSIGNMENT_EXPRESSION = eINSTANCE.getAssignmentExpression();

    /**
     * The meta object literal for the '<em><b>Left Hand Side</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE = eINSTANCE.getAssignmentExpression_LeftHandSide();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT_EXPRESSION__OPERATOR = eINSTANCE.getAssignmentExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Right Hand Side</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE = eINSTANCE.getAssignmentExpression_RightHandSide();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LeftHandSideImpl <em>Left Hand Side</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LeftHandSideImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLeftHandSide()
     * @generated
     */
    EClass LEFT_HAND_SIDE = eINSTANCE.getLeftHandSide();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NameLeftHandSideImpl <em>Name Left Hand Side</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NameLeftHandSideImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNameLeftHandSide()
     * @generated
     */
    EClass NAME_LEFT_HAND_SIDE = eINSTANCE.getNameLeftHandSide();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAME_LEFT_HAND_SIDE__EXPRESSION = eINSTANCE.getNameLeftHandSide_Expression();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAME_LEFT_HAND_SIDE__INDEX = eINSTANCE.getNameLeftHandSide_Index();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.FeatureLeftHandSideImpl <em>Feature Left Hand Side</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.FeatureLeftHandSideImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getFeatureLeftHandSide()
     * @generated
     */
    EClass FEATURE_LEFT_HAND_SIDE = eINSTANCE.getFeatureLeftHandSide();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_LEFT_HAND_SIDE__EXPRESSION = eINSTANCE.getFeatureLeftHandSide_Expression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.StatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SimpleStatementImpl <em>Simple Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SimpleStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getSimpleStatement()
     * @generated
     */
    EClass SIMPLE_STATEMENT = eINSTANCE.getSimpleStatement();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BlockImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getBlock()
     * @generated
     */
    EClass BLOCK = eINSTANCE.getBlock();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK__STATEMENT = eINSTANCE.getBlock_Statement();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BlockStatementImpl <em>Block Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BlockStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getBlockStatement()
     * @generated
     */
    EClass BLOCK_STATEMENT = eINSTANCE.getBlockStatement();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.EmptyStatementImpl <em>Empty Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.EmptyStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getEmptyStatement()
     * @generated
     */
    EClass EMPTY_STATEMENT = eINSTANCE.getEmptyStatement();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LocalNameDeclarationStatementImpl <em>Local Name Declaration Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LocalNameDeclarationStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLocalNameDeclarationStatement()
     * @generated
     */
    EClass LOCAL_NAME_DECLARATION_STATEMENT = eINSTANCE.getLocalNameDeclarationStatement();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_NAME_DECLARATION_STATEMENT__VARIABLE = eINSTANCE.getLocalNameDeclarationStatement_Variable();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_NAME_DECLARATION_STATEMENT__EXPRESSION = eINSTANCE.getLocalNameDeclarationStatement_Expression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.InstanceCreationExpressionImpl <em>Instance Creation Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.InstanceCreationExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getInstanceCreationExpression()
     * @generated
     */
    EClass INSTANCE_CREATION_EXPRESSION = eINSTANCE.getInstanceCreationExpression();

    /**
     * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE_CREATION_EXPRESSION__INSTANCE = eINSTANCE.getInstanceCreationExpression_Instance();

    /**
     * The meta object literal for the '<em><b>Tuple</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE_CREATION_EXPRESSION__TUPLE = eINSTANCE.getInstanceCreationExpression_Tuple();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ExpressionStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getExpressionStatement()
     * @generated
     */
    EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_STATEMENT__EXPRESSION = eINSTANCE.getExpressionStatement_Expression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.IfStatementImpl <em>If Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.IfStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getIfStatement()
     * @generated
     */
    EClass IF_STATEMENT = eINSTANCE.getIfStatement();

    /**
     * The meta object literal for the '<em><b>Non Final Clauses</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__NON_FINAL_CLAUSES = eINSTANCE.getIfStatement_NonFinalClauses();

    /**
     * The meta object literal for the '<em><b>Final Clause</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__FINAL_CLAUSE = eINSTANCE.getIfStatement_FinalClause();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConcurrentClausesImpl <em>Concurrent Clauses</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConcurrentClausesImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getConcurrentClauses()
     * @generated
     */
    EClass CONCURRENT_CLAUSES = eINSTANCE.getConcurrentClauses();

    /**
     * The meta object literal for the '<em><b>Clause</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONCURRENT_CLAUSES__CLAUSE = eINSTANCE.getConcurrentClauses_Clause();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NonFinalClauseImpl <em>Non Final Clause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.NonFinalClauseImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNonFinalClause()
     * @generated
     */
    EClass NON_FINAL_CLAUSE = eINSTANCE.getNonFinalClause();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NON_FINAL_CLAUSE__CONDITION = eINSTANCE.getNonFinalClause_Condition();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NON_FINAL_CLAUSE__BODY = eINSTANCE.getNonFinalClause_Body();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SwitchStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getSwitchStatement()
     * @generated
     */
    EClass SWITCH_STATEMENT = eINSTANCE.getSwitchStatement();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SWITCH_STATEMENT__EXPRESSION = eINSTANCE.getSwitchStatement_Expression();

    /**
     * The meta object literal for the '<em><b>Non Default Clause</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SWITCH_STATEMENT__NON_DEFAULT_CLAUSE = eINSTANCE.getSwitchStatement_NonDefaultClause();

    /**
     * The meta object literal for the '<em><b>Default Clause</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SWITCH_STATEMENT__DEFAULT_CLAUSE = eINSTANCE.getSwitchStatement_DefaultClause();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SwitchClauseImpl <em>Switch Clause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SwitchClauseImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getSwitchClause()
     * @generated
     */
    EClass SWITCH_CLAUSE = eINSTANCE.getSwitchClause();

    /**
     * The meta object literal for the '<em><b>Case</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SWITCH_CLAUSE__CASE = eINSTANCE.getSwitchClause_Case();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SWITCH_CLAUSE__BLOCK = eINSTANCE.getSwitchClause_Block();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.WhileStatementImpl <em>While Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.WhileStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getWhileStatement()
     * @generated
     */
    EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STATEMENT__CONDITION = eINSTANCE.getWhileStatement_Condition();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STATEMENT__BODY = eINSTANCE.getWhileStatement_Body();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.DoStatementImpl <em>Do Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.DoStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getDoStatement()
     * @generated
     */
    EClass DO_STATEMENT = eINSTANCE.getDoStatement();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DO_STATEMENT__BODY = eINSTANCE.getDoStatement_Body();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DO_STATEMENT__CONDITION = eINSTANCE.getDoStatement_Condition();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ForStatementImpl <em>For Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ForStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getForStatement()
     * @generated
     */
    EClass FOR_STATEMENT = eINSTANCE.getForStatement();

    /**
     * The meta object literal for the '<em><b>Initialization</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__INITIALIZATION = eINSTANCE.getForStatement_Initialization();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__CONDITION = eINSTANCE.getForStatement_Condition();

    /**
     * The meta object literal for the '<em><b>Update</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__UPDATE = eINSTANCE.getForStatement_Update();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__BODY = eINSTANCE.getForStatement_Body();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ForEachStatementImpl <em>For Each Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ForEachStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getForEachStatement()
     * @generated
     */
    EClass FOR_EACH_STATEMENT = eINSTANCE.getForEachStatement();

    /**
     * The meta object literal for the '<em><b>Variable Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_EACH_STATEMENT__VARIABLE_DEFINITION = eINSTANCE.getForEachStatement_VariableDefinition();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_EACH_STATEMENT__BODY = eINSTANCE.getForEachStatement_Body();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.VariableImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__TYPE = eINSTANCE.getVariable_Type();

    /**
     * The meta object literal for the '<em><b>Has Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__HAS_MULTIPLICITY = eINSTANCE.getVariable_HasMultiplicity();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BreakStatementImpl <em>Break Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.BreakStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getBreakStatement()
     * @generated
     */
    EClass BREAK_STATEMENT = eINSTANCE.getBreakStatement();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReturnStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getReturnStatement()
     * @generated
     */
    EClass RETURN_STATEMENT = eINSTANCE.getReturnStatement();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RETURN_STATEMENT__EXPRESSION = eINSTANCE.getReturnStatement_Expression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassifyStatementImpl <em>Classify Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassifyStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getClassifyStatement()
     * @generated
     */
    EClass CLASSIFY_STATEMENT = eINSTANCE.getClassifyStatement();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFY_STATEMENT__EXPRESSION = eINSTANCE.getClassifyStatement_Expression();

    /**
     * The meta object literal for the '<em><b>From List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFY_STATEMENT__FROM_LIST = eINSTANCE.getClassifyStatement_FromList();

    /**
     * The meta object literal for the '<em><b>To List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFY_STATEMENT__TO_LIST = eINSTANCE.getClassifyStatement_ToList();

    /**
     * The meta object literal for the '<em><b>Is Reclassify All</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFY_STATEMENT__IS_RECLASSIFY_ALL = eINSTANCE.getClassifyStatement_IsReclassifyAll();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.QualifiedNameListImpl <em>Qualified Name List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.QualifiedNameListImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getQualifiedNameList()
     * @generated
     */
    EClass QUALIFIED_NAME_LIST = eINSTANCE.getQualifiedNameList();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUALIFIED_NAME_LIST__NAME = eINSTANCE.getQualifiedNameList_Name();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SendSignalStatementImpl <em>Send Signal Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SendSignalStatementImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getSendSignalStatement()
     * @generated
     */
    EClass SEND_SIGNAL_STATEMENT = eINSTANCE.getSendSignalStatement();

    /**
     * The meta object literal for the '<em><b>Signal</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEND_SIGNAL_STATEMENT__SIGNAL = eINSTANCE.getSendSignalStatement_Signal();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEND_SIGNAL_STATEMENT__TARGET = eINSTANCE.getSendSignalStatement_Target();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.FeatureInvocationExpressionImpl <em>Feature Invocation Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.FeatureInvocationExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getFeatureInvocationExpression()
     * @generated
     */
    EClass FEATURE_INVOCATION_EXPRESSION = eINSTANCE.getFeatureInvocationExpression();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_INVOCATION_EXPRESSION__CONTEXT = eINSTANCE.getFeatureInvocationExpression_Context();

    /**
     * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE_INVOCATION_EXPRESSION__IS_STATIC = eINSTANCE.getFeatureInvocationExpression_IsStatic();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_INVOCATION_EXPRESSION__OPERATION = eINSTANCE.getFeatureInvocationExpression_Operation();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_INVOCATION_EXPRESSION__PARAMETERS = eINSTANCE.getFeatureInvocationExpression_Parameters();

    /**
     * The meta object literal for the '<em><b>Tuple</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_INVOCATION_EXPRESSION__TUPLE = eINSTANCE.getFeatureInvocationExpression_Tuple();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.AssociationAccessExpressionImpl <em>Association Access Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.AssociationAccessExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getAssociationAccessExpression()
     * @generated
     */
    EClass ASSOCIATION_ACCESS_EXPRESSION = eINSTANCE.getAssociationAccessExpression();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_ACCESS_EXPRESSION__CONTEXT = eINSTANCE.getAssociationAccessExpression_Context();

    /**
     * The meta object literal for the '<em><b>Association</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_ACCESS_EXPRESSION__ASSOCIATION = eINSTANCE.getAssociationAccessExpression_Association();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SequenceAccessExpressionImpl <em>Sequence Access Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.SequenceAccessExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getSequenceAccessExpression()
     * @generated
     */
    EClass SEQUENCE_ACCESS_EXPRESSION = eINSTANCE.getSequenceAccessExpression();

    /**
     * The meta object literal for the '<em><b>Primary</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENCE_ACCESS_EXPRESSION__PRIMARY = eINSTANCE.getSequenceAccessExpression_Primary();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENCE_ACCESS_EXPRESSION__INDEX = eINSTANCE.getSequenceAccessExpression_Index();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ThisExpressionImpl <em>This Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ThisExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getThisExpression()
     * @generated
     */
    EClass THIS_EXPRESSION = eINSTANCE.getThisExpression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ElementCollectionExpressionImpl <em>Element Collection Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ElementCollectionExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getElementCollectionExpression()
     * @generated
     */
    EClass ELEMENT_COLLECTION_EXPRESSION = eINSTANCE.getElementCollectionExpression();

    /**
     * The meta object literal for the '<em><b>Collection Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT_COLLECTION_EXPRESSION__COLLECTION_TYPE = eINSTANCE.getElementCollectionExpression_CollectionType();

    /**
     * The meta object literal for the '<em><b>Type Declaration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_COLLECTION_EXPRESSION__TYPE_DECLARATION = eINSTANCE.getElementCollectionExpression_TypeDeclaration();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_COLLECTION_EXPRESSION__ELEMENTS = eINSTANCE.getElementCollectionExpression_Elements();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.PrefixExpressionImpl <em>Prefix Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.PrefixExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getPrefixExpression()
     * @generated
     */
    EClass PREFIX_EXPRESSION = eINSTANCE.getPrefixExpression();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREFIX_EXPRESSION__OPERATOR = eINSTANCE.getPrefixExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREFIX_EXPRESSION__OPERAND = eINSTANCE.getPrefixExpression_Operand();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.PostfixExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getPostfixExpression()
     * @generated
     */
    EClass POSTFIX_EXPRESSION = eINSTANCE.getPostfixExpression();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__OPERAND = eINSTANCE.getPostfixExpression_Operand();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute POSTFIX_EXPRESSION__OPERATOR = eINSTANCE.getPostfixExpression_Operator();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ArithmeticExpressionImpl <em>Arithmetic Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ArithmeticExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getArithmeticExpression()
     * @generated
     */
    EClass ARITHMETIC_EXPRESSION = eINSTANCE.getArithmeticExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARITHMETIC_EXPRESSION__OPERAND1 = eINSTANCE.getArithmeticExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARITHMETIC_EXPRESSION__OPERATOR = eINSTANCE.getArithmeticExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARITHMETIC_EXPRESSION__OPERAND2 = eINSTANCE.getArithmeticExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ShiftExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getShiftExpression()
     * @generated
     */
    EClass SHIFT_EXPRESSION = eINSTANCE.getShiftExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHIFT_EXPRESSION__OPERAND1 = eINSTANCE.getShiftExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHIFT_EXPRESSION__OPERATOR = eINSTANCE.getShiftExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHIFT_EXPRESSION__OPERAND2 = eINSTANCE.getShiftExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.RelationalExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getRelationalExpression()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__OPERAND1 = eINSTANCE.getRelationalExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONAL_EXPRESSION__OPERATOR = eINSTANCE.getRelationalExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__OPERAND2 = eINSTANCE.getRelationalExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassificationExpressionImpl <em>Classification Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassificationExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getClassificationExpression()
     * @generated
     */
    EClass CLASSIFICATION_EXPRESSION = eINSTANCE.getClassificationExpression();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFICATION_EXPRESSION__OPERAND = eINSTANCE.getClassificationExpression_Operand();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFICATION_EXPRESSION__OPERATOR = eINSTANCE.getClassificationExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFICATION_EXPRESSION__TYPE = eINSTANCE.getClassificationExpression_Type();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.EqualityExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getEqualityExpression()
     * @generated
     */
    EClass EQUALITY_EXPRESSION = eINSTANCE.getEqualityExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__OPERAND1 = eINSTANCE.getEqualityExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUALITY_EXPRESSION__OPERATOR = eINSTANCE.getEqualityExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__OPERAND2 = eINSTANCE.getEqualityExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LogicalExpressionImpl <em>Logical Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LogicalExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLogicalExpression()
     * @generated
     */
    EClass LOGICAL_EXPRESSION = eINSTANCE.getLogicalExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_EXPRESSION__OPERAND1 = eINSTANCE.getLogicalExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOGICAL_EXPRESSION__OPERATOR = eINSTANCE.getLogicalExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_EXPRESSION__OPERAND2 = eINSTANCE.getLogicalExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConditionalLogicalExpressionImpl <em>Conditional Logical Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConditionalLogicalExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getConditionalLogicalExpression()
     * @generated
     */
    EClass CONDITIONAL_LOGICAL_EXPRESSION = eINSTANCE.getConditionalLogicalExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_LOGICAL_EXPRESSION__OPERAND1 = eINSTANCE.getConditionalLogicalExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONDITIONAL_LOGICAL_EXPRESSION__OPERATOR = eINSTANCE.getConditionalLogicalExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_LOGICAL_EXPRESSION__OPERAND2 = eINSTANCE.getConditionalLogicalExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConditionalTestExpressionImpl <em>Conditional Test Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ConditionalTestExpressionImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getConditionalTestExpression()
     * @generated
     */
    EClass CONDITIONAL_TEST_EXPRESSION = eINSTANCE.getConditionalTestExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_TEST_EXPRESSION__OPERAND1 = eINSTANCE.getConditionalTestExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_TEST_EXPRESSION__OPERAND2 = eINSTANCE.getConditionalTestExpression_Operand2();

    /**
     * The meta object literal for the '<em><b>Operand3</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_TEST_EXPRESSION__OPERAND3 = eINSTANCE.getConditionalTestExpression_Operand3();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LoopVariableImpl <em>Loop Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LoopVariableImpl
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLoopVariable()
     * @generated
     */
    EClass LOOP_VARIABLE = eINSTANCE.getLoopVariable();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOOP_VARIABLE__EXPRESSION = eINSTANCE.getLoopVariable_Expression();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperation <em>Link Operation</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperation
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getLinkOperation()
     * @generated
     */
    EEnum LINK_OPERATION = eINSTANCE.getLinkOperation();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType <em>Collection Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getCollectionType()
     * @generated
     */
    EEnum COLLECTION_TYPE = eINSTANCE.getCollectionType();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator <em>Affix Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getAffixOperator()
     * @generated
     */
    EEnum AFFIX_OPERATOR = eINSTANCE.getAffixOperator();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator <em>Numeric Unary Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getNumericUnaryOperator()
     * @generated
     */
    EEnum NUMERIC_UNARY_OPERATOR = eINSTANCE.getNumericUnaryOperator();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftOperator <em>Shift Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftOperator
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getShiftOperator()
     * @generated
     */
    EEnum SHIFT_OPERATOR = eINSTANCE.getShiftOperator();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalOperator <em>Relational Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalOperator
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getRelationalOperator()
     * @generated
     */
    EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationOperator <em>Classification Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassificationOperator
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getClassificationOperator()
     * @generated
     */
    EEnum CLASSIFICATION_OPERATOR = eINSTANCE.getClassificationOperator();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityOperator <em>Equality Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityOperator
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getEqualityOperator()
     * @generated
     */
    EEnum EQUALITY_OPERATOR = eINSTANCE.getEqualityOperator();

    /**
     * The meta object literal for the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentOperator <em>Assignment Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentOperator
     * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ReducedAlfLanguagePackageImpl#getAssignmentOperator()
     * @generated
     */
    EEnum ASSIGNMENT_OPERATOR = eINSTANCE.getAssignmentOperator();

  }

} //ReducedAlfLanguagePackage
