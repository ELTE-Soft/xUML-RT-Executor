package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttributeSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClCtorRecord
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionSpec
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.InstanceRegistry
import hu.eltesoft.modelexecution.runtime.base.StatefulClass
import java.util.LinkedList
import java.util.function.Consumer

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
				
			«IF !classSpec.isIsAbstract»
				
			/** Creator for UML class «classSpec.javadoc» */
			public static «classSpec.identifier» create(«Consumer.canonicalName»<«classSpec.identifier»> initializer) {
				«FOR rec : classSpec.ctorRecords»
					final «rec.implementation» «rec.inherited» 
						= new «rec.implementation»(«FOR par : rec.directParents SEPARATOR ','»«par.inherited»«ENDFOR»);
				«ENDFOR»
				«classSpec.implementation» created = new «classSpec.implementation»(
					() -> {
						«FOR rec : dtorRecords»
							«rec.inherited».destroy();
						«ENDFOR»
					}
					«FOR parent : classSpec.parents BEFORE ',' SEPARATOR ','»
						«parent.inherited»
					«ENDFOR»);
				if (null != initializer) {
					initializer.accept(created);
				}
				«InstanceRegistry.canonicalName».getInstanceRegistry().registerInstance(created);
				«IF classSpec.hasStateMachine»
					created.initializeStateMachine();
				«ENDIF»
				return created;
			}
			
			«ENDIF»
		
			/** Deleter for UML class «classSpec.javadoc» */
			void delete();
		
			/** Destructor for UML class «classSpec.javadoc» */
			void destroy();
		
			«content»
		}
	'''

	def dtorRecords() {
		// this is basically the reverse of the constructor records
		// do not use reverse() on the original list as it will throw an exception!
		val result = new LinkedList<ClCtorRecord>(); 
		for (rec : classSpec.ctorRecords) {
			result.add(0, rec)
		}
		result
	}

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
		«IF classSpec.hasReceptions»
		
		// receptions
		«FOR reception : classSpec.receptions»
			
			«generateExternalReception(reception)»
		«ENDFOR»
		«ENDIF»
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
		«IF operation.isStatic»
			static «IF operation.returns»«javaType(operation.returnType)»«ELSE»void«ENDIF» «operation.identifier»(
				«FOR parameter : operation.parameters SEPARATOR ','»
					«javaType(parameter.type)» «parameter.identifier»
				«ENDFOR»
			) {
				«IF operation.returns»return «ENDIF»«classSpec.implementation».«operation.identifier»(«FOR parameter : operation.parameters SEPARATOR ','»«parameter.identifier»«ENDFOR»);
			}
		 «ELSE»
			«IF operation.returns»«javaType(operation.returnType)»«ELSE»void«ENDIF» «operation.identifier»(
				«FOR parameter : operation.parameters SEPARATOR ','»
					«javaType(parameter.type)» «parameter.identifier»
				«ENDFOR»
			);
		 «ENDIF»
	'''

	def generateExternalReception(ClReceptionSpec reception) '''
		/** Method for reception «reception.javadoc» 
		 «javadocParams(reception.parameters)» 
		 */
		void «reception.identifier»_external(
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
