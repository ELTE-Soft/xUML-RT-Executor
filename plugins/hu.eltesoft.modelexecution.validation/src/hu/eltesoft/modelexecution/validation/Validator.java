package hu.eltesoft.modelexecution.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

public class Validator {

	private boolean incremental;
	private Set<ValidationRule> rules = new HashSet<>();

	private static Set<BaseGeneratedPatternGroup> queries = new HashSet<>();

	static {
		try {
			queries.add(General.instance());
			queries.add(Structure.instance());
			queries.add(ClassValidation.instance());
			queries.add(StateMachine.instance());
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	public static Validator create(Validator previous, ModelSet modelSet, IncQueryEngine engine) {
		if (previous != null) {
			if (!previous.incremental) {
				return previous;
			}
			previous.dispose();
		}
		try {
			return new Validator(modelSet, engine, false);
		} catch (IncQueryException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Validator createIncremental(Validator previous, ModelSet modelSet, IncQueryEngine engine) {
		if (previous != null) {
			if (previous.incremental) {
				return previous;
			}
			previous.dispose();
		}
		try {
			return new Validator(modelSet, engine, true);
		} catch (IncQueryException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Validator(ModelSet modelSet, IncQueryEngine engine, boolean incremental) throws IncQueryException {
		for (BaseGeneratedPatternGroup group : queries) {
			for (IQuerySpecification<?> spec : group.getSpecifications()) {
				ValidationRule rule = ValidationRule.create(spec, modelSet, engine, incremental);
				if (rule != null) {
					rules.add(rule);
				}
			}
		}
		prepare(engine);
	}

	private void prepare(IncQueryEngine engine) throws IncQueryException {
		for (BaseGeneratedPatternGroup group : queries) {
			group.prepare(engine);
		}
	}

	public void dispose() {
		for (ValidationRule rule : rules) {
			rule.dispose();
		}
	}

	public void validate() {
		for (ValidationRule rule : rules) {
			rule.validate();
		}
	}

	public void clear() {
		for (ValidationRule rule : rules) {
			rule.clear();
		}
	}

	public boolean isValid() {
		return rules.stream().allMatch(r -> r.isValid());
	}

}
