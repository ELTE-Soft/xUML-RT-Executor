package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttributeSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionSpec
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.StatefulClass
import java.util.LinkedList

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

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

				/// TODO: generate interface for association
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

	def generateStructuralClassBody() '''
		
	'''

	def generateAttribute(
		ClAttributeSpec attribute
	) '''
		«javaType(attribute.type)» get_«attribute.identifier»();
		void set_«attribute.identifier»(«javaType(attribute.type)» newVal);
	'''

	def generateAssociation(ClAssociation association) '''
		/** Attribute for association «association.javadoc» */
		«javaType(association.type)» «association.identifier» = «createEmpty(association.type)»;
		
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
