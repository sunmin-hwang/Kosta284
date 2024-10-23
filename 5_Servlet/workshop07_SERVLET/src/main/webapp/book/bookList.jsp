<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center">도서 목록 화면</h1>
		<div class="clearfix">
			<form class="float-right" action="${pageContext.request.contextPath}/front.do" method="post">
				<input type="hidden" name="command" value="showBook">
				<select name="searchOption">
					<option value="all">전체</option>
					<option value="title">도서명</option>
					<option value="publisher">출판사</option>
				</select>
				<input type="text" name="searchText">
				<input type="submit" value="검색">
			</form>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>도서번호</th>
					<th>도서명</th>
					<th>도서분류</th>
					<th>도서저자</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${!empty list}">
						<c:forEach items="${list }" var="book">
							<tr>
								<td>${book.isbn }</td>
								<td>${book.title }</td>
								<td>${book.catalogue }</td>
								<td>${book.author }</td>
							</tr>
						</c:forEach>					
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4" class="text-center">찾으시는 책이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<div class="text-center">
			<a href="book/Book.jsp">도서 등록</a>
		</div>
	</div>
</body>
</html>