package org.galapagos.ex3;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextParamServlet
 */
@WebServlet(
		urlPatterns = { "/contextparam" }, 
		initParams = { 
				@WebInitParam(name = "pathDir", value = "c:/temp", description = "파일 업로드 경로"), 
				@WebInitParam(name = "userId", value = "hong")
		})
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ServletContext sc = getServletContext(); 
		
		// Application scope = ServletContext, 서버(톰캣)이 종료될 때 끝남
		// web.xml에서 관리하는 ServletContext
		// 하나의 서블릿에 종속된 것이 아니기 때문에
		
		String driver = sc.getInitParameter("driver");
		String dburl =  sc.getInitParameter("dburl");
		String username = sc.getInitParameter("username");
		String password =  sc.getInitParameter("password");
		
		System.out.println(driver);
		System.out.println(dburl);
		System.out.println(username);
		System.out.println(password);
		
		
	}

}
