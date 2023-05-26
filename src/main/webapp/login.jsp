<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function initializePage(){
		const msg = '${msg}'
		
		if(msg.length != 0){
			alert(msg)
			document.login.sid.select()
		}
	}

	function checklogin(){
		
		const form = document.login
		const id = form.sid.value
		const pw = form.spw.value
		

		if(id.length == 0){
			alert("아이디를 입력해주세요")
			form.sid.select()
			return
		}
		if(pw.length == 0){
			alert("비밀번호를 입력해주세요")
			
			form.spw.select()
			return
		}

		form.submit()
		
	}
</script>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body onload="initializePage()">
<div class="center">
<h1>로그인</h1>
<form action="login.do" method="post" name="login">
	  <table>
	    <tr>
	      <th>ID : </th>
	      <td><input type="text" name="sid"></td>
	    </tr>
	    <tr>
	      <th>PASSWORD :</th>
	      <td><input type="password" name="spw"></td>
	    </tr>
	    <tr>
	      <td colspan="2"><input type="button" value="Login" onclick="checklogin()" ></td>
	    </tr>
	    <tr>
	      <td colspan="2">아직 회원이 아니신가요?&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="joinview.do">회원가입</a></td>
	    </tr>
	  </table>
</form>
</div>

</body>
</html>
