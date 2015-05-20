package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.Runtime
import hu.eltesoft.modelexecution.runtime.base.ClassWithState
import hu.eltesoft.modelexecution.runtime.base.Class
import hu.eltesoft.modelexecution.runtime.base.Message

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
		«generatedHeader(classDefinition.originalName)»
		«IF hasStateMachine»
			«generateClassWithState()»
		«ELSE»
			«generateClassWithoutName()»
		«ENDIF»
	'''

	/**
	 * Generates a class with a state machine. It will be a descendant of {@linkplain ClassWithState}.
	 */
	def generateClassWithState() '''
		public class «classDefinition.name» extends «ClassWithState.canonicalName» {
			// Only for Q1
			private static «classDefinition.name» instance = null;
			public static «classDefinition.name» getInstance() {
				return instance;
			}
			
			@Generated(value = { "«classDefinition.region.originalName»" })
			«classDefinition.region.name» stateMachine = new «classDefinition.region.name»(this);
			
			public «classDefinition.name»(«Runtime.canonicalName» runtime) {
				super(runtime);
				instance = this; // Only for Q1
			}
			
			@Override
			public void init() {
				stateMachine.doInitialTransition();
			}
			
			@Override
			public void receive(«Message.canonicalName» message) {
				stateMachine.step(message);
			}
			
			«generateReceptions()»
			
			«generateOperations()»
		}
	'''

	/**
	 * Generates a class that does not have a state machine.
	 */
	def generateClassWithoutName() '''
		public class «classDefinition.name» extends «Class.canonicalName» {
			«generateOperations()»
		}
		
	'''

	def generateOperations() '''
		«FOR operation : classDefinition.operations»
			@Generated(value = { "«operation.originalName»" })
			public void «operation.name»() {
				«IF null != operation.method»
					new «operation.method.name»(this).execute();
				«ENDIF»
			}
		«ENDFOR»
	'''

	def generateReceptions() '''
		«FOR reception : classDefinition.receptions»
			@Generated(value = { "«reception.originalName»" })
			public void «reception.name»() {
				getRuntime().addEventToQueue(this, new «reception.signal.name»());
			}
		«ENDFOR»
	'''

}
