<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function Login(){
		if(document.loginFrm.id.value==""){
			alert("ID를 입력하세요");
			document.loginFrm.user.focus();
		}else if(document.loginFrm.password.value==""){
			alert("PASSWORD를 입력하세요");
			document.loginFrm.pass.focus();
		}else{
			document.loginFrm.submit();
		}
	}
</script>
</head>
<body>
<table width="100%" height="100%">
	<tr>
		<td align="center">
		<table border="4" width="434" height="180">
			<tr><td align="center">
			<table width="400" height="180">
				<tr>
				<td width=107><img src="./images/book.bmp" border="0"></td>
				<td width=281 height="150">
				
					<!--  로그 입력창-->
					
					<form method="post" action="login.do" name="loginFrm">
					<center><font size="3" face="굴림">로그인을 하세요</font></center>
					<p><p><p>
					<table align="center">
						<tr>
							<td><img src="./images/id_id.gif" border="0"></td>
							<td><input type="text" name="id" class="input" onkeypress="if (event.keyCode==13) Login();" style="width:120;height:20;"></td>
						</tr>
						<tr>
							<td><img src="./images/id_pass.gif" border="0"></td>
							<td><input type="password" name="password" class="input" onkeypress="if (event.keyCode==13) Login();" style="width:120;height:20;"></td>
						</tr>
					<tr/><tr>
					<td></td>
					<td height="5" background="./images/line.gif"></td>
					</tr><tr>
					<td></td>
					<td><a href="Javascript:Login();"><img src="./images/butt_login.gif" border="0" width="80" height="25"></a></td>
					</tr>
					</table>
					</form>
					
					<!-- 로그인 입력 끝 -->
				</td></tr></table>
		</td></tr></table>
</body>
</html>