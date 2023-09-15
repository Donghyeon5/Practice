<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../layouts/header.jsp"%>

<script src="/resources/js/search.js">
	/* $(document).ready(function() {
	
	let searchForm = $('#searchForm');
		$('#searchForm button').on('click', function(e) {
			if (!searchForm.find('option:selected').val()) {
				alert('검색종류를 선택하세요');
				return false;
			}
			
			let keyword = searchForm.find('input[name="keyword"]');
			if(!keyword.val()){
				alert('키워드를 입력하세요');
				keyword.focus();
				return false;
			}
			
			searchForm.find('input[name="pageNum"]').val('1');
			e.preventDefault();
			searchForm.submit();
		});

	}); */
</script>


<h1 class="page-header">
	<i class="fas fa-list"></i> &nbsp;게시글 목록
</h1>

<div class="d-flex justify-content-between align-items-center my-4">

	<div class=" ">
		총 ${pageMaker.total}건
		( ${pageMaker.cri.pageNum} .. ${pageMaker.totalPage})
	</div>
	
	<div>
		<form id="searchForm" method="get" class="d-flex">
			<input type="hidden" name="pageNum" value="1">
			<select name="type" class="form-select rounded-0 ml-1">
				<option value="" ${pageMaker.cri.type == null ? 'selected' : ''}>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;검색 대상</option>
				<option value="T" ${pageMaker.cri.type eq 'T' ? 'selected' : ''}>제목</option>
				<option value="C" ${pageMaker.cri.type eq 'C' ? 'selected' : ''}>내용</option>
				<option value="W" ${pageMaker.cri.type eq 'W' ? 'selected' : ''}>작성자</option>
				<option value="TC" ${pageMaker.cri.type eq 'TC' ? 'selected' : ''}>제목+내용</option>
				<option value="TW" ${pageMaker.cri.type eq 'TW' ? 'selected' : ''}>제목+작성자</option>
				<option value="TWC" ${pageMaker.cri.type eq 'TWC' ? 'selected' : ''}>제목+내용+작성자</option>
			</select>
			<div class="input-group">
				<input type="text" name="keyword" class="form-control rounded-0"
					value="${pageMaker.cri.keyword}" />
				<button type="submit" class="btn btn-success rounded-0">
				<i class = "fa-solid fa-magnifying-glass"></i>  &nbsp;검색</button>
			</div>
		</form>
	</div>
	
</div>

<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th style="width: 60px">No</th>
			<th>제목</th>
			<th style="width: 100px">작성자</th>
			<th style="width: 130px">등록일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.bno}</td>
				<td>
					<a class="move" href="${cri.getLinkWithBno('get', board.bno)}">
					${board.title}</a>
				</td>
				<td>${board.writer}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${board.regDate}" /></td>
			</tr>
		</c:forEach>
	</tbody>

</table>

<div class="text-right">
	<a href="register" class="btn btn-primary"> <i class="far fa-edit"></i> 
		글쓰기
	</a>
</div>

<%@include file="../common/pagination.jsp"%>



 




<%@include file="../layouts/footer.jsp"%>
