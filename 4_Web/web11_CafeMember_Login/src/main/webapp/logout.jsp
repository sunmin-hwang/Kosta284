<%@page import="web.sevlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member vo = (Member)session.getAttribute("vo");
	if(vo==null){
%>
<h3><a href="login.jsp">로그인하기</a></h3>
<%		
	}else{
		session.invalidate();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("Log Out~~!!")
	}
</script>
</head>
<body onload="return logout()">
<b>로그아웃 되셨습니다.</b>
<a href="index.html">INDEX로 가기</a>
</body>
</html>