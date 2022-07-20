package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName(); // 호출할 비즈니스  메소드 이름
		
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 작업...");
		System.out.printf("[사후 처리] %s() 리턴값: %s\n", method, returnObj.toString());
	}
}
