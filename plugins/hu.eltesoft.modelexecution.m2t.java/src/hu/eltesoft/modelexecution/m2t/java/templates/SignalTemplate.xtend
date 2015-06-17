package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Signal
import hu.eltesoft.modelexecution.runtime.base.SignalEvent
import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder
import org.json.JSONObject

import static hu.eltesoft.modelexecution.m2t.java.Languages.*
import org.json.JSONArray

@SourceMappedTemplate(stratumName=XUML_RT)
class SignalTemplate extends Template {

	val SgSignal signal

	new(SgSignal signal) {
		super(signal)
		this.signal = signal
	}

	override generate() '''
		/** Class for signal «signal.javadoc» */
		«generatedHeaderForClass(signal)»
		public class «signal.identifier» extends «Signal.canonicalName» {
		
			/** Constructs a signal «signal.javadoc» from a reception
			 «javadocParams(signal.attributes)»
			 */
			public «signal.identifier»(
				«FOR attribute : signal.attributes SEPARATOR ','»
					«typeConverter.javaType(attribute.type)» «attribute.identifier»
				«ENDFOR»
			) {
				super();
				«FOR attribute : signal.attributes»
					this.«attribute.identifier» = «attribute.identifier»;
				«ENDFOR»
			}
		
			/** Constructs a signal «signal.javadoc» in an event
			 * @param event The event that wraps the signal
			 «javadocParams(signal.attributes)»
			 */
			public «signal.identifier»(«SignalEvent.canonicalName» event
				«FOR attribute : signal.attributes»
					, «typeConverter.javaType(attribute.type)» «attribute.identifier»
				«ENDFOR»
			) {
				super(event);
				«FOR attribute : signal.attributes»
					this.«attribute.identifier» = «attribute.identifier»;
				«ENDFOR»
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
					forEach((«JSONArray.canonicalName») obj.get("«attribute.identifier»"), «attribute.identifier»::add);
				«ENDFOR»
			}
			
			// attributes
			
			«FOR attribute : signal.attributes»
				/** Attribute for signal attribute «attribute.javadoc» */
				«typeConverter.javaType(attribute.type)» «attribute.identifier»
					= «typeConverter.createEmpty(attribute.type)»;
			«ENDFOR»
		}
	'''
}
