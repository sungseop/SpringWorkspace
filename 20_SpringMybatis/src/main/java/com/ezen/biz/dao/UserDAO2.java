package com.ezen.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.UserVO;

@Repository("userDao")
public class UserDAO2 {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 사용자 인증
	public UserVO getUser(UserVO vo) {
		System.out.println("==> Mybatis로 사용자 인증 조회...");
		
		return mybatis.selectOne("userMapper.getUser", vo);
	}
	
}
