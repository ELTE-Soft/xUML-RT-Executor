package hu.eltesoft.modelexecution.validation;

import java.util.Set;

import org.eclipse.xtext.xbase.lib.Pure;

import com.google.common.collect.Sets;

public class Helpers {

	public static Set<String> JAVA_KEYWORDS = Sets.newHashSet("abstract", "continue", "for", "new", "switch", "assert",
			"default", "if", "package", "synchronized", "boolean", "do", "goto", "private", "this", "break", "double",
			"implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum",
			"instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final",
			"interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float",
			"native", "super", "while");

	public static Set<String> JAVA_LITERALS = Sets.newHashSet("true", "false", "null");

	public static Set<String> NOT_VALID_JAVA_NAMES = Sets.union(JAVA_KEYWORDS, JAVA_LITERALS);

	@Pure
	public static boolean validJavaIdentifierName(String name) {
		return !NOT_VALID_JAVA_NAMES.contains(name) && !name.isEmpty()
				&& Character.isJavaIdentifierStart(name.charAt(0))
				&& name.chars().skip(1).allMatch(Character::isJavaIdentifierPart);
	}

}
