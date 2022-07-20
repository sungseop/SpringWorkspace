package com.ezen.biz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.dto.UserVO;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// (1) Ŭ���̾�Ʈ ��û PATH���� ������ "/" ���� command �� �и�
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf('/'));
		System.out.println(path);
		
		// (2) path�� ���뿡 ���� ����Ͻ� ���� �б� ó��
		if(path.equals("/login.do")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDao = new UserDAO();
			UserVO user = userDao.getUser(vo);
			
			if (user != null) { // �α��� ������ ���
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.jsp");
			}
		} else if(path.equals("/getBoardList.do")) {
			BoardDAO boardDao = new BoardDAO();
			List<BoardVO> boardList = boardDao.getBoardList();
			
			// �˻������ ���ǿ� �����ϰ� �Խ��� ����� ȣ��
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		} else if(path.equals("/getBoard.do")) {
			// �Խñ� ��ȣ �Է°� ����
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDao = new BoardDAO();
			BoardVO board = boardDao.getBoard(vo);
			
			// ���� ȭ�鱸��
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
		} else if(path.equals("/insertBoard.do")) {
			// 1. ����� �Է� ���� ����
			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			// 3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/updateBoard.do")) {
			request.setCharacterEncoding("UTF-8");

			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDao = new BoardDAO();
			boardDao.updateBoard(vo);
			
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/deleteBoard.do")) {
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDao = new BoardDAO();
			boardDao.deleteBoard(vo);
			
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/logout.do")) {
			HttpSession session = request.getSession();
			session.invalidate();

			response.sendRedirect("login.jsp");
		}
	}
}









