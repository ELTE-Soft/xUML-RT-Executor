package hu.eltesoft.modelexecution.runtime.trace;

import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import hu.eltesoft.modelexecution.runtime.util.PathConverter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import com.thoughtworks.xstream.XStream;

/**
 * Collects traces from several XML files in a directory. Puts them in order and
 * loads events from them on demand.
 */
public class InputTraceBuffer implements AutoCloseable, IInputTraceBuffer {

	private XStream xStream = new XStream();

	/** Invariant: nonempty while hasMoreElems() is true */
	private LinkedList<TargetedEvent> tracedEvents = new LinkedList<>();

	private FileSystem fileSystem;

	public InputTraceBuffer(String inputFolder, FileSystem fileSystem) {
		this(InputTraceBuffer.class.getClassLoader(), inputFolder, fileSystem);
	}

	public InputTraceBuffer(ClassLoader classLoader, String inputFolder,
			FileSystem fileSystem) {
		xStream.setClassLoader(classLoader);
		this.fileSystem = fileSystem;
		detectTraceFiles(inputFolder);
		loadEvents();
	}

	protected Iterator<Path> traceFiles = Arrays.asList(new Path[] {})
			.iterator();

	/**
	 * Detects all files in the given directory and orders them.
	 */
	protected void detectTraceFiles(String inputFolder) {
		Path path = PathConverter.workspaceToProjectBasedPath(fileSystem,
				inputFolder);
		if (Files.exists(path) && !Files.isDirectory(path)) {
			throw new RuntimeException(path + " exists but not a directory.");
		}
		try {
			if (Files.exists(path)) {
				traceFiles = Files.list(path).iterator();
			}
		} catch (IOException e) {
			BaseRuntime.logError("Cannot detect trace files", e);
		}
	}

	/**
	 * Loads a new set of events from a file into the memory.
	 */
	@SuppressWarnings("unchecked")
	private void loadEvents() {
		if (traceFiles.hasNext()) {
			Path first = traceFiles.next();
			try (InputStream input = Files.newInputStream(first)) {
				tracedEvents = (LinkedList<TargetedEvent>) xStream
						.fromXML(input);
			} catch (IOException e) {
				// this problem should shut down the execution
				throw new RuntimeException(e);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hu.eltesoft.modelexecution.runtime.trace.IInputTraceBuffer#hasMoreElems()
	 */
	@Override
	public boolean hasMoreElems() {
		return !tracedEvents.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hu.eltesoft.modelexecution.runtime.trace.IInputTraceBuffer#getTracedEvent
	 * ()
	 */
	@Override
	public TargetedEvent getTracedEvent() {
		TargetedEvent ret = tracedEvents.poll();
		if (tracedEvents.isEmpty()) {
			loadEvents();
		}
		return ret;
	}

	@Override
	public void close() throws Exception {
	}

}
