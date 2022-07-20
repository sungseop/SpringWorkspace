package com.ezen.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.biz.board.BoardService;
import com.ezen.biz.dto.BoardVO;

@Controller
@SessionAttributes("board")   // 세션 내장 객체에 board라는 이름으로 게시글 상세정보 저장
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 게시글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println("게시글 등록 처리...");
		
		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			System.out.println("fileName="+fileName);
			uploadFile.transferTo(new File("D:\\강사방\\SpringWorkspace\\upload\\"+fileName));
		}
		
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	// 게시글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("작성자 이름: " + vo.getWriter());
		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	// 게시글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		
		boardService.deleteBoard(vo);
	
		return "getBoardList.do";
	}
	
	// 게시글 상세정보 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		
		BoardVO board = boardService.getBoard(vo);
		
		// 응답 화면구성
		// model 객체에 board 데이터가 저장됨과 동시에 세션에도 저장됨(SessionAttributes 설정시)
		model.addAttribute("board", board);   
		
		return "getBoard.jsp";
	}
	
	// 검색 조건 목록
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		
		Map<String, String> conditionMap = new LinkedHashMap<>();
		
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	
	// 게시글 목록 조회
	@RequestMapping("/getBoardList.do")
	public String getBoardList(
//			@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
//			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
					BoardVO vo, Model model) {
		
		// searchCondition, searchKeyword 기본값 설정
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		System.out.println("검색 조건: " + vo.getSearchCondition());
		System.out.println("검색 키워드:" + vo.getSearchKeyword());
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		// 검색결과를 request객체에 저장하고 게시판 목록을 호출
		model.addAttribute("boardList", boardList);

		return "getBoardList.jsp";
	}
	
	/*
	 * JSON 데이터로 변환
	 */
	@RequestMapping("/dataTransform.do")
	@ResponseBody  // 데이터를 리턴하는 어노테이션
	public List<BoardVO> dataTransform(BoardVO vo) {
		// searchCondition, searchKeyword 기본값 설정
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		return boardList;
	}
	
}








