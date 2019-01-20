package lru;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * LRU cache- elements in order from least accessed to ,most accessed order
 * @author rdangi
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K,V> extends LinkedHashMap<K, V> {

	
	private static final int DEFAULT_CAPACITY = 16;
	private static final float LOAD_FACTOR = 0.75f;
	private int maxEntries;

	/**
	 * 
	 * @param maxEntries size of LRU cache
	 */
	public LRUCache(int maxEntries)
	{
		super(DEFAULT_CAPACITY, LOAD_FACTOR, true);
		this.maxEntries=maxEntries;
	}
	
	 protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
	        return this.maxEntries<this.size();
	    }
}
