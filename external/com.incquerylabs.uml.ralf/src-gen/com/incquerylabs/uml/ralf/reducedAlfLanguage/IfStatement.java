/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement#getNonFinalClauses <em>Non Final Clauses</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement#getFinalClause <em>Final Clause</em>}</li>
 * </ul>
 *
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Non Final Clauses</b></em>' containment reference list.
   * The list contents are of type {@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConcurrentClauses}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Non Final Clauses</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Non Final Clauses</em>' containment reference list.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getIfStatement_NonFinalClauses()
   * @model containment="true"
   * @generated
   */
  EList<ConcurrentClauses> getNonFinalClauses();

  /**
   * Returns the value of the '<em><b>Final Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Final Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Final Clause</em>' containment reference.
   * @see #setFinalClause(Block)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getIfStatement_FinalClause()
   * @model containment="true"
   * @generated
   */
  Block getFinalClause();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement#getFinalClause <em>Final Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final Clause</em>' containment reference.
   * @see #getFinalClause()
   * @generated
   */
  void setFinalClause(Block value);

} // IfStatement
