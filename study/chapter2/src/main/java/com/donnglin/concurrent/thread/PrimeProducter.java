package com.donnglin.concurrent.thread;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeProducter extends Thread {
	
	private final BlockingQueue<BigInteger> queue;

	public PrimeProducter(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			BigInteger p = BigInteger.ONE;
			while(!Thread.currentThread().isInterrupted())
				queue.put(p = p.nextProbablePrime());
		} catch (InterruptedException e) {
			//准许线程退出
		}
	}
	
	public void cancel() {interrupt();}
}
