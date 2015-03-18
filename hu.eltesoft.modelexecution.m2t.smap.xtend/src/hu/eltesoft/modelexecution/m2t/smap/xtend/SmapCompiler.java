package hu.eltesoft.modelexecution.m2t.smap.xtend;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtend.core.compiler.XtendCompiler;
import org.eclipse.xtend.core.macro.declaration.ExpressionImpl;
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.FeatureCallCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import com.google.inject.Provider;

/**
 * Modification of the original Xtend compiler to support JSR-045 compatible
 * source code mapping in templates. Two main code generator methods are
 * overridden. First, it replaces the type of the _builder variable in the
 * generated code. Second, corrects nested feature call names of template
 * methods from the same template class. This code uses a lot of tricks like
 * reflection to achieve its goals. Therefore, it is needed to check this code
 * very carefully before we upgrade to the next Xtend version.
 */
@SuppressWarnings("restriction")
class SmapCompiler extends XtendCompiler {

	private final JvmType thisType;
	private final String stratumName;
	private final Set<String> originalMethodNames = new HashSet<>();

	/**
	 * @param thisType
	 *            Refers to the Xtend class for which the code generated for.
	 * @param stratumName
	 *            The generated code will create strata with this name.
	 */
	public SmapCompiler(JvmType thisType, String stratumName) {
		this.thisType = thisType;
		this.stratumName = stratumName;
	}

	/**
	 * @see toOriginalName
	 */
	public void addOriginalMethodName(String name) {
		originalMethodNames.add(name);
	}

	/**
	 * Decide whether the returned type of a method body is CharSequence. It
	 * works correctly even when the return type is inferred.
	 */
	public boolean returnsCharSequence(Expression body) {
		JvmTypeReference type = getType(asXExpression(body));
		return type.getQualifiedName().equals(
				CharSequence.class.getCanonicalName());
	}

	/**
	 * Extracts the delegate of an Expression, by casting it to its
	 * implementation. This operation could be dangerous in later versions.
	 */
	private XExpression asXExpression(Expression expr) {
		ExpressionImpl impl = (ExpressionImpl) expr;
		return (XExpression) impl.getDelegate();
	}

	/**
	 * Compiles a single method body as an expression. It will result in a
	 * single zero arity function object and its immediate application.
	 */
	public void compileBody(Expression body, ITreeAppendable b) {
		b.declareVariable(thisType, "this");
		compileAsJavaExpression(asXExpression(body), b,
				getType(asXExpression(body)));
	}

	/**
	 * Change the dynamic type of _builder to our custom string concatenation
	 * implementation in the generated code. Most of the code is copied from the
	 * superclass.
	 */
	@Override
	public void _toJavaStatement(RichString richString, ITreeAppendable b,
			boolean isReferenced) {
		LightweightTypeReference actualType = getLightweightType(richString);
		b = b.trace(richString);
		if (actualType.isType(StringConcatenationClient.class)) {
			String resultVariableName = b.declareSyntheticVariable(richString,
					"_client");
			b.newLine();
			b.append(actualType);
			b.append(" ");
			b.append(resultVariableName);
			b.append(" = new ");
			b.append(actualType);
			b.append("() {");
			b.openScope();
			reassignThisInClosure(b, actualType.getType());
			b.increaseIndentation().newLine();
			b.append("@");
			b.append(Override.class);
			b.newLine().append("protected void appendTo(");
			b.append(StringConcatenationClient.TargetStringConcatenation.class);
			String variableName = b.declareSyntheticVariable(richString,
					"_builder");
			b.append(" ").append(variableName).append(") {");
			b.increaseIndentation();
			RichStringPrepareCompiler compiler = new RichStringPrepareCompiler(
					b, variableName, richString);
			getRichStringProcessor().process(richString, compiler,
					getIndentationHandler().get());
			b.closeScope();
			b.decreaseIndentation().newLine().append("}").decreaseIndentation()
					.newLine().append("};");
		} else {
			// declare variable
			String variableName = b.declareSyntheticVariable(richString,
					"_builder");
			b.newLine();
			b.append(StringConcatenation.class);
			b.append(" ");
			b.append(variableName);
			b.append(" = new ");
			b.append(SmapStringConcatenation.class); // type changed here
			b.append("(\"");
			b.append(stratumName); // parameter added here
			b.append("\");");
			RichStringPrepareCompiler compiler = new RichStringPrepareCompiler(
					b, variableName, richString);
			getRichStringProcessor().process(richString, compiler,
					getIndentationHandler().get());
		}
	}

	/**
	 * Invisibly inherited from XtendCompiler.
	 */
	private RichStringProcessor getRichStringProcessor() {
		return getXtendCompilerFieldValue("richStringProcessor");
	}

