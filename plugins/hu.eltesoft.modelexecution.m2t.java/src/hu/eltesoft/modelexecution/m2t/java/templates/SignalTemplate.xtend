package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Signal

import static hu.eltesoft.modelexecution.m2t.java.Languages.*
import hu.eltesoft.modelexecution.runtime.base.SignalEvent

@SourceMappedTemplate(stratumName=XUML_RT)
class SignalTemplate extends Template {

	val SgSignal signal

	new(SgSignal signal) {
		super(signal)
		this.signal = signal
	}

	override generate() '''
		«generatedHeader(signal.name)»
		public class «signal.name» extends «Signal.canonicalName» {
		
			public «signal.name»() {
				super();
			}
		
			public «signal.name»(«SignalEvent.canonicalName» event) {
				super(event);
			}
		
			@Override
			public boolean equals(Object other) {
				return null != other && other instanceof «signal.name»;
			}
		
			@Override
			public int hashCode() {
				return 0;
			}
		}
	'''
}
