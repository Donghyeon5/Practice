package org.galapagos.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.galapagos.command.Command;
import org.galapagos.command.DetailCommand;
import org.galapagos.command.ListCommand;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Command> commandMap = new HashMap<>();
	String prefix ="views/"; // view 이름의 접두어
	String surfix =".jsp"; // view 이름의 접미어
	
	public FrontControllerServlet() { // 커맨드 객체만들고 서블릿에 추가
		commandMap.put("/list.do", new ListCommand());
		commandMap.put("/detail.do", new DetailCommand());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
//		System.out.println("requestURI : " + requestURI );
//		System.out.println("contextPath : " + contextPath );
//		System.out.println("command : " + command );
		
		Command cmd = commandMap.get(command);
		String view;
		
		if(cmd != null) {
		// 이동할 jsp 파일 경로
			view = cmd.execute(request, response);
		}else { // cmd == null -> 404 에러 상황, 맵에 요청되지 않은 상황일 경우
			view = "404";
		}
		
		String target = prefix + view + surfix;
		
		// view로 forwarding 하기
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
