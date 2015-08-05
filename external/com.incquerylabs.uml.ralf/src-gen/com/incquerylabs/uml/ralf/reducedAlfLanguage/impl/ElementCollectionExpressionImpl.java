/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.impl;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.TypeDeclaration;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Collection Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ElementCollectionExpressionImpl#getCollectionType <em>Collection Type</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ElementCollectionExpressionImpl#getTypeDeclaration <em>Type Declaration</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ElementCollectionExpressionImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementCollectionExpressionImpl extends CollectionLiteralExpressionImpl implements ElementCollectionExpression
{
  /**
   * The default value of the '{@link #getCollectionType() <em>Collection Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCollectionType()
   * @generated
   * @ordered
   */
  protected static final CollectionType COLLECTION_TYPE_EDEFAULT = CollectionType.SET;

  /**
   * The cached value of the '{@link #getCollectionType() <em>Collection Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCollectionType()
   * @generated
   * @ordered
   */
  protected CollectionType collectionType = COLLECTION_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypeDeclaration() <em>Type Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeDeclaration()
   * @generated
   * @ordered
   */
  protected TypeDeclaration typeDeclaration;

  /**
   * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected ExpressionList elements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElementCollectionExpressionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ReducedAlfLanguagePackage.Literals.ELEMENT_COLLECTION_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionType getCollectionType()
  {
    return collectionType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCollectionType(CollectionType newCollectionType)
  {
    CollectionType oldCollectionType = collectionType;
    collectionType = newCollectionType == null ? COLLECTION_TYPE_EDEFAULT : newCollectionType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__COLLECTION_TYPE, oldCollectionType, collectionType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDeclaration getTypeDeclaration()
  {
    return typeDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeDeclaration(TypeDeclaration newTypeDeclaration, NotificationChain msgs)
  {
    TypeDeclaration oldTypeDeclaration = typeDeclaration;
    typeDeclaration = newTypeDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__TYPE_DECLARATION, oldTypeDeclaration, newTypeDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeDeclaration(TypeDeclaration newTypeDeclaration)
  {
    if (newTypeDeclaration != typeDeclaration)
    {
      NotificationChain msgs = null;
      if (typeDeclaration != null)
        msgs = ((InternalEObject)typeDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__TYPE_DECLARATION, null, msgs);
      if (newTypeDeclaration != null)
        msgs = ((InternalEObject)newTypeDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__TYPE_DECLARATION, null, msgs);
      msgs = basicSetTypeDeclaration(newTypeDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__TYPE_DECLARATION, newTypeDeclaration, newTypeDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionList getElements()
  {
    return elements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElements(ExpressionList newElements, NotificationChain msgs)
  {
    ExpressionList oldElements = elements;
    elements = newElements;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__ELEMENTS, oldElements, newElements);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElements(ExpressionList newElements)
  {
    if (newElements != elements)
    {
      NotificationChain msgs = null;
      if (elements != null)
        msgs = ((InternalEObject)elements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__ELEMENTS, null, msgs);
      if (newElements != null)
        msgs = ((InternalEObject)newElements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__ELEMENTS, null, msgs);
      msgs = basicSetElements(newElements, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__ELEMENTS, newElements, newElements));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__TYPE_DECLARATION:
        return basicSetTypeDeclaration(null, msgs);
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__ELEMENTS:
        return basicSetElements(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__COLLECTION_TYPE:
        return getCollectionType();
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__TYPE_DECLARATION:
        return getTypeDeclaration();
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__ELEMENTS:
        return getElements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__COLLECTION_TYPE:
        setCollectionType((CollectionType)newValue);
        return;
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__TYPE_DECLARATION:
        setTypeDeclaration((TypeDeclaration)newValue);
        return;
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__ELEMENTS:
        setElements((ExpressionList)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__COLLECTION_TYPE:
        setCollectionType(COLLECTION_TYPE_EDEFAULT);
        return;
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__TYPE_DECLARATION:
        setTypeDeclaration((TypeDeclaration)null);
        return;
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__ELEMENTS:
        setElements((ExpressionList)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__COLLECTION_TYPE:
        return collectionType != COLLECTION_TYPE_EDEFAULT;
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__TYPE_DECLARATION:
        return typeDeclaration != null;
      case ReducedAlfLanguagePackage.ELEMENT_COLLECTION_EXPRESSION__ELEMENTS:
        return elements != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (collectionType: ");
    result.append(collectionType);
    result.append(')');
    return result.toString();
  }

} //ElementCollectionExpressionImpl
