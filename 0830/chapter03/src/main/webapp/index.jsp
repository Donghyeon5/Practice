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
    	<h1>getParameter 실습</h1>
    	<form action="login" method="get">
    	<fieldset>
    	<legend>로그인 폼</legend>
    	<ul>
	    	<li><label for="userid">아이디</label><input type="text" name="userid"></li>
	    	<li><label for="password">비밀번호</label><input type="password" name="passwd"></li>
	    	<li><input type="submit" value="전송"><li>
    	</ul>
    	</fieldset>
    	</form>
    </div>
  </body>
</html>
