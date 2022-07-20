package com.ezen.biz;

import org.springframework.stereotype.Component;

@Component("bose")
public class BoseSpeaker implements Speaker {
	
	public BoseSpeaker() {
		System.out.println("---> BoseSpeaker ��ü ����");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("BoseSpeaker -- �Ҹ��� �ø���.");
	}

	@Override
	public void volumeDown() {
		System.out.println("BoseSpeaker -- �Ҹ��� ������.");
	}
}