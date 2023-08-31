package org.galapagos.ex5;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextSetServlet
 */
@WebServlet("/contextset")
public class ContextSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// 속성값 설정
		String name = "홍길동";
		int age = 20;
		
		// attribute(key(속성명), value(속성값)); 1개씩 취급
		ServletContext sc = getServletContext();
		sc.setAttribute("name", name);
		sc.setAttribute("age", age);
	
	
	}

}
