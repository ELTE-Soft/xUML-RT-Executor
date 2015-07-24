package hu.eltesoft.modelexecution.cli;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Messages that are printed at some point. The names in the resource bundle
 * must be the lower case equivalents of the enum labels.
 */
public enum Messages {
	POSSIBLE_VALUES,
	DEFAULT_VALUE,
	OPTION,

	UNKNOWN_OPT_PAR,
	MISSING_ACTION_OPTIONS,
	NO_REQUIRED_OPTION_PRESENT1,
	NO_REQUIRED_OPTION_PRESENT_MANY,
	BAD_DIRECTORY,
	BAD_FILE,
	BAD_ARG_COUNT,
	DANGLING_ARG,
	RUNTIME_EXCEPTION,
	MODEL_LOAD_FAILED,
	ROOT_DIR_CREATION_FAILED,
	JAVA_FILE_SAVE_FAILED,
	FAILURE_WHILE_GENERATING_JAVA_FILES,
	INCQUERY_EXCEPTION_OCCURRED,
	JAVA_COMPILER_FAILURE,
	MISSING_JAVA_COMPILER,
	FINISHED_WITH_CODE,

	COMPILING_MODEL_TO_JAVA,
	EXECUTING_COMPILED_JAVA,
	USING_EXISTING_ROOT_DIR,
	CREATING_ROOT_DIR,
	LOADING_MODEL,
	FINISHED_RUNNING,
	GENERATING_CLASS,
	ANALYSING_MODEL,
	COMPILING_JAVA_TO_CLASS;

	private static final String BUNDLE_NAME = "messages";
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	public String getMsg(Object... args) {
		String key = name().toLowerCase();
		String format = BUNDLE.getString(key);
		return MessageFormat.format(format, args);
	}
}
