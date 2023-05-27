<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>My Page</title>
	</head>
	<body>
		<h2>MyPage</h2>
	<form action="Select.do" method="post">
		<table>
			<td>고객님
				${content_view.cname}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" name="action" value="Home">&nbsp;&nbsp;&nbsp;
				<input type="submit" name="action" value="LogOut"> <input
				type="submit" name="action" value="MyPage">
			</td>
		</table>
	</form>
	<form action="UserModify.do" method="post"> 
		<input type="hidden" name="cid" value="HJM1984">
		<table>
			<tr>
				<td>ID</td>
				<td>${content_view.cid}</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="cpw" value="${content_view.cpw}" size="50"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="cname" value="${content_view.cname}" size="50"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="ctelno" value="${content_view.ctelno}" size="50"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="caddress" value="${content_view.caddress}" size="50"></td>
			</tr>
			<tr>
				<td>전자우편</td>
				<td><input type="text" name="cemail" value="${content_view.cemail}" size="50"></td>
			</tr>
			<tr>
			<td colspan="2"><input type="submit" value="수정"></td>
			</tr>
		</table>
	</form>
	</body>
</html>