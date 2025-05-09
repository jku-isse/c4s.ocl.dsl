/**
 * generated by Xtext 2.34.0
 */
package at.jku.isse.oclx.impl;

import at.jku.isse.oclx.BinaryOperator;
import at.jku.isse.oclx.Exp;
import at.jku.isse.oclx.InfixExp;
import at.jku.isse.oclx.OclxPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infix Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.isse.oclx.impl.InfixExpImpl#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link at.jku.isse.oclx.impl.InfixExpImpl#getOperators <em>Operators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InfixExpImpl extends ExpImpl implements InfixExp
{
  /**
   * The cached value of the '{@link #getExpressions() <em>Expressions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressions()
   * @generated
   * @ordered
   */
  protected EList<Exp> expressions;

  /**
   * The cached value of the '{@link #getOperators() <em>Operators</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperators()
   * @generated
   * @ordered
   */
  protected EList<BinaryOperator> operators;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InfixExpImpl()
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
    return OclxPackage.Literals.INFIX_EXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Exp> getExpressions()
  {
    if (expressions == null)
    {
      expressions = new EObjectContainmentEList<Exp>(Exp.class, this, OclxPackage.INFIX_EXP__EXPRESSIONS);
    }
    return expressions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BinaryOperator> getOperators()
  {
    if (operators == null)
    {
      operators = new EObjectContainmentEList<BinaryOperator>(BinaryOperator.class, this, OclxPackage.INFIX_EXP__OPERATORS);
    }
    return operators;
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
      case OclxPackage.INFIX_EXP__EXPRESSIONS:
        return ((InternalEList<?>)getExpressions()).basicRemove(otherEnd, msgs);
      case OclxPackage.INFIX_EXP__OPERATORS:
        return ((InternalEList<?>)getOperators()).basicRemove(otherEnd, msgs);
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
      case OclxPackage.INFIX_EXP__EXPRESSIONS:
        return getExpressions();
      case OclxPackage.INFIX_EXP__OPERATORS:
        return getOperators();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case OclxPackage.INFIX_EXP__EXPRESSIONS:
        getExpressions().clear();
        getExpressions().addAll((Collection<? extends Exp>)newValue);
        return;
      case OclxPackage.INFIX_EXP__OPERATORS:
        getOperators().clear();
        getOperators().addAll((Collection<? extends BinaryOperator>)newValue);
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
      case OclxPackage.INFIX_EXP__EXPRESSIONS:
        getExpressions().clear();
        return;
      case OclxPackage.INFIX_EXP__OPERATORS:
        getOperators().clear();
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
      case OclxPackage.INFIX_EXP__EXPRESSIONS:
        return expressions != null && !expressions.isEmpty();
      case OclxPackage.INFIX_EXP__OPERATORS:
        return operators != null && !operators.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InfixExpImpl
