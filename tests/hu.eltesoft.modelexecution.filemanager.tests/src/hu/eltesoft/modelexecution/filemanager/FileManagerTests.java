package hu.eltesoft.modelexecution.filemanager;

import hu.eltesoft.modelexecution.filemanager.FileManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileManagerTests {

	private static String root;
	private static String testPackage = "hu.eltesoft.modelexecution.testfilemanager";
	private static String testClass = "Test";
	private static String testQualifiedName = testPackage + "." +  testClass;
	private static String testPath = "hu/eltesoft/modelexecution/testfilemanager";
	private static String testFile = "Test.java";
	private static String testContent = "test\ncontent";
	private static String testDirPrefix = "filemanager_test_";
	private static IFileManager manager;

	@BeforeClass
	public static void setUp() {
		try {
			Path tempDir = Files.createTempDirectory(testDirPrefix);
			root = tempDir.toString();
			manager = new FileManager(root);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testCreateAndUpdate() {
		try {
			// Create
			manager.addOrUpdate(testQualifiedName, testContent);
			File result = new File(root + File.separator + testPath
					+ File.separator + testFile);
			Assert.assertTrue("Missing file.", result.exists());
			String read = new String(Files.readAllBytes(result.toPath()));
			Assert.assertEquals("Wrong contents.", testContent, read);

			// Update
			manager.addOrUpdate(testQualifiedName, testContent + testContent);
			result = new File(root + File.separator + testPath + File.separator
					+ testFile);
			Assert.assertTrue("Missing file.", result.exists());
			read = new String(Files.readAllBytes(result.toPath()));
			Assert.assertEquals("Wrong contents.", testContent + testContent,
					read);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void testNoPackage() {
		try {
			manager.addOrUpdate(testClass, testContent);
			File result = new File(root + File.separator + testFile);
			Assert.assertTrue("Missing unpackaged file.", result.exists());
			String read = new String(Files.readAllBytes(result.toPath()));
			Assert.assertEquals("Wrong contents.", testContent, read);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	@Test
	public void testRemove() {
		manager.remove(testQualifiedName);
		File result = new File(root + File.separator + testPath
				+ File.separator + testFile);
		Assert.assertFalse("Remove failed.", result.exists());
	}
	
	@Test
	public void testCleanup() {
		manager.cleanup();
		Assert.assertArrayEquals(new File[0], new File(root).listFiles());
	}

	@AfterClass
	public static void cleanUp() {
		try {
			manager.cleanup();
			new File(root).delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
