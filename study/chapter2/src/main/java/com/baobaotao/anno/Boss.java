package com.baobaotao.anno;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.baobaotao.anno.Car;

@Component
public class Boss {
	private Car car;
	
	public Boss(){
		System.out.println("construct..");
	}

	public Car getCar() {
		return car;
	}
	
	@Autowired
	@Qualifier("car")
	public void setCar(Car car) {
		System.out.println("execute in setCar");
		this.car = car;
	}
	
	@PostConstruct
	private void init1(){
		System.out.println("execute in init1");
	}
	
	@PostConstruct
	private void init2(){
		System.out.println("execute in init2");
	}
	
	@PreDestroy
	private void destory2(){
		System.out.println("execute in destory2");
	}
	
	@PreDestroy
	private void destory1(){
		System.out.println("execute in destory1");
	}
}
