package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	//@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
	//public void allPointcut() { }
	
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		// 업무처리 메소드의 선언부 정보를 얻어온다.
		Signature sig = jp.getSignature();
		
		String method = sig.getName();
		Object[] args = jp.getArgs();
		
		System.out.println("\n[사전 처리] 비즈니스 로직 수행전 처리...");
		if (args.length == 0) {  // 비즈니스 로직 호출시 매개변수가 없음.
			System.out.printf("메소드명: %s\n", method);
			System.out.printf("매개변수: 없음.\n");
		} else {
			System.out.printf("메소드명: %s\n", method);
			System.out.printf("매개변수: %s\n", args[0].toString());
		}
	}
}
