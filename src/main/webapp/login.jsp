<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
<div class="center">
<h1>로그인</h1>
<form action="login.do" method="post">
  <table>
    <tr>
      <th>ID :</th>
      <td><input type="text" name="id"></td>
    </tr>
    <tr>
      <th>PASSWORD :</th>
      <td><input type="text" name="password"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Login" ></td>
    </tr>
    <tr>
      <td colspan="2">아직 회원이 아니신가요?&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="join.do">회원가입</a></td>
    </tr>
  </table>
</form>
</div>

</body>
</html>