	/**
	 * Invisibly inherited from XtendCompiler.
	 */
	private Provider<DefaultIndentationHandler> getIndentationHandler() {
		return getXtendCompilerFieldValue("indentationHandler");
	}

	/**
	 * Retrieves a field inherited from XtendCompiler.
	 */
	private <T> T getXtendCompilerFieldValue(String name) {
		return getInheritedFieldValue(XtendCompiler.class, name);
	}

	/**
	 * Corrects feature call names to source mapped versions. It is needed to
	 * handle nested templates correctly within a single class. Most of the code
	 * is copied from the FeatureCallCompiler parent class.
	 */
	protected void appendFeatureCall(XAbstractFeatureCall call,
			ITreeAppendable b) {
		if (getExpressionHelper().isInlined(call)) {
			appendInlineFeatureCall(call, b);
			return;
		}
		JvmIdentifiableElement feature = call.getFeature();
		String name;
		if (feature instanceof JvmConstructor) {
			JvmDeclaredType constructorContainer = ((JvmConstructor) feature)
					.getDeclaringType();
			JvmIdentifiableElement logicalContainer = getContextProvider()
					.getNearestLogicalContainer(call);
			JvmDeclaredType contextType = ((JvmMember) logicalContainer)
					.getDeclaringType();
			if (contextType == constructorContainer)
				name = "this";
			else
				name = "super";
		} else {
			if (b.hasName(feature)) {
				name = b.getName(feature);
			} else {
				name = getFeatureNameProvider().getSimpleName(feature);
			}
		}
		if (name == null)
			name = "/* name is null */";
		name = toOriginalName(feature, name); // this line of code inserted
		b.trace(call, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 0)
				.append(name);
		if (feature instanceof JvmExecutable) {
			b.append("(");
			List<XExpression> arguments = getActualArguments(call);
			if (!arguments.isEmpty()) {
				XExpression receiver = (call instanceof XMemberFeatureCall) ? ((XMemberFeatureCall) call)
						.getMemberCallTarget() : null;
				boolean shouldBreakFirstArgument = receiver == null
						|| arguments.get(0) != receiver;
				appendArguments(arguments, b, shouldBreakFirstArgument);
			}
			b.append(")");
		}
	}

	/**
	 * If this name marks a call to another method on this class, we try to
	 * remove its prefix added by the source mapped template processor to the
	 * name of original methods.
	 */
	private String toOriginalName(JvmIdentifiableElement feature, String name) {
		if (isMethodOfThisClass(feature) && isModifiedName(name)) {
			return getOriginalName(name);
		}
		return name;
	}

	private boolean isMethodOfThisClass(JvmIdentifiableElement feature) {
		return feature instanceof JvmExecutable
				&& ((JvmExecutable) feature).getDeclaringType()
						.equals(thisType);
	}

	private boolean isModifiedName(String name) {
		return name.startsWith(SourceMappedTemplateProcessor.ORIGINAL_PREFIX)
				&& originalMethodNames.contains(getOriginalName(name));
	}

	private String getOriginalName(String name) {
		return name.substring(SourceMappedTemplateProcessor.ORIGINAL_PREFIX
				.length());
	}

	/**
	 * Invisibly inherited from FeatureCallCompiler.
	 */
	private XExpressionHelper getExpressionHelper() {
		return getFeatureCallCompilerFieldValue("expressionHelper");
	}

	/**
	 * Invisibly inherited from FeatureCallCompiler.
	 */
	private ILogicalContainerProvider getContextProvider() {
		return getFeatureCallCompilerFieldValue("contextProvider");
	}

	/**
	 * Invisibly inherited from FeatureCallCompiler.
	 */
	private IdentifiableSimpleNameProvider getFeatureNameProvider() {
		return getFeatureCallCompilerFieldValue("featureNameProvider");
	}

	/**
	 * Retrieves a field inherited from FeatureCallCompiler.
	 */
	private <T> T getFeatureCallCompilerFieldValue(String name) {
		return getInheritedFieldValue(FeatureCallCompiler.class, name);
	}

	/**
	 * Uses reflection to access a reference in a private field declared in the
	 * specified parent class.
	 */
	@SuppressWarnings("unchecked")
	private <T> T getInheritedFieldValue(Class<?> parent, String fieldName) {
		try {
			Field field = parent.getDeclaredField(fieldName);
			field.setAccessible(true);
			return (T) field.get(this);
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			String message = String.format("Xtend version incompatibility: "
					+ "the requested field could not be found: %s.%s",
					parent.getCanonicalName(), fieldName);
			throw new RuntimeException(message, e);
		}
	}
}
