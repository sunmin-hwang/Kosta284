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
<h1>��ǰ�� ����Ǿ����ϴ�.</h1>
&nbsp;&nbsp;<h3>��ǰ��ȣ</h3> &nbsp;&nbsp;&nbsp; <%= product.getProductNo() %><br>
&nbsp;&nbsp;&nbsp;<h3>�� ǰ ��</h3> &nbsp;&nbsp; <%= product.getName() %><br>
&nbsp;&nbsp;<h3>��ǰ ����</h3> &nbsp; <%= product.getPrice() %><br>
&nbsp;&nbsp;<h3>��ǰ ����</h3> &nbsp; <%= product.getDetail() %><hr>
<a href="List">��ǰ ���</a>
</body>
</html>