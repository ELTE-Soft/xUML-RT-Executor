package hu.eltesoft.modelexecution.m2t.smap.xtend;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;

import org.eclipse.xtend.core.compiler.XtendCompiler;
import org.eclipse.xtend.core.macro.declaration.ExpressionImpl;
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.lib.macro.expression.Expression;
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
 * TODO: write doc
 */
@SuppressWarnings("restriction")
public class SmapCompiler extends XtendCompiler {

	private String stratumName;
	private HashSet<String> methodNames;
	private JvmType thisType;

	public boolean returnsCharSequence(Expression body) {
		JvmTypeReference type = getType(asXExpression(body));
		return type.getQualifiedName().equals(
				CharSequence.class.getCanonicalName());
	}

	private XExpression asXExpression(Expression expr) {
		ExpressionImpl impl = (ExpressionImpl) expr;
		return (XExpression) impl.getDelegate();
	}

	public void compileBody(Expression body, ITreeAppendable b,
			String stratumName, JvmTypeReference returnType, HashSet<String> methodNames, JvmType thisType) {
		this.stratumName = stratumName;
		this.methodNames = methodNames;
		this.thisType = thisType;
		compileAsJavaExpression(asXExpression(body), b, returnType);
	}

	/**
	 * Change the declared type of _builder to our custom string concatenation
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
			b.append(SmapStringConcatenation.class);
			b.append(" ");
			b.append(variableName);
			b.append(" = new ");
			b.append(SmapStringConcatenation.class);
			b.append("(\"");
			b.append(stratumName);
			b.append("\");");
			RichStringPrepareCompiler compiler = new RichStringPrepareCompiler(
					b, variableName, richString);
			getRichStringProcessor().process(richString, compiler,
					getIndentationHandler().get());
		}
	}

	private RichStringProcessor getRichStringProcessor() {
		return getInheritedFieldValue("richStringProcessor");
	}

	private Provider<DefaultIndentationHandler> getIndentationHandler() {
		return getInheritedFieldValue("indentationHandler");
	}

	protected void appendFeatureCall(XAbstractFeatureCall call, ITreeAppendable b) {
		if (getExpressionHelper().isInlined(call)) {
			appendInlineFeatureCall(call, b);
			return;
		}
		JvmIdentifiableElement feature = call.getFeature();
		String name;
		if (feature instanceof JvmConstructor) {
			JvmDeclaredType constructorContainer = ((JvmConstructor) feature).getDeclaringType();
			JvmIdentifiableElement logicalContainer = getContextProvider().getNearestLogicalContainer(call);
			JvmDeclaredType contextType = ((JvmMember) logicalContainer).getDeclaringType();
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
		if(name == null)
			name = "/* name is null */";
		if (methodNames.contains(name) && feature instanceof JvmExecutable && ((JvmExecutable) feature).getDeclaringType().equals(thisType)) {
			name = "smap_" + name;
		}
		b.trace(call, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 0).append(name);
		if (feature instanceof JvmExecutable) {
			b.append("(");
			List<XExpression> arguments = getActualArguments(call);
			if (!arguments.isEmpty()) {
				XExpression receiver = (call instanceof XMemberFeatureCall) ? ((XMemberFeatureCall)call).getMemberCallTarget() : null;
				boolean shouldBreakFirstArgument = receiver == null || arguments.get(0) != receiver;
				appendArguments(arguments, b, shouldBreakFirstArgument);
			}
			b.append(")");
		}
	}

	private XExpressionHelper getExpressionHelper() {
		return getInheritedFieldValue2("expressionHelper");
	}

	private ILogicalContainerProvider getContextProvider() {
		return getInheritedFieldValue2("contextProvider");
	}

	private IdentifiableSimpleNameProvider getFeatureNameProvider() {
		return getInheritedFieldValue2("featureNameProvider");
	}

	/**
	 * Uses reflection to access a reference in a private field of the direct
	 * superclass.
	 */
	@SuppressWarnings("unchecked")
	private <T> T getInheritedFieldValue(String name) {
		Field field;
		try {
			field = XtendCompiler.class.getDeclaredField(name);
			field.setAccessible(true);
			return (T) field.get(this);
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			return null; // nothing to do
		}
	}
	
	@SuppressWarnings("unchecked")
	private <T> T getInheritedFieldValue2(String name) {
		Field field;
		try {
			field = FeatureCallCompiler.class.getDeclaredField(name);
			field.setAccessible(true);
			return (T) field.get(this);
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			return null; // nothing to do
		}
	}
}
