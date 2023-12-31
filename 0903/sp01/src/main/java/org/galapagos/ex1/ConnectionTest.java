package org.galapagos.ex1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ConnectionTest
 */
@WebServlet("/test")
public class ConnectionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource (name="jdbc/mysql")
	DataSource dataFactory;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		try (Connection con = dataFactory.getConnection()){
			System.out.println("연결 획득 성공");
		} catch (Exception e) {
			e.printStackTrace();
		};
	
	}

}
