/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.impl;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentOperator;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LeftHandSide;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.AssignmentExpressionImpl#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.AssignmentExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.AssignmentExpressionImpl#getRightHandSide <em>Right Hand Side</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignmentExpressionImpl extends ExpressionImpl implements AssignmentExpression
{
  /**
   * The cached value of the '{@link #getLeftHandSide() <em>Left Hand Side</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeftHandSide()
   * @generated
   * @ordered
   */
  protected LeftHandSide leftHandSide;

  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final AssignmentOperator OPERATOR_EDEFAULT = AssignmentOperator.ASSIGN;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected AssignmentOperator operator = OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getRightHandSide() <em>Right Hand Side</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightHandSide()
   * @generated
   * @ordered
   */
  protected Expression rightHandSide;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssignmentExpressionImpl()
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
    return ReducedAlfLanguagePackage.Literals.ASSIGNMENT_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LeftHandSide getLeftHandSide()
  {
    return leftHandSide;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeftHandSide(LeftHandSide newLeftHandSide, NotificationChain msgs)
  {
    LeftHandSide oldLeftHandSide = leftHandSide;
    leftHandSide = newLeftHandSide;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE, oldLeftHandSide, newLeftHandSide);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeftHandSide(LeftHandSide newLeftHandSide)
  {
    if (newLeftHandSide != leftHandSide)
    {
      NotificationChain msgs = null;
      if (leftHandSide != null)
        msgs = ((InternalEObject)leftHandSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE, null, msgs);
      if (newLeftHandSide != null)
        msgs = ((InternalEObject)newLeftHandSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE, null, msgs);
      msgs = basicSetLeftHandSide(newLeftHandSide, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE, newLeftHandSide, newLeftHandSide));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(AssignmentOperator newOperator)
  {
    AssignmentOperator oldOperator = operator;
    operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getRightHandSide()
  {
    return rightHandSide;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRightHandSide(Expression newRightHandSide, NotificationChain msgs)
  {
    Expression oldRightHandSide = rightHandSide;
    rightHandSide = newRightHandSide;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE, oldRightHandSide, newRightHandSide);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightHandSide(Expression newRightHandSide)
  {
    if (newRightHandSide != rightHandSide)
    {
      NotificationChain msgs = null;
      if (rightHandSide != null)
        msgs = ((InternalEObject)rightHandSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE, null, msgs);
      if (newRightHandSide != null)
        msgs = ((InternalEObject)newRightHandSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE, null, msgs);
      msgs = basicSetRightHandSide(newRightHandSide, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE, newRightHandSide, newRightHandSide));
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
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE:
        return basicSetLeftHandSide(null, msgs);
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE:
        return basicSetRightHandSide(null, msgs);
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
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE:
        return getLeftHandSide();
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__OPERATOR:
        return getOperator();
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE:
        return getRightHandSide();
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
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE:
        setLeftHandSide((LeftHandSide)newValue);
        return;
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__OPERATOR:
        setOperator((AssignmentOperator)newValue);
        return;
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE:
        setRightHandSide((Expression)newValue);
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
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE:
        setLeftHandSide((LeftHandSide)null);
        return;
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE:
        setRightHandSide((Expression)null);
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
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__LEFT_HAND_SIDE:
        return leftHandSide != null;
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__OPERATOR:
        return operator != OPERATOR_EDEFAULT;
      case ReducedAlfLanguagePackage.ASSIGNMENT_EXPRESSION__RIGHT_HAND_SIDE:
        return rightHandSide != null;
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
    result.append(" (operator: ");
    result.append(operator);
    result.append(')');
    return result.toString();
  }

} //AssignmentExpressionImpl
