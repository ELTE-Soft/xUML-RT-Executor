package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.java.behavior.BehaviorCompiler
import hu.eltesoft.modelexecution.m2t.java.behavior.CompilerBase
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import hu.eltesoft.modelexecution.runtime.base.ActionCode

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

@SourceMappedTemplate(stratumName=XUML_RT)
class BehaviorTemplate extends Template {

	static val CONTEXT_NAME = CompilerBase.CONTEXT_NAME
	static val SIGDATA_NAME = CompilerBase.SIGDATA_NAME

	val BhBehavior behavior
	val SourceMappedText compiledCode
	val boolean returns

	new(BhBehavior behavior) {
		super(behavior)
		this.behavior = behavior
		val compiler = new BehaviorCompiler
		returns = behavior.returnType != null
		compiledCode = compiler.compile(behavior.parsingResults).toSourceMappedText
	}

	override wrapContent(CharSequence content) '''
		/** Class for implementing behavior «behavior.javadoc» 
		 */
		«generatedHeaderForClass(behavior)»
		public class «behavior.identifier» extends «ActionCode.canonicalName» {
			«content»
		}
	'''

	override generateContent() '''
		/** Static method implementing behavior «behavior.javadoc» 
		 «IF returns»* @param «CONTEXT_NAME» Behavior parameter for passing context«ENDIF»
		 «javadocParams(behavior.parameters)»
		 */
		public static «IF returns»«javaType(behavior.returnType)»«ELSE»void«ENDIF» execute(
			«FOR param : allParameters SEPARATOR ', '»«param.value» «param.key»«ENDFOR»
		) {
			«compiledCode»
		}
	'''

	def allParameters() {
		val parameters = newLinkedList()
		if (!behavior.isIsStatic) {
			parameters.add(CONTEXT_NAME -> behavior.containerClass.identifier)
		}
		if (behavior.hasSignal) {
			// As it is very complicated to calculate the appropriate signal type here, we are using Object.
			// It will be casted to a specific signal type directly when its attributes are accessed in the body.
			parameters.add(SIGDATA_NAME -> Object.canonicalName)
		}
		behavior.parameters.forEach [
			parameters.add(identifier -> type.javaType)
		]
		parameters
	}
}
