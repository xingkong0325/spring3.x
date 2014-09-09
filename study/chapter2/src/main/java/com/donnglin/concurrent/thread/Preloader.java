package com.donnglin.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Preloader {
	
	private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>(){

		public ProductInfo call() throws Exception {
			return loadProductInfo();
		}		
	});
	
	private final Thread thread = new Thread(future);
	
	public void start(){ thread.start();}
	
	private ProductInfo loadProductInfo() {
		return null;
	}
	
	public ProductInfo get() throws InterruptedException{
		try {
			return future.get();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
}

class ProductInfo{
	
}