package com.baobaotao.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baobaotao.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class TestUserService {
	
	//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	@Autowired
	private UserService userService;

	@Test
	public void hasMatchUser() {
		//UserService userService = (UserService)ctx.getBean("userService");
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "1111");
		assertTrue(b1);
		assertTrue(b2);
	}
	
	@Test
	public void findUserByUserName() {
		//UserService userService = (UserService)ctx.getBean("userService");
		User user = userService.findUserByUserName("admin");
		assertEquals(user.getUserName(), "admin");
	}

}
