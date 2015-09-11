package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceDeletionExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperation
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LinkOperationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LocalNameDeclarationStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NameExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NamedTuple
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NaturalLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NullExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.RealLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SignalDataExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.StaticFeatureInvocationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.StringLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ThisExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Variable
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2t.java.CompilationFailedException
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import hu.eltesoft.modelexecution.profile.xumlrt.Stereotypes
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import org.apache.commons.lang.StringEscapeUtils
import org.eclipse.emf.common.util.EList
import org.eclipse.uml2.uml.Association
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.NamedElement
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.PrimitiveType
import org.eclipse.uml2.uml.Property
import org.eclipse.uml2.uml.Signal
import org.eclipse.uml2.uml.Type

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class ExpressionCompiler extends CompilerBase {

	// Needed to be defined here for testing purposes.
	def dispatch CodeGenNode compile(ExpressionStatement statement) {
		compile(statement.expression)
	}

	def dispatch CodeGenNode compile(BooleanLiteralExpression lit) {
		booleanLiteral(lit.value)
	}

	def dispatch CodeGenNode compile(NaturalLiteralExpression lit) {
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
		integerLiteral(digits, radix)
	}

	def dispatch CodeGenNode compile(RealLiteralExpression lit) {
		realLiteral(lit.value)
	}

	def dispatch CodeGenNode compile(StringLiteralExpression lit) {
		stringLiteral(StringEscapeUtils.escapeJava(lit.value))
	}

	def dispatch CodeGenNode compile(NullExpression expr) {
		fun(PrimitiveOperations.NULL_VALUE)
	}

	def dispatch CodeGenNode compile(ThisExpression expr) {
		wrap(CONTEXT_NAME)
	}

	def dispatch CodeGenNode compile(LocalNameDeclarationStatement declaration) {
		val type = declaration.variable.type.type.convert.javaType(SINGLE)
		val localName = declaration.variable.localName
		val rhs = if (null != declaration.expression) {
				compile(declaration.expression)
			} else {
				compileTypeInitializer(declaration.variable.type.type)
			}
		binOp(type <> " " <> localName, "=", rhs)
	}

	def dispatch CodeGenNode compileTypeInitializer(PrimitiveType type) {
		switch type.name {
			case "Boolean": booleanLiteral("false")
			case "Integer": integerLiteral("0", 10)
			case "Real": realLiteral("0.0")
			case "String": stringLiteral("")
		}
	}

	def dispatch CodeGenNode compileTypeInitializer(Type type) {
		fun(PrimitiveOperations.NULL_VALUE)
	}

	def dispatch CodeGenNode compile(NameExpression expr) {
		val ref = expr.reference
		switch ref {
			Variable: sequence(ref.localName)
			default: sequence(NamedReference.getIdentifier(ref))
		}
	}

	def dispatch CodeGenNode compile(InstanceCreationExpression expr) {
		switch expr.instance {
			// TODO: add data types later
			Signal: {
				wrap("new " <>
					(NamedReference.getIdentifier(expr.instance) <> compile(expr.parameters, expr.instance as Signal)))
			}
			Class: {
				var param = sequence("null")
				val constructor = getConstructor(expr.instance as Class)
				if (null != constructor) {
					param = "i -> i" ->
						(NamedReference.getIdentifier(constructor) <> compile(expr.parameters, constructor))
				}
				wrap(NamedReference.getIdentifier(expr.instance) -> fun("create", param))
			}
		}
	}

	def dispatch CodeGenNode compile(ExpressionList values, Signal signal) {
		if (!values.expressions.empty) {
			throw new CompilationFailedException("Only by-name parameter passing is supported")
		}
		paren()
	}

	def dispatch CodeGenNode compile(NamedTuple values, Signal signal) {
		compileExpressionList(values, signal.ownedAttributes)
	}

	def Operation getConstructor(Class cl) {
		for (operation : cl.ownedOperations) {
			if (operation.name == cl.name) {
				return operation
			}
		}
	}

	def dispatch CodeGenNode compile(InstanceDeletionExpression expr) {
		val className = NamedReference.getIdentifier(expr.reference.typeOf)
		className -> fun("delete", paren(className <> Template.CLASS_IMPL_SUFFIX) <> unwrap(compile(expr.reference)))
	}

	def dispatch CodeGenNode compile(FeatureInvocationExpression call) {
		unwrap(compile(call.context)) -> switch call.feature {
			Operation: NamedReference.getIdentifier(call.feature) <> compile(call.parameters, call.feature)
			Property: fun(Template.GETTER_PREFIX <> NamedReference.getIdentifier(call.feature))
		}
	}

	def dispatch CodeGenNode compile(StaticFeatureInvocationExpression call) {
		val op = call.operation.reference as Operation
		var cls = op.class_
		if (Stereotypes.isExternalEntity(cls)) {
			RUNTIME_INSTANCE -> fun("getExternalEntity", cls.name <> ".class") ->
				fun(op.name, if (1 == op.ownedParameters.length) {
					// proxy parameter
					val param = op.ownedParameters.get(0)
					"new " <> fun(param.type.name, CONTEXT_NAME)
				} else {
					empty
				})
		} else {
			(NamedReference.getIdentifier(cls) <> Template.CLASS_IMPL_SUFFIX) ->
				(NamedReference.getIdentifier(op) <> compile(call.parameters, op))
		}
	}

	def dispatch CodeGenNode compile(ExpressionList values, Operation operation) {
		if (!values.expressions.empty) {
			throw new CompilationFailedException("Only by-name parameter passing is supported")
		}
		paren()
	}

	def dispatch CodeGenNode compile(NamedTuple values, Operation operation) {
		compileExpressionList(values, operation.ownedParameters)
	}

	def CodeGenNode compileExpressionList(NamedTuple values, EList<? extends NamedElement> qualifiers) {
		val node = paren()
		for (parameter : qualifiers) {
			val value = getExpressionByName(values, parameter.name)
			if (null == value) {
				throw new CompilationFailedException("Unable to match named parameter")
			}
			node.add(compile(value))
		}
		node
	}

	def Expression getExpressionByName(NamedTuple values, String name) {
		for (value : values.expressions) {
			if (value.name == name) {
				return value.expression
			}
		}
	}

	def dispatch CodeGenNode compile(LinkOperationExpression expr) {
		if (!(expr.parameters instanceof NamedTuple)) {
			throw new CompilationFailedException("Only by-name association linking is supported")
		}
		val association = expr.association.reference as Association
		var name = NamedReference.getIdentifier(association)
		var parameters = compileExpressionList(expr.parameters as NamedTuple, association.ownedEnds)
		var opName = if (LinkOperation.LINK == expr.linkOperation) {
				"link"
			} else {
				"unlink"
			}
		parameters.map[unwrap(it)]
		name -> opName <> parameters
	}

	def dispatch CodeGenNode compile(SignalDataExpression expr) {
		fun(PrimitiveOperations.CAST, expr.typeOf.convert.javaType -> "class", wrap(SIGDATA_NAME))
	}
}
