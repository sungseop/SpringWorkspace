package com.ezen.biz;

public class JBLSpeaker implements Speaker {
	
	public JBLSpeaker() {
		System.out.println("---> JBLSpeaker 객체 생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("JBLSpeaker -- 소리를 올린다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("JBLSpeaker -- 소리를 내린다.");
	}
}