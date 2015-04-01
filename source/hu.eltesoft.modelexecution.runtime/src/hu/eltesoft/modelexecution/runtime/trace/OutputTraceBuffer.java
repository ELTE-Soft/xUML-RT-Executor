package hu.eltesoft.modelexecution.runtime.trace;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;

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

	public OutputTraceBuffer(String folderName, int size) {
		this.size = size;
	}

	public void traceEvent(TargetedEvent event) {
		if (tracedEvents.size() < size) {
			tracedEvents.add(event);
		} else {
			outputTracedEvents();
		}
	}

	public void outputTracedEvents() {
		try (OutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File("t" + i + ".trace")))) {
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
