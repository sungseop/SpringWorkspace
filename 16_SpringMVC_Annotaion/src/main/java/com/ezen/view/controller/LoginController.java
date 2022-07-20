package com.ezen.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDao) {

		UserVO user = userDao.getUser(vo);
		
		// ȭ�� ���� ó��		
		if (user != null) { // �α��� ������ ���
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
		
	}

}
