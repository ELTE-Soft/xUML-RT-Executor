package hu.eltesoft.modelexecution.runtime.tests.trace;

import static org.junit.Assert.*;

import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

import hu.eltesoft.modelexecution.runtime.tests.mocks.DummySignal;
import hu.eltesoft.modelexecution.runtime.tests.mocks.MockClass;
import hu.eltesoft.modelexecution.runtime.trace.TargetedMessage;
import hu.eltesoft.modelexecution.runtime.trace.TraceWriter;

import org.junit.Test;

import com.google.common.jimfs.Jimfs;

public class TraceWriterTest {

	@Test
	public void testTraceEvent() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String folderName = "traces";
		TraceWriter sut = new TraceWriter(folderName, fileSystem);
		sut.traceEvent(new TargetedMessage(new MockClass(null), new DummySignal()));
		sut.close();
		
		Path path = fileSystem.getPath(folderName);
		Stream<Path> files = Files.list(path).filter(Files::isRegularFile);
		Optional<Path> anyFile = files.findAny();
		assertTrue(anyFile.isPresent());
		assertTrue(Files.readAllLines(anyFile.get()).size() > 0);
	}
	
	
	
}
