package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

/**
 * An implementation of {@link SourceCodeTask} which performs the modification
 * of a single file.
 */
public class UpdateSourceCodeTask implements SourceCodeTask {

	private final Template template;

	public UpdateSourceCodeTask(Template template) {
		this.template = template;
	}

	@Override
	public void perform(SourceCodeChangeListener listener) {
		String rootName = template.getRootName();
		SourceMappedText output = (SourceMappedText) template.generate();
		DebugSymbols symbols = template.getDebugSymbols();
		listener.sourceCodeChanged(rootName, output, symbols);
	}
}
