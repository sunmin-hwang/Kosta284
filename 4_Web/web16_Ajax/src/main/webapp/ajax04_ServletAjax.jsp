<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(()=>{
		$('#AjaxBtn').on('click', function() {
			let id = $('#userId').val();
			
			$.ajax({
				type:'post',
				url:'front.do',
				data:{'id':id},
				
				success: function(result){
					alert(result);
				},
				error: function(xhr, status, message) {
					alert("대기시간 초과 에러" + message);
				},
				timeout:1000
			});
		});
	});
</script>
</head>
<body>
<h2>서블릿으로 비동기 요청하기</h2>

ID <input type="text" name="userId" id="userId">
<input type="button" value="AjaxBtn" id="AjaxBtn">
<div id="resultScope"></div>

</body>
</html>