<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2">
	<tr>
		<td>ID</td>
		<td>이름</td>
		<td>삭제</td>
	</tr>
<c:forEach var="i" items="${userList}">
	<tr>
		<td>${i.id}</td>
		<td>${i.name}</td>
		<td><button onclick="location.href='/BoardJSP_4th/userdelete_admin.do?id=${i.id}'">삭제</button></td>
	</tr>
</c:forEach>
</table>
</body>
</html>