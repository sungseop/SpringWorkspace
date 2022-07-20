package com.ezen.biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TrackOperation {
	public void myadvice(JoinPoint jp) {
		System.out.println("부가 기능 수행!");
	}
	
	public void myadvice2(JoinPoint jp) {
		System.out.println("[사후 처리]부가 기능 수행!");
	}
	
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[사전 처리] 메소드 수행 전 처리내용...");
		
		Object returnObj = pjp.proceed();
		
		System.out.println("[사후 처리] 메소드 수행 후 처리내용...");
		
		return returnObj;
	}
}
