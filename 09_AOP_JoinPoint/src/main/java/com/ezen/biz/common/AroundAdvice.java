package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	
	// 리턴값:
	// Object: 비즈니스 로직 수행한 결과 return값을 호출한 쪽으로 전달하기 위해 사용
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		// 메소드 실행시간 측정을 위한 객체 생성
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start(); // 비즈니스 메소드 시작 시간 측정
				
		// 비즈니스 로직 호출 후 리턴값 반환
		Object returnObj = pjp.proceed();
		
		stopWatch.stop(); // 비즈니스 메소드 종료 시간 측정
		
		System.out.printf("메소드명: %s 수행에 걸린 시간: %d(ms)\n", method, stopWatch.getTotalTimeMillis());
		
		return returnObj;
	}
}
