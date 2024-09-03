<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
<form action="front.do" method="post">
	<input type="hidden" name="command" value="register">
	ID : <input type="text" name="id" required="required"><br>
	PASSWORD : <input type="password" name="password" required="required"><br>
	NAME : <input type="text" name="name"><br>
	ADDRESS : <input type="text" name="address"><br>
	<input type="submit" value="회원가입">
</form>
</body>
</html>