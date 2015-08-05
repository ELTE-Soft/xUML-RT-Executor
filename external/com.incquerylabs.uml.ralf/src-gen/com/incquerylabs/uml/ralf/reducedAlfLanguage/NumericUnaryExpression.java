/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getNumericUnaryExpression()
 * @model
 * @generated
 */
public interface NumericUnaryExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator
   * @see #setOperator(NumericUnaryOperator)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getNumericUnaryExpression_Operator()
   * @model
   * @generated
   */
  NumericUnaryOperator getOperator();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(NumericUnaryOperator value);

  /**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference.
   * @see #setOperand(Expression)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getNumericUnaryExpression_Operand()
   * @model containment="true"
   * @generated
   */
  Expression getOperand();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(Expression value);

} // NumericUnaryExpression
