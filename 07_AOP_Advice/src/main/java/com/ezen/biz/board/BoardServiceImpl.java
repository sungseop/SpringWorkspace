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
	
	// ����Ͻ� ��⿡�� �α�ó���� ���� ��ü ����
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
		
		/* ������ ���� �߻���Ŵ
		if(board.getSeq()==0) {
			throw new IllegalArgumentException("0�� ���� ����� �� �����ϴ�.");
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
