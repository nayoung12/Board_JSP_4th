<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/BoardJSP_4th/signup.do">
	ID : <input type="text" id="userId" name="userId" /><br/>
	Password : <input type="password" id="passwd" name="passwd" /><br/>
	Name : <input type="text" id="userName" name="userName" /><br/>
	<input type="submit" value="회원가입" />
</form>
<button onclick="location.href='main.jsp'">취소</button>
</body>
</html>