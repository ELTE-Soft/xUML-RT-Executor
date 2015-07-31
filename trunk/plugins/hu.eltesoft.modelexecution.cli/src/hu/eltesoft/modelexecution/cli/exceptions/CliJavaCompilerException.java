package hu.eltesoft.modelexecution.cli.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

import hu.eltesoft.modelexecution.cli.Messages;
import hu.eltesoft.modelexecution.cli.Utils;

public class CliJavaCompilerException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	List<Diagnostic<? extends JavaFileObject>> diagnostics;

	public CliJavaCompilerException() {
		this(new ArrayList<>());
	}

	public CliJavaCompilerException(List<Diagnostic<? extends JavaFileObject>> diagnostics) {
		this.diagnostics = diagnostics;
	}

	@Override
	public String toString() {
		String sep = System.getProperty("line.separator");
		List<String> diags = diagnostics.stream().map(Diagnostic::toString).collect(Collectors.toList());
		String msgWithCount = Messages.JAVA_COMPILER_FAILURE_COUNT_KNOWN.getMsg(diags.size());
		String msgNoCount = Messages.JAVA_COMPILER_FAILURE.getMsg();
		String msg = diags.size() > 0 ? msgWithCount : msgNoCount;
		return String.format("%s%n%s", msg, Utils.join(diags, sep));
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
