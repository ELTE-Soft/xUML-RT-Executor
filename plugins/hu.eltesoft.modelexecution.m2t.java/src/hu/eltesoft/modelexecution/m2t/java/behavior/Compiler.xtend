package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.api.impl.ParsingResults
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BlockStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements
import hu.eltesoft.modelexecution.m2t.java.Languages
import hu.eltesoft.modelexecution.m2t.smap.xtend.SmapStringConcatenation
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import org.apache.commons.lang.StringUtils
import org.eclipse.emf.ecore.EObject

abstract class Compiler {

	public static val CONTEXT_NAME = "context"

	private var SmapStringConcatenation builder

	/**
	 * Compile the specified operation body code to Java source code. The output
	 * code will be returned along with its source mapping information.
	 */
	def SourceMappedText compile(ParsingResults results) {
		builder = new SmapStringConcatenation(Languages.RALF)
		if (results.validationOK) {
			compile(results.model)
		}
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
}
