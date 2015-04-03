package hu.eltesoft.modelexecution.runtime.util;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.Path;

public class PathConverter {

	public static File workspaceToProjectBased(String path) {
		try {
			return new File(new File(".").getCanonicalFile().getParent() + Path.SEPARATOR + path);
		} catch (IOException e) {
			// TODO Error logging in runtime
			throw new RuntimeException(e);
		}
	}

}
