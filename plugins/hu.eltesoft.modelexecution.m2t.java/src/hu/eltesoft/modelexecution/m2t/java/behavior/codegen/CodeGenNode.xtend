package hu.eltesoft.modelexecution.m2t.java.behavior.codegen

import hu.eltesoft.modelexecution.m2t.java.Languages
import hu.eltesoft.modelexecution.m2t.smap.xtend.SmapStringConcatenation
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import java.util.ArrayList
import java.util.List

class CodeGenNode {

	protected val Object before
	protected val Object after
	protected val Object separator
	protected val Object terminator
	protected val List<Object> items = new ArrayList

	def static getExtension() {
		new CodeGenNode()
	}

	def empty() {
		sequence
	}

	def sequence(Object ... items) {
		new CodeGenNode().add(items)
	}

	def str(Object ...items) {
		new CodeGenNode('"', '"').add(items)
	}

	def paren(Object ... items) {
		new CodeGenNode("(", ")", ", ").add(items)
	}

	def block(Object ... items) {
		new CodeGenNode("{\n", "}\n", "", ";\n").add(items)
	}

	def topLevelBlock(Object ... items) {
		new CodeGenNode("", "", "", ";\n").add(items)
	}

	def dot(Object ... items) {
		new CodeGenNode("", "", ".").add(items)
	}

	def isSequence(CodeGenNode node) {
		node.before.toString.empty && node.after.toString.empty && node.separator.toString.empty &&
			node.terminator.toString.empty
	}

	def isParen(CodeGenNode node) {
		"(" == node.before.toString && ")" == node.after.toString && ", " == node.separator.toString &&
			node.terminator.toString.empty
	}

	def isBlock(CodeGenNode node) {
		node.separator.toString.empty && ";\n" == node.terminator.toString
	}

	def isDot(CodeGenNode node) {
		node.before.toString.empty && node.after.toString.empty && "." == node.separator.toString &&
			node.terminator.toString.empty
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
