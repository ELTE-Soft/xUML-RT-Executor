/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;

import org.eclipse.uml2.uml.Association;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Operation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression#getAssociation <em>Association</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression#getOperation <em>Operation</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression#getTuple <em>Tuple</em>}</li>
 * </ul>
 *
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getLinkOperationExpression()
 * @model
 * @generated
 */
public interface LinkOperationExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Association</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association</em>' reference.
   * @see #setAssociation(Association)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getLinkOperationExpression_Association()
   * @model
   * @generated
   */
  Association getAssociation();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression#getAssociation <em>Association</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Association</em>' reference.
   * @see #getAssociation()
   * @generated
   */
  void setAssociation(Association value);

  /**
   * Returns the value of the '<em><b>Operation</b></em>' attribute.
   * The literals are from the enumeration {@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' attribute.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperation
   * @see #setOperation(LinkOperation)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getLinkOperationExpression_Operation()
   * @model
   * @generated
   */
  LinkOperation getOperation();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression#getOperation <em>Operation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation</em>' attribute.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperation
   * @see #getOperation()
   * @generated
   */
  void setOperation(LinkOperation value);

  /**
   * Returns the value of the '<em><b>Tuple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tuple</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tuple</em>' containment reference.
   * @see #setTuple(Tuple)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getLinkOperationExpression_Tuple()
   * @model containment="true"
   * @generated
   */
  Tuple getTuple();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression#getTuple <em>Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tuple</em>' containment reference.
   * @see #getTuple()
   * @generated
   */
  void setTuple(Tuple value);

} // LinkOperationExpression
