package com.ezen.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container
			= new GenericXmlApplicationContext("applicationContext.xml");

		UserService userService = (UserService) container.getBean("userService");
		
		UserVO user = new UserVO();
		user.setId("sslee");
		user.setPassword("1234");
		
		UserVO result = userService.getUser(user);
		if (result != null) {
			System.out.println("�α��ο� �����Ͽ����ϴ�.");
		} else {
			System.out.println("�α����� �����Ͽ����ϴ�.");
		}
		
		container.close();
	}

}
