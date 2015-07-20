/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef;

import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cl Ctor Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClCtorRecord#getUsedObjs <em>Used Objs</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClCtorRecord()
 * @model
 * @generated
 */
public interface ClCtorRecord extends Named {
	/**
	 * Returns the value of the '<em><b>Used Objs</b></em>' attribute list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Objs</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Objs</em>' attribute list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClCtorRecord_UsedObjs()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference"
	 * @generated
	 */
	EList<NamedReference> getUsedObjs();

} // ClCtorRecord
