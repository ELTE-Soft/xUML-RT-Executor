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
		«generatedHeaderForClass(signal)»
		public class «signal.identifier» extends «Signal.canonicalName» {
		
			public «signal.identifier»() {
				super();
			}
		
			public «signal.identifier»(«SignalEvent.canonicalName» event) {
				super(event);
			}
		
			@Override
			public boolean equals(Object other) {
				return null != other && other instanceof «signal.identifier»;
			}
		
			@Override
			public int hashCode() {
				return 0;
			}
		
			@Override
			public String toString() {
				return «signal.nameLiteral»;
			}
		}
	'''
}
