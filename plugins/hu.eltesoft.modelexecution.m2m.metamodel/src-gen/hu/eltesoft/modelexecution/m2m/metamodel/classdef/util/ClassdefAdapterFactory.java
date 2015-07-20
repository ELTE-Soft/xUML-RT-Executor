/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.classdef.util;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Typed;

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage
 * @generated
 */
public class ClassdefAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ClassdefPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassdefAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ClassdefPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassdefSwitch<Adapter> modelSwitch =
		new ClassdefSwitch<Adapter>() {
			@Override
			public Adapter caseClClass(ClClass object) {
				return createClClassAdapter();
			}
			@Override
			public Adapter caseClClassSpec(ClClassSpec object) {
				return createClClassSpecAdapter();
			}
			@Override
			public Adapter caseClClassCommon(ClClassCommon object) {
				return createClClassCommonAdapter();
			}
			@Override
			public Adapter caseClOperation(ClOperation object) {
				return createClOperationAdapter();
			}
			@Override
			public Adapter caseClOperationSpec(ClOperationSpec object) {
				return createClOperationSpecAdapter();
			}
			@Override
			public Adapter caseClReception(ClReception object) {
				return createClReceptionAdapter();
			}
			@Override
			public Adapter caseClReceptionSpec(ClReceptionSpec object) {
				return createClReceptionSpecAdapter();
			}
			@Override
			public Adapter caseClReceptionParameter(ClReceptionParameter object) {
				return createClReceptionParameterAdapter();
			}
			@Override
			public Adapter caseClAttribute(ClAttribute object) {
				return createClAttributeAdapter();
			}
			@Override
			public Adapter caseClAttributeSpec(ClAttributeSpec object) {
				return createClAttributeSpecAdapter();
			}
			@Override
			public Adapter caseClInheritedAttribute(ClInheritedAttribute object) {
				return createClInheritedAttributeAdapter();
			}
			@Override
			public Adapter caseClAssociation(ClAssociation object) {
				return createClAssociationAdapter();
			}
			@Override
			public Adapter caseClCtorRecord(ClCtorRecord object) {
				return createClCtorRecordAdapter();
			}
			@Override
			public Adapter caseInherited(Inherited object) {
				return createInheritedAdapter();
			}
			@Override
			public Adapter caseTranslationObject(TranslationObject object) {
				return createTranslationObjectAdapter();
			}
			@Override
			public Adapter caseNamed(Named object) {
				return createNamedAdapter();
			}
			@Override
			public Adapter caseModelRoot(ModelRoot object) {
				return createModelRootAdapter();
			}
			@Override
			public Adapter caseMultiplicity(Multiplicity object) {
				return createMultiplicityAdapter();
			}
			@Override
			public Adapter caseTyped(Typed object) {
				return createTypedAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass <em>Cl Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
	 * @generated
	 */
	public Adapter createClClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec <em>Cl Class Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec
	 * @generated
	 */
	public Adapter createClClassSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassCommon <em>Cl Class Common</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassCommon
	 * @generated
	 */
	public Adapter createClClassCommonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation <em>Cl Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation
	 * @generated
	 */
	public Adapter createClOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec <em>Cl Operation Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec
	 * @generated
	 */
	public Adapter createClOperationSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception <em>Cl Reception</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception
	 * @generated
	 */
	public Adapter createClReceptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionSpec <em>Cl Reception Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionSpec
	 * @generated
	 */
	public Adapter createClReceptionSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionParameter <em>Cl Reception Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionParameter
	 * @generated
	 */
	public Adapter createClReceptionParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute <em>Cl Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute
	 * @generated
	 */
	public Adapter createClAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttributeSpec <em>Cl Attribute Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttributeSpec
	 * @generated
	 */
	public Adapter createClAttributeSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAttribute <em>Cl Inherited Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAttribute
	 * @generated
	 */
	public Adapter createClInheritedAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation <em>Cl Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation
	 * @generated
	 */
	public Adapter createClAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClCtorRecord <em>Cl Ctor Record</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClCtorRecord
	 * @generated
	 */
	public Adapter createClCtorRecordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.classdef.Inherited <em>Inherited</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.classdef.Inherited
	 * @generated
	 */
	public Adapter createInheritedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject <em>Translation Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject
	 * @generated
	 */
	public Adapter createTranslationObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Named <em>Named</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Named
	 * @generated
	 */
	public Adapter createNamedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot <em>Model Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot
	 * @generated
	 */
	public Adapter createModelRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity
	 * @generated
	 */
	public Adapter createMultiplicityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Typed <em>Typed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Typed
	 * @generated
	 */
	public Adapter createTypedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ClassdefAdapterFactory
