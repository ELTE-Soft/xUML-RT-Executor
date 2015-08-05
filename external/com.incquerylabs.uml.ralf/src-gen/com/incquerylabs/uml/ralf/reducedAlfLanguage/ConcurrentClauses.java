/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concurrent Clauses</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ConcurrentClauses#getClause <em>Clause</em>}</li>
 * </ul>
 *
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getConcurrentClauses()
 * @model
 * @generated
 */
public interface ConcurrentClauses extends EObject
{
  /**
   * Returns the value of the '<em><b>Clause</b></em>' containment reference list.
   * The list contents are of type {@link com.incquerylabs.uml.ralf.reducedAlfLanguage.NonFinalClause}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Clause</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clause</em>' containment reference list.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getConcurrentClauses_Clause()
   * @model containment="true"
   * @generated
   */
  EList<NonFinalClause> getClause();

} // ConcurrentClauses
