package com.ezen.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Controller
public class GetBoardController {
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDao, ModelAndView modelView) {

		BoardVO board = boardDao.getBoard(vo);
		
		// ���� ȭ�鱸��
		modelView.addObject("board", board);
		modelView.setViewName("getBoard.jsp");
		
		return modelView;
	}

}
