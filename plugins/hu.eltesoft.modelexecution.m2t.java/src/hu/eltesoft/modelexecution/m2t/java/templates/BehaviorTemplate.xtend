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

	val BhBehavior behavior
	val SourceMappedText compiledCode
	val boolean returns

	new(BhBehavior behavior) {
		super(behavior)
		this.behavior = behavior
		val compiler = new BehaviorCompiler
		returns = behavior.returnType != null
		compiledCode = compiler.compile(behavior.parsingResults)
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
			«IF !behavior.isStatic»«behavior.containerClass.identifier» «CONTEXT_NAME»«ENDIF»
			«FOR param : behavior.parameters BEFORE (if (!behavior.isStatic) ',' else '') SEPARATOR ','»
				«javaType(param.type)» «param.identifier»
			«ENDFOR»
		) {
			«compiledCode»
			«IF behavior.returnType != null»
				// walkaround while we are not generating actual action code
				return null;
			«ENDIF»
		}
	'''
}
