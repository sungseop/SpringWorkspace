package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {
	//@Pointcut("execution(* com.ezen.biz..*Impl.get*(..))")
	//public void getPointcut() { }
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();  // ȣ���� ����Ͻ� �޼ҵ� �̸�
		
		System.out.println("[���� ó��] ����Ͻ� ���� ���� �� �۾�...");
		System.out.printf("[���� ó��] %s() ���ϰ�:%s\n", method, returnObj.toString());	
	}
}
