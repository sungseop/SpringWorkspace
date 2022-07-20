package com.ezen.view.controller;

import java.util.*;

public class HandlerMapping {
	// Controller ��ü�� ����ϴ� �� ���� ����
	private Map<String, Controller> mappings;
	
	// ������
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		// Controller ��ü ���
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
		
	}
	
	// ��û URL�� ���� �˸��� ����ó�� Controller�� �����Ѵ�
	public Controller getController(String path) {
		
		return mappings.get(path);
	}
}
