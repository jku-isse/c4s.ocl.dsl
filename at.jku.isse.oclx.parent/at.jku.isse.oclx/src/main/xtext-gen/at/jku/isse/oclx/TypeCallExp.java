/**
 * generated by Xtext 2.34.0
 */
package at.jku.isse.oclx;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.isse.oclx.TypeCallExp#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.isse.oclx.TypeCallExp#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see at.jku.isse.oclx.OclxPackage#getTypeCallExp()
 * @model
 * @generated
 */
public interface TypeCallExp extends MethodExp
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see at.jku.isse.oclx.OclxPackage#getTypeCallExp_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.jku.isse.oclx.TypeCallExp#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeExp)
   * @see at.jku.isse.oclx.OclxPackage#getTypeCallExp_Type()
   * @model containment="true"
   * @generated
   */
  TypeExp getType();

  /**
   * Sets the value of the '{@link at.jku.isse.oclx.TypeCallExp#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeExp value);

} // TypeCallExp
