<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>장바구니</title>
	</head>
	<body>
	<h3>장바구니</h3>
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
	<hr>
	<form action="deleteOrPurchase.do" method="post">
	    <table border=1>
	        <tr>
	            <th>사진</th>
	            <th>제품번호</th>
	            <th>제품명</th>
	            <th>가격</th>
	            <th>수량</th>
	            <th>상품선택</th>
	        </tr>
	        <c:forEach items="${list}" var="dto">
	            <tr>
	                <td> <img src="${dto.pimagename}" alt="Product Image" /></td>
	                <td>${dto.pcode }</td>
	                <td>${dto.pname }</td>
	                <td>${dto.pprice }</td>
	                <td>${dto.bqty }</td>
	                <td>
	                    <input type="checkbox" name="selectedItems" value="${dto.bcode}">
	                    <input type="hidden" name="pcode${dto.bcode}" value="${dto.pcode}">
            			<input type="hidden" name="bqty${dto.bcode}" value="${dto.bqty}">
	                </td>
	            </tr>
	        </c:forEach>
	    </table>
	    <input type="submit" name="action" value="삭제">
	    <input type="submit" name="action" value="구매">
	</form>
	</table>
	<br/>
			
	<hr>
	<br/>
	총 구매액 : ${total}원
	
	
	</body>
</html>