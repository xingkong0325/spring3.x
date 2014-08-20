package com.baobaotao.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.baobaotao.reflect.Car;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {
	
	public static void main(String[] args){
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res = resolver.getResource("classpath:com/baobaotao/beanfactory/beans.xml");
		BeanFactory bf = new XmlBeanFactory(res);
		Car car = bf.getBean("car", Car.class);
		car.introduce();
	}

}
