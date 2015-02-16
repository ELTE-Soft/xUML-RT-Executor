package hu.eltesoft.modelexecution.m2t.smap.xtend;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;

import com.google.inject.Injector;

/**
 * Responsible for instantiating or casting to types which are internal to
 * Xtend. The main purpose is to suppress warnings caused by visibility
 * restrictions here, as it could not be done from Xtend code.
 */
@SuppressWarnings("restriction")
public class BuiltinObjectsFactory {

	public static Injector getXtendPluginInjector() {
		return XtendActivator.getInstance().getInjector(
				XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND);
	}

	public static CompilationUnitImpl getComilationUnit(NamedElement element) {
		return (CompilationUnitImpl) element.getCompilationUnit();
	}

	public static ITreeAppendable createAppendable() {
		return new FakeTreeAppendable();
	}
}
