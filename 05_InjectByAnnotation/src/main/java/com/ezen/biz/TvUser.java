package com.ezen.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		LgTV tv = (LgTV)container.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		
		container.close();
	}
}