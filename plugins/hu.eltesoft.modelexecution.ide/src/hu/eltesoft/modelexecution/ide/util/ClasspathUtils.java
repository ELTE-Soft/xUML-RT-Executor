package hu.eltesoft.modelexecution.ide.util;

import java.util.Arrays;
import java.util.LinkedList;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;

public class ClasspathUtils {

	public static void addClasspathEntry(IJavaProject javaProject, IClasspathEntry newSourceEntry)
			throws JavaModelException {
		IClasspathEntry[] classpath = javaProject.getRawClasspath();
		IClasspathEntry[] newCp = Arrays.copyOf(classpath, classpath.length + 1);
		newCp[newCp.length - 1] = newSourceEntry;
		javaProject.setRawClasspath(newCp, null);
	}

	public static void removeClasspathEntry(IJavaProject javaProject, IPath removedSourcePath)
			throws JavaModelException {
		LinkedList<IClasspathEntry> remainingCp = new LinkedList<>();
		IClasspathEntry[] classpath = javaProject.getRawClasspath();
		for (IClasspathEntry cpEntry : classpath) {
			if (!cpEntry.getPath().equals(removedSourcePath)) {
				remainingCp.add(cpEntry);
			}
		}
		javaProject.setRawClasspath(remainingCp.toArray(new IClasspathEntry[remainingCp.size()]), null);
	}

}
