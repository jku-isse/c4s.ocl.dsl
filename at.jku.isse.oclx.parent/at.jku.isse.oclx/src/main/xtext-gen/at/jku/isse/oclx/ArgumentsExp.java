/**
 * generated by Xtext 2.34.0
 */
package at.jku.isse.oclx;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arguments Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.isse.oclx.ArgumentsExp#getOperators <em>Operators</em>}</li>
 * </ul>
 *
 * @see at.jku.isse.oclx.OclxPackage#getArgumentsExp()
 * @model
 * @generated
 */
public interface ArgumentsExp extends EObject
{
  /**
   * Returns the value of the '<em><b>Operators</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.isse.oclx.Exp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operators</em>' containment reference list.
   * @see at.jku.isse.oclx.OclxPackage#getArgumentsExp_Operators()
   * @model containment="true"
   * @generated
   */
  EList<Exp> getOperators();

} // ArgumentsExp
