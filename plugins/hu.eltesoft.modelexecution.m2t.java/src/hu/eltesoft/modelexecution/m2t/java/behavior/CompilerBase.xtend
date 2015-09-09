package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.api.impl.ParsingResults
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements
import hu.eltesoft.modelexecution.m2m.metamodel.base.BaseFactory
import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity
import hu.eltesoft.modelexecution.m2t.java.JavaTypeConverter
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import hu.eltesoft.modelexecution.runtime.BaseRuntime
import org.eclipse.emf.ecore.EObject

abstract class CompilerBase {

	public static val Multiplicity SINGLE = BaseFactory.eINSTANCE.createMultiplicity()

	public static val CONTEXT_NAME = "context"
	public static val RUNTIME_INSTANCE = BaseRuntime.canonicalName + ".getInstance()"

	protected extension CodeGenNode = CodeGenNode.EXTENSION
	protected extension NameExtensions = new NameExtensions
	protected extension TypeConverter = new TypeConverter
	protected extension JavaTypeConverter = new JavaTypeConverter
	protected extension TypeSystemExtensions typeExtensions

	/**
	 * Compile the specified operation body code to Java source code.
	 */
	def CodeGenNode compile(ParsingResults results) {
		typeExtensions = new TypeSystemExtensions(results.typeSystem, results.model)
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
}
