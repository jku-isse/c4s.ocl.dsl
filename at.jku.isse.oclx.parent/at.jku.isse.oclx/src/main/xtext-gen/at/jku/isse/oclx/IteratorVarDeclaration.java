/**
 * generated by Xtext 2.34.0
 */
package at.jku.isse.oclx;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator Var Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.isse.oclx.IteratorVarDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.isse.oclx.IteratorVarDeclaration#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see at.jku.isse.oclx.OclxPackage#getIteratorVarDeclaration()
 * @model
 * @generated
 */
public interface IteratorVarDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(VarDeclaration)
   * @see at.jku.isse.oclx.OclxPackage#getIteratorVarDeclaration_Name()
   * @model containment="true"
   * @generated
   */
  VarDeclaration getName();

  /**
   * Sets the value of the '{@link at.jku.isse.oclx.IteratorVarDeclaration#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(VarDeclaration value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeExp)
   * @see at.jku.isse.oclx.OclxPackage#getIteratorVarDeclaration_Type()
   * @model containment="true"
   * @generated
   */
  TypeExp getType();

  /**
   * Sets the value of the '{@link at.jku.isse.oclx.IteratorVarDeclaration#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeExp value);

} // IteratorVarDeclaration
