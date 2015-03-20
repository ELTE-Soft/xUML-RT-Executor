package hu.eltesoft.modelexecution.filemanager.tests;

import hu.eltesoft.modelexecution.filemanager.FileManager;

import java.nio.file.Files;
import java.nio.file.Path;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileManagerTests extends TestCase {

	private String root;
	private static String testQualifiedName = "hu.eltesoft.modelexecution.testfilemanager.Test";
	private static String testContent = "test\ncontent";
	private static String testDirPrefix = "filemanager_test_";
	
	@Before
	public void setUp() {
		try {
			Path tempDir = Files.createTempDirectory(testDirPrefix);
			root = tempDir.toString();
		} catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testCreate() {
		FileManager manager = new FileManager(root);
		try {
			manager.addOrUpdate(testQualifiedName, testContent);
		} catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
