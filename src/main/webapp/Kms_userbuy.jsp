<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${contentView.pname}</h3>
<form action="basket.do" method="post">
		<input type="hidden" name="pcode" value="${contentView.pcode }">
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