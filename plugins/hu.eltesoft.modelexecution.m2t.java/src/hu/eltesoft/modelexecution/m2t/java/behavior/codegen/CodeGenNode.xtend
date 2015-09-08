package hu.eltesoft.modelexecution.m2t.java.behavior.codegen

import hu.eltesoft.modelexecution.m2t.java.Languages
import hu.eltesoft.modelexecution.m2t.smap.xtend.SmapStringConcatenation
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import java.util.ArrayList
import java.util.List
import java.util.function.Function

/** Represents a node sequence without any separator or boundary markers. Abstracts string concatenation. */
package class Sequence extends CodeGenNode {
}

/** Dot separated sequence, like "a.b.c.d". */
package class DotSeparatedSequence extends CodeGenNode {

	new() {
		super("", "", ".")
	}
}

/** Encapsulates items into a parenthesized tuple, like "(a, b, c, d)". */
package class ParenthesizedTuple extends CodeGenNode {

	new() {
		super("(", ")", ", ")
	}
}

/** Sequence encapsulated within double quotes. */
package class StringWrapper extends CodeGenNode {

	new() {
		super('"', '"')
	}
}

/** Code block with opening and closing curly braces. Each item is terminated by a semicolon. */
package class StatementBlock extends CodeGenNode {

	new() {
		super("{\n", "}\n", "", ";\n")
	}
}

/** Code block without curly braces. Each item is terminated by a semicolon. */
package class TopLevelStatementBlock extends CodeGenNode {

	new() {
		super("", "", "", ";\n")
	}
}

/**
 * Helps code generation and testing by providing a tree-like abstraction. Each node contains four predefined objects,
 * and a list of child items. The four predefined items are used when a node is converted to its string representation:
 * <p><dl>
 * <dt>before</dt><dd>prepended before the text of child items, even there are no children</dd> 
 * <dt>after</dt><dd>appended after the text of child items, even there are no children</dd>
 * <dt>separator</dt><dd>emitted between the text of two child items</dd> 
 * <dt>terminator</dt><dd>emitted after each child item, before the separator between them</dd> 
 * </dl><p>
 * This class is able to generate a source mapped text. When a child item with type DataWithLocation<?> is added,
 * its location information will be traced into the generated source mapping.
 */
class CodeGenNode {

	public static val EXTENSION = new CodeGenNode();

	protected val Object before
	protected val Object after
	protected val Object separator
	protected val Object terminator
	protected var List<Object> items = new ArrayList

	def empty() {
		sequence
	}

	def sequence(Object ... items) {
		new Sequence().add(items)
	}

	def dot(Object ... items) {
		new DotSeparatedSequence().add(items)
	}

	def paren(Object ... items) {
		new ParenthesizedTuple().add(items)
	}

	def str(Object ... items) {
		new StringWrapper().add(items)
	}

	def block(Object ... items) {
		new StatementBlock().add(items)
	}

	def topLevelBlock(Object ... items) {
		new TopLevelStatementBlock().add(items)
	}

	def isSequence(CodeGenNode node) {
		node instanceof Sequence
	}

	def isDot(CodeGenNode node) {
		node instanceof DotSeparatedSequence
	}

	def isParen(CodeGenNode node) {
		node instanceof ParenthesizedTuple
	}

	def isBlock(CodeGenNode node) {
		node instanceof StatementBlock || node instanceof TopLevelStatementBlock
	}

	new() {
		this("", "")
	}

	new(Object before, Object after) {
		this(before, after, "")
	}

	new(Object before, Object after, Object separator) {
		this(before, after, separator, "")
	}

	new(Object before, Object after, Object separator, Object terminator) {
		this.before = before
		this.after = after
		this.separator = separator
		this.terminator = terminator
	}

	def add(Object ... newItems) {
		items.addAll(newItems)
		this
	}

	def map(Function<Object, Object> transformation) {
		items = items.map(transformation)
	}

	protected def getSize() {
		items.length
	}

	protected def itemAt(int i) {
		items.get(i)
	}

	protected def childNodeAt(int i) {
		items.get(i) as CodeGenNode
	}

	def SourceMappedText toSourceMappedText() {
		val builder = new SmapStringConcatenation(Languages.RALF)
		builder.append(before)
		val itemCount = items.length
		for (i : 0 ..< itemCount) {
			val item = items.get(i)
			// fill the indentation parameter to call the dynamically dispatched append
			// it enabled to add location information when the item is a DataWithLocation<?>
			builder.append(item, "")
			if (!isBlock || !(item instanceof CodeGenNode) || !(item as CodeGenNode).endsWithBlock) {
				builder.append(terminator)
			}
			if (i < itemCount - 1) {
				builder.append(separator)
			}
		}
		builder.append(after)
		builder.toSourceMappedText
	}

	def boolean endsWithBlock() {
		if (isBlock) {
			return true
		}
		if (items.empty) {
			return false
		}
		val last = items.last
		switch last {
			CodeGenNode: last.isBlock || last.endsWithBlock
			default: false
		}
	}

	override toString() {
		toSourceMappedText.toString
	}

	def dispatch CodeGenNode <>(Object lhs, Object rhs) {
		sequence(lhs, rhs)
	}

	def dispatch CodeGenNode <>(CodeGenNode lhs, Object rhs) {
		if (lhs.isSequence) {
			// flatten sequence
			return lhs.add(rhs)
		}
		sequence(lhs, rhs)
	}

	def dispatch CodeGenNode <>(Object lhs, CodeGenNode rhs) {
		if (rhs.isSequence) {
			// flatten sequence
			rhs.items.add(0, lhs)
			return rhs
		}
		sequence(lhs, rhs)
	}

	def dispatch CodeGenNode ->(Object lhs, Object rhs) {
		return dot.add(lhs, rhs)
	}

	def dispatch CodeGenNode ->(CodeGenNode lhs, Object rhs) {
		if (lhs.isDot) {
			// flatten dots
			return lhs.add(rhs)
		}
		dot(lhs, rhs)
	}

	def dispatch CodeGenNode ->(Object lhs, CodeGenNode rhs) {
		if (rhs.isDot) {
			// flatten dots
			rhs.items.add(0, lhs)
			return rhs
		}
		dot(lhs, rhs)
	}
}
