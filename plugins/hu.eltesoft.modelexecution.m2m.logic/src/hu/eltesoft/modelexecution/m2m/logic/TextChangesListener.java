package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

/**
 * A listener interface that is informed when the textual representation of the
 * model is changed.
 */
public interface TextChangesListener {

	/**
	 * Called when the content of a file has been changed. The file has not
	 * necessarily existed before, so this method covers both the cases of the
	 * creation and modification of a file.
	 * 
	 * @param filename
	 *            the name of the file to be changed
	 * @param output
	 *            the new contents of the file with source mapping information
	 * @param symbols
	 *            debug symbols
	 */
	void contentChanged(String filename, SourceMappedText output,
			DebugSymbols symbols);

	/**
	 * Called when the content of a file has been deleted from the model so the
	 * file is no more required.
	 * 
	 * @param filename
	 *            the name of the file to be deleted
	 */
	void contentDeleted(String filename);

}
