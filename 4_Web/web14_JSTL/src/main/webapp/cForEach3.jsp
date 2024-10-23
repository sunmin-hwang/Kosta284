<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>c:ForEach문 사용하기</h2>
<c:forEach var="cnt" begin="1" end="7">
	<font size="${cnt}">Hello Nice Day~~~!!</font>  <br>
</c:forEach>
</body>
</html>