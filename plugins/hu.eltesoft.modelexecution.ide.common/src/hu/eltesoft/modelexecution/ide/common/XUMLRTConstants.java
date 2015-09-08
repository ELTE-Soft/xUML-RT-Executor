package hu.eltesoft.modelexecution.ide.common;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.internal.launching.StandardVMType;
import org.eclipse.jdt.launching.JavaRuntime;

// for standard vm type
@SuppressWarnings("restriction")
public class XUMLRTConstants {

	public static final String NATURE_ID = "hu.eltesoft.modelexecution.natures.executableModelNature"; //$NON-NLS-1$

	public static final String EMDW_COMMON_NATURE_ID = "com.incquerylabs.emdw.common.nature"; //$NON-NLS-1$

	public static final String JAVA_SE_VERSION = "JavaSE-1.8"; //$NON-NLS-1$

	public static final String JAVA_COMPILER_OUTPUT_FOLDER = "bin"; //$NON-NLS-1$

	public static final IPath JRE_CONTAINER_PATH = JavaRuntime.newDefaultJREContainerPath()
			.append(StandardVMType.ID_STANDARD_VM_TYPE).append(JAVA_SE_VERSION);
	
	public final static String PROVIDER_ID = "hu.eltesoft.modelexecution.ide.project.runtimeClasspathProvider"; //$NON-NLS-1$
	
}
