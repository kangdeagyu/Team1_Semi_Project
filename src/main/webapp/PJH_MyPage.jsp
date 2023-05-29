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
	<table>
			<td>
			<form action="usermain.do" method="post">
				<input type="submit" name="action" value="Home">
			</form>
			</td>
			<td>${content_view.cname} 고객님</td>
			<td>
			<form action="loginview.do" method="post">
			<input type="submit" name="action" value="LogOut">
			</form>
			</td>
			<td>
			<form action="basket.do" method="post">
				<input type="submit" name="action" value="장바구니">
			</form>
			</td>
	</table>
	<form action="UserModify.do" method="post"> 
		<input type="hidden" name="cid" value=${cid }>
		<table>
			<tr>
				<td>ID</td>
				<td>${cid}</td>
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
		</table>
		<br/>
		<table>
			<tr>
				<td>
					<form action="userorderlist.do" method="post">
						<input type="submit" value="주문목록">
					</form>
				</td>
				<td>
					<input type="submit" value="수정">
				</td>
				<td>
					<form action="deleteaccount.do" method="post">
						<input type="submit" value="탈퇴">
					</form>
				</td>
			</tr>
		</table>
	</form>
	</body>
</html>