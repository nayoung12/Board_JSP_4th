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
<form method="POST" action="/BoardJSP_4th/modify.do" />
<table border="2">
	<tr>
		<td>글번호</td>
		<td><input type="text" id="num" name="num" value="${article.num}"/></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" id="title" name="title" value="${article.title}"/></td>
	</tr>
	<tr>
		<td>글쓴이</td>
		<td>${article.writer}</td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" id="content" name="content" value="${article.content}"/></td>
	</tr>
	<tr>
		<td>작성날짜</td>
		<td>${article.writeDate}</td>
	</tr>
</table>
<input type="submit" value="수정" />
</form>
</body>
</html>