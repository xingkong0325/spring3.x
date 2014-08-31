package com.baobaotao.basic.quartz;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExample {
	private Executor executor;

	public Executor getExecutor() {
		return executor;
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}
	
	public void executorTasks(){
		for(int i=0; i<6; i++){
			executor.execute(new SimpleTask("task" + i));
		}
	}
	
	public static void main(String[] args){
		ExecutorExample ee = new ExecutorExample();
		
		ee.setExecutor(Executors.newFixedThreadPool(3));
		ee.executorTasks();
	}
}

class SimpleTask implements Runnable {
	private String taskName;
	public SimpleTask(String taskName){
		this.taskName = taskName;
	}
	public void run() {
		System.out.println("do " + taskName + "... in Thread:" + Thread.currentThread().getId());
	}

}
