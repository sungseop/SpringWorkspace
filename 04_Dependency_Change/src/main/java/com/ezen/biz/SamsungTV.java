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
		System.out.println("SamsungTV--전원을 켠다.");
		System.out.println("price = " + price);
	}
	
	@Override
	public void powerOff() {
		System.out.println("SamsungTV--전원을 끈다.");
	}
	
	@Override
	public void volumeUp() {
		//System.out.println("SamsungTV--소리를 올린다.");
		speaker.volumeUp();
	}
	
	@Override
	public void volumeDown() {
		//System.out.println("SamsungTV--소리를 내린다.");
		speaker.volumeDown();
	}
}