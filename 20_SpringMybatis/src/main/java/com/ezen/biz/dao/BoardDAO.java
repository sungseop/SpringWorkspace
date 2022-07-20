package com.ezen.biz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

//@Repository("boardDAO")
public class BoardDAO extends SqlSessionDaoSupport {
	
	/*
	 * 부모 클래스의 세션 생성 메소드를 호출하여
	 * 데이터베이스에 연결할 세션을 생성
	 */
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	// 게시글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoardList() 처리...");
		return getSqlSession().selectList("boardMapper.getBoardList", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoard() 기능 처리...");
		
		return getSqlSession().selectOne("boardMapper.getBoard", vo);
	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 insertBoard() 기능 처리");
		
		getSqlSession().insert("boardMapper.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 updateBoard() 기능 처리");
		
		getSqlSession().update("boardMapper.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 deleteBoard() 기능 처리");
		
		getSqlSession().delete("boardMapper.deleteBoard", vo);
	}
}









