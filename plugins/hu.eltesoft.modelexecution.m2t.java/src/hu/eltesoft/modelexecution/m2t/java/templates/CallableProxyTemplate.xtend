package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.base.Named
import hu.eltesoft.modelexecution.m2m.metamodel.callable.CaCallable
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

@SourceMappedTemplate(stratumName=XUML_RT)
class CallableProxyTemplate extends Template {

	val CaCallable callable

	new(CaCallable callable) {
		super(callable)
		this.callable = callable
	}

	override generate() '''
		«generatedHeaderForClass(callable)»
		public class «callable.originalName» {
		
			private final «callable.identifier» instance;
		
			public «callable.originalName»(«callable.identifier» instance) {
				this.instance = instance;
			}
		«FOR reception : callable.receptions»
			
				public void «reception.originalName»() {
					instance.«reception.identifier»_external();
				}
		«ENDFOR»
		}
	'''

	def originalName(Named named) {
		named.reference.originalName
	}
}
