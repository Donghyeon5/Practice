<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
 
    <div class="container">
    	<h1>
    		상세보기
    	</h1>
    	
    	<div>
    		<div>UserId : ${user.userid}</div>
    		<div>Password : ${user.password}</div>
    		<div>email : ${user.email}</div>
    	</div>
    	<a href="list.do">목록으로</a>
    </div>
    
