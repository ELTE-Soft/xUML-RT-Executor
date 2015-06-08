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
	val boolean needsContext

	new(BhBehavior behavior) {
		this.behavior = behavior
		val generator = new BehaviorBodyGenerator
		compiledAlfCode = generator.generate(behavior.alfResult)
		needsContext = !compiledAlfCode.text.toString.trim.empty && !behavior.isStatic
	}

	override generate() '''
		«generatedHeaderForClass(behavior)»
		public class «behavior.identifier» extends «ActionCode.canonicalName» {
		
			«IF behavior.returnType != null»
				private «behavior.returnType.identifier» ret;
				
				public «behavior.returnType.identifier» getReturnValue() {
					return ret;
				}
			«ENDIF»
			«FOR param : behavior.parameters»
				«javaType(param.type, param.direction)» «param.identifier»;
			«ENDFOR»
		
			«IF needsContext»
				«generatedHeader(behavior.containerClass)»
				private «behavior.containerClass.identifier» «CONTEXT_NAME»;
			«ENDIF»
		
			public «behavior.identifier»(
				«IF !behavior.isStatic»«behavior.containerClass.identifier» «CONTEXT_NAME»
					«IF !behavior.parameters.empty»,«ENDIF»
				«ENDIF»
				«FOR param : behavior.parameters SEPARATOR ','»
					«javaType(param.type, param.direction)» «param.identifier»
				«ENDFOR»
				) {
				«IF needsContext»
					this.«CONTEXT_NAME» = «CONTEXT_NAME»;
				«ENDIF»
				«FOR param : behavior.parameters»
					this.«param.identifier» = «param.identifier»;
				«ENDFOR»
			}
		
			@Override
			public void execute() {
				«compiledAlfCode»
			}
		
			@Override
			public String toString() {
				return «behavior.nameLiteral»;
			}
		}
	'''
}
