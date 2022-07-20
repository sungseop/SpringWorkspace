package com.ezen.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO boardDao = new BoardDAO();
		List<BoardVO> boardList = boardDao.getBoardList();
		
		// �˻� ����� request��ü�� �����ϰ� �Խ��� ����� ȣ��
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("boardList", boardList);
		modelView.setViewName("getBoardList");
		
		return modelView;
	}

}
