package hu.eltesoft.modelexecution.runtime.trace;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import com.thoughtworks.xstream.XStream;

/**
 * Collects traces from several XML files in a directory. Puts them in order and
 * loads events from them on demand.
 */
public class InputTraceBuffer implements AutoCloseable {

	private XStream xStream = new XStream();

	/** Invariant: nonempty while hasMoreElems() is true */
	private LinkedList<TargetedEvent> tracedEvents;

	public InputTraceBuffer(String inputFolder) {
		detectTraceFiles(inputFolder);
		loadEvents();
	}

	protected Iterator<Path> traceFileIterator;

	/**
	 * Detects all files in the given directory and orders them.
	 */
	protected void detectTraceFiles(String inputFolder) {
		Path folder = FileSystems.getDefault().getPath(inputFolder);
		Set<Path> traceFiles = new TreeSet<>();
		if (folder.toFile().exists() && !folder.toFile().isDirectory()) {
			throw new RuntimeException(folder + " exists but not a directory.");
		}
		if (!folder.toFile().exists()) {
			folder.toFile().mkdir();
		}
		if (folder.toFile().exists() && folder.toFile().isDirectory()) {
			// newDirectoryStream has better performance than File.listFiles().
			try (DirectoryStream<Path> stream = Files
					.newDirectoryStream(folder)) {
				// files are stared inside a set to be sorted
				for (Path entry : stream) {
					traceFiles.add(entry);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		traceFileIterator = traceFiles.iterator();
	}

	/**
	 * Loads a new set of events from a file into the memory.
	 */
	@SuppressWarnings("unchecked")
	private void loadEvents() {
		if (traceFileIterator.hasNext()) {
			Path first = traceFileIterator.next();
			try (BufferedInputStream input = new BufferedInputStream(
					new FileInputStream(first.toFile()))) {
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
