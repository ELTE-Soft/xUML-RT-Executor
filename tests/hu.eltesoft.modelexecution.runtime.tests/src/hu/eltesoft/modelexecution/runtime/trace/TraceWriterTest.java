package hu.eltesoft.modelexecution.runtime.trace;

import static org.junit.Assert.assertTrue;

import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.jimfs.Jimfs;

import hu.eltesoft.modelexecution.runtime.base.SignalEvent;
import hu.eltesoft.modelexecution.runtime.mocks.DummySignal;
import hu.eltesoft.modelexecution.runtime.mocks.MockClass;

public class TraceWriterTest {

	@Test
	public void testTraceEvent() throws Exception {
		FileSystem fileSystem = Jimfs.newFileSystem();
		String folderName = "traces";

		try (TraceWriter sut = new TraceWriter(folderName, fileSystem)) {
			sut.traceEvent(new TargetedEvent(new MockClass(), new SignalEvent(new DummySignal())));
		}

		Path path = fileSystem.getPath(folderName);
		Stream<Path> files = Files.list(path).filter(Files::isRegularFile);
		Optional<Path> anyFile = files.findAny();
		assertTrue(anyFile.isPresent());
		assertTrue(Files.readAllLines(anyFile.get()).size() > 0);
	}
}
