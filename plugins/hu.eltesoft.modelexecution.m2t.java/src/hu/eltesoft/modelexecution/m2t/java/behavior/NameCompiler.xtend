package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NameExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable
import hu.eltesoft.modelexecution.m2t.java.JavaTypeConverter
import java.util.Map
import java.util.WeakHashMap

class NameCompiler extends LiteralCompiler {

	extension TypeConverter typeConverter = new TypeConverter
	extension JavaTypeConverter javaTypeConverter = new JavaTypeConverter

	int variableCounter = 0;
	Map<Variable, String> variableNames = new WeakHashMap<Variable, String>()

	def freshLocalName() {
		val newName = "_local" + variableCounter
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

	def dispatch void compile(LocalNameDeclarationStatement declaration) {
		val type = declaration.variable.type.type
		val localName = declaration.variable.localName
		append(type.convert.scalarType)
		append(" ")
		append(localName)
		append(";")
	}

	def dispatch void compile(NameExpression expr) {
		val ref = expr.reference
		switch ref {
			Variable: append(ref.localName)
			default: append(ref.name)
		}
	}
}
