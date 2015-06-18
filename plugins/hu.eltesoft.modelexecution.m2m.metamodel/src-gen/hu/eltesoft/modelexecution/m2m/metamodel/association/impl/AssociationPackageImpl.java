/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.association.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociation;
import hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationEnd;
import hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage;

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
public class AssociationPackageImpl extends EPackageImpl implements AssociationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass asAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass asAssociationEndEClass = null;

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
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AssociationPackageImpl() {
		super(eNS_URI, AssociationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AssociationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AssociationPackage init() {
		if (isInited) return (AssociationPackage)EPackage.Registry.INSTANCE.getEPackage(AssociationPackage.eNS_URI);

		// Obtain or create and register package
		AssociationPackageImpl theAssociationPackage = (AssociationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AssociationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AssociationPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		BasePackageImpl theBasePackage = (BasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) instanceof BasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) : BasePackage.eINSTANCE);
		BehaviorPackageImpl theBehaviorPackage = (BehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) instanceof BehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) : BehaviorPackage.eINSTANCE);
		ClassdefPackageImpl theClassdefPackage = (ClassdefPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassdefPackage.eNS_URI) instanceof ClassdefPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassdefPackage.eNS_URI) : ClassdefPackage.eINSTANCE);
		EventPackageImpl theEventPackage = (EventPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI) instanceof EventPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI) : EventPackage.eINSTANCE);
		RegionPackageImpl theRegionPackage = (RegionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RegionPackage.eNS_URI) instanceof RegionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RegionPackage.eNS_URI) : RegionPackage.eINSTANCE);
		SignalPackageImpl theSignalPackage = (SignalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SignalPackage.eNS_URI) instanceof SignalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SignalPackage.eNS_URI) : SignalPackage.eINSTANCE);

		// Create package meta-data objects
		theAssociationPackage.createPackageContents();
		theBasePackage.createPackageContents();
		theBehaviorPackage.createPackageContents();
		theClassdefPackage.createPackageContents();
		theEventPackage.createPackageContents();
		theRegionPackage.createPackageContents();
		theSignalPackage.createPackageContents();

		// Initialize created meta-data
		theAssociationPackage.initializePackageContents();
		theBasePackage.initializePackageContents();
		theBehaviorPackage.initializePackageContents();
		theClassdefPackage.initializePackageContents();
		theEventPackage.initializePackageContents();
		theRegionPackage.initializePackageContents();
		theSignalPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAssociationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AssociationPackage.eNS_URI, theAssociationPackage);
		return theAssociationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAsAssociation() {
		return asAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAsAssociation_Ends() {
		return (EReference)asAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAsAssociationEnd() {
		return asAssociationEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAsAssociationEnd_Type() {
		return (EReference)asAssociationEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationFactory getAssociationFactory() {
		return (AssociationFactory)getEFactoryInstance();
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
		asAssociationEClass = createEClass(AS_ASSOCIATION);
		createEReference(asAssociationEClass, AS_ASSOCIATION__ENDS);

		asAssociationEndEClass = createEClass(AS_ASSOCIATION_END);
		createEReference(asAssociationEndEClass, AS_ASSOCIATION_END__TYPE);
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
		asAssociationEClass.getESuperTypes().add(theBasePackage.getModelRoot());
		asAssociationEndEClass.getESuperTypes().add(theBasePackage.getNamed());

		// Initialize classes, features, and operations; add parameters
		initEClass(asAssociationEClass, AsAssociation.class, "AsAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAsAssociation_Ends(), this.getAsAssociationEnd(), null, "ends", null, 2, 2, AsAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(asAssociationEndEClass, AsAssociationEnd.class, "AsAssociationEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAsAssociationEnd_Type(), theBasePackage.getReferencedType(), null, "type", null, 1, 1, AsAssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AssociationPackageImpl
