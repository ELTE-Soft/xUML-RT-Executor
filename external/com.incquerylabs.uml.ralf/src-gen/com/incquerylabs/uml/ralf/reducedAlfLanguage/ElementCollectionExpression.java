/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Collection Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression#getCollectionType <em>Collection Type</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression#getTypeDeclaration <em>Type Declaration</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getElementCollectionExpression()
 * @model
 * @generated
 */
public interface ElementCollectionExpression extends CollectionLiteralExpression
{
  /**
   * Returns the value of the '<em><b>Collection Type</b></em>' attribute.
   * The literals are from the enumeration {@link com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Collection Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Collection Type</em>' attribute.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType
   * @see #setCollectionType(CollectionType)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getElementCollectionExpression_CollectionType()
   * @model
   * @generated
   */
  CollectionType getCollectionType();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression#getCollectionType <em>Collection Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Collection Type</em>' attribute.
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType
   * @see #getCollectionType()
   * @generated
   */
  void setCollectionType(CollectionType value);

  /**
   * Returns the value of the '<em><b>Type Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Declaration</em>' containment reference.
   * @see #setTypeDeclaration(TypeDeclaration)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getElementCollectionExpression_TypeDeclaration()
   * @model containment="true"
   * @generated
   */
  TypeDeclaration getTypeDeclaration();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression#getTypeDeclaration <em>Type Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Declaration</em>' containment reference.
   * @see #getTypeDeclaration()
   * @generated
   */
  void setTypeDeclaration(TypeDeclaration value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference.
   * @see #setElements(ExpressionList)
   * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getElementCollectionExpression_Elements()
   * @model containment="true"
   * @generated
   */
  ExpressionList getElements();

  /**
   * Sets the value of the '{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression#getElements <em>Elements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Elements</em>' containment reference.
   * @see #getElements()
   * @generated
   */
  void setElements(ExpressionList value);

} // ElementCollectionExpression
