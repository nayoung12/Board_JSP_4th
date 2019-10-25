<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/BoardJSP_4th/write.do">
<table border="2">
	<tr>
		<td>작성자</td>
		<td><input type="text" name="writer" id="writer" /></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" id="title" /></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" name="content" id="content" /></td>
	</tr>
</table>
<input type="submit" value="작성" />
</form>
<script>
function doWrite() {

	document.frm.submit();
}

function doWriteCancel() {

	document.frm.reset();
}

function backToList() {

	location.href="/MVC_BBS/list.do";
}
</script>
</body>
</html>