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
		«generatedHeaderForClass(classDefinition)»
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
		public class «classDefinition.identifier» extends «ClassWithState.canonicalName» {
		
			private static «AtomicInteger.canonicalName» instanceCount = new «AtomicInteger.canonicalName»(0);
											
			private «classDefinition.region.identifier» stateMachine = new «classDefinition.region.identifier»(this);
					
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
			
			// attributes and associations
					
			«generateAttributes()»
						
			
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
		public class «classDefinition.identifier» extends «Class.canonicalName» {
			
			// attributes and associations
					
			«generateAttributes()»
						
			
			// operations
					
			«generateOperations()»
		}
		
	'''
	
	def generateAttributes() '''
		«FOR attribute : classDefinition.attributes»
			«IF attribute.isStatic»static«ENDIF» «javaType(attribute.type, attribute.multiplicity)» «attribute.identifier»;
		«ENDFOR»
	'''

	def generateOperations() '''
		«FOR operation : classDefinition.operations»
			public «IF operation.isStatic»static«ENDIF»
			       «IF operation.returnType != null»«javaType(operation.returnType)»«ELSE»void«ENDIF» «operation.identifier»(
					«FOR parameter : operation.parameters SEPARATOR ','»
						«javaType(parameter.type, parameter.direction)» «parameter.identifier»
					«ENDFOR»
					) {
				«IF null != operation.method»
					«operation.method.identifier» method = new «operation.method.identifier»(
						«IF !operation.isStatic»this«IF !operation.parameters.empty»,«ENDIF»«ENDIF»
						«FOR parameter : operation.parameters SEPARATOR ','»
							«parameter.identifier»
						«ENDFOR»
						);
					method.execute();
					«IF operation.returnType != null»
						return method.getReturnValue();
					«ENDIF»
				«ENDIF»
			}
		«ENDFOR»
	'''

	def generateReceptions() '''
		«FOR reception : classDefinition.receptions»
			public void «reception.identifier»() {
				getRuntime().addEventToQueue(this, new «reception.signal.identifier»());
			}
		«ENDFOR»
	'''

}
