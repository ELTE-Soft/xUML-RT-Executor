package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Signal
import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder
import org.json.JSONArray
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
		/** Class for signal «signal.javadoc» */
		«generatedHeaderForClass(signal)»
		public class «signal.identifier» extends «Signal.canonicalName» {
		
			«FOR attribute : signal.attributes»
				/** Attribute for signal attribute «attribute.javadoc» */
				«javaType(attribute.type, attribute)» «attribute.identifier»
					= «createEmpty(attribute)»;
			«ENDFOR»
		
			/** Constructs a signal
			 «javadocParams(signal.attributes)»
			 */
			public «signal.identifier»(
				«FOR attribute : signal.attributes SEPARATOR ','»
					«javaType(attribute.type, attribute)» «attribute.identifier»
				«ENDFOR»
			) {
				super();
				«FOR attribute : signal.attributes»
					this.«attribute.identifier» = «attribute.identifier»;
				«ENDFOR»
			}
		
			@Override
			public «JSONObject.canonicalName» jsonEncode() {
				«JSONObject.canonicalName» json = new «JSONObject.canonicalName»();
				json.put("«JSONDecoder.JSON_CLASS»", getClass().getCanonicalName());
				«FOR attribute : signal.attributes SEPARATOR ','»
					json.put("«attribute.identifier»", «attribute.identifier»);
				«ENDFOR»
				return json;
			}
		
			@Override
			public void jsonDecode(«JSONDecoder.canonicalName» reader, «JSONObject.canonicalName» obj) {
				«FOR attribute : signal.attributes»
					forEach((«JSONArray.canonicalName») obj.get("«attribute.identifier»"), 
							«javaType(attribute.type)».class, «attribute.identifier»::add);
				«ENDFOR»
			}
			
			@Override
			public boolean equals(Object obj) {
				if (obj == null || !(obj instanceof «signal.identifier»)) {
					return false;
				}
				«FOR attribute : signal.attributes
					BEFORE '''«signal.identifier» other = («signal.identifier») obj;'''»
					if (!obj.«attribute.identifier».equals(this.«attribute.identifier»)) {
						return false;
					}
				«ENDFOR»
				return true;
			}
			
			@Override
			public int hashCode() {
				return «Objects.canonicalName».hash(
				«FOR attribute : signal.attributes SEPARATOR ','»
						«attribute.identifier»
				«ENDFOR»);
			}
		}
	'''
}
