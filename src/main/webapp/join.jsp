<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="join.do" method="post">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="cid"></td>
			</tr>
			<tr>
				<td>PASSWORD :</td>
				<td><input type="text" name="cpw"></td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td><input type="text" name="cname"></td>
			</tr>
			<tr>
				<td>전화번호 :</td>
				<td><input type="text" name="ctelno"></td>
			</tr>
			<tr>
				<td>주소 :</td>
				<td><input type="text" name="caddress"></td>
			</tr>
			<tr>
				<td>이메일 :</td>
				<td><input type="text" name="cemail"></td>
			</tr>
			<tr>
				<td><input type="submit" value="등록"> </td>
			</tr>
		</table>
	</form>
</body>
</html>