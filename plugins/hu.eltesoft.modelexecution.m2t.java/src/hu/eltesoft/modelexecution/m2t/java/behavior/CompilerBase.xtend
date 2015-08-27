package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.api.impl.ParsingResults
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable
import hu.eltesoft.modelexecution.m2m.metamodel.base.BaseFactory
import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity
import hu.eltesoft.modelexecution.m2t.java.CompilationFailedException
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import hu.eltesoft.modelexecution.runtime.BaseRuntime
import java.util.WeakHashMap
import org.eclipse.emf.ecore.EObject

abstract class CompilerBase {

	static extension CodeGenNode = CodeGenNode.extension

	public static val Multiplicity SINGLE = BaseFactory.eINSTANCE.createMultiplicity()

	public static val CONTEXT_NAME = "context"
	public static val RUNTIME_INSTANCE = BaseRuntime.canonicalName + ".getInstance()"

	/**
	 * Compile the specified operation body code to Java source code.
	 */
	def CodeGenNode compile(ParsingResults results) {
		if (!results.validationOK) {
			throw new CompilationFailedException(results.toString)
		}
		compile(results.model)
	}

	protected def CodeGenNode compile(Statements statements) {
		var node = topLevelBlock()
		for (statement : statements.statement) {
			node.add(compile(statement))
		}
		node
	}

	abstract protected def CodeGenNode compile(EObject node)

	var variableCounter = 0
	val variableNames = new WeakHashMap<Variable, String>()

	def freshLocalName() {
		val String newName = "_local" + variableCounter
		variableCounter += 1
		newName
	}

	def localName(Variable variable) {
		var name = variableNames.get(variable);
		if (null == name) {
			name = freshLocalName
			variableNames.put(variable, name)
		}
		name
	}
}
