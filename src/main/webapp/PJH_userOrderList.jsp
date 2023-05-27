<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>구매목록</title>
	</head>
	<body>
	<h3>구매 목록</h3>
	<input type="hidden" name="cid" value="IU1993">
	<form action="Select.do"method="post">
	<table>
	<td>고객님 ${cid}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="action" value="Home">&nbsp;&nbsp;&nbsp;
	<input type="submit" name="action" value="LogOut">
	<input type="submit" name="action" value="MyPage"></td>
	</table>
	</form>
	<hr>
	    <table border=1>
	        <tr>
	            <th>사진</th>
	            <th>주문번호</th>
	            <th>제품명</th>
	            <th>가격</th>
	            <th>수량</th>
	            <th>주문날짜</th>
	        </tr>
	        <c:forEach items="${list}" var="dto">
	            <tr>
	                <!--<td> <img src="${dto.pimagename}" alt="Product Image" /></td>-->
	                <td>${dto.onum }</td>
	                <td>${dto.pname }</td>
	                <td>${dto.pprice }</td>
	                <td>${dto.oqty }</td>
	                <td>${dto.odate}</td>
	            </tr>
	        </c:forEach>
	    </table>
	</form>
	</table>
	<br/>
			
	<hr>
	<br/>
	총 구매액 : ${total}원
	
	
	</body>
</html>