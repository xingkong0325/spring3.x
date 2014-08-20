package com.baobaotao.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baobaotao.reflect.Car;

@Configuration
public class Beans {
	
	@Bean(name="car")
	public Car bulidCar(){
		Car car = new Car();
		car.setBrand("宝马X6");
		car.setColor("黑色");
		car.setMaxSpeed(300);
		return car;
	}

}
