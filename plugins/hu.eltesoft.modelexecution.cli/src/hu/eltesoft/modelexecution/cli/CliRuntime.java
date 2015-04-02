package hu.eltesoft.modelexecution.cli;

import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader;
import hu.eltesoft.modelexecution.runtime.trace.Tracer;

public class CliRuntime extends BaseRuntime {

	public CliRuntime(Tracer tracer, TraceReader traceReader, Logger logger) {
		super(tracer, traceReader, logger);
	}

}
