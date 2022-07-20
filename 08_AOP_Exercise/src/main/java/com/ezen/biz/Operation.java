package com.ezen.biz;

import org.springframework.stereotype.Component;

/*
 * 비즈니스 처리 로직
 */
@Component("opBean")
public class Operation {
	public void message() {
		System.out.println("message() 메소드 호출됨.");
	}
	
	public int m() {
		System.out.println("m() 메소드 호출됨.");
		return 2;
	}
	
	public int k() {
		System.out.println("k() 메소드 호출됨.");
		return 3;
	}
	
	public void throwException() {
		throw new RuntimeException("예외 발생...");
	}
}
