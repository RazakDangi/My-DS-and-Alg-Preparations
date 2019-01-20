package lru;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestMaps {

	public static void main(String[] args) {
		
		LRUCache<Integer, String> cache=new LRUCache<>(5);
		
		IntStream.rangeClosed(1, 10)
				.forEach(i->cache.put(i, "Hi"+i));
		System.out.println(cache.values());
		
		Map<Integer, String> linkedHashMap=new LinkedHashMap<>(5);
		IntStream.rangeClosed(1, 5)
		.forEach(i->linkedHashMap.put(i, "Hi"+i));
		
		System.out.println(linkedHashMap.values());
		
		
		Map<Integer,String> treeMap=new TreeMap<Integer,String>();
		IntStream.rangeClosed(1, 5)
		.forEach(i->treeMap.put(i, "Hi"+i));
		
		System.out.println(treeMap.values());
		
		Map<Integer,String> hashMap=new HashMap<Integer,String>(5);
		IntStream.rangeClosed(1, 5)
		.forEach(i->hashMap.put(i, "Hi"+i));
		
		
		System.out.println(hashMap.values());
		
		cache.put(9, "Hi9");
		cache.put(12, "Hi12");
		cache.get(1);
		cache.get(8);
		
		System.out.println(cache.values());
		

	}

}
