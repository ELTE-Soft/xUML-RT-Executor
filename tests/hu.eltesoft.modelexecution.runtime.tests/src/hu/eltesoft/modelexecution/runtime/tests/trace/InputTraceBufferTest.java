package hu.eltesoft.modelexecution.runtime.tests.trace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import hu.eltesoft.modelexecution.runtime.Runtime;
import hu.eltesoft.modelexecution.runtime.tests.mocks.DummyEvent;
import hu.eltesoft.modelexecution.runtime.tests.mocks.MockClass;
import hu.eltesoft.modelexecution.runtime.trace.IInputTraceBuffer;
import hu.eltesoft.modelexecution.runtime.trace.InputTraceBuffer;
import hu.eltesoft.modelexecution.runtime.trace.OutputTraceBuffer;
import hu.eltesoft.modelexecution.runtime.trace.TargetedEvent;

import java.io.IOException;
import java.nio.file.FileSystem;

import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;

public class InputTraceBufferTest {

	FileSystem fs;
	static Mockery context = new Mockery();
	static Runtime runtime = context.mock(hu.eltesoft.modelexecution.runtime.Runtime.class);

	@BeforeClass
	public static void setupClass() {
		new MockClass(runtime);
	}
	
	@Before
	public void setup() {
		fs = Jimfs.newFileSystem(Configuration.unix());
	}

	@After
	public void teardown() throws IOException {
		fs.close();
	}

	@Test
	public void testWithOneTraceFile() throws Exception {
		String traceFolderName = "tracefolder";
		String folderName = fs.getPath("MyProject",
				traceFolderName).toString();
		int numEvents = 3;
		writeTraceFiles(folderName, 10, numEvents);
		InputTraceBuffer sut = new InputTraceBuffer(getClass().getClassLoader(), folderName, fs);
		checkElems(numEvents, sut);
		sut.close();
	}
	
	@Test
	public void testWithMultipleTraceFiles() throws Exception {
		String traceFolderName = "tracefolder";
		String folderName = fs.getPath("MyProject",
				traceFolderName).toString();
		int numEvents = 10;
		writeTraceFiles(folderName, 3, numEvents);
		InputTraceBuffer sut = new InputTraceBuffer(getClass().getClassLoader(), folderName, fs);
		checkElems(numEvents, sut);
		sut.close();
	}

	private void checkElems(int numEvents, IInputTraceBuffer sut) {
		for (int i = 0; i < numEvents; i++) {
			assertTrue(sut.hasMoreElems());
			TargetedEvent tracedEvent = sut.getTracedEvent();
			assertEquals(tracedEvent, sampleEvent());
		}
		assertFalse(sut.hasMoreElems());
	}

	private void writeTraceFiles(String folderName, int size, int numEvents) throws Exception {
		OutputTraceBuffer otb = new OutputTraceBuffer(folderName, size, fs);
		for (int i = 0; i < numEvents; i++) {
			otb.traceEvent(sampleEvent());
		}
		otb.close();
	}

	private TargetedEvent sampleEvent() {
		return new TargetedEvent(MockClass.getInstance(),
				new DummyEvent());
	}
}
