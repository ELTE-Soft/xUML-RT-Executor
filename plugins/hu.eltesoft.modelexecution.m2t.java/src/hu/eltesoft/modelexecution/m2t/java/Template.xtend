package hu.eltesoft.modelexecution.m2t.java

import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type
import hu.eltesoft.modelexecution.m2t.smap.emf.EmfTraceExtensions
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier
import java.util.Collections
import java.util.Date
import org.apache.commons.lang.StringEscapeUtils
import org.eclipse.emf.ecore.EObject
import hu.eltesoft.modelexecution.m2m.metamodel.base.Direction

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

	protected def generatedHeaderForClass(Named root) '''
		import javax.annotation.Generated;
		
		@Generated(date = "«new Date().toString»", value = { «root.nameLiteral» })
	'''

	protected def generatedHeader(Named named) '''
		@Generated(value = { «named.nameLiteral» })
	'''

	protected def generatedHeader(NamedReference reference) '''
		@Generated(value = { «reference.nameLiteral» })
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
	
	/**
	 * Create java type from a primitive type
	 */
	dispatch def javaType(PrimitiveType type) {
		javaPrimitiveType(type.type);
	}
	
	/**
	 * Create java type from a data class
	 */
	dispatch def javaType(Type type) {
		type.reference.identifier
	}
	
	/**
	 * Create java type from a primitive type with direction
	 */
	dispatch def javaType(PrimitiveType type, Direction direction) {
		genTypeWithDirection(direction, javaPrimitiveType(type.type));
	}
	
	/**
	 * Create java type from a data class with direction
	 */
	dispatch def javaType(Type type, Direction direction) {
		genTypeWithDirection(direction, type.reference.identifier)
	}
	/**
	 * Create java type from a primitive type with multiplicity
	 */
	dispatch def javaType(PrimitiveType type, Multiplicity multiplicity) {
		val baseType = javaPrimitiveType(type.type);
		genTypeWithMultiplicity(multiplicity, baseType)
	}
	
	/**
	 * Create java type from a data class with multiplicity
	 */
	dispatch def javaType(Type type, Multiplicity multiplicity) {
		genTypeWithMultiplicity(multiplicity, type.reference.identifier)
	}
	
	def genTypeWithMultiplicity(Multiplicity mult, CharSequence baseType) {
		// FIXME: wrong code is generated from the following
//		switch (mult) {
//			case MULTI: ArrayList.canonicalName + "<" + baseType + ">"
//			case ONE: baseType
//		}
		baseType
	}
	
		def genTypeWithDirection(Direction direction, CharSequence baseType) {
		// FIXME: wrong code is generated from the following
//		switch (mult) {
//			case OUT, INOUT: Reference.canonicalName + "<" + baseType + ">"
//			default: baseType
//		}
		baseType
	}
	
	def javaPrimitiveType(PrimitiveTypes primType) {
		switch (primType) {
			case BOOLEAN: "Boolean"
			case INTEGER: "Integer"
			case STRING: "String"
		}
	}
	
}
