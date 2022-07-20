package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		if(args != null) {
			System.out.printf("[���� ó��] �޼ҵ��: %s(), Args: %s\n", method, args[0].toString());
		} else {
			System.out.printf("[���� ó��] �޼ҵ��: %s(), Args: ����\n", method);
		}
	}
}
