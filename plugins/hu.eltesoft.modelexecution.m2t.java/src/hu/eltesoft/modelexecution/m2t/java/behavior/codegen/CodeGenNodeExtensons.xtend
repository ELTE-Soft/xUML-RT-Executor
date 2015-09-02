package hu.eltesoft.modelexecution.m2t.java.behavior.codegen

import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations

/**
 * Shortcut functions to several frequent CodeGenNode constructions.
 */
class CodeGenNodeExtensons {

	static extension CodeGenNode = CodeGenNode.EXTENSION

	/**
	 * Generate a function call from the callee name and its parameters.
	 */
	def static CodeGenNode fun(Object name, Object ... params) {
		name <> paren(params)
	}

	/**
	 * Constructs infix binary operator application from its operands and operator.
	 */
	def static binOp(Object lhs, Object operator, Object rhs) {
		lhs <> " " <> operator <> " " <> rhs
	}

	/**
	 * Apply wrap primitive operation to a single item.
	 */
	def static dispatch CodeGenNode wrap(Object item) {
		wrap(sequence(item))
	}

	/**
	 * Apply wrap primitive operation to a CodeGenNode. Nested wrap-unwrap pairs will be automatically simplified.
	 */
	def static dispatch CodeGenNode wrap(CodeGenNode node) {
		if (node.isUnwrap) {
			return node.extractInner
		}
		CodeGenNodeExtensons.fun(PrimitiveOperations.WRAP, node)
	}

	/**
	 * Apply unwrap primitive operation to a single item.
	 */
	def static dispatch CodeGenNode unwrap(Object item) {
		unwrap(sequence(item))
	}

	/**
	 * Apply uwrap primitive operation to a CodeGenNode. Nested unwrap-wrap pairs will be automatically simplified.
	 */
	def static dispatch CodeGenNode unwrap(CodeGenNode node) {
		if (node.isWrap) {
			return node.extractInner
		}
		CodeGenNodeExtensons.fun(PrimitiveOperations.UNWRAP, node)
	}

	/**
	 * Detects whether the given node is constructed by wrap.
	 */
	def static isWrap(CodeGenNode node) {
		node.isSequence && 2 == node.size && PrimitiveOperations.WRAP == node.itemAt(0) &&
			node.itemAt(1) instanceof CodeGenNode && node.childNodeAt(1).isParen
	}

	/**
	 * Detects whether the given node is constructed by unwrap.
	 */
	def static isUnwrap(CodeGenNode node) {
		node.isSequence && 2 == node.size && PrimitiveOperations.UNWRAP == node.itemAt(0) &&
			node.itemAt(1) instanceof CodeGenNode && node.childNodeAt(1).isParen
	}

	/**
	 * Extracts the inner expression of wrap or unwrap.
	 */
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
