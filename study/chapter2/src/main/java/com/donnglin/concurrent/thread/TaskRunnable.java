package com.donnglin.concurrent.thread;

import java.util.concurrent.BlockingQueue;

import com.sun.jmx.snmp.tasks.Task;

public class TaskRunnable implements Runnable {
	
	BlockingQueue<Task> queue;

	public void run() {
		try {
			peocessTask(queue.take());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private void peocessTask(Task take) {
		
	}

}
