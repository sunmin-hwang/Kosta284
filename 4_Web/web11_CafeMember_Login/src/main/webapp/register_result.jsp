<%@page import="web.sevlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	Member vo = (Member)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2><%= vo.getName() %>�� ȸ������ ����~</h2>
</body>
</html>