<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>구매목록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        h3 {
            margin-top: 20px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        img {
            height: 100px;
            width: 100px;
        }

        .button-group {
            margin-top: 20px;
        }

        .button-group form {
            display: inline-block;
            margin-right: 10px;
        }

        .total {
            font-weight: bold;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<h3>구매 목록</h3>
<div class="button-group">
    <p>${dto.cname} 고객님</p>
    <form action="usermain.do" method="post">
        <input type="submit" name="action" value="Home">
    </form>
    <form action="loginview.do" method="post">
        <input type="submit" name="action" value="LogOut">
    </form>
    <form action="mypage.do" method="post">
        <input type="submit" name="action" value="MyPage">
    </form>
    <form action="cartlist.do" method="post">
        <input type="submit" name="action" value="장바구니">
    </form>
</div>
<hr>
<table>
    <tr>
        <th>사진</th>
        <th>주문번호</th>
        <th>제품명</th>
        <th>가격</th>
        <th>수량</th>
        <th>주문날짜</th>
        <th>주소</th>
        <th>리뷰 작성하기</th>
    </tr>
    <c:forEach items="${olist}" var="dto">
        <tr>
            <td> <img src="${dto.pimagename}" alt="Product Image"></td>
            <td>${dto.onum}</td>
            <td>${dto.pname}</td>
            <td>${dto.pprice}</td>
            <td>${dto.oqty}</td>
            <td>${dto.odate}</td>
            <td>${dto.caddress}</td>
            <td><a href="review_write.do?pcode=${dto.pcode}">리뷰작성하기</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<hr>
<br/>
<p class="total">총 구매액: ${total}원</p>
</body>
</html>