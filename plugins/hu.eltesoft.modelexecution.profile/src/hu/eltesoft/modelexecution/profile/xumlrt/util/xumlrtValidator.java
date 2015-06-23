/**
 */
package hu.eltesoft.modelexecution.profile.xumlrt.util;

import hu.eltesoft.modelexecution.profile.xumlrt.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see hu.eltesoft.modelexecution.profile.xumlrt.xumlrtPackage
 * @generated
 */
public class xumlrtValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final xumlrtValidator INSTANCE = new xumlrtValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "hu.eltesoft.modelexecution.profile.xumlrt";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Class Name Is Valid' of 'Callable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALLABLE__CLASS_NAME_IS_VALID = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Reception Names Are Valid' of 'Callable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALLABLE__RECEPTION_NAMES_ARE_VALID = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'All Operations Are Non Static' of 'External Entity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_ENTITY__ALL_OPERATIONS_ARE_NON_STATIC = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has No Attributes' of 'External Entity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_ENTITY__HAS_NO_ATTRIBUTES = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Referenced Class Name Is Valid' of 'External Entity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_ENTITY__REFERENCED_CLASS_NAME_IS_VALID = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Operation Names Are Valid' of 'External Entity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_ENTITY__OPERATION_NAMES_ARE_VALID = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Number Of Parameters Is Valid' of 'External Entity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_ENTITY__NUMBER_OF_PARAMETERS_IS_VALID = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Parameter Is Callable' of 'External Entity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_ENTITY__PARAMETER_IS_CALLABLE = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Parameter Direction Is In' of 'External Entity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_ENTITY__PARAMETER_DIRECTION_IS_IN = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Parameter Name Is Valid' of 'External Entity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_ENTITY__PARAMETER_NAME_IS_VALID = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Parameter Multiplicity Is One' of 'External Entity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_ENTITY__PARAMETER_MULTIPLICITY_IS_ONE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Class Must Be Abstract' of 'External Entity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_ENTITY__CLASS_MUST_BE_ABSTRACT = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Class Name Is Valid' of 'External Entity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTERNAL_ENTITY__CLASS_NAME_IS_VALID = 13;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 13;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public xumlrtValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return xumlrtPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case xumlrtPackage.CALLABLE:
				return validateCallable((Callable)value, diagnostics, context);
			case xumlrtPackage.EXTERNAL_ENTITY:
				return validateExternalEntity((ExternalEntity)value, diagnostics, context);
			case xumlrtPackage.ENTITY_TYPE:
				return validateEntityType((EntityType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallable(Callable callable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(callable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(callable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(callable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(callable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(callable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(callable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(callable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(callable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(callable, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallable_ClassNameIsValid(callable, diagnostics, context);
		if (result || diagnostics != null) result &= validateCallable_ReceptionNamesAreValid(callable, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ClassNameIsValid constraint of '<em>Callable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallable_ClassNameIsValid(Callable callable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return callable.ClassNameIsValid(diagnostics, context);
	}

	/**
	 * Validates the ReceptionNamesAreValid constraint of '<em>Callable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallable_ReceptionNamesAreValid(Callable callable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return callable.ReceptionNamesAreValid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEntity(ExternalEntity externalEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(externalEntity, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalEntity_AllOperationsAreNonStatic(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalEntity_HasNoAttributes(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalEntity_ReferencedClassNameIsValid(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalEntity_OperationNamesAreValid(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalEntity_NumberOfParametersIsValid(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalEntity_ParameterIsCallable(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalEntity_ParameterDirectionIsIn(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalEntity_ParameterNameIsValid(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalEntity_ParameterMultiplicityIsOne(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalEntity_ClassMustBeAbstract(externalEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalEntity_ClassNameIsValid(externalEntity, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AllOperationsAreNonStatic constraint of '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEntity_AllOperationsAreNonStatic(ExternalEntity externalEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalEntity.AllOperationsAreNonStatic(diagnostics, context);
	}

	/**
	 * Validates the HasNoAttributes constraint of '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEntity_HasNoAttributes(ExternalEntity externalEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalEntity.HasNoAttributes(diagnostics, context);
	}

	/**
	 * Validates the ReferencedClassNameIsValid constraint of '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEntity_ReferencedClassNameIsValid(ExternalEntity externalEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalEntity.ReferencedClassNameIsValid(diagnostics, context);
	}

	/**
	 * Validates the OperationNamesAreValid constraint of '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEntity_OperationNamesAreValid(ExternalEntity externalEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalEntity.OperationNamesAreValid(diagnostics, context);
	}

	/**
	 * Validates the NumberOfParametersIsValid constraint of '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEntity_NumberOfParametersIsValid(ExternalEntity externalEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalEntity.NumberOfParametersIsValid(diagnostics, context);
	}

	/**
	 * Validates the ParameterIsCallable constraint of '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEntity_ParameterIsCallable(ExternalEntity externalEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalEntity.ParameterIsCallable(diagnostics, context);
	}

	/**
	 * Validates the ParameterDirectionIsIn constraint of '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEntity_ParameterDirectionIsIn(ExternalEntity externalEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalEntity.ParameterDirectionIsIn(diagnostics, context);
	}

	/**
	 * Validates the ParameterNameIsValid constraint of '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEntity_ParameterNameIsValid(ExternalEntity externalEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalEntity.ParameterNameIsValid(diagnostics, context);
	}

	/**
	 * Validates the ParameterMultiplicityIsOne constraint of '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEntity_ParameterMultiplicityIsOne(ExternalEntity externalEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalEntity.ParameterMultiplicityIsOne(diagnostics, context);
	}

	/**
	 * Validates the ClassMustBeAbstract constraint of '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEntity_ClassMustBeAbstract(ExternalEntity externalEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalEntity.ClassMustBeAbstract(diagnostics, context);
	}

	/**
	 * Validates the ClassNameIsValid constraint of '<em>External Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalEntity_ClassNameIsValid(ExternalEntity externalEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return externalEntity.ClassNameIsValid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntityType(EntityType entityType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //xumlrtValidator
