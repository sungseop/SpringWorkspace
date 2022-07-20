package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	//@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
	//public void allPointcut() {}
	
	// ���ϰ�:
	// Object: ����Ͻ� ���� ������ ��� return���� ȣ���� ������ �����ϱ� ���� ���
	@Around("PointcutCommon.allPointcut()")
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
