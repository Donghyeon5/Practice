<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
 	<%@include file = "header.jsp" %>
 	
 	<%
 	
 	Date d = new Date();
 	
 	%>
 	
 	
 
  <body>
    <div class="container">
    	<h1>									<!-- 메서드 오면 메서드의 출력값 출력 -->
    		Glory에 오신 것을 환영합니다. <br>현재시간 : <%=d.toLocaleString()%>
    	</h1>
    	<a href="about.jsp">about</a>
    </div>
  </body>
	
	<%@include file = "footer.jsp" %>
