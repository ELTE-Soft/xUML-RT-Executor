package hu.eltesoft.modelexecution.ide.util;

import java.util.Arrays;

import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;

public class ClasspathUtils {

	public static void addClasspathEntry(IJavaProject javaProject,
			IClasspathEntry newSourceEntry) throws JavaModelException {
		IClasspathEntry[] classpath = javaProject.getRawClasspath();
		IClasspathEntry[] newCp = Arrays
				.copyOf(classpath, classpath.length + 1);
		newCp[newCp.length - 1] = newSourceEntry;
		javaProject.setRawClasspath(newCp, null);
	}

}
