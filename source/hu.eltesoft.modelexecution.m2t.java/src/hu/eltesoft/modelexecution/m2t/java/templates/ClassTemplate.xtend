package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.DynamicSignalEvent
import hu.eltesoft.modelexecution.runtime.Runtime
import hu.eltesoft.modelexecution.runtime.base.Class
import hu.eltesoft.modelexecution.runtime.base.Event

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

@SourceMappedTemplate(stratumName=XUML_RT)
class ClassTemplate extends Template {

	val ClClass classDefinition

	new(ClClass classDefinition) {
		super(classDefinition)
		this.classDefinition = classDefinition
	}

	override generate() '''
		«generatedHeader(classDefinition.name)»
		public class «classDefinition.name» extends «Class.canonicalName» {
		
			// Only for Q1
			private static «classDefinition.name» instance = null;
			public static «classDefinition.name» getInstance() {
				return instance;
			}
		
			«IF null != classDefinition.region»
				«classDefinition.region.name» stateMachine = new «classDefinition.region.name»(this);
			«ENDIF»
		
			public «classDefinition.name»(«Runtime.canonicalName» runtime) {
				super(runtime, "«classDefinition.name»");
				instance = this; // Only for Q1
			}
			
			@Override
			public void init() {
				stateMachine.doInitialTransition();
			}
		
			@Override
			public void receive(«Event.canonicalName» event) {
				«IF null != classDefinition.region»
					stateMachine.step(event);
				«ENDIF»
			}
		
			«FOR reception : classDefinition.receptions»
				public void «reception.name»() {
					getRuntime().addEventToQueue(this, new «DynamicSignalEvent.canonicalName»(new «reception.signal.name»()));
				}
			«ENDFOR»
		
			«FOR operation : classDefinition.operations»
				public void «operation.name»() {
					«IF null != operation.method»
						new «operation.method»(this).execute();
					«ENDIF»
				}
			«ENDFOR»
		}
	'''
}
