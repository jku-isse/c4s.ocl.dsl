/**
 * generated by Xtext 2.34.0
 */
package at.jku.isse.oclx.impl;

import at.jku.isse.oclx.Exp;
import at.jku.isse.oclx.OclxPackage;
import at.jku.isse.oclx.PrefixExp;
import at.jku.isse.oclx.UnaryOperator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prefix Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.isse.oclx.impl.PrefixExpImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link at.jku.isse.oclx.impl.PrefixExpImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrefixExpImpl extends ExpImpl implements PrefixExp
{
  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected UnaryOperator operator;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Exp expression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrefixExpImpl()
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
    return OclxPackage.Literals.PREFIX_EXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnaryOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperator(UnaryOperator newOperator, NotificationChain msgs)
  {
    UnaryOperator oldOperator = operator;
    operator = newOperator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OclxPackage.PREFIX_EXP__OPERATOR, oldOperator, newOperator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOperator(UnaryOperator newOperator)
  {
    if (newOperator != operator)
    {
      NotificationChain msgs = null;
      if (operator != null)
        msgs = ((InternalEObject)operator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OclxPackage.PREFIX_EXP__OPERATOR, null, msgs);
      if (newOperator != null)
        msgs = ((InternalEObject)newOperator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OclxPackage.PREFIX_EXP__OPERATOR, null, msgs);
      msgs = basicSetOperator(newOperator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OclxPackage.PREFIX_EXP__OPERATOR, newOperator, newOperator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Exp getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Exp newExpression, NotificationChain msgs)
  {
    Exp oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OclxPackage.PREFIX_EXP__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExpression(Exp newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OclxPackage.PREFIX_EXP__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OclxPackage.PREFIX_EXP__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OclxPackage.PREFIX_EXP__EXPRESSION, newExpression, newExpression));
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
      case OclxPackage.PREFIX_EXP__OPERATOR:
        return basicSetOperator(null, msgs);
      case OclxPackage.PREFIX_EXP__EXPRESSION:
        return basicSetExpression(null, msgs);
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
      case OclxPackage.PREFIX_EXP__OPERATOR:
        return getOperator();
      case OclxPackage.PREFIX_EXP__EXPRESSION:
        return getExpression();
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
      case OclxPackage.PREFIX_EXP__OPERATOR:
        setOperator((UnaryOperator)newValue);
        return;
      case OclxPackage.PREFIX_EXP__EXPRESSION:
        setExpression((Exp)newValue);
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
      case OclxPackage.PREFIX_EXP__OPERATOR:
        setOperator((UnaryOperator)null);
        return;
      case OclxPackage.PREFIX_EXP__EXPRESSION:
        setExpression((Exp)null);
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
      case OclxPackage.PREFIX_EXP__OPERATOR:
        return operator != null;
      case OclxPackage.PREFIX_EXP__EXPRESSION:
        return expression != null;
    }
    return super.eIsSet(featureID);
  }

} //PrefixExpImpl
