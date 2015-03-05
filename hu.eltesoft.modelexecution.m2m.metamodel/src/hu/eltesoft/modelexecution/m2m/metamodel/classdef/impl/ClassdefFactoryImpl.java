/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef.impl;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassdefFactoryImpl extends EFactoryImpl implements ClassdefFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassdefFactory init() {
		try {
			ClassdefFactory theClassdefFactory = (ClassdefFactory)EPackage.Registry.INSTANCE.getEFactory(ClassdefPackage.eNS_URI);
			if (theClassdefFactory != null) {
				return theClassdefFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ClassdefFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdefFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ClassdefPackage.CL_CLASS: return createClClass();
			case ClassdefPackage.CL_OPERATION: return createClOperation();
			case ClassdefPackage.CL_RECEPTION: return createClReception();
			case ClassdefPackage.CL_SIGNAL: return createClSignal();
			case ClassdefPackage.CL_REGION: return createClRegion();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClClass createClClass() {
		ClClassImpl clClass = new ClClassImpl();
		return clClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClOperation createClOperation() {
		ClOperationImpl clOperation = new ClOperationImpl();
		return clOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClReception createClReception() {
		ClReceptionImpl clReception = new ClReceptionImpl();
		return clReception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClSignal createClSignal() {
		ClSignalImpl clSignal = new ClSignalImpl();
		return clSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClRegion createClRegion() {
		ClRegionImpl clRegion = new ClRegionImpl();
		return clRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdefPackage getClassdefPackage() {
		return (ClassdefPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ClassdefPackage getPackage() {
		return ClassdefPackage.eINSTANCE;
	}

} //ClassdefFactoryImpl
