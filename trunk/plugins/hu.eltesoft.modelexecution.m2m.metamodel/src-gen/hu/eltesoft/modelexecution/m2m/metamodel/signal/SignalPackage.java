/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.signal;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory
 * @model kind="package"
 * @generated
 */
public interface SignalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "signal";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eltesoft.hu/modelexecution/m2m/metamodel/signal";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.eltesoft.modelexecution.m2m.metamodel.signal";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SignalPackage eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SignalPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgSignalImpl <em>Sg Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgSignalImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SignalPackageImpl#getSgSignal()
	 * @generated
	 */
	int SG_SIGNAL = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_SIGNAL__REFERENCE = BasePackage.MODEL_ROOT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_SIGNAL__ATTRIBUTES = BasePackage.MODEL_ROOT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sg Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_SIGNAL_FEATURE_COUNT = BasePackage.MODEL_ROOT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sg Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_SIGNAL_OPERATION_COUNT = BasePackage.MODEL_ROOT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgAttributeImpl <em>Sg Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgAttributeImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SignalPackageImpl#getSgAttribute()
	 * @generated
	 */
	int SG_ATTRIBUTE = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_ATTRIBUTE__REFERENCE = BasePackage.NAMED__REFERENCE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_ATTRIBUTE__LOWER_BOUND = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_ATTRIBUTE__UPPER_BOUND = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_ATTRIBUTE__IS_ORDERED = BasePackage.NAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_ATTRIBUTE__IS_UNIQUE = BasePackage.NAMED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_ATTRIBUTE__TYPE = BasePackage.NAMED_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Sg Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_ATTRIBUTE_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Sg Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SG_ATTRIBUTE_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal <em>Sg Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sg Signal</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal
	 * @generated
	 */
	EClass getSgSignal();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal#getAttributes()
	 * @see #getSgSignal()
	 * @generated
	 */
	EReference getSgSignal_Attributes();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.SgAttribute <em>Sg Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sg Attribute</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SgAttribute
	 * @generated
	 */
	EClass getSgAttribute();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.SgAttribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SgAttribute#getType()
	 * @see #getSgAttribute()
	 * @generated
	 */
	EReference getSgAttribute_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SignalFactory getSignalFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgSignalImpl <em>Sg Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgSignalImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SignalPackageImpl#getSgSignal()
		 * @generated
		 */
		EClass SG_SIGNAL = eINSTANCE.getSgSignal();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SG_SIGNAL__ATTRIBUTES = eINSTANCE.getSgSignal_Attributes();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgAttributeImpl <em>Sg Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SgAttributeImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SignalPackageImpl#getSgAttribute()
		 * @generated
		 */
		EClass SG_ATTRIBUTE = eINSTANCE.getSgAttribute();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SG_ATTRIBUTE__TYPE = eINSTANCE.getSgAttribute_Type();

	}

} //SignalPackage
