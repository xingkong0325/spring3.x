package com.baobaotao.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.baobaotao.Car1;

public class XmlApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/baobaotao/context/*.xml");
		Car1 car1 = ctx.getBean("car",Car1.class);
//		ctx = new FileSystemXmlApplicationContext("D:/masterSpring/chapter3/src/com/baobaotao/context/*.xml");
//		Car car2 = ctx.getBean("car",Car.class);
	}
}
