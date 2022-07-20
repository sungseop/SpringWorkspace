package com.ezen.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.BoardDAOSpring;
import com.ezen.biz.dto.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAOSpring bDao;
	// 비지니스 모듈에서 로깅처리를 위한 객체 선언
	//private LogAdvice log;
	//private Log4jAdvice log;
	
	public BoardServiceImpl() {
		//log = new LogAdvice();
		//log = new Log4jAdvice();
	}
	
	@Override
	public void insertBoard(BoardVO board) {
		//log.printLog();
		//log.printLogging();
		
		// 강제로 예외 발생시킴.
		/*
		if (board.getSeq()==0) {
			throw new IllegalArgumentException("0번 글을 등록할 수 없습니다.");
		}
		*/
		bDao.insertBoard(board);
		//bDao.insertBoard(board);  // 트랜잭션 처리 연습
		
	}
	
	@Override
	public void updateBoard(BoardVO board) {
		//log.printLog();
		//log.printLogging();
		bDao.updateBoard(board);
	}
	
	@Override
	public void deleteBoard(BoardVO board) {
		//log.printLog();
		//log.printLogging();
		bDao.deleteBoard(board);
	}
	
	@Override
	public List<BoardVO> getBoardList() {
		//log.printLog();
		//log.printLogging();
		return bDao.getBoardList();
	}
	
	@Override
	public BoardVO getBoard(BoardVO board) {
		//log.printLog();
		//log.printLogging();
		return bDao.getBoard(board);
	}
}






