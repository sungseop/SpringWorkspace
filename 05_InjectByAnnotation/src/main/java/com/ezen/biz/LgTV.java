package com.ezen.biz;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	//@Autowired // 컨테이너에 등록된 객체를 찾아서 자동으로 할당
	//@Qualifier("bose")
	@Resource(name="jbl")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("---> LgTV 객체 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV -- 전원을 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV -- 전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}