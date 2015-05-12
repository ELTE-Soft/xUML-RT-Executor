package hu.eltesoft.modelexecution.runtime.tests.trace;

import static org.junit.Assert.*;
import hu.eltesoft.modelexecution.runtime.tests.mocks.DummySignal;
import hu.eltesoft.modelexecution.runtime.tests.mocks.MockClass;
import hu.eltesoft.modelexecution.runtime.trace.OutputTraceBuffer;
import hu.eltesoft.modelexecution.runtime.trace.TargetedMessage;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;

public class OutputTraceBufferTest {

	FileSystem fs;

	@Before
	public void setup() {
		fs = Jimfs.newFileSystem(Configuration.unix());
	}

	@After
	public void teardown() throws IOException {
		fs.close();
	}

	@Test
	public void testClose() throws Exception {
		String traceFolderName = "tracefolder";
		Path traceFolder = fs.getPath(traceFolderName);
		Files.createDirectories(traceFolder);
		OutputTraceBuffer sut = new OutputTraceBuffer(fs.getPath("MyProject",
				traceFolderName).toString(), 10, fs);
		sut.traceEvent(new TargetedMessage(MockClass.getInstance(),
				new DummySignal()));
		sut.close();
		Path expectedFile = traceFolder.resolve("t1.trace");
		assertTrue(Files.exists(expectedFile));
		String fileContent = new String(Files.readAllBytes(expectedFile));
		assertTrue(fileContent.contains(MockClass.class.getCanonicalName()));
	}

	@Test
	public void testAutomaticWrite() throws Exception {
		String traceFolderName = "tracefolder";
		Path traceFolder = fs.getPath(traceFolderName);
		Files.createDirectories(traceFolder);
		OutputTraceBuffer sut = new OutputTraceBuffer(fs.getPath("MyProject",
				traceFolderName).toString(), 3, fs);
		for (int i = 0; i < 10; i++) {
			sut.traceEvent(new TargetedMessage(MockClass.getInstance(),
					new DummySignal()));
		}
		assertTrue(Files.exists(traceFolder.resolve("t1.trace")));
		assertTrue(Files.exists(traceFolder.resolve("t2.trace")));
		assertTrue(Files.exists(traceFolder.resolve("t3.trace")));
		sut.close();
		assertTrue(Files.exists(traceFolder.resolve("t4.trace")));
		String lastContent = new String(Files.readAllBytes(traceFolder
				.resolve("t4.trace")));
		assertFalse(lastContent.trim().isEmpty());
	}

}
