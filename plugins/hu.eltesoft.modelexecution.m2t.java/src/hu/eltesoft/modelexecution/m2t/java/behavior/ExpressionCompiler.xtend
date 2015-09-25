package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.AssociationAccessExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanLiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ClassExtentExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType
import com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionVariable
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ElementCollectionExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.FilterExpression
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
import hu.eltesoft.modelexecution.runtime.InstanceRegistry
import hu.eltesoft.modelexecution.runtime.library.CollectionOperations
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import org.apache.commons.lang.StringEscapeUtils
import org.eclipse.emf.common.util.EList
import org.eclipse.uml2.uml.Association
import org.eclipse.uml2.uml.BehavioralFeature
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.NamedElement
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.Parameter
import org.eclipse.uml2.uml.ParameterDirectionKind
import org.eclipse.uml2.uml.PrimitiveType
import org.eclipse.uml2.uml.Property
import org.eclipse.uml2.uml.Signal
import org.eclipse.uml2.uml.Type
import org.eclipse.uml2.uml.TypedElement

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

	def dispatch CodeGenNode compile(ElementCollectionExpression lit) {
		val items = paren()
		for (expr : lit.elements.expressions) {
			items.add(unwrap(compile(expr)))
		}
		val funName = switch lit.collectionType {
			case SEQUENCE: CollectionOperations.SEQUENCE_LITERAL
			case SET: CollectionOperations.SET_LITERAL
			case BAG: CollectionOperations.BAG_LITERAL
		}
		funName <> items
	}

	def dispatch CodeGenNode compile(NullExpression expr) {
		fun(PrimitiveOperations.NULL_VALUE)
	}

	def dispatch CodeGenNode compile(ThisExpression expr) {
		wrap(CONTEXT_NAME)
	}

	def dispatch CodeGenNode compile(LocalNameDeclarationStatement declaration) {
		val variable = declaration.variable
		val baseType = variable.type.type.convert
		val type = switch variable {
			CollectionVariable: collectionName(variable.collectionType) <> "<" <> baseType.javaType <> ">"
			Variable: baseType.javaType(SINGLE)
		}

		val localName = declaration.variable.localName
		val rhs = if (null != declaration.expression) {
				compile(declaration.expression)
			} else if (variable instanceof CollectionVariable) {
				compileCollectionInitializer((variable as CollectionVariable).collectionType)
			} else {
				compileTypeInitializer(variable.type.type)
			}
		binOp(type <> " " <> localName, "=", rhs)
	}

	def CodeGenNode compileCollectionInitializer(CollectionType type) {
		sequence(createEmpty(type))
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
						(NamedReference.getIdentifier(constructor) <> compile(expr.parameters, constructor, false))
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
		compileExpressionList(values, signal.ownedAttributes, false)
	}

	def Operation getConstructor(Class cl) {
		for (operation : cl.ownedOperations) {
			if (operation.name == cl.name) {
				return operation
			}
		}
	}

	def dispatch CodeGenNode compile(InstanceDeletionExpression expr) {
		unwrap(compile(expr.reference)) -> fun("delete")
	}

	def dispatch CodeGenNode compile(FeatureInvocationExpression call) {
		val context = compile(call.context)
		switch call.feature {
			Operation: {
				val parameters = compile(call.parameters, call.feature as BehavioralFeature, false)
				if (StandardLibraryMapping.isStandardFeature(call.feature.qualifiedName)) {
					parameters.prepend(context)
					StandardLibraryMapping.getImplementationName(call.feature.qualifiedName) <> parameters
				} else {
					unwrap(context) -> NamedReference.getIdentifier(call.feature) <> parameters
				}
			}
			Property:
				unwrap(context) -> fun(Template.GETTER_PREFIX <> NamedReference.getIdentifier(call.feature))
		}
	}

	def dispatch CodeGenNode compile(StaticFeatureInvocationExpression call) {
		val op = call.operation.reference as Operation
		var cls = op.class_
		if (StandardLibraryMapping.isStandardFeature(op.qualifiedName)) {
			StandardLibraryMapping.getImplementationName(op.qualifiedName) <> compile(call.parameters, op, false)
		} else if (null != cls && Stereotypes.isExternalEntity(cls)) {
			val expr = RUNTIME_INSTANCE -> fun("getExternalEntity", cls.name <> ".class") -> op.name <>
				compile(call.parameters, op, true)
			if (null != op.getReturnResult) {
				wrap(expr)
			} else {
				expr
			}
		} else {
			(NamedReference.getIdentifier(cls) <> Template.CLASS_IMPL_SUFFIX) ->
				(NamedReference.getIdentifier(op) <> compile(call.parameters, op, false))
		}
	}

	def dispatch CodeGenNode compile(ExpressionList values, BehavioralFeature feature, boolean isExternal) {
		compileExpressionList(values, feature.ownedParameters, isExternal)
	}

	def dispatch CodeGenNode compile(NamedTuple values, BehavioralFeature feature, boolean isExternal) {
		compileExpressionList(values, feature.ownedParameters, isExternal)
	}

	def <E extends NamedElement & TypedElement> CodeGenNode compileExpressionList(ExpressionList values,
		EList<E> parameters, boolean isExternal) {
		val node = paren()
		for (i : 0 ..< values.expressions.length) {
			val parameter = parameters.get(i)
			if (!parameter.isReturnParameter) {
				val value = values.expressions.get(i)
				node.add(compileParameter(parameter, value, isExternal))
			}
		}
		node
	}

	def <E extends NamedElement & TypedElement> CodeGenNode compileExpressionList(NamedTuple values,
		EList<E> parameters, boolean isExternal) {
		val node = paren()
		for (parameter : parameters) {
			if (!parameter.isReturnParameter) {
				val value = getExpressionByName(values, parameter.name)
				if (null == value) {
					throw new CompilationFailedException("Unable to match named parameter")
				}
				node.add(compileParameter(parameter, value, isExternal))
			}
		}
		node
	}

	def dispatch isReturnParameter(Object parameter) {
		false
	}

	def dispatch isReturnParameter(Parameter parameter) {
		ParameterDirectionKind.RETURN_LITERAL == (parameter as Parameter).direction
	}

	def <E extends NamedElement & TypedElement> compileParameter(E parameter, Expression value, boolean isExternal) {
		var expr = compile(value)
		if (isExternal) {
			expr = unwrap(expr)
			if (!(parameter.type instanceof PrimitiveType)) {
				// add callable wrapper
				expr = "new " <> fun(parameter.type.name, expr)
			}
		}
		expr
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
		var parameters = compileExpressionList(expr.parameters as NamedTuple, association.ownedEnds, false)
		var opName = if (LinkOperation.LINK == expr.linkOperation) {
				"link"
			} else {
				"unlink"
			}
		parameters.map[unwrap(it)]
		name -> opName <> parameters
	}

	def dispatch CodeGenNode compile(AssociationAccessExpression expr) {
		val end = expr.association
		val assoc = end.owner as Association
		val otherEnd = assoc.otherEnd(end)

		val baseType = expr.context.valueTypeOf.convert.javaType
		var fromType = if (expr.context.typeOf.isCollection) {
				expr.context.typeOf.collectionName <> "<? extends " <> baseType <> ">"
			} else {
				"java.util.Collection<? extends " <> baseType <> ">"
			}
		val toType = expr.typeOf.collectionName <> "<" <> expr.valueTypeOf.convert.javaType <> ">"
		val lambdaType = "java.util.function.Function<" <> fromType <> ", " <> toType <> ">"
		val paramName = freshLocalName
		val resultName = freshLocalName
		val objName = freshLocalName
		val assocName = freshLocalName
		val assocType = assoc.convert.javaType
		val assocGetter = Template.GETTER_PREFIX <> NamedReference.getIdentifier(otherEnd)
		val propName = NamedReference.getIdentifier(end)
		val labmdaBody = block(
			sequence(toType) <> " " <> resultName <> " = " <> expr.typeOf.createEmpty,
			"for " <> paren(baseType <> " " <> objName <> " : " <> paramName) <> " " <> block(
				"for " <> paren(assocType <> " " <> assocName <> " : " <> objName -> fun(assocGetter)) <> " " <> block(
					resultName -> fun("add", assocName -> propName)
				)
			),
			"return " <> resultName
		)
		val lambda = paren(paren(lambdaType) <> paren(paren(paramName) <> " -> " <> labmdaBody))
		lambda -> fun("apply", compile(expr.context));
	}

	def otherEnd(Association association, Property property) {
		for (end : association.ownedEnds) {
			if (end != property) {
				return end
			}
		}
	}

	def dispatch CodeGenNode compile(SignalDataExpression expr) {
		fun(PrimitiveOperations.CAST, expr.typeOf.convert.javaType -> "class", wrap(SIGDATA_NAME))
	}

	def dispatch CodeGenNode compile(ClassExtentExpression expr) {
		InstanceRegistry.canonicalName -> fun("getInstanceRegistry") ->
			fun("allInstances", (compile(expr.class_) <> Template.CLASS_IMPL_SUFFIX) -> "class")
	}

	def dispatch CodeGenNode compile(FilterExpression expr) {
		fun(
			CollectionOperations.FILTER,
			compile(expr.context),
			expr.declaration.localName <> " -> " <> unwrap(compile(expr.expression))
		)
	}
}
