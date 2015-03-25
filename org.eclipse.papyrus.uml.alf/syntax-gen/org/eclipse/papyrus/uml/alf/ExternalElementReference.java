/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A direct reference to a UML model element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ExternalElementReference#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ExternalElementReference#getAlias <em>Alias</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExternalElementReference()
 * @model
 * @generated
 */
public interface ExternalElementReference extends ElementReference {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referenced model element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExternalElementReference_Element()
	 * @model required="true"
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ExternalElementReference#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The alias for the model element, if this is a reference to an imported
	 * element with multiple names within a namespace.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alias</em>' attribute.
	 * @see #setAlias(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExternalElementReference_Alias()
	 * @model
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ExternalElementReference#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='true'"
	 * @generated
	 */
	boolean isUml();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element'"
	 * @generated
	 */
	EObject asUml();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamedElement() then null\n        else\n          Member{\n            visibility = self.visibility(), \n            definition = ImportedMember{name = self.name(), referent = self}\n          }\n        endif'"
	 * @generated
	 */
	Member asMember();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if member.isAlf() then member.isSameKindAs(self)\n        else\n          let other = member.asUml().oclAsType(UML::Element) in\n            self.element.oclIsKindOf(other.oclType()) or\n            other.oclIsKindOf(self.element.oclType())\n        endif'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::NamedElement)'"
	 * @generated
	 */
	boolean isNamedElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Namespace)'"
	 * @generated
	 */
	boolean isNamespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isNamespace()'"
	 * @generated
	 */
	boolean isNamespaceFor(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isModelNamespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Package)'"
	 * @generated
	 */
	boolean isPackage();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Profile)'"
	 * @generated
	 */
	boolean isProfile();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::PackageableElement)'"
	 * @generated
	 */
	boolean isPackageableElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Classifier)'"
	 * @generated
	 */
	boolean isClassifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isClassifier() and self.element.oclAsType(UML::Classifier).isAbstract'"
	 * @generated
	 */
	boolean isAbstractClassifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Association)'"
	 * @generated
	 */
	boolean isAssociation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::DataType)'"
	 * @generated
	 */
	boolean isDataType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Class) and not self.element.oclIsKindOf(UML::Behavior)'"
	 * @generated
	 */
	boolean isClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isClass() and self.element.oclAsType(UML::Class).isActive'"
	 * @generated
	 */
	boolean isActiveClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Signal)'"
	 * @generated
	 */
	boolean isSignal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Enumeration)'"
	 * @generated
	 */
	boolean isEnumeration();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Behavior)'"
	 * @generated
	 */
	boolean isBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Activity)'"
	 * @generated
	 */
	boolean isActivity();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isBehavior() and\n          self.element.oclAsType(UML::Behavior).specification <> null'"
	 * @generated
	 */
	boolean isMethod();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Reception)'"
	 * @generated
	 */
	boolean isReception();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::PrimitiveType)'"
	 * @generated
	 */
	boolean isPrimitiveType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Operation)'"
	 * @generated
	 */
	boolean isOperation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isOperation() and \n        self.element.oclAsType(UML::Element).\n          getAppliedStereotype(\'StandardProfile::Create\') <> null'"
	 * @generated
	 */
	boolean isConstructor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isOperation() and \n        self.element.oclAsType(UML::Element).\n          getAppliedStereotype(\'StandardProfile::Destroy\') <> null'"
	 * @generated
	 */
	boolean isDestructor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Feature)'"
	 * @generated
	 */
	boolean isFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Property)'"
	 * @generated
	 */
	boolean isProperty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isProperty() and \n        -- Note: Only association-owned ends are considered as association ends.\n        self.element.oclAsType(UML::Property).owningAssociation <> null'"
	 * @generated
	 */
	boolean isAssociationEnd();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Parameter)'"
	 * @generated
	 */
	boolean isParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.element.oclIsKindOf(UML::TemplateableElement) and\n        self.element.oclAsType(UML::TemplateableElement).isTemplate()'"
	 * @generated
	 */
	boolean isTemplate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::TemplateParameter)'"
	 * @generated
	 */
	boolean isTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::ClassifierTemplateParameter)'"
	 * @generated
	 */
	boolean isClassifierTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.element.oclIsKindOf(UML::Classifier) and\n        self.element.oclAsType(UML::Classifier).templateParameter <> null'"
	 * @generated
	 */
	boolean isParameteredElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.umlTemplateBinding()->notEmpty()'"
	 * @generated
	 */
	boolean isTemplateBinding();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::Stereotype)'"
	 * @generated
	 */
	boolean isStereotype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(UML::EnumerationLiteral)'"
	 * @generated
	 */
	boolean isEnumerationLiteral();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isLoopVariable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isAnnotation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isSequenceExpansionExpression();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if alias <> null then\n          alias\n        else if self.element.oclIsKindOf(UML::NamedElement) then \n          self.element.oclAsType(UML::NamedElement).name\n        else if self.element.oclIsKindOf(UML::TemplateParameter) then\n          let parameteredElement = \n            self.element.oclAsType(UML::TemplateParameter).parameteredElement \n          in\n            if parameteredElement.oclIsKindOf(UML::NamedElement) then\n              parameteredElement.oclAsType(UML::NamedElement).name\n            else\n              null\n            endif\n        else\n          null\n        endif endif endif'"
	 * @generated
	 */
	String name();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.element.oclIsKindOf(UML::NamedElement) then \'\'\n        else\n          let visibility = self.element.oclAsType(UML::NamedElement).visibility in \n            if visibility = null then null\n            else if visibility = UML::VisibilityKind::public then \'public\'\n            else if visibility = UML::VisibilityKind::protected then \'protected\'\n            else if visibility = UML::VisibilityKind::private then \'private\'\n            else \'\'\n            endif endif endif endif\n        endif'"
	 * @generated
	 */
	String visibility();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamespace() then OrderedSet(ElementReference){}\n        else \n          self.element.oclAsType(UML::Namespace).ownedMember->\n            collect(m | ExternalElementReference{element = m})->asOrderedSet()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> ownedMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * EXTERNAL
	 * (Workaround for a seeming OCL bug "unboxing" enumeration literals.)
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<ElementReference> enumerationMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamespace() then OrderedSet(ElementReference){}\n        else\n          let namespace = self.element.oclAsType(UML::Namespace) in\n          let members = \n            if self.isEnumeration() then\n              self.enumerationMembers()\n            else\n            namespace.member-> \n              collect(m | \n                let names = namespace.getNamesOfMember(m) in\n                  if names->isEmpty() then\n                    Bag{ExternalElementReference{element = m}}\n                  else\n                    names->collect(name | \n                      ExternalElementReference{alias = name, element = m}\n                    )\n                  endif\n              )->asOrderedSet()\n              endif\n          in\n          let additionalMembers = self.additionalMembers() in\n            additionalMembers->includingAll(members)->\n              includingAll(self.templateParameters())\n        endif'"
	 * @generated
	 */
	EList<ElementReference> members();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isClassifier() then OrderedSet(ElementReference){}\n        else\n          -- This will collect the inherited members from the effective  \n          -- expanded bound elements of each parent that is a template binding. \n          self.parents()->select(isTemplateBinding())->asOrderedSet()->\n            collect(binding |\n              binding.oclAsType(ExternalElementReference).inherit(\n                binding.template().bind(binding.templateActuals()->asSequence()).\n                  members()->select(visibility() <> \'private\')\n              )\n            )->asOrderedSet()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> additionalMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inheritableMembersMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        -- NOTE: This is used to reject operations that would be inherited\n        -- via a template binding, in the case that the template binding itself\n        -- has an operation that should hide the inheritable operation.\n        -- This is used in the Alf standard library implementation as a\n        -- substitute for redefinition of operations from template instantiation. \n        let ownedOperations = self.ownedMembers()->select(isOperation()) in\n          inheritableMembers->reject(inheritableMember |\n            ownedOperations->exists(not isDistinguishableFrom(inheritableMember))\n          )'"
	 * @generated
	 */
	EList<ElementReference> inherit(EList<ElementReference> inheritableMembers);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isClassifier() then OrderedSet(ElementReference){}\n        else if self.isAssociation() then\n        -- NOTE: This is to ensure proper ordering.\n          self.memberEnds()->includingAll(self.parents().properties())\n        else\n          self.element.oclAsType(UML::Classifier).allAttributes()->\n            collect(a | ExternalElementReference{element = a})->\n            asOrderedSet()\n        endif endif'"
	 * @generated
	 */
	EList<ElementReference> properties();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isAssociation() then OrderedSet(ElementReference){}\n        else\n          self.element.oclAsType(UML::Association).memberEnd->\n          collect(e | ExternalElementReference{element = e})->\n          asOrderedSet()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> memberEnds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        -- NOTE: This is to ensure proper ordering.\n        self.ownedEnds()->includingAll(self.parents().associationEnds())'"
	 * @generated
	 */
	EList<ElementReference> associationEnds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isAssociation() then OrderedSet(ElementReference){}\n        else\n          self.element.oclAsType(UML::Association).ownedEnd->\n          collect(e | ExternalElementReference{element = e})->\n          asOrderedSet()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> ownedEnds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n--        if not self.isProperty() then null\n--        else self.element.oclAsType(UML::Property).opposite()\n--        endif;\n        if not self.isAssociationEnd() then null\n        else\n          let property = self.element.oclAsType(UML::Property) in\n            let association = property.association in\n            let ends = association.memberEnd in\n              if ends->size() <> 2 then null\n              else ExternalElementReference{element= ends->any(e | e <> property)}\n              endif\n        endif'"
	 * @generated
	 */
	ElementReference opposite();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isReception() then\n          null\n        else\n          ExternalElementReference{\n            element = self.element.oclAsType(UML::Reception).signal\n          }\n        endif'"
	 * @generated
	 */
	ElementReference signal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isParameteredElement() then\n          ExternalElementReference{\n            element = self.element.oclAsType(UML::ParameterableElement).\n                        templateParameter.signature.template\n          }\n        else if self.element.oclIsKindOf(UML::NamedElement) then\n          let namespace = self.element.oclAsType(UML::NamedElement).namespace in\n            if namespace = null then\n              null\n            else\n              ExternalElementReference{element = namespace}\n            endif\n        else\n          null\n        endif endif'"
	 * @generated
	 */
	ElementReference namespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.parameters()\n          else if self.isBehavior() then\n            self.element.oclAsType(UML::Behavior).ownedParameter\n          else if self.isOperation() then\n            self.element.oclAsType(UML::Operation).ownedParameter\n          else\n            OrderedSet{}\n          endif endif endif'"
	 * @generated
	 */
	EList<EObject> ownedParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.ownedParameters().oclAsType(UML::Parameter)->\n          reject(direction = UML::ParameterDirectionKind::return)->\n          collect(parameter |\n            ExternalElementReference{element = parameter}\n          )->asOrderedSet()'"
	 * @generated
	 */
	EList<ElementReference> parameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let returnParameters = self.ownedParameters().oclAsType(UML::Parameter)->\n          select(direction = UML::ParameterDirectionKind::return) \n        in\n          if returnParameters->isEmpty() then\n            null\n          else\n            ExternalElementReference{element = returnParameters->any(true)}\n          endif'"
	 * @generated
	 */
	ElementReference returnParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isOperation() then \n          self\n        else if self.isBehavior() then\n          let specification = self.element.oclAsType(UML::Behavior).specification in\n            if specification = null then null\n            else ExternalElementReference{element = specification}\n            endif\n        else \n          null\n        endif endif'"
	 * @generated
	 */
	ElementReference specification();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isOperation() then Set(ElementReference){}\n        else\n          self.element.oclAsType(UML::Operation).redefinedOperation->\n            collect(op | ExternalElementReference{element = op})\n        endif'"
	 * @generated
	 */
	EList<ElementReference> redefinedOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let templateBinding = self.umlTemplateBinding() in\n          if templateBinding = null or \n            templateBinding.oclAsType(UML::TemplateBinding).signature = null then\n            null\n          else\n            ExternalElementReference{\n              element = templateBinding.oclAsType(UML::TemplateBinding).signature.template\n            }\n          endif'"
	 * @generated
	 */
	ElementReference template();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.element.oclIsKindOf(UML::TemplateableElement) then\n          let templateBindings = \n            self.element.oclAsType(UML::TemplateableElement).templateBinding \n          in\n            if templateBindings->notEmpty() then\n              templateBindings->any(true)\n            else if self.element.oclIsKindOf(UML::NamedElement) then\n              let templateBindings =\n                self.element.oclAsType(UML::NamedElement).clientDependency->select(\n                    oclIsKindOf(UML::Realization) and\n                    supplier->size() = 1 and\n                    supplier->forAll(oclIsKindOf(UML::TemplateableElement))\n                  )->collect(\n                    supplier.oclAsType(UML::TemplateableElement).templateBinding\n                  )\n              in\n                if templateBindings->isEmpty() then\n                  null\n                else\n                  templateBindings->any(true)\n                endif\n            else\n              null\n            endif endif\n        else\n          null\n        endif'"
	 * @generated
	 */
	EObject umlTemplateBinding();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isTemplate() then\n          self.element.oclAsType(UML::TemplateableElement).\n            ownedTemplateSignature.parameter->\n            collect(p | ExternalElementReference{element = p})->asOrderedSet()\n        else\n          OrderedSet(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> templateParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isTemplate() then\n          self.element.oclAsType(UML::TemplateableElement).\n            ownedTemplateSignature.parameter.parameteredElement->\n            collect(p | ExternalElementReference{element = p})->asOrderedSet()\n        else\n          OrderedSet(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> parameteredElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let t = self.umlTemplateBinding() in\n          if t = null then\n            OrderedSet(ElementReference){}\n          else\n            let templateBinding = t.oclAsType(UML::TemplateBinding) in\n            let parameterSubstitution = templateBinding.parameterSubstitution in\n              templateBinding.signature.parameter->collect(parameter |\n                parameterSubstitution->select(formal = parameter).actual\n              )->collect(actual |\n                ExternalElementReference{element = actual}\n              )->asOrderedSet()\n          endif'"
	 * @generated
	 */
	EList<ElementReference> templateActuals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isParameter() then\n          let direction = self.element.oclAsType(UML::Parameter).direction in\n            if direction = UML::ParameterDirectionKind::_in then \'in\'\n            else if direction = UML::ParameterDirectionKind::_in then \'in\'\n            else if direction = UML::ParameterDirectionKind::out then \'out\'\n            else if direction = UML::ParameterDirectionKind::inout then \'inout\'\n            else if direction = UML::ParameterDirectionKind::return then \'return\'\n            else null\n            endif endif endif endif endif\n        else\n          null\n        endif'"
	 * @generated
	 */
	String direction();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isProperty() then null\n        -- Note: Only owned ends are treated as association ends.\n        else self.element.oclAsType(UML::Property).owningAssociation\n        endif'"
	 * @generated
	 */
	ElementReference association();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isBehavior() then\n            let returnParameter = self.returnParameter() in\n              if returnParameter = null then null\n              else returnParameter.type()\n              endif\n        else\n          let type =\n            if self.element.oclIsKindOf(UML::TypedElement) then\n              self.element.oclAsType(UML::TypedElement).type\n            else if self.isOperation() then\n              self.element.oclAsType(UML::Operation).type\n            else if self.isEnumerationLiteral() then\n              self.element.oclAsType(UML::EnumerationLiteral).enumeration\n            else\n              null\n            endif endif endif\n          in\n            if type = null then null \n            else ExternalElementReference{element = type} endif\n        endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.element.oclIsKindOf(UML::MultiplicityElement) then\n          self.element.oclAsType(UML::MultiplicityElement).lower\n        else\n          1\n       endif'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.element.oclIsKindOf(UML::MultiplicityElement) then\n          self.element.oclAsType(UML::MultiplicityElement).upper\n        else\n          1\n       endif'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.element.oclIsKindOf(UML::MultiplicityElement) then\n          self.element.oclAsType(UML::MultiplicityElement).isOrdered\n        else\n          false\n       endif'"
	 * @generated
	 */
	boolean isOrdered();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.element.oclIsKindOf(UML::MultiplicityElement) then\n          not self.element.oclAsType(UML::MultiplicityElement).isUnique\n        else\n          false\n       endif'"
	 * @generated
	 */
	boolean isNonunique();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isClassifier() then\n          self.element.oclAsType(UML::Classifier).general->\n            collect(g | ExternalElementReference{element = g})->asSet()\n        else if self.element.oclIsKindOf(UML::ClassifierTemplateParameter) then\n          self.element.oclAsType(UML::ClassifierTemplateParameter).constrainingClassifier->\n            collect(c | ExternalElementReference{element = c})->asSet()\n        else\n          Set(ElementReference){}\n        endif endif'"
	 * @generated
	 */
	EList<ElementReference> parents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let allParents = \n          if self.isClassifier() then \n            self.element.oclAsType(UML::Classifier).allParents()->asSet()\n          else if self.element.oclIsKindOf(UML::ClassifierTemplateParameter) then\n            let parents = \n              self.element.oclAsType(UML::ClassifierTemplateParameter).\n                constrainingClassifier \n            in\n              parents->union(parents.allParents())->asSet()\n          else\n            Set(UML::Classifier){}\n          endif endif\n        in\n          allParents->collect(p | ExternalElementReference{element = p})->asSet()'"
	 * @generated
	 */
	EList<ElementReference> allParents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.element.oclIsKindOf(UML::BehavioredClassifier) then null\n        else\n          let classifierBehavior = \n            self.element.oclAsType(UML::BehavioredClassifier).classifierBehavior in\n            if classifierBehavior = null then null\n            else ExternalElementReference{element = classifierBehavior}\n            endif\n        endif'"
	 * @generated
	 */
	ElementReference classifierBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamespace() then Set(ecore::EObject){}\n        else\n          self.element.oclAsType(UML::Namespace).getNearestPackage().\n            getAllAppliedProfiles()->\n            collect(e | ExternalElementReference{element = e})\n        endif'"
	 * @generated
	 */
	EList<ElementReference> appliedProfiles();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isBehavior() then null\n        else if self.element.oclAsType(UML::Behavior).isActive then self\n        else\n          let context = self.element.oclAsType(UML::Behavior).context in\n            if context <> null and self.element = context.classifierBehavior then\n              ExternalElementReference{element = context}\n            else\n              null\n            endif\n        endif endif'"
	 * @generated
	 */
	ElementReference activeClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        other = null or\n        self.isClassifier() and \n        let otherType = other.asUml() in\n          otherType <> null and otherType.oclIsKindOf(UML::Type) and\n          self.element.oclAsType(UML::Classifier).conformsTo(otherType.oclAsType(UML::Type))'"
	 * @generated
	 */
	boolean conformsTo(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        other <> null and \n        other.asUml() = self.element and \n        other.name() = self.name()'"
	 * @generated
	 */
	boolean equals(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='ExternalElementReference{element = self.element}'"
	 * @generated
	 */
	ElementReference copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isNamespace() then self\n        else null\n        endif'"
	 * @generated
	 */
	ElementReference modelScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" pathNameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='ExternalElementReference_resolvePathName(pathName)'"
	 * @generated
	 */
	EList<ElementReference> resolvePathName(String pathName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * EXTERNAL
	 * <!-- end-model-doc -->
	 * @model ordered="false" pathNameRequired="true"
	 * @generated
	 */
	EList<ElementReference> ExternalElementReference_resolvePathName(String pathName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.members()->select(name() = name)'"
	 * @generated
	 */
	EList<ElementReference> resolveInScope(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" stereotypeNameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isProfile() then\n          self.element.oclAsType(UML::Profile).ownedStereotype->\n            select(name = stereotypeName)->\n            collect(e | ExternalElementReference{element = e})->asSet()\n        else\n          Set(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> resolveStereotype(String stereotypeName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='null'"
	 * @generated
	 */
	ElementReference stub();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let definition = unit.definition in\n          if not definition.oclIsKindOf(ActivityDefinition) then null\n          else\n            let name = definition.actualName() in\n            let referents = self.ownedMembers()->select(\n              isOperation() and (name = name() or name.startsWith(name() + \'$method$\')) or\n              isActiveBehavior() and (name = name() or name.startsWith(name() + \'$behavior$\')) or\n              isProperty() and name.startsWith(name() + \'$defaultValue$\') \n            ) in\n              if referents->isEmpty() then null\n              else referents->any(true)\n              endif\n          endif'"
	 * @generated
	 */
	ElementReference stubFor(UnitDefinition unit);

} // ExternalElementReference
