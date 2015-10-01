package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationClass
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Association
import hu.eltesoft.modelexecution.runtime.base.Class
import hu.eltesoft.modelexecution.runtime.base.ClassWithState
import java.util.Objects

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
			
			public static «assocClass.identifier» link(«assocTemplate.endParams») {
				«assocClass.implementation» assoc = («assocClass.implementation») «assocClass.identifier».create(null);
				«FOR end : assocClass.ends»
					«end.identifier».«end.getter»().add(assoc);
				«ENDFOR»
				«FOR end : assocClass.ends»
					assoc.«end.identifier» = «end.identifier»;
				«ENDFOR»
				return assoc;
			}
			
			public static «assocClass.identifier» unlink(«assocTemplate.endParams») {
				«assocClass.identifier» assoc = «assocClass.identifier».create(null);
				«FOR end : assocClass.ends»
					«end.identifier».«end.getter»().remove(assoc);
				«ENDFOR»
				assoc.delete();
				return assoc;
			}
			
		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof «assocClass.identifier»)) {
				return false;
			}
			«assocClass.implementation» other = («assocClass.implementation») obj;
			«FOR end : assocClass.ends»
				if (!«end.identifier».equals(other.«end.identifier»)) {
					return false;
				}
			«ENDFOR»
			return true;
		}
		
		@Override
		public int hashCode() {
			return «Objects.canonicalName».hash(«assocTemplate.endIds»);
		}
			
			«content»
		}
	'''

	override generateContent() '''
		«assocTemplate.generateContent»
		«classTemplate.generateContent»
	'''

}