package hu.eltesoft.modelexecution.runtime.util;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Path;

public class PathConverter {

	public static Path workspaceToProjectBasedPath(FileSystem fs, String path) throws IOException {
		return fs.getPath("..", path);
	}

}
