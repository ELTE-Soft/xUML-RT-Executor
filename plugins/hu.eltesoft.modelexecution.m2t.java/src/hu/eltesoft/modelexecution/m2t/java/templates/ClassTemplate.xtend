package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.base.Named
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAttribute
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.InstanceRegistry
import hu.eltesoft.modelexecution.runtime.Runtime
import hu.eltesoft.modelexecution.runtime.base.Class
import hu.eltesoft.modelexecution.runtime.base.ClassWithState
import hu.eltesoft.modelexecution.runtime.base.SignalEvent
import hu.eltesoft.modelexecution.runtime.base.StateMachineRegion
import java.util.concurrent.atomic.AtomicInteger

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

@SourceMappedTemplate(stratumName=XUML_RT)
class ClassTemplate extends Template {

	val ClClass classDefinition
	val boolean hasStateMachine
	val NamedReference region

	new(ClClass classDefinition) {
		super(classDefinition)
		this.classDefinition = classDefinition
		this.hasStateMachine = classDefinition.region != null || classDefinition.inheritedRegion != null
		region = if (classDefinition.region != null) classDefinition.region else classDefinition.inheritedRegion
	}

	override wrapContent(CharSequence content) '''
		«IF hasStateMachine»
			«generateClassWithState(content)»
		«ELSE»
			«generateClassWithoutState(content)»
		«ENDIF»
	'''

	/**
	 * Generates a class with a state machine. It will be a descendant of {@linkplain ClassWithState}.
	 */
	def generateClassWithState(CharSequence content) '''
		/** Implementation class for UML class «classDefinition.javadoc» */
		«generatedHeaderForClass(classDefinition)»
		public class «classDefinition.implementation» 
			extends «ClassWithState.canonicalName» 
			implements «classDefinition.identifier» {
			
			/** Constructor for UML class «classDefinition.javadoc» */
			public «classDefinition.implementation»(«Runtime.canonicalName» runtime) {
				super(runtime, instanceCount.getAndIncrement());
				«InstanceRegistry.canonicalName».getInstanceRegistry().registerInstance(this);
			}
			«content»
		}
	'''

	/**
	 * Generates a class that does not have a state machine.
	 */
	def generateClassWithoutState(CharSequence content) '''
		/** Data class for UML class «classDefinition.javadoc» */
		«generatedHeaderForClass(classDefinition)»
		public class «classDefinition.implementation» 
			extends «Class.canonicalName» 
			implements «classDefinition.identifier» {
			«content»
		}
	'''

	override generateContent() '''
		«IF hasStateMachine»
			private static «AtomicInteger.canonicalName» instanceCount = new «AtomicInteger.canonicalName»(0);

			@Override
			protected «StateMachineRegion.canonicalName» createStateMachine() {
				return new «region.identifier»(this);
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
	
	// operations
	«FOR operation : classDefinition.operations»
		
			«generateOperation(operation)»
	«ENDFOR»
	'''

	def generateAttribute(
		ClAttribute attribute
	) '''
		/** Attribute for UML attribute «attribute.javadoc» */
		private «IF attribute.isStatic»static«ENDIF» «javaType(attribute.type)» «attribute.identifier» = «createEmpty(attribute.type)»;
		
		@Override
		public «IF attribute.isStatic»static«ENDIF» «javaType(attribute.type)» «attribute.getter»() {
			return «attribute.identifier»;
		}
		
		@Override
		public «IF attribute.isStatic»static«ENDIF» void «attribute.setter»(«javaType(attribute.type)» newVal) {
			«attribute.identifier» = newVal;
		}
	'''
	
	def generateInheritedAttribute(
		ClInheritedAttribute attribute
	) '''
		//@Override
		public «javaType(attribute.type)» «attribute.getter»() {
			return «attribute.parent.inherited».«attribute.getter»();
		}
		
		//@Override
		public void «attribute.setter»(«javaType(attribute.type)» newVal) {
			«attribute.parent.inherited».«attribute.setter»(newVal);
		}
	'''

	def generateAssociation(ClAssociation association) '''
		/** Attribute for association «association.javadoc» */
		«javaType(association.type)» «association.identifier» = «createEmpty(association.type)»;
		
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
	
	def getter(Named ref) { "get_" + ref.identifier }
	
	def setter(Named ref) { "set_" + ref.identifier }
	
	def inherited(Named ref) { ref.identifier + "_inherited" }
	
	def inherited(NamedReference ref) { ref.identifier + "_inherited" }
	
	def implementation(Named ref) { ref.identifier + "_impl" }
	
	def implementation(NamedReference ref) { ref.identifier + "_impl" }
}
