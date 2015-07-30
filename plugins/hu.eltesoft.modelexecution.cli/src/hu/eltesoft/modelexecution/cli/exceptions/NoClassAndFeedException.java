package hu.eltesoft.modelexecution.cli.exceptions;

import java.io.File;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map;
import java.util.stream.Collectors;

import hu.eltesoft.modelexecution.cli.Messages;

public class NoClassAndFeedException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	Map<SimpleImmutableEntry<String, String>, SimpleImmutableEntry<String, String>> nameMapping;

	public NoClassAndFeedException(Map<SimpleImmutableEntry<String, String>, SimpleImmutableEntry<String, String>> nameMapping) {
		this.nameMapping = nameMapping;
	}

	@Override
	public String toString() {
		String validClassAndFeeds = nameMapping.keySet().stream().sorted().map(pair -> String.format("    (%s,%s)%n", pair.getKey(), pair.getValue())).collect(Collectors.joining());
		return Messages.NO_CLASS_AND_FEED.getMsg() + validClassAndFeeds;
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
