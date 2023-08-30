<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <!-- Latest compiled and minified CSS -->
    <!-- CDN : Content Delivery Network -->

    <!--fontawesome의 CDN-->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
      integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />

    <!--bootstrap의 CDN-->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
    />

    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <!-- jQuery -> popper -> bootstrap 순으로  -->
    <link rel="stylesheet" href="css/main.css" />
    <style></style>
  </head>
  <body>
    <!-- 합이 12가 되도록, 해상도에 따라 어떻게 나눌것인지가 핵심 모두 Bootstrap에서 정의하고 있음-->

    <div class="container">
    	<div class="mx-auto mt-4" style="width:500px">
    	<h1>getParameterValues 실습</h1>
    	<form action ="sport" method="post" class= "form">
    		<fieldset>
    			<legend>좋아하는 운동 및 성별</legend>
    			
    				<div class="form-control">
    				<label for ="baseball">야구</label><input type="checkbox" name="sports" value="야구">
    				<label for ="baseball">축구</label><input type="checkbox" name="sports" value="축구">
    				<label for ="baseball">농구</label><input type="checkbox" name="sports" value="농구">
    				</div>
    				
    				<div class="form-control">
    				<label for ="sex">남</label><input type="radio" name="sex" value="남자" checked>
    				<label for ="sex">여</label><input type="radio" name="sex" value="여자" >
    				</div>
    				
    				<div>
    				<label>나이</label>
    				<input type="number" name="age" required>
    				</div>
    		
    			
    			<button type="submit" class = "btn btn-primary">전송</button>
    			
    			
    		</fieldset>
    	</form>
    	    </div>
    </div>
  </body>
</html>
