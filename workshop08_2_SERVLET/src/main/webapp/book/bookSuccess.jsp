<%@page import="web.servlet.vo.Book"%>
<%@page import="web.servlet.vo.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		text-align: center;
	}
</style>
</head>
<body>
<br>
<h1>결과페이지</h1>
<br>
${param.bookTitle } ${msg}
<br><br>
<a href="book/Book.jsp">추가등록</a><br><br>
<a href="${pageContext.request.contextPath}/front.do?command=showBook&searchOption=all">도서목록</a>
</body>
</html>