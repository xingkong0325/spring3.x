package com.donnglin.concurrent.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.annotation.GuardedBy;

public class Memoizer2<A, V> implements Computable<A, V> {
	@GuardedBy("this")
	private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
	private final Computable<A, V> c;
	
	public Memoizer2(Computable<A, V> c){this.c = c;}

	public V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if(result == null){
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}

}
