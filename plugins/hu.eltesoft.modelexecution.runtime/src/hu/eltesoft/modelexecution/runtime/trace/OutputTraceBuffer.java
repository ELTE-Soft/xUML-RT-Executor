package hu.eltesoft.modelexecution.runtime.trace;

import hu.eltesoft.modelexecution.runtime.util.PathConverter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;

import org.eclipse.core.runtime.Path;

import com.thoughtworks.xstream.XStream;

/**
 * Implements the collection of traces into tracefiles. Buffers events and puts
 * each N event them into an XML file.
 */
public class OutputTraceBuffer implements AutoCloseable {

	private XStream xStream = new XStream();

	int i = 0;

	LinkedList<TargetedEvent> tracedEvents = new LinkedList<>();
	private int size;

	private String folderName;

	public OutputTraceBuffer(String folderName, int size) {
		this.folderName = folderName;
		this.size = size;
	}

	public void traceEvent(TargetedEvent event) {
		if (tracedEvents.size() < size) {
			tracedEvents.add(event);
		} else {
			outputTracedEvents();
		}
	}

	/**
	 * Writes the collected event into a file.
	 */
	public void outputTracedEvents() {
		File folder = PathConverter.workspaceToProjectBased(folderName);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File file = PathConverter.workspaceToProjectBased(folderName
				+ Path.SEPARATOR + "t" + (++i) + ".trace");
		try (OutputStream stream = new BufferedOutputStream(
				new FileOutputStream(file.getAbsoluteFile()))) {
			xStream.toXML(tracedEvents, stream);
		} catch (IOException e) {
			throw new RuntimeException("Exception while opening trace stream.",
					e);
		}
		tracedEvents.clear();
	}

	@Override
	public void close() throws Exception {
		outputTracedEvents();
	}

}
