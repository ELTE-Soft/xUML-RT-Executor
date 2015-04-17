package hu.eltesoft.modelexecution.filemanager;

import java.io.IOException;

public interface IFileManager {

	/**
	 * Set root directory. Contents of the old location will be left intact and
	 * will not be moved/copied to this new location.
	 * 
	 * @param rootDirectory
	 *            The new path to set.
	 */
	public abstract void setRoot(String rootDirectory);

	/**
	 * @return Returns the current root directory path as string.
	 */
	public abstract String getRoot();

	/**
	 * @param qualifiedName
	 *            A fully qualified class name like a.b.cc.Ddd or Aaa
	 * @param content
	 *            The content to be written in the file.
	 */
	public abstract void addOrUpdate(String qualifiedName, String content)
			throws IOException;

	/**
	 * Removes a Java file if possible.
	 * 
	 * @param qualifiedName
	 *            Fully qualified class name of the Java file to be deleted.
	 */
	public abstract void remove(String qualifiedName);

	/**
	 * Remove all files and directories under the root.
	 * 
	 * @return Returns true if all files and directories under the root were
	 *         successfully removed, false otherwise.
	 */
	public abstract boolean cleanup();

	/**
	 * @param fileName
	 *            A fileName like almafa.java
	 * @param content
	 *            The content to be written in the file.
	 */
	public abstract void addOrUpdateFile(String fileName, String content) throws IOException;

}