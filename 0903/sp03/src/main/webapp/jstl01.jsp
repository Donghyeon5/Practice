<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 

  	<%-- c:set var = "변수명" value = "변수값"  target ="객체" 
  			property="객체의 프로퍼티" scope="scope값"/--%>	
  			
	<c:set var="page" value="1" scope="request" />   
		<%-- value = ${1} -> 정수 1, value = "1" -> 문자열1  --%>
		
<%@include file = "header.jsp" %>
 
 

    <div class="container">
    	<h1>
    		Page : ${pageScope.page} / ${requestScope.page} / ${page}
    	</h1>
    	<c:out value= "${page}" /> / <c:out value= "page" />
    		<hr>
    	<c:remove var="page"/> <%--페이지 속성 삭제 --%>
    	(${page})
    	
    </div>

	
<%@include file = "footer.jsp" %>