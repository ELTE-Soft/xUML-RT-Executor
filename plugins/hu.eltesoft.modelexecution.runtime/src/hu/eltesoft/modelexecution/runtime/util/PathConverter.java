package hu.eltesoft.modelexecution.runtime.util;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.Arrays;

public class PathConverter {

	public static Path workspaceToProjectBasedPath(FileSystem fs, String path) {
		String[] splitPath = path.split(Character
				.toString(org.eclipse.core.runtime.Path.SEPARATOR));
		Object[] pathParts = Arrays.stream(splitPath).filter( s -> !s.isEmpty() ).toArray();
		if (pathParts.length > 1) {
			return fs.getPath((String) pathParts[1],
					Arrays.copyOfRange(pathParts, 2, pathParts.length, String[].class));
		}
		return fs.getPath(".");
	}

}
