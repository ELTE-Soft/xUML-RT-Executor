package hu.eltesoft.modelexecution.cli;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.junit.Test;

public class ResourceBundleTests {

	@Test
	public void allUsedMessagesAreInBundles() {
		allUsedMessagesAreInBundle(Messages.values(), Messages.BUNDLE);
		allUsedMessagesAreInBundle(Opt.values(), Opt.BUNDLE);
	}

	private void allUsedMessagesAreInBundle(Enum<?> values[], ResourceBundle bundle) {
		List<String> messageNames = Arrays.stream(values).map(Utils::toResourceKey).collect(Collectors.toList());
		for (String messageName : messageNames) {
			assertTrue("key " + messageName + " is not present in bundle " + bundle.getBaseBundleName(),
					bundle.containsKey(messageName));
		}
	}

	@Test
	public void allMessagesInBundlesAreInUse() {
		allMessagesInBundleAreInUse(Messages.values(), Messages.BUNDLE);
		allMessagesInBundleAreInUse(Opt.values(), Opt.BUNDLE);
	}

	private void allMessagesInBundleAreInUse(Enum<?> values[], ResourceBundle bundle) {
		List<String> messageNames = Arrays.stream(values).map(Utils::toResourceKey).collect(Collectors.toList());
		for (String messageName : Collections.list(bundle.getKeys())) {
			assertTrue("key " + messageName + " is unused from bundle " + bundle.getBaseBundleName(),
					messageNames.contains(messageName));
		}
	}
}
