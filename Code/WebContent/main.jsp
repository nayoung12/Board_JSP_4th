<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/BoardJSP_4th/login.do">
	ID : <input type="text" id="ids" name="ids" /><br/>
	Password : <input type="password" id="passwd" name="passwd" /><br/>
	<input type="submit" value="로그인" />
	<!-- 값 validation 체크 부분 삽입 필요 -->
</form>
</body>
</html>