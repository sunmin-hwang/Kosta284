<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	h2{
		color: DodgerBlue;
	}

	#itemList{
		display: flex;
		justify-content: space-around;
	}
	
	#item{
		width: 200px;
		height: 300px;
	}
	
	img{
		width: 200px;
		height: 200px;
		border: 4px solid DeepSkyBlue;
		border-radius: 10px;
	}
	
	img:hover{
		border: 4px solid red;
	}
</style>
<script type="text/javascript">
	$(()=>{
		$('img').on('click', function() {
			location.href = 'view.do?itemNumber=' + $(this).attr('id');
		})
	});
</script>
</head>
<body>
<h2 align="center">Fruit Total List 1.</h2>
<div id="itemList">
	<c:forEach items="${list}" var="item">
		<div id="item">
			<img src="${item.url }" id="${item.itemNumber }"><br><br>
			상품명 : ${item.name }<br><br>
			가격 : ${item.price }원
		</div>
	</c:forEach>
</div>

</body>
</html>