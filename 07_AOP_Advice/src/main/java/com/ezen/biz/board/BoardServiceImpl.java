package com.ezen.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO bDao;
	
	// 비즈니스 모듈에서 로깅처리를 위한 객체 선언
	//private LogAdvice log;
	//private Log4jAdvice log;
	
	public BoardServiceImpl() {
		//log = new LogAdvice();
		//log = new Log4jAdvice();
	}
	
	@Override
	public void insertBoard(BoardVO board) {
		//log.printLog();
		//log.printLoggin();
		
		/* 강제로 예외 발생시킴
		if(board.getSeq()==0) {
			throw new IllegalArgumentException("0번 글을 등록할 수 없습니다.");
		}
		*/
		bDao.insertBoard(board);
	}
	
	@Override
	public void updateBoard(BoardVO board) {
		//log.printLog();
		//log.printLoggin();
		bDao.updateBoard(board);
	}
	
	@Override
	public void deleteBoard(BoardVO board) {
		//log.printLog();
		//log.printLoggin();
		bDao.deleteBoard(board);
	}
	
	@Override
	public List<BoardVO> getBoardList() {
		//log.printLog();
		//log.printLoggin();
		return bDao.getBoardList();
	}
	
	@Override
	public BoardVO getBoard(BoardVO board) {
		//log.printLog();
		//log.printLoggin();
		return bDao.getBoard(board);
	}
}
