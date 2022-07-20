package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// �Խñ� ��ȣ �Է°� ����
		String seq = request.getParameter("seq");

		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDao = new BoardDAO();
		BoardVO board = boardDao.getBoard(vo);
		
		// ���� ȭ�鱸��
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("board", board);
		modelView.setViewName("getBoard");
		
		return modelView;
	}

}
