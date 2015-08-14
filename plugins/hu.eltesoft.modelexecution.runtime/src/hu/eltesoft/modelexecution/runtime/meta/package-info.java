/**
 * This package contains meta-representation of Classes to support debugging.
 * This is a pretty lightweight solution, may be changed in the future if the
 * representation needs to be more complex.
 * 
 * Some of this meta-representation can
 * be serialized and deserialized into a String to transport the whole
 * representation from the jvm to the eclipse host. This serialization is a
 * simple json-based one and only works when the meta-representation is a tree.
 */
package hu.eltesoft.modelexecution.runtime.meta;