package com.donnglin.concurrent.thread;

public class NoVisibility {
	
	private static boolean read;
	private static int number;
	
	private static class ReadThread extends Thread {

		@Override
		public void run() {
			while(!read){
				Thread.yield();
				System.out.println(number);
			}
		}
		
	}

	public static void main(String[] args){
		//read = true;
		new ReadThread().start();
		number = 42;
		read = true;
	}
}
