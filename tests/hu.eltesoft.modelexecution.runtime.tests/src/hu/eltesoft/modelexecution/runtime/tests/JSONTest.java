package hu.eltesoft.modelexecution.runtime.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class JSONTest {

	@Test
	public void testArrayList() throws Exception {
		JSONObject obj = new JSONObject();
		ArrayList<String> original = new ArrayList<>();
		original.add("aaa");
		original.add("bbb");
		obj.put("list", original);
		JSONObject deserialized = seralizeDeserialize(obj);
		JSONArray jsonArray = deserialized.getJSONArray("list");
		ArrayList<String> actual = new ArrayList<>();
		for (int i = 0; i < jsonArray.length(); i++) {
			actual.add((String) jsonArray.get(i));
		}
		assertEquals(original, actual);
	}

	@Test
	public void testHashSet() throws Exception {
		JSONObject obj = new JSONObject();
		HashSet<String> original = new HashSet<>();
		original.add("aaa");
		original.add("bbb");
		obj.put("set", original);
		JSONObject deserialized = seralizeDeserialize(obj);
		JSONArray jsonArray = deserialized.getJSONArray("set");
		HashSet<String> actual = new HashSet<>();
		for (int i = 0; i < jsonArray.length(); i++) {
			actual.add((String) jsonArray.get(i));
		}
		assertEquals(original, actual);
	}
	
	@Test
	public void testMultiset() throws Exception {
		JSONObject obj = new JSONObject();
		Multiset<String> original = HashMultiset.create();
		original.add("aaa");
		original.add("bbb");
		obj.put("set", original);
		JSONObject deserialized = seralizeDeserialize(obj);
		JSONArray jsonArray = deserialized.getJSONArray("set");
		Multiset<String> actual = HashMultiset.create();
		for (int i = 0; i < jsonArray.length(); i++) {
			actual.add((String) jsonArray.get(i));
		}
		assertEquals(original, actual);
	}

	private JSONObject seralizeDeserialize(JSONObject obj) {
		String serialized = obj.toString();
		JSONTokener tokener = new JSONTokener(serialized);
		JSONObject deserialized = new JSONObject(tokener);
		return deserialized;
	}
	
}
