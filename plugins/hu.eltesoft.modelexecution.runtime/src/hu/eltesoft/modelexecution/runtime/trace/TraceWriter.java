package hu.eltesoft.modelexecution.runtime.trace;

import hu.eltesoft.modelexecution.runtime.util.PathConverter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This tracer serializes incoming events into a file. The file contains no root
 * element, so it can be read while still being written.
 */
public class TraceWriter implements Tracer {

	private BufferedWriter writer;

	protected TraceWriter(Path outputFilePath) throws IOException {
		writer = Files.newBufferedWriter(outputFilePath);
		if (!Files.exists(outputFilePath)) {
			Files.createFile(outputFilePath);
		}
	}
	
	public TraceWriter(String folderName, FileSystem fileSystem) throws IOException {
		this(PathConverter.workspaceToProjectBasedPath(
				fileSystem, folderName));
	}

	public TraceWriter(FileSystem fileSystem) throws IOException {
		this(createDefaultPath(fileSystem));
	}

	private static Path createDefaultPath(FileSystem fileSystem) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		return fileSystem.getPath(format.format(new Date()) + ".trace");
	}

	@Override
	public void traceEvent(TargetedMessage event) throws IOException {
		event.jsonEncode().write(writer);
		writer.append('\n');
	}

	@Override
	public void close() throws Exception {
		writer.close();
	}

}
