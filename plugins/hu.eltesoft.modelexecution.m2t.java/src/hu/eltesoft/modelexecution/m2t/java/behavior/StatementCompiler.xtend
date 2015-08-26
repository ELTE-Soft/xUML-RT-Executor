package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.Block
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BlockStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BreakStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.EmptyStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.IfStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReturnStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement
import hu.eltesoft.modelexecution.runtime.base.SignalEvent
import com.incquerylabs.uml.ralf.reducedAlfLanguage.IfClause
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations

// TODO: missing statements: SwitchStatement, ForEachStatement ClassifyStatement
class StatementCompiler extends ExpressionCompiler {

	def dispatch void compile(EmptyStatement statement) {
		append(";")
	}

	def dispatch void compile(Block block) {
		compile(block, true)
	}

	def void compile(Block block, boolean breakAfter) {
		append("{\n")
		level += 1
		for (statement : block.statement) {
			compile(statement)
			if (! (statement instanceof BlockStatement)) {
				append("\n")
			}
		}
		level -= 1
		append("}")
		if (breakAfter) {
			append("\n")
		}
	}

	def dispatch void compile(ReturnStatement statement) {
		append("return")
		if (null != statement.expression) {
			append(" ")
			compile(statement.expression)
		}
		append(";")
	}

	def dispatch void compile(IfStatement statement) {
		for (i : 0 ..< statement.clauses.size) {
			val clause = statement.clauses.get(i)
			switch clause {
				IfClause: {
					if (i > 0) {
						append("else ")
					}
					append("if (")
					append(PrimitiveOperations.UNWRAP)
					append("(")
					compile(clause.condition)
					append(")) ")
					compile(clause.body)
				}
				BlockStatement: {
					append("else ")
					compile(clause)
				}
			}
		}
	}

	def dispatch void compile(WhileStatement loop) {
		append("while (")
		append(PrimitiveOperations.UNWRAP)
		append("(")
		compile(loop.condition)
		append(")) ")
		compile(loop.body)
	}

	def dispatch void compile(DoStatement loop) {
		append("do ")
		compile(loop.body as Block, false)
		append(" while (")
		append(PrimitiveOperations.UNWRAP)
		append("(")
		compile(loop.condition)
		append("));")
	}

	def dispatch void compile(ForStatement loop) {
		append("for (")
		// as initializer is a statement, it already has a closing semicolon
		compile(loop.initialization)
		append(" ")
		compile(loop.condition)
		append("; ")
		compile(loop.update)
		append(") ")
		compile(loop.body)
	}

	def dispatch void compile(BreakStatement statement) {
		append("break;")
	}

	def dispatch void compile(SendSignalStatement send) {
		append(PrimitiveOperations.UNWRAP)
		append("(")
		compile(send.target)
		append(").send(new ")
		append(SignalEvent.canonicalName)
		append("(")
		append(PrimitiveOperations.UNWRAP)
		append("(")
		compile(send.signal)
		append(")));")
	}
}
