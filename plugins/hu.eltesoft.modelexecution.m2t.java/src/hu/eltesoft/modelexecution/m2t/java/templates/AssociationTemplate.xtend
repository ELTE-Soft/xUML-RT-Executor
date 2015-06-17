package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociation
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Association

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

@SourceMappedTemplate(stratumName=XUML_RT)
class AssociationTemplate extends Template {
	
	val AsAssociation association
	
	new(AsAssociation association) {
		super(association)
		this.association = association
	}
	
	override generate() '''
		/** Association class for association «association.javadoc» */
		«generatedHeaderForClass(association)»
		class «association.identifier» extends «Association.canonicalName» {
			
			«FOR end : association.ends»
				/** Attribute for association end «end.javadoc» */
				public «typeConverter.javaType(end.type)» «end.identifier»;
			«ENDFOR»
			
			public «association.identifier»(«endParams()») {
				«FOR end : association.ends»
					this.«end.identifier» = «end.identifier»;
				«ENDFOR»
			}
		
		}
	'''
	
	def endParams() '''
		«FOR end : association.ends SEPARATOR ','»
			«typeConverter.javaType(end.type)» «end.identifier»
		«ENDFOR»
	'''
	
}