package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAssociation
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAttribute
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.Runtime
import hu.eltesoft.modelexecution.runtime.base.Class
import hu.eltesoft.modelexecution.runtime.base.ClassWithState
import hu.eltesoft.modelexecution.runtime.base.SignalEvent
import hu.eltesoft.modelexecution.runtime.base.StateMachineRegion
import hu.eltesoft.modelexecution.runtime.meta.AttributeM
import hu.eltesoft.modelexecution.runtime.meta.ClassM
import hu.eltesoft.modelexecution.runtime.meta.VisibilityM
import java.util.concurrent.atomic.AtomicInteger

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

@SourceMappedTemplate(stratumName=XUML_RT)
class ClassTemplate extends Template {

	val ClClass classDefinition
	val boolean hasStateMachine

	new(ClClass classDefinition) {
		super(classDefinition)
		this.classDefinition = classDefinition
		this.hasStateMachine = classDefinition.region != null
	}

	override wrapContent(CharSequence content) '''
		/** Implementation class for UML class «classDefinition.javadoc» */
		«generatedHeaderForClass(classDefinition)»
		public class «classDefinition.implementation» 
			extends «IF (hasStateMachine)»«ClassWithState.canonicalName»«ELSE»«Class.canonicalName»«ENDIF»
			implements «classDefinition.identifier» {
				
			/** Meta-description of the structure of the class */
			public static «ClassM.canonicalName» metaRepr = new «ClassM.canonicalName»(
				new «ClassM.canonicalName»[] { 
					«FOR parent : classDefinition.parents SEPARATOR ','»
						«parent.implementation».metaRepr
					«ENDFOR»
				},
				new «AttributeM.canonicalName»[] { 
					«FOR attr : classDefinition.attributes SEPARATOR ','»
						new «AttributeM.canonicalName»(«attr.nameLiteral», "«attr.identifier»", «VisibilityM.canonicalName».«VisibilityM.PublicM»)
					«ENDFOR»
				}
			);
		
			«content»
		}
	'''
	
	override generateContent() '''
		/** Constructor for UML class «classDefinition.javadoc» */
		public «classDefinition.implementation»(«Runtime.canonicalName» runtime
				«FOR parent : classDefinition.parents», «parent.implementation» «parent.inherited»«ENDFOR») {
			«IF hasStateMachine»super(runtime, instanceCount.getAndIncrement());«ENDIF»
			«FOR parent : classDefinition.parents»
				this.«parent.inherited» = «parent.inherited»;«»
			«ENDFOR»
		}

		«IF hasStateMachine»
			private static «AtomicInteger.canonicalName» instanceCount = new «AtomicInteger.canonicalName»(0);

			@Override
			protected «StateMachineRegion.canonicalName» createStateMachine() {
				return new «classDefinition.region.identifier»(this);
			}
			
			// receptions
			«FOR reception : classDefinition.receptions»
				
				«generateReception(reception, false)»
				
				«generateReception(reception, true)»
			«ENDFOR»
			
		«ENDIF»
		
		«generateStructuralClassBody()»
	'''

	def generateStructuralClassBody() '''
	// references to parent objects
	«FOR parent : classDefinition.parents»
		
		«parent.implementation» «parent.inherited»;
	«ENDFOR»


	// attributes
	«FOR attribute : classDefinition.attributes»
		
		«generateAttribute(attribute)»
	«ENDFOR»
	
	// inherited attributes
	«FOR attribute : classDefinition.inheritedAttributes»
		
		«generateInheritedAttribute(attribute)»
	«ENDFOR»
	
	// associations
	«FOR association : classDefinition.associations»
		
		«generateAssociation(association)»
	«ENDFOR»
	
	// inherited associations
	«FOR association : classDefinition.inheritedAssociations»
		
		«generateInheritedAssociation(association)»
	«ENDFOR»
	
	// operations (both defined and inherited)
	«FOR operation : classDefinition.operations»
		
		«generateOperation(operation)»
	«ENDFOR»
	'''

	def generateAttribute(
		ClAttribute attribute
	) '''
		/** Attribute for UML attribute «attribute.javadoc» */
		private «IF attribute.isStatic»static«ENDIF» «javaType(attribute.type)» «attribute.identifier» = «createEmpty(attribute.type)»;
		
		«IF !attribute.isStatic»@Override«ENDIF»
		public «IF attribute.isStatic»static«ENDIF» «javaType(attribute.type)» «attribute.getter»() {
			return «attribute.identifier»;
		}
		
		«IF !attribute.isStatic»@Override«ENDIF»
		public «IF attribute.isStatic»static«ENDIF» void «attribute.setter»(«javaType(attribute.type)» newVal) {
			«attribute.identifier» = newVal;
		}
	'''
	
