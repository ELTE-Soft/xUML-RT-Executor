package hu.eltesoft.modelexecution.m2t.java

import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.base.ScalarType
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type
import hu.eltesoft.modelexecution.m2t.smap.emf.EmfTraceExtensions
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier
import java.util.Date
import javax.annotation.Generated
import org.apache.commons.lang.StringEscapeUtils
import org.eclipse.emf.common.util.EList

/**
 * Base class for code generation templates. It defines a common interface for
 * calling these templates, and also adds source mapping support for EMF object
 * references. Inherited classes must be annotated with
 * {@link hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
 * SourceMappedTemplate}.
 * Translation meta-model objects
 * should be passed as constructor parameters to a template.
 */
abstract class Template extends EmfTraceExtensions {

	public static val GETTER_PREFIX = "get_"
	public static val SETTER_PREFIX = "set_"
	public static val INHERITED_SUFFIX = "_inherited"
	public static val CLASS_IMPL_SUFFIX = "_impl"

	private val DebugSymbols debugSymbols
	private val JavaTypeConverter typeConverter = new JavaTypeConverter

	/**
	 * Call only after the generate method, as its location registry will only
	 * be propagated after code generation is done.
	 */
	def DebugSymbols getDebugSymbols() {
		return debugSymbols
	}

	new(Named genModel) {
		val nameMapping = new NameMapper().mapNames(genModel)
		debugSymbols = new DebugSymbols(locationRegistry, nameMapping)
	}

	/**
	 * Code generate for a root element.
	 */
	def CharSequence generate() {
		wrapContent(generateContent);
	}

	/**
	 * Wraps the generated content into a java class, possibly adding class elements 
	 * that cannot be composed, like constructors.
	 */
	def CharSequence wrapContent(CharSequence contents)

	/**
	 * Implement code generation for features here. The generated content should 
	 * be ready to be composed with contents from other root elements.
	 */
	def CharSequence generateContent()

	/**
	 * This definition should be ignored, as it is only here to suppress Xtend
	 * compilation error caused by a side effect of source mapping support.
	 */
	protected def CharSequence original_generate() ''''''

	protected def generatedHeaderForClass(Named root) '''
		@«Generated.canonicalName»(date = "«new Date().toString»", value = {}, comments = «root.nameLiteral»)
	'''

	/**
	 * Intended to be used as an extension method in form namedObject.identifier.
	 * It returns the identifier of the underlying named reference.
	 */
	def identifier(Named named) {
		named.reference.identifier
	}

	/**
	 * Intended to be used as an extension method in form namedObject.nameLiteral.
	 * It returns the original name as a Java string literal.
	 */
	def nameLiteral(Named named) {
		literal(named.reference.originalName)
	}

	def nameLiteral(NamedReference reference) {
		literal(reference.originalName)
	}

	def javadocParams(EList<? extends Named> params) '''
		«FOR param : params»
			* @param «param.identifier» «param.javadoc»
		«ENDFOR»
	'''

	/**
	 * Escapes and emphasizes original names of elements
	 */
	def javadoc(Named named) {
		"<b>" + javadocEscape(named.reference.originalName) + "</b>"
	}

	/**
	 * Escapes a string to be used in javadoc
	 */
	def javadocEscape(String toEscape) {
		val htmlEscaped = StringEscapeUtils.escapeHtml(toEscape)
		if (htmlEscaped != null) {
			htmlEscaped.replace("*/", "{@literal */}").replace("@", "{@literal @}")
		} else {
			""
		}
	}

	/**
	 * Helps tracing location information of Named objects.
	 * Prints out the name of the object, while the contained EMF reference will
	 * be traced to the location of the name. 
	 */
	def <T extends Named> trace(T data) {
		return trace(data.identifier, data.reference)
	}

	def <T extends Named> trace(T data, Class<? extends LocationQualifier> classifier) {
		return trace(data.identifier, data.reference, classifier)
	}

	/**
	 * Uses the original name of the object as a string literal while tracing
	 * its source location. It escapes the name to make it safe.
	 */
	def <T extends Named> traceLiteral(T data) {
		return trace(data.nameLiteral, data.reference)
	}

	def <T extends Named> traceLiteral(T data, Class<? extends LocationQualifier> classifier) {
		return trace(data.nameLiteral, data.reference, classifier)
	}

	/**
	 * Escapes a string to let it print safely inside a Java string literal. 
	 */
	def escape(String text) {
		StringEscapeUtils.escapeJava(text)
	}

	/**
	 * Creates a Java string literal from the given text safely.
	 */
	def literal(String text) '''"«escape(text)»"'''

	def javaType(Type type) {
		typeConverter.javaType(type)
	}

	def javaType(ScalarType type) {
		typeConverter.javaType(type)
	}

	def javaType(ScalarType type, Multiplicity mult) {
		typeConverter.javaType(type, mult)
	}

	def createEmpty(Multiplicity type) {
		typeConverter.createEmpty(type)
	}
	
	def getter(Named ref) { GETTER_PREFIX + ref.identifier }
	
	def setter(Named ref) { SETTER_PREFIX + ref.identifier }
	
	def inherited(Named ref) { ref.identifier + INHERITED_SUFFIX }
	
	def inherited(NamedReference ref) { ref.identifier + INHERITED_SUFFIX }
	
	def implementation(Named ref) { ref.identifier + CLASS_IMPL_SUFFIX }
	
	def implementation(NamedReference ref) { ref.identifier + CLASS_IMPL_SUFFIX }

}
