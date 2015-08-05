/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.impl;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperation;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Tuple;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.uml.Association;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Operation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LinkOperationExpressionImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LinkOperationExpressionImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.LinkOperationExpressionImpl#getTuple <em>Tuple</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinkOperationExpressionImpl extends ExpressionImpl implements LinkOperationExpression
{
  /**
   * The cached value of the '{@link #getAssociation() <em>Association</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociation()
   * @generated
   * @ordered
   */
  protected Association association;

  /**
   * The default value of the '{@link #getOperation() <em>Operation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperation()
   * @generated
   * @ordered
   */
  protected static final LinkOperation OPERATION_EDEFAULT = LinkOperation.LINK;

  /**
   * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperation()
   * @generated
   * @ordered
   */
  protected LinkOperation operation = OPERATION_EDEFAULT;

  /**
   * The cached value of the '{@link #getTuple() <em>Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTuple()
   * @generated
   * @ordered
   */
  protected Tuple tuple;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LinkOperationExpressionImpl()
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
    return ReducedAlfLanguagePackage.Literals.LINK_OPERATION_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Association getAssociation()
  {
    if (association != null && association.eIsProxy())
    {
      InternalEObject oldAssociation = (InternalEObject)association;
      association = (Association)eResolveProxy(oldAssociation);
      if (association != oldAssociation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__ASSOCIATION, oldAssociation, association));
      }
    }
    return association;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Association basicGetAssociation()
  {
    return association;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssociation(Association newAssociation)
  {
    Association oldAssociation = association;
    association = newAssociation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__ASSOCIATION, oldAssociation, association));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperation getOperation()
  {
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperation(LinkOperation newOperation)
  {
    LinkOperation oldOperation = operation;
    operation = newOperation == null ? OPERATION_EDEFAULT : newOperation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__OPERATION, oldOperation, operation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tuple getTuple()
  {
    return tuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTuple(Tuple newTuple, NotificationChain msgs)
  {
    Tuple oldTuple = tuple;
    tuple = newTuple;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__TUPLE, oldTuple, newTuple);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTuple(Tuple newTuple)
  {
    if (newTuple != tuple)
    {
      NotificationChain msgs = null;
      if (tuple != null)
        msgs = ((InternalEObject)tuple).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__TUPLE, null, msgs);
      if (newTuple != null)
        msgs = ((InternalEObject)newTuple).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__TUPLE, null, msgs);
      msgs = basicSetTuple(newTuple, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__TUPLE, newTuple, newTuple));
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
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__TUPLE:
        return basicSetTuple(null, msgs);
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
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__ASSOCIATION:
        if (resolve) return getAssociation();
        return basicGetAssociation();
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__OPERATION:
        return getOperation();
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__TUPLE:
        return getTuple();
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
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__ASSOCIATION:
        setAssociation((Association)newValue);
        return;
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__OPERATION:
        setOperation((LinkOperation)newValue);
        return;
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__TUPLE:
        setTuple((Tuple)newValue);
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
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__ASSOCIATION:
        setAssociation((Association)null);
        return;
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__OPERATION:
        setOperation(OPERATION_EDEFAULT);
        return;
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__TUPLE:
        setTuple((Tuple)null);
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
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__ASSOCIATION:
        return association != null;
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__OPERATION:
        return operation != OPERATION_EDEFAULT;
      case ReducedAlfLanguagePackage.LINK_OPERATION_EXPRESSION__TUPLE:
        return tuple != null;
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
    result.append(" (operation: ");
    result.append(operation);
    result.append(')');
    return result.toString();
  }

} //LinkOperationExpressionImpl
