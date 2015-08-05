/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classify Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#getExpression <em>Expression</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#getFromList <em>From List</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#getToList <em>To List</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#isIsReclassifyAll <em>Is Reclassify All</em>}</li>
 * </ul>
 *
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getClassifyStatement()
 * @model
 * @generated
 */
public interface ClassifyStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getClassifyStatement_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

  /**
   * Returns the value of the '<em><b>From List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From List</em>' containment reference.
   * @see #setFromList(QualifiedNameList)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getClassifyStatement_FromList()
   * @model containment="true"
   * @generated
   */
  QualifiedNameList getFromList();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#getFromList <em>From List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From List</em>' containment reference.
   * @see #getFromList()
   * @generated
   */
  void setFromList(QualifiedNameList value);

  /**
   * Returns the value of the '<em><b>To List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To List</em>' containment reference.
   * @see #setToList(QualifiedNameList)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getClassifyStatement_ToList()
   * @model containment="true"
   * @generated
   */
  QualifiedNameList getToList();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#getToList <em>To List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To List</em>' containment reference.
   * @see #getToList()
   * @generated
   */
  void setToList(QualifiedNameList value);

  /**
   * Returns the value of the '<em><b>Is Reclassify All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Reclassify All</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Reclassify All</em>' attribute.
   * @see #setIsReclassifyAll(boolean)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getClassifyStatement_IsReclassifyAll()
   * @model
   * @generated
   */
  boolean isIsReclassifyAll();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement#isIsReclassifyAll <em>Is Reclassify All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Reclassify All</em>' attribute.
   * @see #isIsReclassifyAll()
   * @generated
   */
  void setIsReclassifyAll(boolean value);

} // ClassifyStatement
