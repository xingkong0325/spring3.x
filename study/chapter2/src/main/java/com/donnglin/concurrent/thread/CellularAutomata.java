package com.donnglin.concurrent.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class CellularAutomata {
	
	private final Board mainBoard;
	private final CyclicBarrier barrier;
	private final Worker[] workers;
	
	public CellularAutomata(Board board){
		this.mainBoard = board;
		int count = Runtime.getRuntime().availableProcessors();
		this.barrier = new CyclicBarrier(count, new Runnable(){
			public void run() {
				mainBoard.commitNewValues();
			}
		});
		this.workers = new Worker[count];
		for(int i=0; i<count; i++)
			workers[i] = new Worker(mainBoard.getSubBoard(count, i));
	}
	
	private class Worker implements Runnable{

		private final Board board;
		
		public Worker(Board board){this.board = board;}
		
		public void run() {
			while(!board.hasConverged()){
				try {
					barrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

class Board{

	public void commitNewValues() {
		
	}

	public Board getSubBoard(int count, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasConverged() {
		return false;
	}
}