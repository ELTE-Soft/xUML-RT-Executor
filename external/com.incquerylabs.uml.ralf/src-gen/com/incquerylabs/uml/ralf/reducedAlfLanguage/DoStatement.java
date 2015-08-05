/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Do Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement#getBody <em>Body</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getDoStatement()
 * @model
 * @generated
 */
public interface DoStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(Block)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getDoStatement_Body()
   * @model containment="true"
   * @generated
   */
  Block getBody();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(Block value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Expression)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getDoStatement_Condition()
   * @model containment="true"
   * @generated
   */
  Expression getCondition();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expression value);

} // DoStatement
