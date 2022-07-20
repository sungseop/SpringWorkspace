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
		
		// 화면 응답 처리		
		if (user != null) { // 로그인 성공의 경우
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
		
	}

}
