<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../layouts/header.jsp" %>

<script>
$(document).ready(function() {

		$('.remove').click(function() {
			// click 이벤트 핸들러 함수
			if (!confirm('삭제하시겠습니까?'))
				return; //confirm - return값이 있음
			// form을 얻어서 submit() 호출
			// console.log(document.forms);
			document.forms.removeForm.submit();
		});
		
	});
</script>

<c:if test="${result=='success'}">
	<script>
		alert("수정을 완료했습니다.");
	</script>
</c:if>

<%-- 개별 페이지 --%>
<h1 class="page-header">
	<i class="fa-solid fa-hashtag"></i> ${travel.title}
</h1>


<div class="d-flex justify-content-between">

	<div>
		${travel.region}
	</div>
	
	<div>
		<i class="fa-solid fa-phone"></i> &nbsp;${travel.phone}
	</div>
	
</div>

	

	<hr>
	<div>
		${travel.description}
	</div>
	
	<div class = "mt-4 mb-2">
		주소 : ${travel.address}
	</div>
	
	<div id="map" style="width:100%; height:400px; background:gray"></div>


<hr>

<div>
	${board.content}
</div>


<div class="mt-4">
	<a href="${cri.getLink('list')}" class="btn btn-primary list"><i class="fas fa-list"></i> 목록</a>
	<a href="${cri.getLink('modify')}&no=${travel.no}" class="btn btn-primary modify"><i class="fas fa-edit"></i> 수정</a>
	<a href="#" class="btn btn-danger remove"><i class="fas fa-trash-alt"></i> 삭제</a>
</div>


<form action="remove" method="post" name="removeForm">
	<input type="hidden" name="no" value="${travel.no}"/>
	<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
	<input type="hidden" name="amount" value="${cri.amount}"/>
	<input type="hidden" name="type" value="${cri.type}"/>
	<input type="hidden" name="keyword" value="${cri.keyword}"/>
</form>

<%-- <form id="listForm" action="/board/list" method="get">
	<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
	<input type="hidden" name="amount" value="${cri.amount}"/>
	<input type="hidden" name="type" value="${cri.type}"/>
	<input type="hidden" name="keyword" value="${cri.keyword}"/>
</form>

<form id="modifyForm" action="/board/modify" method="get">
	<input type="hidden" id="bno" name="bno" value="${board.bno}"/>
	<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
	<input type="hidden" name="amount" value="${cri.amount}"/>
	<input type="hidden" name="type" value="${cri.type}"/>
	<input type="hidden" name="keyword" value="${cri.keyword}"/>
</form> --%>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3ac284c42da1e2d811a900fcb04d3f3d&libraries=services">
</script>

<script>
	let geocoder = new kakao.maps.services.Geocoder();
	
	let address ='${travel.address}'; // 주소 정보
	
	geocoder.addressSearch(address, function(result, status){
		if(status === kakao.maps.services.Status.OK){
			
			
			// 배열의 첫번째 위치로 이동
			let coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			
		  	let mapContainer = document.getElementById('map');
		  	//  지도 제어 코딩
			let mapOption = {
		  			center: coords,  // 중심 좌표
		  			level:3 // 지도의 확대 레벨
		  	};	
		  	
		  	let map = new kakao.maps.Map(mapContainer, mapOption);
			
			let marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});
			
			// 지도의 중심을 결과값으로 받은 위치로 이동
			// map.setCenter(coords);
		} else{
			alert('잘못된 주소입니다.');
		}
	});
	
	

  	

  	
</script>




<%@ include file="../layouts/footer.jsp"%>