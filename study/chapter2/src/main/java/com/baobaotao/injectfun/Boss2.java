package com.baobaotao.injectfun;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

import com.baobaotao.ditype.Car;

public class Boss2 implements MethodReplacer {

	public Object reimplement(Object obj, Method method, Object[] args)
			throws Throwable {
		Car car = new Car();
		car.setBrand("美人豹");
		return car;
	}

}
