package com.donnglin.concurrent.thread;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StatelessFactorizer implements Servlet {
	
	private final AtomicLong count = new AtomicLong(0);
	
	public long getCount(){ return count.get();}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//BigInteger i = extractFromRequest(req);
		count.incrementAndGet();
		//Vector
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
