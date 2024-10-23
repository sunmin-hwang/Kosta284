<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	li{
		margin-left: 40px;
	}
	
	a{
		text-decoration: none;
		color: black;
	}
	
	img{
		width: 600px;
		height: 600px;
	}
	
</style>
</head>
<body>
<h2 align="center"><b>${item.name }의 정보</b></h2><br>
<nav class="navbar navbar-expand-sm bg-warning justify-content-end">
  <ul class="navbar-nav">
    <li class="nav-item">
      <span class="navbar-text">조회수 : ${item.count}</span>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">장바구니 담기</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">장바구니 확인</a>
    </li>
  </ul>
</nav>
<div id="item" class="container d-flex justify-content-between">
	<div class="text-center">
		<img src="${item.url }" id="${item.itemNumber }"><br>
		<a href="list.do">상품목록 보기</a>
	</div>
	<div id="item-info">
		<br><br>
		종류 : ${item.name }<br><br><br>
		가격 : ${item.price }<br><br><br><br><br><br>
		설명 : ${item.description }
	</div>
</div>
</body>
</html>