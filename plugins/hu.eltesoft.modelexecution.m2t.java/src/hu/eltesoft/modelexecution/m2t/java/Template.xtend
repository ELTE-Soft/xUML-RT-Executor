package hu.eltesoft.modelexecution.m2t.java

import hu.eltesoft.modelexecution.m2m.metamodel.base.Named
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2t.smap.emf.EmfTraceExtensions
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier
import java.util.Date
import org.apache.commons.lang.StringEscapeUtils
import javax.annotation.Generated

/**
 * Base class for code generation templates. It defines a common interface for
 * calling these templates, and also adds source mapping support for EMF object
 * references. Inherited classes must be annotated with
 * {@link hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
 * SourceMappedTemplate}.
 */
abstract class Template extends EmfTraceExtensions {

	private val DebugSymbols debugSymbols;
	private val String rootName;
	private val TypeConverter typeConverter = new TypeConverter;

	/**
	 * Call only after the generate method, as its location registry will only
	 * be propagated after code generation is done.
	 */
	def DebugSymbols getDebugSymbols() {
		return debugSymbols
	}

	def String getRootName() {
		return rootName
	}

	new(Named genModel) {
		val nameMapping = new NameMapper().mapNames(genModel)
		debugSymbols = new DebugSymbols(locationRegistry, nameMapping)
		rootName = genModel.identifier
	}

	/**
	 * Implement code generation logic here. Translation meta-model objects
	 * should be passed as constructor parameters to a template.
	 */
	def CharSequence generate();

	/**
	 * This definition should be ignored, as it is only here to suppress Xtend
	 * compilation error caused by a side effect of source mapping support.
	 */
	protected def CharSequence original_generate() ''''''

	protected def generatedHeaderForClass(Named root) '''
		@«Generated.canonicalName»(date = "«new Date().toString»", value = { «root.nameLiteral» })
		@«SuppressWarnings.canonicalName»("all")
	'''

	protected def generatedHeader(Named named) '''
		@«Generated.canonicalName»(value = { «named.nameLiteral» })
	'''

	protected def generatedHeader(NamedReference reference) '''
		@«Generated.canonicalName»(value = { «reference.nameLiteral» })
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
	
	def getTypeConverter() {
		typeConverter
	}

}
