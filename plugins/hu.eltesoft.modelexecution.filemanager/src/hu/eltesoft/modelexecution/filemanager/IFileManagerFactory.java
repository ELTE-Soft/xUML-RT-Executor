package hu.eltesoft.modelexecution.filemanager;

public interface IFileManagerFactory {

	IFileManager createFileManager(String rootDirectory);

}
