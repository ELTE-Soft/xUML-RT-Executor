package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

/**
 * An implementation of {@link SourceCodeTask} which performs the modification
 * of a single file.
 */
public class UpdateSourceCodeTask implements SourceCodeTask {

	private final String rootName;
	private final Template template;

	public UpdateSourceCodeTask(String rootName, Template template) {
		this.rootName = rootName;
		this.template = template;
	}

	@Override
	public void perform(SourceCodeChangeListener listener) {
		SourceMappedText output = (SourceMappedText) template.generate();
		DebugSymbols symbols = template.getDebugSymbols();
		listener.sourceCodeChanged(rootName, output, symbols);
	}

	@Override
	public String toString() {
		return super.toString() + "( rootName: " + rootName + ", template: " + template + ")";
	}
}
