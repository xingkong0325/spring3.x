package com.baobaotao.aspectj.example;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.baobaotao.NaiveWaiter;
import com.baobaotao.Waiter;
import com.baobaotao.aspectj.anno.PreGreetingAspect;

public class AspectJProxyTest {
	public static void main(String[] args) {
		Waiter target = new NaiveWaiter();
		AspectJProxyFactory factory = new AspectJProxyFactory();
		factory.setTarget(target);
		factory.addAspect(PreGreetingAspect.class);
		Waiter proxy = factory.getProxy();
		proxy.greetTo("John");
		proxy.serveTo("John");
	}
}
