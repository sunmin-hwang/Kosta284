<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript">
	$(()=>{
		$('.title').mouseover(function() {
			$.ajax({
				type: 'get',
				url: 'findByTitle.do?isbn=' + $(this).attr('id'),
				success: function(result) {
					let re = result.split(',');
					$('#bookDetail').html("<h5><font color=crimson>Book 상세정보 출력-제목 : " + re[0] + ", 출판사 : " + re[1] + ", 저자 : " + re[2] + "</font></h5>")
				}
			});
		})
	});
</script>
</head>
<body>
	<div class="container">
		<h1 class="text-center">도서 목록 화면</h1>
		<div class="clearfix">
			<c:if test="${not empty vo}">
				<h4 class="float-left">${vo.name }님 로그인 되셨습니다.
				<a href="${pageContext.request.contextPath}/logout.do">로그아웃</a></h4>
			</c:if>
			<form class="float-right" action="${pageContext.request.contextPath}/showBook.do" method="post">
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
					<th>출판사</th>
					<th>도서저자</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${list.size()!=0}">
						<c:forEach items="${list }" var="book">
							<tr>
								<td>${book.isbn }</td>
								<td><a href="#" class="title" id="${book.isbn }">${book.title }</a></td>
								<td>${book.catalogue }</td>
								<td>${book.publisher }</td>
								<td>${book.author }</td>
							</tr>
						</c:forEach>					
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5" class="text-center">입력된 도서 정보가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<span class="text-center pt-3" id="bookDetail"></span>
		<div class="text-center pt-5">
			<a href="book/Book.jsp">도서 등록</a>
		</div>
	</div>
</body>
</html>