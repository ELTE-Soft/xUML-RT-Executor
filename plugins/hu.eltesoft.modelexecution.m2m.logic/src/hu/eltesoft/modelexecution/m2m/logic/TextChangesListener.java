package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

/**
 * A listener interface that is informed when the textual representation of the
 * model is changed.
 * 
 * @author Gábor Ferenc Kovács
 *
 */
public interface TextChangesListener {

	/**
	 * Called when the content of a file has been changed. The file has not
	 * necessarily existed before, so this method covers both the cases of the
	 * creation and modification of a file.
	 * 
	 * @param rootName
	 *            the fully qualified name of the root model object of the
	 *            modified file
	 * @param output
	 *            The new contents of the file with source mapping information.
	 * @param symbols
	 *            Debug symbols.
	 */
	void contentChanged(String rootName, SourceMappedText output,
			DebugSymbols symbols);

	/**
	 * Called when the content of a file has been deleted from the model so the
	 * file is no more required.
	 * 
	 * @param filename
	 *            the fully qualified name of the root model object of the
	 *            deleted file
	 */
	void contentDeleted(String rootName);

}
