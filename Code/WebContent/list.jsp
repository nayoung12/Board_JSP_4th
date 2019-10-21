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
	<tr align="center">
		<td width="50">글번호</td>
		<td width="100">글쓴이</td>
		<td width="300">제목</td>
		<td width="150">날짜</td>
		<td width="50">조회수</td>
		<td width="50">추천</td>
	</tr>
	<!-- 얻어온 게시물 개수만큼 루프를 돌면서 찍어준다 -->
	<c:forEach var="i" items="${articleList}">
		<tr>
			<td>${i.num}</td>		
			<td>${i.writer}</td>
			<td><a href="/BoardJSP_4th/read.do?num=${i.num}">${i.title}</a></td>
			<td>${i.writeDate}</td>
			<td>${i.hits}</td>	
			<td>${i.recommand}</td>	
		</tr>
	</c:forEach>
</table>
<br/>
<button onclick="location.href='write.jsp'">글쓰기</button>
</body>
</html>