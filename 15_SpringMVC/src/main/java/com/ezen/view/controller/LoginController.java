package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDao = new UserDAO();
		UserVO user = userDao.getUser(vo);
		
		// ȭ�� ���� ó��
		ModelAndView modelView = new ModelAndView();
		if (user != null) { // �α��� ������ ���
			modelView.setViewName("redirect:getBoardList.do");
		} else {
			modelView.setViewName("login");
		}
		
		return modelView;
	}

}
