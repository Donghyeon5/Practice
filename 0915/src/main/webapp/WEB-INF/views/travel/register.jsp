<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../layouts/header.jsp"%>
<link rel="stylesheet" href="../resources/css/summernote/summernote-lite.min.css">
<script src="../resources/js/summernote/summernote-lite.min.js"></script> 
<script src="../resources/js/summernote/lang/summernote-ko-KR.min.js"></script> 
<script>
$(document).ready(function() {
    $('#content').summernote({
        height: 300,    // 에디터 높이
        lang: "ko-KR",    // 한글 설정
    });
});
</script>

<h1 class="page-header">
    <i class="far fa-edit"></i> 여행지 등록
</h1>
<div class="panel panel-default">
    <div class="panel-body">
        <form role="form" method="post">
        
        <div class="form-group">
                <label>권역</label>
                <input name="region" class="form-control">
            </div>
            <div class="form-group">
                <label>제목</label>
                <input name="title" class="form-control" >
            </div>
            <div class="form-group">
                <label>주소</label>
                <input name="address" class="form-control">
            </div>
            <div class="form-group">
                <label>전화번호</label>
                <input name="phone" class="form-control">
            </div>
            <div class="form-group">
                <label>내용</label>
                <textarea class="form-control" 
                    name="description" id="content"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">
                <i class="fas fa-check"></i> 확인
            </button>
            <button type="reset" class="btn btn-primary">
                <i class="fas fa-undo"></i> 취소
            </button>
            <a href="javascript:history.back()" class="btn btn-primary"> <i class="fas fa-list"></i>
                목록
            </a>
        </form>
    </div>
</div>
<%@include file="../layouts/footer.jsp"%>