package com.baobaotao.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/baobaotao/anno/beans.xml");
		((ClassPathXmlApplicationContext)ctx).destroy();
	}

}
