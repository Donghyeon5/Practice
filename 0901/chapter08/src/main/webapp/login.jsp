<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
	
	<%--이 사이트 방문시 session 스코프에 userId 정보 1개 저장 --%>
<c:set var="userid" value="admin" scope="session"/>
 

<%@include file = "header.jsp" %>
    <div class="container">
    	<h1>
    		로그인 성공
    	</h1>
    	<a href="visit.jsp">visit</a>
    </div>

	
<%@include file = "footer.jsp" %>