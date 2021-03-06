/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region;

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
 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionFactory
 * @model kind="package"
 * @generated
 */
public interface RegionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "region";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eltesoft.hu/modelexecution/m2m/metamodel/region";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.eltesoft.modelexecution.m2m.metamodel.region";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RegionPackage eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgRegionImpl <em>Rg Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgRegionImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionPackageImpl#getRgRegion()
	 * @generated
	 */
	int RG_REGION = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_REGION__REFERENCE = BasePackage.MODEL_ROOT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_REGION__CONTAINER_CLASS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Pseudostate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_REGION__INITIAL_PSEUDOSTATE = BasePackage.MODEL_ROOT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_REGION__STATES = BasePackage.MODEL_ROOT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rg Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_REGION_FEATURE_COUNT = BasePackage.MODEL_ROOT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Rg Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_REGION_OPERATION_COUNT = BasePackage.MODEL_ROOT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgInitialPseudostateImpl <em>Rg Initial Pseudostate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgInitialPseudostateImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionPackageImpl#getRgInitialPseudostate()
	 * @generated
	 */
	int RG_INITIAL_PSEUDOSTATE = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_INITIAL_PSEUDOSTATE__REFERENCE = BasePackage.NAMED__REFERENCE;

	/**
	 * The feature id for the '<em><b>Initial Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_INITIAL_PSEUDOSTATE__INITIAL_TRANSITION = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rg Initial Pseudostate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_INITIAL_PSEUDOSTATE_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Rg Initial Pseudostate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_INITIAL_PSEUDOSTATE_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgStateImpl <em>Rg State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgStateImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionPackageImpl#getRgState()
	 * @generated
	 */
	int RG_STATE = 2;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_STATE__REFERENCE = BasePackage.NAMED__REFERENCE;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_STATE__ENTRY = BasePackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_STATE__EXIT = BasePackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_STATE__TRANSITIONS = BasePackage.NAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_STATE__IS_FINAL = BasePackage.NAMED_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rg State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_STATE_FEATURE_COUNT = BasePackage.NAMED_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Rg State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_STATE_OPERATION_COUNT = BasePackage.NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgTransitionImpl <em>Rg Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgTransitionImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionPackageImpl#getRgTransition()
	 * @generated
	 */
	int RG_TRANSITION = 3;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_TRANSITION__REFERENCE = BasePackage.REFERENCED__REFERENCE;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_TRANSITION__MESSAGE = BasePackage.REFERENCED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_TRANSITION__EFFECT = BasePackage.REFERENCED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_TRANSITION__TARGET = BasePackage.REFERENCED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_TRANSITION__EVENT = BasePackage.REFERENCED_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rg Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_TRANSITION_FEATURE_COUNT = BasePackage.REFERENCED_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Rg Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RG_TRANSITION_OPERATION_COUNT = BasePackage.REFERENCED_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion <em>Rg Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rg Region</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion
	 * @generated
	 */
	EClass getRgRegion();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getContainerClass <em>Container Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container Class</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getContainerClass()
	 * @see #getRgRegion()
	 * @generated
	 */
	EAttribute getRgRegion_ContainerClass();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getInitialPseudostate <em>Initial Pseudostate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial Pseudostate</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getInitialPseudostate()
	 * @see #getRgRegion()
	 * @generated
	 */
	EReference getRgRegion_InitialPseudostate();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>States</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion#getStates()
	 * @see #getRgRegion()
	 * @generated
	 */
	EReference getRgRegion_States();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate <em>Rg Initial Pseudostate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rg Initial Pseudostate</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate
	 * @generated
	 */
	EClass getRgInitialPseudostate();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate#getInitialTransition <em>Initial Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial Transition</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate#getInitialTransition()
	 * @see #getRgInitialPseudostate()
	 * @generated
	 */
	EReference getRgInitialPseudostate_InitialTransition();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState <em>Rg State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rg State</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgState
	 * @generated
	 */
	EClass getRgState();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entry</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getEntry()
	 * @see #getRgState()
	 * @generated
	 */
	EAttribute getRgState_Entry();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getExit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exit</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getExit()
	 * @see #getRgState()
	 * @generated
	 */
	EAttribute getRgState_Exit();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Transitions</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#getTransitions()
	 * @see #getRgState()
	 * @generated
	 */
	EReference getRgState_Transitions();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#isIsFinal <em>Is Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Final</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgState#isIsFinal()
	 * @see #getRgState()
	 * @generated
	 */
	EAttribute getRgState_IsFinal();

	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition <em>Rg Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rg Transition</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition
	 * @generated
	 */
	EClass getRgTransition();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getMessage()
	 * @see #getRgTransition()
	 * @generated
	 */
	EAttribute getRgTransition_Message();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getEffect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effect</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getEffect()
	 * @see #getRgTransition()
	 * @generated
	 */
	EAttribute getRgTransition_Effect();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getTarget()
	 * @see #getRgTransition()
	 * @generated
	 */
	EReference getRgTransition_Target();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition#getEvent()
	 * @see #getRgTransition()
	 * @generated
	 */
	EAttribute getRgTransition_Event();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RegionFactory getRegionFactory();

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
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgRegionImpl <em>Rg Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgRegionImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionPackageImpl#getRgRegion()
		 * @generated
		 */
		EClass RG_REGION = eINSTANCE.getRgRegion();

		/**
		 * The meta object literal for the '<em><b>Container Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RG_REGION__CONTAINER_CLASS = eINSTANCE.getRgRegion_ContainerClass();

		/**
		 * The meta object literal for the '<em><b>Initial Pseudostate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RG_REGION__INITIAL_PSEUDOSTATE = eINSTANCE.getRgRegion_InitialPseudostate();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RG_REGION__STATES = eINSTANCE.getRgRegion_States();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgInitialPseudostateImpl <em>Rg Initial Pseudostate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgInitialPseudostateImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionPackageImpl#getRgInitialPseudostate()
		 * @generated
		 */
		EClass RG_INITIAL_PSEUDOSTATE = eINSTANCE.getRgInitialPseudostate();

		/**
		 * The meta object literal for the '<em><b>Initial Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RG_INITIAL_PSEUDOSTATE__INITIAL_TRANSITION = eINSTANCE.getRgInitialPseudostate_InitialTransition();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgStateImpl <em>Rg State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgStateImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionPackageImpl#getRgState()
		 * @generated
		 */
		EClass RG_STATE = eINSTANCE.getRgState();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RG_STATE__ENTRY = eINSTANCE.getRgState_Entry();

		/**
		 * The meta object literal for the '<em><b>Exit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RG_STATE__EXIT = eINSTANCE.getRgState_Exit();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RG_STATE__TRANSITIONS = eINSTANCE.getRgState_Transitions();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RG_STATE__IS_FINAL = eINSTANCE.getRgState_IsFinal();

		/**
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgTransitionImpl <em>Rg Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RgTransitionImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionPackageImpl#getRgTransition()
		 * @generated
		 */
		EClass RG_TRANSITION = eINSTANCE.getRgTransition();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RG_TRANSITION__MESSAGE = eINSTANCE.getRgTransition_Message();

		/**
		 * The meta object literal for the '<em><b>Effect</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RG_TRANSITION__EFFECT = eINSTANCE.getRgTransition_Effect();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RG_TRANSITION__TARGET = eINSTANCE.getRgTransition_Target();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RG_TRANSITION__EVENT = eINSTANCE.getRgTransition_Event();

	}

} //RegionPackage
