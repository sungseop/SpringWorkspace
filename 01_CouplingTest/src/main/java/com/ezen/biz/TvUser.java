package com.ezen.biz;

public class TvUser {

	public static void main(String[] args) {
		/*
		SamsungTV tv = new SamsungTV();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		*/
		
		// tv ��ü�� SamsungTV���� LgTV�� �ٲ� ��� ��ü ������ �޼ҵ� ȣ�� ��� ���� �ʿ�
		LgTV tv = new LgTV();
		
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
	}
}