	def generateInheritedAttribute(
		ClInheritedAttribute attribute
	) '''
		@Override
		public «javaType(attribute.type)» «attribute.getter»() {
			return «attribute.parent.inherited».«attribute.getter»();
		}
		
		@Override
		public void «attribute.setter»(«javaType(attribute.type)» newVal) {
			«attribute.parent.inherited».«attribute.setter»(newVal);
		}
	'''

	def generateAssociation(ClAssociation association) '''
		/** Attribute for association labeled with «association.javadoc» */
		«javaType(association.type)» «association.identifier» = «createEmpty(association.type)»;
		
		@Override
		public «javaType(association.type)» «association.getter»() {
			return «association.identifier»;
		}
		
		@Override
		public void «association.setter»(«javaType(association.type)» newVal) {
			«association.identifier» = newVal;
		}
	'''
	
	def generateInheritedAssociation(
		ClInheritedAssociation association
	) '''
		@Override
		public «javaType(association.type)» «association.getter»() {
			return «association.parent.inherited».«association.getter»();
		}
		
		@Override
		public void «association.setter»(«javaType(association.type)» newVal) {
			«association.parent.inherited».«association.setter»(newVal);
		}
	'''

	def generateOperation(ClOperation operation) '''
		/** Method for operation «operation.javadoc» 
		 «javadocParams(operation.parameters)»
		 */
		«IF !operation.isStatic»@Override«ENDIF»
		public «IF operation.isStatic»static«ENDIF»
			«IF operation.returns»«javaType(operation.returnType)»«ELSE»void«ENDIF» «operation.identifier»(
				«FOR parameter : operation.parameters SEPARATOR ','»
					«javaType(parameter.type)» «parameter.identifier»
				«ENDFOR»
			) {
				«IF operation.hasBody»
					«IF operation.returnType != null»return«ENDIF»
						«operation.method.identifier».execute(
				«IF !operation.isStatic»this«IF operation.hasParameters»,«ENDIF»«ENDIF»
				«FOR parameter : operation.parameters SEPARATOR ','»
					«parameter.identifier»
				«ENDFOR»
				);
		«ENDIF»
		}
		
		«IF !operation.isStatic»
			/** Statically dispatched access to operation «operation.javadoc» 
			 «javadocParams(operation.parameters)»
			 */
			public static «IF operation.returns»«javaType(operation.returnType)»«ELSE»void«ENDIF» «operation.identifier»(
					«classDefinition.implementation» thisRef
					«FOR parameter : operation.parameters BEFORE ',' SEPARATOR ','»
						«javaType(parameter.type)» «parameter.identifier»
					«ENDFOR»
				) {
					«IF operation.hasBody»
						«IF operation.returnType != null»return«ENDIF»
							«operation.method.identifier».execute(
					«IF !operation.isStatic»thisRef«ENDIF»
					«FOR parameter : operation.parameters BEFORE ',' SEPARATOR ','»
						«parameter.identifier»
					«ENDFOR»
					);
			«ENDIF»
			}
		«ENDIF»
	'''
	
	def generateReception(ClReception reception, boolean isExternal) '''
		/** Method for reception «reception.javadoc» 
		 «javadocParams(reception.parameters)» 
		 */
		@Override
		public void «reception.identifier»«IF isExternal»_external«ENDIF»(
			«FOR parameter : reception.parameters SEPARATOR ','»
				«javaType(parameter.type, parameter)» «parameter.identifier»
			«ENDFOR»
		) {
			«reception.signal.identifier» signal = new «reception.signal.identifier»(
				«FOR parameter : reception.parameters SEPARATOR ','»
					«parameter.identifier»
				«ENDFOR»
			);
			getRuntime().add«IF isExternal»External«ENDIF»EventToQueue(this, new «SignalEvent.canonicalName»(signal));
		}
	'''

	def returns(ClOperationSpec op) { op.returnType != null }

	def hasBody(ClOperation op) { op.method != null }

	def hasParameters(ClOperationSpec op) { !op.parameters.empty }
	
}
