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
	<h1>신발 리스트</h1>
	<table border="1">
		<tr>
			<th>이미지</th>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품가격</th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td><img src="${dto.pimage } alt=${dto.pimagename}"></td>
				<td>${dto.pcode }</td>
				<td><a href="buy.do?pname=${dto.pname }">${dto.pname }</a></td>
				<td>${dto.pprice }</td>
			</tr>
		</c:forEach>
	</table>
	
	
	