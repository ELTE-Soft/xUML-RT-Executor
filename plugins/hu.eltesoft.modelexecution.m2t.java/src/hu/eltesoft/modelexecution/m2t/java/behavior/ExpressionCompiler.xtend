package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentOperator
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
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.profile.xumlrt.Stereotypes
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import org.apache.commons.lang.StringEscapeUtils
import org.eclipse.emf.common.util.EList
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.NamedElement
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.PrimitiveType
import org.eclipse.uml2.uml.Property
import org.eclipse.uml2.uml.Signal
import org.eclipse.uml2.uml.Type

class ExpressionCompiler extends CompilerBase {

	extension TypeConverter typeConverter = new TypeConverter
	extension JavaTypeConverter javaTypeConverter = new JavaTypeConverter

	// Needed to be defined here for testing purposes.
	def dispatch void compile(ExpressionStatement statement) {
		compile(statement.expression)
		append(";")
	}

	def dispatch void compile(BooleanLiteralExpression lit) {
		append(PrimitiveOperations.BOOLEAN_LITERAL)
		append("(")
		append(lit.value)
		append(")")
	}

	def dispatch void compile(NaturalLiteralExpression lit) {
		var String digits = lit.value.replace("_", "")
		var int radix = 10
		if (digits.startsWith("0x") || digits.startsWith("0X")) {
			digits = digits.substring(2)
			radix = 16
		} else if (digits.startsWith("0b") || digits.startsWith("0B")) {
			digits = digits.substring(2)
			radix = 2
		} else if (digits.startsWith("0") && "0" != digits) {
			digits = digits.substring(1)
			radix = 8
		}
		append(PrimitiveOperations.INTEGER_LITERAL)
		append('("')
		append(digits)
		append('", ')
		append(radix)
		append(")")
	}

	def dispatch void compile(RealLiteralExpression lit) {
		append(PrimitiveOperations.REAL_LITERAL)
		append("(")
		append(lit.value)
		append(")")
	}

	def dispatch void compile(StringLiteralExpression lit) {
		append(PrimitiveOperations.STRING_LITERAL)
		append('("')
		append(StringEscapeUtils.escapeJava(lit.value))
		append('")')
	}

	def dispatch void compile(NullExpression expr) {
		append(PrimitiveOperations.NULL_VALUE)
		append("()")
	}

	def dispatch void compile(ThisExpression expr) {
		append(PrimitiveOperations.WRAP)
		append("(")
		append(CONTEXT_NAME)
		append(")")
	}

	def dispatch void compile(LocalNameDeclarationStatement declaration) {
		val type = declaration.variable.type.type
		val localName = declaration.variable.localName
		append(type.convert.javaType(SINGLE))
		append(" ")
		append(localName)
		append(" = ")
		if (null != declaration.expression) {
			compile(declaration.expression)
		} else {
			compileTypeInitializer(declaration.variable.type.type)
		}
		append(";")
	}

	def dispatch compileTypeInitializer(PrimitiveType type) {
		switch type.name {
			case "Boolean": {
				append(PrimitiveOperations.BOOLEAN_LITERAL)
				append("(false)")
			}
			case "Integer": {
				append(PrimitiveOperations.INTEGER_LITERAL)
				append('("0", 10)')
			}
			case "Real": {
				append(PrimitiveOperations.REAL_LITERAL)
				append("(0.0)")
			}
			case "String": {
				append(PrimitiveOperations.STRING_LITERAL)
				append('("")')
			}
		}
	}

	def dispatch compileTypeInitializer(Type type) {
		append(PrimitiveOperations.NULL_VALUE)
		append("()")
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
				append(PrimitiveOperations.WRAP)
				append("(new ")
				append(NamedReference.getIdentifier(expr.instance))
				append("(")
				compile(expr.parameters, expr.instance as Signal)
				append("))")
			}
			Class: {
				append(PrimitiveOperations.WRAP)
				append("(")
				append(NamedReference.getIdentifier(expr.instance))
				append(".create(")
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
		append(PrimitiveOperations.UNWRAP)
		append("(")
		compile(expr.reference)
		append(").dispose()")
	}

	def dispatch void compile(FeatureInvocationExpression call) {
		append(PrimitiveOperations.UNWRAP)
		append("(")
		compile(call.context)
		append(").")
		switch call.feature {
			Operation: {
				append(NamedReference.getIdentifier(call.feature))
				append("(")
				compile(call.parameters, call.feature)
				append(")")
			}
			Property: {
				append(Template.GETTER_PREFIX)
				append(NamedReference.getIdentifier(call.feature))
				append("()")
			}
		}
	}

	def dispatch void compile(StaticFeatureInvocationExpression call) {
		val op = call.operation.reference as Operation
		var cls = op.class_
		if (Stereotypes.isExternalEntity(cls)) {
			append(RUNTIME_INSTANCE)
			append(".getExternalEntity(")
			append(cls.name)
			append(".class).")
			append(op.name)
			append("(")
			if (1 == op.ownedParameters.length) {
				// proxy parameter
				val param = op.ownedParameters.get(0)
				append("new ")
				append(param.type.name)
				append("(")
				append(CONTEXT_NAME)
				append(")")
			}
			append(")")
		} else {
			append(NamedReference.getIdentifier(cls))
			append(Template.CLASS_IMPL_SUFFIX)
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

	def dispatch compile(AssignmentExpression assignment) {
		if (AssignmentOperator.ASSIGN != assignment.operator) {
			throw new CompilationFailedException("Compound assignment operators are unsupported")
		}
		val lhs = assignment.leftHandSide
		switch lhs {
			// attribute assignment
			FeatureInvocationExpression: {
				append(PrimitiveOperations.UNWRAP)
				append("(")
				compile(lhs.context)
				append(").")
				append(Template.SETTER_PREFIX)
				append(NamedReference.getIdentifier(lhs.feature))
				append("(")
				compile(assignment.rightHandSide)
				append(")")
			}
			// local variable assignment
			NameExpression: {
				append(PrimitiveOperations.SET_VALUE)
				append("(")
				compile(lhs)
				append(", ")
				compile(assignment.rightHandSide)
				append(")")
			}
		}
	}
}
