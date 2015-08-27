package hu.eltesoft.modelexecution.m2t.java.behavior.codegen

import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations

class CodeGenNodeExtensons {

	static extension CodeGenNode = CodeGenNode.extension

	def static CodeGenNode fun(Object name, Object ... params) {
		name <> paren(params)
	}

	def static binOp(Object lhs, Object operator, Object rhs) {
		lhs <> " " <> operator <> " " <> rhs
	}

	def static dispatch CodeGenNode wrap(Object item) {
		wrap(sequence(item))
	}

	def static dispatch CodeGenNode wrap(CodeGenNode node) {
		if (node.isUnwrap) {
			return node.extractInner
		}
		CodeGenNodeExtensons.fun(PrimitiveOperations.WRAP, node)
	}

	def static dispatch CodeGenNode unwrap(Object item) {
		unwrap(sequence(item))
	}

	def static dispatch CodeGenNode unwrap(CodeGenNode node) {
		if (node.isWrap) {
			return node.extractInner
		}
		CodeGenNodeExtensons.fun(PrimitiveOperations.UNWRAP, node)
	}

	def static isWrap(CodeGenNode node) {
		node.isSequence && 2 == node.size && PrimitiveOperations.WRAP == node.itemAt(0) &&
			node.itemAt(1) instanceof CodeGenNode && node.childNodeAt(1).isParen
	}

	def static isUnwrap(CodeGenNode node) {
		node.isSequence && 2 == node.size && PrimitiveOperations.UNWRAP == node.itemAt(0) &&
			node.itemAt(1) instanceof CodeGenNode && node.childNodeAt(1).isParen
	}

	def static extractInner(CodeGenNode node) {
		val paren = node.childNodeAt(1)
		paren.childNodeAt(0)
	}

	def static booleanLiteral(String value) {
		CodeGenNodeExtensons.fun(PrimitiveOperations.BOOLEAN_LITERAL, value)
	}

	def static integerLiteral(String digits, int radix) {
		CodeGenNodeExtensons.fun(PrimitiveOperations.INTEGER_LITERAL, str(digits), radix)
	}

	def static realLiteral(String value) {
		CodeGenNodeExtensons.fun(PrimitiveOperations.REAL_LITERAL, value)
	}

	def static stringLiteral(String value) {
		CodeGenNodeExtensons.fun(PrimitiveOperations.STRING_LITERAL, str(value))
	}
}
