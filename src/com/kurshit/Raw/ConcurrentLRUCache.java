package com.kurshit.Raw;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLRUCache {

	private final int maxSize;
	private ConcurrentHashMap<Object, Object> map;
	private ConcurrentLinkedQueue<Object> queue;

	public ConcurrentLRUCache(final int maxSize) {
		this.maxSize = maxSize;
		map = new ConcurrentHashMap<Object, Object>(maxSize);
		queue = new ConcurrentLinkedQueue<Object>();
	}

	/**
	 * @param key - may not be null!
	 * @param value - may not be null!
	 */
	public void put(final Object key, final Object value) {
		if (map.containsKey(key)) {
			queue.remove(key); // remove the key from the FIFO queue
		}

		while (queue.size() >= maxSize) {
			Object oldestKey = queue.poll();
			if (null != oldestKey) {
				map.remove(oldestKey);
			}
		}
		queue.add(key);
		map.put(key, value);
	}

	/**
	 * @param key - may not be null!
	 * @return the value associated to the given key or null
	 */
	public Object get(final Object key) {
		return map.get(key);
	}
}