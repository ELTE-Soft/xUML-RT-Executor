package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Signal
import hu.eltesoft.modelexecution.runtime.base.SignalEvent
import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder
import org.json.JSONObject

import static hu.eltesoft.modelexecution.m2t.java.Languages.*
import java.util.Objects

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
			public boolean equals(Object obj) {
				if (null == obj || !(obj instanceof «signal.identifier»)) {
					return false;
				}
				«signal.identifier» other = («signal.identifier») obj;
				return true
					«FOR attribute : signal.attributes»
						&& «attribute.identifier» == other.«attribute.identifier»
					«ENDFOR»;
			}
		
			@Override
			public int hashCode() {
				return «Objects.canonicalName».hash(«FOR attribute : signal.attributes SEPARATOR ','»«attribute.identifier»«ENDFOR»);
			}
		
			@Override
			public String toString() {
				return «signal.nameLiteral»
					«FOR attribute : signal.attributes SEPARATOR '+","'»
						 + "«attribute.reference.originalName»: " + «attribute.identifier»
					«ENDFOR»;
			}
		
			@Override
			public «JSONObject.canonicalName» jsonEncode() {
				«JSONObject.canonicalName» json = new «JSONObject.canonicalName»();
				json.put("class", getClass().getCanonicalName());
				«FOR attribute : signal.attributes SEPARATOR ','»
					json.put("«attribute.identifier»", «attribute.identifier»);
				«ENDFOR»
				return json;
			}
		
			@Override
			public void jsonDecode(«JSONDecoder.canonicalName» reader, «JSONObject.canonicalName» obj) {
				«FOR attribute : signal.attributes SEPARATOR ','»
					this.«attribute.identifier» = («javaType(attribute.type, attribute.multiplicity)») obj.get("«attribute.identifier»");
				«ENDFOR»
			}
			
			// attributes
			
			«FOR attribute : signal.attributes»
				«javaType(attribute.type, attribute.multiplicity)» «attribute.identifier»;
			«ENDFOR»
		}
	'''
}
