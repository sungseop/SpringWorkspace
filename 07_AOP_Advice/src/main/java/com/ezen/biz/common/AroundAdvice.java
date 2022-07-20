package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	
	// 리턴값:
	// Object: 비즈니스 로직 수행한 결과 return값을 호출한 쪽으로 전달하기 위해 사용
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE] 비즈니스 메소드 수행 전 처리 내용...");
		
		// 비즈니스 로직 호출 후 리턴값 반환
		Object returnObj = pjp.proceed();
		
		System.out.println("[AFTER] 비즈니스 메소드 수행 후 처리 내용...");
		return returnObj;
	}
}
