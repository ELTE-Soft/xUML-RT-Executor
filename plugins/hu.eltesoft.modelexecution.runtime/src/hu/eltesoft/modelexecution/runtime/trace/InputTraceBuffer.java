package hu.eltesoft.modelexecution.runtime.trace;

import hu.eltesoft.modelexecution.runtime.util.PathConverter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import com.thoughtworks.xstream.XStream;

/**
 * Collects traces from several XML files in a directory. Puts them in order and
 * loads events from them on demand.
 */
public class InputTraceBuffer implements AutoCloseable {

	private XStream xStream = new XStream();

	/** Invariant: nonempty while hasMoreElems() is true */
	private LinkedList<TargetedEvent> tracedEvents = new LinkedList<>();

	public InputTraceBuffer(String inputFolder) {
		detectTraceFiles(inputFolder);
		loadEvents();
	}

	protected LinkedList<File> traceFiles = new LinkedList<>();

	/**
	 * Detects all files in the given directory and orders them.
	 */
	protected void detectTraceFiles(String inputFolder) {
		File folder = new File(
				PathConverter.workspaceToProjectBased(inputFolder));
		if (folder.exists() && !folder.isDirectory()) {
			throw new RuntimeException(folder + " exists but not a directory.");
		}
		if (!folder.exists()) {
			folder.mkdir();
		}
		if (folder.exists() && folder.isDirectory()) {
			// newDirectoryStream has better performance than File.listFiles().
			traceFiles = new LinkedList<File>(Arrays.asList(folder.listFiles()));
		}
	}

	/**
	 * Loads a new set of events from a file into the memory.
	 */
	@SuppressWarnings("unchecked")
	private void loadEvents() {
		if (!traceFiles.isEmpty()) {
			File first = traceFiles.poll();
			try (BufferedInputStream input = new BufferedInputStream(
					new FileInputStream(first))) {
				tracedEvents = (LinkedList<TargetedEvent>) xStream
						.fromXML(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * True, if getTracedEvent() can be called.
	 */
	public boolean hasMoreElems() {
		return !tracedEvents.isEmpty();
	}

	/**
	 * Takes the next event. If the queue becomes empty loads the next file.
	 */
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
