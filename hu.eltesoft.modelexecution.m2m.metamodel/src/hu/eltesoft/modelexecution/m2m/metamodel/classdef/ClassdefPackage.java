/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory
 * @model kind="package"
 * @generated
 */
public interface ClassdefPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "classdef";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eltesoft.hu/modelexecution/m2m/classdef";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.eltesoft.modelexecution.m2m.metamodel.classdef";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassdefPackage eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl <em>Cl Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClClass()
	 * @generated
	 */
	int CL_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__NAME = BasePackage.NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__ID = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__OPERATIONS = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Receptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__RECEPTIONS = BasePackage.NAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS__REGION = BasePackage.NAMED_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Cl Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Cl Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_CLASS_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClOperationImpl <em>Cl Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClOperationImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClOperation()
	 * @generated
	 */
	int CL_OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION__NAME = BasePackage.NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION__ID = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION__METHOD = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cl Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cl Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_OPERATION_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionImpl <em>Cl Reception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClReception()
	 * @generated
	 */
	int CL_RECEPTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION__NAME = BasePackage.NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION__ID = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION__SIGNAL = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cl Reception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cl Reception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_RECEPTION_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClSignalImpl <em>Cl Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClSignalImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClSignal()
	 * @generated
	 */
	int CL_SIGNAL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_SIGNAL__NAME = BasePackage.NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_SIGNAL__ID = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cl Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_SIGNAL_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cl Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_SIGNAL_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClRegionImpl <em>Cl Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClRegionImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClRegion()
	 * @generated
	 */
	int CL_REGION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_REGION__NAME = BasePackage.NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_REGION__ID = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cl Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_REGION_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cl Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CL_REGION_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass <em>Cl Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Class</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
	 * @generated
	 */
	EClass getClClass();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operations</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getOperations()
	 * @see #getClClass()
	 * @generated
	 */
	EReference getClClass_Operations();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getReceptions <em>Receptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Receptions</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getReceptions()
	 * @see #getClClass()
	 * @generated
	 */
	EReference getClClass_Receptions();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Region</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass#getRegion()
	 * @see #getClClass()
	 * @generated
	 */
	EReference getClClass_Region();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation <em>Cl Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Operation</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation
	 * @generated
	 */
	EClass getClOperation();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation#getMethod()
	 * @see #getClOperation()
	 * @generated
	 */
	EAttribute getClOperation_Method();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception <em>Cl Reception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Reception</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception
	 * @generated
	 */
	EClass getClReception();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception#getSignal()
	 * @see #getClReception()
	 * @generated
	 */
	EReference getClReception_Signal();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClSignal <em>Cl Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Signal</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClSignal
	 * @generated
	 */
	EClass getClSignal();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClRegion <em>Cl Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cl Region</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClRegion
	 * @generated
	 */
	EClass getClRegion();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClassdefFactory getClassdefFactory();

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
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl <em>Cl Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClClassImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClClass()
		 * @generated
		 */
		EClass CL_CLASS = eINSTANCE.getClClass();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_CLASS__OPERATIONS = eINSTANCE.getClClass_Operations();

		/**
		 * The meta object literal for the '<em><b>Receptions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_CLASS__RECEPTIONS = eINSTANCE.getClClass_Receptions();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_CLASS__REGION = eINSTANCE.getClClass_Region();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClOperationImpl <em>Cl Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClOperationImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClOperation()
		 * @generated
		 */
		EClass CL_OPERATION = eINSTANCE.getClOperation();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CL_OPERATION__METHOD = eINSTANCE.getClOperation_Method();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionImpl <em>Cl Reception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClReceptionImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClReception()
		 * @generated
		 */
		EClass CL_RECEPTION = eINSTANCE.getClReception();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CL_RECEPTION__SIGNAL = eINSTANCE.getClReception_Signal();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClSignalImpl <em>Cl Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClSignalImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClSignal()
		 * @generated
		 */
		EClass CL_SIGNAL = eINSTANCE.getClSignal();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClRegionImpl <em>Cl Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClRegionImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl#getClRegion()
		 * @generated
		 */
		EClass CL_REGION = eINSTANCE.getClRegion();

	}

} //ClassdefPackage
