package com.ezen.biz;

public class JBLSpeaker implements Speaker {
	
	public JBLSpeaker() {
		System.out.println("---> JBLSpeaker ��ü ����");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("JBLSpeaker -- �Ҹ��� �ø���.");
	}

	@Override
	public void volumeDown() {
		System.out.println("JBLSpeaker -- �Ҹ��� ������.");
	}
}