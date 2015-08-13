package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceDeletionExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NameExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NameLeftHandSide
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedTuple
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NaturalLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NullExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.StaticFeatureInvocationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.StringLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ThisExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2t.java.CompilationFailedException
import hu.eltesoft.modelexecution.m2t.java.JavaTypeConverter
import java.math.BigInteger
import java.util.Map
import java.util.WeakHashMap
import org.apache.commons.lang.StringEscapeUtils
import org.eclipse.emf.common.util.EList
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.NamedElement
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.PrimitiveType
import org.eclipse.uml2.uml.Signal
import org.eclipse.uml2.uml.Type
import hu.eltesoft.modelexecution.profile.xumlrt.Stereotypes

class ExpressionCompiler extends Compiler {

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

	// this is required to be defined here, as it makes unit testing of this class possible
	def dispatch void compile(ExpressionStatement statement) {
		compile(statement.expression)
		append(";")
	}

	def dispatch void compile(LiteralExpression lit) {
		append(lit.value)
	}

	def dispatch void compile(NaturalLiteralExpression lit) {
		append(BigInteger.canonicalName)
		append(".valueOf(")
		append(lit.value)
		append(")")
	}

	def dispatch void compile(StringLiteralExpression lit) {
		append('''"«StringEscapeUtils.escapeJava(lit.value)»"''')
	}

	def dispatch void compile(NullExpression expr) {
		append("null")
	}

	def dispatch void compile(ThisExpression expr) {
		append(Compiler.CONTEXT_NAME)
	}

	def dispatch void compile(LocalNameDeclarationStatement declaration) {
		val type = declaration.variable.type.type
		val localName = declaration.variable.localName
		append(type.convert.scalarType)
		append(" ")
		append(localName)
		if (null != declaration.expression) {
			append(" = ")
			compile(declaration.expression)
		} else {
			append(declaration.variable.type.type.typeInitializer)
		}
		append(";")
	}

	def dispatch typeInitializer(Type type) {
		"" // only primitive types are needed to be initialized
	}

	def dispatch typeInitializer(PrimitiveType type) {
		switch type.name {
			case "Boolean": ''' = false'''
			case "Integer": ''' = «BigInteger.canonicalName».valueOf(0)'''
			case "Real": ''' = 0.0'''
			case "String": ''' = ""'''
		}
	}

	def dispatch void compile(NameExpression expr) {
		val ref = expr.reference
		switch ref {
			Variable: append(ref.localName)
			default: append(NamedReference.getIdentifier(ref))
		}
	}

	def dispatch void compile(NameLeftHandSide lhs) {
		// TODO: handle lhs.index?
		compile(lhs.expression)
	}

	def dispatch void compile(InstanceCreationExpression expr) {
		switch expr.instance {
			// TODO: add data types later
			Signal: {
				append("new ")
				append(NamedReference.getIdentifier(expr.instance))
				append("(")
				compile(expr.tuple, expr.instance as Signal)
				append(")")
			}
			Class: {
				append(NamedReference.getIdentifier(expr.instance))
				append(".create(context.getRuntime()")
				val constructor = getConstructor(expr.instance as Class)
				if (null != constructor && !constructor.ownedParameters.empty) {
					append(", ")
					compile(expr.tuple, constructor)
				}
				append(")")
			}
		}
	}

	def dispatch compile(ExpressionList values, Signal signal) {
		if (!values.expressions.empty) {
			throw new CompilationFailedException("Only by-name parameter passing is supported")
		}
	}

	def dispatch compile(NamedTuple values, Signal signal) {
		compileExpressionList(values, signal.ownedAttributes)
	}

	def Operation getConstructor(Class cl) {
		for (operation : cl.ownedOperations) {
			if (operation.name == cl.name) {
				return operation
			}
		}
	}

	def dispatch void compile(InstanceDeletionExpression expr) {
		compile(expr.reference)
		append(".dispose()")
	}

	def dispatch void compile(FeatureInvocationExpression call) {
		compile(call.context)
		append(".")
		append(NamedReference.getIdentifier(call.operation))
		append("(")
		compile(call.parameters, call.operation)
		append(")")
	}

	def dispatch void compile(StaticFeatureInvocationExpression call) {
		val op = call.operation
		var cls = op.class_
		if (Stereotypes.isExternalEntity(cls)) {
			append(CONTEXT_NAME)
			append(".getRuntime().getExternalEntity(")
			append(cls.name)
			append(".class).")
			append(op.name)
			append("(")
			if (1 == op.ownedParameters.length) {
				// proxy parameter
				append("new ")
				append(op.ownedParameters.get(0).type.name)
				append("(")
				append(CONTEXT_NAME)
				append(")")
			}
			append(")")
		} else {
			append(NamedReference.getIdentifier(cls))
			append(".")
			append(NamedReference.getIdentifier(op))
			append("(")
			compile(call.parameters, op)
			append(")")
		}
	}

	def dispatch compile(ExpressionList values, Operation operation) {
		if (!values.expressions.empty) {
			throw new CompilationFailedException("Only by-name parameter passing is supported")
		}
	}

	def dispatch compile(NamedTuple values, Operation operation) {
		compileExpressionList(values, operation.ownedParameters)
	}

	def void compileExpressionList(NamedTuple values, EList<? extends NamedElement> qualifiers) {
		val upper = qualifiers.length
		for (i : 0 ..< upper) {
			val parameter = qualifiers.get(i)
			val value = getExpressionByName(values, parameter.name)
			if (null == value) {
				throw new CompilationFailedException("Unable to match named parameter")
			}
			compile(value)
			if (i < upper - 1) {
				append(", ")
			}
		}
	}

	def Expression getExpressionByName(NamedTuple values, String name) {
		for (value : values.expressions) {
			if (value.name == name) {
				return value.expression
			}
		}
	}
}
