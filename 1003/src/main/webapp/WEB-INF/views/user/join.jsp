<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action ="/user/join" method="POST">
		<!-- form 데이터를 DTO에 바로 매핑 -->
		<!-- UserDTO 의 변수와 input의 name 일치 -->
		회원 ID : <input type="text" name="userid" value="hong"><br>
		비밀번호 : <input type="password" name="password" value="1234"><br>
		비밀번호 확인 : <input type="password" name="password2" value="1234"><br>
		email : <input type="email" name="email" value="hong@naver.com"><br>
		취미 : 
			<input type="checkbox" name="hobbies" value="축구">축구
			<input type="checkbox" name="hobbies" value="농구">농구
			<input type="checkbox" name="hobbies" value="배구">배구
			<input type="checkbox" name="hobbies" value="게임" checked>게임
			<input type="checkbox" name="hobbies" value="영화" checked>영화
		<br>
		생일 : <input type="text" name="birthDate" placeholder="yyyy-MM-dd" value="2000-10-10">
		<br>
		<input type="submit">
	</form>
</body>
</html>