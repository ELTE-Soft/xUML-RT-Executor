/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.region.util;

import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRootType;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced;
import hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject;

import hu.eltesoft.modelexecution.m2m.metamodel.region.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage
 * @generated
 */
public class RegionAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RegionPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegionAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RegionPackage.eINSTANCE;
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
	protected RegionSwitch<Adapter> modelSwitch =
		new RegionSwitch<Adapter>() {
			@Override
			public Adapter caseRgRegion(RgRegion object) {
				return createRgRegionAdapter();
			}
			@Override
			public Adapter caseRgClass(RgClass object) {
				return createRgClassAdapter();
			}
			@Override
			public Adapter caseRgState(RgState object) {
				return createRgStateAdapter();
			}
			@Override
			public Adapter caseRgTransition(RgTransition object) {
				return createRgTransitionAdapter();
			}
			@Override
			public Adapter caseRgEvent(RgEvent object) {
				return createRgEventAdapter();
			}
			@Override
			public Adapter caseRgBehavior(RgBehavior object) {
				return createRgBehaviorAdapter();
			}
			@Override
			public Adapter caseTranslationObject(TranslationObject object) {
				return createTranslationObjectAdapter();
			}
			@Override
			public Adapter caseModelRootType(ModelRootType object) {
				return createModelRootTypeAdapter();
			}
			@Override
			public Adapter caseNamed(Named object) {
				return createNamedAdapter();
			}
			@Override
			public Adapter caseReferenced(Referenced object) {
				return createReferencedAdapter();
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
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion <em>Rg Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion
	 * @generated
	 */
	public Adapter createRgRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgClass <em>Rg Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgClass
	 * @generated
	 */
	public Adapter createRgClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgState <em>Rg State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgState
	 * @generated
	 */
	public Adapter createRgStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition <em>Rg Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition
	 * @generated
	 */
	public Adapter createRgTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgEvent <em>Rg Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgEvent
	 * @generated
	 */
	public Adapter createRgEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.region.RgBehavior <em>Rg Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.region.RgBehavior
	 * @generated
	 */
	public Adapter createRgBehaviorAdapter() {
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
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRootType <em>Model Root Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRootType
	 * @generated
	 */
	public Adapter createModelRootTypeAdapter() {
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
	 * Creates a new adapter for an object of class '{@link hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced <em>Referenced</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.base.Referenced
	 * @generated
	 */
	public Adapter createReferencedAdapter() {
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

} //RegionAdapterFactory
