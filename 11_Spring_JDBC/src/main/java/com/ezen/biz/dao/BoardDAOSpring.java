package com.ezen.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

@Repository("boardDAO")
public class BoardDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL 명령어
	private final static String BOARD_INSERT 
			= "INSERT INTO board(seq, title, writer, content) VALUES(board_seq.NEXTVAL, ?, ?, ?)";
	// 트랜잭션 처리 연습
	/*
	private final static String BOARD_INSERT 
	= "INSERT INTO board(seq, title, writer, content) VALUES(?, ?, ?, ?)";
	*/
	private final static String BOARD_UPDATE
			= "UPDATE board SET title=?, writer=?, content=? WHERE seq=?";
	private final static String BOARD_DELETE
			= "DELETE board WHERE seq=?";
	private final static String BOARD_GET
			= "SELECT * FROM board WHERE seq=?";
	private final static String BOARD_LIST	
			= "SELECT * FROM board ORDER BY seq DESC";
	
	// 게시글 전체 목록 조회
	public List<BoardVO> getBoardList() {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		
		
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		
		Object[] args = {vo.getSeq()};
		
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	public void insertBoard(BoardVO board) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_INSERT, 
							board.getTitle(), board.getWriter(), board.getContent());
		
		/* 트랜잭션 처리 연습
		jdbcTemplate.update(BOARD_INSERT, 
							board.getSeq(), board.getTitle(), board.getWriter(), board.getContent());
		*/
	}
	
	public void updateBoard(BoardVO board) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_UPDATE,
							board.getTitle(), board.getWriter(), board.getContent(), board.getSeq());
	}
	
	public void deleteBoard(BoardVO board) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_DELETE, board.getSeq());
	}
	

}

/*
 * BoardVO 객체에 SQL 조회 결과를 저장하여 반환
 */
class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegDate(rs.getDate("regDate"));
		board.setCnt(rs.getInt("cnt"));
		
		return board;
	}
	
}









