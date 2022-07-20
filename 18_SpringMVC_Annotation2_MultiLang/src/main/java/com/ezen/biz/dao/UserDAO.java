﻿package com.ezen.biz.dao;

import java.sql.*;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.UserVO;

@Service("userDao")
public class UserDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private final static String USER_GET 
		= "SELECT * FROM users WHERE id=? AND password=?";
	
	// 占쏙옙占쏙옙占?占쏙옙회
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return user;
	}
	
}
