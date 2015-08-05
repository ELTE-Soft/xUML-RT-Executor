/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage.impl;

import com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassifyStatement;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.QualifiedNameList;
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classify Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassifyStatementImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassifyStatementImpl#getFromList <em>From List</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassifyStatementImpl#getToList <em>To List</em>}</li>
 *   <li>{@link com.incquerylabs.uml.ralf.reducedAlfLanguage.impl.ClassifyStatementImpl#isIsReclassifyAll <em>Is Reclassify All</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassifyStatementImpl extends StatementImpl implements ClassifyStatement
{
  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * The cached value of the '{@link #getFromList() <em>From List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFromList()
   * @generated
   * @ordered
   */
  protected QualifiedNameList fromList;

  /**
   * The cached value of the '{@link #getToList() <em>To List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToList()
   * @generated
   * @ordered
   */
  protected QualifiedNameList toList;

  /**
   * The default value of the '{@link #isIsReclassifyAll() <em>Is Reclassify All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsReclassifyAll()
   * @generated
   * @ordered
   */
  protected static final boolean IS_RECLASSIFY_ALL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsReclassifyAll() <em>Is Reclassify All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsReclassifyAll()
   * @generated
   * @ordered
   */
  protected boolean isReclassifyAll = IS_RECLASSIFY_ALL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassifyStatementImpl()
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
    return ReducedAlfLanguagePackage.Literals.CLASSIFY_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameList getFromList()
  {
    return fromList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFromList(QualifiedNameList newFromList, NotificationChain msgs)
  {
    QualifiedNameList oldFromList = fromList;
    fromList = newFromList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__FROM_LIST, oldFromList, newFromList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFromList(QualifiedNameList newFromList)
  {
    if (newFromList != fromList)
    {
      NotificationChain msgs = null;
      if (fromList != null)
        msgs = ((InternalEObject)fromList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__FROM_LIST, null, msgs);
      if (newFromList != null)
        msgs = ((InternalEObject)newFromList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__FROM_LIST, null, msgs);
      msgs = basicSetFromList(newFromList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__FROM_LIST, newFromList, newFromList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameList getToList()
  {
    return toList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetToList(QualifiedNameList newToList, NotificationChain msgs)
  {
    QualifiedNameList oldToList = toList;
    toList = newToList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__TO_LIST, oldToList, newToList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToList(QualifiedNameList newToList)
  {
    if (newToList != toList)
    {
      NotificationChain msgs = null;
      if (toList != null)
        msgs = ((InternalEObject)toList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__TO_LIST, null, msgs);
      if (newToList != null)
        msgs = ((InternalEObject)newToList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__TO_LIST, null, msgs);
      msgs = basicSetToList(newToList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__TO_LIST, newToList, newToList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsReclassifyAll()
  {
    return isReclassifyAll;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsReclassifyAll(boolean newIsReclassifyAll)
  {
    boolean oldIsReclassifyAll = isReclassifyAll;
    isReclassifyAll = newIsReclassifyAll;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__IS_RECLASSIFY_ALL, oldIsReclassifyAll, isReclassifyAll));
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
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__EXPRESSION:
        return basicSetExpression(null, msgs);
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__FROM_LIST:
        return basicSetFromList(null, msgs);
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__TO_LIST:
        return basicSetToList(null, msgs);
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
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__EXPRESSION:
        return getExpression();
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__FROM_LIST:
        return getFromList();
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__TO_LIST:
        return getToList();
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__IS_RECLASSIFY_ALL:
        return isIsReclassifyAll();
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
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__FROM_LIST:
        setFromList((QualifiedNameList)newValue);
        return;
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__TO_LIST:
        setToList((QualifiedNameList)newValue);
        return;
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__IS_RECLASSIFY_ALL:
        setIsReclassifyAll((Boolean)newValue);
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
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__EXPRESSION:
        setExpression((Expression)null);
        return;
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__FROM_LIST:
        setFromList((QualifiedNameList)null);
        return;
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__TO_LIST:
        setToList((QualifiedNameList)null);
        return;
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__IS_RECLASSIFY_ALL:
        setIsReclassifyAll(IS_RECLASSIFY_ALL_EDEFAULT);
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
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__EXPRESSION:
        return expression != null;
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__FROM_LIST:
        return fromList != null;
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__TO_LIST:
        return toList != null;
      case ReducedAlfLanguagePackage.CLASSIFY_STATEMENT__IS_RECLASSIFY_ALL:
        return isReclassifyAll != IS_RECLASSIFY_ALL_EDEFAULT;
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
    result.append(" (isReclassifyAll: ");
    result.append(isReclassifyAll);
    result.append(')');
    return result.toString();
  }

} //ClassifyStatementImpl
