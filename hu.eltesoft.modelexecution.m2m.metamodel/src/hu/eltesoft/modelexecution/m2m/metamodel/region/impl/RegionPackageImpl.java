/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region.impl;

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
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgBehavior;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgClass;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgEvent;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgState;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition;

import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SignalPackageImpl;

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
	private EClass rgClassEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rgEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rgBehaviorEClass = null;

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
		BasePackageImpl theBasePackage = (BasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) instanceof BasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) : BasePackage.eINSTANCE);
		BehaviorPackageImpl theBehaviorPackage = (BehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) instanceof BehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) : BehaviorPackage.eINSTANCE);
		ClassdefPackageImpl theClassdefPackage = (ClassdefPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassdefPackage.eNS_URI) instanceof ClassdefPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassdefPackage.eNS_URI) : ClassdefPackage.eINSTANCE);
		EventPackageImpl theEventPackage = (EventPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI) instanceof EventPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI) : EventPackage.eINSTANCE);
		SignalPackageImpl theSignalPackage = (SignalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SignalPackage.eNS_URI) instanceof SignalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SignalPackage.eNS_URI) : SignalPackage.eINSTANCE);

		// Create package meta-data objects
		theRegionPackage.createPackageContents();
		theBasePackage.createPackageContents();
		theBehaviorPackage.createPackageContents();
		theClassdefPackage.createPackageContents();
		theEventPackage.createPackageContents();
		theSignalPackage.createPackageContents();

		// Initialize created meta-data
		theRegionPackage.initializePackageContents();
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
	public EReference getRgRegion_ContainingClass() {
		return (EReference)rgRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRgRegion_InitialTransition() {
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
	public EClass getRgClass() {
		return rgClassEClass;
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
	public EReference getRgState_Entry() {
		return (EReference)rgStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRgState_Exit() {
		return (EReference)rgStateEClass.getEStructuralFeatures().get(1);
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
	public EReference getRgTransition_Event() {
		return (EReference)rgTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRgTransition_Effect() {
		return (EReference)rgTransitionEClass.getEStructuralFeatures().get(1);
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
	public EClass getRgEvent() {
		return rgEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRgBehavior() {
		return rgBehaviorEClass;
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
		createEReference(rgRegionEClass, RG_REGION__CONTAINING_CLASS);
		createEReference(rgRegionEClass, RG_REGION__INITIAL_TRANSITION);
		createEReference(rgRegionEClass, RG_REGION__STATES);

		rgClassEClass = createEClass(RG_CLASS);

		rgStateEClass = createEClass(RG_STATE);
		createEReference(rgStateEClass, RG_STATE__ENTRY);
		createEReference(rgStateEClass, RG_STATE__EXIT);
		createEReference(rgStateEClass, RG_STATE__TRANSITIONS);

		rgTransitionEClass = createEClass(RG_TRANSITION);
		createEReference(rgTransitionEClass, RG_TRANSITION__EVENT);
		createEReference(rgTransitionEClass, RG_TRANSITION__EFFECT);
		createEReference(rgTransitionEClass, RG_TRANSITION__TARGET);

		rgEventEClass = createEClass(RG_EVENT);

		rgBehaviorEClass = createEClass(RG_BEHAVIOR);
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
		rgRegionEClass.getESuperTypes().add(theBasePackage.getNamed());
		rgClassEClass.getESuperTypes().add(theBasePackage.getNamed());
		rgStateEClass.getESuperTypes().add(theBasePackage.getNamed());
		rgStateEClass.getESuperTypes().add(theBasePackage.getReferenced());
		rgTransitionEClass.getESuperTypes().add(theBasePackage.getReferenced());
		rgEventEClass.getESuperTypes().add(theBasePackage.getNamed());
		rgBehaviorEClass.getESuperTypes().add(theBasePackage.getNamed());

		// Initialize classes, features, and operations; add parameters
		initEClass(rgRegionEClass, RgRegion.class, "RgRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRgRegion_ContainingClass(), this.getRgClass(), null, "containingClass", null, 1, 1, RgRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRgRegion_InitialTransition(), this.getRgTransition(), null, "initialTransition", null, 0, 1, RgRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRgRegion_States(), this.getRgState(), null, "states", null, 1, -1, RgRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rgClassEClass, RgClass.class, "RgClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rgStateEClass, RgState.class, "RgState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRgState_Entry(), this.getRgBehavior(), null, "entry", null, 0, 1, RgState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRgState_Exit(), this.getRgBehavior(), null, "exit", null, 0, 1, RgState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRgState_Transitions(), this.getRgTransition(), null, "transitions", null, 1, -1, RgState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rgTransitionEClass, RgTransition.class, "RgTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRgTransition_Event(), this.getRgEvent(), null, "event", null, 1, 1, RgTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRgTransition_Effect(), this.getRgBehavior(), null, "effect", null, 0, 1, RgTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRgTransition_Target(), this.getRgState(), null, "target", null, 1, 1, RgTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rgEventEClass, RgEvent.class, "RgEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rgBehaviorEClass, RgBehavior.class, "RgBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //RegionPackageImpl
