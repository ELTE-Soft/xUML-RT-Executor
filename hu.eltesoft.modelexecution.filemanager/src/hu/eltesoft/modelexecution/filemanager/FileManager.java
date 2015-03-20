package hu.eltesoft.modelexecution.filemanager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FileManager {

	private String rootDirectory;

	public FileManager(String rootDirectory) {
		this.rootDirectory = rootDirectory;
		if(null == this.rootDirectory) {
			this.rootDirectory = "";
		}
	}
	
	public void addOrUpdate(String qualifiedName, String content) throws IOException {
		if(null == qualifiedName) {
			return;
		}
		
		File outFile = qualifiedNameToFile(qualifiedName);
		File parent = outFile.getParentFile();
		if(null != parent) {
			parent.mkdirs();
		}
		FileWriter writer = new FileWriter(outFile);
		writer.write(content);
		writer.close();
	}
	
	public void remove(String qualifiedName) {
		if(null == qualifiedName) {
			return;
		}
		
		File toDelete = qualifiedNameToFile(qualifiedName);
		toDelete.delete();
	}
	
	private File qualifiedNameToFile(String qualifiedName) {
		String[] parts = qualifiedName.split("\\.");
		return Paths.get(rootDirectory, parts).toFile();
	}
}
