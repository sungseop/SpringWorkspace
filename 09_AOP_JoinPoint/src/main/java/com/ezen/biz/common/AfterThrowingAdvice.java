package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		
		System.out.printf("[���� ó��] %s() ���� �� ���� �߻�: %s\n", method, exceptObj.getMessage());
	}
}
