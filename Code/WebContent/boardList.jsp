<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrap">
	<h1>게시글 리스트</h1>
	<table class="list">
		<tr>
			<td colspan="6" style="border: white; text-align: right;">
				<a href="BoardServlet?command=board_write_form">게시판 등록</a>
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회</th>
			<th>추천수</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<td>${board.num }</td>
			<td>
				<a href="BoardServlet?command=board_view&num=${board.num }">${board.title }</a>
			</td>
			<td>${board.writer }</td>
			<td><fmt:formatDate value="${board.writeDate }" /></td>
			<td>${board.hits }</td>
			<td>${board.recommand }</td>
		</c:forEach>
	</table>
</div>
</body>
</html>