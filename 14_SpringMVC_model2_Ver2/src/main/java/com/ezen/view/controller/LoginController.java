package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDao = new UserDAO();
		UserVO user = userDao.getUser(vo);
		
		if (user != null) { // �α��� ������ ���
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}

}
