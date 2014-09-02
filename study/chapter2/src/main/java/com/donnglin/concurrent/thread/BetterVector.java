package com.donnglin.concurrent.thread;

import java.util.Vector;

public class BetterVector<E> extends Vector<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public synchronized boolean putIfAbsent(E x){
		boolean absent = ! contains(x);
		if(absent)
			add(x);
		return absent;
	}
}
