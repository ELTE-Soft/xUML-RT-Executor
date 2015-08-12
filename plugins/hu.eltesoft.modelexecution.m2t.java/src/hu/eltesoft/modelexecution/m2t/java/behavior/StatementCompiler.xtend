package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.Block
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BlockStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BreakStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.DoStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.EmptyStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ForStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ReturnStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.WhileStatement

class StatementCompiler extends NameCompiler {

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

	def dispatch void compile(WhileStatement loop) {
		append("while (")
		compile(loop.condition)
		append(")\n")
		compile(loop.body)
	}

	def dispatch void compile(DoStatement loop) {
		append("do\n")
		compile(loop.body, false)
		append(" while (")
		compile(loop.condition)
		append(");")
	}

	def dispatch void compile(ForStatement loop) {
		append("for (")
		// as initializer is a statement, it already has a closing semicolon
		compile(loop.initialization)
		append(" ")
		compile(loop.condition)
		append("; ")
		compile(loop.update)
		append(")\n")
		compile(loop.body)
	}

	def dispatch void compile(BreakStatement statement) {
		append("break;")
	}
/*
 * IfStatement |
 *     SwitchStatement |
 *     ForEachStatement |
 *     ClassifyStatement |
 *     SendSignalStatement 
 */
}
