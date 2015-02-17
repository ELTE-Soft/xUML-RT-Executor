package hu.eltesoft.modelexecution.m2t.smap.xtend;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SmapStringConcatenationTest.class,
		SourceMappedTemplateTest.class, SourceMappedTextTest.class })
public class AllTests {
}
