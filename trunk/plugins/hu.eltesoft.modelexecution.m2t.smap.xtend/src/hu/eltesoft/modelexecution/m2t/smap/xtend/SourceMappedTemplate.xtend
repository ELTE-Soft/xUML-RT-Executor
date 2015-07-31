package hu.eltesoft.modelexecution.m2t.smap.xtend

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend2.lib.StringConcatenation

/**
 * Enables JSR-045 compatible source mapping support for ordinary Xtend templates.
 * It should be used on Xtend classes which are serving code generation purposes.
 * If present, the annotation processor generates an additional class. When the
 * annotated template class name is X, then the the generated source mapping
 * capable class will be named as XSmap. In its method bodies, the usual StringConcatenation
 * class is replaced with a custom SmapStringConcatenation, which is able to collect
 * and return source mapping related information in a straightforward way.
 * 
 * Exact source locations could be added to template substitutions using one of
 * the trace methods in the {@link TraceExtensions} class. Example:
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

	override void doGenerateCode(ClassDeclaration annotatedClass, extension CodeGenerationContext context) {
		val stratumName = annotatedClass.annotations.findFirst[a|
			a.annotationTypeDeclaration.qualifiedName == SourceMappedTemplate.name].getStringValue("stratumName")

		val sourcePath = annotatedClass.compilationUnit.filePath
		var outputFile = sourcePath.targetFolder.append(annotatedClass.qualifiedName.replace('.', '/') + ".java")
		var javaCode = outputFile.contents.toString
		val className = annotatedClass.simpleName

		// add import for SmapStringConcatenation
		val annotationPattern = '''@«SourceMappedTemplate.simpleName»'''
		javaCode = javaCode.replace(annotationPattern,
			'''
			import «SmapStringConcatenation.name»;
			import «SourceMappedText.name»;
			
			«annotationPattern»''')

		// replace class name
		javaCode = javaCode.replaceAll("\\b"+ className + "\\b", className + "Smap");

		// replace builder constructors
		javaCode = javaCode.replace(
			'''«StringConcatenation.simpleName» _builder = new «StringConcatenation.simpleName»();''',
			'''«SmapStringConcatenation.simpleName» _builder = new «SmapStringConcatenation.simpleName»("«stratumName»");''')

		// replace references in return statements and assignments
		javaCode = javaCode.replace(" _builder;", " _builder.toSourceMappedText();")

		// replace return types
		javaCode = javaCode.replaceAll(" CharSequence ([^\\(\\s]+)\\(", " SourceMappedText $1(")

		// write out contents
		outputFile = sourcePath.targetFolder.append(annotatedClass.qualifiedName.replace('.', '/') + "Smap.java")
		outputFile.contents = javaCode
	}
}
