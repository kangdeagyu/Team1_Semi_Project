<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신발 리스트</title>
</head>
<body>
	${sid } 고객님 환영합니다.<br/>
	<h1>신발 리스트</h1>
	<input type="hidden" name="cid" value=${cid }>
	<table>
		<td>${cid} 고객님</td>
			<form action="loginview.do" method="post">
			<input type="submit" name="action" value="LogOut">
			</form>
			</td>
			<td>
			<form action="cartlist.do" method="post">
				<input type="submit" name="action" value="MyPage">
			</form>
			</td>
			<td>
			<form action="basket.do" method="post">
				<input type="submit" name="action" value="장바구니">
			</form>
			</td>
			<td>
			<form action="Q_Write.do" method="post">
				<input type="submit" name="action" value="질문 작성하기">
			</form>
			</td>
	</table>
	<form action="search.do" method="post">
		검색 선택 : <select name="list">
				<option value="pname" selected="selected">상품명</option>
				<option value="pcode">상품번호</option>
		</select>
		<input type="text" name="content" size="20">
		<input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<th>이미지</th>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th></th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td><img src="${dto.pimage } alt=${dto.pimagename}"></td>
				<td>${dto.pcode }</td>
				<td><a href="buy.do?pname=${dto.pname }">${dto.pname }</a></td>
				<td>${dto.pprice }</td>
				<td><a href="reviewlist.do?pcode=${dto.pcode }">리뷰목록</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
	