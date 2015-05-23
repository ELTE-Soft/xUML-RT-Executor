package hu.eltesoft.modelexecution.runtime.trace;

import hu.eltesoft.modelexecution.runtime.util.PathConverter;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import com.thoughtworks.xstream.XStream;

/**
 * Implements the collection of traces into trace files. Buffers events and puts
 * each N event them into a separate XML file.
 */
public class OutputTraceBuffer implements IOutputTraceBuffer {

	private XStream xStream = new XStream();

	int i = 0;

	LinkedList<TargetedMessage> tracedEvents = new LinkedList<>();
	private int size;

	private String folderName;

	private FileSystem fileSystem;

	/**
	 * The trace files will be put under the project-based part of folderName.
	 * (Working directory is assumed to be project-based.)
	 * 
	 * @param folderName
	 *            Workspace based.
	 */
	public OutputTraceBuffer(String folderName, int size, FileSystem fileSystem) {
		this.folderName = folderName;
		this.size = size;
		this.fileSystem = fileSystem;
	}

	public OutputTraceBuffer(int size, FileSystem fileSystem) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		this.folderName = "project" + fileSystem.getSeparator() + "traces"
				+ format.format(date);
		this.size = size;
		this.fileSystem = fileSystem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hu.eltesoft.modelexecution.runtime.trace.IOutputTraceBuffer#traceEvent
	 * (hu.eltesoft.modelexecution.runtime.trace.TargetedEvent)
	 */
	@Override
	public void traceEvent(TargetedMessage event) {
		if (tracedEvents.size() >= size) {
			outputTracedEvents();
		}
		tracedEvents.add(event);
	}

	/**
	 * Writes collected events into a file.
	 */
	private void outputTracedEvents() {
		Path path = PathConverter.workspaceToProjectBasedPath(fileSystem,
				folderName);
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		Path file = path.resolve("t" + (++i) + ".trace");
		try (OutputStream stream = Files.newOutputStream(file)) {
			xStream.toXML(tracedEvents, stream);
		} catch (IOException e) {
			// this problem should shut down the execution
			throw new RuntimeException(e);
		}
		tracedEvents.clear();
	}

	@Override
	public void close() throws Exception {
		outputTracedEvents();
	}

}
