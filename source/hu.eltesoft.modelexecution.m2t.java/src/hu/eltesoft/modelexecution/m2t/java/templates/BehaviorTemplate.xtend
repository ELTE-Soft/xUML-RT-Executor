package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior
import hu.eltesoft.modelexecution.m2t.java.Languages
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SmapStringConcatenation
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import hu.eltesoft.modelexecution.runtime.base.ActionCode
import hu.eltesoft.modelexecution.uml.alf.OperationBodyCompiler

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

@SourceMappedTemplate(stratumName=ALF)
class BehaviorTemplate extends Template {

	static val CONTEXT_NAME = OperationBodyCompiler.CONTEXT_NAME

	val BhBehavior behavior
	val SourceMappedText compiledAlfCode
	val boolean needsContext

	new(BhBehavior behavior) {
		this.behavior = behavior
		compiledAlfCode = compile(behavior.alfCode)
		needsContext = !compiledAlfCode.text.toString.trim.empty
	}

	def SourceMappedText compile(String alfCode) {
		val builder = new SmapStringConcatenation(Languages.ALF)
		new OperationBodyCompiler().compile(alfCode, builder);
		return builder.toSourceMappedText
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
