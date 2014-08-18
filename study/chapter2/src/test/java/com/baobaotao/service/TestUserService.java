package com.baobaotao.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.domain.User;

//@RunWith(SpringJUint4ClassRunner.class)

public class TestUserService {
	
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void hasMatchUser() {
		UserService userService = (UserService)ctx.getBean("userService");
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "1111");
		assertTrue(b1);
		assertTrue(b2);
	}
	
	@Test
	public void findUserByUserName() {
		UserService userService = (UserService)ctx.getBean("userService");
		User user = userService.findUserByUserName("admin");
		assertEquals(user.getUserName(), "admin");
	}

}
