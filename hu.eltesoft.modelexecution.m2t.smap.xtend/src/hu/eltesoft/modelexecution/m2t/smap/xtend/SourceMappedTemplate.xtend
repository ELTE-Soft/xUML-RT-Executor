package hu.eltesoft.modelexecution.m2t.smap.xtend

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtend.lib.macro.expression.Expression

import static extension hu.eltesoft.modelexecution.m2t.smap.xtend.BuiltinObjectsFactory.*

/**
 * Enables JSR-045 compatible source mapping support for ordinary Xtend templates.
 * It should be used on Xtend classes which are serving code generation purposes.
 * When present, code for each template method (which is returning a CharSequence)
 * will be generated twice. First, the Xtend compiler will create its own code,
 * but this method will be renamed as it gets prefixed with ORIGINAL_PREFIX.
 * Second, the associated annotation processor will generate custom body for each
 * template method with its original name. In this body, the usual StringConcatenation
 * class is replaced with a custom SmapStringConcatenation, which is able to collect
 * and return source mapping related information in a straightforward way.
 * 
 * Exact source locations could be added to template substitutions using one of
 * the trace methods in the TraceExtensions class. Example:
 * 
 * val Location location = ...;
 * 
 * def generate(String name) '''Hello «trace(location, name)»!'''
 */
@Active(SourceMappedTemplateProcessor)
annotation SourceMappedTemplate {
	String stratumName;
}

class SourceMappedTemplateProcessor extends AbstractClassProcessor {

	public static val ORIGINAL_PREFIX = "original_"
	public static val SMAP_CONCAT_CLASS_NAME = SmapStringConcatenation.canonicalName

	var SmapCompiler compiler

	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {

		// collect and assemble compilation data and set up compiler
		val cu = annotatedClass.getCompilationUnitInternal
		val thisType = cu.toJvmTypeReference(newTypeReference(annotatedClass)).type

		val annotation = annotatedClass.findAnnotation(newTypeReference(SourceMappedTemplate).type)
		val stratumName = annotation.getStringValue("stratumName")

		compiler = new SmapCompiler(thisType, stratumName)
		getXtendPluginInjector.injectMembers(compiler)

		annotatedClass.declaredMethods.filter[transformable].forEach [ method |
			compiler.addOriginalMethodName(method.simpleName)
		]

		// run transformation over appropriate methods
		annotatedClass.declaredMethods.filter[transformable].forEach [ method |
			annotatedClass.addMethod(method.simpleName) [
				it.returnType = newTypeReference(SourceMappedText)
				for (param : method.parameters) {
					it.addParameter(param.simpleName, param.type)
				}
				val smapBody = compileSmapCapableBody(method.body)
				it.body = '''
					return ((«SMAP_CONCAT_CLASS_NAME»)«smapBody»).toSourceMappedText();
				''';
				method.simpleName = ORIGINAL_PREFIX + method.simpleName
				method.visibility = Visibility.PROTECTED
			]
		]
	}

	def transformable(MutableMethodDeclaration method) {
		return !hasInferredParameters(method) && returnsCharSequence(method)
	}

	def hasInferredParameters(MutableMethodDeclaration method) {
		method.parameters.exists[p|p.type.inferred]
	}

	def returnsCharSequence(MutableMethodDeclaration method) {
		null != method.body && compiler.returnsCharSequence(method.body)
	}

	def compileSmapCapableBody(Expression expression) {
		val output = createAppendable
		compiler.compileBody(expression, output)
		return output
	}
}
