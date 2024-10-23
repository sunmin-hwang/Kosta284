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
		$('#ajax').on('click', function() {
			//비동기 통신 시작...
			$.ajax({
				//요청부분
				type:"get",
				url:"http://localhost:8888/web16_Ajax/bank.json",
				//응답부분
				success: function(resultData){
					alert(resultData.data);
				},
				error: function(e){
					alert(e + "..응답시간이 너무 지연됩니다...다시 시도해주세요");
				},
				timeout:1000 //1초동안 서버로부터 응답이 없으면 Error발생(응답시간 지정 가능)
			});
		});
	});
</script>
</head>
<body>
	<h3>버튼 클릭시 비동기 통신 시작</h3>
	<input type="button" value="JQuery Ajax" id="ajax">
</body>
</html>