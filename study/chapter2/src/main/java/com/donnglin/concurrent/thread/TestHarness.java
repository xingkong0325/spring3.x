package com.donnglin.concurrent.thread;

import java.util.concurrent.CountDownLatch;

public class TestHarness {
	
	public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		for(int i=0; i<nThreads; i++){
			Thread t = new Thread(){
				@Override
				public void run() {
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException e) {}
				}			
			};
			t.start();
		}
		
		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		System.out.println(end - start);		
		return end - start;
	}
	
	public static void main(String[] args) throws InterruptedException{
		new TestHarness().timeTasks(5, new TestTask());
	}
}

class TestTask implements Runnable {

	public void run() {
		for(int i=0; i<10; i++){
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread.interrupted();
				e.printStackTrace();
			}
		}
	}
	
}
