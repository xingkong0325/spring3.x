package com.donnglin.concurrent.thread;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class BrokenPrimeProducter extends Thread {
	
	private final BlockingQueue<BigInteger> queue;
	private volatile boolean cancelled = false;

	public BrokenPrimeProducter(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			BigInteger p = BigInteger.ONE;
			while(!cancelled)
				queue.put(p = p.nextProbablePrime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void cancel() {cancelled = true;}
	
	void consumePrimes(){
		
	}

}
