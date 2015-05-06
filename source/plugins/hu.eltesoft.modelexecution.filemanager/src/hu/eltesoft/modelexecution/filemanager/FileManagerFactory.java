package hu.eltesoft.modelexecution.filemanager;

public class FileManagerFactory implements IFileManagerFactory {

	@Override
	public IFileManager createFileManager(String rootDirectory) {
		return new FileManager(rootDirectory);
	}

}
