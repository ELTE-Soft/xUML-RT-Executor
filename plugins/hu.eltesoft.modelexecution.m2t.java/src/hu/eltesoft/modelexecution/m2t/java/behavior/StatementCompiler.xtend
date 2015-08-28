package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.Block
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BlockStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BreakStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.EmptyStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.IfClause
import com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NaturalLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReturnStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.StringLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SwitchStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement
import hu.eltesoft.modelexecution.m2t.java.CompilationFailedException
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import hu.eltesoft.modelexecution.runtime.base.SignalEvent
import org.apache.commons.lang.StringEscapeUtils

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

// TODO: missing statements: ForEachStatement, ClassifyStatement
class StatementCompiler extends OperatorCompiler {

	static extension CodeGenNode = CodeGenNode.extension

	def dispatch CodeGenNode compile(EmptyStatement statement) {
		empty
	}

	def dispatch CodeGenNode compile(Block block) {
		val node = block()
		for (statement : block.statement) {
			node.add(compile(statement))
		}
		node
	}

	def dispatch CodeGenNode compile(ReturnStatement statement) {
		"return" <> if (null != statement.expression) {
			" " <> compile(statement.expression)
		} else {
			empty
		}
	}

	def dispatch CodeGenNode compile(IfStatement statement) {
		val node = empty
		statement.clauses.forEach [
			switch it {
				IfClause: {
					if (statement.clauses.indexOf(it) > 0) {
						node.add("else ")
					}
					node.add("if " <> paren(unwrap(compile(condition))) <> " " <> compile(body))
				}
				BlockStatement: {
					node.add("else " <> compile(it))
				}
			}
		]
		node
	}

	def dispatch CodeGenNode compile(WhileStatement loop) {
		"while " <> paren(unwrap(compile(loop.condition))) <> " " <> compile(loop.body)
	}

	def dispatch CodeGenNode compile(DoStatement loop) {
		"do " <> compile(loop.body) <> "while " <> paren(unwrap(compile(loop.condition)))
	}

	def dispatch CodeGenNode compile(ForStatement loop) {
		val params = new CodeGenNode("(", ")", "; ")
		params.add(compile(loop.initialization))
		params.add(compile(loop.condition))
		params.add(compile(loop.update))
		"for " <> params <> " " <> compile(loop.body)
	}

	def dispatch CodeGenNode compile(BreakStatement statement) {
		sequence("break")
	}

	def dispatch CodeGenNode compile(SendSignalStatement send) {
		unwrap(compile(send.target)) ->
			fun("send", "new " <> fun(SignalEvent.canonicalName, unwrap(compile(send.signal))))
	}

	def dispatch CodeGenNode compile(SwitchStatement statement) {
		val clauses = block()
		statement.nonDefaultClause.forEach [
			val cases = empty
			^case.forEach [
				cases.add("case " <> compileCaseExpression(it) <> ": ")
			]
			cases.add(compile(block))
			clauses.add(cases)
		]
		if (null != statement.defaultClause) {
			clauses.add("default: " <> compile(statement.defaultClause))
		}
		"switch " <> paren(compileSwitchBase(statement.expression)) <> " " <> clauses
	}

	def compileSwitchBase(Expression expr) {
		val node = unwrap(compile(expr))
		if (expr.isInteger) {
			// extract a long value from the BigInteger
			return node -> fun("longValue")
		}
		node
	}

	def dispatch CodeGenNode compileCaseExpression(NaturalLiteralExpression lit) {
		sequence(lit.value)
	}

	def dispatch CodeGenNode compileCaseExpression(StringLiteralExpression lit) {
		str(StringEscapeUtils.escapeJava(lit.value))
	}

	def dispatch CodeGenNode compileCaseExpression(Expression expr) {
		throw new CompilationFailedException("Only string and integer literals are supported in case expressions")
	}
}
