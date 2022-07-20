package com.ezen.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.UserDAO2;
import com.ezen.biz.dto.UserVO;

@Service("userService")	// (2) ������̼� ������� ������ �ʿ�
public class UserServiceImpl implements UserService {
	@Autowired  // (2) ������̼� ������� ������ �ʿ�
	//private UserDAO userDAO;
	private UserDAO2 userDAO;
	
	@Override
	public UserVO getUser(UserVO vo) {
		
		return userDAO.getUser(vo);
	}
}
