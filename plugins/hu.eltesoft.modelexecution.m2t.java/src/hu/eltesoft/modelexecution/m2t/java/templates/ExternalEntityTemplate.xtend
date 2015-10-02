package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.base.Named
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType
import hu.eltesoft.modelexecution.m2m.metamodel.base.ReferencedType
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExOperation
import hu.eltesoft.modelexecution.m2t.java.JavaTypeConverter
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.external.ExternalEntity
import hu.eltesoft.modelexecution.runtime.external.ExternalEntityType

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

@SourceMappedTemplate(stratumName=XUML_RT)
class ExternalEntityTemplate extends Template {

	extension JavaTypeConverter typeConverter = new JavaTypeConverter

	val ExExternalEntity entity

	new(ExExternalEntity entity) {
		super(entity)
		this.entity = entity
	}

	override wrapContent(CharSequence content) '''
		«generatedHeaderForClass(entity)»
		@«ExternalEntity.canonicalName»(
			implementationClass = «entity.implementationClass.literal»,
			type = «ExternalEntityType.canonicalName».«entity.type.convert»)
		public interface «entity.originalName» {
			«content»
		}
	'''
	
	override generateContent() '''
		«FOR operation : entity.operations»
			
			public «IF operation.returns»«operation.returnType.baseType.scalarType»«ELSE»void«ENDIF» «operation.originalName»(
			«FOR parameter : operation.parameters SEPARATOR ','»
				final «parameter.type.baseType.scalarType» «parameter.originalName»
			«ENDFOR»
			);
		«ENDFOR»
	'''

	def convert(ExEntityType type) {
		switch (type) {
			case STATELESS: ExternalEntityType.Stateless.name
			case SINGLETON: ExternalEntityType.Singleton.name
		}
	}

	dispatch def scalarType(PrimitiveType type) {
		javaPrimitiveType(type.type);
	}

	dispatch def scalarType(ReferencedType type) {
		// callable class reference
		type.reference.originalName
	}

	def originalName(Named named) {
		named.reference.originalName
	}

	def returns(ExOperation op) {
		op.returnType != null
	}
}
