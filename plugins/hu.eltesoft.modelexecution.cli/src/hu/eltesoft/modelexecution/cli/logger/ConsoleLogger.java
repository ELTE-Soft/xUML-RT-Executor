package hu.eltesoft.modelexecution.cli.logger;

import hu.eltesoft.modelexecution.cli.Messages;

public interface ConsoleLogger {

	void verboseTimeMsg(Messages msg, String... params);
	
}
