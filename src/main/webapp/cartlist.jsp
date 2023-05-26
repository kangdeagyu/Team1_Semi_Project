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
	<input type="hidden" name="cid" value="IU1993">
	고객님 ${cid}
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