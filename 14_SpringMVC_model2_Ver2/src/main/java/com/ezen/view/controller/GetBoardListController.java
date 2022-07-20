package com.ezen.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO boardDao = new BoardDAO();
		List<BoardVO> boardList = boardDao.getBoardList();
		
		// �˻������ ���ǿ� �����ϰ� �Խ��� ����� ȣ��
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
	}

}
