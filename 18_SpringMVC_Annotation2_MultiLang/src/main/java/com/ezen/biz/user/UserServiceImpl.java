package com.ezen.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

@Service("userService")	// (2) 어노테이션 방식으로 구현시 필요
public class UserServiceImpl implements UserService {
	@Autowired  // (2) 어노테이션 방식으로 구현시 필요
	private UserDAO userDAO;
	
	@Override
	public UserVO getUser(UserVO vo) {
		
		return userDAO.getUser(vo);
	}

	@Override
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
