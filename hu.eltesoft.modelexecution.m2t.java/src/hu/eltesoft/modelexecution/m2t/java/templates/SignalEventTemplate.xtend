package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.SignalEvent

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

@SourceMappedTemplate(stratumName=XUML_RT)
class SignalEventTemplate extends Template {

	val EvSignalEvent event;

	new(EvSignalEvent event) {
		super(event)
		this.event = event;
	}

	override generate() '''
		«generatedHeader(event.name)»
		public class «event.name» extends «SignalEvent.canonicalName» {
		
			@Override
			public boolean equals(Object other) {
				return null != other && other instanceof «event.name»;
			}
		
			@Override
			public int hashCode() {
				return 0;
			}
		}
	'''
}
