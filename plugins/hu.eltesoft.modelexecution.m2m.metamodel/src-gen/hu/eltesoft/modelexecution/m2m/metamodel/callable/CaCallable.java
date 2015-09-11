/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.callable;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ca Callable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.callable.CaCallable#getReceptions <em>Receptions</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.callable.CallablePackage#getCaCallable()
 * @model
 * @generated
 */
public interface CaCallable extends ModelRoot {
	/**
	 * Returns the value of the '<em><b>Receptions</b></em>' attribute list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receptions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receptions</em>' attribute list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.callable.CallablePackage#getCaCallable_Receptions()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference" ordered="false"
	 * @generated
	 */
	EList<NamedReference> getReceptions();

} // CaCallable
