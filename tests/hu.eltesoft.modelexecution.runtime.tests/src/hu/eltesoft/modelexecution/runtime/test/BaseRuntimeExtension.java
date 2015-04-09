package hu.eltesoft.modelexecution.runtime.test;

import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader;
import hu.eltesoft.modelexecution.runtime.trace.Tracer;

final class BaseRuntimeExtension extends BaseRuntime {
	BaseRuntimeExtension(Tracer tracer, TraceReader traceReader,
			Logger logger) {
		super(tracer, traceReader, logger);
	}
}