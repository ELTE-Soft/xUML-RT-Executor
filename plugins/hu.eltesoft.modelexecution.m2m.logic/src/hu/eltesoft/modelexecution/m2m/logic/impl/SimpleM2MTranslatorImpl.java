package hu.eltesoft.modelexecution.m2m.logic.impl;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.SimpleM2MTranslator;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.generators.BehaviorGenerator;
import hu.eltesoft.modelexecution.m2m.logic.generators.ClassGenerator;
import hu.eltesoft.modelexecution.m2m.logic.generators.RegionGenerator;
import hu.eltesoft.modelexecution.m2m.logic.generators.SignalEventGenerator;
import hu.eltesoft.modelexecution.m2m.logic.generators.SignalGenerator;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ModelGenerationTaskQueue;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.EventMatcher;
import hu.eltesoft.modelexecution.uml.incquery.RegionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * Default implementation for the {@link SimpleM2MTranslator} interface.
 */
public class SimpleM2MTranslatorImpl implements SimpleM2MTranslator {

	private final IncQueryEngine engine;

	// matchers

	private final BehaviorMatcher behaviorMatcher;
	private final ClsMatcher clsMatcher;
	private final RegionMatcher regionMatcher;
	private final EventMatcher eventMatcher;
	private final SignalMatcher signalMatcher;

	// generators

	protected final BehaviorGenerator behaviorGenerator;
	protected final ClassGenerator classGenerator;
	protected final RegionGenerator regionGenerator;
	protected final SignalEventGenerator signalEventGenerator;
	protected final SignalGenerator signalGenerator;

	public SimpleM2MTranslatorImpl(IncQueryEngine engine,
			TextChangesListener listener) throws IncQueryException {
		this.engine = engine;

		this.behaviorMatcher = BehaviorMatcher.on(engine);
		this.clsMatcher = ClsMatcher.on(engine);
		this.regionMatcher = RegionMatcher.on(engine);
		this.eventMatcher = EventMatcher.on(engine);
		this.signalMatcher = SignalMatcher.on(engine);

		this.behaviorGenerator = new BehaviorGenerator(engine, listener);
		this.classGenerator = new ClassGenerator(engine, listener);
		this.regionGenerator = new RegionGenerator(engine, listener);
		this.signalEventGenerator = new SignalEventGenerator(engine, listener);
		this.signalGenerator = new SignalGenerator(engine, listener);
	}

	@Override
	public IncQueryEngine getIncQueryEngine() {
		return engine;
	}

	@Override
	public FileUpdateTaskQueue fullBuild() {
		ModelGenerationTaskQueue generationTaskQueue = new ModelGenerationTaskQueue();

		behaviorMatcher.forEachMatch((Behavior) null, match -> {
			generationTaskQueue.addNew(match.getBehavior(), behaviorGenerator);
		});
		clsMatcher.forEachMatch((Class) null, match -> {
			generationTaskQueue.addNew(match.getCls(), classGenerator);
		});
		eventMatcher.forEachMatch((SignalEvent) null, match -> {
			generationTaskQueue.addNew(match.getEvent(), signalEventGenerator);
		});
		regionMatcher.forEachMatch((Region) null, match -> {
			generationTaskQueue.addNew(match.getRegion(), regionGenerator);
		});
		signalMatcher.forEachMatch((Signal) null, match -> {
			generationTaskQueue.addNew(match.getSignal(), signalGenerator);
		});

		return generationTaskQueue.performAll();
	}
}
