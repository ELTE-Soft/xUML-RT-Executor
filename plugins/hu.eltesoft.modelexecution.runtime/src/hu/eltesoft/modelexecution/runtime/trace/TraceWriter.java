package hu.eltesoft.modelexecution.runtime.trace;

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
		if (!Files.exists(outputFilePath)) {
			if (outputFilePath.getParent() != null
					&& !Files.exists(outputFilePath.getParent())) {
				Files.createDirectories(outputFilePath.getParent());
			}
			Files.createFile(outputFilePath);
		}
		writer = Files.newBufferedWriter(outputFilePath);
	}

	public TraceWriter(String folderName, FileSystem fileSystem)
			throws IOException {
		this(fileSystem.getPath(folderName).resolve(
				createTimestampedFileName(fileSystem)));
	}

	public static TraceWriter forSpecifiedFile(String fileName,
			FileSystem fileSystem) throws IOException {
		return new TraceWriter(fileSystem.getPath(fileName));
	}

	private static Path createTimestampedFileName(FileSystem fileSystem) {
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
