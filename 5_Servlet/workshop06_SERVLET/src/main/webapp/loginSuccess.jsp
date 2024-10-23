<%@page import="web.servlet.vo.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	User vo = (User)session.getAttribute("vo");
	
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
<h1><%= vo.getName() %> 님이 로그인 되었습니다.!!!</h1>
<br>
<a href="./book/Book.html">도서등록</a><br><br>
<a href="login.html" onclick="logout()">로그아웃</a>
</body>
<script type="text/javascript">
	function logout() {
		<% session.invalidate();%>
	}
</script>
</html>