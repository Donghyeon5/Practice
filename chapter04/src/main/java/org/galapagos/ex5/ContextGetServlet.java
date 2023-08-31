package org.galapagos.ex5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextGetServlet
 */
@WebServlet("/contextget")
public class ContextGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		//속성값 얻기 object 이므로 반드시 타입 캐스팅필요
		ServletContext sc = getServletContext();
		String name = (String) sc.getAttribute("name");
		int age = (Integer) sc.getAttribute("age");
	

		
		System.out.println("name : " + name);
		System.out.println("age : " + age);   
	}

}
