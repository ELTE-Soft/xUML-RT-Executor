package hu.eltesoft.modelexecution.cli.logger;

/** Names for the arguments of the options. */
public enum LoggerType {
	LOGGER_NONE("none"), LOGGER_MINIMAL("minimal");

	String name;

	private LoggerType(String name) {
		this.name = name;
	}
}