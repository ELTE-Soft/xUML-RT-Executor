package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.Runtime
import hu.eltesoft.modelexecution.runtime.base.Class
import hu.eltesoft.modelexecution.runtime.base.ClassWithState
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
		«generatedHeaderForClass(classDefinition)»
		«IF hasStateMachine»
			«generateClassWithState()»
		«ELSE»
			«generateClassWithoutState()»
		«ENDIF»
	'''

	/**
	 * Generates a class with a state machine.
	 * It will be a descendant of {@linkplain ClassWithState}.
	 */
	def generateClassWithState() '''
		public class «classDefinition.identifier» extends «ClassWithState.canonicalName» {
			// Only for Q1
			private static «classDefinition.identifier» instance = null;
			public static «classDefinition.identifier» getInstance() {
				return instance;
			}
		
			«generatedHeader(classDefinition.region)»
			«classDefinition.region.identifier» stateMachine = new «classDefinition.region.identifier»(this);
			
			public «classDefinition.identifier»(«Runtime.canonicalName» runtime) {
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
		
			@Override
			public String toString() {
				return «classDefinition.nameLiteral»;
			}
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
			«generatedHeader(operation)»
			public void «operation.identifier»() {
				«IF null != operation.method»
					new «operation.method.identifier»(this).execute();
				«ENDIF»
			}
		«ENDFOR»
	'''

	def generateReceptions() '''
		«FOR reception : classDefinition.receptions»
			«generatedHeader(reception)»
			public void «reception.identifier»() {
				getRuntime().addEventToQueue(this, new «reception.signal.identifier»());
			}
		«ENDFOR»
	'''
}
