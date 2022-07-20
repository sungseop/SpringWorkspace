package com.ezen.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    @Override // ���� ��ü�� ������ �Ŀ� �ڵ����� ����
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
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
		// (1) ���������� ������ URI ������ ��´�
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path= " + path);
		
		// (2) HandlerMapping���� path�� �ش��ϴ� Controller �˻�
		Controller controller = handlerMapping.getController(path);
		
		// (3) Controller ����
		String viewName = controller.handleRequest(request, response);
		
		// (4) ViewResolver�� ���� view ��� �ϼ�
		String view = "";
		if(viewName.contains(".do")) { // view �̸��� .do�� �����ϰ� ������ ��� �ϼ� �ʿ� ����
			view = viewName;
		} else {
			view = viewResolver.getView(viewName); // �� �ܿ��� jsp ��θ� ����
		}
		
		// (5) view ȭ���� �����Ѵ�
		response.sendRedirect(view);
	}

}
