package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttributeSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionSpec
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.StatefulClass
import hu.eltesoft.modelexecution.runtime.Runtime
import java.util.LinkedList

import static hu.eltesoft.modelexecution.m2t.java.Languages.*
import hu.eltesoft.modelexecution.runtime.InstanceRegistry

@SourceMappedTemplate(stratumName=XUML_RT)
class ClassSpecTemplate extends Template {

	val ClClassSpec classSpec
	val extendings = new LinkedList<String>();

	new(ClClassSpec classSpec) {
		super(classSpec)
		this.classSpec = classSpec
		if (classSpec.hasStateMachine) { extendings.add(StatefulClass.canonicalName) }
		classSpec.parents.forEach[ extendings.add(identifier) ]
	}

	override wrapContent(
		CharSequence content
	) '''
		/** Interface for specification of UML class «classSpec.javadoc» */
		public interface «classSpec.identifier» 
			«FOR extending : extendings BEFORE 'extends ' SEPARATOR ','»«extending»«ENDFOR» {
				
			/** Creator for UML class «classSpec.javadoc» */
			public static «classSpec.identifier» create(«Runtime.canonicalName» runtime) {
				«FOR rec : classSpec.ctorRecords»
					«rec.implementation» «rec.inherited» 
						= new «rec.implementation»(runtime«FOR par : rec.directParents», «par.inherited»«ENDFOR»);
				«ENDFOR»
				«classSpec.implementation» created = new «classSpec.implementation»(runtime«FOR parent : classSpec.parents», «parent.inherited»«ENDFOR»);
				«IF classSpec.hasStateMachine»«InstanceRegistry.canonicalName».getInstanceRegistry().registerInstance(created);«ENDIF»
				return created;
			}
			«content»
		}
	'''

	override generateContent() '''
		// attributes
		«FOR attribute : classSpec.attributes»
			
			«generateAttribute(attribute)»
		«ENDFOR»
		
		// associations
		«FOR association : classSpec.associations»

			«generateAssociation(association)»
		«ENDFOR»
		
		// operations
		«FOR operation : classSpec.operations»
			
			«generateOperation(operation)»
		«ENDFOR»
		
		// receptions
		«FOR reception : classSpec.receptions»
			
			«generateReception(reception, false)»
			
			«generateReception(reception, true)»
		«ENDFOR»
	'''

	def generateAttribute(ClAttributeSpec attribute) '''
		/** Gets the value(s) of the attribute «attribute.javadoc» */
		«javaType(attribute.type)» get_«attribute.identifier»();
		
		/** Sets the value(s) of the attribute «attribute.javadoc» */
		void set_«attribute.identifier»(«javaType(attribute.type)» newVal);
	'''

	def generateAssociation(ClAssociation association) '''
		/** Gets the value(s) of the association «association.javadoc» */
		«javaType(association.type)» get_«association.identifier»();
		
		/** Sets the value(s) of the association «association.javadoc» */
		void set_«association.identifier»(«javaType(association.type)» newVal);
		
	'''

	def generateOperation(ClOperationSpec operation) '''
		/** Method for operation «operation.javadoc» 
		 «javadocParams(operation.parameters)»
		 */
		 «IF operation.returns»«javaType(operation.returnType)»«ELSE»void«ENDIF» «operation.identifier»(
		 	«FOR parameter : operation.parameters SEPARATOR ','»
		 		«javaType(parameter.type)» «parameter.identifier»
		 	«ENDFOR»
		 );
	'''

	def generateReception(ClReceptionSpec reception, boolean isExternal) '''
		/** Method for reception «reception.javadoc» 
		 «javadocParams(reception.parameters)» 
		 */
		void «reception.identifier»«IF isExternal»_external«ENDIF»(
			«FOR parameter : reception.parameters SEPARATOR ','»
				«javaType(parameter.type, parameter)» «parameter.identifier»
			«ENDFOR»
		);
	'''

	def returns(ClOperationSpec op) {
		op.returnType != null
	}

	def hasParameters(ClOperationSpec op) {
		!op.parameters.empty
	}
}
