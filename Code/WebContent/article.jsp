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
<table border="2" align="center">
	<tr>
		<td width="80">글번호</td>
		<td>${article.num}</td>
	</tr>
	<tr>
		<td width="80">제목</td>
		<td>${article.title}</td>
	</tr> 
	<tr>
		<td width="80">글쓴이</td>
		<td>${article.writer}</td>
	</tr>
	<tr>
		<td width="80">내용</td>
		<td>${article.content}</td>
	</tr>
	<tr>
		<td width="80">작성날짜</td>
		<td>${article.writeDate}</td>
	</tr>
	<tr>
		<td width="80">조회수</td>
		<td>${article.hits}</td>
	</tr>
	<tr>
		<td width="80">추천수</td>
		<td>${article.recommand}</td>
	</tr>
	<tr>
		<!-- 작성자만 수정버튼이 보이도록 -->
		<td><button onclick="/BoardJSP_4th/modify_form.do">수정</button></td>
		<!-- 작성자,관리자만 수정버튼이 보이도록 -->
		<td><button onclick="">삭제</button></td>
	</tr>
	<tr>
		<td><!-- 추천 버튼 --></td>
		<td><!-- 추천 취소 버튼 --></td>
	</tr>
</table>
</body>
</html>