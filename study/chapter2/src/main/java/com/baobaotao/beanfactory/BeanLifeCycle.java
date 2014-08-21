package com.baobaotao.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.baobaotao.Car1;

public class BeanLifeCycle {
    private static void LifeCycleInBeanFactory(){
 	   Resource res = new ClassPathResource("com/baobaotao/beanfactory/beans.xml");	
       BeanFactory bf = new XmlBeanFactory(res);
       (new MyBeanFactoryPostProcessor()).postProcessBeanFactory((XmlBeanFactory)bf);
       //InstantiationAwareBeanPostProcessor
       ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor()); 
       //BeanPostProcessor
       ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());             
       Car1 car1 = (Car1)bf.getBean("car");
       car1.introduce();
       car1.setColor("红色");
       Car1 car2 = bf.getBean("car",Car1.class);
       car2.introduce();
       ((XmlBeanFactory)bf).destroySingletons();
    }
	public static void main(String[] args) {
		LifeCycleInBeanFactory();
	}
}
