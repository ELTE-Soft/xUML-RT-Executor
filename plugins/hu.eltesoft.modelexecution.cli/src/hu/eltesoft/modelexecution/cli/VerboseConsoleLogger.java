package hu.eltesoft.modelexecution.cli;

import java.util.Date;

public class VerboseConsoleLogger implements ConsoleLogger {
	
	private Date startTime;
	
	public VerboseConsoleLogger() {
		startTime = new Date();
	}
	
	public void verboseTimeMsg(Messages msg, String... params) {
		Object[] objParams = (Object[]) params;
		Date currentTime = new Date();
		long msecDiff = currentTime.getTime() - startTime.getTime();
		long msecPart = msecDiff % 1000;
		long secPart = msecDiff / 1000;
		System.out.printf("[%d.%03ds] %s%n", secPart, msecPart, msg.getMsg(objParams));
	}
}
