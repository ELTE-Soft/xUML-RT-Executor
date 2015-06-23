package hu.eltesoft.modelexecution.runtime.external;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Attaches meta-information to external entity skeleton classes. This
 * information will be used to lookup an implementation instance from a
 * behavior's generated code.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExternalEntity {

	String implementationClass();

	ExternalEntityType type();
}
