package com.donnglin.concurrent.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {
	
	private static final int NTTHREADS = 100;
	private static final Executor exec = Executors.newFixedThreadPool(NTTHREADS);
	
	public static void main(String[] args) throws IOException{
		ServerSocket socket = new ServerSocket(80);
		while(true){
			final Socket connection = socket.accept();
			Runnable task = new Runnable(){
				public void run() {
					new TaskExecutionWebServer().handleRequest(connection);
				}		
			};
			exec.execute(task);
		}
	}
	
	public void handleRequest(Socket connection) {
		
	}	
}
