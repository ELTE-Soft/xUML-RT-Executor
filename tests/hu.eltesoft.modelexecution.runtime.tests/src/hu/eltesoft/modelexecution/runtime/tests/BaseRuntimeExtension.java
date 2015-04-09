package hu.eltesoft.modelexecution.runtime.tests;

import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader;
import hu.eltesoft.modelexecution.runtime.trace.Tracer;

public final class BaseRuntimeExtension extends BaseRuntime {
	BaseRuntimeExtension(Tracer tracer, TraceReader traceReader,
			Logger logger) {
		super(tracer, traceReader, logger);
	}
}