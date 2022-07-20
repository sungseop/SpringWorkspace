package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	
	// ���ϰ�:
	// Object: ����Ͻ� ���� ������ ��� return���� ȣ���� ������ �����ϱ� ���� ���
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		// �޼ҵ� ����ð� ������ ���� ��ü ����
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start(); // ����Ͻ� �޼ҵ� ���� �ð� ����
				
		// ����Ͻ� ���� ȣ�� �� ���ϰ� ��ȯ
		Object returnObj = pjp.proceed();
		
		stopWatch.stop(); // ����Ͻ� �޼ҵ� ���� �ð� ����
		
		System.out.printf("�޼ҵ��: %s ���࿡ �ɸ� �ð�: %d(ms)\n", method, stopWatch.getTotalTimeMillis());
		
		return returnObj;
	}
}
