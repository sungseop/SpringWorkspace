package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		
		System.out.printf("[예외 처리] %s() 수행 중 예외 발생: %s\n", method, exceptObj.getMessage());
	}
}
