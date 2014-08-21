package com.baobaotao.injectfun;

import com.baobaotao.ditype.Car;

public class Boss1 {
	public Car getCar(){
		Car car = new Car();
		car.setBrand("宝马Z4");
		return car;
	}
}
