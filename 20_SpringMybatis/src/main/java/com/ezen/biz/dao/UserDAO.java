package com.ezen.biz.dao;

import java.sql.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.ezen.biz.dto.UserVO;

//@Repository("userDao")
public class UserDAO extends SqlSessionDaoSupport {
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	// 사용자 인증
	public UserVO getUser(UserVO vo) {
		System.out.println("==> Mybatis로 사용자 인증 조회...");
		
		return getSqlSession().selectOne("userMapper.getUser", vo);
	}
	
}
