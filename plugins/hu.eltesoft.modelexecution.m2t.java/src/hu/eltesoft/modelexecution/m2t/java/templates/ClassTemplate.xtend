package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociation
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttribute
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttributeSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAssociation
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClInheritedAttribute
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperation
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReception
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Class
import hu.eltesoft.modelexecution.runtime.base.ClassWithState
import hu.eltesoft.modelexecution.runtime.base.SignalEvent
import hu.eltesoft.modelexecution.runtime.base.StateMachineRegion
import java.util.LinkedList
import java.util.concurrent.atomic.AtomicInteger

import static hu.eltesoft.modelexecution.m2t.java.Languages.*
import hu.eltesoft.modelexecution.runtime.meta.ClassMeta
import hu.eltesoft.modelexecution.runtime.meta.BoundsMeta
import hu.eltesoft.modelexecution.runtime.meta.PropertyMeta

@SourceMappedTemplate(stratumName=XUML_RT)
class ClassTemplate extends Template {

	val ClClass classDefinition
	val boolean hasStateMachine

	new(ClClass classDefinition) {
		super(classDefinition)
		this.classDefinition = classDefinition
		this.hasStateMachine = classDefinition.region != null
	}

	override wrapContent(CharSequence content) '''
		/** Implementation class for UML class «classDefinition.javadoc» */
		«generatedHeaderForClass(classDefinition)»
		public class «classDefinition.implementation» 
			extends «IF (hasStateMachine)»«ClassWithState.canonicalName»«ELSE»«Class.canonicalName»«ENDIF»
			implements «classDefinition.identifier» {
		
			«content»
		}
	'''
	
	override generateContent() '''
		private static final «AtomicInteger.canonicalName» nextInstanceID = new «AtomicInteger.canonicalName»(0);
		
		/** Constructor for UML class «classDefinition.javadoc» */
		public «classDefinition.implementation»(
				«FOR parent : classDefinition.parents SEPARATOR ','»
					«parent.implementation» «parent.inherited»
				«ENDFOR») {
			super(nextInstanceID.getAndIncrement());
			«FOR parent : classDefinition.parents»
				this.«parent.inherited» = «parent.inherited»;«»
			«ENDFOR»
		}
		
		/** Meta-description of the structure of the class */
		public static «ClassMeta.canonicalName» «META_REPR_NAME» = new «ClassMeta.canonicalName»(
			«classDefinition.nameLiteral»,
			new «PropertyMeta.canonicalName»[] { 
				«FOR attr : classDefinition.allAttributes SEPARATOR ','»
					new «PropertyMeta.canonicalName»(«attr.nameLiteral»,"«attr.getter»",
						new «BoundsMeta.canonicalName»(«attr.type.upperBound», «attr.type.lowerBound»))
				«ENDFOR»
			}
		);
		
		public String getOriginalClassName() {
			return «META_REPR_NAME».getName();
		}

		«IF hasStateMachine»
			@Override
			protected «StateMachineRegion.canonicalName» createStateMachine() {
				return new «classDefinition.region.identifier»(this);
			}
			«IF classDefinition.hasReceptions»
			
			// receptions
			«FOR reception : classDefinition.receptions»
				
				«generateExternalReception(reception)»
			«ENDFOR»
			«ENDIF»
		«ENDIF»
		
		«generateStructuralClassBody()»
	'''

	def generateStructuralClassBody() '''
	// references to parent objects
	«FOR parent : classDefinition.parents»
		
		«parent.implementation» «parent.inherited»;
	«ENDFOR»

	// destructor
	public void destroy() {
		if (isDeleted()) {
			// verification error: double destruction
		}
		«IF null != classDefinition.destructor»
			«classDefinition.destructor.identifier».execute(this);
		«ELSE»
			// default destructor, no destroy operation defined in the model
		«ENDIF»
		setDeleted();
	}

	// attributes
	«FOR attribute : classDefinition.attributes»
		
		«generateAttribute(attribute)»
	«ENDFOR»

	// inherited attributes
	«FOR attribute : classDefinition.inheritedAttributes»
		
		«generateInheritedAttribute(attribute)»
	«ENDFOR»

	// associations
	«FOR association : classDefinition.associations»
		
		«generateAssociation(association)»
	«ENDFOR»

	// inherited associations
	«FOR association : classDefinition.inheritedAssociations»
		
		«generateInheritedAssociation(association)»
	«ENDFOR»

	// operations (both defined and inherited)
	«FOR operation : classDefinition.operations»
		
		«generateOperation(operation)»
	«ENDFOR»
	'''

