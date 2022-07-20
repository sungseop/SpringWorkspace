package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	
	// ���ϰ�:
	// Object: ����Ͻ� ���� ������ ��� return���� ȣ���� ������ �����ϱ� ���� ���
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE] ����Ͻ� �޼ҵ� ���� �� ó�� ����...");
		
		// ����Ͻ� ���� ȣ�� �� ���ϰ� ��ȯ
		Object returnObj = pjp.proceed();
		
		System.out.println("[AFTER] ����Ͻ� �޼ҵ� ���� �� ó�� ����...");
		return returnObj;
	}
}
