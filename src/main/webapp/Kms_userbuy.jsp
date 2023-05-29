<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${sid } 고객님 환영합니다. <br/>
<h3>${contentView.pname}</h3>
<input type="hidden" name="cid" value=${cid }>
	<table>
		<td>${cid} 고객님</td>
			<td>
			<form action="usermain.do" method="post">
				<input type="submit" name="action" value="Home">
			</form>
			</td>
			<td>
			<form action="loginview.do" method="post">
			<input type="submit" name="action" value="LogOut">
			</form>
			</td>
			<td>
			<form action="mypage.do" method="post">
				<input type="submit" name="action" value="MyPage">
			</form>
			</td>
			<td>
			<form action="cartlist.do" method="post">
				<input type="submit" name="action" value="장바구니">
			</form>
			</td>
	</table>
<form action="basket.do" method="post">
		<input type="hidden" name="pcode" value="${contentView.pcode }">
		<input type="hidden" name="cid" value="${cid }">
		<table>
			<tr>
				<td>상품이름 :</td>
				<td>${contentView.pname }</td>
			</tr>
			<tr>
				<td>상품번호</td>
				<td>${contentView.pcode }</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${contentView.pprice }</td>
			</tr>
			<tr>
				<td><img src="${contentView.pimage } alt=${contentView.pname}"></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="text" name="bqty"> </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="장바구니 담기">&nbsp;&nbsp;&nbsp;<a href="usermain.do">목록보기</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>