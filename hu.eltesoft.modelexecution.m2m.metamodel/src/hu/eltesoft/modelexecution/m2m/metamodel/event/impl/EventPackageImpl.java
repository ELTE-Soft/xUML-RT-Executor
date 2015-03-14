/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.event.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.event.EvEvent;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EventFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EventPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionPackageImpl;

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
public class EventPackageImpl extends EPackageImpl implements EventPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evSignalEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evSignalEClass = null;

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
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.event.EventPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EventPackageImpl() {
		super(eNS_URI, EventFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EventPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EventPackage init() {
		if (isInited) return (EventPackage)EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI);

		// Obtain or create and register package
		EventPackageImpl theEventPackage = (EventPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EventPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EventPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		BasePackageImpl theBasePackage = (BasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) instanceof BasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) : BasePackage.eINSTANCE);
		BehaviorPackageImpl theBehaviorPackage = (BehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) instanceof BehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) : BehaviorPackage.eINSTANCE);
		ClassdefPackageImpl theClassdefPackage = (ClassdefPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassdefPackage.eNS_URI) instanceof ClassdefPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassdefPackage.eNS_URI) : ClassdefPackage.eINSTANCE);
		RegionPackageImpl theRegionPackage = (RegionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RegionPackage.eNS_URI) instanceof RegionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RegionPackage.eNS_URI) : RegionPackage.eINSTANCE);
		SignalPackageImpl theSignalPackage = (SignalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SignalPackage.eNS_URI) instanceof SignalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SignalPackage.eNS_URI) : SignalPackage.eINSTANCE);

		// Create package meta-data objects
		theEventPackage.createPackageContents();
		theBasePackage.createPackageContents();
		theBehaviorPackage.createPackageContents();
		theClassdefPackage.createPackageContents();
		theRegionPackage.createPackageContents();
		theSignalPackage.createPackageContents();

		// Initialize created meta-data
		theEventPackage.initializePackageContents();
		theBasePackage.initializePackageContents();
		theBehaviorPackage.initializePackageContents();
		theClassdefPackage.initializePackageContents();
		theRegionPackage.initializePackageContents();
		theSignalPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEventPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EventPackage.eNS_URI, theEventPackage);
		return theEventPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvEvent() {
		return evEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvSignalEvent() {
		return evSignalEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvSignalEvent_Signal() {
		return (EReference)evSignalEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvSignal() {
		return evSignalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventFactory getEventFactory() {
		return (EventFactory)getEFactoryInstance();
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
		evEventEClass = createEClass(EV_EVENT);

		evSignalEventEClass = createEClass(EV_SIGNAL_EVENT);
		createEReference(evSignalEventEClass, EV_SIGNAL_EVENT__SIGNAL);

		evSignalEClass = createEClass(EV_SIGNAL);
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
		evEventEClass.getESuperTypes().add(theBasePackage.getModelRootType());
		evEventEClass.getESuperTypes().add(theBasePackage.getNamed());
		evSignalEventEClass.getESuperTypes().add(this.getEvEvent());
		evSignalEClass.getESuperTypes().add(theBasePackage.getNamed());

		// Initialize classes, features, and operations; add parameters
		initEClass(evEventEClass, EvEvent.class, "EvEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(evSignalEventEClass, EvSignalEvent.class, "EvSignalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvSignalEvent_Signal(), this.getEvSignal(), null, "signal", null, 1, 1, EvSignalEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evSignalEClass, EvSignal.class, "EvSignal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EventPackageImpl
