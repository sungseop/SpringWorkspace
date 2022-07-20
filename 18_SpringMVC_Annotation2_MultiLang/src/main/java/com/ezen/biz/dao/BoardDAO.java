﻿package com.ezen.biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// SQL 占쏙옙占?
	private final static String BOARD_INSERT 
			= "INSERT INTO board(seq, title, writer, content) VALUES(board_seq.NEXTVAL, ?, ?, ?)";
	private final static String BOARD_UPDATE
			= "UPDATE board SET title=?, writer=?, content=? WHERE seq=?";
	private final static String BOARD_DELETE
			= "DELETE board WHERE seq=?";
	private final static String BOARD_GET
			= "SELECT * FROM board WHERE seq=?";
	//private final static String BOARD_LIST	
	//		= "SELECT * FROM board ORDER BY seq DESC";
	// 제목을 조건으로 게시글 목록 조회
	private final static String BOARD_LIST_T 
			= "SELECT * FROM board WHERE title LIKE '%'||?||'%' ORDER BY seq DESC";
	// 내용을 조건으로 게시글 목록 조회
	private final static String BOARD_LIST_C 
			= "SELECT * FROM board WHERE content LIKE '%'||?||'%' ORDER BY seq DESC";
	
	// 占쌉시깍옙 占쏙옙체 占쏙옙占?占쏙옙회
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> boardList = null;
		System.out.println("===> JDBC에서 getBoardList() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			if (vo.getSearchCondition().equals("TITLE")) {
				pstmt = conn.prepareStatement(BOARD_LIST_T);
			} else if (vo.getSearchCondition().equals("CONTENT")) {
				pstmt = conn.prepareStatement(BOARD_LIST_C);
			}
			pstmt.setString(1, vo.getSearchKeyword());  // 검색어를 SQL에 바인딩
			
			rs = pstmt.executeQuery();
			
			boardList = new ArrayList<>();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regDate"));
				board.setCnt(rs.getInt("cnt"));
				
				boardList.add(board);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return boardList;
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC에서 getBoard() 기능 처리");
		BoardVO board = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardVO();
				
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regDate"));
				board.setCnt(rs.getInt("cnt"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return board;
		
	}
	
	public void insertBoard(BoardVO board) {
		System.out.println("===> JDBC에서 insertBoard() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}	
	}
	
	public void updateBoard(BoardVO board) {
		System.out.println("===> JDBC에서 updateBoard() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getSeq());
			
			pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	public void deleteBoard(BoardVO board) {
		System.out.println("===> JDBC에서 deleteBoard() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, board.getSeq());
			
			pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
}









