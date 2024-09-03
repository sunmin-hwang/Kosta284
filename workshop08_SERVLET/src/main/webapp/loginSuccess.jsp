<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h1>${param.id } 님이 로그인 되었습니다.!!!</h1>
<br>
<a href="./book/Book.jsp">도서등록</a><br><br>
<a href="${pageContext.request.contextPath}/front.do?command=logout">로그아웃</a>
</body>
</html>