<%@page import="web.servlet.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	Product product = (Product)request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	h3{
		display: inline-block;
	}
</style>
</head>
<body>
<h1>상품이 저장되었습니다.</h1>
&nbsp;&nbsp;<h3>상품번호</h3> &nbsp;&nbsp;&nbsp; <%= product.getProductNo() %><br>
&nbsp;&nbsp;&nbsp;<h3>상 품 명</h3> &nbsp;&nbsp; <%= product.getName() %><br>
&nbsp;&nbsp;<h3>상품 가격</h3> &nbsp; <%= product.getPrice() %><br>
&nbsp;&nbsp;<h3>상품 설명</h3> &nbsp; <%= product.getDetail() %><hr>
<a href="List">상품 목록</a>
</body>
</html>