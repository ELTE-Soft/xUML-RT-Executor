/**
 */
package hu.eltesoft.modelexecution.m2m.metamodel.behavior;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorFactory
 * @model kind="package"
 * @generated
 */
public interface BehaviorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "behavior";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eltesoft.hu/modelexecution/m2m/metamodel/behavior";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.eltesoft.modelexecution.m2m.metamodel.behavior";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BehaviorPackage eINSTANCE = hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl <em>Bh Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorPackageImpl#getBhBehavior()
	 * @generated
	 */
	int BH_BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR__REFERENCE = BasePackage.MODEL_ROOT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR__CONTAINER_CLASS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Alf Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR__ALF_RESULT = BasePackage.MODEL_ROOT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR__PARAMETERS = BasePackage.MODEL_ROOT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR__IS_STATIC = BasePackage.MODEL_ROOT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR__RETURN_TYPE = BasePackage.MODEL_ROOT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Bh Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR_FEATURE_COUNT = BasePackage.MODEL_ROOT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Bh Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BH_BEHAVIOR_OPERATION_COUNT = BasePackage.MODEL_ROOT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>Alf Analyzer Result</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorPackageImpl#getAlfAnalyzerResult()
	 * @generated
	 */
	int ALF_ANALYZER_RESULT = 1;


	/**
	 * Returns the meta object for class '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior <em>Bh Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bh Behavior</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior
	 * @generated
	 */
	EClass getBhBehavior();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getContainerClass <em>Container Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container Class</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getContainerClass()
	 * @see #getBhBehavior()
	 * @generated
	 */
	EAttribute getBhBehavior_ContainerClass();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getAlfResult <em>Alf Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alf Result</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getAlfResult()
	 * @see #getBhBehavior()
	 * @generated
	 */
	EAttribute getBhBehavior_AlfResult();

	/**
	 * Returns the meta object for the reference list '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getParameters()
	 * @see #getBhBehavior()
	 * @generated
	 */
	EReference getBhBehavior_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#isIsStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#isIsStatic()
	 * @see #getBhBehavior()
	 * @generated
	 */
	EAttribute getBhBehavior_IsStatic();

	/**
	 * Returns the meta object for the reference '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Return Type</em>'.
	 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior#getReturnType()
	 * @see #getBhBehavior()
	 * @generated
	 */
	EReference getBhBehavior_ReturnType();

	/**
	 * Returns the meta object for data type '{@link hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult <em>Alf Analyzer Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Alf Analyzer Result</em>'.
	 * @see hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult
	 * @model instanceClass="hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult"
	 * @generated
	 */
	EDataType getAlfAnalyzerResult();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BehaviorFactory getBehaviorFactory();

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
		 * The meta object literal for the '{@link hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl <em>Bh Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BhBehaviorImpl
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorPackageImpl#getBhBehavior()
		 * @generated
		 */
		EClass BH_BEHAVIOR = eINSTANCE.getBhBehavior();

		/**
		 * The meta object literal for the '<em><b>Container Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BH_BEHAVIOR__CONTAINER_CLASS = eINSTANCE.getBhBehavior_ContainerClass();

		/**
		 * The meta object literal for the '<em><b>Alf Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BH_BEHAVIOR__ALF_RESULT = eINSTANCE.getBhBehavior_AlfResult();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BH_BEHAVIOR__PARAMETERS = eINSTANCE.getBhBehavior_Parameters();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BH_BEHAVIOR__IS_STATIC = eINSTANCE.getBhBehavior_IsStatic();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BH_BEHAVIOR__RETURN_TYPE = eINSTANCE.getBhBehavior_ReturnType();

		/**
		 * The meta object literal for the '<em>Alf Analyzer Result</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult
		 * @see hu.eltesoft.modelexecution.m2m.metamodel.behavior.impl.BehaviorPackageImpl#getAlfAnalyzerResult()
		 * @generated
		 */
		EDataType ALF_ANALYZER_RESULT = eINSTANCE.getAlfAnalyzerResult();

	}

} //BehaviorPackage
