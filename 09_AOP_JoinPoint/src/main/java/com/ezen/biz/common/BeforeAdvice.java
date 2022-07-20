package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class BeforeAdvice {

		public void beforeLog(JoinPoint jp) {
			// ����ó�� �޼ҵ��� ����� ������ ���´�.
			Signature sig = jp.getSignature();
			
			String method = sig.getName();
			Object[] args = jp.getArgs();
			
			System.out.println("\n[���� ó��] ����Ͻ� ���� ���� �� ó��...");
			if(args.length == 0) { // ����Ͻ� ���� ȣ��� �Ű������� ����.
				System.out.printf("�޼ҵ��: %s\n", method);
				System.out.printf("�Ű�����: ����.\n");
			} else {
				System.out.printf("�޼ҵ��: %s\n", method);
				System.out.printf("�Ű�����: %s\n", args[0].toString());
			}
			
		}
}
