<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	/* 자바코드만 입력함... */
	Member mem = (Member)request.getAttribute("mem");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2><%= mem.getAddress() %>에 거주하는 멤버의 정보입니다.</h2>
<p></p>
이름 : <%= mem.getName() %> <br>
나이 : <%= mem.getAge() %>
</body>
</html>