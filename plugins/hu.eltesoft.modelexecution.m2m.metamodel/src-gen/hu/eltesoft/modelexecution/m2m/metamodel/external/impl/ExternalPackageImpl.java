/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.external.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.association.impl.AssociationPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;

import hu.eltesoft.modelexecution.m2m.metamodel.base.impl.BasePackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.callable.CallablePackage;

import hu.eltesoft.modelexecution.m2m.metamodel.callable.impl.CallablePackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl.ClassdefPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.event.EventPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.event.impl.EventPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType;
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity;
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExOperation;
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.region.impl.RegionPackageImpl;

import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage;

import hu.eltesoft.modelexecution.m2m.metamodel.signal.impl.SignalPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExternalPackageImpl extends EPackageImpl implements ExternalPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exExternalEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum exEntityTypeEEnum = null;

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
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExternalPackageImpl() {
		super(eNS_URI, ExternalFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExternalPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExternalPackage init() {
		if (isInited) return (ExternalPackage)EPackage.Registry.INSTANCE.getEPackage(ExternalPackage.eNS_URI);

		// Obtain or create and register package
		ExternalPackageImpl theExternalPackage = (ExternalPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExternalPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExternalPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AssociationPackageImpl theAssociationPackage = (AssociationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AssociationPackage.eNS_URI) instanceof AssociationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AssociationPackage.eNS_URI) : AssociationPackage.eINSTANCE);
		BasePackageImpl theBasePackage = (BasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) instanceof BasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) : BasePackage.eINSTANCE);
		BehaviorPackageImpl theBehaviorPackage = (BehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) instanceof BehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) : BehaviorPackage.eINSTANCE);
		CallablePackageImpl theCallablePackage = (CallablePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CallablePackage.eNS_URI) instanceof CallablePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CallablePackage.eNS_URI) : CallablePackage.eINSTANCE);
		ClassdefPackageImpl theClassdefPackage = (ClassdefPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassdefPackage.eNS_URI) instanceof ClassdefPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassdefPackage.eNS_URI) : ClassdefPackage.eINSTANCE);
		EventPackageImpl theEventPackage = (EventPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI) instanceof EventPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI) : EventPackage.eINSTANCE);
		RegionPackageImpl theRegionPackage = (RegionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RegionPackage.eNS_URI) instanceof RegionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RegionPackage.eNS_URI) : RegionPackage.eINSTANCE);
		SignalPackageImpl theSignalPackage = (SignalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SignalPackage.eNS_URI) instanceof SignalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SignalPackage.eNS_URI) : SignalPackage.eINSTANCE);

		// Create package meta-data objects
		theExternalPackage.createPackageContents();
		theAssociationPackage.createPackageContents();
		theBasePackage.createPackageContents();
		theBehaviorPackage.createPackageContents();
		theCallablePackage.createPackageContents();
		theClassdefPackage.createPackageContents();
		theEventPackage.createPackageContents();
		theRegionPackage.createPackageContents();
		theSignalPackage.createPackageContents();

		// Initialize created meta-data
		theExternalPackage.initializePackageContents();
		theAssociationPackage.initializePackageContents();
		theBasePackage.initializePackageContents();
		theBehaviorPackage.initializePackageContents();
		theCallablePackage.initializePackageContents();
		theClassdefPackage.initializePackageContents();
		theEventPackage.initializePackageContents();
		theRegionPackage.initializePackageContents();
		theSignalPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExternalPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExternalPackage.eNS_URI, theExternalPackage);
		return theExternalPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExExternalEntity() {
		return exExternalEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExExternalEntity_Operations() {
		return (EReference)exExternalEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExExternalEntity_ImplementationClass() {
		return (EAttribute)exExternalEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExExternalEntity_Type() {
		return (EAttribute)exExternalEntityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExOperation() {
		return exOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExOperation_ProxyClass() {
		return (EAttribute)exOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExEntityType() {
		return exEntityTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalFactory getExternalFactory() {
		return (ExternalFactory)getEFactoryInstance();
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
		exExternalEntityEClass = createEClass(EX_EXTERNAL_ENTITY);
		createEReference(exExternalEntityEClass, EX_EXTERNAL_ENTITY__OPERATIONS);
		createEAttribute(exExternalEntityEClass, EX_EXTERNAL_ENTITY__IMPLEMENTATION_CLASS);
		createEAttribute(exExternalEntityEClass, EX_EXTERNAL_ENTITY__TYPE);

		exOperationEClass = createEClass(EX_OPERATION);
		createEAttribute(exOperationEClass, EX_OPERATION__PROXY_CLASS);

		// Create enums
		exEntityTypeEEnum = createEEnum(EX_ENTITY_TYPE);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		exExternalEntityEClass.getESuperTypes().add(theBasePackage.getModelRoot());
		exOperationEClass.getESuperTypes().add(theBasePackage.getNamed());

		// Initialize classes, features, and operations; add parameters
		initEClass(exExternalEntityEClass, ExExternalEntity.class, "ExExternalEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExExternalEntity_Operations(), this.getExOperation(), null, "operations", null, 0, -1, ExExternalEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExExternalEntity_ImplementationClass(), ecorePackage.getEString(), "implementationClass", null, 1, 1, ExExternalEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExExternalEntity_Type(), this.getExEntityType(), "type", null, 1, 1, ExExternalEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exOperationEClass, ExOperation.class, "ExOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExOperation_ProxyClass(), theEcorePackage.getEString(), "proxyClass", null, 0, 1, ExOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(exEntityTypeEEnum, ExEntityType.class, "ExEntityType");
		addEEnumLiteral(exEntityTypeEEnum, ExEntityType.STATELESS);
		addEEnumLiteral(exEntityTypeEEnum, ExEntityType.SINGLETON);

		// Create resource
		createResource(eNS_URI);
	}

} //ExternalPackageImpl
