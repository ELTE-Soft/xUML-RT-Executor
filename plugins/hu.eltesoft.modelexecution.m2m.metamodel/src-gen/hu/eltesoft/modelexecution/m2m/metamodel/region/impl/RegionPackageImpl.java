/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AssociationPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.event.EventPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EventPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgState;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition;

import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SignalPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RegionPackageImpl extends EPackageImpl implements RegionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rgRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rgInitialPseudostateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rgStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rgTransitionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RegionPackageImpl() {
		super(eNS_URI, RegionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RegionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RegionPackage init() {
		if (isInited) return (RegionPackage)EPackage.Registry.INSTANCE.getEPackage(RegionPackage.eNS_URI);

		// Obtain or create and register package
		RegionPackageImpl theRegionPackage = (RegionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RegionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RegionPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AssociationPackageImpl theAssociationPackage = (AssociationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AssociationPackage.eNS_URI) instanceof AssociationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AssociationPackage.eNS_URI) : AssociationPackage.eINSTANCE);
		BasePackageImpl theBasePackage = (BasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) instanceof BasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) : BasePackage.eINSTANCE);
		BehaviorPackageImpl theBehaviorPackage = (BehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) instanceof BehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) : BehaviorPackage.eINSTANCE);
		ClassdefPackageImpl theClassdefPackage = (ClassdefPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassdefPackage.eNS_URI) instanceof ClassdefPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassdefPackage.eNS_URI) : ClassdefPackage.eINSTANCE);
		EventPackageImpl theEventPackage = (EventPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI) instanceof EventPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI) : EventPackage.eINSTANCE);
		SignalPackageImpl theSignalPackage = (SignalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SignalPackage.eNS_URI) instanceof SignalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SignalPackage.eNS_URI) : SignalPackage.eINSTANCE);

		// Create package meta-data objects
		theRegionPackage.createPackageContents();
		theAssociationPackage.createPackageContents();
		theBasePackage.createPackageContents();
		theBehaviorPackage.createPackageContents();
		theClassdefPackage.createPackageContents();
		theEventPackage.createPackageContents();
		theSignalPackage.createPackageContents();

		// Initialize created meta-data
		theRegionPackage.initializePackageContents();
		theAssociationPackage.initializePackageContents();
		theBasePackage.initializePackageContents();
		theBehaviorPackage.initializePackageContents();
		theClassdefPackage.initializePackageContents();
		theEventPackage.initializePackageContents();
		theSignalPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRegionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RegionPackage.eNS_URI, theRegionPackage);
		return theRegionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRgRegion() {
		return rgRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRgRegion_ContainerClass() {
		return (EAttribute)rgRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRgRegion_InitialPseudostate() {
		return (EReference)rgRegionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRgRegion_States() {
		return (EReference)rgRegionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRgInitialPseudostate() {
		return rgInitialPseudostateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRgInitialPseudostate_InitialTransition() {
		return (EReference)rgInitialPseudostateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRgState() {
		return rgStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRgState_Entry() {
		return (EAttribute)rgStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRgState_Exit() {
		return (EAttribute)rgStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRgState_Transitions() {
		return (EReference)rgStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRgTransition() {
		return rgTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRgTransition_Message() {
		return (EAttribute)rgTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRgTransition_Effect() {
		return (EAttribute)rgTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRgTransition_Target() {
		return (EReference)rgTransitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRgTransition_Event() {
		return (EAttribute)rgTransitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegionFactory getRegionFactory() {
		return (RegionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		rgRegionEClass = createEClass(RG_REGION);
		createEAttribute(rgRegionEClass, RG_REGION__CONTAINER_CLASS);
		createEReference(rgRegionEClass, RG_REGION__INITIAL_PSEUDOSTATE);
		createEReference(rgRegionEClass, RG_REGION__STATES);

		rgInitialPseudostateEClass = createEClass(RG_INITIAL_PSEUDOSTATE);
		createEReference(rgInitialPseudostateEClass, RG_INITIAL_PSEUDOSTATE__INITIAL_TRANSITION);

		rgStateEClass = createEClass(RG_STATE);
		createEAttribute(rgStateEClass, RG_STATE__ENTRY);
		createEAttribute(rgStateEClass, RG_STATE__EXIT);
		createEReference(rgStateEClass, RG_STATE__TRANSITIONS);

		rgTransitionEClass = createEClass(RG_TRANSITION);
		createEAttribute(rgTransitionEClass, RG_TRANSITION__MESSAGE);
		createEAttribute(rgTransitionEClass, RG_TRANSITION__EFFECT);
		createEReference(rgTransitionEClass, RG_TRANSITION__TARGET);
		createEAttribute(rgTransitionEClass, RG_TRANSITION__EVENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BasePackage theBasePackage = (BasePackage)EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		rgRegionEClass.getESuperTypes().add(theBasePackage.getModelRoot());
		rgInitialPseudostateEClass.getESuperTypes().add(theBasePackage.getNamed());
		rgStateEClass.getESuperTypes().add(theBasePackage.getNamed());
		rgTransitionEClass.getESuperTypes().add(theBasePackage.getReferenced());

		// Initialize classes, features, and operations; add parameters
		initEClass(rgRegionEClass, RgRegion.class, "RgRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRgRegion_ContainerClass(), theBasePackage.getNamedReference(), "containerClass", null, 1, 1, RgRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRgRegion_InitialPseudostate(), this.getRgInitialPseudostate(), null, "initialPseudostate", null, 1, 1, RgRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRgRegion_States(), this.getRgState(), null, "states", null, 1, -1, RgRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rgInitialPseudostateEClass, RgInitialPseudostate.class, "RgInitialPseudostate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRgInitialPseudostate_InitialTransition(), this.getRgTransition(), null, "initialTransition", null, 1, 1, RgInitialPseudostate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rgStateEClass, RgState.class, "RgState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRgState_Entry(), theBasePackage.getNamedReference(), "entry", null, 0, 1, RgState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRgState_Exit(), theBasePackage.getNamedReference(), "exit", null, 0, 1, RgState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRgState_Transitions(), this.getRgTransition(), null, "transitions", null, 0, -1, RgState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rgTransitionEClass, RgTransition.class, "RgTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRgTransition_Message(), theBasePackage.getNamedReference(), "message", null, 1, 1, RgTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRgTransition_Effect(), theBasePackage.getNamedReference(), "effect", null, 0, 1, RgTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRgTransition_Target(), this.getRgState(), null, "target", null, 1, 1, RgTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRgTransition_Event(), theBasePackage.getNamedReference(), "event", null, 0, 1, RgTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RegionPackageImpl
