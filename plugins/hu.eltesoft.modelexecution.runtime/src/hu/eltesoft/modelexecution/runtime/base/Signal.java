package hu.eltesoft.modelexecution.runtime.base;

import java.math.BigInteger;
import java.util.function.Consumer;

import org.json.JSONArray;

import hu.eltesoft.modelexecution.runtime.serialize.JSONSerializable;

/**
 * The base class of code generated for UML signals.
 */
public abstract class Signal implements JSONSerializable {

	@SuppressWarnings("unchecked")
	protected static <E> void forEach(JSONArray array, java.lang.Class<E> cls, Consumer<E> consumer) {
		for (int i = 0; i < array.length(); i++) {
			if (cls.equals(BigInteger.class)) {
				// ints cannot be cast to BigInteger, all the other primitive
				// types can be simply casted
				consumer.accept((E) new BigInteger(array.get(i).toString(), 10));
			} else {
				consumer.accept((E) array.get(i));
			}
		}
	}

	protected abstract String getOriginalSignalName();

	@Override
	public String toString() {
		return getOriginalSignalName();
	}

}
