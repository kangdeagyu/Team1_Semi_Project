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
			document.login.cid.select()
		}
	}

	function checklogin(){
		
		const form = document.login
		const id = form.cid.value
		const pw = form.cpw.value
		

		if(id.length == 0){
			alert("아이디를 입력해주세요")
			form.cid.select()
			return
		}
		if(pw.length == 0){
			alert("비밀번호를 입력해주세요")
			
			form.cpw.select()
			return
		}

		form.submit()
		
	}
</script>
<meta charset="UTF-8">
<title>로그인 화면</title>
  <style>
    body {
      margin: 0 auto;
      width: 500px;
    }
  </style>
</head>
<body onload="initializePage()">

<h1>로그인</h1>
<form action="login.do" method="post" name="login">
	  <table>
	    <tr>
	      <th>ID : </th>
	      <td><input type="text" name="cid"></td>
	    </tr>
	    <tr>
	      <th>PASSWORD :</th>
	      <td><input type="password" name="cpw"></td>
	    </tr>
	    <tr>
	      <td colspan="2"><input type="button" value="Login" onclick="checklogin()" ></td>
	    </tr>
	    <tr>
	      <td colspan="2">아직 회원이 아니신가요?&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="joinview.do">회원가입</a></td>
	    </tr>
	  </table>
</form>


</body>
</html>
