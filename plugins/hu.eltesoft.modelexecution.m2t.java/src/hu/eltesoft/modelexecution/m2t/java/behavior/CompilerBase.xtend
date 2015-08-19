package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.api.impl.ParsingResults
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BlockStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable
import hu.eltesoft.modelexecution.m2m.metamodel.base.BaseFactory
import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity
import hu.eltesoft.modelexecution.m2t.java.CompilationFailedException
import hu.eltesoft.modelexecution.m2t.java.Languages
import hu.eltesoft.modelexecution.m2t.smap.xtend.SmapStringConcatenation
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import java.util.Map
import java.util.WeakHashMap
import org.apache.commons.lang.StringUtils
import org.eclipse.emf.ecore.EObject

abstract class CompilerBase {

	public static val Multiplicity SINGLE = BaseFactory.eINSTANCE.createMultiplicity()
	public static val CONTEXT_NAME = "context"

	private var SmapStringConcatenation builder

	/**
	 * Compile the specified operation body code to Java source code. The output
	 * code will be returned along with its source mapping information.
	 */
	def SourceMappedText compile(ParsingResults results) {
		builder = new SmapStringConcatenation(Languages.RALF)
		if (!results.validationOK) {
			throw new CompilationFailedException(results.toString)
		}
		compile(results.model)
		return builder.toSourceMappedText
	}

	def void compile(Statements statements) {
		val breakLine = statements.statement.length > 1
		for (statement : statements.statement) {
			compile(statement)
			if (breakLine && !(statement instanceof BlockStatement)) {
				append("\n")
			}
		}
	}

	abstract protected def void compile(EObject node)

	protected var level = 0;

	protected def indent() {
		StringUtils.repeat("\t", level)
	}

	protected def append(Object object) {
		builder.append(object)
	}

	int variableCounter = 0;
	Map<Variable, String> variableNames = new WeakHashMap<Variable, String>()

	def freshLocalName() {
		val newName = "_local" + variableCounter
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
