package com.ezen.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex1Client {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		Operation op = (Operation)container.getBean("opBean");
		
		op.message();
		
		int result = op.m();
		System.out.println("op.m()의 실행결과는 " + result);
		
		result = op.k();
		System.out.println("op.k()의 실행결과는 " + result);
		
	}

}
