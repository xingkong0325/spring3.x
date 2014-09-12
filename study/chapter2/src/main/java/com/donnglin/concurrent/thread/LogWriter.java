package com.donnglin.concurrent.thread;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LogWriter {
	
	private final BlockingQueue<String> queue;
	private final LoggerThread logger;
	
	public LogWriter(Writer writer){
		queue = new LinkedBlockingQueue<String>(100);
		logger = new LoggerThread(writer);
	}
	
	public void start(){
		logger.start();
	}
	
	public void log(String msg) throws InterruptedException{
		queue.put(msg);
	}
	
	private class LoggerThread extends Thread {
		private PrintWriter writer;

		public LoggerThread(Writer writer) {
			
		}

		@Override
		public void run() {
			try {
				while(true)
					writer.println(queue.take());
			} catch (InterruptedException e) {
				
			} finally {
				writer.close();
			}
		}
		
	}
 
}
