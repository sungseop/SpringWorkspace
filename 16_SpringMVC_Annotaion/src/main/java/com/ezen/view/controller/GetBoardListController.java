package com.ezen.view.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Controller
public class GetBoardListController {
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDao, ModelAndView modelView) {
		List<BoardVO> boardList = boardDao.getBoardList();
		
		// �˻� ����� request��ü�� �����ϰ� �Խ��� ����� ȣ��
		modelView.addObject("boardList", boardList);
		modelView.setViewName("getBoardList.jsp");
		
		return modelView;
	}

}
