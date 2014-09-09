package com.donnglin.concurrent.thread;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Factorizer implements Servlet {
	
	private final Computable<BigInteger, BigInteger[]> c = new Computable<BigInteger, BigInteger[]>(){
		public BigInteger[] compute(BigInteger arg){
			return factor(arg);
		}

		private BigInteger[] factor(BigInteger arg) {
			return null;
		}
	};
	private final Computable<BigInteger, BigInteger[]> cache = new Memoizer<BigInteger, BigInteger[]>(c);

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		try {
			cache.compute(BigInteger.ONE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
