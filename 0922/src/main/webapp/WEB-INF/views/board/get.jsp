<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../layouts/header.jsp"%>

<script src="/resources/js/rest.js"></script>

<script>
$(document).ready(async function() {

	$('.remove').click(function(){
		if(!confirm('정말 삭제할까요?')) return;		
		document.forms.removeForm.submit();
	});	
	
	const bno = ${board.bno};
 
	const url='/api/board/' + bno + '/comment';
	console.log(url);
	let data = await rest_get(url);
	console.log(data);

}); 

</script>

<h1 class="page-header"><i class="far fa-file-alt"></i> ${board.title}</h1>
	
<div class="d-flex justify-content-between">
	<div><i class="fas fa-user"></i> ${board.writer}</div>
	<div>
		<i class="fas fa-clock"></i> 
		<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/>
	</div>
</div>
	
<hr>
	
<div>
	${board.content}
</div>

<div class="mt-4">
	<a href="${cri.getLink('list')}" class="btn btn-primary list">
		<i class="fas fa-list"></i> 목록</a>
		
	<c:if test="${username == board.writer}">	
	<a href="${cri.getLinkWithBno('modify', board.bno) }" class="btn btn-primary modify">
		<i class="far fa-edit"></i> 수정</a>
	<a href="#" class="btn btn-danger remove">
		<i class="fas fa-trash-alt"></i> 삭제</a>
	</c:if>
</div>

<%-- 
<form id="listForm" action="/board/list" method="get" >
	<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
	<input type="hidden" name="amount" value="${cri.amount}"/>
	<input type="hidden" name="type" value="${cri.type}"/>
	<input type="hidden" name="keyword" value="${cri.keyword}"/>
</form>

<form id="modifyForm" action="/board/modify" method="get" >
	<input type="hidden" id="bno" name="bno" value="${board.bno}"/>
	<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
	<input type="hidden" name="amount" value="${cri.amount}"/>
	<input type="hidden" name="type" value="${cri.type}"/>
	<input type="hidden" name="keyword" value="${cri.keyword}"/>
</form>
 --%>
 
<form action="remove" method="post" name="removeForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="hidden" name="bno" value="${board.bno}"/>
	<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
	<input type="hidden" name="amount" value="${cri.amount}"/>
	<input type="hidden" name="type" value="${cri.type}"/>
	<input type="hidden" name="keyword" value="${cri.keyword}"/>
</form>

<%@include file="../layouts/footer.jsp"%>
