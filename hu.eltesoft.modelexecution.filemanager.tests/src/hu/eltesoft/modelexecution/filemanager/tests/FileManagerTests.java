package hu.eltesoft.modelexecution.filemanager.tests;

import hu.eltesoft.modelexecution.filemanager.FileManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileManagerTests extends TestCase {

	private String root;
	private static String testQualifiedName = "hu.eltesoft.modelexecution.testfilemanager.Test";
	private static String testFile = "hu/eltesoft/modelexecution/testfilemanager/Test.java";
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
			File result = new File(root + File.separator + testFile);
			Assert.assertTrue("Missing file.", result.exists());
			String read = new String(Files.readAllBytes(result.toPath()));
			Assert.assertEquals("Wrong contents.", testContent, read);
		} catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@After
	public void cleanUp() {
		try {
			new File(root).delete();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
