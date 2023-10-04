<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../layouts/header.jsp"%>

<div style="width:500px" class="mx-auto">
<h1 class="mb-5"><i class="fa-solid fa-arrow-right-to-bracket"></i> 로그인</h1>

	<c:if test="${param.error == 'true' }">
		<div class="error">
			사용자 ID 또는 비밀번호가 일치하지 않습니다.
		</div>
	</c:if>
	
<form action="/security/login" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
	<div class= "form-group">
	<label><i class="fa-solid fa-user"></i>사용자 ID : </label>
	<input type="text" name="username"/><br>
	</div>
	
	<div class= "form-group">
	<i class="fa-solid fa-lock"></i>비밀번호 :   
	<input type="password" name="password"/><br>
	</div>
	
	<div class= "form-group form-check">
	<label>
		<input type="checkbox" name="remember-me"> 로그인 유지
	</label>
	</div>
	
	<button type="submit" class="btn btn-primary btn-block">
		<i class="fa-solid fa-right-to-bracket"></i>
		 &nbsp;로그인
	</button>
	
	<button type="submit" class="btn btn-primary btn-block">
		<i class="fa-solid fa-user-plus"></i>
		  &nbsp;회원 가입
	</button>
	

</form>
</div>
<%@include file="../layouts/footer.jsp"%>