	def generateAttribute(
		ClAttribute attribute
	) '''
		/** Attribute for UML attribute «attribute.javadoc» */
		private «IF attribute.isStatic»static«ENDIF» «javaType(attribute.type)» «attribute.identifier» = «createEmpty(attribute.type)»;
		
		«IF !attribute.isStatic»@Override«ENDIF»
		public «IF attribute.isStatic»static«ENDIF» «javaType(attribute.type)» «attribute.getter»() {
			return «attribute.identifier»;
		}
		
		«IF !attribute.isStatic»@Override«ENDIF»
		public «IF attribute.isStatic»static«ENDIF» void «attribute.setter»(«javaType(attribute.type)» newVal) {
			«attribute.identifier» = newVal;
		}
	'''
	
	def generateInheritedAttribute(
		ClInheritedAttribute attribute
	) '''
		@Override
		public «javaType(attribute.type)» «attribute.getter»() {
			return «attribute.parent.inherited».«attribute.getter»();
		}
		
		@Override
		public void «attribute.setter»(«javaType(attribute.type)» newVal) {
			«attribute.parent.inherited».«attribute.setter»(newVal);
		}
	'''

	def generateAssociation(ClAssociation association) '''
		/** Attribute for association labeled with «association.javadoc» */
		«javaType(association.type)» «association.identifier» = «createEmpty(association.type)»;
		
		@Override
		public «javaType(association.type)» «association.getter»() {
			return «association.identifier»;
		}
		
		@Override
		public void «association.setter»(«javaType(association.type)» newVal) {
			«association.identifier» = newVal;
		}
	'''
	
	def generateInheritedAssociation(
		ClInheritedAssociation association
	) '''
		@Override
		public «javaType(association.type)» «association.getter»() {
			return «association.parent.inherited».«association.getter»();
		}
		
		@Override
		public void «association.setter»(«javaType(association.type)» newVal) {
			«association.parent.inherited».«association.setter»(newVal);
		}
	'''

	def generateOperation(ClOperation operation) '''
		/** Method for operation «operation.javadoc» 
		 «javadocParams(operation.parameters)»
		 */
		«IF !operation.isStatic»@Override«ENDIF»
		public «IF operation.isStatic»static«ENDIF»
			«IF operation.returns»«javaType(operation.returnType)»«ELSE»void«ENDIF» «operation.identifier»(
				«FOR parameter : operation.parameters SEPARATOR ','»
					«javaType(parameter.type)» «parameter.identifier»
				«ENDFOR»
			) {
				«IF operation.hasBody»
					«IF operation.returnType != null»return«ENDIF»
						«operation.method.identifier».execute(
				«IF !operation.isStatic»this«IF operation.hasParameters»,«ENDIF»«ENDIF»
				«FOR parameter : operation.parameters SEPARATOR ','»
					«parameter.identifier»
				«ENDFOR»
				);
		«ENDIF»
		}
		
		«IF !operation.isStatic»
			/** Statically dispatched access to operation «operation.javadoc» 
			 «javadocParams(operation.parameters)»
			 */
			public static «IF operation.returns»«javaType(operation.returnType)»«ELSE»void«ENDIF» «operation.identifier»(
					«classDefinition.implementation» thisRef
					«FOR parameter : operation.parameters BEFORE ',' SEPARATOR ','»
						«javaType(parameter.type)» «parameter.identifier»
					«ENDFOR»
				) {
					«IF operation.hasBody»
						«IF operation.returnType != null»return«ENDIF»
							«operation.method.identifier».execute(
					«IF !operation.isStatic»thisRef«ENDIF»
					«FOR parameter : operation.parameters BEFORE ',' SEPARATOR ','»
						«parameter.identifier»
					«ENDFOR»
					);
			«ENDIF»
			}
		«ENDIF»
	'''
	
	def generateExternalReception(ClReception reception) '''
		/** Method for external reception «reception.javadoc» 
		 «javadocParams(reception.parameters)» 
		 */
		@Override
		public void «reception.identifier»_external(
			«FOR parameter : reception.parameters SEPARATOR ','»
				«javaType(parameter.type, parameter)» «parameter.identifier»
			«ENDFOR»
		) {
			«reception.signal.identifier» signal = new «reception.signal.identifier»(
				«FOR parameter : reception.parameters SEPARATOR ','»
					«parameter.identifier»
				«ENDFOR»
			);
			«runtime».addExternalEventToQueue(this, new «SignalEvent.canonicalName»(signal));
		}
	'''

	def returns(ClOperationSpec op) { op.returnType != null }

	def hasBody(ClOperation op) { op.method != null }

	def hasParameters(ClOperationSpec op) { !op.parameters.empty }
	
	def allAttributes(ClClass cls) { 
		val list = new LinkedList<ClAttributeSpec>
		list.addAll(cls.attributes)
		list.addAll(cls.inheritedAttributes)
		return list
	}
	
}
