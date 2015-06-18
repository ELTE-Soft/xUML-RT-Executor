package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.InstanceRegistry
import hu.eltesoft.modelexecution.runtime.Runtime
import hu.eltesoft.modelexecution.runtime.base.Class
import hu.eltesoft.modelexecution.runtime.base.ClassWithState
import hu.eltesoft.modelexecution.runtime.base.Message
import java.util.concurrent.atomic.AtomicInteger

import static hu.eltesoft.modelexecution.m2t.java.Languages.*
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation

@SourceMappedTemplate(stratumName=XUML_RT)
class ClassTemplate extends Template {

	val ClClass classDefinition
	val boolean hasStateMachine

	new(ClClass classDefinition) {
		super(classDefinition)
		this.classDefinition = classDefinition
		this.hasStateMachine = classDefinition.region != null
	}

	override generate() '''
		«IF hasStateMachine»
			«generateClassWithState()»
		«ELSE»
			«generateClassWithoutState()»
		«ENDIF»
	'''

	/**
	 * Generates a class with a state machine. It will be a descendant of {@linkplain ClassWithState}.
	 */
	def generateClassWithState() '''
		/** Class for UML class «classDefinition.javadoc» */
		«generatedHeaderForClass(classDefinition)»
		public class «classDefinition.identifier» extends «ClassWithState.canonicalName» {
		
			private static «AtomicInteger.canonicalName» instanceCount = new «AtomicInteger.canonicalName»(0);
											
			private «classDefinition.region.identifier» stateMachine = new «classDefinition.region.identifier»(this);
					
			/** Constructor for UML class «classDefinition.javadoc» */
			public «classDefinition.identifier»(«Runtime.canonicalName» runtime) {
				super(runtime, instanceCount.getAndIncrement());
				«InstanceRegistry.canonicalName».getInstanceRegistry().registerInstance(this);
			}
			
			@Override
			public void init() {
				stateMachine.doInitialTransition();
			}
					
			@Override
			public void receive(«Message.canonicalName» message) {
				stateMachine.step(message);
			}
								
			@Override
			public void dispose() {
				// lets the instance to be garbage-collected
				«InstanceRegistry.canonicalName».getInstanceRegistry().unregisterInstance(this);
			}
			
			// attributes
					
			«generateAttributes()»
						
			// associations
					
			«generateAssociations()»
						
			
			// operations
					
			«generateOperations()»
			
			// receptions
					
			«generateReceptions()»
					
		}
	'''

	/**
	 * Generates a class that does not have a state machine.
	 */
	def generateClassWithoutState() '''
		/** Data class for UML class «classDefinition.javadoc» */
		«generatedHeaderForClass(classDefinition)»
		public class «classDefinition.identifier» extends «Class.canonicalName» {
		
			// attributes
			«generateAttributes()»
		
			// associations
			«generateAssociations()»
		
			// operations
			«generateOperations()»
		}
		
	'''

	def generateAttributes() '''
		«FOR attribute : classDefinition.attributes»
			/** Attribute for UML attribute «attribute.javadoc» */
			«IF attribute.isStatic»static«ENDIF» «javaType(attribute.type)» «attribute.identifier» 
				= «createEmpty(attribute.type)»;
		«ENDFOR»
	'''

	def generateAssociations() '''
		«FOR association : classDefinition.associations»
			/** Attribute for association «association.javadoc» */
			«javaType(association.type)» «association.identifier» 
				= «createEmpty(association.type)»;
		«ENDFOR»
	'''

	def generateOperations() '''
		«FOR operation : classDefinition.operations»
			/** Method for operation «operation.javadoc» 
			 «javadocParams(operation.parameters)»
			 */
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
		«ENDFOR»
	'''

	def generateReceptions() '''
		«FOR reception : classDefinition.receptions»
			
				/** Method for reception «reception.javadoc» 
				 «javadocParams(reception.parameters)» 
				 */
				public void «reception.identifier»(
					«FOR parameter : reception.parameters SEPARATOR ','»
						«javaType(parameter.type, parameter)» «parameter.identifier»
					«ENDFOR»
				) {
					«reception.signal.identifier» signal = new «reception.signal.identifier»(
						«FOR parameter : reception.parameters SEPARATOR ','»
							«parameter.identifier»
						«ENDFOR»
					);
					getRuntime().addEventToQueue(this, signal);
				}
		«ENDFOR»
	'''

	def returns(ClOperation op) {
		op.returnType != null
	}
	
	def hasBody(ClOperation op) {
		op.method != null
	}
	
	def hasParameters(ClOperation op) {
		!op.parameters.empty
	}

}
