package hu.eltesoft.modelexecution.m2t.java

import hu.eltesoft.modelexecution.m2m.metamodel.base.Named
import hu.eltesoft.modelexecution.m2t.smap.emf.EmfTraceExtensions
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier
import java.util.Collections
import java.util.Date
import org.eclipse.emf.ecore.EObject

/**
 * Base class for code generation templates. It defines a common interface for
 * calling these templates, and also adds source mapping support for EMF object
 * references. Inherited classes must be annotated with
 * {@link hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
 * SourceMappedTemplate}.
 */
abstract class Template extends EmfTraceExtensions {

	private val DebugSymbols debugSymbols;

	/**
	 * Call only after the generate method, as its location registry will only
	 * be propagated after code generation is done.
	 */
	def DebugSymbols getDebugSymbols() {
		return debugSymbols
	}

	new() {
		val nameMapping = Collections.EMPTY_MAP
		debugSymbols = new DebugSymbols(locationRegistry, nameMapping)
	}

	new(EObject genModel) {
		val nameMapping = new NameMapper().mapNames(genModel)
		debugSymbols = new DebugSymbols(locationRegistry, nameMapping)
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

	protected def generatedHeader(String value) '''
		import javax.annotation.Generated;
		@Generated(date = "«new Date().toString»", value = { "«value»" })
	'''

	/**
	 * Intended to be used as an extension method in form namedObject.name.
	 * It returns the new identifier of the underlying named reference.
	 */
	def name(Named named) {
		named.reference.newIdentifier
	}

	/**
	 * Intended to be used as an extension method in form namedObject.name.
	 * It returns the original name of the underlying named reference.
	 */
	def originalName(Named named) {
		named.reference.originalName
	}

	/**
	 * Helps tracing location information of Named objects.
	 * Prints out the name of the object, while the contained EMF reference will
	 * be traced to the location of the name. 
	 */
	def <T extends Named> trace(T data) {
		return trace(data.name, data.reference)
	}

	def <T extends Named> trace(T data, Class<? extends LocationQualifier> classifier) {
		return trace(data.name, data.reference, classifier)
	}

	def <T extends Named> traceOriginal(T data) {
		return trace(data.originalName, data.reference)
	}

	def <T extends Named> traceOriginal(T data, Class<? extends LocationQualifier> classifier) {
		return trace(data.originalName, data.reference, classifier)
	}
}
