package hu.eltesoft.modelexecution.m2m.logic.tasks;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTask;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

/**
 * An implementation of {@link FileUpdateTask} which performs the modification
 * of a single file.
 */
public class FileModificationTask implements FileUpdateTask {

	private final String rootName;
	private final Template template;

	public FileModificationTask(String rootName, Template template) {
		this.rootName = rootName;
		this.template = template;
	}

	@Override
	public void perform(TextChangesListener listener) {
		SourceMappedText output = (SourceMappedText) template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		listener.contentChanged(rootName, output, symbols);
	}

	@Override
	public int hashCode() {
		return (template == null) ? 0 : template.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileModificationTask other = (FileModificationTask) obj;
		if (template == null) {
			if (other.template != null)
				return false;
		} else if (!template.equals(other.template))
			return false;
		return true;
	}
}
