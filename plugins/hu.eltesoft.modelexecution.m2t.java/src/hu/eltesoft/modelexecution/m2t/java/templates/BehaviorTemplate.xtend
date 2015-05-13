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
		compiledAlfCode = generator.generate(behavior.alfResult.astRoot)
		needsContext = !compiledAlfCode.text.toString.trim.empty
	}

	override generate() '''
		«generatedHeader(behavior.name)»
		public class «behavior.name» extends «ActionCode.canonicalName» {
		
			«IF needsContext»
				private «behavior.containerClass.name» «CONTEXT_NAME»;
			«ENDIF»
		
			public «behavior.name»(«behavior.containerClass.name» «CONTEXT_NAME») {
				«IF needsContext»
					this.«CONTEXT_NAME» = «CONTEXT_NAME»;
				«ENDIF»
			}
		
			@Override
			public void execute() {
				«compiledAlfCode»
			}
		}
	'''
}
