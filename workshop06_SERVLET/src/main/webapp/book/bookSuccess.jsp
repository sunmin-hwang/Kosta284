<%@page import="web.servlet.vo.Book"%>
<%@page import="web.servlet.vo.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	Book book = (Book)session.getAttribute("book");
%>
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
<%= book.getTitle() %>정상적으로 저장되었습니다.
<br><br>
<a href="./Book.html">추가등록</a><br><br>
<a href="">도서목록</a>
</body>
</html>