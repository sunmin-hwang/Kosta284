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
<h1><%= user.getId() %> ���� �α��� �Ǿ����ϴ�.!!!</h1>
<br>
<a href="">�������</a><br><br>
<a href="">�α׾ƿ�</a>
</body>
</html>