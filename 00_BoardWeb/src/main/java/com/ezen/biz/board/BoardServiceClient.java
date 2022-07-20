package com.ezen.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.BoardVO;

public class BoardServiceClient {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService boardService = (BoardService)container.getBean("boardService");
		
		// �Խñ� ���
		for(int i=0; i<10; i++) {
			BoardVO board = new BoardVO();
			board.setTitle("�Խñ� ����" + i);
			board.setWriter("�ۼ���" + i);
			board.setContent("������ ���� �Խñ��Դϴ�.");
		
			boardService.insertBoard(board);
		}
		
		// �Խñ� ��ü ��� ���
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO vo : boardList) {
			System.out.println(vo);
		}
	}
}