package hu.eltesoft.modelexecution.cli.logger;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.log.MinimalLogger;
import hu.eltesoft.modelexecution.runtime.log.NoLogger;

/** Names for the arguments of the options. */
public enum Loggers {
	LOGGER_NONE("none", () -> new NoLogger()), LOGGER_MINIMAL("minimal", () -> new MinimalLogger());

	static final Map<String, Supplier<Logger>> LOGGERS = new HashMap<>();

	static {
		for (Loggers logger : values()) {
			LOGGERS.put(logger.name, logger.loggerFactory);
		}
	}
	
	public String name;
	public Supplier<Logger> loggerFactory;

	private Loggers(String name, Supplier<Logger> loggerFactory) {
		this.name = name;
		this.loggerFactory = loggerFactory;
	}

	public static boolean hasLoggerName(String name) {
		return LOGGERS.containsKey(name);
	}
}
