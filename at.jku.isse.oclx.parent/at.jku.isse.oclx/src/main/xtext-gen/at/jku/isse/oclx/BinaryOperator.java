/**
 * generated by Xtext 2.34.0
 */
package at.jku.isse.oclx;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.isse.oclx.BinaryOperator#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @see at.jku.isse.oclx.OclxPackage#getBinaryOperator()
 * @model
 * @generated
 */
public interface BinaryOperator extends EObject
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see at.jku.isse.oclx.OclxPackage#getBinaryOperator_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link at.jku.isse.oclx.BinaryOperator#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

} // BinaryOperator
