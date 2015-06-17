package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior
import hu.eltesoft.modelexecution.m2t.java.BehaviorBodyGenerator
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import hu.eltesoft.modelexecution.runtime.base.ActionCode

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

@SourceMappedTemplate(stratumName=XUML_RT)
class BehaviorTemplate extends Template {

	static val CONTEXT_NAME = BehaviorBodyGenerator.CONTEXT_NAME

	val BhBehavior behavior
	val SourceMappedText compiledAlfCode
	val boolean returns

	new(BhBehavior behavior) {
		super(behavior)
		this.behavior = behavior
		val generator = new BehaviorBodyGenerator
		returns = behavior.returnType != null
		compiledAlfCode = generator.generate(behavior.alfResult)
	}

	override generate() '''
		/** Class for implementing behavior «behavior.javadoc» 
		 */
		«generatedHeaderForClass(behavior)»
		public class «behavior.identifier» extends «ActionCode.canonicalName» {
				
			/** Static method implementing behavior «behavior.javadoc» 
			 «IF returns»* @param «CONTEXT_NAME» Behavior parameter for passing context«ENDIF»
			 «javadocParams(behavior.parameters)»
			 */
			public static «IF returns»«typeConverter.javaType(behavior.returnType)»«ELSE»void«ENDIF» execute(
				«IF !behavior.isStatic»«behavior.containerClass.identifier» 
					«CONTEXT_NAME»
					«IF !behavior.parameters.empty»,«ENDIF»
				«ENDIF»
				«FOR param : behavior.parameters SEPARATOR ','»
					«typeConverter.javaType(param.type)» «param.identifier»
				«ENDFOR»
			) {
				«compiledAlfCode»
				«IF behavior.returnType != null»
					// walkaround while we are not generating actual action code
					return null;
				«ENDIF»
			}
		}
	'''
}
