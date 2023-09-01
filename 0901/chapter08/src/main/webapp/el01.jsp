<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
 	<%@include file = "header.jsp" %>
 	
 	<%
 	
 	String name = "테스트"; //지역 변수에서 찾는 <% >
 	request.setAttribute("name", "test" ); //el용, scope에서 찾는다
 	
 	%>
 
  <body>
    <div class="container">
    	<h1>
    		<!-- ${name} 해도 됨, 좁은 범위에서 넒은 범위로 자동 탐색 -->
    		${requestScope.name} / <%=name%>
    	</h1>
    </div>

	
	<%@include file = "footer.jsp" %>