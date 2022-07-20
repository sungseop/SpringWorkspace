package com.ezen.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.biz.dto.MemberVO;
import com.ezen.biz.dto.QnaVO;
import com.ezen.biz.qna.QnaService;

@Controller
public class QnaController {

	@Autowired
	QnaService qnaService;
	
	/*
	 * id를 조건으로 QnA 목록 조회
	 */
	@RequestMapping(value="/qna_list", method=RequestMethod.GET)
	public String qnaList(HttpSession session, Model model) {
		
		// 세션에 사용자 정보가 저장되어 있는지 확인(로그인 여부 확인)
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			
			return "member/login";
		} else {
			
			List<QnaVO> qnaList = qnaService.getListQna(loginUser.getId());
			
			model.addAttribute("qnaList", qnaList);
			
			return "qna/qnaList";
		}
	}
	
	/*
	 * QnA 게시글 상세보기
	 */
	@RequestMapping(value="/qna_view", method=RequestMethod.GET)
	public String qnaView(QnaVO vo, HttpSession session, Model model) {
		// 세션에 사용자 정보가 저장되어 있는지 확인(로그인 여부 확인)
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			
			return "member/login";
		} else {
			QnaVO qna = qnaService.getQna(vo.getQseq());
			model.addAttribute("qnaVO", qna);
			
			return "qna/qnaView";
		}
	}
	
	/*
	 * Q&A 게시글 쓰기 폼 출력 
	 */
	@RequestMapping(value="qna_write_form", method=RequestMethod.GET)
	public String qnaWriteView(HttpSession session) {

		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if (loginUser == null) {
			
			return "member/login";
		} else {
			return "qna/qnaWrite";
		}
	}
	
	/*
	 * Qna 글쓰기 처리
	 */
	@RequestMapping(value="qna_write", method=RequestMethod.POST)
	public String qnaWriteAction(QnaVO vo, HttpSession session) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if (loginUser == null) {
			
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			qnaService.insertQna(vo);
			
			return "redirect:qna_list";
		}
	}
	
	
}















