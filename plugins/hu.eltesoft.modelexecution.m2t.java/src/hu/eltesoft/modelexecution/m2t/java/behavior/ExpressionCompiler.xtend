package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceDeletionExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NameExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedTuple
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NaturalLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NullExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.RealLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.StaticFeatureInvocationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.StringLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ThisExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2t.java.CompilationFailedException
import hu.eltesoft.modelexecution.m2t.java.JavaTypeConverter
import hu.eltesoft.modelexecution.profile.xumlrt.Stereotypes
import org.apache.commons.lang.StringEscapeUtils
import org.eclipse.emf.common.util.EList
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.NamedElement
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.PrimitiveType
import org.eclipse.uml2.uml.Signal
import org.eclipse.uml2.uml.Type

class ExpressionCompiler extends CompilerBase {

	extension TypeConverter typeConverter = new TypeConverter
	extension JavaTypeConverter javaTypeConverter = new JavaTypeConverter

	// this is required to be defined here, as it makes unit testing of this class possible
	// FIXME: do not define it here, move it to stmt compiler and inherit a class for tests?
	def dispatch void compile(ExpressionStatement statement) {
		compile(statement.expression)
		append(";")
	}

	def dispatch void compile(BooleanLiteralExpression lit) {
		append('''booleanLiteral(«lit.value»)''')
	}

	def dispatch void compile(NaturalLiteralExpression lit) {
		var String digits = lit.value.replace("_", "")
		var int radix = 10
		if (digits.startsWith("0x")) {
			digits = digits.substring(2)
			radix = 16
		} else if (digits.startsWith("0b") || digits.startsWith("0B")) {
			digits = digits.substring(2)
			radix = 2
		} else if (digits.startsWith("0") && "0" != digits) {
			digits = digits.substring(1)
			radix = 8
		}
		append('''integerLiteral("«digits»", «radix»)''')
	}

	def dispatch void compile(RealLiteralExpression lit) {
		append('''realLiteral(«lit.value»)''')
	}

	def dispatch void compile(StringLiteralExpression lit) {
		append('''stringLiteral("«StringEscapeUtils.escapeJava(lit.value)»")''')
	}

	def dispatch void compile(NullExpression expr) {
		append("wrap(null)")
	}

	def dispatch void compile(ThisExpression expr) {
		append('''wrap(«CompilerBase.CONTEXT_NAME»)''')
	}

	def dispatch void compile(LocalNameDeclarationStatement declaration) {
		val type = declaration.variable.type.type
		val localName = declaration.variable.localName
		append(type.convert.javaType(SINGLE))
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
		"" // only primitive types are needed to be automatically initialized
		// TODO: is this true? do we need an empty wrapper for reference types?
		// depends on the implementation of assignment!
	}

	def dispatch typeInitializer(PrimitiveType type) {
		switch type.name {
			case "Boolean": ''' = booleanLiteral(false)'''
			case "Integer": ''' = integerLiteral("0", 10)'''
			case "Real": ''' = realLiteral(0.0)'''
			case "String": ''' = stringLiteral("")'''
		}
	}

	def dispatch void compile(NameExpression expr) {
		val ref = expr.reference
		switch ref {
			Variable: append(ref.localName)
			default: append(NamedReference.getIdentifier(ref))
		}
	}

	def dispatch void compile(InstanceCreationExpression expr) {
		switch expr.instance {
			// TODO: add data types later
			Signal: {
				append("wrap(new ")
				append(NamedReference.getIdentifier(expr.instance))
				append("(")
				compile(expr.parameters, expr.instance as Signal)
				append("))")
			}
			Class: {
				append("wrap(")
				append(NamedReference.getIdentifier(expr.instance))
				append(".create(context.getRuntime(), ")
				val constructor = getConstructor(expr.instance as Class)
				if (null == constructor) {
					append("null")
				} else {
					append("i -> i.")
					append(NamedReference.getIdentifier(constructor))
					append("(")
					compile(expr.parameters, constructor)
					append(")")
				}
				append("))")
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
		append("unwrap(")
		compile(expr.reference)
		append(").dispose()")
	}

	def dispatch void compile(FeatureInvocationExpression call) {
		append("unwrap(")
		compile(call.context)
		append(").")
		append(NamedReference.getIdentifier(call.feature))
		append("(")
		compile(call.parameters, call.feature)
		append(")")
	}

	def dispatch void compile(StaticFeatureInvocationExpression call) {
		val op = call.operation.reference as Operation
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
				append(CONTEXT_NAME)
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
