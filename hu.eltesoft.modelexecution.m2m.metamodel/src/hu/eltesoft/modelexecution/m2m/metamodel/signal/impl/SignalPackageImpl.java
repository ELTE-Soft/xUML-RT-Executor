/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.signal.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.event.EventPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EventPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SignalPackageImpl extends EPackageImpl implements SignalPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sgSignalEClass = null;

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
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SignalPackageImpl() {
		super(eNS_URI, SignalFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SignalPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SignalPackage init() {
		if (isInited) return (SignalPackage)EPackage.Registry.INSTANCE.getEPackage(SignalPackage.eNS_URI);

		// Obtain or create and register package
		SignalPackageImpl theSignalPackage = (SignalPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SignalPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SignalPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		BasePackageImpl theBasePackage = (BasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) instanceof BasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) : BasePackage.eINSTANCE);
		BehaviorPackageImpl theBehaviorPackage = (BehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) instanceof BehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) : BehaviorPackage.eINSTANCE);
		ClassdefPackageImpl theClassdefPackage = (ClassdefPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassdefPackage.eNS_URI) instanceof ClassdefPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassdefPackage.eNS_URI) : ClassdefPackage.eINSTANCE);
		EventPackageImpl theEventPackage = (EventPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI) instanceof EventPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI) : EventPackage.eINSTANCE);
		RegionPackageImpl theRegionPackage = (RegionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RegionPackage.eNS_URI) instanceof RegionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RegionPackage.eNS_URI) : RegionPackage.eINSTANCE);

		// Create package meta-data objects
		theSignalPackage.createPackageContents();
		theBasePackage.createPackageContents();
		theBehaviorPackage.createPackageContents();
		theClassdefPackage.createPackageContents();
		theEventPackage.createPackageContents();
		theRegionPackage.createPackageContents();

		// Initialize created meta-data
		theSignalPackage.initializePackageContents();
		theBasePackage.initializePackageContents();
		theBehaviorPackage.initializePackageContents();
		theClassdefPackage.initializePackageContents();
		theEventPackage.initializePackageContents();
		theRegionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSignalPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SignalPackage.eNS_URI, theSignalPackage);
		return theSignalPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSgSignal() {
		return sgSignalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalFactory getSignalFactory() {
		return (SignalFactory)getEFactoryInstance();
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
		sgSignalEClass = createEClass(SG_SIGNAL);
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
		sgSignalEClass.getESuperTypes().add(theBasePackage.getModelRootType());
		sgSignalEClass.getESuperTypes().add(theBasePackage.getNamed());

		// Initialize classes, features, and operations; add parameters
		initEClass(sgSignalEClass, SgSignal.class, "SgSignal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SignalPackageImpl
