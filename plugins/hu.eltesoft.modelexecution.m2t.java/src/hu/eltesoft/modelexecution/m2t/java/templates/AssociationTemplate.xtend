package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociation
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Association

import static hu.eltesoft.modelexecution.m2t.java.Languages.*
import java.util.Objects

@SourceMappedTemplate(stratumName=XUML_RT)
class AssociationTemplate extends Template {

	val AsAssociation association

	new(AsAssociation association) {
		super(association)
		this.association = association
	}

	override wrapContent(CharSequence content) '''
		/** Association class for association «association.javadoc» */
		«generatedHeaderForClass(association)»
		class «association.identifier» implements «Association.canonicalName» {

			public «association.identifier»(«endParams») {
				«FOR end : association.ends»
					this.«end.identifier» = «end.identifier»;
				«ENDFOR»
			}
			«content»
		}
	'''

	override generateContent() '''
		«FOR end : association.ends»
			/** Attribute for association end «end.javadoc» */
			public «javaType(end.type)» «end.identifier»;
		«ENDFOR»
		
		public static «association.identifier» link(«endParams») {
			«association.identifier» assoc = new «association.identifier»(«endIds»);
			«FOR end : association.ends»
				«end.identifier».«end.getter»().add(assoc);
			«ENDFOR»
			return assoc;
		}
		
		public static «association.identifier» unlink(«endParams») {
			«association.identifier» assoc = new «association.identifier»(«endIds»);
			«FOR end : association.ends»
				«end.identifier».«end.getter»().remove(assoc);
			«ENDFOR»
			return assoc;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof «association.identifier»)) {
				return false;
			}
			«association.identifier» other = («association.identifier») obj;
			«FOR end : association.ends»
				if (!«end.identifier».equals(other.«end.identifier»)) {
					return false;
				}
			«ENDFOR»
			return true;
		}
		
		@Override
		public int hashCode() {
			return «Objects.canonicalName».hash(«endIds»);
		}
	'''
	
	def endIds() '''
		«FOR otherEnd : association.ends SEPARATOR ','»
			«otherEnd.identifier»
		«ENDFOR»
	'''

	def endParams() '''
		«FOR end : association.ends SEPARATOR ','»
			«javaType(end.type)» «end.identifier»
		«ENDFOR»
	'''

}