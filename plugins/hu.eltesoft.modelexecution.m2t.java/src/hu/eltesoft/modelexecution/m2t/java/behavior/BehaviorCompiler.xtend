package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import org.eclipse.emf.ecore.EObject

class BehaviorCompiler extends StatementCompiler {

	def dispatch CodeGenNode compile(EObject node) {
		throw new UnsupportedRalfFeature("Unsupported rALF feature `" + node.class.simpleName + "`.");
	}
}
