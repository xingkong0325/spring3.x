package com.donnglin.concurrent.thread;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class PeimeGenerator implements Runnable {
	@GuardedBy("this")
	private final List<BigInteger> primes = new ArrayList<BigInteger>();
	private volatile boolean cancelled;
	
	public void run() {
		BigInteger p = BigInteger.ONE;
		while(!cancelled){
			p = p.nextProbablePrime();
			synchronized(this){
				primes.add(p);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void cancel(){
		cancelled = true;
	}
	
	public synchronized List<BigInteger> get(){
		return new ArrayList<BigInteger>(primes);
	}
	
	List<BigInteger> aSecondOfPrimes() throws InterruptedException{
		PeimeGenerator generator = new PeimeGenerator();
		new Thread(generator).start();
		try {
			Thread.sleep(1000);
		} finally {
			generator.cancel();
		}
		return generator.get();
	}
	
	public static void main(String[] args) throws InterruptedException{
		List<BigInteger> primes = new PeimeGenerator().aSecondOfPrimes();
		System.out.println(primes);
	}
}
