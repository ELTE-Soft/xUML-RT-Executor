/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression#getOperand <em>Operand</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getPostfixExpression()
 * @model
 * @generated
 */
public interface PostfixExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference.
   * @see #setOperand(LeftHandSide)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getPostfixExpression_Operand()
   * @model containment="true"
   * @generated
   */
  LeftHandSide getOperand();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(LeftHandSide value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator
   * @see #setOperator(AffixOperator)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getPostfixExpression_Operator()
   * @model
   * @generated
   */
  AffixOperator getOperator();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(AffixOperator value);

} // PostfixExpression
