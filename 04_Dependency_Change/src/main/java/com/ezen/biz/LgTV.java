package com.ezen.biz;

public class LgTV implements TV {
	
	public LgTV() {
		System.out.println("LgTV ��ü�� �����մϴ�.");
	}
	
	public void initMethod() {
		System.out.println("��ü �ʱ�ȭ �۾� ó��...");
	}
	
	public void destroyMethod() {
		System.out.println("��ü ���� �� ó���� ����...");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV--������ �Ҵ�.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("LgTV--������ ����.");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("LgTV--�Ҹ��� �ø���.");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("LgTV--�Ҹ��� ������.");
	}
}