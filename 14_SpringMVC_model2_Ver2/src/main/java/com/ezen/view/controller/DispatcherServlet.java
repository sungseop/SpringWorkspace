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
   
    @Override // 서블릿 객체가 생성된 후에 자동으로 실행
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
		// (1) 브라우저에서 수신한 URI 정보를 얻는다
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path= " + path);
		
		// (2) HandlerMapping에서 path에 해당하는 Controller 검색
		Controller controller = handlerMapping.getController(path);
		
		// (3) Controller 실행
		String viewName = controller.handleRequest(request, response);
		
		// (4) ViewResolver를 통해 view 경로 완성
		String view = "";
		if(viewName.contains(".do")) { // view 이름에 .do를 포함하고 있으면 경로 완성 필요 없음
			view = viewName;
		} else {
			view = viewResolver.getView(viewName); // 그 외에는 jsp 경로를 조립
		}
		
		// (5) view 화면을 응답한다
		response.sendRedirect(view);
	}

}
