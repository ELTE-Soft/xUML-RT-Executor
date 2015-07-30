package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationClass
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.Runtime
import hu.eltesoft.modelexecution.runtime.base.Association
import hu.eltesoft.modelexecution.runtime.base.Class
import hu.eltesoft.modelexecution.runtime.base.ClassWithState

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

@SourceMappedTemplate(stratumName=XUML_RT)
class AssociationClassTemplate extends Template {

	val AsAssociationClass assocClass

	val AssociationTemplate assocTemplate
	val ClassTemplate classTemplate

	boolean stateful

	new(AsAssociationClass assocClass) {
		super(assocClass)
		this.assocClass = assocClass
		stateful = assocClass.region != null
		assocTemplate = new AssociationTemplate(assocClass)
		classTemplate = new ClassTemplate(assocClass)
	}

	override wrapContent(CharSequence content) '''
		/** Generated class for association class «assocClass.javadoc» */
		«generatedHeaderForClass(assocClass)»
		class «assocClass.implementation» 
			extends «IF stateful»«ClassWithState.canonicalName»«ELSE»«Class.canonicalName»«ENDIF» 
			implements «Association.canonicalName», «assocClass.identifier» {
		
			/** Association constructor for UML class «assocClass.javadoc» */
			public «assocClass.implementation»(«Runtime.canonicalName» runtime
					«FOR parent : assocClass.parents», «parent.implementation» «parent.inherited»«ENDFOR»,
					«assocTemplate.endParams») {
				«IF stateful»super(runtime, instanceCount.getAndIncrement());«ENDIF»
				«FOR parent : assocClass.parents»
					this.«parent.inherited» = «parent.inherited»;
				«ENDFOR»
				«FOR end : assocClass.ends»
					this.«end.identifier» = «end.identifier»;
				«ENDFOR»
			}
			«content»
		}
	'''

	override generateContent() '''
		«assocTemplate.generateContent»
		«classTemplate.generateContent»
	'''

}