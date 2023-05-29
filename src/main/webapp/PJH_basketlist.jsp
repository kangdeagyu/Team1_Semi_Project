<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>장바구니</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .button-group {
            display: flex;
            justify-content: flex-end;
            align-items: center;
            margin-bottom: 10px;
        }
        .button-group .btn {
            margin-left: 5px;
        }
        .table-container {
            position: relative;
        }
        .action-buttons {
            position: absolute;
            bottom: 0;
            right: 0;
            margin: 10px;
        }
        .action-buttons .btn {
            margin-right: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <h3>장바구니</h3>
    <div class="button-group">
        <p>${cid} 고객님</p>
        <div class="ms-auto">
            <form action="usermain.do" method="post">
                <input type="submit" name="action" value="Home" class="btn btn-primary btn-sm">
            </form>
            <form action="loginview.do" method="post">
                <input type="submit" name="action" value="LogOut" class="btn btn-primary btn-sm">
            </form>
            <form action="mypage.do" method="post">
                <input type="submit" name="action" value="MyPage" class="btn btn-primary btn-sm">
            </form>
        </div>
    </div>
    <hr>
    <form action="deleteOrPurchase.do" method="post">
        <div class="table-container">
            <input type="hidden" name="cid" value="${cid}">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>사진</th>
                    <th>제품번호</th>
                    <th>제품명</th>
                    <th>가격</th>
                    <th>수량</th>
                    <th>상품선택</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="dto">
                    <tr>
                        <td> <img src="${dto.pimage}" alt="Product Image" height="100" width="100"></td>
                        <td>${dto.pcode}</td>
                        <td>${dto.pname}</td>
                        <td>${dto.pprice}</td>
                        <td>${dto.bqty}</td>
                        <td>
                            <input type="checkbox" name="selectedItems" value="${dto.bcode}">
                            <input type="hidden" name="pcode${dto.bcode}" value="${dto.pcode}">
                            <input type="hidden" name="bqty${dto.bcode}" value="${dto.bqty}">
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
            <div class="action-buttons">
                <input type="submit" name="action" value="삭제" class="btn btn-danger btn-sm">
                <input type="submit" name="action" value="구매" class="btn btn-success btn-sm">
            </div>
    </form>
    <hr>
    <p>총 구매액: ${total}원</p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>