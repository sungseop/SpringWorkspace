package com.ezen.biz;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {	
	}

	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV--������ �Ҵ�.");
		System.out.println("price = " + price);
	}
	
	@Override
	public void powerOff() {
		System.out.println("SamsungTV--������ ����.");
	}
	
	@Override
	public void volumeUp() {
		//System.out.println("SamsungTV--�Ҹ��� �ø���.");
		speaker.volumeUp();
	}
	
	@Override
	public void volumeDown() {
		//System.out.println("SamsungTV--�Ҹ��� ������.");
		speaker.volumeDown();
	}
}