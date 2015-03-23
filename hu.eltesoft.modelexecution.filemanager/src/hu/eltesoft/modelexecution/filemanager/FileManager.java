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
		try (FileWriter writer = new FileWriter(outFile)) {
			writer.write(content);
		}
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
	 */
	public void cleanup() {
		File root = new File(rootDirectory);
		for (File file : root.listFiles()) {
			delete(file);
		}
	}

	private static void delete(File toDelete) {
		if (toDelete.exists()) {
			if (toDelete.isDirectory()) {
				File[] files = toDelete.listFiles();
				for (File file : files) {
					delete(file);
				}
			}
			toDelete.delete();
		}
	}

	private File qualifiedNameToFile(String qualifiedName) {
		String[] parts = qualifiedName.split("\\.");
		if (parts.length > 0) {
			parts[parts.length - 1] += ".java";
		}
		return Paths.get(rootDirectory, parts).toFile();
	}
	
	private static void createDirectoryForFile(File outFile) {
		File parent = outFile.getParentFile();
		if (null != parent) {
			parent.mkdirs();
		}
	}
}
