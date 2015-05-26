package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Signal
import hu.eltesoft.modelexecution.runtime.base.SignalEvent
import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder
import org.json.JSONObject

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

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
		
			@Override
			public «JSONObject.canonicalName» jsonEncode() {
				«JSONObject.canonicalName» json = new «JSONObject.canonicalName»();
				json.put("class", getClass().getCanonicalName());
				// also give a human-readable name
				json.put("name", «signal.nameLiteral»);
				return json;
			}
		
			@Override
			public void jsonDecode(«JSONDecoder.canonicalName» reader, «JSONObject.canonicalName» obj) {
				// this signal has no attribute to read from json
			}
		}
	'''
}
