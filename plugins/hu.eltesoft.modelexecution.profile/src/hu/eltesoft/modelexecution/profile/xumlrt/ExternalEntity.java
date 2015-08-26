/**
 */
package hu.eltesoft.modelexecution.profile.xumlrt;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.eltesoft.modelexecution.profile.xumlrt.ExternalEntity#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.profile.xumlrt.ExternalEntity#getClass_ <em>Class</em>}</li>
 *   <li>{@link hu.eltesoft.modelexecution.profile.xumlrt.ExternalEntity#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see hu.eltesoft.modelexecution.profile.xumlrt.xumlrtPackage#getExternalEntity()
 * @model
 * @generated
 */
public interface ExternalEntity extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see hu.eltesoft.modelexecution.profile.xumlrt.xumlrtPackage#getExternalEntity_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.profile.xumlrt.ExternalEntity#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass_(String)
	 * @see hu.eltesoft.modelexecution.profile.xumlrt.xumlrtPackage#getExternalEntity_Class()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.profile.xumlrt.ExternalEntity#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass_(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"Stateless"</code>.
	 * The literals are from the enumeration {@link hu.eltesoft.modelexecution.profile.xumlrt.EntityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see hu.eltesoft.modelexecution.profile.xumlrt.EntityType
	 * @see #setType(EntityType)
	 * @see hu.eltesoft.modelexecution.profile.xumlrt.xumlrtPackage#getExternalEntity_Type()
	 * @model default="Stateless" required="true" ordered="false"
	 * @generated
	 */
	EntityType getType();

	/**
	 * Sets the value of the '{@link hu.eltesoft.modelexecution.profile.xumlrt.ExternalEntity#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see hu.eltesoft.modelexecution.profile.xumlrt.EntityType
	 * @see #getType()
	 * @generated
	 */
	void setType(EntityType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tuple{
	 *   status=base_Class.ownedOperation->forAll(op | op.isStatic),
	 *   message='Only static operations are accepted on an external entity.',
	 *   severity=-5
	 * }.status
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean AllOperationsAreStatic(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Tuple{
	 *   status=base_Class.ownedAttribute->isEmpty(),
	 *   message='External entity must not have any attribute.',
	 *   severity=-5
	 * }.status
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean HasNoAttributes(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tuple{
	 *   status=class.matches('([\\p{L}_$][\\p{L}\\p{N}_$]*\\.)*[\\p{L}_$][\\p{L}\\p{N}_$]*'),
	 *   message='External entity must specify a fully qualified Java class name.',
	 *   severity=-5
	 * }.status
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ReferencedClassNameIsValid(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tuple{
	 *   status=base_Class.ownedOperation->forAll(op | op.name.matches('[\\p{L}_$][\\p{L}\\p{N}_$]*')),
	 *   message='Name of an operation on an external entity must be a valid Java method name.',
	 *   severity=-5
	 * }.status
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean OperationNamesAreValid(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tuple{
	 *   status=base_Class.ownedOperation->forAll(op | op.ownedParameter->size() <= 1),
	 *   message='Operation on an external entity could only have at most one parameter.',
	 *   severity=-5
	 * }.status
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean NumberOfParametersIsValid(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tuple{
	 *   status=base_Class.ownedOperation->forAll(op | op.ownedParameter->size() = 1 implies
	 *       let param : Parameter = op.ownedParameter->first()
	 *       in param.type.getAppliedStereotype('xUML-RT::Callable') <> null
	 *   ),
	 *   message='Type of a parameter on an external entity operation must be a class with Callable stereotype applied.',
	 *   severity=-5
	 * }.status
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ParameterIsCallable(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tuple{
	 *   status=base_Class.ownedOperation->forAll(op | op.ownedParameter->size() = 1 implies
	 *       let param : Parameter = op.ownedParameter->first()
	 *       in param.direction = ParameterDirectionKind::_'in'
	 *   ),
	 *   message='Only an input parameter is accepted on an external entity operation.',
	 *   severity=-5
	 * }.status
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ParameterDirectionIsIn(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tuple{
	 *   status=base_Class.ownedOperation->forAll(op | op.ownedParameter->size() = 1 implies
	 *       let param : Parameter = op.ownedParameter->first()
	 *       in param.name.matches('[\\p{L}_$][\\p{L}\\p{N}_$]*')
	 *   ),
	 *   message='Name of an operation parameter on an external entity must be a valid Java identifier.',
	 *   severity=-5
	 * }.status
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ParameterNameIsValid(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tuple{
	 *   status=base_Class.ownedOperation->forAll(op | op.ownedParameter->size() = 1 implies
	 *       let param : Parameter = op.ownedParameter->first()
	 *       in param.lower = 1 and param.upper = 1
	 *   ),
	 *   message='Multiplicity of an operation parameter on an external entity must be 1.',
	 *   severity=-5
	 * }.status
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ParameterMultiplicityIsOne(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Tuple{
	 *   status=base_Class.isAbstract,
	 *   message='External entity must be an abstract class.',
	 *   severity=-5
	 * }.status
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ClassMustBeAbstract(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tuple{
	 *   status=base_Class.name.matches('[\\p{L}_$][\\p{L}\\p{N}_$]*'),
	 *   message='Name of an external entity class must be a valid Java class name.',
	 *   severity=-5
	 * }.status
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ClassNameIsValid(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ExternalEntity
