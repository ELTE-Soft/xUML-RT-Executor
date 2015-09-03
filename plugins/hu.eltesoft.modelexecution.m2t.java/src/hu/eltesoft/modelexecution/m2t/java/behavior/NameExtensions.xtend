package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable
import java.util.WeakHashMap

class NameExtensions {

	var variableCounter = 0
	val variableNames = new WeakHashMap<Variable, String>()

	def freshLocalName() {
		val String newName = "_local" + variableCounter
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
