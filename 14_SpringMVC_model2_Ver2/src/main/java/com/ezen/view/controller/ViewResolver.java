package com.ezen.view.controller;

public class ViewResolver {
	private String prefix; // view 이름 앞에 붙여지는 경로를 저장
	private String suffix; // view 확장자를 저장
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	// 응답을 보낼 view를 return하는 메소드
	public String getView(String viewName) {
		
		return prefix + viewName + suffix;
	}
}
