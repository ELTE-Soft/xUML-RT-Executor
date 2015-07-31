/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.external;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ex External Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity#getOperations <em>Operations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity#getImplementationClass <em>Implementation Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage#getExExternalEntity()
 * @model
 * @generated
 */
public interface ExExternalEntity extends ModelRoot {
	/**
	 * Returns the value of the '<em><b>Operations</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage#getExExternalEntity_Operations()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ExOperation> getOperations();

	/**
	 * Returns the value of the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Class</em>' attribute.
	 * @see #setImplementationClass(String)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage#getExExternalEntity_ImplementationClass()
	 * @model required="true"
	 * @generated
	 */
	String getImplementationClass();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity#getImplementationClass <em>Implementation Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Class</em>' attribute.
	 * @see #getImplementationClass()
	 * @generated
	 */
	void setImplementationClass(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType
	 * @see #setType(ExEntityType)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage#getExExternalEntity_Type()
	 * @model required="true"
	 * @generated
	 */
	ExEntityType getType();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType
	 * @see #getType()
	 * @generated
	 */
	void setType(ExEntityType value);

} // ExExternalEntity
