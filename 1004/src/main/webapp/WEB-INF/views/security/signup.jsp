<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="../layouts/header.jsp" %>

<div class = "text-center">
<h1 class="mb-5"><i class="fa-solid fa-user-plus"></i> 회원 가입 </h1>
</div>
<div>
	<form:form modelAttribute="member">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		
		<div class="form-group">
			<form:label path="username"><i class="fa-solid fa-user"></i>  &nbsp; 사용자 ID  </form:label>
			<form:input path="username" class="form-control"/>
			<form:errors path="username" cssClass="error"/>
		</div>
		
		<div class="form-group">
			<form:label path="password"><i class="fa-solid fa-lock"></i>  &nbsp; 비밀번호  </form:label>
			<form:input path="password" class="form-control"/>
			<form:errors path="password" cssClass="error"/>
		</div>
		
		<div class="form-group">
			<form:label path="password2"><i class="fa-solid fa-lock"></i>  &nbsp; 비밀번호 확인  </form:label>
			<form:input path="password2" class="form-control"/>
			<form:errors path="password2" cssClass="error"/>
		</div>		
		
		<div class="form-group, mb-5">
			<form:label path="email"><i class="fa-solid fa-envelope"></i>  &nbsp; email  </form:label>
			<form:input path="email" class="form-control"/>
			<form:errors path="email" cssClass="error"/>
		</div>
		
		<div class = "text-center">
			<button type="submit" class="btn btn-primary"><i class="fa-solid fa-user-plus"></i>  &nbsp; 회원가입</button>
		</div>
		
	</form:form>
</div>
<%@ include file="../layouts/footer.jsp"%>