package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.Runtime
import hu.eltesoft.modelexecution.runtime.base.Class
import hu.eltesoft.modelexecution.runtime.base.ClassWithState
import hu.eltesoft.modelexecution.runtime.base.Message
import java.util.concurrent.atomic.AtomicInteger

import static hu.eltesoft.modelexecution.m2t.java.Languages.*
import hu.eltesoft.modelexecution.runtime.InstanceRegistry

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
			
			// receptions
					
			«generateReceptions()»
					
			// operations
					
			«generateOperations()»
		}
	'''

	/**
	 * Generates a class that does not have a state machine.
	 */
	def generateClassWithoutState() '''
		public class «classDefinition.identifier» extends «Class.canonicalName» {
			«generateOperations()»
		}
		
	'''

	def generateOperations() '''
		«FOR operation : classDefinition.operations»
			public void «operation.identifier»() {
				«IF null != operation.method»
					new «operation.method.identifier»(this).execute();
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
