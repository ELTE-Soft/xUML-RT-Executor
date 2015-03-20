package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

/**
 * A listener interface that is informed when the textual representation of the
 * model is changed.
 * 
 * @author Kovács Gábor Ferenc
 *
 */
public interface TextChangesListener {

	/**
	 * Called when the content of a file has been changed. The file has not
	 * necessarily existed before, so this method covers both the cases of the
	 * creation and modification of a file.
	 * 
	 * @param filename
	 *            The name of the file to be changed.
	 * @param output
	 *            The new contents of the file with source mapping information.
	 * @param symbols
	 *            Debug symbols.
	 */
	void contentChanged(String fileName, SourceMappedText output, DebugSymbols symbols);

	/**
	 * Called when the content of a file has been deleted from the model so the
	 * file is no more required.
	 * 
	 * @param fileName
	 *            The name of the file to be deleted.
	 */
	void contentDeleted(String fileName);

}
