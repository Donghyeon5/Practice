package org.galapagos.ex1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.galapagos.vo.Member;

/**
 * Servlet implementation class VoServlet
 */
@WebServlet("/vo")
public class VoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member admin = new Member("admin", "관리자");
		// Map 아니므로 프로퍼티로 값을 확인 getName, getUserid 메서드 실행해서 값을 얻음
		
		request.setAttribute("user", admin);
		
		RequestDispatcher dis = request.getRequestDispatcher("el03.jsp");
		dis.forward(request, response);
	
	}

}
