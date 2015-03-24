package hu.eltesoft.modelexecution.filemanager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Manager class to write, update and delete Java files according to package
 * hierarchy under a specified root directory.
 */
public class FileManager {

	private String rootDirectory;
	private static final String DEFAULT_ROOT_DIRECTORY = "";
	// The package element separator is a dot and it needs to be escaped:
	private static final String PACKAGE_ELEMENT_SEPARATOR_REGEX = "\\.";
	private static final String JAVA_EXTENSION = ".java";

	/**
	 * @param rootDirectory
	 *            Root directory of the package hierarchy to be created.
	 *            Warning: Empty path is set as default if this parameter is
	 *            null.
	 */
	public FileManager(String rootDirectory) {
		this.rootDirectory = rootDirectory;
		if (null == this.rootDirectory) {
			this.rootDirectory = DEFAULT_ROOT_DIRECTORY;
		}
	}

	/**
	 * Set root directory. Contents of the old location will be left intact and
	 * will not be moved/copied to this new location.
	 * 
	 * @param rootDirectory
	 *            The new path to set.
	 */
	public void setRoot(String rootDirectory) {
		this.rootDirectory = rootDirectory;
	}

	/**
	 * @return Returns the current root directory path as string.
	 */
	public String getRoot() {
		return rootDirectory;
	}

	/**
	 * @param qualifiedName
	 *            A fully qualified class name like a.b.cc.Ddd or Aaa
	 * @param content
	 *            The content to be written in the file.
	 */
	public void addOrUpdate(String qualifiedName, String content)
			throws IOException {
		if (null == qualifiedName) {
			return;
		}

		File outFile = qualifiedNameToFile(qualifiedName);
		createDirectoryForFile(outFile);
		writeContentToFile(content, outFile);
	}

	/**
	 * Removes a Java file if possible.
	 * 
	 * @param qualifiedName
	 *            Fully qualified class name of the Java file to be deleted.
	 */
	public void remove(String qualifiedName) {
		if (null == qualifiedName) {
			return;
		}

		File toDelete = qualifiedNameToFile(qualifiedName);
		toDelete.delete();
	}

	/**
	 * Remove all files and directories under the root.
	 * 
	 * @return Returns true if all files and directories under the root were
	 *         successfully removed, false otherwise.
	 */
	public boolean cleanup() {
		File root = new File(rootDirectory);
		File[] listFiles = root.listFiles();
		if (listFiles == null) {
			return false;
		}

		boolean allSucceeded = true;
		for (File file : listFiles) {
			boolean thisSucceeded = delete(file);
			allSucceeded &= thisSucceeded;
		}
		return allSucceeded;
	}

	private static boolean delete(File toDelete) {
		if (!toDelete.exists()) {
			return true;
		}

		if (toDelete.isDirectory()) {
			File[] files = toDelete.listFiles();
			for (File file : files) {
				delete(file);
			}
		}
		return toDelete.delete();
	}

	private File qualifiedNameToFile(String qualifiedName) {
		String[] parts = qualifiedName.split(PACKAGE_ELEMENT_SEPARATOR_REGEX);
		if (parts.length > 0) {
			parts[parts.length - 1] += JAVA_EXTENSION;
		}
		return Paths.get(rootDirectory, parts).toFile();
	}

	private static void createDirectoryForFile(File outFile) {
		File parent = outFile.getParentFile();
		if (null != parent) {
			parent.mkdirs();
		}
	}

	private static void writeContentToFile(String content, File outFile)
			throws IOException {
		try (FileWriter writer = new FileWriter(outFile)) {
			writer.write(content);
		}
	}
}
