/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cl Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getRegion <em>Region</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getInheritedRegion <em>Inherited Region</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getOperations <em>Operations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getReceptions <em>Receptions</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getInheritedAttributes <em>Inherited Attributes</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getAssociations <em>Associations</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getParents <em>Parents</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClClass()
 * @model
 * @generated
 */
public interface ClClass extends ModelRoot {
	/**
	 * Returns the value of the '<em><b>Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region</em>' attribute.
	 * @see #setRegion(NamedReference)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClClass_Region()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference"
	 * @generated
	 */
	NamedReference getRegion();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getRegion <em>Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Region</em>' attribute.
	 * @see #getRegion()
	 * @generated
	 */
	void setRegion(NamedReference value);

	/**
	 * Returns the value of the '<em><b>Inherited Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Region</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Region</em>' attribute.
	 * @see #setInheritedRegion(NamedReference)
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClClass_InheritedRegion()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference"
	 * @generated
	 */
	NamedReference getInheritedRegion();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getInheritedRegion <em>Inherited Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited Region</em>' attribute.
	 * @see #getInheritedRegion()
	 * @generated
	 */
	void setInheritedRegion(NamedReference value);

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClClass_Operations()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ClOperation> getOperations();

	/**
	 * Returns the value of the '<em><b>Receptions</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receptions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receptions</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClClass_Receptions()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ClReception> getReceptions();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClClass_Attributes()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ClAttribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Inherited Attributes</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Attributes</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClClass_InheritedAttributes()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ClInheritedAttribute> getInheritedAttributes();

	/**
	 * Returns the value of the '<em><b>Associations</b></em>' reference list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations</em>' reference list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClClass_Associations()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ClAssociation> getAssociations();

	/**
	 * Returns the value of the '<em><b>Parents</b></em>' attribute list.
	 * The list contents are of type {@link hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parents</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parents</em>' attribute list.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage#getClClass_Parents()
	 * @model dataType="hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference" ordered="false"
	 * @generated
	 */
	EList<NamedReference> getParents();

} // ClClass
