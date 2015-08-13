package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Signal
import hu.eltesoft.modelexecution.runtime.meta.AttributeM
import hu.eltesoft.modelexecution.runtime.meta.BoundsM
import hu.eltesoft.modelexecution.runtime.meta.ClassM
import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder
import java.util.Objects
import org.json.JSONArray
import org.json.JSONObject

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

@SourceMappedTemplate(stratumName=XUML_RT)
class SignalTemplate extends Template {

	val SgSignal signal

	new(SgSignal signal) {
		super(signal)
		this.signal = signal
	}

	override wrapContent(CharSequence content) '''
		/** Class for signal «signal.javadoc» */
		«generatedHeaderForClass(signal)»
		public class «signal.identifier» extends «Signal.canonicalName» {
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
			
			/** Meta-description of the structure of the class */
			public static «ClassM.canonicalName» «META_REPR_NAME» = new «ClassM.canonicalName»(
				«signal.nameLiteral»,
				new «ClassM.canonicalName»[0],
				new «AttributeM.canonicalName»[] { 
					«FOR attr : signal.attributes SEPARATOR ','»
						new «AttributeM.canonicalName»(«attr.nameLiteral»,"«attr.identifier»",
							new «BoundsM.canonicalName»(«attr.upperBound», «attr.lowerBound»))
					«ENDFOR»
				}
			);
			
			protected String getOriginalSignalName() {
				return «META_REPR_NAME».getName();
			}
			
			«content»
		}
	'''

	override generateContent() '''
		«FOR attribute : signal.attributes»
			/** Attribute for signal attribute «attribute.javadoc» */
			«javaType(attribute.type, attribute)» «attribute.identifier»
				= «createEmpty(attribute)»;
		«ENDFOR»

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
			«FOR attribute : signal.attributes BEFORE '''«signal.identifier» other = («signal.identifier») obj;'''»
				if (!other.«attribute.identifier».equals(this.«attribute.identifier»)) {
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
	'''

}
