package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Signal
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import hu.eltesoft.modelexecution.runtime.meta.BoundsMeta
import hu.eltesoft.modelexecution.runtime.meta.ClassMeta
import hu.eltesoft.modelexecution.runtime.meta.PropertyMeta
import hu.eltesoft.modelexecution.runtime.serialize.JSONDecoder
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
					«PrimitiveOperations.SET_VALUE»(this.«attribute.identifier», «attribute.identifier»);
				«ENDFOR»
			}
			
			/** Meta-description of the structure of the class */
			public static «ClassMeta.canonicalName» «META_REPR_NAME» = new «ClassMeta.canonicalName»(
				«signal.nameLiteral»,
				new «PropertyMeta.canonicalName»[] { 
					«FOR attr : signal.attributes SEPARATOR ','»
						new «PropertyMeta.canonicalName»(«attr.nameLiteral»,"«attr.getter»",
							new «BoundsMeta.canonicalName»(«attr.upperBound», «attr.lowerBound»))
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
			private «javaType(attribute.type, attribute)» «attribute.identifier»
				= «createEmpty(attribute)»;
			
			public «javaType(attribute.type, attribute)» «attribute.getter»() {
				return «attribute.identifier»;
			}
			
		«ENDFOR»
		
		@Override
		public «JSONObject.canonicalName» jsonEncode() {
			«JSONObject.canonicalName» json = new «JSONObject.canonicalName»();
			json.put("«JSONDecoder.JSON_CLASS»", getClass().getCanonicalName());
			«FOR attribute : signal.attributes»
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
				if (!«PrimitiveOperations.UNWRAP»(«PrimitiveOperations.VALUE_EQUALITY»(other.«attribute.identifier», this.«attribute.identifier»))) {
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
