package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.Block
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BlockStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BreakStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.EmptyStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.IfClause
import com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReturnStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import hu.eltesoft.modelexecution.runtime.base.SignalEvent

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

// TODO: missing statements: SwitchStatement, ForEachStatement, ClassifyStatement
class StatementCompiler extends ExpressionCompiler {

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
		for (i : 0 ..< statement.clauses.size) {
			val clause = statement.clauses.get(i)
			switch clause {
				IfClause: {
					if (i > 0) {
						node.add("else ")
					}
					node.add("if " <> paren(unwrap(compile(clause.condition))) <> " " <> compile(clause.body))
				}
				BlockStatement: {
					node.add("else " <> compile(clause))
				}
			}
		}
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
}
