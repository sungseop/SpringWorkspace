package com.ezen.biz;

public class BoseSpeaker implements Speaker {
	
	// ������
	public BoseSpeaker() {
		System.out.println("---> BoseSpeaker ��ü ����");
	}
	
	public void volumeUp() {
		System.out.println("BoseSpeaker -- �Ҹ��� �ø���.");
	}
	
	public void volumeDown() {
		System.out.println("BoseSpeaker -- �Ҹ��� ������.");
	}
}