package com.donnglin.concurrent.thread;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.http.annotation.GuardedBy;

public class LogService {
	private final BlockingQueue<String> queue;
	private final LoggerThread loggerThread;
	private final PrintWriter writer;
	@GuardedBy("this")
	private boolean isShutDown;
	@GuardedBy("this")
	private int reservations;
	
	public LogService(Writer writer){
		queue = new LinkedBlockingQueue<String>(100);
		loggerThread = new LoggerThread();
		this.writer = new PrintWriter(writer);
	}
	
	public void start(){
		loggerThread.start();
	}
	
	public void stop(){
		synchronized(this){
			isShutDown = true;
		}
		loggerThread.interrupt();
	}
	
	public void log(String msg) throws InterruptedException{
		synchronized(this){
			if(isShutDown)
				throw new IllegalStateException();
			++reservations;
		}
		queue.put(msg);
	}
	
	private class LoggerThread extends Thread {

		@Override
		public void run() {
			try {
				while(true)
					try {
						synchronized(LogService.this){
							if(isShutDown && reservations == 0)
								break;
						}
						String msg = queue.take();
						synchronized(LogService.this){
							--reservations;
						}
						writer.println(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
			} finally {
				writer.close();
			}
		}
		
	}
}
