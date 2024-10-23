<%@page import="web.servlet.vo.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	User user = (User)request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	*{
		text-align: center;
	}
</style>
</head>
<body>
<br>
<h1><%= user.getId() %> 님이 로그인 되었습니다.!!!</h1>
<br>
<a href="">도서등록</a><br><br>
<a href="">로그아웃</a>
</body>
</html>