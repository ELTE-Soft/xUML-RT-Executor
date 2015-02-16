package hu.eltesoft.modelexecution.m2t.smap.xtend

import java.util.HashSet
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtend.lib.macro.expression.Expression
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference

import static extension hu.eltesoft.modelexecution.m2t.smap.xtend.BuiltinObjectsFactory.*

@Active(SourceMappedTemplateProcessor)
annotation SourceMappedTemplate {
    String stratumName;
}

class SourceMappedTemplateProcessor extends AbstractClassProcessor {

    var SmapCompiler compiler
    var JvmType thisType
    var JvmTypeReference blockReturnType
    val methodNames = new HashSet<String>

    override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
        compiler = new SmapCompiler
        getXtendPluginInjector.injectMembers(compiler)

        val cu = annotatedClass.getComilationUnit
        thisType = cu.toJvmTypeReference(newTypeReference(annotatedClass)).type
        blockReturnType = cu.toJvmTypeReference(newTypeReference(SmapStringConcatenation))

        val annotation = annotatedClass.findAnnotation(newTypeReference(SourceMappedTemplate).type)
        val stratumName = annotation.getStringValue("stratumName")

        annotatedClass.declaredMethods.filter[transformable].forEach [ method |
            methodNames.add(method.simpleName)
        ]

        annotatedClass.declaredMethods.filter[transformable].forEach [ method |
            annotatedClass.addMethod("smap_" + method.simpleName) [
                returnType = newTypeReference(SourceMappedText)
                for (param : method.parameters) {
                    addParameter(param.simpleName, param.type)
                }
                body = '''return «compileSmapCapableBody(method.body, stratumName)».toSourceMappedText();''';
            ]
            //method.simpleName = "_" + method.simpleName
            method.visibility = Visibility.PRIVATE
        ]
    }

    def transformable(MutableMethodDeclaration method) {
        return hasNoInferredParameters(method) && returnsCharSequence(method)
    }

    def hasNoInferredParameters(MutableMethodDeclaration method) {
        !method.parameters.exists[p|p.type.inferred]
    }

    def returnsCharSequence(MutableMethodDeclaration method) {
        null != method.body && compiler.returnsCharSequence(method.body)
    }

    def compileSmapCapableBody(Expression expression, String stratumName) {
        val output = createAppendable
        output.declareVariable(thisType, "this")
        compiler.compileBody(expression, output, stratumName, blockReturnType, methodNames, thisType)
        return output
    }
}
